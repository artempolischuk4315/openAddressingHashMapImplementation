package hashMap;

class Entry {

    private int key;

    private long value;

    Entry(int key, long value) {

        this.key = key;

        this.value = value;
    }

    long getValue() {

        return value;
    }

    void setValue(long value) {

        this.value = value;
    }

    int getKey() {

        return key;
    }
}