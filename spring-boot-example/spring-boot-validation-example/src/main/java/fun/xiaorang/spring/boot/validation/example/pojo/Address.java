package fun.xiaorang.spring.boot.validation.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 23:36
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  @NotBlank(message = "省份不能为空")
  private String province;
  @NotBlank(message = "城市不能为空")
  private String city;
  @NotBlank(message = "街道不能为空")
  private String street;
}
