package com.bips.service;

import com.bips.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

/**
 * Created by ahadcse on 24/03/16.
 */

@Component
public class UserManager extends JdbcUserDetailsManager {

    @Value("${default.super.admin.user}")
    private String defaultAdminUsername;

    @Value("${default.super.admin.password}")
    private String defaultAdminPassword;

    @Value("{default.admin.role}")
    private String defaultAdmin;

    @Value("{default.user.role}")
    private String defaultUser;

    public static final String DEF_USERS_WITH_AUTHORITY_SQL = "select distinct username FROM authorities where authority = ?";
    private String usersWithAuthoritySql = DEF_USERS_WITH_AUTHORITY_SQL;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserManager(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void init() {
        if(!userExists(defaultAdminUsername)) {
            Registration registration = new Registration();
            registration.setUsername(defaultAdminUsername);
            registration.setPassword(defaultAdminPassword);
            createUser(createUserDetails(registration, defaultAdmin));
        }
    }

    // For normal user. Will be called from the API.
    public void createUser(Registration registration) {
        createUser(createUserDetails(registration, defaultUser));
    }

    public String[] listAllUsersWithRole(String userRole) {
        return (String[]) getJdbcTemplate().queryForList(usersWithAuthoritySql, new String[] {userRole}, String.class).toArray(new String[0]);
    }

    private UserDetails createUserDetails(Registration registration, String userRole) {
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(userRole));
        return new User(registration.getUsername(), passwordEncoder.encode(registration.getPassword()), authorities);
    }
}
