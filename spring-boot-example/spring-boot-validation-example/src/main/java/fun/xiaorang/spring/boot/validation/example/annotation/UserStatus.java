package fun.xiaorang.spring.boot.validation.example.annotation;

import fun.xiaorang.spring.boot.validation.example.validate.UserStatusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/13 14:05
 */
@Constraint(validatedBy = UserStatusValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserStatus {
  String message() default "用户状态不正确，值必须在1或2或3之中";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
