
let passwordEl = document.getElementById("password");
let rePasswordEl = document.getElementById("repeatPassword");
let errorEl = document.getElementById("passwordValidity");
const formSubmiter = document.getElementById("formSubmit");

const validatePassword = function (event) {
    if(passwordEl.value !== rePasswordEl.value && passwordEl.value.length != 0 && rePasswordEl.value.length != 0) {
        errorEl.innerText = "Passwords don't match!";
        formSubmiter.setAttribute("disabled", "true");
    }
    else {
        errorEl.innerText = "";
        formSubmiter.removeAttribute("disabled");
    }
}
rePasswordEl.addEventListener("keyup", validatePassword);
passwordEl.addEventListener("keyup", validatePassword);
