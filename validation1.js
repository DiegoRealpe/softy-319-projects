/**
 * Simple Javascript file containing some basic functions to
 * control the HTML validation form with some images.
 */

var imgYes = "correct.png";
var imgNo = "wrong.png";
var formIdArr = ['fname-', 'lname-', 'gender-', 'state-'];

function checkBasic() {
    let redirect = true;
    formIdArr.forEach(id => {
        if(!isFilled(id)){
            redirect = false;
        }
    });
    if(redirect){
        alert("JUMPEEEEER");
    }
}

function isFilled(name) {
    document.getElementById(name + 'i').style.display="block";
    if(document.getElementById(name + 'f').value){
        document.getElementById(name + 'i').src=imgYes;
        return true;
    }
    document.getElementById(name + 'i').src=imgNo;
    return false;
    
}