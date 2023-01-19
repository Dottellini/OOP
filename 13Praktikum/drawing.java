class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Canvas {
    final char[][] pane; // Welche weiteren sechs Variablen fehlen hier?
    float deltaX, deltaY, xmin, xmax, ymin, ymax;
    

    Canvas(int width, int height) {
        assert width > 0 && height > 0;
        pane = new char[height][width];
        clear();
        setRange(-1,+1,-1,+1);
    }
    
    void clear() {
        for(int i = 0; i < pane.length; i++) {
            for(int j = 0; j < pane[i].length; j++) {
                pane[i][j] = '.';
            }
        }
    }

    int getWidth() { return pane.length; }

    int getHeight() { return pane[0].length; }

    void setRange(float xmin, float xmax, float ymin, float ymax) {
        assert xmin < xmax && ymin < ymax;
        this.xmin = xmin;
        this.xmax = xmax;  // Was wird hier warum in der Methode gemacht?
        this.ymin = ymin;  // Man setzt die Werte, in welchen man die punkte verticaleilen möche. Z.b. -1 bis 1
        this.ymax = ymax;
        deltaX = Math.abs(xmax - xmin) / (getWidth()  - 1);      // Hier bestimmt man einen delta Wert, welcher genutzt wird um einen Wert
        deltaY = Math.abs(ymax - ymin) / (getHeight() - 1);     // vom Array in unsere Grenzen zu übersetzen
    }

    int getX(float fx) {
        return Math.round((fx - xmin) / deltaX);    // Gibt den index für fx im Array wieder (Die Vertikale)
    }

    int getY(float fy) {
        return Math.round((ymax - fy) / deltaY);    // Gibt den index für fy im Array wieder (Die Horizontale)
    }

    char getPoint(float fx, float fy) {
        Point point = new Point(getX(fx), getY(fy));

        if(point.x > pane.length || point.x < 0 || point.y > pane[0].length || point.y < 0) return '.';

        return pane[point.x][point.y];
    }

    Canvas setPoint(float fx, float fy, char c) {
        Point point = new Point(getX(-fy), getY(-fx));

        if(point.x > pane.length || point.x < 0 || point.y > pane[0].length || point.y < 0) return this;

        pane[point.x][point.y] = c;

        return this;
    }

    Canvas drawCircle(float fx, float fy, float radius) {
        for(double i = 0.0; i < 2 * Math.PI; i += 0.1) {
            setPoint((float)Math.cos(i) * radius + fx, (float)Math.sin(i) * radius + fy, '+');
        }

        return this;
    }

    Canvas drawLine(float fx_start, float fy_start, float fx_end, float fy_end) {
        //Hier muss man noch prüfen, dass werte innerhalb des Feldes liegen aber ich bin grad zu faul dafür
        assert fx_start <= fx_end && fy_start <= fy_end;
    
        float m = (fy_end - fy_start) / (fx_end - fx_start);
        System.out.println(m);

        //Still buggy
        while(fx_start < fx_end || fy_start < fy_end) {
            System.out.println("A");
            setPoint(fx_start, fy_start, '@');
            fx_start += 0.1 * m;
            fy_start += 0.1 * m;
        }
        
        return this;
    };

    void show() { System.out.print(this); }

    public String toString() {
        String s = "\n";

        for(int i = 0; i < pane.length; i++) {
            for(int j = 0; j < pane[i].length; j++) {
                s += pane[i][j];
            }
            s += "\n";
        }

        return s;
    }
}
