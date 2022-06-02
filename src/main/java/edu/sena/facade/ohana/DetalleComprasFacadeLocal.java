/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.DetalleCompras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Acer
 */
@Local
public interface DetalleComprasFacadeLocal {

    void create(DetalleCompras detalleCompras);

    void edit(DetalleCompras detalleCompras);

    void remove(DetalleCompras detalleCompras);

    DetalleCompras find(Object id);

    List<DetalleCompras> findAll();

    List<DetalleCompras> findRange(int[] range);

    int count();
    
}
