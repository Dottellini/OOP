class TTT { 
    int[] board = new int[9];
    int turn = 1;
    char[] symbol = new char[]{'X', '.', 'O'};  
    int[] history = new int[board.length];
    int moves = 0;

    TTT() {}

    TTT(char[] symbol) {
        assert symbol.length == 3;
        this.symbol = symbol;
    }

    //make multiple moves
    void makeMove(int... pos) {
        assert pos != null;
        for(int i: pos) {
            makeMove(i);
        }
    } 
    
    //make songle move
    boolean makeMove(int pos) {
        assert pos >= 0 && pos <= 8 : "Move out of board boundries";
        if(board[pos] != 0) return false;
        board[pos] = this.turn;

        if(threeInRow()) System.out.println((turn == 1 ? "Player 1 " : "Player 2 ") + "won!");

        this.turn = -this.turn;
        this.history[moves] = pos;
        moves++;
        return true;
    }

    //returns positions of not used slots
    int[] getMoves() {
        int[] res = new int[countFreeSlots()];
        int j = 0;

        for(int i = 0; i < board.length; i++) {
            if(board[i] == 0) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }

    //undo one move
    boolean undoMove() {
        if(moves <= 0) return false;
        history[moves] = 0;
        board[history[--moves]] = 0;
        turn = -turn;

        return true;
    }

    //counts amount of not used slots
    int countFreeSlots() {
        return board.length - moves;
    }

    //Check for win condition
    boolean threeInRow() {
        int[][] winConditions = {{0, 1, 2}, {3, 4, 5}, {0, 4, 8}, {2, 4, 6}, {6, 7, 8}, {1, 4, 7}, {2, 5, 8}, {0, 3, 6}};

        for(int[] row: winConditions) {
            if(board[row[0]] + board[row[1]] + board[row[2]] == 3 || board[row[0]] + board[row[1]] + board[row[2]] == -3) return true;
        }

        return false;
    }

    public String toString() {
        String s = "\n";
        for(int i = 0; i < board.length; i++) {
            s += i % 3 != 2 ? symbol[board[i] + 1] : symbol[board[i] + 1] + "\n";
        }
        return s;
    }
}
