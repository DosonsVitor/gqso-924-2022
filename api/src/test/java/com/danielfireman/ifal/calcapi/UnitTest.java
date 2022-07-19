package com.danielfireman.ifal.calcapi;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import org.junit.jupiter.api.Test;

import com.dosonsvitor.ifal.calcapi.App;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
  @Test
  public void welcome() {
    MockRouter router = new MockRouter(new App());
    router.get("/", rsp -> {
      assertEquals("{"
                  +"   \"status\": 200,"
                  +"   \"message\": \"API para resolução das 4 principais operações matematicas.\""
                  +"}", rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }
}