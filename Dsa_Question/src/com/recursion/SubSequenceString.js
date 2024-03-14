
function getKeypadStrings(mainStr) {
    if (mainStr.length == 0) {
        return [""];
    }
    const ch = mainStr[0];
    mainStr = mainStr.substring(1);
    const prevStrings = getKeypadStrings(mainStr);
    const updatedArray = [];

    prevStrings.forEach(str => {
        console.log(ch, "->", str);
        updatedArray.push(str + "");
        updatedArray.push(ch + str);
    });

    return updatedArray;
}
let al = [];
al = getKeypadStrings("abcdlmnopqr");

console.log(al)