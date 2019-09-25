/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductoWS;

import com.udea.model.Producto;
import com.udea.model.ProductoDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Lenovo
 */
@WebService(serviceName = "NewWebService")
public class ProductoWS {

     @WebMethod(operationName = "ingresarProducto")
    public String ingresarProducto( @WebParam(name = "nombre") String nombre, 
            @WebParam(name = "precio") double precio, @WebParam(name = "stock") int stock, @WebParam(name = "descripcion") 
                    String descripcion) {
        //TODO write your implementation code here:
        Producto p = new Producto(nombre, precio, stock, descripcion);
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.ingresarProducto(p);
        return "Producto Ingresado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarProducto")
    public String BuscarProducto(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
       ProductoDAO productoDAO = new ProductoDAO();
       return productoDAO.consultarProducto(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarProducto")
    public List<Producto> ConsultarProducto() {
        //TODO write your implementation code here:
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProducto = productoDAO.verProductos();
        
        return listaProducto;
    }
}
