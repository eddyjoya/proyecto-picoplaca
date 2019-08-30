/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.picoplaca.tester;

import com.proyecto.picoplaca.entidad.CarRegistroPlaca;

/**
 *
 * @author eddie
 */
public class TesterEJB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CarRegistroPlaca registro = new CarRegistroPlaca();
        System.out.println(registro.toString());
    }

}
