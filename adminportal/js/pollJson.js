const fs = require('fs');

module.exports = {
    //Parse and return Poll module's settings json
    getJson: function getPollJson() {
        //get relative path
        let rawdata;
        try {
            rawdata = fs.readFileSync('public/json/poll.json');
        } catch (error) {
            //Poll default module settings
            let department = {
                moduleEnabled: true,
                default: false,
                pollQuestion: '*insert poll question*',
                pollResp1: '*insert poll response 1*',
                pollResp2: '*insert poll response 2*',
                pollResp1Val: 0,
                pollResp2Val: 0
            };

            rawdata = JSON.stringify(department, null, 2);

            fs.writeFileSync("public/json/poll.json", rawdata, (err) => {
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