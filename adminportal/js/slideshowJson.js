const fs = require('fs');

module.exports = {
    //Parse and return Slideshow module's settings json
    removeSlide: function removeImageJson(path) {
        var object = this.getJson();

        path = path.replace('public/', '');

        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {

                if(object.images[i].thumbnail != ""){
                    fs.unlink('public/' + object.images[i].thumbnail, (err) => {
                        if (err)
                          console.log(err);
                      });
                }
                //Remove from array
                object.images.splice(i, 1);

                //Update the seqnum of next slide if there is one after
                if(object.images[i])
                    object.images[i].seqnum = object.images[i].seqnum - 1;
            }
        }

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/slideshow.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Parse and return Slideshow module's settings json
    addSlide: function addSlideImageJson(files) {
        var object = this.getJson();
        
        files.forEach(file => {           
            var path = file.path.replace(/\\/g, '/');
            path = path.replace('public/', '');

            object['images'].push({
                seqnum: object['images'].length,
                location: path,
                lastModified: Date.now(),
                thumbnail: ""
            });
        });

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/slideshow.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Parse and return Slideshow module's settings json
    addThumbnail: function addThumbnailJson(path, thubmnail64) {
        var object = this.getJson();

        path = path.replace('public/', '');

        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {   
                let base64Image = thubmnail64.replace(/^data:image\/jpeg+;base64,/, "");
                base64Image = base64Image.replace(/ /g, '+');

                var filePath = "public/Uploads/thumbnail" + Date.now() + ".jpeg";
                fs.writeFile(filePath, base64Image, 'base64', function(err) {
                    if(err)
                        console.log(err);
                });

                filePath = filePath.replace('public/', '');
                object.images[i].thumbnail = filePath;
            }
        }

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/slideshow.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Parse and return Slideshow module's speed settings json
    getSlideSpeed: function getSlideshowSpeed() {
        var object = this.getJson();
        var objectString = JSON.stringify(object.transitionSpeed);

        return objectString;
    },

    //Parse and return Slideshow module's settings json
    getJson: function getSlideshowJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('public/json/slideshow.json');
        } catch {
            //Slideshow default module settings
            let slideshow = {
                moduleEnabled: true,
                transitionSpeed: 3,
                willTransition: true,
                autoPlayVideo: true,
                default: true,
                images: []
            };

            rawdata = JSON.stringify(slideshow, null, 2);

            fs.writeFileSync("public/json/slideshow.json", rawdata, (err) => {
                if (err) {
                    console.error(err);
                    return;
                };
            });
        }
        //parse using json
        var object = JSON.parse(rawdata);

        return object;
    }
}

function decodeBase64Image(dataString) {
    var matches = dataString.match(/^data:([A-Za-z-+\/]+);base64,(.+)$/),
      response = {};
  
    if (matches.length !== 3) {
      return new Error('Invalid input string');
    }
  
    response.type = matches[1];
    response.data = new Buffer(matches[2], 'base64');
  
    return response;
  }