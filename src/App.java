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
    }
}
