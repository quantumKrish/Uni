let numbers = new Array(5);

for (let i = 0; i < 5; i++) {

    var num = window.prompt("Please enter a number");
    numbers[i] = num;

}

window.alert("The highest number is: " + Math.max(...numbers));