/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author eddie
 */
@Entity
@Table(name = "car_registro_placa")
public class CarRegistroPlaca implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_placa", nullable = true)
    private String numeroPlaca;

    @Column(name = "car_fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "car_hora_registro")
    @Temporal(TemporalType.TIME)
    private Date horaRegistro;

    //VARIABLES LOCALES NO PERSISTEN EN BD
    @Transient
    private String fechaResgistro;

    public CarRegistroPlaca() {
    }

    @Override
    public String toString() {
        return "CarRegistroPlaca{" + "id=" + id + ", numeroPlaca=" + numeroPlaca + ", fechaRegistro=" + fechaRegistro + ", horaRegistro=" + horaRegistro + ", fechaResgistro=" + fechaResgistro + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(Date horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public String getFechaResgistro() {
        return fechaResgistro;
    }

    public void setFechaResgistro(String fechaResgistro) {
        this.fechaResgistro = fechaResgistro;
    }

}
