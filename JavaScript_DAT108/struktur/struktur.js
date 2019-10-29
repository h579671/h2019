"use strict"

const tall = [1, 2, 3, 4, 5];

let sumButton = document.getElementById("sum");
let produktButton = document.getElementById("produkt");
let resultat = document.getElementById("resultat");

sumButton.addEventListener("click", event => {
    resultat.innerHTML = sum(tall);
});

produktButton.addEventListener("click", event => {
    resultat.innerHTML = produkt(tall);
});

function sum(tallrekke) {
    let res = 0;
    for (let i = 0; i < tall.length; i++) {
        res += tall[i];
    }
    return res;
}

function produkt(tallrekke) {
    let res = 1;
    for (let t of tall) {
        res *= t;
    }
    return res;
}

