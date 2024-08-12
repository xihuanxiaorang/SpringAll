package fun.xiaorang.spring.boot.response.wrapper.example.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import fun.xiaorang.spring.boot.response.wrapper.example.enums.ResultCode;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 12:04
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {
  /**
   * 响应码
   */
  private String code;

  /**
   * 响应消息
   */
  private String message;

  /**
   * 响应数据
   */
  private T data;

  public static <T> R<T> success() {
    return success(null);
  }

  public static <T> R<T> success(T data) {
    return result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
  }

  public static <T> R<T> fail() {
    return fail(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), ResultCode.SYSTEM_EXECUTION_ERROR.getMessage());
  }

  public static <T> R<T> fail(String message) {
    return fail(ResultCode.SYSTEM_EXECUTION_ERROR.getCode(), message);
  }

  public static <T> R<T> fail(ResultCode resultCode) {
    return fail(resultCode.getCode(), resultCode.getMessage());
  }

  public static <T> R<T> fail(String code, String message) {
    return result(code, message, null);
  }

  public static <T> R<T> result(String code, String message, T data) {
    return R.<T>builder().code(code).message(message).data(data).build();
  }

  public static <T> R<T> judge(boolean status) {
    return status ? success() : fail();
  }

  public static boolean isSuccess(R<?> result) {
    return result != null && ResultCode.SUCCESS.getCode().equals(result.getCode());
  }
}
