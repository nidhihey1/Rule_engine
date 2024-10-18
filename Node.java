public class Node {
    private String nodeType; // "operator" or "operand"
    private Node left;       // Reference to left child
    private Node right;      // Reference to right child (for operators)
    private String value;    // Optional value for operand nodes

    public Node(String nodeType, Node left, Node right, String value) {
        this.nodeType = nodeType;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    // Getters
    public String getNodeType() { return nodeType; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public String getValue() { return value; }
}
