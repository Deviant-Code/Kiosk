const fs = require('fs');

module.exports = {
    //Add New Schedule to Json
    addSchedule: function addSchedule(scheduleType, title, description, startTime, endTime) {
        var object = this.getJson();

        //Find the schedule type in our list
        for (var i = 0; i < object['scheduleTypes'].length; i++) {
            if (object.scheduleTypes[i].name == scheduleType){
                object.scheduleTypes[i]['schedules'].push({
                    title: title,
                    description: description,
                    startTime: startTime,
                    endTime: endTime
                });

                let data = JSON.stringify(object, null, 2);

                fs.writeFileSync("public/json/schedules.json", data, (err) => {
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
    deleteSchedule: function deleteSchedule(scheduleType, title) {
        var object = this.getJson();

        //Find the schedule type in our list
        for (var i = 0; i < object['scheduleTypes'].length; i++) {
            if (object.scheduleTypes[i].name == scheduleType){
                var type = object.scheduleTypes[i];

                for(var j =0; j < type.schedules.length; j++){
                    if(type.schedules[j].title = title){
                        type.schedules.splice(j, 1);
                        break;
                    }
                }

                let data = JSON.stringify(object, null, 2);

                fs.writeFileSync("public/json/schedules.json", data, (err) => {
                    if (err) {
                        console.error(err);
                        return;
                    };
                });
                break;
            }     
        }
    },

    //Add New Schedule Type to Json
    addScheduleType: function addScheduleType(name) {
        var object = this.getJson();

        //If the name already exists then dont add the type
        for (var i = 0; i < object['scheduleTypes'].length; i++) {
            if (object.scheduleTypes[i].name == name)
                return;
        }

        object['scheduleTypes'].push({
            name: name,
            schedules: []
        });

        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("public/json/schedules.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Parse and return Department module's settings json
    getJson: function getSchedulesJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('public/json/schedules.json');
        } catch (error) {
            //Schedule default module settings
            let department = {
                moduleEnabled: true,
                default: false,
                scheduleTypes: []
            };

            rawdata = JSON.stringify(department, null, 2);

            fs.writeFileSync("public/json/schedules.json", rawdata, (err) => {
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