package com.webapplication.servlet.controller.admin;

import com.webapplication.servlet.controller.common.CommonServletHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public class AdminHomeServletHandler extends CommonServletHandler {
    private static final long serialVersionUID = 2821398058404801717L;

    @Override
    protected void handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
        forwardToJSP("admin/home", request, response);
    }
}
