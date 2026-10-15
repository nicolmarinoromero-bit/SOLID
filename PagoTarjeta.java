import java.math.BigDecimal;

public final class PagoTarjeta implements ProcesadorPago {
    @Override
    public boolean soporta(String metodoPago) {
        return "TARJETA".equals(metodoPago);
    }

    @Override
    public void procesar(BigDecimal monto) {
        System.out.println("Conectando con pasarela de pago con tarjeta... Procesando $" + monto);
    }
}
