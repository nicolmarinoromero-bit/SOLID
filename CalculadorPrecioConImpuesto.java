import java.math.BigDecimal;
import java.math.RoundingMode;

/** Aplica IVA y descuentos por tipo de cliente. */
public final class CalculadorPrecioConImpuesto implements CalculadorPrecio {
    private static final BigDecimal IVA = new BigDecimal("0.19");

    @Override
    public BigDecimal calcular(BigDecimal precioBase, String tipoCliente) {
        if (precioBase == null || precioBase.signum() < 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor o igual a cero.");
        }
        BigDecimal descuento = "VIP".equals(tipoCliente)
                ? new BigDecimal("0.15")
                : "MAYORISTA".equals(tipoCliente) ? new BigDecimal("0.25") : BigDecimal.ZERO;
        return precioBase.multiply(BigDecimal.ONE.add(IVA))
                .multiply(BigDecimal.ONE.subtract(descuento))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
