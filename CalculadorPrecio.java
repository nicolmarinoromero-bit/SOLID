import java.math.BigDecimal;

public interface CalculadorPrecio {
    BigDecimal calcular(BigDecimal precioBase, String tipoCliente);
}
