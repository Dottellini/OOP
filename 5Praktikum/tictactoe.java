int[] board;
char[] markers;
String field;


//Logik Funktionen
///////////////////////////////////////////////////////////////////////////////////

//Check if board is valid
boolean isValid(int[] board) {
    if(board.length != 9) return false;
    for(int e: board) {
        if(e < -1 || e > 1) return false;
    }
    return true;
}

//print board to console
void printBoard(int[] board) {
    assert isValid(board): "invalid board";
    field = board2String(board, markers);
    for(int i = 0; i < field.length(); i++) {
        System.out.print(i % 3 != 2 ? field.charAt(i) : field.charAt(i) + "\n");
    }
}

//returns board in a String
String board2String(int[] board, char[] symbol) {
    assert isValid(board);
    assert symbol.length == 3;
    String s = "";
    for(int i = 0; i < board.length; i++) {
        s += symbol[board[i] + 1];
    }
    return s;
}


//Spiel Funktionen
///////////////////////////////////////////////////////////////////////////////////

//Place a marker on the board using Player and the position you want to place
void place(int player, int pos) {
    assert player >= 1 && player <= 2: "Invalid player. Use: 1 or 2"; 
    assert pos >= 0 && pos <= 8: "Invalid position. Places 0-8 are Valid";
    assert board[pos] != -1 && board[pos] != 1: "Position not empty";

    board[pos] = player == 1 ? -1 : 1;
    printBoard(board);
}

//Print the current board
void print() {
    printBoard(board);
}

//Clear the board
void clearBoard() {
    board = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    print();
}


//Set Variables to avoid jshell error when first loading file
board = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
markers = new char[]{'O', '.', 'X'};
field = board2String(board, markers);

assert isValid(new int[]{0, 1, -1, 0}) == false;
assert isValid(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}) == true;
assert isValid(new int[]{0, 2, 1, -3, 0, 0, 0, 1, 5}) == false;

assert board2String(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, new char[]{'A', 'B', 'C'}).equals("BBBBBBBBB");
assert board2String(new int[]{0, 1, 0, -1, 0, 1, 0, 0, -1}, new char[]{'A', 'B', 'C'}).equals("BCBABCBBA");
assert !board2String(new int[]{0, 1, 0, -1, 0, 1, 0, 0, -1}, new char[]{'A', 'B', 'C'}).equals("ABSEFA");
