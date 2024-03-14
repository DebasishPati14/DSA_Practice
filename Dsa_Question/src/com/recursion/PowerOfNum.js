
function linierPowerOfNumber(num, pow) {
    if (pow == 0) {
        return 1;
    }
    const result = num * linierPowerOfNumber(num, pow - 1);
    return result;
}

function logarithmicPowerOfNumber(num, pow) {
    let result = 1;
    if (pow == 0) {
        return result;
    }
    console.log(pow);
    if (pow % 2 != 0) {
        const power = logarithmicPowerOfNumber(num, Math.floor(pow / 2));
        result = power * power * num;
    } else {
        const power = logarithmicPowerOfNumber(num, Math.floor(pow / 2));
        result = power * power;
    }
    return result;
}

const num = 2;
const pow = 9;

const linierPower = linierPowerOfNumber(num, pow);
console.log("Liner power is ", linierPower);

const logPower = logarithmicPowerOfNumber(num, pow);
console.log("Liner power is ", logPower);