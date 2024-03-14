// const givenName = {
//     "firstName": "Debasish",
//     lastName: "Pati"
// }

// const printMyName = function (city, state) {
//     console.log("Name: " + this.firstName + " " + this.lastName, "\nFrom: " + city + " " + state);
// }
// printMyName.apply(givenName, ["Jpr", "RJ"])

// const printBind1 = printMyName.bind(givenName, "BBSR", "Odisha");
// printBind1();

// Function.prototype.myCustomBind = function (...args1) {
//     const caller = this;
//     const args = args1.slice(1);
//     return function (...args2) {
//         this.apply(args1[0], [...args, ...args2])
//     }
// }

// const printBind2 = printMyName.myCustomBind(givenName, "Odisha", "BBSR");
// printBind2()


const arr = [1, 2, 3, 4, 5];

const newArr = arr.map(multiply);
function multiply(param) {
    return param * 5;
}

const myMap = function (logic) {
    const resultArr = [];
    this.forEach(element => {
        resultArr.push(logic(element));
    })
    return resultArr;
}


Array.prototype.myFilter = function (logic) {
    const resultArr = [];
    this.forEach(ele => {
        if (logic(ele)) {
            resultArr.push(ele)
        }
    })
    return resultArr
}

let reducr = arr.myFilter(x => x > 3)
Array.prototype.myMap = myMap;
const lastArr = arr.myMap(multiply)
console.log({ newArr, arr, lastArr, reducr });;