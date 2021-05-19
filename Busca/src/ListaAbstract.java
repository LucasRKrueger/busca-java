
public abstract class ListaAbstract<T> {
	private T[] info;
    private int tamanho;
    
    public ListaAbstract() { liberar(); }    
    
    protected T[] getInfo() { return info; }
    
    public int getTamanho() { return tamanho; }
    
    protected void setTamanho(int tamanho) { this.tamanho = tamanho; }    
    
    public abstract void inserir(T valor);
      
    public void exibir() { System.out.println(this.toString()); }
    
    abstract int buscar(T valor);
    
    public boolean estaVazia() { return tamanho == 0; }
    
    protected void redimensionar() {
        T[] infoRedimensionada = (T[]) new Object[tamanho + 10];
    
        for (int i = 0; i < info.length; i++) {
            infoRedimensionada[i] = info[i];
        }
    
        info = infoRedimensionada;        
    }
    
    public void retirar(T valor) {
        int posicao = buscar(valor);
        
        if(posicao > -1)
        {
            for (int i = posicao; i < tamanho; i++) {
                info[i] = info[i + 1];
            }
            tamanho--;
        }
    }
    
    public void liberar() {
        info = (T[]) new Object[10];
        tamanho = 0;
    }
    
    public T obterElemento(int posicao) throws IndexOutOfBoundsException {
        if(posicao >= 0 && posicao >= tamanho)
            throw new IndexOutOfBoundsException();
        return info[posicao];
    }
    
    
     @Override
     public String toString() { 
         String resultado = "";
            
            for (int i = 0; i < tamanho; i++) {
                if(i > 0)
                    resultado += ", ";
                resultado += info[i].toString();
            }
            
        return resultado;
     } 
     
     public void inverter() {
         T backup;
         
         for (int i = 0; i < tamanho / 2; i++) {
                 backup = info[i];
                info[i] = info[tamanho - (i + 1)];
                info[tamanho - (i + 1)] = backup;
            }
    }
}
