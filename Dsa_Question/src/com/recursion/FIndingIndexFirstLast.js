const findFirstIndex = function (arr, idx, element) {
    let elementIndex = -1;
    if (arr[idx] == element) {
        elementIndex = idx;
    }
    else if (idx == arr.length) {
        elementIndex = -1;
    }
    else {
        elementIndex = findFirstIndex(arr, idx + 1, element);
    }
    return elementIndex;

}


const findLastIndex = function (arr, idx, element) {
    let eleIdx = -1;
    if (arr[idx] == element) {
        eleIdx = idx
    } else if (idx == -1) {
        eleIdx = -1;
    }
    else {
        eleIdx = findLastIndex(arr, idx - 1, element);
    }
    return eleIdx;
}
const lastIdx = findLastIndex([36, 420, 36, 24, 85], 4, 306);
const firstIdx = findFirstIndex([36, 420, 36, 24, 85], 0, 306);
console.log({ lastIdx });
console.log({ firstIdx });
