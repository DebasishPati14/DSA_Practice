const arrOfNumbers = [2, 8, 4, 5, 9, 1, 7, 6, 3];


function swap(idx1, idx2) {
    console.log("Swapped the number: ", arrOfNumbers[idx1], arrOfNumbers[idx2]);
    const temp = arrOfNumbers[idx1];
    arrOfNumbers[idx1] = arrOfNumbers[idx2];
    arrOfNumbers[idx2] = temp;
    return;
}

function isGreater(idx1, idx2) {
    return arrOfNumbers[idx1] > arrOfNumbers[idx2];;
}

function mergeTwoSortedArray(arr1, arr2) {
    let i = 0;
    let j = 0;
    let k = 0;
    const mergedArr = [];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] > arr2[j]) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        } else {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
    }
    if (i == arr1.length) {
        while (j < arr2.length) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }
    } else {
        while (i < arr1.length) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }
    }
    return mergedArr;
}

function partitioningArray(pivot, first, last) {
    j = first;
    for (let i = first; i <= last;) {
        if (arrOfNumbers[i] > pivot) {
            i++;
        } else {
            const temp = arrOfNumbers[i];
            arrOfNumbers[i] = arrOfNumbers[j];
            arrOfNumbers[j] = temp;
            i++;
            j++;
        }
    }
    return j - 1;
}

const bubbleSort = () => {
    for (let i = 0; i < arrOfNumbers.length - 1; i++) {
        for (let j = 0; j < arrOfNumbers.length - 1; j++) {
            if (isGreater(j, j + 1)) {
                swap(j, j + 1)
            }
        }
        console.log(arrOfNumbers);
    }
}


const selectionSort = () => {
    for (let i = 0; i < arrOfNumbers.length - 1; i++) {
        let min = i;
        for (let j = i + 1; j < arrOfNumbers.length; j++) {
            if (isGreater(min, j)) {
                min = j;
            }
        }
        swap(i, min);
        console.log(arrOfNumbers);
    }

}

const insertionSort = () => {
    for (let i = 0; i < arrOfNumbers.length; i++) {
        for (let j = i + 1; j > 0; j--) {
            if (isGreater(j - 1, j)) {
                swap(j - 1, j);
            } else {
                continue;
            }
        }
    }
}

const mergeSort = (array, first, last) => {
    // console.log({ middle: Math.floor((first + last) / 2), first, last, ele: array[first] });
    if (first == last) {
        return [array[first]];
    }

    const middle = Math.floor((first + last) / 2);
    const sortedFirstHalf = mergeSort(array, first, middle);
    const sortedSecondHalf = mergeSort(array, middle + 1, last);

    const mergedArrays = mergeTwoSortedArray(sortedFirstHalf, sortedSecondHalf);
    console.log({ sortedFirstHalf, sortedSecondHalf, mergedArrays });

    return mergedArrays;
}

const quickSort = (first, last) => {
    if (first >= last) {
        return;
    }
    pivot = arrOfNumbers[last];
    pivotIdx = partitioningArray(pivot, first, last);
    quickSort(first, pivotIdx - 1);
    quickSort(pivotIdx + 1, last);
}


// console.log("BeforeSorting: ", { arrOfNumbers });

//      SORTING CALLS
// *************************
// bubbleSort();
// selectionSort();
// insertionSort();
// quickSort(0, arrOfNumbers.length - 1);


const res = mergeSort(arrOfNumbers, 0, arrOfNumbers.length - 1);
// const res = mergeTwoSortedArray([2, 4, 6, 8, 10], [1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 20])
console.log(res);

// console.log("After Sorting: ", { arrOfNumbers });