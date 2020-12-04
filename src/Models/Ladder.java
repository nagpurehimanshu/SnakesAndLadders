package Models;

public class Ladder {
    int tail;
    int head;

    public Ladder(int tail, int head) {
        this.tail = tail;
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }
}
