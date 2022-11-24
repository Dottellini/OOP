import java.util.Random;

class Creature {
    int vitality;
    boolean lovely;
    String name;

    static Random rand = new Random();

    int counter = 0;
    Creature[] parentOf = new Creature[5];

    Creature(String name) {
        this.name = name;
        this.vitality = rand.nextInt(101);
        this.lovely = true;
    }

    Creature(String name, boolean lovely, int vitality) {
        assert vitality <= 100 && vitality >= 0;
        this.name = name;
        this.lovely = lovely;
        this.vitality = vitality;
    }

    boolean canJoin(Creature other) {
        if(this.counter >= 5) return false;
        if(this.vitality < 50 || other.vitality < 50) return false;
        return true;
    }

    void reduceVitality(int n) {
        this.vitality = this.vitality > n ? this.vitality - n : 0;
    }

    void join(Creature partner) {
        assert canJoin(partner) : "join not possible";

        String childName = this.name + " " + partner.name;
        boolean childLovely = this.lovely && partner.lovely ? true : (!this.lovely && !partner.lovely ? false : (rand.nextInt(2) == 0 ? true : false));
        int childVitality = (int)(this.vitality + partner.vitality)/2;

        this.reduceVitality(33);

        Creature child = new Creature(childName, childLovely, childVitality);
        parentOf[counter++] = child;
        
    }

    String creatureString(Creature c) {
        return c.name + "(" + (c.lovely ? "lovely" : "unlovely") + ", " + c.vitality + ")";
    }

    public String toString() {
        String s = creatureString(this);
        
        //This loop make s empty for some reason
        for(int i = 0; i <= counter; i++) {
            s += "\nparent of " + creatureString(parentOf[i]);
        }
    
        return s;
    }
    
}