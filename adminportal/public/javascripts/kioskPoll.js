var resp1,resp2;

function loadPollContentKiosk() {
  document.body.className -= ' fade-out';

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      var res = JSON.parse(this.responseText);

      document.getElementById("poll1").innerHTML = res.pollResp1;
      document.getElementById("poll2").innerHTML = res.pollResp2;
      document.getElementById("pollQuestion").innerHTML = res.pollQuestion;

      document.getElementById("CurrentResponse1").innerHTML =
        res.pollResp1 + "<br>" + res.pollResp1Val;

      document.getElementById("CurrentResponse2").innerHTML =
        res.pollResp2 + "<br>" + res.pollResp2Val;

        resp1 = res.pollResp1Val;
        resp2 = res.pollResp2Val;
    }
  };
  xhttp.open("GET", "/getPollParams", true);
  xhttp.send();
}

function transitionScreen() {
  //Move old elements
  document.getElementById("poll1").style.transitionDuration = "5s";
  document.getElementById("poll1").style.transform = "translate(-5000px, 0px)";
  document.getElementById("poll2").style.transitionDuration = "5s";
  document.getElementById("poll2").style.transform = "translate(5000px, 0px)";
  document.getElementById("pollQuestion").style.transitionDuration = "5s";
  document.getElementById("pollQuestion").style.transform = "translate(0px, -5000px)";

  setTimeout(function () {
    document.getElementById("poll1").remove();
    document.getElementById("poll2").remove();
    document.getElementById("pollQuestion").remove();

    //Move new elements
    document.getElementById("CurrentResponse").style.visibility = "visible";
    document.getElementById("responseText").style.transform = "scale(0)";
    document.getElementById("response1Bar").style.transformOrigin = "bottom";
    document.getElementById("response1Bar").style.transform = "scale(1,0)";
    document.getElementById("response2Bar").style.transformOrigin = "bottom";
    document.getElementById("response2Bar").style.transform = "scale(1,0)";

    


  }, 1500);

  setTimeout(function () {

    document.getElementById("responseText").style.transitionDuration = ".5s";
    document.getElementById("responseText").style.transform = "scale(1)";

    //Scale bars
    document.getElementById("response1Bar").style.transitionDuration = "1s";
    document.getElementById("response1Bar").style.transform = "scale(1," + (resp1 / (resp1 + resp2)) *1.4 + ")";

    document.getElementById("response2Bar").style.transitionDuration = "1s";
    document.getElementById("response2Bar").style.transform = "scale(1," + (resp2 / (resp1 + resp2)) *1.4  + ")";
  }, 1550);

  setTimeout(function() {
    document.body.className += ' fade-out';
  }, 9000);

  setTimeout(function() {
    location.reload();
  }, 10000);
}