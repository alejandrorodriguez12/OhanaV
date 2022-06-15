/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Compras;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josea
 */
@Local
public interface ComprasFacadeLocal {

    void create(Compras compras);

    void edit(Compras compras);

    void remove(Compras compras);

    Compras find(Object id);

    List<Compras> findAll();

    List<Compras> findRange(int[] range);

    int count();
    
}
