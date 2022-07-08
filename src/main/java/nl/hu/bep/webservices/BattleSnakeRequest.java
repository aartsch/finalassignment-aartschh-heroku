package nl.hu.bep.webservices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BattleSnakeRequest {
    public int turn;
    public Map<String, Object> you;
    public Map<String, Object> customizations;
}
