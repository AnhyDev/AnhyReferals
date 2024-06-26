package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import java.time.Duration;

public class SurvivalTimeAchievement extends Achievement {
    private Duration survivalTime; // Час виживання

    public SurvivalTimeAchievement(String description, int value, LocalDateTime dateReceived, Duration survivalTime) {
        super(description, value, dateReceived);
        this.survivalTime = survivalTime;
    }

    public Duration getSurvivalTime() {
        return survivalTime;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("survivalTime", survivalTime.toString());
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.survivalTime = Duration.parse(json.get("survivalTime").getAsString());
    }

    @Override
    public AchievementType getType() {
        return AchievementType.SURVIVAL_TIME;
    }

    @Override
    public String toString() {
        return "SurvivalTimeAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", survivalTime=" + survivalTime +
                '}';
    }
}
