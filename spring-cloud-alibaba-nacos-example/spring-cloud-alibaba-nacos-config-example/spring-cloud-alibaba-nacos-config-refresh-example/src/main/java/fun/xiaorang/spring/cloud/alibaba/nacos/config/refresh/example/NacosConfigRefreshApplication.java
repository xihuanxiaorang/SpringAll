package fun.xiaorang.spring.cloud.alibaba.nacos.config.refresh.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/10 14:11
 */
@SpringBootApplication
public class NacosConfigRefreshApplication {
  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigRefreshApplication.class, args);
    while (true) {
      //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
      String userName = applicationContext.getEnvironment().getProperty("user.name");
      String userAge = applicationContext.getEnvironment().getProperty("user.age");
      System.err.println("user name :" + userName + "; age: " + userAge);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
