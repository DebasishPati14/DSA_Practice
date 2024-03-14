function getStairCase(num) {
    if (num == 0) {
        return [""];
    }

    if (num < 0) {
        return [];
    }


    const oneStepPaths = getStairCase(num - 1);
    const twoStepPaths = getStairCase(num - 2);
    const threeStepPaths = getStairCase(num - 3);
    const updatedPath = []

    oneStepPaths.forEach(path => {
        updatedPath.push(path + "1")
    })

    twoStepPaths.forEach(path => {
        updatedPath.push(path + "2")
    })

    threeStepPaths.forEach(path => {
        updatedPath.push(path + "3")
    })

    return updatedPath;
}

console.log(getStairCase(4));