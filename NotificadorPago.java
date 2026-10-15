import java.math.BigDecimal;

public interface NotificadorPago {
    void notificarPagoExitoso(String emailCliente, BigDecimal monto);
}
