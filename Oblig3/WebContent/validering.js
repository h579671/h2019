"use strict";


let Personjs = new Personjs();

let opprettButton = document.getElementById("opprett");
opprettButton.addEventListener("click", event => {
    person = opprettPerson();
});


function opprettPerson(){
		
	person = new Person();
    person.fornavn = document.getElementById("fornavn").value;
    person.etternavn = document.getElementById("etternavn").value;
    person.mobilnummer = document.getElementById("mobilnummer").value;
    person.passord = document.getElementById("passord").value;
    person.passordto = document.getElementById("passordto").value;
    person.kjonn = document.getElementById("kjonn").value;
    
    if(!superValidering(person)){
    	return null;
    }
    
    return person;
}

function superValidering(person){
	let valid = true;
	if(!validerFornavn(person.fornavn)){
		valid = false;
	}
	
	if(!validerEtternavn(person.etternavn)){
		valid = false;
	}
	
	if(!validerMobilnummer(person.mobilnummer)){
		valid = false;
	}
	
	if(!validerPassord(person.passord)){
		valid = false;
	}
	
	if(!validerPassordto(person.passordto)){
		valid = false;
	}
	
	if(!validerKjonn(person.kjonn)){
		valid = false;
	}
	return valid;
}

function visPerson(person) {
    document.getElementById("visfornavn").innerText = person.fornavn;
    document.getElementById("visetternavn").innerText = person.etternavn;
    document.getElementById("vismobilnummer").innerText = person.mobilnummer;
    document.getElementById("viskjonn").innerText = person.kjonn;
}

function validerFornavn(fornavn){
	let valid = true;
	
	if (typeof fornavn === 'string' || fornavn instanceof String) {
		let upperCaseLetters = /[A-Z]/g;
        if (fornavn.length >= 2  && fornavn.length <= 20) {
            if (person[0] !== person[0].toLowerCase()) {
                // valid
            } else {
                alert("fornavn må ha stor bokstav");
                valid = false;
            }
        } else {
            alert("brukernavn skal være mellom 2 og 20 bokstaver");
            valid = false;
        }
    } else {
        alert("fornavn " + fornavn + " er ikke en streng");
        valid = false;
    }
    return valid;
}

function validerEtternavn(etternavn){
    let valid = true;
	let space = " ";
	if (typeof fornavn === 'string' || fornavn instanceof String) {
		let upperCaseLetters = /[A-Z]/g;
        if (fornavn.length >= 2  && fornavn.length <= 20) {
            if (person[0] !== person[0].toLowerCase()) {
                if(!space.match(etternavn)){
                	//valid
                }else{
                	alert("Kan ikke bruke mellomrom")
                	valid = false;
                }
            } else {
                alert("etternavn må ha stor bokstav");
                valid = false;
            }
        } else {
            alert("etternavn skal være mellom 2 og 20 bokstaver");
            valid = false;
        }
    } else {
        alert("fornavn " + fornavn + " er ikke en streng");
        valid = false;
    }
    return valid;
}

function validerMobilnummer(mobilnummer){
	let valid = true;
	let numbers = /^[0-9]+$/;
    if(!mobilnummer.value.match(numbers)){
    	alert("Nummer kan kun inneholde tall");
    	valid = false;
	}else{
    	if(mobilnummer.length != 8){
    		alert("Nummeret må være 8 tall")
    		valid = false;
    	}
    }
    return valid;
}

function validerPassord(passord){
	let valid = true;
	
	let myInput = document.getElementById("passord");
	let letter = document.getElementById("letter");
	let capital = document.getElementById("capital");
	let number = document.getElementById("number");
	let length = document.getElementById("length");
	
	//Sjekker styrke
	let span = document.getElementById("errorSpan");
	  if (password.length >= 12) {
		  span.style.color = "green";
	  } else if (password.length >= 6) {
		  span.style.color = "yellow";
	  } else {
		  span.style.color = "red";
	  }

	// When the user clicks on the password field, show the message box
	myInput.onfocus = function() {
	  document.getElementById("message").style.display = "block";
	}

	// When the user clicks outside of the password field, hide the message box
	myInput.onblur = function() {
	  document.getElementById("message").style.display = "none";
	}

	// When the user starts to type something inside the password field
	myInput.onkeyup = function() {
	  // Validate lowercase letters
	  let lowerCaseLetters = /[a-z]/g;
	  if(myInput.value.match(lowerCaseLetters)) {
	    //valid
	  } else {
	    valid = false;
	    alert("Du må ha liten bokstav");
	}

	  // Validate capital letters
	  let upperCaseLetters = /[A-Z]/g;
	  if(myInput.value.match(upperCaseLetters)) {
	    //valid
	  } else {
	    valid = false;
	    alert("Stor bokstav påkrevd");
	  }

	  // Validate numbers
	  let numbers = /[0-9]/g;
	  if(myInput.value.match(numbers)) {
	    //valid
	  } else {
	    valid = false;
	    alert("Nummer påkrevd");
	  }

	  // Validate length
	  if(myInput.value.length >= 8) {
	    //valid
	  } else {
	    valid = false;
	    alert("For kort passord");
	  }
	  
	}
	
	return valid;
}

function validerPassordto(passordto){
	let valid = true;
	if(!person.passord.equals(passordto)){
		valid = false;
	}
	return valid;
}

function validerKjonn(kjonn){
	let valid = true;
	if(kjonn === null){
		alert("Du må velge et kjønn");
		valid = false;
	}
	return valid;
}














/*

var myInput = document.getElementById("passord");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}

  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
  
}
*/