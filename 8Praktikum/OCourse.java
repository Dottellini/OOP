import java.util.Random;

class OCourse {
    int[] road;
    int length;
    int width;
    String[] out = {"^", ".", "O"};
    Random rand = new Random();
    boolean player = false;
    int step;
    int posRunner;

    OCourse(int length, int width) {
        this.length = length;
        this.width = width;
        this.road = new int[length*width];
        this.step = length - 1;
        for(int i = 0; i < length*width - width; i += width) {
            road[i + rand.nextInt(width)] = -1;
        }
    }

    void initCourse(int pos) {
        assert pos >= 0 && pos < width : "Position has to be between 0 and " + (width - 1);
        assert !player : "Only 1 Runner on the Track allowed";
        road[(road.length - width) + pos] = 1;
        posRunner = (road.length - width) + pos;
        player = true;
    }

    boolean step() {
        if(step == 0) return false;

        if(road[posRunner - width] == -1) {
            if(posRunner % width == width-1) {
                road[posRunner - width - 1] = 1;
                posRunner = posRunner - width - 1;
            }
            else if(posRunner % width == 0) {
                road[posRunner - width + 1] = 1;
                posRunner = posRunner - width + 1;
            }
            else {
                int chooseSide = rand.nextInt(2);
                road[posRunner - width + (chooseSide == 0 ? -1 : 1)] = 1;
                posRunner = posRunner - width + (chooseSide == 0 ? -1 : 1);
            }
        } else {
            road[posRunner - width] = 1;
            posRunner = posRunner - width;
        }

        return true;
    }

    OCourse run() {
        assert player = true : "No Player set";
        while(step()) {
            step--;
        } 

        return this;
    }

    public String toString() {
        String s = "\n";
        for(int i = 0; i < road.length; i++) {
            s += i % width == width-1 ? out[road[i] + 1] + "\n" : out[road[i] + 1]; 
        }
        return s;
    }
}