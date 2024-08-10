package fun.xiaorang.nacos.spring.cloud.discovery.consumer.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/09 17:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(NacosConsumerApplication.class, args);
  }

  @FeignClient(name = "nacos-provider")
  public interface EchoFeignClient {
    @GetMapping("/echo/{str}")
    String echo(@PathVariable(value = "str") String str);
  }

  @RestController
  public static class NacosController {
    private final EchoFeignClient echoFeignClient;

    @Value("${spring.application.name}")
    private String appName;

    public NacosController(final EchoFeignClient echoFeignClient) {
      this.echoFeignClient = echoFeignClient;
    }

    @GetMapping("/echo/app-name")
    public String echoAppName() {
      return echoFeignClient.echo(appName);
    }
  }
}
