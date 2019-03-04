
var coorX = 0; //Initial coordinates
var coorY = 250;
const North = { 'X': 0, 'Y': 10 }; //direction structs
const East = { 'X': 10, 'Y': 0 };
const South = { 'X': 0, 'Y': -10 };
const West = { 'X': -10, 'Y': 0 };
var direction = East;
var brush = document.getElementById("snakecanvas").getContext("2d");// Canvas object
brush.lineWidth = "5"; //line size and color
brush.strokeStyle = "green";

var Timer = setInterval()

var leftTurn = document.getElementById("left"); //buttons
var rightTurn = document.getElementById("right");
var move = document.getElementById("move");

/**function move() {
    brush.beginPath();
    brush.moveTo(coorX, coorY);
    coorX += direction.X;
    coorY += direction.Y;
    brush.lineTo(coorX, coorY);
    brush.stroke();
}*/



function play() {
    if (Timer == NULL) {
        Timer = setInterval(() => {
            brush.beginPath();
            brush.moveTo(coorX, coorY);
            coorX += direction.X;
            coorY += direction.Y;
            brush.lineTo(coorX, coorY);
            brush.stroke();
        }, 1000);
    }
}


function turnRight() { //switching fucntions for both turn directions
    if (direction == North) {
        direction = West;
    }
    else if (direction == East) {
        direction = North;
    }
    else if (direction == South) {
        direction = East;
    }
    else if (direction == West) {
        direction = South;
    }
}

function turnLeft() {
    if (direction == North) {
        direction = East;
    }
    else if (direction == East) {
        direction = South;
    }
    else if (direction == South) {
        direction = West;
    }
    else if (direction == West) {
        direction = North;
    }
}