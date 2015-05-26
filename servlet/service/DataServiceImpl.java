package com.webapplication.servlet.service;


import com.webapplication.servlet.exceptions.CommonException;
import com.webapplication.servlet.exceptions.InvalidDataException;
import com.webapplication.servlet.model.Account;
import com.webapplication.servlet.model.Role;
import com.webapplication.servlet.service.interfaces.DataService;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public class DataServiceImpl implements DataService {
    @Override
    public Account login(String username, String password, Integer role) throws InvalidDataException {

        for(Account a : DataStorage.ALL_ACCOUNTS) {

            if(StringUtils.equals(username, a.getUsername())) {

                if(StringUtils.equals(password, a.getPassword())) {

                    for(Role currentRole : a.getRoles()) {

                        if(currentRole.getId().equals(role)) {

                            return a;
                        }
                    }

                    throw new InvalidDataException("Invalid role");
                } else {

                    throw new InvalidDataException("Invalid password");
                }
            }
        }
        throw new InvalidDataException("Account not found");
    }

    @Override
    public List<Role> listRoles() throws CommonException {
        return DataStorage.ALL_ROLES;
    }

    @Override
    public void close() {

    }
}
