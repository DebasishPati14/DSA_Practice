function printDecreasingIncreasing(num) {

    if (num == 0) {
        console.log("________________________")

        return;
    }

    console.log(num)
    printDecreasingIncreasing(num - 1);
    console.log(num)
}

printDecreasingIncreasing(8)