// Create form element
const form = document.createElement("form");
document.body.appendChild(form);

// Create first input field
const input1 = document.createElement("input");
input1.setAttribute("type", "text");
input1.setAttribute("id", "input1");
form.appendChild(input1);

// Create second input field
const input2 = document.createElement("input");
input2.setAttribute("type", "text");
input2.setAttribute("id", "input2");
form.appendChild(input2);

// Create button
const button = document.createElement("button");
button.textContent = "Check";
button.setAttribute("onclick", "validate()");
form.appendChild(button);


function validate() {
    
    // Get input values
    const input1 = document.getElementById("input1").value;
    const input2 = document.getElementById("input2").value;

    // Check if input values are null or not equal
    if (isEmpty(input1) || isEmpty(input2)) {
        window.alert("Input is empty");

    } else if ( input1 != input2) {
        window.alert("Input not equal");

    } else {

        window.alert("Inputs are equal");
    }
}

// Function to check if a string is empty
function isEmpty(str) {
    return !str.trim();
}