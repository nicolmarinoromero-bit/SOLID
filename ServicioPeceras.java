import java.math.BigDecimal;
import java.util.List;

/** Coordina los casos de uso de peceras sin depender de servicios concretos. */
public final class ServicioPeceras {
    private final RepositorioPeceras repositorio;
    private final CalculadorPrecio calculadorPrecio;
    private final List<ProcesadorPago> procesadoresPago;
    private final NotificadorPago notificador;

    public ServicioPeceras(RepositorioPeceras repositorio,
                           CalculadorPrecio calculadorPrecio,
                           List<ProcesadorPago> procesadoresPago,
                           NotificadorPago notificador) {
        if (repositorio == null || calculadorPrecio == null || procesadoresPago == null || notificador == null) {
            throw new IllegalArgumentException("Todas las dependencias son obligatorias.");
        }
        this.repositorio = repositorio;
        this.calculadorPrecio = calculadorPrecio;
        this.procesadoresPago = procesadoresPago;
        this.notificador = notificador;
    }

    public void agregarPecera(String tipoPecera, BigDecimal precio) {
        repositorio.guardar(new Pecera(tipoPecera, precio));
    }

    public BigDecimal calcularTotalConImpuesto(BigDecimal precioBase, String tipoCliente) {
        return calculadorPrecio.calcular(precioBase, tipoCliente);
    }

    public void procesarPagoYNotificar(String metodoPago, BigDecimal monto, String emailCliente) {
        for (ProcesadorPago procesador : procesadoresPago) {
            if (procesador.soporta(metodoPago)) {
                procesador.procesar(monto);
                notificador.notificarPagoExitoso(emailCliente, monto);
                return;
            }
        }
        throw new IllegalArgumentException("Método de pago no soportado: " + metodoPago);
    }
}
