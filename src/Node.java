public class Node {
    Node root;
    Node next_H;
    Node next_L;

    int value;

    public Node(int value, Node root){
        this.value = value;
        this.root = root;
        this.next_L = null;
        this.next_H = null;
    }
}
