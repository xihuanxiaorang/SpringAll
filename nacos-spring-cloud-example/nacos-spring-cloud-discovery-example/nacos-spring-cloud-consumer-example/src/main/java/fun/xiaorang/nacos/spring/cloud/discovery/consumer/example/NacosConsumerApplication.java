package fun.xiaorang.nacos.spring.cloud.discovery.consumer.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/09 17:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {
  /**
   * 实例化 RestTemplate 实例
   * 标注 @LoadBalanced 注解即可在 RestTemplate 上开启 LoadBalanced 负载均衡的功能
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(NacosConsumerApplication.class, args);
  }

  @RestController
  public static class NacosController {
    private final RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    public NacosController(final RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
    }

    @GetMapping("/echo/app-name")
    public String echoAppName() {
      final String url = String.format("http://%s/echo/%s", "nacos-provider", appName);
      System.out.println("request url:" + url);
      return restTemplate.getForObject(url, String.class);
    }
  }
}
