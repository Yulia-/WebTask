package com.webapplication.servlet.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public class ErrorServletHandler extends CommonServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forwardToJSP("error.jsp", request, response);
    }
}
