package com.tienda;

public class Cliente {
    private String nombre;
    private String telefono;
    private String direccion;
    /**
     * @description Constructor
     * @param nombre
     * @param telefono
     * @param direccion
     */
    public Cliente(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    /**
     * @description Getter para la propiedad nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @description Getter para la propiedad telefono
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * @description Getter para la propiedad direccion
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @description Devuelve el cliente con todas sus propiedades
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente [nombre: " + nombre + ", telefono: " + telefono + ", direccion: " + direccion + "]";
    }
}
