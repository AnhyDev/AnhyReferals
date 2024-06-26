package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public class PointsBonus extends Bonus {

    public PointsBonus(int points) {
        super(points);
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("points", value);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.value = json.get("points").getAsInt();
    }

    @Override
    public BonusType getType() {
        return BonusType.POINTS_BONUS;
    }

    @Override
    public String toString() {
        return "PointsBonus{" +
                "points=" + value +
                '}';
    }
}
