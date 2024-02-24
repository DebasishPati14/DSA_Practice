function printAscending(arr, idx) {
    if (idx == -1) {
        return;
    }
    console.log(arr[idx])
    printAscending(arr, idx - 1);
    console.log(arr[idx]);
}

function printDescending(arr, idx) {
    if (idx === arr.length) {
        return;
    }
    printDescending(arr, idx + 1);
    console.log(arr[idx]);
}

printAscending([1, 2, 3, 4, 5], 4);
console.log("Descending");
printDescending([1, 2, 3, 4, 5], 0);