function updateJson() {
    var d = new Date();
    var n = d.getTime();
    var text = "{text: it is" + n +"}";
    alert("Changing Text to " + n);
    var jsonString = JSON.stringify(text);

    //Write jsonString to file will require something like node.js
    //But is very common and may already be installed in labs
    //Here's vaguely what you'd use

    /*
    var fs = require("fs");
    fs.writeFile("./public/settings.json", jsonString, (err) => {
        if (err) {
            console.error(err);
            return;
        };
        console.log("File has been created");
    });
    */
}