/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eddie-PC
 */
public class Utils {

    public static Date transformarStringADate(String fechaString) {
        SimpleDateFormat formatoDelTexto;
        formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(fechaString);
        } catch (ParseException ex) {
            ex.getErrorOffset();
        }

        return fecha;
    }
}
