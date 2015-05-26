package com.webapplication.servlet.controller.common;
import com.sun.media.sound.InvalidDataException;
import com.webapplication.servlet.service.DataBase.AccountsDao;
import org.apache.commons.lang.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public class RegistrationServletHandler extends CommonServletHandler {

    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {

            forwardToJSP("registration", request, response);

        } else {
            registrationHandler(request, response);
        }

    }

    protected void validateRequest(String username, String email, String password, String confirmPass, String firstName,
                                   String lastName) throws InvalidDataException {

        if (StringUtils.isBlank(username)) {

            throw new InvalidDataException("Username is blank");
        } else if (StringUtils.isBlank(email)) {

            throw new InvalidDataException("Email is blank");

        } else if (StringUtils.isBlank(password)) {

            throw new InvalidDataException("Password is blank");
        } else if (StringUtils.isBlank(confirmPass)) {

            throw new InvalidDataException("Password is blank");
        } else if (StringUtils.isBlank(firstName)) {

            throw new InvalidDataException("First name is blank");
        } else if (StringUtils.isBlank(lastName)) {

            throw new InvalidDataException("Last name is blank");

        } else if (!password.equals(confirmPass)) {

            throw new InvalidDataException("Different passwords");
        } else if (!email.matches(".*@.*")){
            throw new InvalidDataException("Incorrect email");
        }
    }

    protected void registrationHandler(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPass");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");



        try {
            validateRequest(username, email, password, confirmPass, firstName, lastName);
            AccountsDao dao = new AccountsDao();
            dao.saveAccount(username, email, password, firstName, lastName);
            redirectRequest("/login.php", request, response);
        } catch (InvalidDataException a) {
            request.setAttribute("error_message", a.getMessage());
            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("confirmPass", request.getParameter("confirmPass"));
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("lastName", request.getParameter("lastName"));
            forwardToJSP("registration", request, response);

        }

    }


}



