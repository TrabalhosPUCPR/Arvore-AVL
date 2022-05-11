package Lista;

public class Lista {
    No<?> primeiro;
    No<?> ultimo;

    public Lista(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public <T> void add(T value){
        if(this.primeiro == null){
            this.primeiro = new No<T>(value);
            this.ultimo = new No<T>(value);
            this.ultimo.anterior = this.primeiro;
            return;
        }
        this.ultimo.proximo = new No<T>(value);
        this.ultimo.proximo.anterior = this.ultimo;
        this.ultimo = this.ultimo.proximo;
    }

    public void printAll(){
        No<?> p = this.primeiro;
        while(p != null){
            System.out.println("Class: " + p.getClass().getName() + " Value:" + p.value);
        }
    }

    public No<?> get(int index){
        try{
            No<?> p = this.primeiro;
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
}
