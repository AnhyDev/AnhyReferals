package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;

public class FishingAchievement extends Achievement {
    private int fishCaught; // Кількість виловленої риби

    public FishingAchievement(String description, int value, LocalDateTime dateReceived, int fishCaught) {
        super(description, value, dateReceived);
        this.fishCaught = fishCaught;
    }

    public int getFishCaught() {
        return fishCaught;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("fishCaught", fishCaught);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.fishCaught = json.get("fishCaught").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.FISHING;
    }

    @Override
    public String toString() {
        return "FishingAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", fishCaught=" + fishCaught +
                '}';
    }
}
