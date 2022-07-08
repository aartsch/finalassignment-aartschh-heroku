package nl.hu.bep.webservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleSnakeRequest {
    public Map<String, Object> game;
    public int turn;
    public Map<String, Object> you;
    public Map<String, Object> customizations;
}
