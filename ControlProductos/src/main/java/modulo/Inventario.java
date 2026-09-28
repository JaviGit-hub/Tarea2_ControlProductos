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
        //CONDICIÓN PARA VALIDAR QUE SE REGISTREN SOLO 10 PRODUCTOS MÁXIMOS
        if (cantidad >= 10) {
            JOptionPane.showMessageDialog(null,
                    "ERROR\nSe ha alcanzado el límite de 10 productos.");
            return;
        }

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nIngrese el código del producto (SOLO DÍGITOS)"));
        for (int i = 0; i < productos.length; i++) {

            // SE VALIDA QUE EL CÓDIGO NO ESTÉ REPETIDO
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null, "ERROR\nEl código " + codigo + " ya está registrado");
                return;
            }
        }

        //Registro de los datos del equipo
        String nombre = JOptionPane.showInputDialog("REGISTRO\nNombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("REGISTRO\nPrecio ₡"));

        //EL PRECIO DEBE SER MAYOR A 0
        while (precio <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR\nEl precio del artículo no puede ser 0");
            precio = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nIngrese el precio nuevamente"));
        }

        int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nCantidad disponible"));

        //La cantidad inicial no puede ser 0
        while (cantidadDisponible <= 0) {
            JOptionPane.showMessageDialog(null, "ERROR\nLa cantidad a registrar no puede ser 0");

            cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nIngrese la cantidad nuevamente"));
        }

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = new Producto(codigo, nombre, precio, cantidadDisponible);
                cantidad++;
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente (" + cantidad + " de 10)");
                break;
            }
        }
    }
    //Fin de registroProducto()

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

                JOptionPane.showMessageDialog(null, "Producto encontrado: " + productos[i].getNombre()
                        + "\nPrecio ₡" + productos[i].getPrecio()
                        + "\nDisponibles: " + productos[i].getCantidadDisponible());

                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El producto NO EXISTE. Intente nuevamente");
    } //Fin de buscarProductos()

    public void venderUnidades() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("VENTA\nIngrese el código del producto"));

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                int cantidadVenta = Integer.parseInt(JOptionPane.showInputDialog("VENTA\nProducto: " + productos[i].getNombre()
                        + "\nCantidad disponible: "
                        + productos[i].getCantidadDisponible()
                        + "\n\nIngrese la cantidad a vender")
                );

                if (cantidadVenta <= 0) {
                    JOptionPane.showMessageDialog(null, "ERROR\nLa cantidad a vender debe ser mayor que 0.");
                    return;
                }

                if (cantidadVenta <= productos[i].getCantidadDisponible()) {
                    productos[i].setCantidadDisponible(productos[i].getCantidadDisponible() - cantidadVenta);

                    JOptionPane.showMessageDialog(null, "VENTA REALIZADA\n"
                            + "Producto: " + productos[i].getNombre()
                            + "\nUnidades vendidas: " + cantidadVenta
                            + "\nExistencias restantes: "
                            + productos[i].getCantidadDisponible());
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR\nNo hay suficientes unidades disponibles.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "ERROR\nNo se encontró ningún producto con el código: " + codigo);
    } //Fin de venderUnidades()

    public void valorInventario() {
        double total = 0.0;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                total += productos[i].getPrecio() * productos[i].getCantidadDisponible();
            }
        }
        JOptionPane.showMessageDialog(null, "VALOR TOTAL DEL INVENTARIO\n" + "₡ " + String.format("%.2f%n", total));
    } //Fin valorInventario

    public void reestablecerInventario() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("REABASTECER\nIngrese el código del producto"));

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getCodigo() == codigo) {
                int cantidadReabastecer = Integer.parseInt(JOptionPane.showInputDialog("REABASTECER\n"
                        + "Producto: " + productos[i].getNombre()
                        + "\nCantidad disponible: " + productos[i].getCantidadDisponible()
                        + "\n\nIngrese la cantidad a reabastecer")
                );

                while (cantidadReabastecer <= 0) {
                    JOptionPane.showMessageDialog(null, "ERROR\nLa cantidad a reabastecer debe ser mayor que cero.");
                    cantidadReabastecer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad nuevamente"));
                }

                productos[i].setCantidadDisponible(productos[i].getCantidadDisponible() + cantidadReabastecer);

                JOptionPane.showMessageDialog(null, "REABASTECIMIENTO REALIZADO\n"
                        + "Producto: " + productos[i].getNombre()
                        + "\nUnidades agregadas: " + cantidadReabastecer
                        + "\nExistencias actuales: " + productos[i].getCantidadDisponible());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "ERROR\nNo se encontró ningún producto con el código: " + codigo);
    } //Fin de reestablecerInventario()
}
