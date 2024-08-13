package fun.xiaorang.spring.boot.validation.example.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import fun.xiaorang.spring.boot.validation.example.enums.ResultCode;
import fun.xiaorang.spring.boot.validation.example.exception.BizException;
import fun.xiaorang.spring.boot.validation.example.pojo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 17:16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public <T> R<T> handleException(BindException e) {
    log.error("参数校验异常信息，异常堆栈信息：{}", e.getMessage(), e);
    String msg = e.getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
    return R.fail(ResultCode.PARAM_ERROR.getCode(), msg);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public <T> R<T> handleException(MethodArgumentNotValidException e) {
    log.error("参数校验异常信息，异常堆栈信息：{}", e.getMessage(), e);
    String msg = e.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
    return R.fail(ResultCode.PARAM_ERROR.getCode(), msg);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public <T> R<T> handleException(ConstraintViolationException e) {
    log.error("参数校验异常信息，异常堆栈信息：{}", e.getMessage(), e);
    String msg = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
    return R.fail(ResultCode.PARAM_ERROR.getCode(), msg);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public <T> R<T> handleException(MethodArgumentTypeMismatchException e) {
    log.error("参数类型不匹配异常信息，异常堆栈信息：{}", e.getMessage(), e);
    return R.fail(ResultCode.PARAM_ERROR);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public <T> R<T> handleException(IllegalArgumentException e) {
    log.error("非法参数异常，异常原因：{}", e.getMessage(), e);
    return R.fail(e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(JsonProcessingException.class)
  public <T> R<T> handleException(JsonProcessingException e) {
    log.error("Json转换异常，异常原因：{}", e.getMessage(), e);
    return R.fail(e.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(ArithmeticException.class)
  public <T> R<T> handleException(ArithmeticException e) {
    log.error("算术异常信息，异常堆栈信息：{}", e.getMessage(), e);
    return R.fail(ResultCode.SYSTEM_EXECUTION_ERROR);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoHandlerFoundException.class)
  public <T> R<T> handleException(NoHandlerFoundException e) {
    log.error("404异常信息，异常堆栈信息：{}", e.getMessage(), e);
    return R.fail(ResultCode.RESOURCE_NOT_FOUND);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(BizException.class)
  public <T> R<T> handleException(BizException e) {
    log.error("业务异常信息，异常堆栈信息：{}", e.getMessage(), e);
    return R.fail(e.getCode(), e.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public <T> R<T> handleException(Exception e) {
    log.error("全局异常信息，异常堆栈信息：{}", e.getMessage(), e);
    return R.fail(ResultCode.SYSTEM_EXECUTION_ERROR);
  }
}