function printTowerOfHanoi(num, t1, t2, t3) {
    if (num == 0) {
        return;
    }

    // Faith all tower form t1 will come to t3 with the help of t2
    printTowerOfHanoi(num - 1, t1, t3, t2);
    console.log("[", t1, "-> ", t2, "]", "Disk: ", num);
    // Expectation all tower form t1 will come to t2 with the help of t3
    printTowerOfHanoi(num - 1, t3, t2, t1);
}

printTowerOfHanoi(3, "A", "B", "C")