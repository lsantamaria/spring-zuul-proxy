package com.lsantamaria.portal.zuultest.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class LogPreRoutingFilter extends ZuulFilter {

  public static final int LOG_FILTER_ORDER = FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return LOG_FILTER_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest req = ctx.getRequest();

    if (!StringUtils.isEmpty(req.getParameter("log"))) {
      log.info("Applying prerouting filter...");
    }

    return null;
  }
}
