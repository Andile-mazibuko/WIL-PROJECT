
let container = document.getElementById("form-cont");
let logInForm = document.getElementById("logInForm");
let signUpForm = document.getElementById("signUpForm");


document.getElementById("toogle-login").addEventListener("click",function(){
    signUpForm.classList.toggle("invisible");
    container.classList.toggle("login-form-cont");
    logInForm.classList.toggle("visible");
    

});
document.getElementById("toogle-sign-up").addEventListener("click",function(){
    container.classList.toggle("login-form-cont");
    signUpForm.classList.toggle("invisible");
    logInForm.classList.toggle("visible");
    
});
/*
function toogleBoxContainer()
{
    container.classList.add("form-cont");*/