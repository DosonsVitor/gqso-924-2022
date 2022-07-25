package com.dosonsvitor.ifal.calcapi.handlers;

import io.jooby.annotations.*;

@Path("sub/{parametro1}/{parametro2}")
public class Subtrair {
    @GET
    public Double Sub(@PathParam String parametro1, @PathParam String parametro2){
        Double num1 = Double.parseDouble(parametro1);
        Double num2 = Double.parseDouble(parametro2);
        return num1 - num2;
    }
}
