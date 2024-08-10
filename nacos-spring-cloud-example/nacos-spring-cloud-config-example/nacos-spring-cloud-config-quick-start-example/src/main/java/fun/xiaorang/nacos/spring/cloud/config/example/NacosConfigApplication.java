package fun.xiaorang.nacos.spring.cloud.config.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/10 12:58
 */
@SpringBootApplication
public class NacosConfigApplication {
  public static void main(String[] args) {
    final ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
    final String userName = applicationContext.getEnvironment().getProperty("user.name");
    final String userAge = applicationContext.getEnvironment().getProperty("user.age");
    System.err.println("user name: " + userName + "; age: " + userAge);
  }
}
