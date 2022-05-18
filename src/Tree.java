import Lista.No;

public class Tree {
    private Node root;
    private TxtReader txtreader = new TxtReader("");

    public Tree(){
        this.root = null;
    }

    public void insert(String value, String fileTitle){
        this.txtreader.path = fileTitle;
        for(int freq = txtreader.pegarFreq(value); freq > 0; freq--){
            if(this.root == null){
                this.root = new Node(value, fileTitle);
            }else{
                Node node = this.root;
                Node inserted = new Node(value, fileTitle);
                while(node != null){
                    if(node.value.compareTo(value) < 0){
                        if(node.leftBranch == null){
                            inserted.root = node;
                            node.leftBranch = inserted; 
                            break;
                        }
                        node = node.leftBranch;
                    }else if(node.value.compareTo(value) > 0){
                        if(node.rightBranch == null){
                            inserted.root = node;
                            node.rightBranch = inserted; 
                            break;
                        }
                        node = node.rightBranch;
                    }else{
                        No no = node.getLista().getPrimeiro();
                        boolean contain = false;
                        while(no != null){
                            if(no.getTitle().equals(fileTitle)){
                                no.incrementFreq();
                                contain = true;
                                break;
                            }
                            no = no.getProx();
                        }
                        if(!contain){
                            node.getLista().add(1, fileTitle);
                        }
                        break;
                    }
                }
                node.updateHeight();
                this.root = Node.rotate(node);
            }
        }
    }

    public void remove(String value){
        Node node = this.root;
        while(node != null){
            if(node.value == value){
                if(node.rightBranch == null){
                    node.equalize(node.leftBranch);
                    node.leftBranch = null;
                }else if(node.leftBranch == null){
                    node.equalize(node.rightBranch);
                    node.rightBranch = null;
                }else{
                    Node node2 = node.leftBranch;
                    while(node2.rightBranch != null){
                        node2 = node2.rightBranch;
                    }
                    node.equalize(node2);
                    node2.root.leftBranch = null;
                }
                node.updateHeight();
                this.root = Node.rotate(node);
                return;
            }else if(node.value.compareTo(value) < 0/*node.value > value*/){
                node = node.leftBranch;
            }else{
                node = node.rightBranch;
            }
        }
        System.out.println("String nao encontrado");
    }

    public String getFreq(String value){
        Node node = this.root;
        while(node != null){
            if(node.value == value){
                return node.lista.toString();
            }else if(node.value.compareTo(value) < 0/*node.value > value*/){
                node = node.leftBranch;
            }else{
                node = node.rightBranch;
            }
        }
        return "";
    }

    public boolean exists(String value){
        Node node = this.root;
        while(node != null){
            if(node.value == value){
                return true;
            }else if(node.value.compareTo(value) < 0/*node.value > value*/){
                node = node.leftBranch;
            }else{
                node = node.rightBranch;
            }
        }
        return false;
    }

    public int getMaxHeight(){
        if(this.root == null){return 0;}
        return this.root.height;
    }

    public void print_preorder(){System.out.print("Tree in pre-order: "); print_preorder(this.root); System.out.println("");}
    private void print_preorder(Node node){
        // recursive function
        if(node == null){return;}
        else{
            System.out.print(node.value + " ");
            print_preorder(node.leftBranch);
            print_preorder(node.rightBranch);
        }
    }

    public void print_inorder(){System.out.print("Tree in in-order: "); print_inorder(this.root); System.out.println("");}
    private void print_inorder(Node node){
        // recursive function
        if(node == null){return;}
        else{
            print_inorder(node.leftBranch);
            System.out.print(node.value + " ");
            print_inorder(node.rightBranch);
        }
    }

    public void print_postorder(){System.out.print("Tree in post-order: "); print_postorder(this.root); System.out.println("");}
    private void print_postorder(Node node){
        // recursive function
        if(node == null){return;}
        else{
            print_postorder(node.leftBranch);
            print_postorder(node.rightBranch);
            System.out.print(node.value + " ");
        }
    }
}
