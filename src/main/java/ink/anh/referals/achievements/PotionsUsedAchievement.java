package ink.anh.referals.achievements;

import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import org.bukkit.potion.PotionType;

public class PotionsUsedAchievement extends Achievement {
    private PotionType potionType; // Тип зілля
    private int amountUsed; // Кількість використаних зіль

    public PotionsUsedAchievement(String description, int value, LocalDateTime dateReceived, PotionType potionType, int amountUsed) {
        super(description, value, dateReceived);
        this.potionType = potionType;
        this.amountUsed = amountUsed;
    }

    public PotionType getPotionType() {
        return potionType;
    }

    public int getAmountUsed() {
        return amountUsed;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("description", description);
        json.addProperty("value", value);
        json.addProperty("dateReceived", dateReceived.toString());
        json.addProperty("potionType", potionType.toString());
        json.addProperty("amountUsed", amountUsed);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.description = json.get("description").getAsString();
        this.value = json.get("value").getAsInt();
        this.dateReceived = LocalDateTime.parse(json.get("dateReceived").getAsString());
        this.potionType = PotionType.valueOf(json.get("potionType").getAsString());
        this.amountUsed = json.get("amountUsed").getAsInt();
    }

    @Override
    public AchievementType getType() {
        return AchievementType.POTIONS_USED;
    }

    @Override
    public String toString() {
        return "PotionsUsedAchievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                ", potionType=" + potionType +
                ", amountUsed=" + amountUsed +
                '}';
    }
}
