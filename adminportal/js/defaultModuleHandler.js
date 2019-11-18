const fs = require('fs');
var slideshowJson = require('./slideshowJson');
var departmentJson = require('./departmentJson');
var pollJson = require('./pollJson');

module.exports = {
        //Function to set defualt module and update other modules accordingly
        setDefault: function setDefaultModule(defaultModule) {
            var object;
            var data;

            switch (defaultModule) {
                case "slideshow":
                    object = departmentJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/department.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    object = pollJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/poll.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    break;
                case "department":
                    object = slideshowJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/slideshow.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    object = pollJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/poll.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    break;
                case "poll":
                    object = slideshowJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/slideshow.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    object = departmentJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/department.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    break;
                default:
                    //Set slideshow to true and all others to false 
                    object = slideshowJson.getJson();
                    object.default = true;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/slideshow.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    object = departmentJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/department.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });

                    object = pollJson.getJson();
                    object.default = false;
                    data = JSON.stringify(object, null, 2);
                    fs.writeFileSync("public/json/poll.json", data, (err) => {
                        if (err) {
                            console.error(err);
                        }
                    });
                    break;
            }
        }
    }