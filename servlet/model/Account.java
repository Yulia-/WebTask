package com.webapplication.servlet.model;

import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by Þëÿ on 05.05.2015.
 */
public class Account extends CommonModelBean {
    private static final Logger LOGGER = Logger.getLogger(Account.class);
    private static final long serialVersionUID = -5787220666753301113L;


    private String username;
    private String password;
    private List<Role> roles;


    public Account() {
        super();
    }

    public Account(String username, String password, List<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Account(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    protected Object getIdModel() {
        return getUsername();
    }
}
