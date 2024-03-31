
let name = new Array("Mohammed", "Olivia", "Oliver", "Sophia", "Noah", "Ava", "Muhammad", "Isla", "George", "Mia");

name.sort();

window.alert(name);

for (let i = 0; i < 4; i++) {

    newName = window.prompt("Enter a new name: ");
    name.push(newName);
    name.sort();
    window.alert(name);
}

console.log(name);