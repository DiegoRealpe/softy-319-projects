
const inquirer = require('inquirer');
var questions = [{
    name: 'first',
    type: 'input',
    message: '1st Number?',
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
    message: '2nd Number?',
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
    message: '3rd Number?',
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
    message: '4th Number?',
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
    console.log("works");
})
