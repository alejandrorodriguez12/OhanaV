/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.ohana;

import edu.sena.entity.ohana.Cotizaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 57301
 */
@Local
public interface CotizacionesFacadeLocal {

    void create(Cotizaciones cotizaciones);

    void edit(Cotizaciones cotizaciones);

    void remove(Cotizaciones cotizaciones);

    Cotizaciones find(Object id);

    List<Cotizaciones> findAll();

    List<Cotizaciones> findRange(int[] range);

    int count();
    
}
