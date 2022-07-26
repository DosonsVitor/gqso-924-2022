package com.dosonsvitor.ifal.calcapi;

import com.dosonsvitor.ifal.calcapi.handlers.Multiplicar;

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
    
    mvc(new Subtrair());
    mvc(new Multiplicar());
    mvc(new Dividir());
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }
}
