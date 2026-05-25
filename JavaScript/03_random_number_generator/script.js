const mybtn = document.getElementById("mybtn");
const label = document.getElementById("myLabel");

const min = 1;
const max = 6;
let randomNumber;

mybtn.onclick = function(){
    randomNumber = Math.floor(Math.random()*max)+min;
    label.textContent = randomNumber;
}
