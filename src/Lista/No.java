package Lista;

public class No <T>{
    T value;
    No<?> proximo;
    No<?> anterior;

    public No(T value){
        this.value = value;
        this.proximo = null;
        this.anterior = null;
    }

    public T getValue(){
        return this.value;
    }
}
