package hashMap;

import java.util.Arrays;

public class HashMap {

    private final static int STARTER_CAPACITY=32;
    private static final int RESIZE_COEF = 2;
    private final static int EMPTY_CELL = Integer.MIN_VALUE;
    private final static double LOAD_FACTOR = 0.55;

    private int capacity;
    private int size = 0;

    private int[] keys;
    private long[] values;

    public HashMap() {

        this.capacity = STARTER_CAPACITY;

        createKeyValuesArrays();
    }

    private int hashFirst(int x) {
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = (x >>> 16) ^ x;
        return (x)&(capacity-1);
    }

    private int findCell(int key){

        int index = hashFirst(key);

        int i = 0;

        while ((keys[index] != EMPTY_CELL) && keys[index] != key) {
            index = (index + i*i)&(capacity-1);
            i++;
        }
        return index;
    }

    public void put(int key, long value) {

       int index = findCell(key);

        if (keys[index] != EMPTY_CELL) {
            values[index] = value;
            return;
        }

        if(size >= LOAD_FACTOR*capacity){
            resize();
            index = findCell(key);
        }

        keys[index] = key;
        values[index] = value;
        size++;

   }

   public Long get(int key){
       int index = findCell(key);

       if (keys[index] != EMPTY_CELL) {
           return values[index];
       } else {
           return null;
       }
   }

    private void resize() {

        int oldCapacity = capacity;
        capacity = oldCapacity * RESIZE_COEF;

        int[] oldKeys = keys;
        long[] oldValues = values;

        createKeyValuesArrays();

        size = 0;

        for(int i = 0; i < oldCapacity; i++){
            if(oldKeys[i] != EMPTY_CELL){
                put(oldKeys[i], oldValues[i]);
            }
        }
    }

    private void createKeyValuesArrays() {
        keys = new int[capacity];
        values = new long[capacity];
        Arrays.fill(keys, EMPTY_CELL);
    }

    public int getSize() {
        return size;
    }
}
