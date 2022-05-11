public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();

        tree.insert("pao");
        tree.insert("batata");
        tree.insert("yua");
        tree.insert("simsim");
        tree.insert("aaaaaa");
        tree.insert("naonao");
        tree.insert("legal");
        tree.insert("muitoshowdebola");
        tree.print_preorder();
        //tree.print_inorder();
        //tree.print_postorder();
        System.out.println("Height: " + tree.height());
        System.out.println("pao exists on this tree: " + tree.search("pao"));
        System.out.println("muit0legal exists on this tree: " + tree.search("muitolegal"));
        tree.remove("yua");
        tree.print_preorder();
    } 
}
