package com.dosonsvitor.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SubtrairTest {
    @Test
    public void sub() {
        MockRouter router = new MockRouter(new App());
        router.get("/sub/5/5", rsp -> {
            assertEquals(0.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void sub_firstOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/a/5", rsp -> {});
        });
    }

    @Test
    public void sub_secondOperadorIsString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/5/a", rsp -> {});
        });
    }

    @Test
    public void sub_allOperadorsAreString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/a/a", rsp -> {});
        });
    }
}
