// Quicksort, in place sorting -- according to
// https://www.youtube.com/watch?v=MZaf_9IZCrc


//Tauscht i und j
void swap(int[] numbers, int i, int j) {
    int tmp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = tmp;
}


//schiebt den Pivot in die Mittelstelle, wo die kleineren Zahlen vor ihm, und die größeren nach ihm stehen
void shift(int[] numbers, int from, int to) {
    int tmp = numbers[to];  //Speichert letzte Zahl in variable
    for (int i = to - 1; i >= from; i--)    //Schiebt alle Zahlen von rechts beginnend um eine Stelle nach rechts
        numbers[i + 1] = numbers[i];
    numbers[from] = tmp;    //Setzt gespeicherte Zahl in nun freie Stelle ein
}


//Quicksort Algorithmus
void qs(int[] numbers, int first, int last) {
    if (first >= last) return;
    int i = first - 1;
    for (int j = first; j < last; j++) {
        if (numbers[j] < numbers[last]) {   //Wenn die Zahl bei j größer als der Pivot ist, wird sie mit i+1 getauscht
            i = i + 1;
            swap(numbers, i, j); //Tauscht i und j
        }
    }
    shift(numbers, i + 1, last);    //Der Pivot wird in die Mitte geschoben
    qs(numbers, first, i);      //Rekursion
    qs(numbers, i + 2, last);   //Rekursion
}

int[] quicksort(int[] numbers) {
    qs(numbers, 0, numbers.length - 1);
    return numbers;
}

// Beispielanwendung:
//
// jshell> quicksort(new int[]{7, 2, 1, 8, 6, 3, 5, 4})
// $9 ==> int[8] { 1, 2, 3, 4, 5, 6, 7, 8 }

// Testing

AssertionError ae;
try { assert false; }
catch (AssertionError exception) { ae = exception; }
if (ae == null) System.out.println("WARNING: Turn assertions on, call \"jshell -R-ea\"");

int[] numbers = new int[]{};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{});

numbers = new int[]{7};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{7});

numbers = new int[]{1, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 1});

numbers = new int[]{1, 2};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2});

numbers = new int[]{2, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2});

numbers = new int[]{1, 2, 3};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{1, 3, 2};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{2, 1, 3};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{2, 3, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{3, 1, 2};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{3, 2, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 2, 3});

numbers = new int[]{3, 3, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 3, 3});

numbers = new int[]{1, 3, 3};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 3, 3});

numbers = new int[]{3, 3, 1};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{1, 3, 3});

numbers = new int[]{5, 3, 3};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{3, 3, 5});

numbers = new int[]{3, 3, 5};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{3, 3, 5});

numbers = new int[]{3, 3, 3};
qs(numbers, 0, numbers.length - 1);
assert Arrays.equals(numbers, new int[]{3, 3, 3});