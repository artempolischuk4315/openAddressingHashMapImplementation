package hashMap;

public class HashMap {

     private final static int START_CAPACITY=32;

     private int capacity;

     private int size=0;

     private final static double LOAD_FACTOR = 0.55;

     private Entry[] table;

    public HashMap() {

        this.capacity = START_CAPACITY;

        table = new Entry[capacity];

    }

    private int hashFirst(int x) {
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = ((x >>> 16) ^ x) * 0x45d9f3b;
        x = (x >>> 16) ^ x; //https://stackoverflow.com/questions/664014/what-integer-hash-function-are-good-that-accepts-an-integer-hash-key
        return (x)&(capacity-1);
    }

    private int hashSecond(int x){
         return (x*31)&(capacity-1);
    }

    private int findCell(int key){

        int index = hashFirst(key);
       // System.out.println("Key = "+key +" hash = "+index);

        int delta = hashSecond(key);
        int i = 0;

        while ((table[index] != null) && table[index].getKey() != key) {
           // System.out.println("Enter ");
            index = (index + i*i)&(capacity-1);
            i++;
        }
       // System.out.println("Number of iters "+i);
       // System.out.println("-----------------");
        //System.out.println("Cell is "+index);
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

        //System.out.println("Old = " +oldCapacity);

        capacity = oldCapacity*2;

       // System.out.println("New = "+capacity);

        Entry[] oldTable = table;

        table = new Entry[capacity];

        size =0;

        for(int i = 0; i < oldCapacity; i++){
            if(oldTable[i] != null){
            //    System.out.println("RESIZE");
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }
        }
    }
}
