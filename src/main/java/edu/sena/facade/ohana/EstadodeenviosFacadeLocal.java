/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Estadodeenvios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface EstadodeenviosFacadeLocal {

    void create(Estadodeenvios estadodeenvios);

    void edit(Estadodeenvios estadodeenvios);

    void remove(Estadodeenvios estadodeenvios);

    Estadodeenvios find(Object id);

    List<Estadodeenvios> findAll();

    List<Estadodeenvios> findRange(int[] range);

    int count();
    
}
