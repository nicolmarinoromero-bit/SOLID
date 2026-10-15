import java.math.BigDecimal;

public interface ProcesadorPago {
    boolean soporta(String metodoPago);
    void procesar(BigDecimal monto);
}
