package com.dosonsvitor.ifal.calcapi.handlers;

import io.jooby.annotations.*;
import io.jooby.exception.BadRequestException;

@Path("div/{parametro1}/{parametro2}")
public class Dividir {
    @GET
    public Double Div(@PathParam String parametro1, @PathParam String parametro2) {
        Double num1, num2;
        try {
            num1 = Double.parseDouble(parametro1);
        } catch (NumberFormatException e) {
            throw new BadRequestException("Parâmetro inválido: " + parametro1);
        } try {
            num2 = Double.parseDouble(parametro2);
            if(num2 == 0){
                throw new BadRequestException("Você não pode dividir por 0");
            }
        } catch (NumberFormatException e) {
            throw new BadRequestException("Parâmetro inválido: " + parametro2);
        }

        return num1 / num2;
    }
}
