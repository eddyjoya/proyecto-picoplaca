/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.service;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import com.proyecto.picoplaca.excepciones.EntidadNoEncontradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion;
import com.proyecto.picoplaca.serviceUI.UIRegistroPlacaService;
import com.proyecto.picoplaca.utils.Utils;
import java.util.Date;
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
    public String verificaPermisoCirculacion(CarRegistroPlaca registroPlaca)
            throws EntidadNoEncontradaExcepcion, EntidadNoGrabadaExcepcion {
        /**
         * MÉTODO PARA VALIDAR LA INFORMACIÓN INGRESADA
         */
        validaInformacionAProcesar(registroPlaca);
        String mensajeRespuesta, campoBusquedaCodigo;
        /**
         * MÉTODO PARA OBTENER EL ÚLTIMO DIGITO DE LA PLACA INGRESADA
         */
        campoBusquedaCodigo = registroPlaca.getNumeroPlaca().substring(registroPlaca.getNumeroPlaca().length() - 1,
                registroPlaca.getNumeroPlaca().length());

        mensajeRespuesta = "DÍA " + consultarDiaPicoPlaca(campoBusquedaCodigo) + " "
                + Utils.darFormatoHoraSring(registroPlaca.getHoraRegistro());
        if (consultaPermisoCirculacion(registroPlaca.getHoraRegistro())) {
            mensajeRespuesta = mensajeRespuesta + " TIENE PERMISO DE CIRCULACIÓN";
        } else {
            mensajeRespuesta = mensajeRespuesta + " NO TIENE PERMISO DE CIRCULACIÓN";
        }
        return mensajeRespuesta;
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

    private void validaInformacionAProcesar(CarRegistroPlaca placa)
            throws EntidadNoEncontradaExcepcion {
        Date fecha = Utils.transformarStringADate(placa.getFecha());
        if (fecha == null) {
            throw new EntidadNoEncontradaExcepcion("¡Fecha no válida!");
        }
    }

    private boolean consultaPermisoCirculacion(Date hora) {
        Boolean horaPico1 = false, horaPico2 = false, puedeCircular = false;
        /**
         * INSTANCIAR VARIABLES DE HORAS PICO*
         */
        Date hora1 = Utils.transformarStringAHoras("07:00:00");
        Date hora2 = Utils.transformarStringAHoras("09:30:00");
        Date hora3 = Utils.transformarStringAHoras("16:00:00");
        Date hora4 = Utils.transformarStringAHoras("19:30:00");
        /**
         * PICO Y PLACA DE 7:OO A 9:30
         */
        if ((hora.before(hora1) || (hora.after(hora2)))) {
            horaPico1 = true;
        }
        /**
         * PICO Y PLACA DE 16:OO A 19:30
         */
        if ((hora.before(hora3) || (hora.after(hora4)))) {
            horaPico2 = true;
        }
        /**
         * SI LA HORA INGRESADA ESTA FUERA DEL RANGO DE LAS HORAS QUE APLICA
         * PICO Y PLACA, LA PLACA INGRESADA PUEDE CIRCULAR
         */
        if ((horaPico1) && (horaPico2)) {
            puedeCircular = true;
        }
        return puedeCircular;
    }
}
