package fun.xiaroang.nacos.spring.cloud.config.profile.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/10 18:31
 */
@SpringBootApplication
public class NacosConfigApplication {
  public static void main(String[] args) throws InterruptedException {
    final ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
    while (true) {
      //当动态配置刷新时，会更新到 Enviroment 中，因此这里每隔一秒中从 Enviroment 中获取配置
      final String userName = applicationContext.getEnvironment().getProperty("user.name");
      final String userAge = applicationContext.getEnvironment().getProperty("user.age");
      //获取当前部署的环境
      final String currentEnv = applicationContext.getEnvironment().getProperty("current.env");
      System.err.println("in " + currentEnv + " enviroment; " + "user name :" + userName + "; age: " + userAge);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
