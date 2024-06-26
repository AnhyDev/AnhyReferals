package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;

public class VillagerTradeAchievement extends Achievement {
    private int tradesCompleted; // Кількість завершених торгів

    public VillagerTradeAchievement(String description, int value, LocalDateTime dateReceived, int tradesCompleted) {
        super(description, value, dateReceived);
        this.tradesCompleted = tradesCompleted;
    }

    public int getTradesCompleted() {
        return tradesCompleted;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("tradesCompleted", tradesCompleted);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.tradesCompleted = json.get("tradesCompleted").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.VILLAGER_TRADE;
    }

    @Override
    public String toString() {
        return "VillagerTradeAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", tradesCompleted=" + tradesCompleted +
                '}';
    }
}
