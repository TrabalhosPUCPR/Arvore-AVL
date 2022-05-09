public class Tree {
    Node root;

    public Tree(){
        this.root = null;
    }

    public void insert(int value){
        if(this.root == null){
            this.root = new Node(value, null);
        }else{
            Node p = this.root;
            do{
                if(p.value > value){
                    if(p.next_L == null){p.next_L = new Node(value, p); break;}
                    p = p.next_L;
                }else{
                    if(p.next_H == null){p.next_H = new Node(value, p); break;}
                    p = p.next_H;
                }
            }while(p != null);
        }
    }

    public void print_preorder(){System.out.print("Tree in pre-order: "); print_preorder(this.root);}
    private void print_preorder(Node p){
        // recursive function
        if(p == null){return;}
        else{
            System.out.print(p.value + " ");
            print_preorder(p.next_L);
            print_preorder(p.next_H);
        }
    }
}
