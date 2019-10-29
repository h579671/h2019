"use strict";

/**
 * Modellen.
 */
let person = new Person();

/**
 * Kontroller for opprett person1.
 */
let opprettButton = document.getElementById("opprett");
opprettButton.addEventListener("click", event => {
    person = opprettPerson();
});

/**
 * Kontroller for vis person1.
 */
let visButton = document.getElementById("vis");
visButton.addEventListener("click", event => {
    visPerson(person);
});

/**
 * Henter data fra HTML-siden og oppretter en ny person1.
 */
function opprettPerson() {
    let postnummer = document.getElementById("postnummer").value;
    if (!validerPostnummer(postnummer)) {
        return;
    }

    person = new Person();
    person.fornavn = document.getElementById("fornavn").value;
    person.etternavn = document.getElementById("etternavn").value;
    person.postnummer = document.getElementById("postnummer").value;
    person.telefon = document.getElementById("telefon").value;
    return person;

    // let fornavn = document.getElementById("fornavn").value;
    // let etternavn = document.getElementById("etternavn").value;
    // let postnummer = document.getElementById("postnummer").value;
    // let telefon = document.getElementById("telefon").value;
    // return new Person(fornavn, etternavn, postnummer, telefon);
}

/**
 * Viser data for person1.
 */
function visPerson(person) {
    document.getElementById("visfornavn").innerText = person.fornavn;
    document.getElementById("visetternavn").innerText = person.etternavn;
    document.getElementById("vispostnummer").innerText = person.postnummer;
    document.getElementById("vistelefon").innerText = person.telefon;
}

/**
 * Validerer et postnummer.
 */
function validerPostnummer(postnummer) {
    let valid = true;
    if (typeof postnummer === 'string' || postnummer instanceof String) {
        if (postnummer.length === 4) {
            if (!isNaN(postnummer)){
                // valid
            } else {
                alert("postnummer må være et tall");
                valid = false;
            }
        } else {
            alert("postnummer skal være 4 tegn");
            valid = false;
        }
    } else {
        alert("postnummer " + postnummer + " er ikke en streng");
        valid = false;
    }
    return valid;
}