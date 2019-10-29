"use strict"

let summerButton = document.getElementById("summer");

summerButton.addEventListener("click", event => {
    const t1 = 2;
    const t2 = 2;
    let sum = t1 + t2;
    document.getElementById("sum").innerHTML = sum;
});
