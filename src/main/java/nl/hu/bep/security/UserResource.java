package nl.hu.bep.security;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("/register")
public class UserResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(AuthenticationRequest requestData) {
        int users = User.getAllUsers().size();
        User newUser = new User(requestData.username, requestData.password, "user");

        if (User.getAllUsers().size() > users) {
            return Response.ok(newUser).build();
        } else {
            return Response.status(409)
                    .entity(new AbstractMap.SimpleEntry<>("error", "user already exists!"))
                    .build();
        }
    }
}
