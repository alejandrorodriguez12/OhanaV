/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import static edu.sena.entity.ohana.Images_.id;
import edu.sena.entity.ohana.Productos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josea
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "up_ohana")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    @Override
    public List<Productos> leerTodo() {

        em.getEntityManagerFactory().getCache().evictAll();
        Query prod = em.createQuery("SELECT u FROM Productos u");
        return prod.getResultList();
    }

    @Override
    public boolean agregarProducto(Productos prodagr, int idProducto, int idTipoProducto) {
        try {
            Query prod = em.createNativeQuery("INSERT INTO productos (idTipoProducto,Nombres,Foto,Descripcion,Precio,Stock) VALUES (?,?,?,?,?,?);");
            prod.setParameter(1, idTipoProducto);
            prod.setParameter(2, prodagr.getNombres());
            prod.setParameter(3, prodagr.getFoto());
            prod.setParameter(4, prodagr.getDescripcion());
            prod.setParameter(5, prodagr.getPrecio());
            prod.setParameter(6, prodagr.getStock());
            prod.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Productos> findNombresStartWith(String nombres) {
        String jpql = "SELECT u FROM Productos u WHERE u.nombres like 'Mug%'";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public List<Productos> findByCamisetasHStartsWith(String nombres) {
        String jpql = "SELECT u FROM Productos u WHERE u.nombres like 'Camiseta h%'";
        Query query1 = em.createQuery(jpql);
        return query1.getResultList();
    }

    @Override
    public List<Productos> findByCamisetasMStartsWith(String nombres) {
        String jpql = "SELECT u FROM Productos u WHERE u.nombres like 'Camiseta m%'";
        Query query1 = em.createQuery(jpql);
        return query1.getResultList();
    }

    @Override
    public List<Productos> findByGorrasStartsWith(String nombres) {
        String jpql = "SELECT u FROM Productos u WHERE u.nombres like 'Gorra%'";
        Query query1 = em.createQuery(jpql);
        return query1.getResultList();
    }

}
