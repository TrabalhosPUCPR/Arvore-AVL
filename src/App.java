public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();

        tree.insert(10);
        tree.insert(16);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(9);
        tree.print_preorder();
        //tree.print_inorder();
        //tree.print_postorder();
        System.out.println("Altura: " + tree.getMaxHeight());
        System.out.println("15 existe na arvore: " + tree.search(15));
        System.out.println("20 existe na arvore: " + tree.search(20));
        //tree.remove(5);
        tree.print_preorder();
    } 
}
