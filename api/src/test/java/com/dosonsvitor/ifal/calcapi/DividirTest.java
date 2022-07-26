package com.dosonsvitor.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class DividirTest {
    @Test
    public void div() {
        MockRouter router = new MockRouter(new App());
        router.get("/div/5/5", rsp -> {
            assertEquals(1.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void div_firstOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/a/5", rsp -> {});
        });
    }

    @Test
    public void div_secondOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/2/a", rsp -> {});
        });
    }

    @Test
    public void div_allOperadorsAreString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/a/a", rsp -> {});
        });
    }
}
