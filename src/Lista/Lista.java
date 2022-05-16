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
        No p = this.primeiro;
        while(p != null){
            System.out.println("Title: " + p.title + " Frequencia:" + p.freq);
        }
    }

    public No get(int index){
        try{
            No p = this.primeiro;
            int cont = 0;
            while(p != null){
                if(cont == index){return p;}
                p = p.proximo;
                cont++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    public String toString(){
        No p = this.primeiro;
        String s = "";
        while(p != null){
            s += p.getTitle() + ": " + p.getFreq() + ". ";
            p = p.proximo;
        }
        return s;
    }
    public No getPrimeiro(){return this.primeiro;}
}
