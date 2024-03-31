function multiplication() {
    
    // Code inside this function will run when the DOM content is fully loaded
    const table = document.getElementById("multiplicationTable");

    tbody = document.createElement("tbody");
    table.appendChild(tbody);

   // Loop to generate header row for the multiplication table
   const thead = document.createElement("thead");
   const headRow = document.createElement("tr");

   for (let i = 0; i <= 15; i++) {

        if (i == 0) {

            const head = document.createElement("th");
            head.textContent = "×";
            headRow.appendChild(head);
        }


        if (i > 0) {

            const head = document.createElement("th");
            head.textContent = i;
            headRow.appendChild(head);
    
        }
   }

   thead.appendChild(headRow);
   table.appendChild(thead);

   // Loop to generate rows for the multiplication table
   for (let i = 1; i <= 15; i++) {
    
    const row = document.createElement("tr");


    const head = document.createElement("th");
    head.textContent = i;
    row.appendChild(head);



       for (let j = 1; j <= 15; j++) {

           const cell = document.createElement("td");
           cell.textContent = i * j;
           row.appendChild(cell);
       }

       tbody.appendChild(row);
   }
}

multiplication();
