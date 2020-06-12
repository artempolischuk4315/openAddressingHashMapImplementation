package hashMap;

public class HashMap {

     private final static int STARTER_CAPACITY=32;

     private int capacity;

     private int size=0;

     private final static double LOAD_FACTOR = 0.55;

     private Entry[] table;

    public HashMap() {

        this.capacity = STARTER_CAPACITY;

        table = new Entry[capacity];
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

        while ((table[index] != null) && table[index].getKey() != key) {
            index = (index + i*i)&(capacity-1);
            i++;
        }
        return index;
    }

    public void put(int key, long value) {

       int index = findCell(key);

        if (table[index] != null) {
            table[index].setValue(value);
            return;
        }

        if(size >= LOAD_FACTOR*capacity){
            resize();
            index = findCell(key);
        }

        table[index] = new Entry(key, value);
        size++;

   }

   public Long get(int key){
       int index =findCell(key);

       if (table[index] != null) {
           return table[index].getValue();
       } else {
           return null;
       }
   }

    public int getSize() {
        return size;
    }

    private void resize() {
        int oldCapacity = capacity;


        capacity = oldCapacity*2;

        Entry[] oldTable = table;

        table = new Entry[capacity];

        size =0;

        for(int i = 0; i < oldCapacity; i++){

            if(oldTable[i] != null){
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }
}
