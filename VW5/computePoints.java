int minimum(int... points) {
    assert points.length > 0: "minimum(): Array musn't be empty";
    int min = points[0];
    for(int e: points) {
        if(e < min) min = e;
    }
    return min;
}

int[] discardValue(int[] points, int min) {
    int index = -1; //-1, um es nicht mit einer validen Position zu vertauschen
    
    for(int i=0; i < points.length; i++) {
        if(points[i] == min) {
            index = i;
            break;
        }
    }

    int newLength = index >= 0 ? points.length - 1 : points.length;
    int[] arr = new int[newLength < 0 ? 0 : newLength];

    for(int i = 0, j = 0; i < points.length; i++) {
        if(i == index) continue;
        arr[j++] = points[i];
    }

    return arr;
}

float average(int... points) {
    assert points.length > 0: "average(): Array musn't be empty";
    int sum = 0;
    for(int e: points) {
        sum += e;
    }

    return sum / points.length;
}

float computePoints(int... points) {
    assert points.length > 0: "Array musn't be empty";
    return average(discardValue(points, minimum(points)));
}

int[] discardValue(int[] values, int min) {
    int index = -1;

    for(int i = 0; i < values.length; i++) {
        if(values[i] == min) {
            index = i;
            break;
        }
    }

    int newLength = index >= 0 ? values.length - 1 : values.length;
    newLength = newLength < 0 ? 0 : newLength;
    int[] arr = new int[newLength];

    for(int i = 0, j = 0; i < values.length; i++) {
        if(i == index) continue;
        arr[j++] = values[i];
    }

    return arr;
}

assert minimum(new int[]{1}) == 1;
assert minimum(new int[]{1, 2}) == 1;
assert minimum(new int[]{2, 1}) == 1;
assert minimum(new int[]{1, 2, 3}) == 1;
assert minimum(new int[]{3, 2, 1}) == 1;
assert minimum(new int[]{2, 1, 3}) == 1;


assert Arrays.equals(discardValue(new int[]{1}, 1), new int[]{});
assert Arrays.equals(discardValue(new int[]{1}, 0), new int[]{1});
assert Arrays.equals(discardValue(new int[]{1, 2, 3}, 1), new int[]{2, 3});
assert Arrays.equals(discardValue(new int[]{1, 2, 3}, 2), new int[]{1, 3});
assert Arrays.equals(discardValue(new int[]{1, 2, 3}, 3), new int[]{1, 2});
assert Arrays.equals(discardValue(new int[]{1, 2, 3}, 0), new int[]{1, 2, 3});
assert Arrays.equals(discardValue(new int[]{1, 2, 3, 1}, 1), new int[]{2, 3, 1});
assert Arrays.equals(discardValue(new int[]{1, 2, 3, 1}, 2), new int[]{1, 3, 1});
int[] test = {1, 2, 3};
assert discardValue(test, 0) != test : "Never return given array";
assert Arrays.equals(discardValue(new int[]{}, 1), new int[]{});

assert average(1, 2, 3, 4, 5) == 3.0f;

assert computePoints(1, 2, 3, 4, 5) == (2 + 3 + 4 + 5) / 4;
