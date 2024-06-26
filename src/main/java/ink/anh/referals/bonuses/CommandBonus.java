package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public class CommandBonus extends Bonus {
    private String command; // Команда для виконання

    public CommandBonus(String command, int value) {
        super(value);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public JsonObject serialize() {
        JsonObject json = new JsonObject();
        json.addProperty("type", getType().toString());
        json.addProperty("command", command);
        json.addProperty("value", value);
        return json;
    }

    @Override
    public void deserialize(JsonObject json) {
        this.command = json.get("command").getAsString();
        this.value = json.get("value").getAsInt();
    }

    @Override
    public BonusType getType() {
        return BonusType.COMMAND_BONUS;
    }

    @Override
    public String toString() {
        return "CommandBonus{" +
                "command='" + command + '\'' +
                ", value=" + value +
                '}';
    }
}
