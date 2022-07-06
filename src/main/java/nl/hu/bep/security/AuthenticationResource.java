package nl.hu.bep.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.List;


@Path("/login")
public class AuthenticationResource {
    public static Key key = MacProvider.generateKey();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginWebservice(AuthenticationRequest loginData) {
        //temporary function instead of registering users
        User.initializeUsers();

        for (User user  : User.getAllUsers()) {

            if (user.getName().equals(loginData.username) &&
                    user.checkPassword(loginData.password)) {

                String jwt = Jwts.builder()
                        .setSubject(loginData.username)
                        .claim("role", user.getRole())
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();

                return Response.ok(new AbstractMap.SimpleEntry<>("JWT-token", jwt)).build();
            }
        }

        return Response.status(406).build();
    }
}
