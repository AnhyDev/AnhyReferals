package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public class ItemBonus extends Bonus {
    private String itemName; // Назва предмету

    public ItemBonus(String itemName, int quantity) {
        super(quantity);
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("itemName", itemName);
        json.addProperty("quantity", value);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.itemName = json.get("itemName").getAsString();
        this.value = json.get("quantity").getAsInt();
    }

    @Override
    public BonusType getType() {
        return BonusType.ITEM_BONUS;
    }

    @Override
    public String toString() {
        return "ItemBonus{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + value +
                '}';
    }
}
