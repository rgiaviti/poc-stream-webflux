package com.gh.rgiaviti.server;

import com.github.javafaker.Faker;
import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FluxStreamServer {

  public static void main(String[] args) {
    SpringApplication.run(FluxStreamServer.class, args);
  }

  @Bean
  public Faker faker() {
    return new Faker(new Locale("pt", "BR"));
  }

}
