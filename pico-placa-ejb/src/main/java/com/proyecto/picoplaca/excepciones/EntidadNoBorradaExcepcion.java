/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.excepciones;

import javax.ejb.ApplicationException;

/**
 *
 * @author eddie
 */
@ApplicationException(rollback = true)
public class EntidadNoBorradaExcepcion extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Instancia un nuevo entidad no borrada exception.
     */
    public EntidadNoBorradaExcepcion() {
        super();
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     * @param arg1 the arg1
     */
    public EntidadNoBorradaExcepcion(final String arg0, final Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoBorradaExcepcion(final String arg0) {
        super(arg0);
    }

    /**
     * Instancia un nuevo entidad no borrada exception.
     *
     * @param arg0 the arg0
     */
    public EntidadNoBorradaExcepcion(final Throwable arg0) {
        super(arg0);
    }
}
