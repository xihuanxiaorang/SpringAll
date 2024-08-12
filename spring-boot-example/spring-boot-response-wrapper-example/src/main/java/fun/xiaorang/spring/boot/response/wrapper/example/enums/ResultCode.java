package fun.xiaorang.spring.boot.response.wrapper.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 12:00
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements Serializable {

  SUCCESS("00000", "请求成功"),

  USER_NOT_EXIST("A0201", "账户不存在"),
  USER_ACCOUNT_LOCKED("A0202", "账户被冻结，请联系管理员"),
  USER_ACCOUNT_INVALID("A0203", "账户已作废，请联系管理员"),
  USERNAME_OR_PASSWORD_ERROR("A0210", "用户名或密码错误"),
  VERIFY_CODE_TIMEOUT("A0213", "验证码已过期"),
  VERIFY_CODE_ERROR("A0214", "验证码错误"),
  TOKEN_INVALID("A0230", "token无效或已过期"),
  TOKEN_ACCESS_FORBIDDEN("A0231", "token已被禁止访问"),
  ACCESS_UNAUTHORIZED("A0301", "访问未授权"),
  ACCESS_FORBIDDEN("A0401", "访问权限不足"),
  PARAM_ERROR("A0400", "用户请求参数错误"),
  RESOURCE_NOT_FOUND("A0404", "请求资源不存在"),
  PARAM_IS_NULL("A0410", "请求必填参数为空"),

  SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错");

  private final String code;
  private final String message;
}
