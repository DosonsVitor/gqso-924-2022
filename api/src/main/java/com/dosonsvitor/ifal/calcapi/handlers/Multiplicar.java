package com.dosonsvitor.ifal.calcapi.handlers;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("multi/{parametro1}/{parametro2}")
public class Multiplicar {
    @GET
    public Double Multi(@PathParam String parametro1, @PathParam String parametro2) {
        Double num1, num2;
        try {
            num1 = Double.parseDouble(parametro1);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Parâmetro inválido: " + parametro1);
        } try {
            num2 = Double.parseDouble(parametro2);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Parâmetro inválido: " + parametro2);
        }

        return num1 * num2;
    }
}
