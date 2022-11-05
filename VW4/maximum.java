int maximum(int[] ar) {
    assert ar.length > 0 : "Kein leeres Array erlaubt";
    int max = ar[0];
    for(int elem: ar) {
        if(elem > max) max = elem;
    }
    return max;
}

assert maximum(new int[]{-9, 1, 3, 0, 10, 2, 6}) == 10;
assert maximum(new int[]{-10, -1, -2, -4}) == -1;
assert maximum(new int[]{1}) == 1;
assert maximum(new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE}) == Integer.MAX_VALUE;
