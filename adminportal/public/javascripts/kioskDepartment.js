/* Functions used on the department kiosk module page */

//Grabs Json from server and parses then populates page with data
function loadDepartmentContent() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content on the page
      document.getElementById("departmentManagerKiosk").innerHTML = "";

      //For each floor
      for (var i = 0; i < res.images.length; i++) {
        
        //Add a floor div
        var floorDiv = document.createElement("div");
        floorDiv.className = "floor-display"
        document.getElementById("departmentManagerKiosk").appendChild(floorDiv);

        //Add a floor heading
        var floorHeading = document.createElement("h1");
        floorHeading.innerHTML = "Floor " + (i + 1);
        floorHeading.setAttribute("style", "font-size: 4vw;margin: 0 0;") 
        floorDiv.appendChild(floorHeading);

        //Add image for floor
        var floorImg = document.createElement("IMG");
        floorImg.setAttribute("src", "../" + res.images[i].location);
        floorImg.setAttribute("width", "65%");
        floorImg.setAttribute("alt", "Floor " + i + " Plan");
        floorDiv.appendChild(floorImg);

        //add all rooms for floor
        for (var j = 0; j < res.rooms.length; j++) {
          var roomDiv = document.createElement("div");
          roomDiv.className = "room-display"
          floorDiv.appendChild(roomDiv);

          var roomName = document.createElement("h2");
          roomName.innerHTML = res.rooms[i].name; 
          roomDiv.appendChild(roomName);
        }
      }
    }
  };
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}

// Used by the serach div to reload the department manager display with specfied parameters as defined
function search(){
  term = document.getElementById("searchTerm").value;

  loadDepartmentContentAux(term);
}

// Is called by search to reload content on the kiosk
function loadDepartmentContentAux(term) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      //Clear all content in the div
      document.getElementById("departmentManagerKiosk").innerHTML = "";

      for (var i = 0; i < res.rooms.length; i++) {
        if(term == "" || term == res.rooms[i].name){
          //Populate department manager
          
        }else{
          continue;
        }
      }
    }
  };
  xhttp.open("GET", "/getDepartmentParams", true);
  xhttp.send();
}