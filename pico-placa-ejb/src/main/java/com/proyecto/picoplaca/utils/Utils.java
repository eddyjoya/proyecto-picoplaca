/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eddie-PC
 */
public class Utils {
    
    public static Date transformarStringADate(String fechaString) {
        SimpleDateFormat formatoDelTexto;
        formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        try {
            formatoDelTexto.setLenient(false);
            return formatoDelTexto.parse(fechaString);
            
        } catch (ParseException ex) {
            return null;
        }
        
    }
    
    public static String darFormatoHoraSring(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(fecha);
    }
    
    public static String darFormatoFechaSring(Date fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(fecha);
    }
    
    public static Date transformarStringAHoras(String horaString) {
        Date hora = null;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        try {
            hora = dateFormat.parse(horaString);
        } catch (ParseException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hora;
    }
}
