//Meine Version
int checksum(int n) {
    int sum = 0; //Sum ist die "rechteste" Ziffer
    assert n >= 0 : "Nur positive Werte";
    
    while(n != 0) {
        sum += n % 10;
        n = n/10;
    }

    if(sum > 9) sum = checksum(sum);

    return sum;
}


//Herzis Version
int checksum_h(int n) {
    if(n <= 9) return n;
    int sum = n % 10;
    n = n / 10;
    return checksum(sum + checksum_h(n));
}

assert checksum(123) == 6;
assert checksum(938) == 2;
assert checksum(0) == 0;
assert checksum(10) == 1;
assert checksum(9) == 9;
assert checksum(19) == checksum(10);
