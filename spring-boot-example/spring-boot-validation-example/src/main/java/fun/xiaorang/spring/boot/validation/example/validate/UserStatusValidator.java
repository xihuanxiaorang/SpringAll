package fun.xiaorang.spring.boot.validation.example.validate;

import fun.xiaorang.spring.boot.validation.example.annotation.UserStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/13 14:07
 */
public class UserStatusValidator implements ConstraintValidator<UserStatus, Integer> {
  @Override
  public boolean isValid(Integer status, ConstraintValidatorContext constraintValidatorContext) {
    if (status == null) {
      return false;
    }
    return Arrays.asList(1, 2, 3).contains(status);
  }
}
