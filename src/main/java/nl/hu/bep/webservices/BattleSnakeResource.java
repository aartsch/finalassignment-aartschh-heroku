package nl.hu.bep.webservices;

import nl.hu.bep.domain.Game;
import nl.hu.bep.domain.GameInformation;
import nl.hu.bep.domain.Move;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/snake")
public class BattleSnakeResource {
    private static GameInformation info = new GameInformation();
    private static Game game;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo() {

        return Response.ok(info).build();
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSnake(GameInformationRequest request) {
        System.out.println(request.color);

        info.setColor(request.color);
        info.setHead(request.head);
        info.setTail(request.tail);

        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startGame(BattleSnakeRequest request) {
        game = new Game((String) request.game.get("id"));

        System.out.println(Game.getIdsFromAllGames());

        return Response.ok(game).build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {

        return Response.ok().build();
    }

    @GET
    @Path("/game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGameIds() {
        List<String> allGameIds = Game.getIdsFromAllGames();


        return Response.ok(allGameIds).build();
    }

    @GET
    @Path("/game/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameDetailsById(@PathParam("id") String id) {
        String gameDetails = Game.getGameDetailsById(id);

        return Response.ok(gameDetails).build();
    }

    @DELETE
    @Path("/game/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeGameById(@PathParam("id") String id) {
        return Game.removeGame(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(BattleSnakeRequest request ) {
        game.setTurn(request.turn);

        MoveResponse move;
        move = new MoveResponse(Move.UP, "Going up!");

        return Response.ok(move).build();
    }
}

