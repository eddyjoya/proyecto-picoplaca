/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.serviceUI;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import com.proyecto.picoplaca.excepciones.EntidadNoEncontradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion;
import javax.ejb.Local;

/**
 *
 * @author eddie
 */
@Local
public interface UIRegistroPlacaService {

    public String verificaPermisoCirculacion(CarRegistroPlaca registroPlaca)
            throws EntidadNoEncontradaExcepcion, EntidadNoGrabadaExcepcion;
}
