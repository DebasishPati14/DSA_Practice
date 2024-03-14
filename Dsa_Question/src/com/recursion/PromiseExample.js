let p1 = new Promise((res, rej) => {
    setTimeout(() => {
        res("P1 is resolved")
    }, 5000)
})

let p2 = new Promise((res, rej) => {
    setTimeout(() => {
        res("P2 is resolved")
    }, 5000)
})

async function handlePromise() {
    console.log("Line 1 of function;");

    const val1 = await p1;
    console.log("After 1st promise resolve.");
    console.log(val1);

    const val2 = await p2;
    console.log("After 2nd promise resolve.");
    console.log(val2);
}

handlePromise();