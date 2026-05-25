const decrease = document.getElementById("decreaseBtn");
const reset = document.getElementById("resetBtn");
const increase = document.getElementById("increaseBtn");
const counter = document.getElementById("countLabel");
let count = 0;

decrease.onclick = function(){
    count--;
    counter.textContent = count;
}

reset.onclick = function(){
    count = 0;
    counter.textContent = count;
}

increase.onclick = function(){
    count++;
    counter.textContent = count;
}