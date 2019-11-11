const fs = require('fs');

module.exports = {
    //Parse and return Slideshow module's settings json
    removeSlide: function removeImageJson(path) {
        var object = this.getJson();
        console.log(path);

        path = path.replace('public/', '');

        console.log(path);
        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {
                //Remove from array
                object.images.splice(i, 1);
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
                seqNum: object['images'].length,
                location: path,
                lastModified: Date.now()
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