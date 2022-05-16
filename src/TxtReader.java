import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtReader {

    String path;

    public TxtReader(String localTxt) {
        this.path = localTxt;
    }

    public int pegarFreq(String palavra){
        // endereço do arquivo
        try {
            byte[] texto1 = Files.readAllBytes(Paths.get(this.path));
            // cria um array contendo todo o texto que está no arquivo txt
            String txt = new String(texto1);
            int freq = 0;

            for(int i = 0, cont = 0; i < txt.length(); i++){
                if(txt.charAt(i) == palavra.charAt(cont)){
                    cont++;
                    if(cont >= palavra.length()){
                        cont = 0;
                        freq++;
                    }
                }else{
                    cont = 0;
                }
            }
            return freq;
        }
        catch(Exception erro) {
            System.out.println(erro);
            return 0;
        }
    }

    public String getPath(){return this.path;}
}

