package ink.anh.referals.achievements;

import com.google.gson.JsonObject;

import java.time.LocalDateTime;

public class TimeSpentAchievement extends Achievement {
    private long timeSpent; // Час проведений на сервері в мілісекундах

    public TimeSpentAchievement(String description, int value, LocalDateTime dateReceived, long timeSpent) {
        super(description, value, dateReceived);
        this.timeSpent = timeSpent;
    }

    public long getTimeSpent() {
        return timeSpent;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("timeSpent", timeSpent);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.timeSpent = json.get("timeSpent").getAsLong();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.TIME_SPENT;
    }

    @Override
    public String toString() {
        return "TimeSpentAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", timeSpent=" + timeSpent +
                '}';
    }
}
