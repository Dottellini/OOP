// Wenn eine Zahl kleiner ist als ihr Vorgänger, werden 
void swap(int[] nums, int i, int j) {
    assert i >= 0 && i < nums.length;
    assert j >= 0 && j < nums.length;
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp; 
}

boolean bubble(int[] numbers) {
    boolean swapped = false;
    for (int i = 0; i < numbers.length - 1; i++) {
        if (numbers[i] > numbers[i + 1]) {
            swap(numbers, i, i + 1);
            swapped = true;
        }
    }
    return swapped;
}

int[] bubblesort(int... numbers) {
    while (bubble(numbers));
    return numbers;
}

int[] generateRandomNumbers(int n) {
    int[] randomNumbers = new int[n];
    for (int i = 0; i < randomNumbers.length; i++)
        randomNumbers[i] = new Random().nextInt(100);
    return randomNumbers;
}

// Testing

AssertionError ae;
try { assert false; }
catch (AssertionError exception) { ae = exception; }
if (ae == null) System.out.println("WARNING: Turn assertions on, call \"jshell -R-ea\"");

assert Arrays.equals(new int[]{}, bubblesort());
assert Arrays.equals(new int[]{}, bubblesort(new int[]{}));
assert Arrays.equals(new int[]{3}, bubblesort(new int[]{3}));
assert Arrays.equals(new int[]{3, 5}, bubblesort(new int[]{3, 5}));
assert Arrays.equals(new int[]{3, 5}, bubblesort(new int[]{5, 3}));
assert Arrays.equals(new int[]{3, 3}, bubblesort(new int[]{3, 3}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{1, 2, 3}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{1, 3, 2}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{2, 1, 3}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{2, 3, 1}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{3, 1, 2}));
assert Arrays.equals(new int[]{1, 2, 3}, bubblesort(new int[]{3, 2, 1}));

boolean bubblesortTest(int[] numbers) {
    int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(numbersCopy);
    bubblesort(numbers);
    return Arrays.equals(numbersCopy, numbers);
}

assert bubblesortTest(new int[]{4, 3, 7, 1, 5, 2});
assert bubblesortTest(generateRandomNumbers(20));