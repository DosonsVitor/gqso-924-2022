package com.dosonsvitor.ifal.calcapi.handlers;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.annotations.*;

@Path("multi/{parametro1}/{parametro2}")
public class Multiplicar {
    @GET
    public String Multi(@PathParam("parametro1") String par1){
        return par1;
    }
}
