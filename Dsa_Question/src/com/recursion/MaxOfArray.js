const findMaximumOfArray = function (arr, idx, max) {

    if (idx == 0) {
        return arr[0];
    }

    const maxOfMinArr = findMaximumOfArray(arr, idx - 1, max);
    const maximumNumber = maxOfMinArr > arr[idx] ? maxOfMinArr : arr[idx];

    return maximumNumber;
}

const max = findMaximumOfArray([11, 420, 36, 24, 85], 4, 0);
console.log(max);
