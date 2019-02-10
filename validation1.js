/**
 * Simple Javascript file containing some basic functions to
 * control the HTML validation form with some images.
 */

var imgYes = "correct.png";
var imgNo = "wrong.png";

function submitForm() {
    checkFilled('fname-');
    checkFilled('lname-');
    checkSelected('gender-');
}

function checkFilled(name) {
    document.getElementById(name + 'i').style.display="block";
    if(document.getElementById(name + 'f').value){
        document.getElementById(name + 'i').src=imgYes;
    }
    else{
        document.getElementById(name + 'i').src=imgNo;
    }
}

function checkSelected(name){

}