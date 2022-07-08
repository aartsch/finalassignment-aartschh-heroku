package nl.hu.bep.webservices;

import nl.hu.bep.domain.Game;
import nl.hu.bep.domain.GameInformation;
import nl.hu.bep.domain.GameState;
import nl.hu.bep.domain.Move;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/snake")
public class BattleSnakeResource {
    private static GameInformation gameInfo = new GameInformation();
    private static Game game;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameInfo() {
        Map<String, String> messages = new HashMap<>();
        messages.put("error", "Game was not initialized correctly");

        if (gameInfo != null) {
            return Response.ok(gameInfo).build();
        } else return  Response.status(409).entity(messages).build();
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSnake(GameInformationRequest request) {

        gameInfo.setColor(request.color);
        gameInfo.setHead(request.head);
        gameInfo.setTail(request.tail);

        return Response.ok(gameInfo).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startGame(BattleSnakeRequest request) {
        Map<String, String> messages = new HashMap<>();
        messages.put("error", "Game with this id already exists");

        game = new Game((String) request.game.get("id"));
        game.setState(GameState.PLAYING);

        return Response.ok(game).build();
    }

    @POST
    @Path("/end")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame(BattleSnakeRequest request) {
        Map<String, String> messages = new HashMap<>();
        messages.put("error", "Game with this id is already over");

        if(game.getState().equals(GameState.OVER)) {
            return Response.status(Response.Status.CONFLICT).entity(messages).build();
        }

        game.setTurn(request.turn);
        game.setState(GameState.OVER);
        return Response.ok(game).build();
    }

    @GET
    @Path("/game")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGameIds() {
        Map<String, String> messages = new HashMap<>();
        messages.put("error", "There are no existing games");

        if(Game.getIdsFromAllGames().equals(null)) {
            return Response.status(Response.Status.CONFLICT).entity(messages).build();
        }
        List<String> allGameIds = Game.getIdsFromAllGames();
        return Response.ok(allGameIds).build();
    }

    @GET
    @Path("/game/{gameid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameDetailsById(@PathParam("gameid") String id) {
        Map<String, String> messages = new HashMap<>();
        messages.put("error", "This game doesn't exist");



        if(Game.getGameDetailsById(id).equals(null)) {
            return Response.status(Response.Status.CONFLICT).entity(messages).build();
        }
        String gameDetails = Game.getGameDetailsById(id);

        return Response.ok(gameDetails).build();
    }

    @DELETE
    @Path("/game/{gameid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeGameById(@PathParam("gameid") String id) {
        return Game.removeGame(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //niet met de mooie manier van requests gedaan omdat ik niet de head coordinates kon krijgen
    public Response move(String body ) {
        JsonReader reader = Json.createReader(new StringReader(body));
        int yHead =  reader.readObject().getJsonObject("you").getJsonObject("head").getInt("y");

        MoveResponse move = null;

        Map<String, String> messages = new HashMap<>();
        messages.put("error", "This game is already over");

        if(Game.getAllGames() == null || game.getState() != GameState.PLAYING) {
            return Response.status(Response.Status.CONFLICT).entity(messages).build();
        }
        // (als head top coordinate + 1 > 10 && right coordinate + 1 > 10  )Move.right, move.down
        if(yHead + 1 >= 5   ) {
            move = new MoveResponse(Move.RIGHT, "Going up!");
        } else {
            move = new MoveResponse(Move.UP, "Going up!");
        }

        return Response.ok(move).build();
    }
}

