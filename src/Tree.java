public class Tree {
    Element root;

    public Tree(){
        this.root = null;
    }

    public void insert(int value){
        if(this.root == null){
            this.root = new Element(value, null);
        }else{
            Element p = this.root;
            do{
                if(p.value > value){
                    if(p.next_L == null){p.next_L = new Element(value, p); break;}
                    p = p.next_L;
                }else{
                    if(p.next_H == null){p.next_H = new Element(value, p); break;}
                    p = p.next_H;
                }
            }while(p != null);
        }
    }

    public void print(){}
}
