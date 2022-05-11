public class Tree {
    private Node root;
    private int nodes = 0;

    public Tree(){
        this.root = null;
    }

    public void insert(String value){
        if(this.root == null){
            this.root = new Node(value, null);
        }else{
            Node p = this.root;
            while(p != null){
                if(p.value.compareTo(value) < 0){
                    if(p.next_L == null){p.next_L = new Node(value, p); break;}
                    p = p.next_L;
                }else{
                    if(p.next_H == null){p.next_H = new Node(value, p); break;}
                    p = p.next_H;
                }
            }
        }
        nodes++;
    }

    public void remove(String value){
        Node p = this.root;
        while(p != null){
            if(p.value == value){
                if(p.next_H == null){
                    Node p2 = p.next_L;
                    while(p2.next_H != null){
                        p2 = p2.next_H;
                    }
                    p.value = p2.value;
                    p.lista = p2.lista;
                    if(p.next_L == p2){p.next_L = null;}else{p2.root.next_H = p2.next_L;}
                }else{
                    Node p2 = p.next_H;
                    while(p2.next_L != null){
                        p2 = p2.next_L;
                    }
                    p.value = p2.value;
                    p.lista = p2.lista;
                    if(p.next_H == p2){p.next_H = null;}else{p2.root.next_L = p2.next_H;}
                }
                return;
            }else if(p.value.compareTo(value) < 0){
                p = p.next_L;
            }else{
                p = p.next_H;
            }
        }
        System.out.println("String nao encontrado");
    }

    public boolean search(String value){
        Node p = this.root;
        while(p != null){
            if(p.value == value){
                return true;
            }else if(p.value.compareTo(value) < 0){
                p = p.next_L;
            }else{
                p = p.next_H;
            }
        }
        return false;
    }

    public int height(){
        return (int)Math.pow(this.nodes, 0.5);
    }

    public void print_preorder(){System.out.print("Tree in pre-order: "); print_preorder(this.root); System.out.println("");}
    private void print_preorder(Node p){
        // recursive function
        if(p == null){return;}
        else{
            System.out.print(p.value + " ");
            print_preorder(p.next_L);
            print_preorder(p.next_H);
        }
    }

    public void print_inorder(){System.out.print("Tree in in-order: "); print_inorder(this.root); System.out.println("");}
    private void print_inorder(Node p){
        // recursive function
        if(p == null){return;}
        else{
            print_inorder(p.next_L);
            System.out.print(p.value + " ");
            print_inorder(p.next_H);
        }
    }

    public void print_postorder(){System.out.print("Tree in post-order: "); print_postorder(this.root); System.out.println("");}
    private void print_postorder(Node p){
        // recursive function
        if(p == null){return;}
        else{
            print_postorder(p.next_L);
            print_postorder(p.next_H);
            System.out.print(p.value + " ");
        }
    }
}
