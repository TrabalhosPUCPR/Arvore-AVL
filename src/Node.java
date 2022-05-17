import Lista.Lista;

public class Node {
    Node root;
    Node leftBranch;
    Node rightBranch;

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
        if(this.rightBranch != null && this.leftBranch == null){
            this.height = this.rightBranch.height + 1;
        }else if(this.rightBranch == null && this.leftBranch != null){
            this.height = this.leftBranch.height + 1;
        }else if(this.rightBranch != null && this.leftBranch != null){
            if(this.rightBranch != null && this.rightBranch.height > this.leftBranch.height){
                this.height = this.rightBranch.height + 1;
            }else if(this.leftBranch != null && this.rightBranch.height < this.leftBranch.height){
                this.height = this.rightBranch.height + 1;
            }
        }else{
            this.height = 1;
        }
        for(Node node = this.root; node != null; node = node.root){
            node.updateHeight();
        }
    }
    public void equalize(Node node){
        this.value = node.value;
        this.lista = node.lista;
    }

    private static int balance(Node node){
        if(node != null){
            return height(node.leftBranch) - height(node.rightBranch);
        }
        return 0;
    }

    private static int height(Node node){
        if(node != null){return node.height;}
        return 0;
    }

    static Node rotate(Node node){
        while(node != null){
            int balance = balance(node);
            if(balance > 1){
                if(balance(node.leftBranch) < 0){
                    node.leftBranch = leftRotate(node.leftBranch);
                }
                node = rightRotate(node);
                if(node.root != null){node.root.rightBranch = node;}
            }
            else if(balance < -1){
                if(balance(node.rightBranch) > 0){
                    node.rightBranch = rightRotate(node.rightBranch);
                }
                node = leftRotate(node);
                if(node.root != null){node.root.leftBranch = node;}
            }
            if(node.root == null){return node;}
            node = node.root;
        }
        return null;
    }

    static Node leftRotate(Node node){
        Node right = node.rightBranch;
        Node center = right.leftBranch;
        right.leftBranch = node;
        right.root = node.root;
        node.root = right;
        node.rightBranch = center;
        node.updateHeight();
        right.updateHeight();
        return right;
    }
    static Node rightRotate(Node node){
        Node left = node.leftBranch;
        Node center = left.rightBranch;
        left.rightBranch = node;
        left.root = node.root;
        node.root = left;
        node.leftBranch = center;
        node.updateHeight();
        left.updateHeight();
        return left;
    }

    public Lista getLista(){return this.lista;}
}
