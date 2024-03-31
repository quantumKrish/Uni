
let array = new Array(2, 2, 2, 4, 2, 2, 2);
let average = 0;

function findStats(array) {


    for (let i = 0; i < array.length; i++) {

        let num = array[i];
        average += num;
    }

    window.alert("The average of the numbers is: " + Math.floor(average / array.length));

    let middle = Math.floor(array.length / 2);

    window.alert("The median is: " + array[middle]);
}

findStats(array);