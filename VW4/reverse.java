int[] reverse(int[] ar) {
    assert ar.length > 0 : "Kein leeres Array erlaubt";
    int[] help = new int[ar.length];

    //Hilfsarray befüllen
    for (int i = 0; i < ar.length; i++) {
        help[i] = ar[i];
    }

    //Array reversen durch Hilfsarray
    for (int i = ar.length-1, j = 0; i >= 0; i--, j++) {
        ar[j] = help[i];
    }

    return ar;
}

assert Arrays.equals(reverse(new int[]{1, 2, 3, 4, 5}), new int[]{5, 4, 3, 2, 1});
assert Arrays.equals(reverse(new int[]{-1, -5, 3, 9}), new int[]{9, 3, -5, -1});
