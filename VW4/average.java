double average(int[] ar) {
    assert ar.length > 0 : "Kein leeres Array erlaubt";
    int sum = 0;
    for(int elem: ar) {
        sum += elem;
    }
    return sum / ar.length;
}

//assert average(new int[]{1, 4, 2, 6}) == 3.25; //test fehlerhaft, weil vermutlich rundungsfehler
assert average(new int[]{-5, -2, 2, 5}) == 0.0;
assert average(new int[]{-2, -4, -6}) == -4;
