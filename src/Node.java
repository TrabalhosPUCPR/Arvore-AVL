import Lista.Lista;

public class Node {
    Node root;
    Node next_H;
    Node next_L;

    int height;

    String value;
    //int value;
    Lista lista;

    public Node(String value){
        this.value = value;
        this.height = 1;
        this.lista = new Lista();
    }
    public Node(String value, Lista lista){
        this.value = value;
        this.height = 1;
        this.lista = lista;
    }
    public Node(String value, String fileTitle){
        this.value = value;
        this.height = 1;
        this.lista = new Lista();
        this.lista.add(1, fileTitle);
    }

    void updateHeight(){
        if(this.next_H != null && this.next_L == null){
            this.height = this.next_H.height + 1;
        }else if(this.next_H == null && this.next_L != null){
            this.height = this.next_L.height + 1;
        }else if(this.next_H != null && this.next_L != null){
            if(this.next_H != null && this.next_H.height > this.next_L.height){
                this.height = this.next_H.height + 1;
            }else if(this.next_L != null && this.next_H.height < this.next_L.height){
                this.height = this.next_H.height + 1;
            }
        }else{
            this.height = 1;
        }
        for(Node p = this.root; p != null; p = p.root){
            p.updateHeight();
        }
    }
    public void equalize(Node p){
        this.value = p.value;
        this.lista = p.lista;
    }

    private static int balance(Node p){
        if(p != null){
            return height(p.next_L) - height(p.next_H);
        }
        return 0;
    }

    private static int height(Node p){
        if(p != null){return p.height;}
        return 0;
    }

    static Node rotate(Node p){
        while(p != null){
            int balance = balance(p);
            if(balance > 1){
                if(balance(p.next_L) < 0){
                    p.next_L = leftRotate(p.next_L);
                }
                p = rightRotate(p);
                if(p.root != null){p.root.next_H = p;}
            }
            else if(balance < -1){
                if(balance(p.next_H) > 0){
                    p.next_H = rightRotate(p.next_H);
                }
                p = leftRotate(p);
                if(p.root != null){p.root.next_L = p;}
            }
            if(p.root == null){return p;}
            p = p.root;
        }
        return null;
    }

    static Node leftRotate(Node p){
        Node aux = p.next_H;
        Node aux2 = aux.next_L;
        aux.next_L = p;
        aux.root = p.root;
        p.root = aux;
        p.next_H = aux2;
        p.updateHeight();
        aux.updateHeight();
        return aux;
    }
    static Node rightRotate(Node p){
        Node aux = p.next_L;
        Node aux2 = aux.next_H;
        aux.next_H = p;
        aux.root = p.root;
        p.root = aux;
        p.next_L = aux2;
        p.updateHeight();
        aux.updateHeight();
        return aux;
    }

    public Lista getLista(){return this.lista;}
}
