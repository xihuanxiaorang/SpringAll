package fun.xiaorang.spring.boot.validation.example.handler;

import cn.hutool.json.JSONUtil;
import fun.xiaorang.spring.boot.validation.example.annotation.IgnoreGlobalResponse;
import fun.xiaorang.spring.boot.validation.example.pojo.R;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/SpringAll">SpringAll</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/08/12 14:58
 */
@ConditionalOnProperty(prefix = "response.wrapper", name = "enabled", havingValue = "true", matchIfMissing = true)
@RestControllerAdvice(value = "fun.xiaorang")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {
  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreGlobalResponse.class)) {
      return false;
    }
    return !returnType.hasMethodAnnotation(IgnoreGlobalResponse.class);
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    if (body == null) {
      return R.success();
    }
    if (body instanceof R) {
      return body;
    }
    if (body instanceof String) {
      return JSONUtil.toJsonStr(R.success(body));
    }
    return R.success(body);
  }
}
