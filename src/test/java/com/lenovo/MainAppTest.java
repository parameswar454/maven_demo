package com.lenovo;

import static com.google.common.truth.Truth.assertThat;

import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpResponse;
import com.despegar.sparkjava.test.SparkServer;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MainAppTest {
  @ClassRule
	public static SparkServer<MainApp> server = new SparkServer<>(MainApp.class, 4567);

  @Test
  public void integrationTest() throws Exception {
    GetMethod get = server.get("/api/hello", false);
    HttpResponse httpResponse = server.execute(get);
    assertThat(httpResponse.code()).isEqualTo(200);
    assertThat(new String(httpResponse.body())).isEqualTo("Hello from Spark!");
  }

  @Test
  public void unitTest() {
    assertThat(new MainApp().getMessage()).isEqualTo("Hello from Spark!");
  }
}
