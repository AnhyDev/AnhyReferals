package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;

public class PvpKillsAchievement extends Achievement {
    private int playersKilled; // Кількість знищених гравців

    public PvpKillsAchievement(String description, int value, LocalDateTime dateReceived, int playersKilled) {
        super(description, value, dateReceived);
        this.playersKilled = playersKilled;
    }

    public int getPlayersKilled() {
        return playersKilled;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("playersKilled", playersKilled);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.playersKilled = json.get("playersKilled").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.PVP_KILLS;
    }

    @Override
    public String toString() {
        return "PvpKillsAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", playersKilled=" + playersKilled +
                '}';
    }
}
