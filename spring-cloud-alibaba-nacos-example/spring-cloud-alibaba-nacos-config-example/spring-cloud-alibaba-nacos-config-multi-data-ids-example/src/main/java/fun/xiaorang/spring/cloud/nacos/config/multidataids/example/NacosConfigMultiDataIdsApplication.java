package fun.xiaorang.spring.cloud.nacos.config.multidataids.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/11 16:26
 */
@SpringBootApplication
public class NacosConfigMultiDataIdsApplication {
  public static void main(String[] args) throws InterruptedException {
    final ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigMultiDataIdsApplication.class, args);
    while (true) {
      final String name = applicationContext.getEnvironment().getProperty("user.name");
      final String age = applicationContext.getEnvironment().getProperty("user.age");
      final String hobby = applicationContext.getEnvironment().getProperty("user.hobby");
      final String salary = applicationContext.getEnvironment().getProperty("user.salary");
      final String address = applicationContext.getEnvironment().getProperty("user.address");
      final String sex = applicationContext.getEnvironment().getProperty("user.sex");
      // name: xiaorang，age: 28，hobby: football，salary: 8000，address: changsha，sex: 男
      System.out.println("name: " + name + ", age: " + age + ", hobby: " + hobby + ", salary: " + salary + ", address: " + address + ", sex: " + sex);
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
