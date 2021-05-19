
public class ListaEstatica<T> extends ListaAbstract<T> {

    @Override
    public void inserir(T valor) {
        if(getInfo().length == getTamanho())
            redimensionar();

        getInfo()[getTamanho()] = valor;
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
