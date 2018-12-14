package com.shanijeet.inventory.microservices.netflixzuulmicroservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Marker;
import org.springframework.cloud.netflix.zuul.ZuulRouteApplicationContextInitializer;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter  extends ZuulFilter {

    private Logger logger=LoggerFactory.getLogger(this.getClass());


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {

        HttpServletRequest servletRequest=RequestContext.getCurrentContext().getRequest();
        //servletRequest.g
        logger.info("Request --> {}", servletRequest,servletRequest.getRequestURI());
        return null;
    }
}
