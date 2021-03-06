public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();

        TxtReader txt = new TxtReader("src/teste.txt");
        TxtReader txt2 = new TxtReader("src/teste2.txt");
        String[] palavras = {"computador", "pao", "monitor", "batata"};

        for(int i = 0; i < palavras.length; i++){
            tree.insert(palavras[i], txt.path);
        }

        tree.insert("computador", txt2.path);

        tree.print_preorder();
        tree.print_inorder();
        tree.print_postorder();
        System.out.println("Altura: " + tree.getMaxHeight());
        System.out.println("monitor existe na arvore: " + tree.exists("monitor"));
        System.out.println("simsim existe na arvore: " + tree.exists("simsim"));
        System.out.println("Removendo palavra monitor: ");
        tree.remove("monitor");
        tree.print_preorder();
        System.out.println("Frequencia de cada palavra: ");

        for(int i = 0; i < palavras.length; i++){
            System.out.println(palavras[i] + " " + tree.getFreq(palavras[i]));
        }
    } 
}
