package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public class EventBonus extends Bonus {

    public EventBonus(int bonusId) {
        super(bonusId);
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("bonusId", value);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.value = json.get("bonusId").getAsInt();
    }

    @Override
    public BonusType getType() {
        return BonusType.EVENT_BONUS;
    }

    @Override
    public String toString() {
        return "EventBonus{" +
                "bonusId=" + value +
                '}';
    }
}
