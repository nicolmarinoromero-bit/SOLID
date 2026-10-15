import java.math.BigDecimal;

/** Adaptador de ejemplo; se puede reemplazar por un cliente SMTP real. */
public final class NotificadorCorreoConsola implements NotificadorPago {
    @Override
    public void notificarPagoExitoso(String emailCliente, BigDecimal monto) {
        System.out.println("Enviando correo a " + emailCliente
                + ": Su pago de $" + monto + " fue exitoso.");
    }
}
