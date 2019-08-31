/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.dao;

import com.proyecto.picoplaca.daoUI.UIGenericDao;
import com.proyecto.picoplaca.excepciones.EntidadNoBorradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoEncontradaExcepcion;
import com.proyecto.picoplaca.excepciones.EntidadNoGrabadaExcepcion;
import java.io.Serializable;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author eddie
 * @param <T>
 * @param <PK>
 */
@SuppressWarnings("unchecked")
public class GenericDao<T, PK extends Serializable> implements
        UIGenericDao<T, PK> {

    @PersistenceContext(unitName = "picoplacaDS")
    protected EntityManager em;

    private final Class<T> type;

    /**
     * Instancia un nuevo generic dao.
     *
     * @param type the type
     */
    public GenericDao(final Class<T> type) {
        this.type = type;
    }

    /**
     */
    @Override
    public void crear(final T o) throws EntidadNoGrabadaExcepcion {
        try {
            em.persist(o);
        } catch (final PersistenceException e) {
            throw new EntidadNoGrabadaExcepcion("Error al grabar: ".concat(o
                    .toString()), e);
        } catch (IllegalArgumentException ex) {
            throw new EntityExistsException(ex.getMessage());
        }
    }

    /**
     */
    @Override
    public T recuperar(final PK id) throws EntidadNoEncontradaExcepcion {

        final T entidad = em.find(type, id);

        if (entidad == null) {
            final StringBuffer msg = new StringBuffer();
            msg.append(type.getSimpleName());
            msg.append('[');
            msg.append(id.toString());
            msg.append("] no encontrada.");
            throw new EntidadNoEncontradaExcepcion(msg.toString());
        }

        return entidad;
    }

    /**
     */
    @Override
    public void actualizar(final T o) throws EntidadNoGrabadaExcepcion {

        try {

            em.merge(o);

        } catch (IllegalArgumentException ex) {
            throw new EntidadNoGrabadaExcepcion(ex.getMessage());
        }
    }

    /**
     * tion
     */
    @Override
    public void eliminar(final T o) throws EntidadNoBorradaExcepcion {

        try {

            em.merge(o);
            em.remove(o);

        } catch (IllegalArgumentException ex) {
            throw new EntidadNoBorradaExcepcion(ex.getMessage());
        }
    }
}
