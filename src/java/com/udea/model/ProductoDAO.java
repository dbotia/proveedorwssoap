/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class ProductoDAO {
    public void ingresarProducto(Producto p){
    SessionFactory sf=null;
    Session session = null;
    Transaction tx=null;
    
    try{
    
    sf=HibernateUtil.getSessionFactory();
    session=sf.openSession();
    tx=session.beginTransaction();
    session.save(p);
    tx.commit();
    session.close();
    }catch(Exception e){
    tx.rollback();
    throw new RuntimeException("No se pudo guardar el producto");
    
    }
    
    }
    
    
    public String consultarProducto(int codigo){
    SessionFactory sf=HibernateUtil.getSessionFactory();
    Session session=sf.openSession();
    Producto p =(Producto) session.get(Producto.class, codigo);
    session.close();
    if(p!=null){
      return "El producto de codigo " + p.getCodigo()+ " cuyo nombre es " + p.getNombre()+ " cuesta $" + p.getPrecio()
              + " tiene en stock " + p.getStock() + " y su descripcion es " + p.getDescripcion();
              
    } else { return "El producto con codigo " + codigo + " no existe";}
    
    }
    
    
    
    
    public List<Producto> verProductos(){
      SessionFactory sf=HibernateUtil.getSessionFactory();
      Session session = sf.openSession();
      Query query= session.createQuery("from Producto");
      List<Producto> lista= query.list();
    return lista;
    }
    
    
    
}
