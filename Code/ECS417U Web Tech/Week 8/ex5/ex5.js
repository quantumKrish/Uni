

const form = document.getElementById('form');
const submitButton = document.getElementById('save-btn');



submitButton.addEventListener('click', (event) => {

  let fnameValue = document.getElementById("firstname").value;
  localStorage.setItem('firstname', fnameValue);

  let snameValue = document.getElementById("surname").value;
  localStorage.setItem('surname', snameValue); 

  window.location.href = 'ex5result.html';

});

  let form1 = document.getElementById('form1');

  let storedValue1 = localStorage.getItem('firstname');
  let storedValue2 = localStorage.getItem('surname');

  let fullname = document.createElement('h1');
  fullname.textContent = storedValue1 + ' ' + storedValue2;

  console.log(fullname);

  form1.appendChild(fullname);