package com.webapplication.servlet.service.interfaces;

import com.webapplication.servlet.exceptions.CommonException;
import com.webapplication.servlet.exceptions.InvalidDataException;
import com.webapplication.servlet.model.Account;
import com.webapplication.servlet.model.Role;

import java.util.List;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public interface DataService extends AutoCloseable {

    Account login(String username, String password, Integer role) throws InvalidDataException;
    List<Role> listRoles() throws CommonException;

}
