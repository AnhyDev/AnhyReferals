package ink.anh.referals.achievements;

import java.time.LocalDateTime;
import java.util.Objects;

import com.google.gson.JsonObject;

public abstract class Achievement {
    protected String description; // Опис досягнення
    protected int value; // Числовий аргумент для варіантів досягнень
    protected LocalDateTime dateReceived; // Дата отримання досягнення

    public Achievement(String description, int value, LocalDateTime dateReceived) {
        this.description = description;
        this.value = value;
        this.dateReceived = dateReceived;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public LocalDateTime getDateReceived() {
        return dateReceived;
    }

    // Абстрактний метод для серіалізації досягнення в JSON
    public abstract JsonObject serialize();

    // Абстрактний метод для десеріалізації досягнення з JSON
    public abstract void deserialize(JsonObject json);

    // Абстрактний метод для отримання типу досягнення
    public abstract AchievementType getType();

    @Override
    public String toString() {
        return "Achievement{" +
                "description='" + description + '\'' +
                ", value=" + value +
                ", dateReceived=" + dateReceived +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
        return value == that.value && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), value);
    }
}
