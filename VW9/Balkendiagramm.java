class Bar {
    final int MAX_SIZE = 40;
    int size;

    Bar(int size) {
        if(size > MAX_SIZE || size < 0) throw new IllegalArgumentException("required: 0 <= size <= " + MAX_SIZE);
        this.size = size;
    }

    @Override
    public String toString() {
        return "#".repeat(size) + " " + size;
    }
}


class Chart {
    Bar[] bars;
    int index = 0;

    Chart(int size) {
        if(size < 0) throw new IllegalArgumentException("required: size >= 0");
        bars = new Bar[size];
    }

    void up() {
        up(1);
    }

    void up(int n) {
        if(n <= 0) throw new IllegalArgumentException("required: n > 0");
        index = (index + n) % bars.length;
    }

    void down() {
        down(1);
    }

    void down(int n) {
        if(n <= 0) throw new IllegalArgumentException("required: n > 0");
        index = (index + bars.length - n) % bars.length;
    }

    void set(Bar bar) {
        bars[index] = bar;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < bars.length; i++) {
            s += (index == i ? "* " : "  ") + (bars[i] == null ? "???" : bars[i].toString()) + "\n";
        }
        return s;
    }
}

//Bar Testing
assert new Bar(10).toString().equals("########## 10");

//Chart Testing
Chart chart = new Chart(3);
assert chart.toString().equals("* ???\n  ???\n  ???\n");
chart.down(1);
assert chart.toString().equals("  ???\n  ???\n* ???\n");
chart.up(1);
assert chart.toString().equals("* ???\n  ???\n  ???\n");
