public class Element {
    Element root;
    Element next_H;
    Element next_L;

    int value;

    public Element(int value, Element root){
        this.value = value;
        this.root = root;
        this.next_L = null;
        this.next_H = null;
    }

    public void insert_H(Element n){
        this.next_H = n;
    }
    public void insert_L(Element n){
        this.next_L = n;
    }
}
