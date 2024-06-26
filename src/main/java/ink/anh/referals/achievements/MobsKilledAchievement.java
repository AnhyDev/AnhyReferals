package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.entity.EntityType;

public class MobsKilledAchievement extends Achievement {
    private EntityType mobType; // Тип моба
    private int amountKilled; // Кількість знищених мобів
    private String uniqueName; // Унікальне ім'я моба (може бути null)

    public MobsKilledAchievement(String description, int value, LocalDateTime dateReceived, EntityType mobType, int amountKilled, String uniqueName) {
        super(description, value, dateReceived);
        this.mobType = mobType;
        this.amountKilled = amountKilled;
        this.uniqueName = uniqueName;
    }

    public EntityType getMobType() {
        return mobType;
    }

    public int getAmountKilled() {
        return amountKilled;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("mobType", mobType.toString());
        json.addProperty("amountKilled", amountKilled);
        if (uniqueName != null) {
            json.addProperty("uniqueName", uniqueName);
        }
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.mobType = EntityType.valueOf(json.get("mobType").getAsString());
        this.amountKilled = json.get("amountKilled").getAsInt();
        if (json.has("uniqueName")) {
            this.uniqueName = json.get("uniqueName").getAsString();
        } else {
            this.uniqueName = null;
        }
    }

    @Override
    public AchievementType getType() {
        return AchievementType.MOBS_KILLED;
    }

    @Override
    public String toString() {
        return "MobsKilledAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", mobType=" + mobType +
                ", amountKilled=" + amountKilled +
                ", uniqueName='" + uniqueName + '\'' +
                '}';
    }
}
