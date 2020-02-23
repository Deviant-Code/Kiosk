const fs = require('fs');

module.exports = {
    //Find the target and moving path within our json array and swap them
    //Update the seqnum values for all floors
    reorderFloors: function reorderFloorsJson(movingPath, targetPath) {
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

        fs.writeFileSync("public/json/department.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    removeImage: function removeImageJson(path) {
        var object = this.getJson();

        path = path.replace('public/', '');

        for (var i = 0; i < object.images.length; i++) {
            if (object.images[i].location == path) {
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
    addRoom: function addRoom(floorName, roomName, faculty, attribute, startHour, endHour) {
        var object = this.getJson();

        if(floorName != ""){
            //Find the floor in our list
            for (var i = 0; i < object['floors'].length; i++) {
                if (object.floors[i].name == floorName){
                    object.floors[i]['rooms'].push({
                        name: roomName,
                        faculty: faculty,
                        attribute: attribute,
                        startHour: startHour,
                        endHour: endHour

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
    addFloor: function addFloor(floorName) {
        var object = this.getJson();

        //If the name already exists then dont add the type
        for (var i = 0; i < object['floors'].length; i++) {
            if (object.floors[i].name == floorName)
                return;
        }

        object['floors'].push({
            name: floorName,
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

    //Delete a Floor from Json
    deleteFloor: function deleteFloor(floorName) {
        var object = this.getJson();

        //Find the schedule type in our list and splice it
        for (var i = 0; i < object['floors'].length; i++) {
            if (object.floors[i].name == floorName){

                object.floors.splice(i, 1);

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

    //Delete a Room from Json
    deleteRoom: function deleteRoom(floorName, roomName) {
        var object = this.getJson();

        //Find the floor the room is on, in our list
        for (var i = 0; i < object['floors'].length; i++) {
            if (object.floors[i].name == floorName){
                var floor = object.floors[i];

                for(var j =0; j < floor.rooms.length; j++){
                    if(floor.rooms[j].name = roomName){
                        floor.rooms.splice(j, 1);
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
                images: [],
                floors: []
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
