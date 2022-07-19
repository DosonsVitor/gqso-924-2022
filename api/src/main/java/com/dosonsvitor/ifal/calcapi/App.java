package com.dosonsvitor.ifal.calcapi;

import io.jooby.Jooby;
import io.jooby.MediaType;

public class App extends Jooby {

  {
    get("/", ctx -> {
      ctx.setDefaultResponseType(MediaType.json);
      return "{"
            +"   \"status\": 200,"
            +"   \"message\": \"API para resolução das 4 principais operações matematicas.\""
            +"}";
    });
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }
}