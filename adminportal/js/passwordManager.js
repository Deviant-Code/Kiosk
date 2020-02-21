const fs = require('fs');

module.exports = {
    updatePassword: function UpdatePass(newPass){
        object = this.getJson();

        object.password = newPass;
        let data = JSON.stringify(object, null, 2);

        fs.writeFileSync("pass.json", data, (err) => {
            if (err) {
                console.error(err);
                return;
            };
        });
    },

    //Parse and return Json
    getJson: function getPasswordJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('pass.json');
        } catch (error) {
            //Password default settings
            let settings = {
                username: 'admin',
                password: 'password'
            };

            rawdata = JSON.stringify(settings, null, 2);

            fs.writeFileSync("pass.json", rawdata, (err) => {
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