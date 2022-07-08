package nl.hu.bep.webservices;

import nl.hu.bep.domain.GameInformation;
import nl.hu.bep.domain.Move;
import org.glassfish.jersey.server.model.internal.ResourceMethodInvocationHandlerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/snake")
public class BattleSnakeResource {
    private GameInformation info = new GameInformation();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo() {

        return Response.ok(info).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSnake(GameInformationRequest request) {
        System.out.println(request.color);

        info.setColor(request.color);
        info.setColor(request.head);
        info.setColor(request.tail);

        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startGame() {

        return Response.ok().build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {

        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(BattleSnakeRequest request ) {

        System.out.println(  request.you.get("customizations"));


        MoveResponse move;


        move = new MoveResponse(Move.UP, "Going up!");


        return Response.ok(move).build();
    }
}

