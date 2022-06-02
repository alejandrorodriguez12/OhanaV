/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Encargadosdelinventario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface EncargadosdelinventarioFacadeLocal {

    void create(Encargadosdelinventario encargadosdelinventario);

    void edit(Encargadosdelinventario encargadosdelinventario);

    void remove(Encargadosdelinventario encargadosdelinventario);

    Encargadosdelinventario find(Object id);

    List<Encargadosdelinventario> findAll();

    List<Encargadosdelinventario> findRange(int[] range);

    int count();
    
}
