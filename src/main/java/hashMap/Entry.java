package hashMap;

public class Entry {

    private int key;

    private long value;

    Entry(int key, long value) {

        this.key = key;

        this.value = value;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getValue() {

        return value;
    }

    public void setValue(long value) {

        this.value = value;
    }

    public int getKey() {

        return key;
    }
}