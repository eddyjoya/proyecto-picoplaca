/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.service;

import com.proyecto.picoplaca.daoUI.UIRegistroPlacaDao;
import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion;
import com.proyecto.picoplaca.serviceUI.UIRegistroPlacaService;
import com.proyecto.picoplaca.utils.Utils;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
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

    @EJB
    UIRegistroPlacaDao registroPlacaDao;

    @Override
    public void guardar(CarRegistroPlaca registroPlaca) throws EntidadNoGrabadaExcepcion {
        if (registroPlaca != null) {
            registroPlacaDao.actualizar(registroPlaca);
        } else {
            registroPlacaDao.crear(registroPlaca);
        }

    }

    @Override
    public void registrarPlaca(CarRegistroPlaca registroPlaca) {

    }

    @Override
    public Boolean verificaPermisoCirculacion(CarRegistroPlaca registroPlaca) {
        String campoBusquedaCodigo = registroPlaca.getNumeroPlaca().substring(registroPlaca.getNumeroPlaca().length() - 1,
                registroPlaca.getNumeroPlaca().length());
        System.out.println("DÍA: " + consultarDiaPicoPlaca(campoBusquedaCodigo));
        consultarHoraPicoPlaca(registroPlaca.getHoraRegistro());
        return false;
    }

    private String consultarDiaPicoPlaca(String digitoVericador) {
        switch (digitoVericador) {
            case "1":
            case "2":
                return "LUNES";
            case "3":
            case "4":
                return "MARTES";
            case "5":
            case "6":
                return "MIÉRCOLES";
            case "7":
            case "8":
                return "JUEVES";
            case "9":
            case "0":
                return "VIERNES";
            default:
                break;
        }
        return null;
    }

    private void consultarHoraPicoPlaca(Date hora) {
        Date hora1 = Utils.transformarStringAHoras("07:00:00");
        Date hora2 = Utils.transformarStringAHoras("09:30:00");

        Date hora3 = Utils.transformarStringAHoras("16:00:00");
        Date hora4 = Utils.transformarStringAHoras("19:30:00");
        Boolean horaPico1 = false, horaPico2 = false;
        if ((hora.before(hora1) || (hora.after(hora2)))) {
            horaPico1 = true;
        }
        if ((hora.before(hora3) || (hora.after(hora4)))) {
            horaPico2 = true;
        }
        if ((horaPico1) && (horaPico2)) {
            System.out.println("Puede circular");
        }
    }
}
