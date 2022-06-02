/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Recibos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface RecibosFacadeLocal {

    void create(Recibos recibos);

    void edit(Recibos recibos);

    void remove(Recibos recibos);

    Recibos find(Object id);

    List<Recibos> findAll();

    List<Recibos> findRange(int[] range);

    int count();
    
}
