package com.dosonsvitor.ifal.calcapi.handlers;


import io.jooby.Context;
import io.jooby.annotations.*;

@Path("multi/{parametro1}/{parametro2}")
public class Multiplicar {
    @GET
    public Double Multi(@PathParam String parametro1, @PathParam String parametro2){
        Double num1 = Double.parseDouble(parametro1);
        Double num2 = Double.parseDouble(parametro2);
        return num1 * num2;
    }
}
