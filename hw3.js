
const inquirer = require('inquirer');
var questions = [{
    name: 'first',
    type: 'input',
    message: '1st Number',
    validate: function(value) {
        var pass = value.match(
          /[0-9]{1,}/i
        );
        if (pass) {
          return true;
        }
        return 'Please enter a valid number';
    }
},
{
    name: 'second',
    type: 'input',
    message: '2nd Number',
    validate: function(value) {
        var pass = value.match(
          /[0-9]{1,}/i
        );
        if (pass) {
          return true;
        }
        return 'Please enter a valid number';
    }
},
{
    name: 'third',
    type: 'input',
    message: '3rd Number',
    validate: function(value) {
        var pass = value.match(
          /[0-9]{1,}/i
        );
        if (pass) {
          return true;
        }
        return 'Please enter a valid number';
    }
},
{
    name: 'fourth',
    type: 'input',
    message: '4th Number',
    validate: function(value) {
        var pass = value.match(
          /[0-9]{1,}/i
        );
        if (pass) {
          return true;
        }
        return 'Please enter a valid number';
    }
}];

console.log("Please input 3 numbers");
inquirer.prompt(questions).then(answers => {

    //calculate the factorial of the first number
    let fact = 1;
    for(let i = answers.first; i > 0; --i){
        fact *= i;
    }
    console.log("Factorial of 1st number is = " + fact);

    //add digits
    let digits = 0;
    for(let i = 0; i < answers.second.length; ++i){
        digits += Number(answers.second[i]);
    }
    console.log("Sum of all secound number's digits = " + digits);

    //inversing number
    let inverse = "";
    for(let i = answers.third.length - 1; i >= 0 ; --i){
        inverse += answers.third[i];
    }
    console.log("The inverse of the 3rd number is = " + inverse);

    //palindrome check
    let palindrome = true;
    let start = 0;
    let end = answers.fourth.length - 1; 
    while(start <= (answers.fourth.length/2) &&  end >= (answers.fourth.length/2)){
        if(answers.fourth[start] != answers.fourth[end]){
            palindrome = false;
            break;
        }
        ++start;
        --end;
    }
    console.log("Is the fourth number a palindrome? (T/F) " + palindrome);
    if(palindrome){
        console.log("True");
    }
    else{
        console.log("False");
    }


})
