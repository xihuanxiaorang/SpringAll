package fun.xiaorang.spring.boot.validation.example.controller;

import fun.xiaorang.spring.boot.validation.example.pojo.User;
import fun.xiaorang.spring.boot.validation.example.validate.Insert;
import fun.xiaorang.spring.boot.validation.example.validate.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 21:56
 */
@RestController
@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
public class UserController {
  private final Validator validator;

  @PostMapping
  public User create(@Validated({Insert.class}) @RequestBody User user) {
    // 此处只会校验 Insert 分组下的约束注解
    return user;
  }

  @PutMapping
  public User save(@Validated(Update.class) @RequestBody User user) {
    // 此处只会校验 Update 分组下的约束注解
    return user;
  }

  @GetMapping("echo")
  public User query(@NotBlank(message = "用户名不能为空") @RequestParam String username,
                    @Min(value = 0, message = "年龄最小为{value}") @RequestParam Integer age) {
    return User.builder().id(1L).username(username).password("123456").age(age).email("15019474951@163.com").build();
  }

  @PostMapping("/manual")
  public User manual(@RequestBody User user) {
    // 手动校验，Insert 分组
    final Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, Insert.class);
    if (!constraintViolations.isEmpty()) {
      throw new ConstraintViolationException(constraintViolations);
    }
    return user;
  }
}
