package com.tienda;

public class Promocion {
    private double montoCompraMinima;
    private double porcentajeDescuento;
    public Promocion(double montoCompraMinima, double porcentajeDescuento) {
        this.montoCompraMinima = montoCompraMinima;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public double aplicarDescuento(double total) {
        if (total >= montoCompraMinima) {
            return total * (1 - porcentajeDescuento / 100);
        }
        return total;
    }
    public double getMontoCompraMinima() {
        return montoCompraMinima;
    }
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
