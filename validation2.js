/**
 * Simple Javascript file containing the second part
 * of the verification project
 */

var imgYes = "correct.png";
var imgNo = "wrong.png";
const phoneRegEx = /[0-9]{3}[-]?[0-9]{3}[-]?[0-9]{4}/;
const emailRegEx = /[a-zA-Z0-9]{3,}[@]{1}[a-zA-Z0-9]{3,}[\.]{1}[a-zA-Z0-9]{2,3}/
const addressRegEx = /[a-zA-Z]{2,}[,]{1}[A-Z]{2}/;

function submitAll(){
    console.log("function executing");
    let email = emailCheck();
    let phone  = phoneCheck();
    let addr = addressCheck();
    console.log(email);
    console.log(phone);
    console.log(addr);
}

function emailCheck(){
    let input = document.getElementById('email-f').value;
    if(emailRegEx.test(input)){
        document.getElementById('email-i').src=imgYes;
        return true;
    }
    document.getElementById('email-i').src=imgNo;
    return false;
}

function phoneCheck(){
    let input = document.getElementById('phone-f').value;
    if(phoneRegEx.test(input)){
        document.getElementById('phone-i').src=imgYes;
        return true;
    }
    document.getElementById('phone-i').src=imgNo;
    return false;
}

function addressCheck(){
    let input = document.getElementById('address-f').value;
    if(addressRegEx.test(input)){
        document.getElementById('address-i').src=imgYes;
        return true;  
    }
    document.getElementById('address-i').src=imgNo;
    return false;
}