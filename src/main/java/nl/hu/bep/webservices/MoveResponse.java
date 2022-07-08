package nl.hu.bep.webservices;

import nl.hu.bep.domain.Move;

public class MoveResponse {
    public String move;
    public String shout;

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}
