package fun.xiaorang.spring.cloud.alibaba.nacos.discovery.provider.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/09 16:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(NacosProviderApplication.class, args);
  }

  @RestController
  public static class EchoController {
    @GetMapping("/echo/{str}")
    public String echo(@PathVariable(value = "str") String str) {
      return "Hello Nacos Discovery " + str;
    }
  }
}
