/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.serviceUI;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import javax.ejb.Local;

/**
 *
 * @author eddie
 */
@Local
public interface UIRegistroPlacaService {

    public void guardar(CarRegistroPlaca registroPlaca);

    public void registrarPlaca(CarRegistroPlaca registroPlaca);

    public void verificarCirculacionAuto(CarRegistroPlaca registroPlaca);
}
