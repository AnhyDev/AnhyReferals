package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.Material;

public class ItemsCollectedAchievement extends Achievement {
    private Material itemType; // Тип предмету
    private int amountCollected; // Кількість зібраних предметів

    public ItemsCollectedAchievement(String description, int value, LocalDateTime dateReceived, Material itemType, int amountCollected) {
        super(description, value, dateReceived);
        this.itemType = itemType;
        this.amountCollected = amountCollected;
    }

    public Material getItemType() {
        return itemType;
    }

    public int getAmountCollected() {
        return amountCollected;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("itemType", itemType.toString());
        json.addProperty("amountCollected", amountCollected);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.itemType = Material.valueOf(json.get("itemType").getAsString());
        this.amountCollected = json.get("amountCollected").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.ITEMS_COLLECTED;
    }

    @Override
    public String toString() {
        return "ItemsCollectedAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", itemType=" + itemType +
                ", amountCollected=" + amountCollected +
                '}';
    }
}
