import java.math.BigDecimal;

/** Datos de una pecera del inventario. */
public final class Pecera {
    private final String tipo;
    private final BigDecimal precio;

    public Pecera(String tipo, BigDecimal precio) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pecera es obligatorio.");
        }
        if (precio == null || precio.signum() < 0) {
            throw new IllegalArgumentException("El precio debe ser mayor o igual a cero.");
        }
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public BigDecimal getPrecio() { return precio; }
}
