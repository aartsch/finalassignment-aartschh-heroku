package nl.hu.bep.security;


import nl.hu.bep.security.User;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private User user;
    private boolean isSecure;

    public MySecurityContext(User user, boolean isSecure) {
        this.user = user;
        this.isSecure = isSecure;
    }

    @Override
    public Principal getUserPrincipal() {
        return user;
    }

    @Override
    public boolean isUserInRole(String s) {
        return user.getRole().equals(s);
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

    @Override
    public String getAuthenticationScheme() {
        return "Token-Based-Auth-Scheme";
    }
}
