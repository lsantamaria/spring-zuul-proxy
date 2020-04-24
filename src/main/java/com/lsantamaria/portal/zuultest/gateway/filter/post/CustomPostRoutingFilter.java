package com.lsantamaria.portal.zuultest.gateway.filter.post;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

/**
 * An example implementation of a pre-routing filter. This filter is executing before {@link
 * org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter}.
 * <p>
 * The filter buffers the response body, modifies it and adds it back to the response.
 */
@Component
@Slf4j
public class CustomPostRoutingFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "post";
  }

  @Override
  public int filterOrder() {
    return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    try {
      RequestContext context = getCurrentContext();
      InputStream stream = context.getResponseDataStream();
      String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
      context.setResponseBody("Modified response: \n" + body);
    } catch (IOException e) {
      rethrowRuntimeException(e);
    }
    return null;
  }
}
