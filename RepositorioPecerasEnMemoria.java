import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Implementación en memoria; puede sustituirse por una persistencia SQL. */
public final class RepositorioPecerasEnMemoria implements RepositorioPeceras {
    private final List<Pecera> inventario = new ArrayList<>();

    @Override
    public void guardar(Pecera pecera) {
        inventario.add(pecera);
    }

    public List<Pecera> listar() {
        return Collections.unmodifiableList(inventario);
    }
}
