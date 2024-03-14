const result = sum(2)(5)(7)(9)();

function sum(num1) {
    return function (num2) {
        if (num2 == undefined) {
            return num1;
        }
        console.log({ num1, num2 });
        return sum(num1 + num2);
    }
}



function multiply(num1) {
    return function (num2) {
        if (!num2) {
            return num1;
        }
        return multiply(num1 * num2)
    }
}

const result2 = multiply(2)(3)(4)(5)();

console.log({ add: result, multiply: result2 });
