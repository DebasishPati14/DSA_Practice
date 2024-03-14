function printFactorialOFNumber(num) {
    if (num == 0) {
        return 1;
    }
    const factorial = num * printFactorialOFNumber(num - 1)
    return factorial
}

const num = 5;
const factorial = printFactorialOFNumber(num);
console.log("Factorial of ", num, " is =", factorial);