package com.dosonsvitor.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SomarTest {
    @Test
    public void sum() {
        MockRouter router = new MockRouter(new App());
        router.get("/sum/5/5", rsp -> {
            assertEquals(10.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void sum_firstOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sum/a/5", rsp -> {});
        });
    }

    @Test
    public void sum_secondOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sum/5/a", rsp -> {});
        });
    }

    @Test
    public void sum_allOperadorsAreString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sum/a/a", rsp -> {});
        });
    }
}
