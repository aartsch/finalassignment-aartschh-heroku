package nl.hu.bep.webservices;

import nl.hu.bep.domain.Move;

public class MoveResponse {
    public Enum<Move> move;
    public String shout;

    public MoveResponse(Enum move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}
