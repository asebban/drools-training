package ma.medtech.drools.model;

public class Counter {
    private int value;

    public Counter(int value) { this.value = value; }
    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    @Override
    public String toString() {
        return "Counter{" + "value=" + value + '}';
    }
}

