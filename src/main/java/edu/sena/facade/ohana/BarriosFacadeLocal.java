/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Barrios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface BarriosFacadeLocal {

    void create(Barrios barrios);

    void edit(Barrios barrios);

    void remove(Barrios barrios);

    Barrios find(Object id);

    List<Barrios> findAll();

    List<Barrios> findRange(int[] range);

    int count();
    
}
