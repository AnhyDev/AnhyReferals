package ink.anh.referals.bonuses;

import com.google.gson.JsonObject;

public abstract class Bonus {
    protected int value; // Числове поле для ідентифікації бонусу

    public Bonus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Абстрактний метод для серіалізації бонусу в JSON
    public abstract JsonObject serialize();

    // Абстрактний метод для десеріалізації бонусу з JSON
    public abstract void deserialize(JsonObject json);

    // Метод для отримання типу бонусу
    public abstract BonusType getType();

    @Override
    public String toString() {
        return "Bonus{" +
                "value=" + value +
                '}';
    }
}
