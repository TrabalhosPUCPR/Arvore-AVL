import Lista.Lista;

public class Node {
    Node root;
    Node next_H;
    Node next_L;

    String value;
    Lista lista;

    public Node(String value, Node root){
        this.value = value;
        this.root = root;
        this.next_L = null;
        this.next_H = null;
        this.lista = new Lista();
    }

    public Lista getLista(){return this.lista;}
}
