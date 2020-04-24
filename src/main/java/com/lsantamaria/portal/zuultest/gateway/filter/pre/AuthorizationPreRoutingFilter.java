package com.lsantamaria.portal.zuultest.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.lsantamaria.portal.zuultest.gateway.service.AuthService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * An example implementation of a pre-routing filter. This filter is executing before {@link
 * org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter} and make an external call
 * to authenticate the user and adds the auth token received to the request going to downstream
 * services.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthorizationPreRoutingFilter extends ZuulFilter {

  public static final int AUTH_FILTER_ORDER = LogPreRoutingFilter.LOG_FILTER_ORDER + 1;

  public final AuthService authService;

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return AUTH_FILTER_ORDER;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest req = ctx.getRequest();
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    String authToken = authService.performAuthentication(username, password);

    ctx.addZuulRequestHeader("Authorization", authToken);

    return null;
  }
}
