/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.daoUI;

import com.proyecto.picoplaca.excepciones.EntidadNoBorradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoEncontradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion;
import java.io.Serializable;

/**
 *
 * @author eddie
 * @param <T>
 * @param <PK>
 */
public interface UIGenericDao<T, PK extends Serializable> {

    /**
     * Guardar un objeto en la base de datos.
     *
     * @param o the o
     * @throws com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion
     */
    void crear(T o) throws EntidadNoGrabadaExcepcion;

    /**
     * Obtener un objeto almacenado utilizando su llave primaria.
     *
     * @param id llave primaria.
     *
     * @return the T
     * @throws com.proyecto.picoplaca.excepciones.EntidadNoEncontradaExcepcion
     */
    T recuperar(PK id) throws EntidadNoEncontradaExcepcion;

    /**
     * Almacenar los cambios hechos a un objeto.
     *
     * @param o the o
     * @throws com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion
     */
    void actualizar(T o) throws EntidadNoGrabadaExcepcion;

    /**
     * Eliminar un objeto de la base de datos.
     *
     * @param o the o
     * @throws com.proyecto.picoplaca.excepciones.EntidadNoBorradaExcepcion
     */
    void eliminar(T o) throws EntidadNoBorradaExcepcion;

}
