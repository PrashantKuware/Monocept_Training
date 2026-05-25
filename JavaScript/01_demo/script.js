

const PI=3.14;
let radius;
let circumference;

document.getElementById("mySubmit").onclick = function()
{
    radius = (document.getElementById("radius").value);
    radius = Number (radius);
    circumference = 2*PI*radius;
    document.getElementById("myh3").textContent = circumference;
}

