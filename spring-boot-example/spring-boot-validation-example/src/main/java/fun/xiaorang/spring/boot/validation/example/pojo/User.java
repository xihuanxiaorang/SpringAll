package fun.xiaorang.spring.boot.validation.example.pojo;

import fun.xiaorang.spring.boot.validation.example.annotation.UserStatus;
import fun.xiaorang.spring.boot.validation.example.validate.Update;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 21:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @NotNull(message = "id不能为空", groups = {Update.class})
  private Long id;
  @NotBlank(message = "用户名不能为空")
  private String username;
  @NotBlank(message = "密码不能为空")
  @Length(min = 6, max = 20, message = "密码长度在{min}-{max}之间")
  private String password;
  @Min(value = 0, message = "年龄最小为{value}")
  @Max(value = 200, message = "年龄最大为{value}")
  private Integer age;
  @NotBlank(message = "邮箱不能为空")
  @Email(message = "邮箱格式不正确")
  private String email;
  @Valid
  private Address address;
  @UserStatus
  private Integer status;
}
