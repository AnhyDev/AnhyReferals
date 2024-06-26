package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;

public class LevelReachedAchievement extends Achievement {
    private int level; // Досягнутий рівень

    public LevelReachedAchievement(String description, int value, LocalDateTime dateReceived, int level) {
        super(description, value, dateReceived);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("level", level);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.level = json.get("level").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.LEVEL_REACHED;
    }

    @Override
    public String toString() {
        return "LevelReachedAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", level=" + level +
                '}';
    }
}
