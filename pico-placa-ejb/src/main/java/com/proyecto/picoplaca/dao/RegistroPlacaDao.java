/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.dao;

import com.proyecto.picoplaca.daoUI.UIRegistroPlacaDao;
import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import javax.ejb.Singleton;

/**
 *
 * @author eddie
 */
@Singleton
public class RegistroPlacaDao
        extends GenericDao<CarRegistroPlaca, Long>
        implements UIRegistroPlacaDao {

    public RegistroPlacaDao() {
        super(CarRegistroPlaca.class);
    }

}
