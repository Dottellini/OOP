class Roll {
    Roll next;
    Roll previous;
}

class RQueue {
    Roll head, tail;

    void add(Roll r) {
        if(tail == null && head == null) {
            head = r;
        } else {
            r.next = tail;
            tail.previous = r;
        }

        tail = r;
    }

    Roll remove() {
        Roll removedElement = head;
        if(head == tail) {
            head = null;
            tail = null;
            return removedElement;
        };
        head = head.previous;
        head.next = null;

        return removedElement;
    }
}
