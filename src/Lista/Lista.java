package Lista;

public class Lista {
    No primeiro;
    No ultimo;

    public Lista(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void add(int freq, String title){
        if(this.primeiro == null){
            this.primeiro = new No(freq, title);
            this.ultimo = this.primeiro;
            this.ultimo.anterior = this.primeiro;
            return;
        }
        this.ultimo.proximo = new No(freq, title);
        this.ultimo.proximo.anterior = this.ultimo;
        this.ultimo = this.ultimo.proximo;
    }

    public void printAll(){
        No no = this.primeiro;
        while(no != null){
            System.out.println("Title: " + no.title + " Frequencia:" + no.freq);
        }
    }

    public No get(int index){
        try{
            No no = this.primeiro;
            int cont = 0;
            while(no != null){
                if(cont == index){return no;}
                no = no.proximo;
                cont++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public String toString(){
        No no = this.primeiro;
        String s = "";
        while(no != null){
            s += no.getTitle() + ": " + no.getFreq() + ". ";
            no = no.proximo;
        }
        return s;
    }
    public No getPrimeiro(){return this.primeiro;}
}
