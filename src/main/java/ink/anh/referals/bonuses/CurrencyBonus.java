package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public class CurrencyBonus extends Bonus {
    public CurrencyBonus(int amount) {
        super(amount);
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("amount", value);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.value = json.get("amount").getAsInt();
    }

    @Override
    public BonusType getType() {
        return BonusType.CURRENCY_BONUS;
    }

    @Override
    public String toString() {
        return "CurrencyBonus{" +
                "amount=" + value +
                '}';
    }
}
