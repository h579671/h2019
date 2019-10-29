"use strict";

let halloButton = document.getElementById("Hei");

halloButton.addEventListener("click", event => {
    document.getElementById("hello").innerHTML = "Hello!";
});
