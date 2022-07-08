package nl.hu.bep.webservices;

import nl.hu.bep.domain.Move;

public class MoveResponse {
    public Move move;
    public String shout;

    public MoveResponse(Move move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}
