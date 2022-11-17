/* OOP: Test Nr. 2 (VW6)

Der Test schließt an Tic-Tac-Toe an. Dieser Code hier muss jedoch eigenständig
laufen. Ergänzen Sie an den geforderten Stellen Ihre Implementierung. Die Tests
können Sie als weitere Hinweisgeber verstehen, was Sie implementieren sollen.

Alle Tests müssen erfolgreich durchlaufen. Es MUSS ein Ablauf durch die
JShell erfolgen. Vergessen Sie nicht den Aufruf mit dem Argument -R-ea.
*/

// Die Methode vergleicht zwei Arrays auf Gleichheit

boolean isEqual(int[] arrayA, int[] arrayB) {
    return arrayA.equals(arrayB);
}

// Die Methode rotiert ein Tic-Tac-Toe-Spielbrett um 90° nach rechts.
// Verwenden Sie bitte ein zweidimensionales int-Array als Datenstruktur,
// das die von/nach-Positionsdaten der Rotation enthält. 

int[] rot(int[] board) { // rotate 90° to the right
    int[] fromTo = new int[9][2];
}

// Die Methode überprüft, ob zwei Spielpositionen sich als gleich erweisen,
// wenn man die Rotation mit berücksichtigt.
// Zählen Sie im Rumpf auf keinerlei Weise die Anzahl der Rotationen mit.

boolean isRotEqual(final int[] boardA, final int[] boardB) {
    // IHRE IMPLEMENTIERUNG
}