const fs = require('fs');

module.exports = {
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
                description: '*insert description*'
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