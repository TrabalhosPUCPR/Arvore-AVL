public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();

        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(12);
        tree.insert(1);
        tree.insert(16);
        tree.insert(19);
        tree.insert(14);
        tree.insert(15);
        tree.print_preorder();
        tree.print_inorder();
        tree.print_postorder();
        System.out.println("Height: " + tree.height());
        System.out.println("15 exists on this tree: " + tree.search(15));
        System.out.println("3 exists on this tree: " + tree.search(3));
    } 
}
