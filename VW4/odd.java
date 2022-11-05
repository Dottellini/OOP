//Version ohne Negativwerte
boolean odd (int num) {
    assert num >= 0 : "Nur positive Werte erlaubt";
    return num % 2 == 1;
}

//Version mit Negativwerte
boolean odd (int num) {
    if(num < 0) num = -num;
    return num % 2 == 1;
}


boolean odd (int num) {
    if(num == Integer.MIN_VALUE) return false; 
    if(num < 0) return odd(-num);
    return num % 2 == 1;
}

boolean odd (int num) {
    return num % 2 != 0;
}

//Testing
assert odd(0) == false;
assert odd(5) == true;
assert odd(2) == false;
assert odd(Integer.MAX_VALUE) == true;

assert odd(-8) == false;
assert odd(-7) == true;
assert odd(Integer.MIN_VALUE) == false;
