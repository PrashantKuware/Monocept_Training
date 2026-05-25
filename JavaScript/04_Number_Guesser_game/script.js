const min = 1;
const max = 100;
const answer = Math.floor(Math.random() * (max-min+1))+min;

let attempt = 0;
let guess;
let running = true;

while(running)
{
    guess=window.prompt(`Guess a number between ${min} - ${max}`);
    guess = Number(guess);

    if(isNaN(guess))
    {
        window.alert("Please enter a valid number");
    }
    else if(guess < min || guess > max) 
        {
         window.alert("Please enter a valid number");
    }
    else
    {
        attempt++;
        if(guess < answer)
        {
            window.alert("Too low! Try again");
        }
        else if(guess > answer)
        {
            window.alert("Too high! Try again");
        }
        else
        {
            window.alert(`Correct! the answer was ${answer}. It took you ${attempt} attempts`);
            running=false;
        }
    }
   
}