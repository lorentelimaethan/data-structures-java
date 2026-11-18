import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {
    @Test
    void shouldFindExistingValue() {
        TreeNode tree = new TreeNode(8);
        tree.addRightNode(10);

        boolean found = tree.findValue(10);

        assertEquals(true, found);
    }

    @Test
    void shouldNotFindMissingValue() {
        TreeNode tree = new TreeNode(8);
        tree.addLeftNode(3);

        boolean found = tree.findValue(5);

        assertEquals(false, found);
    }

    @Test
    void shouldReturnTrueForSameTrees() {
        TreeNode first = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode second = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        boolean same = Main.isSameTree(first, second);

        assertEquals(true, same);
    }

    @Test
    void shouldReturnFalseForDifferentValues() {
        TreeNode first = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode second = new TreeNode(1, new TreeNode(2), new TreeNode(4));

        boolean same = Main.isSameTree(first, second);

        assertEquals(false, same);
    }

    @Test
    void shouldReturnFalseForDifferentShapes() {
        TreeNode first = new TreeNode(1, new TreeNode(2), null);
        TreeNode second = new TreeNode(1, null, new TreeNode(2));

        boolean same = Main.isSameTree(first, second);

        assertEquals(false, same);
    }

    @Test
    void shouldReturnTrueWhenBothTreesAreNull() {
        boolean same = Main.isSameTree(null, null);

        assertEquals(true, same);
    }

    @Test
    void shouldReturnFalseWhenOnlyOneTreeIsNull() {
        TreeNode tree = new TreeNode(1);

        boolean same = Main.isSameTree(tree, null);

        assertEquals(false, same);
    }
}
