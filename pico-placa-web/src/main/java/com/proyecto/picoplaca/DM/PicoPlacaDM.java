/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.DM;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Eddie-PC
 */
@ManagedBean(name = "picoPlacaDM")
@ViewScoped
public class PicoPlacaDM {

    /**
     * DECLARACION DE VARIABLES
     */
    private CarRegistroPlaca registroPlaca = new CarRegistroPlaca();

    public CarRegistroPlaca getRegistroPlaca() {
        return registroPlaca;
    }

    public void setRegistroPlaca(CarRegistroPlaca registroPlaca) {
        this.registroPlaca = registroPlaca;
    }

}
