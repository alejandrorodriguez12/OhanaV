/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Localidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface LocalidadesFacadeLocal {

    void create(Localidades localidades);

    void edit(Localidades localidades);

    void remove(Localidades localidades);

    Localidades find(Object id);

    List<Localidades> findAll();

    List<Localidades> findRange(int[] range);

    int count();
    
}
