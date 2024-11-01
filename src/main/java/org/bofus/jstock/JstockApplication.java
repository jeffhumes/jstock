package org.bofus.jstock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.bofus.jstock.mapper")
public class JstockApplication {

  public static void main(String[] args) {
    SpringApplication.run(JstockApplication.class, args);
  }
}
