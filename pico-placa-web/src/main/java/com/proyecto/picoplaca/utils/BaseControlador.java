/**
 * BaseController
 *
 */
package com.proyecto.picoplaca.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

/**
 * @author Jorge Llamba
 *
 */
@ManagedBean(name = "baseControlador")
@SessionScoped
public abstract class BaseControlador implements Serializable {

    /**
     * @param resumen
     */
    protected void addErrorMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     */
    protected void addInfoMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addWarnMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param date
     * @param format
     * @return
     */
    protected String dateFormat(final Date date, final String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
