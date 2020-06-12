import hashMap.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestClass {

    private static final int NUMBER_OF_ELEMENTS =257;
    private static final int KEY = 1;
    private static final int OTHER_KEY = 100;
    private static final long VALUE = 2135214;
    private static final long OTHER_VALUE = 34213;
    private static final int MILLION = 1000000;

    private  HashMap systemUnderTest;

    @BeforeEach
    void init(){
         systemUnderTest = new HashMap();
    }

    @Test
    void getSizeShouldReturnZeroIfSizeIsZero(){


        int expected = systemUnderTest.getSize();
        int actual = 0;

        assertEquals(expected, actual);
    }

    @Test
    void getSizeShouldReturnNumberOfAddedElements(){

        for(int i=0; i<NUMBER_OF_ELEMENTS; i++){
            systemUnderTest.put(i, i);
        }

        int expected = systemUnderTest.getSize();
        int actual = NUMBER_OF_ELEMENTS;

        assertEquals(expected, actual);
    }

    @Test
    void hashMapShouldSuccessfullyAddMillionElements(){

        for(int i = 0; i< MILLION; i++){
            systemUnderTest.put(i, new Random().nextLong());
        }

        int expectedSize = systemUnderTest.getSize();
        int actualSize = MILLION;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void sizeShouldIncreaseAfterAddingNewElement(){

        int  actualSize = systemUnderTest.getSize();

        assertEquals(0,  actualSize);

        systemUnderTest.put(KEY, VALUE);
        actualSize = systemUnderTest.getSize();

        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void sizeShouldNotIncreaseAfterAddingExistingElement(){

        systemUnderTest.put(KEY, VALUE);

        int actualSize = systemUnderTest.getSize();

        assertEquals(1, actualSize);

        systemUnderTest.put(KEY, VALUE);

        actualSize = systemUnderTest.getSize();

        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void valueShouldChangeAfterAddingAlreadyExistingElementWithNewValue(){

        systemUnderTest.put(KEY, VALUE);

        long actualValue = systemUnderTest.get(KEY);
        long expectedValue = VALUE;

        assertEquals(expectedValue, actualValue);

        systemUnderTest.put(KEY, OTHER_VALUE);

        actualValue = systemUnderTest.get(KEY);
        expectedValue = OTHER_VALUE;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getShouldReturnElementIfElementInHashMap(){

        systemUnderTest.put(KEY, VALUE);

        long expected = VALUE;
        long actual = systemUnderTest.get(KEY);

        assertEquals(expected, actual);
    }

    @Test
    void getShouldReturnNullIfElementNotInHashMap(){

        systemUnderTest.put(KEY, VALUE);

        assertNull(systemUnderTest.get(OTHER_KEY));
    }

    @Test
    void getShouldReturnElementAfterResizingIfElementInHashMap(){

        systemUnderTest.put(KEY, VALUE);

        for(int i=0; i<NUMBER_OF_ELEMENTS; i++){
            systemUnderTest.put(new Random().nextInt(), i);
        }

        long expected = VALUE;
        long actual = systemUnderTest.get(KEY);

        assertEquals(expected, actual);
    }


   /* @Test
    void test2() {
        Map<Integer, Long> hashMap = new java.util.HashMap<Integer, Long>();

        for(int i=0; i<10000000; i++) {
            hashMap.put(i*23, (long)i);
        }
       /* for(long i =0; i<1000; i++) {
            int kek =new Random().nextInt();
            Long lol = hashMap.get(kek);
            if(lol!=null)
                System.out.println(lol);
        }*/
      /*  System.out.println(hashMap.size());
    }*/

   /* @Test
    void test() {
        HashMap hashMap = new HashMap();

        for(int i =1; i<=100000; i++) {
            hashMap.put(i*23, i);
        }
        System.out.println(hashMap.getSize());
    }

    @Test
    void test3() {
        HashMap hashMap = new HashMap();

        for(long i =0; i<10000000; i++) {
            hashMap.put(new Random().nextInt(), new Random().nextInt());
        }
        for(long i =0; i<10000000; i++) {
            int kek =new Random().nextInt();
            Long lol = hashMap.get(kek);
            if(lol!=null)
            System.out.println(lol);
        }
    }

    @Test
    void test4() {
        HashMap hashMap = new HashMap();

        for(int i=0; i<10000000; i++) {
            hashMap.put(i, i);

        }
        for(int i =0; i<10000000; i++) {

            Long lol = hashMap.get(i);
            if(lol!=null)
                System.out.println(lol);
        }
    }*/
}
