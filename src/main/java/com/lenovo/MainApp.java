package com.lenovo;

import spark.servlet.SparkApplication;
import static spark.Spark.get;

public class MainApp implements SparkApplication {

  public static void main(String[] args) {
    new MainApp().init();
  }

  @Override
  public void init() {
    get("/api/hello", (request, response) -> getMessage());
  }

  public String getMessage() {
    return "Hello from Spark!";
  }
}