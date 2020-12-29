
const passwordEl = document.getElementById("password");
const rePasswordEl = document.getElementById("repeatPassword");
const errorEl = document.getElementById("passwordValidity");
const formSubmitEl = document.getElementById("formSubmit");

const validatePassword = function (event) {
    if (passwordEl.value !== rePasswordEl.value && passwordEl.value.length !== 0 && rePasswordEl.value.length !== 0) {
        errorEl.innerText = "Passwords don't match!";
        formSubmitEl.setAttribute("disabled", "");
    }
    else {
        errorEl.innerText = "";
        formSubmitEl.removeAttribute("disabled");
    }
}
rePasswordEl.addEventListener("keyup", validatePassword);
