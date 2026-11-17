public class TreeNode{
       private int value; 
       private TreeNode leftNode;
       private TreeNode rightNode; 
       
       public TreeNode(int value, TreeNode leftNode, TreeNode rightNode){
           this.value = value; 
           this.leftNode = leftNode; 
           this.rightNode = rightNode; 
       }
       
       public TreeNode(int value){
           this.value = value; 
           this.leftNode = null; 
           this.rightNode = null; 
       }
       
       public void addLeftNode(int leftValue){
           this.leftNode = new TreeNode(leftValue); 
       }
       
       public void addRightNode(int rightValue){
           this.rightNode = new TreeNode(rightValue);
       }
       
       public boolean findValue(int requestedValue){
           return findNodeValue(this, requestedValue);
       }

       public int getValue() {
           return value;
       }

       public TreeNode getLeftNode() {
           return leftNode;
       }

       public TreeNode getRightNode() {
           return rightNode;
       }
       
       private boolean findNodeValue(TreeNode node, int value) {
           if(node == null) {
               return false;
           }
           if(node.value == value) {
               return true;
           }
           return findNodeValue(node.leftNode, value) || findNodeValue(node.rightNode, value);
       }
}
