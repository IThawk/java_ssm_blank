package com.ithawk.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter
  implements Filter
{
  /**
   * 跨域请求方法
   */
  public static final String  CORS_METHOD="Access-Control-Request-Method";

  /**
   * 跨域请求预请求头
   */
  public static final String PREVIEW_HEADER="OPTIONS";
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
  {


    HttpServletResponse response = (HttpServletResponse)res;
    HttpServletRequest request = (HttpServletRequest)req;





    response.setHeader("Access-Control-Allow-Origin", "*");
    
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, " +
            "Accept, Access-Control-Request-Method, Access-Control-Request-Headers, verifyId, " +
            "Access-Control-Allow-Origin,authorization,token,cache-control,pragma,enctype");
    if ((request.getHeader(CORS_METHOD) != null) && (PREVIEW_HEADER.equals(request.getMethod())))
    {
      response.setStatus(200);
      return;
    }
    chain.doFilter(req, res);
  }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig arg0)
    throws ServletException
  {}
}
