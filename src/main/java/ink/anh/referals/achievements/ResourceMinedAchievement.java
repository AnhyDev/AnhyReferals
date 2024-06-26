package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.Material;

public class ResourceMinedAchievement extends Achievement {
    private Material resourceType; // Тип ресурсу
    private int amountMined; // Кількість видобутих ресурсів

    public ResourceMinedAchievement(String description, int value, LocalDateTime dateReceived, Material resourceType, int amountMined) {
        super(description, value, dateReceived);
        this.resourceType = resourceType;
        this.amountMined = amountMined;
    }

    public Material getResourceType() {
        return resourceType;
    }

    public int getAmountMined() {
        return amountMined;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("resourceType", resourceType.toString());
        json.addProperty("amountMined", amountMined);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.resourceType = Material.valueOf(json.get("resourceType").getAsString());
        this.amountMined = json.get("amountMined").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.RESOURCE_MINED;
    }

    @Override
    public String toString() {
        return "ResourceMinedAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", resourceType=" + resourceType +
                ", amountMined=" + amountMined +
                '}';
    }
}
