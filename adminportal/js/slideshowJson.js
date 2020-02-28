const fs = require('fs');

module.exports = {
    //Find the target path and update its settings
    updateSlideSettings: function reorderSlidesJson(path, transitionTime, expiration) {
        var object = this.getJson();


        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {
                object.images[i].expiration = expiration;
                object.images[i].transitionTime = parseInt(transitionTime);
                console.log(path);
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

    //Find the target and moving path within our json array and swap them
    //Update the seqnum values for all slides
    reorderSlides: function reorderSlidesJson(movingPath, targetPath) {
        var object = this.getJson();

        movingPath = movingPath.replace('public/', '');
        targetPath = targetPath.replace('public/', '');

        var targetIndex;
        var movingIndex, movingElement;

        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == movingPath) {
                movingIndex = i;
                movingElement = object.images[i];
            }
            if (object.images[i].location == targetPath) {
                targetIndex = i;
            }
        }

        if (targetIndex != null && movingIndex != null && movingElement != null) {
            //Remove old copy from array
            object.images.splice(movingIndex, 1);
            //Insert copy into array
            object.images.splice(targetIndex, 0, movingElement);
        }

        //Update the seqnum of next slides if there is one or more after the removed
        for (var i = 0; i < object.images.length; i++) {
            object.images[i].seqnum = i;
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
    removeSlide: function removeImageJson(path) {
        var object = this.getJson();

        path = path.replace('public/', '');

        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {

                if (object.images[i].thumbnail != "") {
                    fs.unlink('public/' + object.images[i].thumbnail, (err) => {
                        if (err)
                            console.log(err);
                    });
                }
                //Remove from array
                object.images.splice(i, 1);

                //Update the seqnum of next slides if there is one or more after the removed
                for (var j = i; j < object.images.length; j++) {
                    if (object.images[j])
                        object.images[j].seqnum = object.images[j].seqnum - 1;
                }
                break;
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

            //If is a video file, put in videos folder
            if(isVideo(path.replace('Uploads/', ''))){
                fs.renameSync(file.path, 'public/Uploads/Videos/' + path.replace('Uploads/', ''), function (err) {
                    if (err)
                        throw err
                })
                path = 'Uploads/Videos/' + path.replace('Uploads/', '')
            }

            object['images'].push({
                seqnum: object['images'].length,
                location: path,
                lastModified: Date.now(),
                thumbnail: "",
                expiration: "",
                transitionTime: 10
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

                var filePath = "public/" + path.replace('Videos/', '').split('.')[0] + ".jpeg";
                fs.writeFile(filePath, base64Image, 'base64', function (err) {
                    if (err)
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
        } catch (error) {
            //Slideshow default module settings
            let slideshow = {
                moduleEnabled: true,
                transitionSpeed: 10,
                willTransition: true,
                autoPlayVideo: true,
                default: true,
                slides: []
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

function isVideo(filename) {
    var ext = (filename + '').split('.').pop();
    switch (ext.toLowerCase()) {
    case 'm4v':
    case 'avi':
    case 'mpg':
    case 'mp4':
    case 'mov':
        return true;
    }
    return false;
  }
