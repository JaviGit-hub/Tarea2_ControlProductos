/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;

import javax.swing.JOptionPane;

/**
 *
 * @author Javier MT
 */
public class Producto {

    //ATRIBUTOS DE LA CLASE
    public int codigo;
    public String nombre;
    public double precio;
    public int cantidadDisponible;

    //MÉTODO CONSTRUCTOR
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

    //GETTERS AND SETTERS
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    //MÉTODO PARA VISUALIZAR LA INFORMACIÓN DE LOS PRODUCTOS
    public void infoProdutos() {
        JOptionPane.showMessageDialog(null, "INFORMACIÓN DEL PRODUCTO\n\n"
                + "CÓDIGO: " + codigo
                + "\nNombre del producto: " + nombre
                + "\nPrecio: ₡ " + precio
                + "\nDisponibles: " + cantidadDisponible);
    } //Fin de infoProductos

} //Fin de la clase
