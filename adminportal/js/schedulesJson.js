const fs = require('fs');

module.exports = {
    //Parse and return Department module's settings json
    getJson: function getSchedulesJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('public/json/schedules.json');
        } catch {
            //Schedule default module settings
            let department = {
                moduleEnabled: true,
                default: false
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