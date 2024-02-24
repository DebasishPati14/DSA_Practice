const keypadStrings = [".;",
    "',", "abc", "def",
    "ghi", "jkl", "mno",
    "pqrs", "tuv", "wxyz"];

function getKeypadStrings(mainStr) {
    if (mainStr.length == 0) {
        return [""];
    }
    const ch = mainStr.charAt(0);
    mainStr = mainStr.substring(1);
    const prevStrings = getKeypadStrings(mainStr);
    const updatedArr = [];


    const numberCharacters = keypadStrings[+ch];
    // console.log(numberCharacters.charAt(index));
    for (let index = 0; index < numberCharacters.length; index++) {
        const ch = numberCharacters.charAt(index);
        prevStrings.forEach(str => {
            updatedArr.push(ch + str)
        })
    }

    return updatedArr;
}

const combination = getKeypadStrings("25274");
console.log(combination);