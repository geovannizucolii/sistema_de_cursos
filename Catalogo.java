import java.util.ArrayList;
import java.util.List;

public class Catalogo<T> {
    private ArrayList<T> lista;

    public Catalogo(){
        this.lista = new ArrayList<>();
    }

    public void adicionar(T elemento){
        lista.add(elemento);
    }

    public List<T> getElementos(){
        return lista;
    }
}
