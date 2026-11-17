public class MyArray {
    private int[] values = new int[10];
    private int size;

    public void add(int value) {
        if (size == values.length) {
            int[] biggerArray = new int[values.length * 2];
            for (int i = 0; i < values.length; i++) {
                biggerArray[i] = values[i];
            }
            values = biggerArray;
        }

        values[size] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return values[index];
    }

    public int size() {
        return size;
    }
}
