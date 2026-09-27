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
public class Inventario {

    Producto[] productos = new Producto[10];

    //ACUMULADOR
    private int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }

    public void registroProductos() {
        if (cantidad >= 10) {
            JOptionPane.showMessageDialog(null, "ERROR\nSe ha excedido el límite de registros");
            return;
        }

        cantidad++;

        for (int i = 0; i < productos.length; i++) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nIngrese el código del producto (SOLO DÍGITOS)"));
            String nombre = JOptionPane.showInputDialog("REGISTRO\nNombre del producto");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("REGISTRO\nPrecio ₡"));
            int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nCantidad disponible"));
            
            //CONDICIÓN PARA VALIDAR QUE LA CANTIDAD INICIAL A REGISTAR NO SEA 0
            while (cantidadDisponible <= 0){
                JOptionPane.showMessageDialog(null, "ERROR\nLa cantidad a registrar no puede ser 0");
                cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad nuevamente"));
            }

            productos[i] = new Producto(codigo, nombre, precio, cantidadDisponible);
            break;   
        }
    } //Fin de registroProducto()

    public void mostrarInfo() {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                productos[i].infoProdutos();
            }
        }
    } //Fin de mostrarInfo()

    public void buscarProductos() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("BÚSQUEDA DE PRODUCTOS\nIngrese el código"));

        int indice = -1; //SI NO SE ENCUENTRA EL CÓDIGO EN EL ARREGLO RETORNA ESTE VALOR

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                indice = i;
                
                JOptionPane.showMessageDialog(null, "PRODUCTO ENCONTRADO: " + productos[i].getNombre()
                        + "\nPrecio ₡" + productos[i].getPrecio()
                        + "\nDisponibles: " + productos[i].getCantidadDisponible());
                
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El producto NO EXISTE. Intente nuevamente");

    } //Fin de buscarProductos()
}