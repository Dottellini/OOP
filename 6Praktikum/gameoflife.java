class Game {
    int[] world = new int[]{};
    boolean init = false;
    int alive = 0;
    int fullSize = 0;

    Game(int size, int... life) {
        assert size > 0;
        assert life.length > 0;

        world = new int[(size+2) * (size+2)];
        fullSize = size+2;
        init = true;
        alive = 0;

        for(int e: life) {
            assert e > fullSize && e < world.length-fullSize && e % fullSize != 0 && e % fullSize-1 != 0 : "Life not in playing field";
        }

        for(int e: life) {
            world[e] = 1;
            alive++;    
        }
    }

    void calcLife() {
        for(int i = fullSize; i < world.length - fullSize - 1; i++) {
            if(i%fullSize == 0 || i%fullSize-1 == 0) continue;
            int neighbors = 0; //amount of Alive neighbors
            if(world[i-fullSize-1] == 1) neighbors++;
            if(world[i-fullSize] == 1) neighbors++;
            if(world[i-fullSize+1] == 1) neighbors++;
            if(world[i-1] == 1) neighbors++;
            if(world[i+1] == 1) neighbors++;
            if(world[i+fullSize-1] == 1) neighbors++;
            if(world[i+fullSize] == 1) neighbors++;
            if(world[i+fullSize+1] == 1) neighbors++;

            //check if alive and has 2 or 3 neighors -> stays alive
            if((neighbors == 3 || neighbors == 2 ) && world[i] == 1) continue;

            //check if has 3 neighbors and is dead -> becomes alive
            if(neighbors == 3 && world[i] == 0) {
                world[i] = 1;
                alive++;
            }

            //Check if is alive and because none of the above was true -> dies
            if(world[i] == 1) {
                world[i] = 0;
                alive--;
            }

        }
    }

    void startGame() {
        assert init && alive > 0;
        do {
            //Timeout
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            //World printing
            for(int i = 0; i < world.length; i++){
                if(i%fullSize == 0) System.out.println();
                System.out.print(world[i] + " ");
            }
            System.out.println(); //Linebreak after printing full board
            System.out.println("Number of Alive fields: " + alive + "\n");
            this.calcLife();
            
        } while(alive > 0);

    }

}