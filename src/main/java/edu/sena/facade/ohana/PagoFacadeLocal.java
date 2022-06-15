/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Pago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author josea
 */
@Local
public interface PagoFacadeLocal {

    void create(Pago pago);

    void edit(Pago pago);

    void remove(Pago pago);

    Pago find(Object id);

    List<Pago> findAll();

    List<Pago> findRange(int[] range);

    int count();
    
}
