let presentIndex = [];

function findingAllIndices(arr, idx, element) {
    if (arr[idx] == element) {
        presentIndex.push(idx);
    }
    else if (idx == arr.length) {
        return;
    }
    findingAllIndices(arr, idx + 1, element);
}


findingAllIndices([36, 420, 36, 24, 85], 0, 36);

console.log(presentIndex);
