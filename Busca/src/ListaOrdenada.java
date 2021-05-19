
public class ListaOrdenada <T extends Comparable<T>> extends ListaAbstract<T> {
	
	@Override
    public void inserir(T valor) {
        T[] info = getInfo();

        if(info.length == getTamanho())
            redimensionar();

        int posicao = 0;
        for (int i = 0; i < getTamanho(); i++) {
            if(valor.compareTo(info[i]) > 0)
            {
                posicao = i;
                continue;
            }
        }

        T backup;
        for (int i = posicao; i < getTamanho(); i++) {
            backup = info[i];
            info[i] = valor;
            valor = backup;
        }

        setTamanho(getTamanho()+1);
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < getTamanho(); i++) {
            if(valor == getInfo()[i])
                return i;
        }

        return -1;
    }	 
}
