import java.lang.System;

int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};

boolean isPrime(int number) {
    if(number < 2) return false;
    for(int i = 2; i < number; i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}

boolean isPrimeTest(int[] primeNumbers) {
    assert primeNumbers.length > 0 : "Array cant be empty";
    for(int elem: primeNumbers) {
        if(!isPrime(elem)) return false;
    }
    return true;
}

int[] primes(int n) {
    assert n >= 2 : "Parameter in primes() must be larger or equal to 2";
    int[] helper = new int[n];
    int counter = 0;
    for(int i = 2; i <= n; i++) {
        if(isPrime(i)) {
            helper[counter] = i;
            counter++;
        }
    }

    int[] arr = new int[counter]; //Copy helper to new array to erase 0
    for(int i = 0; i < counter; i++) {
        arr[i] = helper[i];
    }

    return arr;
}

boolean isPrimeFast(int[] primes, int n, int number) {
    if(number == 2) return true; //Exception für die Zahl 2, da sonst das zweite Assert failed

    assert n <= primes.length : "n is bigger than Array";
    assert number % 2 != 0 || n % 2 != 0 : "number and n must be odd";
    assert number < primes[n-1] * primes[n-1]: "Number must be smaller than primes[n-1]*primes[n-1]";
    for(int i = 0; i < primes.length; i++) {
        if(number % primes[i] == 0) return false; //Keine Primzahl, wenn durch Primzahl teilbar
    }

    return true;
}

assert isPrime(7) == true;
assert isPrime(2) == true;
assert isPrime(5) == true;
assert isPrime(1) == false;

assert isPrimeTest(primeNumbers) == true;
assert isPrimeTest(new int[]{2, 3, 4, 5, 6}) == false;
assert isPrimeTest(primes(71)) == true;
assert isPrimeTest(primes(200)) == true;

/*assert isPrimeFast(primes(20), 5, 9) == false;
assert isPrimeFast(primes(10), 1, 3) == true;
assert isPrimeFast(primes(20), 5, 2) == true;
*/