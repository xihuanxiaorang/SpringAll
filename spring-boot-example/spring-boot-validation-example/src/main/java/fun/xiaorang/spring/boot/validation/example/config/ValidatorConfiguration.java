package fun.xiaorang.spring.boot.validation.example.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 23:31
 */
@Configuration
public class ValidatorConfiguration {
  @Bean
  public Validator validator(AutowireCapableBeanFactory beanFactory) {
    try (ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .constraintValidatorFactory(new SpringConstraintValidatorFactory(beanFactory))
            .buildValidatorFactory()) {
      return validatorFactory.getValidator();
    }
  }
}
