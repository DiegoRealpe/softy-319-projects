
var myBtn = document.getElementById("btn");
myBtn.onclick = function () {
    // getContext() method returns an object that provides methods
    // and properties for drawing on the canvas
    var context = document.getElementById("canvasId").getContext("2d");
    context.fillStyle = "#ffc821";

    //draw a rectangle at 20,20  with  width 150 and height 100
    context.rect(20, 20, 150, 100);

    //fill the rectangle
    context.fill();
}
     //look at other canvas methods!