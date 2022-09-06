package com.dosonsvitor.ifal.calcapi;

import okhttp3.*;
import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class SubtracaoIntegrationTest {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void checkOkStatus(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/sub/8/4")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK.value(), rsp.code());
      assertEquals("4.0", rsp.body().string());
    }
  }

  @Test
  public void checkFirstNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/sub/a/5")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checkSecondNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/sub/5/a")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checkAllNotNumError(int serverPort) throws IOException {
    Request req = new Request.Builder()
      .url("http://localhost:"+ serverPort + "/sub/a/a")
      .build();

    try(Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }
}
