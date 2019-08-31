/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.controlador;

import com.proyecto.picoplaca.DM.PicoPlacaDM;
import com.proyecto.picoplaca.serviceUI.UIRegistroPlacaService;
import com.proyecto.picoplaca.utils.BaseControlador;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Eddie-PC
 */
@ManagedBean(name = "picoPlacaControlador")
@ViewScoped
public class PicoPlacaControlador extends BaseControlador {

    /**
     * INSTANCIAR VARIABLES DM
     */
    @ManagedProperty("#{picoPlacaDM}")
    PicoPlacaDM picoPlacaDM;

    /**
     * INSTANCIAR EJB DE SERVICIO
     */
    @EJB
    UIRegistroPlacaService registroPlacaService;

    /**
     * DECLARACIÓN DE METODOS
     */
    public void verificarPermisoCirculacion() {
        Boolean tienePermiso = registroPlacaService.verificaPermisoCirculacion(picoPlacaDM.getRegistroPlaca());
        if (tienePermiso) {

        } else {
            addErrorMessage("NO TIENE PERMISO DE CIRCULACIÓN");
        }
    }

    public PicoPlacaDM getPicoPlacaDM() {
        return picoPlacaDM;
    }

    public void setPicoPlacaDM(PicoPlacaDM picoPlacaDM) {
        this.picoPlacaDM = picoPlacaDM;
    }

}
