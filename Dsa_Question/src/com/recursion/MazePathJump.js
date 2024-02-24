function getMazePathJump(sR, sC, dR, dC) {
    if (sR == dR && sC == dC) {
        return [""];
    }

    const updatedPaths = [];

    // horizontal jump column sR -> 
    for (let index = 1; index <= dR - sR; index++) {
        const horMoves = getMazePathJump(sR + index, sC, dR, dC);
        horMoves.forEach(element => {
            updatedPaths.push(element + "h" + index);
        });
    }
    // vertical jump column sC -> 
    for (let index = 1; index <= dC - sC; index++) {
        const verMoves = getMazePathJump(sR, sC + index, dR, dC);
        verMoves.forEach(element => {
            updatedPaths.push(element + "v" + index);
        });
    }
    // diagonal jump column sC -> 
    for (let index = 1; index <= dC - sC && index < dR - sR; index++) {
        const digMoves = getMazePathJump(sR + index, sC + index, dR, dC);
        digMoves.forEach(element => {
            updatedPaths.push(element + "d" + index);
        });
    }
    return updatedPaths;
}
console.log(getMazePathJump(1, 1, 3, 2));