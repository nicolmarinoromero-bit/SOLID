import java.math.BigDecimal;

public final class PagoNequi implements ProcesadorPago {
    @Override
    public boolean soporta(String metodoPago) {
        return "NEQUI".equals(metodoPago);
    }

    @Override
    public void procesar(BigDecimal monto) {
        System.out.println("Conectando con API de Nequi... Procesando $" + monto);
    }
}
