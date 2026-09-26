/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modulo;
import javax.swing.JOptionPane;
import modulo.Producto;

/**
 *
 * @author Javier MT
 */
public class Inventario {
   Producto[] productos = new Producto[10];
   
   //ACUMULADOR
   private int cantidad = 0;
   
   public int getCantidad(){
       return cantidad;
   }
   
   public void registroProductos(){
       for (int i = 0; i<productos.length; i++){
           int codigo = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nIngrese el código del producto (SOLO DÍGITOS)"));
           String nombre = JOptionPane.showInputDialog("REGISTRO\nNombre del producto");
           double precio = Double.parseDouble(JOptionPane.showInputDialog("REGISTRO\nPrecio (₡)"));
           int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("REGISTRO\nCantidad disponible"));
           
        productos[i] = new Producto(codigo, nombre, precio, cantidadDisponible);
        cantidad++;
        break;
       }
       if (cantidad >= 10){
           JOptionPane.showMessageDialog(null, "ERROR\nSe ha excedido el límite de registros");
       }
   } //Fin de registroProducto()
   
   public void mostrarInfo(){
       for (int i = 0; i<productos.length; i++){
           if (productos[i] != null){
               productos[i].infoProdutos();
           }
       }
   } //Fin de mostrarInfo
   
    
}
