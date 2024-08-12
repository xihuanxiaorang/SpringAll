package fun.xiaorang.spring.boot.response.wrapper.example.controller;

import fun.xiaorang.spring.boot.response.wrapper.example.enums.ResultCode;
import fun.xiaorang.spring.boot.response.wrapper.example.pojo.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 12:25
 */
@RestController
@RequestMapping("/test")
public class TestController {
  @GetMapping("/success")
  public Map<String, Object> success() {
    Integer age = 18;
    String name = "小让";
    Map<String, Object> map = new HashMap<>();
    map.put("name", name);
    map.put("age", age);
    return map;
  }

  @GetMapping("/error")
  public R<?> error() {
    int i = 1 / 0;
    return R.fail(ResultCode.SYSTEM_EXECUTION_ERROR);
  }

  @GetMapping("/error2")
  public Integer error2(Integer age) {
    return age;
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}