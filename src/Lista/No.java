package Lista;

public class No{
    int freq;
    String title;
    No proximo;
    No anterior;

    public No(int freq, String title){
        this.freq = freq;
        this.title = title;
        this.proximo = null;
        this.anterior = null;
    }

    public int getFreq(){return this.freq;}
    public void incrementFreq(){this.freq++;}
    public String getTitle(){return this.title;}
    public No getProx(){return this.proximo;}
}
