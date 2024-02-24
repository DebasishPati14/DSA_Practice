function getMazePath(sR, sC, dR, dC) {
    if (sC == dC && sR == dR) {
        return [""];
    }


    let horPaths = []
    let verPaths = [];
    if (sC < dC) {
        verPaths = getMazePath(sR, sC + 1, dR, dC);
    }

    if (sR < dR) {
        horPaths = getMazePath(sR + 1, sC, dR, dC);
        console.log(horPaths);
    }

    const resultantPath = [];

    horPaths.forEach(ele => {
        resultantPath.push("h" + sR + ele)
    })

    verPaths.forEach(ele => {
        resultantPath.push("v" + sC + ele)
    })

    return resultantPath;
}
console.log(getMazePath(1, 1, 3, 3));