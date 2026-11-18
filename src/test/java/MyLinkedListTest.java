import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyLinkedListTest {
    private MyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
    }

    @Test
    void shouldFindMiddleValueInOddList() {
        int middle = Main.findMiddleValue(list);

        assertEquals(3, middle);
    }

    @Test
    void shouldFindSecondMiddleValueInEvenList() {
        MyLinkedList evenList = new MyLinkedList();
        evenList.add(1);
        evenList.add(2);
        evenList.add(3);
        evenList.add(4);

        int middle = Main.findMiddleValue(evenList);

        assertEquals(3, middle);
    }

    @Test
    void shouldThrowWhenFindingMiddleOfEmptyList() {
        MyLinkedList emptyList = new MyLinkedList();

        assertThrows(IllegalStateException.class, () -> Main.findMiddleValue(emptyList));
    }

    @Test
    void shouldFindExistingValue() {
        boolean found = Main.findValue(list, 3);

        assertEquals(true, found);
    }

    @Test
    void shouldNotFindMissingValue() {
        boolean found = Main.findValue(list, 9);

        assertEquals(false, found);
    }

    @Test
    void shouldNotFindValueInEmptyList() {
        MyLinkedList emptyList = new MyLinkedList();

        boolean found = Main.findValue(emptyList, 2);

        assertEquals(false, found);
    }

    @Test
    void shouldFindSecondValueFromEnd() {
        Integer value = Main.findValueFromEnd(list, 2);

        assertEquals(2, value);
    }

    @Test
    void shouldFindLastValue() {
        Integer value = Main.findValueFromEnd(list, 1);

        assertEquals(1, value);
    }

    @Test
    void shouldReturnNullWhenPositionIsTooLarge() {
        Integer value = Main.findValueFromEnd(list, 6);

        assertEquals(null, value);
    }

    @Test
    void shouldReturnNullWhenListIsEmpty() {
        MyLinkedList emptyList = new MyLinkedList();

        Integer value = Main.findValueFromEnd(emptyList, 1);

        assertEquals(null, value);
    }
}
