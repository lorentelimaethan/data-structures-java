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

}
