package com.dosonsvitor.ifal.calcapi;

import okhttp3.*;
import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class DividirIntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void checkOkStatus(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/div/10/2")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK.value(), rsp.code());
      assertEquals("5.0", rsp.body().string());
    }
  }

  @Test
  public void checkFirstNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/div/a/5")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checkSecondNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/div/5/a")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checkAllNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/div/a/a")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }
}
