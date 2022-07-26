package com.dosonsvitor.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class MultiplicarTest {
    @Test
    public void multi() {
        MockRouter router = new MockRouter(new App());
        router.get("/multi/5/5", rsp -> {
            assertEquals(25.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void multi_firstOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multi/a/5", rsp -> {});
        });
    }

    @Test
    public void multi_secondOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multi/5/a", rsp -> {});
        });
    }

    @Test
    public void multi_allOperadorsAreString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/multi/a/a", rsp -> {});
        });
    }
}
