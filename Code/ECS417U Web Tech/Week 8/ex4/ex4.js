
let name = document.getElementById("name");
let email = document.getElementById("email");
let address = document.getElementById("address");
let postcode = document.getElementById("postcode");
let checkbox = document.getElementById("checkbox");
let quantity = document.getElementById("quantity");

// Function to check if a string is empty
function isEmpty(str) {
  return !str.trim();
}

function purple(id) {
  let element = document.getElementById(id);
  element.style.backgroundColor = "#f1cbff";
}

function reset(id) {
    let element = document.getElementById(id);
    element.style.backgroundColor = "white";
}

const form = document.getElementById('form');

function validateForm() {

    let hasEmptyFields = false;

    if (isEmpty(name.value)) {

    purple("name");
    hasEmptyFields = true;
    } else {
        reset("name");
    }

    if (isEmpty(email.value)) {
    purple("email");
    hasEmptyFields = true;
    } else {
        reset("email");
    }

    if (isEmpty(address.value)) {
    purple("address");
    hasEmptyFields = true;
    } else {
        reset("address");
    }

    if (isEmpty(postcode.value)) {
    purple("postcode");
    hasEmptyFields = true;
    } else {
        reset("postcode");
    }

    if (!checkbox.checked) {
    purple("checkboxdiv");
    hasEmptyFields = true;
    } else {
        reset("checkboxdiv");
    }

    return hasEmptyFields;

}

form.addEventListener('submit', (event) => {

    if (validateForm()) {

        event.preventDefault();
        console.log("has empty fields");
    }
});

