import hashMap.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WorkTest {

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

        int actual = systemUnderTest.getSize();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void getSizeShouldReturnNumberOfAddedElements(){

        for(int i=0; i<NUMBER_OF_ELEMENTS; i++){
            systemUnderTest.put(i, i);
        }

        int actual = systemUnderTest.getSize();
        int expected = NUMBER_OF_ELEMENTS;

        assertEquals(expected, actual);
    }

    @Test
    void hashMapShouldSuccessfullyAddMillionElements(){

        for(int i = 0; i< MILLION; i++){
            systemUnderTest.put(i, new Random().nextLong());
        }

        int actualSize = systemUnderTest.getSize();
        int expectedSize = MILLION;

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
}
