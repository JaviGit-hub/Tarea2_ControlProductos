/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;
import modulo. *;

/**
 *
 * @author Javier MT
 */
public class Menu {

    private int opcion;
    private Inventario i = new Inventario();

    public void menuPrincipal() {

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    SISTEMA DE CONTROL DE PRODUCTOS
                                                                    
                                                                    Digite una opción para comenzar:
                                                                    1. Registar producto
                                                                    2. Mostrar productos
                                                                    3. Búsqueda de producto (por código)
                                                                    4. Vender unidades
                                                                    5. Reabastecer stock
                                                                    6. Calcular VALOR TOTAL del inventario
                                                                    7. SALIR DEL SISTEMA
                                                                    """));
            if (opcion >= 2 && opcion < 7 && i.getCantidad()== 0) {
                JOptionPane.showMessageDialog(null, "ERROR\nDebe registrar un PRODUCTO primero");
                continue;
            }
            switch (opcion) {
                case 1:
                    i.registroProductos();
                    JOptionPane.showMessageDialog(null, "Producto registrado correctamente (" + i.getCantidad() + " de 10)" );
                    break;
                case 2:
                    i.mostrarInfo();
                    break;
                case 3:
                    i.buscarProductos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "En desarollo ...");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "En desarollo ...");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "En desarollo ...");
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema de control ...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR\nOpción inválida. Intente nuevamente");
            }
        } while (opcion != 7);
    }
}
