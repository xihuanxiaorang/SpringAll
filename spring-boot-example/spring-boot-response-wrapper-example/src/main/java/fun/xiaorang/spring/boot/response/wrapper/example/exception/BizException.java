package fun.xiaorang.spring.boot.response.wrapper.example.exception;

import fun.xiaorang.spring.boot.response.wrapper.example.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 16:39
 */
@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {
  private final String code;
  private final String message;

  public BizException(ResultCode resultCode) {
    this.code = resultCode.getCode();
    this.message = resultCode.getMessage();
  }
}
