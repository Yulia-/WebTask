package com.webapplication.servlet.controller.common;

import com.webapplication.servlet.service.CommonServiceManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Þëÿ on 05.05.2015.
 */
public abstract class CommonServletHandler extends HttpServlet {
    private static final long serialVersionUID = 2616056221299712890L;

    protected final Logger LOGGER = Logger.getLogger(CommonServletHandler.class);
    private String contextName;
    protected CommonServiceManager manager;


    @Override
    public final void init(ServletConfig config) throws ServletException {

        contextName = config.getServletContext().getContextPath();
        manager = CommonServiceManager.getInstance(config.getServletContext());
        super.init(config);
    }

    /**
     * Additional code which does not allow to break a logic of CommonServletHandler
     */
    @Override
    protected final void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.service(req, resp);
    }

    @Override
    public final void service(ServletRequest req, ServletResponse res)throws ServletException, IOException {

        super.service(req, res);
    }

    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        handleCommonRequest(req, resp);
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        handleCommonRequest(req, resp);
    }

    @Override
    protected final void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        handleCommonRequest(req, resp);
    }


    private void handleCommonRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            preHandleRequest(request, response);
            handleRequest (request, response);
        } catch (Exception e) {

            LOGGER.error("Application can't fulfil this request", e);
            handleError(e, request, response);
        }
    }

    /**
     * Common request handler for all types of requests
     */

    protected abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws Exception;

    protected void preHandleRequest (HttpServletRequest request, HttpServletResponse response) throws Exception {

    }


    protected final String getContextName() {
        return contextName;
    }

    protected final void handleError (Exception ex, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("javax.servlet.error.exception", ex);
        forwardToJSP("error", request, response);
    }

    protected final void forwardToJSP(String jspName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("currentPage", String.format("../%s.jsp", jspName));
        forwardRequest("/WEB-INF/jsp/templates/page-template.jsp", request, response);
    }

    protected final void forwardRequest (String url, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(url).forward(request, response);
    }

    protected final void redirectRequest (String path, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(String.format("%s%s", contextName, path));
    }
}
