/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.service;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import com.proyecto.picoplaca.serviceUI.UIRegistroPlacaService;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 *
 * @author eddie
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 120000)
@Lock(LockType.WRITE)
public class RegistroPlacaService implements UIRegistroPlacaService {

    @Override
    public void guardar(CarRegistroPlaca registroPlaca) {

    }

    @Override
    public void registrarPlaca(CarRegistroPlaca registroPlaca) {

    }

    @Override
    public void verificarCirculacionAuto(CarRegistroPlaca registroPlaca) {

    }
}
