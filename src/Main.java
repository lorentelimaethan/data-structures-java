class Main {
   // ===== Hash map =====
   public static void getFromMap(MyHashMap<String,Integer> map, String key) {
       Integer value = map.get(key);
       if(value != null) {
           System.out.println(key + ": " + value);
       } else {
           System.out.println(key + " not found");
       }
   }

   // ===== Binary tree =====
   public static void findAndDisplay(TreeNode node, int value) {
       if(node.findValue(value)) {
           System.out.println("Node with value " + value + " found!");
       } else {
           System.out.println("Node with value " + value + " not found!");
       }
   }
   
   public static boolean isSameTree(TreeNode p, TreeNode q) {
       if (p == null && q == null) {
           return true;
       }
       if (p == null || q == null) {
           return false;
       }
       if (p.getValue() != q.getValue()) {
           return false;
       }

       boolean sameLeft = isSameTree(p.getLeftNode(), q.getLeftNode());
       boolean sameRight = isSameTree(p.getRightNode(), q.getRightNode());
       return sameLeft && sameRight;
   }

   // ===== Linked list =====
   public static int findMiddleValue(MyLinkedList list) {
       if (list.size() == 0) {
           throw new IllegalStateException("List is empty");
       }
       return list.get(list.size() / 2);
   }

   public static boolean findValue(MyLinkedList list, int value) {
       MyLinkedList.Node current = list.getFirstNode();
       while (current != null) {
           if (current.getValue() == value) {
               return true;
           }
           current = current.getNext();
       }
       return false;
   }

   public static Integer findValueFromEnd(MyLinkedList list, int position) {
       if (position < 1) {
           return null;
       }

       MyLinkedList.Node slow = list.getFirstNode();
       MyLinkedList.Node fast = list.getFirstNode();

       for (int i = 0; i < position; i++) {
           if (fast == null) {
               return null;
           }
           fast = fast.getNext();
       }

       while (fast != null) {
           slow = slow.getNext();
           fast = fast.getNext();
       }

       return slow.getValue();
   }

   // ===== Array =====
   public static Integer findValue(MyArray array, int index) {
       if (index < 0 || index >= array.size()) {
           return null;
       }
       return array.get(index);
   }

   public static int findIndex(MyArray array, int value) {
       for (int i = 0; i < array.size(); i++) {
           if (array.get(i) == value) {
               return i;
           }
       }
       return -1;
   }

   public static int maxProfit(MyArray prices) {
       if (prices.size() == 0) {
           return 0;
       }

       int lowestPrice = prices.get(0);
       int bestProfit = 0;

       for (int i = 1; i < prices.size(); i++) {
           if (prices.get(i) < lowestPrice) {
               lowestPrice = prices.get(i);
           } else if (prices.get(i) - lowestPrice > bestProfit) {
               bestProfit = prices.get(i) - lowestPrice;
           }
       }
       return bestProfit;
   }

   // ===== Examples and tests =====
   public static void main(String[] args) {
       // ----- Hash map -----
       MyHashMap<String, Integer> map = new MyHashMap();
       
       map.put("Apple", 10);
       map.put("Apple1", 11);
       map.put("Apple", 12);
       map.put("Banana", 20);
       
       getFromMap(map, "Apple");
       getFromMap(map, "Apple1");
       getFromMap(map, "Banana");
       getFromMap(map, "Kiwi");
       
       System.out.println("Done!");

       // ----- Binary tree -----
       TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
       TreeNode node2 = new TreeNode(8);
       node2.addLeftNode(3);
       node2.addRightNode(10);
       
       findAndDisplay(node2, 10);
       findAndDisplay(node2, 5);
       
       boolean sameTree = isSameTree(node1, node2);
       
       System.out.println("Same tree: " + sameTree);
       
       
       System.out.println("Done!");

       // ----- Linked list -----
       MyLinkedList oddList = new MyLinkedList();
       oddList.add(1);
       oddList.add(2);
       oddList.add(3);
       oddList.add(2);
       oddList.add(1);
       System.out.println("Middle of 1,2,3,2,1 (expected 3): " + findMiddleValue(oddList));
       System.out.println("Find 3 in 1,2,3,2,1 (expected true): " + findValue(oddList, 3));
       System.out.println("Find 9 in 1,2,3,2,1 (expected false): " + findValue(oddList, 9));
       System.out.println("Second value from end (expected 2): " + findValueFromEnd(oddList, 2));
       System.out.println("Last value (expected 1): " + findValueFromEnd(oddList, 1));

       MyLinkedList evenList = new MyLinkedList();
       evenList.add(1);
       evenList.add(2);
       evenList.add(2);
       evenList.add(1);
       System.out.println("Middle of 1,2,2,1 (expected 2): " + findMiddleValue(evenList));
       System.out.println("Fourth value from end (expected 1): " + findValueFromEnd(evenList, 4));
       System.out.println("Fifth value from end (expected null): " + findValueFromEnd(evenList, 5));

       MyLinkedList differentList = new MyLinkedList();
       differentList.add(1);
       differentList.add(2);
       differentList.add(3);
       System.out.println("Find 2 in 1,2,3 (expected true): " + findValue(differentList, 2));
       System.out.println("Find 2 in empty list (expected false): " + findValue(new MyLinkedList(), 2));
       System.out.println("Value from end of empty list (expected null): " + findValueFromEnd(new MyLinkedList(), 1));

       // ----- Array -----
       MyArray numbers = new MyArray();
       numbers.add(2);
       numbers.add(7);
       numbers.add(11);
       numbers.add(15);
       System.out.println("Value at index 0 (expected 2): " + findValue(numbers, 0));
       System.out.println("Value at index 3 (expected 15): " + findValue(numbers, 3));
       System.out.println("Value at index 8 (expected null): " + findValue(numbers, 8));
       System.out.println("Index of 11 (expected 2): " + findIndex(numbers, 11));
       System.out.println("Index of 99 (expected -1): " + findIndex(numbers, 99));

       MyArray repeatedNumbers = new MyArray();
       repeatedNumbers.add(3);
       repeatedNumbers.add(3);
       System.out.println("First index of 3 (expected 0): " + findIndex(repeatedNumbers, 3));
       System.out.println("Index in empty array (expected -1): " + findIndex(new MyArray(), 3));

       MyArray pricesWithProfit = new MyArray();
       pricesWithProfit.add(7);
       pricesWithProfit.add(1);
       pricesWithProfit.add(5);
       pricesWithProfit.add(3);
       pricesWithProfit.add(6);
       pricesWithProfit.add(4);
       System.out.println("Profit from 7,1,5,3,6,4 (expected 5): " + maxProfit(pricesWithProfit));

       MyArray fallingPrices = new MyArray();
       fallingPrices.add(7);
       fallingPrices.add(6);
       fallingPrices.add(4);
       fallingPrices.add(3);
       fallingPrices.add(1);
       System.out.println("Profit from 7,6,4,3,1 (expected 0): " + maxProfit(fallingPrices));
       System.out.println("Profit from empty array (expected 0): " + maxProfit(new MyArray()));
   }
}
