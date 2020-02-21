const fs = require('fs');

module.exports = {

    removeImage: function removeImageJson(path) {
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

                //Update the seqnum if there is one or more after the removed
                for (var j = i; j < object.images.length; j++) {
                    if (object.images[j])
                        object.images[j].seqnum = object.images[j].seqnum - 1;
                }
                break;
            }
        }

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/department.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    addImage: function addDeptImageJson(files) {
        var object = this.getJson();
        files.forEach(file => {

            var path = file.path.replace(/\\/g, '/');
            path = path.replace('public/', '');

            //Put in Department folder
            if(isDeptImage(path.replace('Uploads/', ''))){
                fs.renameSync(file.path, 'public/Uploads/Department/' + path.replace('Uploads/', ''), function (err) {
                    if (err)
                        throw err
                })
                path = 'Uploads/Department/' + path.replace('Uploads/', '')
            }

            object['images'].push({
                seqnum: object['images'].length,
                location: path,
                lastModified: Date.now(),
                thumbnail: ""
            });
        });

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/department.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Add New Room to Json
    addRoom: function addRoom(roomType, title, faculty, startTime, endTime) {
        var object = this.getJson();

        if(title != ""){
            //Find the schedule type in our list
            for (var i = 0; i < object['roomTypes'].length; i++) {
                if (object.roomTypes[i].name == roomType){
                    object.roomTypes[i]['rooms'].push({
                        title: title,
                        faculty: faculty,
                        startTime: startTime,
                        endTime: endTime
                    });

                    let data = JSON.stringify(object, null, 2);

                    fs.writeFileSync("public/json/department.json", data, (err) => {
                        if (err) {
                            console.error(err);
                            return;
                        };
                    });

                    break;
                }
            }
        }

    },

    //Add New Room Type to Json
    addRoomType: function addRoomType(name) {
        var object = this.getJson();

        //If the name already exists then dont add the type
        for (var i = 0; i < object['roomTypes'].length; i++) {
            if (object.roomTypes[i].name == name)
                return;
        }

        object['roomTypes'].push({
            name: name,
            rooms: []
        });

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/department.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Delete a Room Type from Json
    deleteRoomType: function deleteRoom(roomType) {
        var object = this.getJson();

        //Find the schedule type in our list and splice it
        for (var i = 0; i < object['roomTypes'].length; i++) {
            if (object.roomTypes[i].name == roomType){

                object.roomTypes.splice(i, 1);

                let data = JSON.stringify(object, null, 2);

                fs.writeFileSync("public/json/department.json", data, (err) => {
                    if (err) {
                        console.error(err);
                        return;
                    };
                });
                break;
            }
        }
    },

    //Delete a Schedule from Json
    deleteRoom: function deleteRoom(roomType, title) {
        var object = this.getJson();

        //Find the schedule type in our list
        for (var i = 0; i < object['roomTypes'].length; i++) {
            if (object.roomTypes[i].name == roomType){
                var type = object.roomTypes[i];

                for(var j =0; j < type.rooms.length; j++){
                    if(type.rooms[j].title = title){
                        type.rooms.splice(j, 1);
                        break;
                    }
                }

                let data = JSON.stringify(object, null, 2);

                fs.writeFileSync("public/json/department.json", data, (err) => {
                    if (err) {
                        console.error(err);
                        return;
                    };
                });
                break;
            }
        }
    },

    //Parse and return Department module's settings json
    getJson: function getDepartmentJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('public/json/department.json');
        } catch (error) {
            //Department default module settings
            let department = {
                moduleEnabled: true,
                default: false,
                heading: '*insert heading*',
                description: '*insert description*',

            };

            rawdata = JSON.stringify(department, null, 2);

            fs.writeFileSync("public/json/department.json", rawdata, (err) => {
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

function isDeptImage(filename) {
    // If file is prefixed with deptImage
    if (filename.indexOf('deptImage') > -1) {
        return true;
    }
    return false;
}
