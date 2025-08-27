package com.api.company.dto;

import org.springframework.stereotype.Service;


public class Mensaje {

    private String Mensaje;

    public Mensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

}
