/*README
 start the server from the command line in the js folder. 
 start using node server.js. it will display a server in the command line, go there.
 you will need to change the directory to the location of the index.html in your folder.

*/

/*
NOTES ON POTENTIAL ISSUES:
need to have all files in sources here? otherwise they cannot be found.
send stuff to html from here only?

*/



//CODE FOR GETTING JSON BELOW!
//load fs module to app
/*const fs = require('fs');
//get relative path
let rawdata = fs.readFileSync('../public/settings.json');
//parse using json
var object = JSON.parse(rawdata);
console.log(object);
var objectString = JSON.stringify(object);
*/





//CODE FOR SERVER BELOW!

var http = require('http');
var fs = require('fs');
var express = require('express');
var path = require('path');






var http = require('http');
var server = http.createServer(function (req, res) {
    //FOR LOADING HTML PAGE
    res.writeHead(200, {'Content-Type': 'text/html'});//html so its not treated as text
    //HARD CODED IN DIRECTORY. CHANGE TO YOUR DIRECTORY FOR IT TO WORK.
    var myReadStream = fs.createReadStream('/home/ricenad/Desktop/492/kiosk/adminPortalSrc/index.html', 'utf8');
    //pipe to html
    myReadStream.pipe(res);
    //res.end('Hello World\n');
    //res.end(objectString);



    //FOR LOADING JSON OBJECT
    //get relative path
    /*
    let rawdata = fs.readFileSync('../public/settings.json');
    //parse using json
    var object = JSON.parse(rawdata);
    console.log(object);
    var objectString = JSON.stringify(object);
    //myReadStream.pipe(objectString);
    res.writeHead(200, {'Content-Type': 'text/JSON'});//jsno for objects
    res.end(objectString);
    */


});
//listen on port and ip
server.listen(3000, "127.0.0.1");

console.log('Server running at http://127.0.0.1:3000/');
//alert("server started");






