package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.Material;

public class ItemsCraftedAchievement extends Achievement {
    private Material itemType; // Тип предмету
    private int amountCrafted; // Кількість створених предметів

    public ItemsCraftedAchievement(String description, int value, LocalDateTime dateReceived, Material itemType, int amountCrafted) {
        super(description, value, dateReceived);
        this.itemType = itemType;
        this.amountCrafted = amountCrafted;
    }

    public Material getItemType() {
        return itemType;
    }

    public int getAmountCrafted() {
        return amountCrafted;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("itemType", itemType.toString());
        json.addProperty("amountCrafted", amountCrafted);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.itemType = Material.valueOf(json.get("itemType").getAsString());
        this.amountCrafted = json.get("amountCrafted").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.ITEMS_CRAFTED;
    }

    @Override
    public String toString() {
        return "ItemsCraftedAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", itemType=" + itemType +
                ", amountCrafted=" + amountCrafted +
                '}';
    }
}
