import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayTest {
    private MyArray numbers;

    @BeforeEach
    void setUp() {
        numbers = new MyArray();
        numbers.add(2);
        numbers.add(7);
        numbers.add(11);
        numbers.add(15);
    }

    @Test
    void shouldFindValueAtIndex() {
        Integer value = Main.findValue(numbers, 3);

        assertEquals(15, value);
    }

    @Test
    void shouldReturnNullForInvalidIndex() {
        Integer value = Main.findValue(numbers, 8);

        assertEquals(null, value);
    }

    @Test
    void shouldFindIndexOfValue() {
        int index = Main.findIndex(numbers, 11);

        assertEquals(2, index);
    }

    @Test
    void shouldReturnMinusOneForMissingValue() {
        int index = Main.findIndex(numbers, 99);

        assertEquals(-1, index);
    }

    @Test
    void shouldFindFirstIndexForRepeatedValue() {
        MyArray repeated = new MyArray();
        repeated.add(3);
        repeated.add(3);

        int index = Main.findIndex(repeated, 3);

        assertEquals(0, index);
    }

    @Test
    void shouldCalculateProfitWhenPricesRise() {
        MyArray prices = new MyArray();
        prices.add(7);
        prices.add(1);
        prices.add(5);
        prices.add(3);
        prices.add(6);
        prices.add(4);

        int profit = Main.maxProfit(prices);

        assertEquals(5, profit);
    }

    @Test
    void shouldReturnZeroWhenPricesOnlyFall() {
        MyArray prices = new MyArray();
        prices.add(7);
        prices.add(6);
        prices.add(4);
        prices.add(3);
        prices.add(1);

        int profit = Main.maxProfit(prices);

        assertEquals(0, profit);
    }

    @Test
    void shouldReturnZeroForEmptyPrices() {
        MyArray prices = new MyArray();

        int profit = Main.maxProfit(prices);

        assertEquals(0, profit);
    }

    @Test
    void shouldGrowWhenMoreThanTenValuesAreAdded() {
        MyArray array = new MyArray();
        for (int i = 0; i < 11; i++) {
            array.add(i);
        }

        int lastValue = array.get(10);

        assertEquals(10, lastValue);
    }
}
