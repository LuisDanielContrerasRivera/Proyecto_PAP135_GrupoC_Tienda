package com.tienda;

public class Promocion {
    private double montoCompraMinima;
    private double porcentajeDescuento;
    /**
     * @description Constructor
     * @param montoCompraMinima
     * @param porcentajeDescuento
     */
    public Promocion(double montoCompraMinima, double porcentajeDescuento) {
        this.montoCompraMinima = montoCompraMinima;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    /**
     * @description Aplica descuento en la compra en caso de cumplir el monto minimo
     * @param total
     * @return double
     */
    public double aplicarDescuento(double total) {
        if (total >= montoCompraMinima) {
            return total * (1 - porcentajeDescuento / 100);
        }
        return total;
    }
    /**
     * @description Getter para la propiedad montoCompraMinima
     * @return double
     */
    public double getMontoCompraMinima() {
        return montoCompraMinima;
    }
    /**
     * @description Getter para la propiedad porcentajeDescuento
     * @return double
     */
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    /**
     * @description Devuelve la promoción con todas sus propiedades
     * @return String
     */
    @Override
    public String toString() {
        return "Promocion [montoCompraMinima: " + montoCompraMinima + ", porcentajeDescuento: " + porcentajeDescuento + "]";
    }
}
