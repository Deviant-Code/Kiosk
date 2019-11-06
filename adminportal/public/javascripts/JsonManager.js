'use strict';

const fs = require('fs');

//Call when wanting to delete a file and pass the file's path
function deleteFile(path){
    fs.unlink(path, (err) => {
        if (err)
            console.log(err);
      });
}

//Update Slideshow module's settings json
function updateSlideshowJson(speed, transition, autoPlay, defaultModule) {

    //Slideshow module settings
    let slideshow = {
        transitionSpeed: speed,
        willTransition: transition,
        autoPlayVideo: autoPlay,
        default: defaultModule
    };

    let data = JSON.stringify(slideshow, null, 2);

    fs.writeFile("../json/Slideshow.json", data, (err) => {
        if (err) {
            console.error(err);
            return;
        };
    });
}

//Parse and return Slideshow module's settings json
function getSlideshowJson(){
    //get relative path
    let rawdata = fs.readFileSync('../json/Slideshow.json');
    //parse using json
    var object = JSON.parse(rawdata);
    var objectString = JSON.stringify(object);

    return objectString;
}
