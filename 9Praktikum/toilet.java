import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;

//Not finished

class Roll {
    boolean emptied = false;

    boolean isEmpty() {
        return emptied;
    }

    void use() {
        emptied = true;
    }
}

class Spender {
    ConcurrentLinkedQueue<Roll> queue = new ConcurrentLinkedQueue<>();

    boolean add(Roll roll) {
        queue.add(roll);
        return true;
    }

    Roll remove() {
        return queue.remove();
    }
}
