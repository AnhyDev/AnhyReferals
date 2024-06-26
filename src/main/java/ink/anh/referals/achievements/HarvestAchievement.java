package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.Material;

public class HarvestAchievement extends Achievement {
    private Material cropType; // Тип сільськогосподарської культури
    private int amountHarvested; // Кількість зібраних культур

    public HarvestAchievement(String description, int value, LocalDateTime dateReceived, Material cropType, int amountHarvested) {
        super(description, value, dateReceived);
        this.cropType = cropType;
        this.amountHarvested = amountHarvested;
    }

    public Material getCropType() {
        return cropType;
    }

    public int getAmountHarvested() {
        return amountHarvested;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("cropType", cropType.toString());
        json.addProperty("amountHarvested", amountHarvested);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.cropType = Material.valueOf(json.get("cropType").getAsString());
        this.amountHarvested = json.get("amountHarvested").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.HARVEST;
    }

    @Override
    public String toString() {
        return "HarvestAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", cropType=" + cropType +
                ", amountHarvested=" + amountHarvested +
                '}';
    }
}
