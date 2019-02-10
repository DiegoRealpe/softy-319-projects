
function submitForm() {
    validateText('fname-');
    validateText('lname-');
}

function validateText(name) {
    if(document.getElementById(name + 'f').value){
        document.getElementById(name + 'i').style.display="block";
    }
    else{
        document.getElementById(name + 'i').style.display="none";
    }
}