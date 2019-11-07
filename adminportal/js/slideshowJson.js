const fs = require('fs');

module.exports = {
    //Parse and return Slideshow module's settings json
    removeSlide: function removeSlideImageJson(file){
        var object = getSlideshowJson();
        var array = object['images'];

        array.forEach(function(object, index) {
            if(object[location] === file.path) {
            //Remove from array
            array.splice(index, 1);
            }    
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
    addSlide: function addSlideImageJson(file){
        var object = this.getJson();
        object['images'].push({seqNum: object['images'].length, location: file.path, lastModified: Date.now()});

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/slideshow.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },   

    //Parse and return Slideshow module's speed settings json
    getSlideSpeed: function getSlideshowSpeed(){
        var object = this.getJson();
        var objectString = JSON.stringify(object.transitionSpeed);

        return objectString;
    },

    //Parse and return Slideshow module's settings json
    getJson: function getSlideshowJson(){
        //get relative path
        let rawdata;
        try{
            rawdata = fs.readFileSync('public/json/slideshow.json');    
        }catch{
            //Slideshow default module settings
            let slideshow = {
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