
function generatepassword(length, lowercase, upperCase, number, symbols)
{
    const lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
    const uppserCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const numberschars = "0123456789";
    const speacialChars = "!@#$%^&*()_+-/";

    let allowedChars = "";
    let password = "";

    allowedChars += lowercase ? lowerCaseChars : "";
    allowedChars += upperCase ? uppserCaseChars : "";
    allowedChars += number ? numberschars : "";
    allowedChars += symbols ? speacialChars : "";

    if(length <= 0)
    {
        return `Password length must be atleast 1`;
    }
    if(allowedChars.length === 0)
    {
        return `At least one set of characters must be selected`;
    }
    for(let i=0; i<length ; i++)
    {
        const randomindex = Math.floor(Math.random() * allowedChars.length);
        password += allowedChars[randomindex];
    }
    return password;
}

const passwordLength = 12;
const includelowerCase = true;
const includeUpperCase = true;
const includenumber = true;
const includeSymbols = true;

const password = generatepassword(passwordLength, 
                                    includelowerCase, 
                                    includeUpperCase, 
                                    includenumber, 
                                    includeSymbols);

 console.log(`Generated Password : ${password}`)                                   