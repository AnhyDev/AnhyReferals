package ink.anh.referals.system;

import java.util.Objects;

import ink.anh.referals.bonuses.BonusType;

public class BonusIdentifier {
    private BonusType bonusType;
    private int value;

    public BonusIdentifier(BonusType bonusType, int value) {
        this.bonusType = bonusType;
        this.value = value;
    }

    public BonusType getClassName() {
        return bonusType;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusIdentifier that = (BonusIdentifier) o;
        return value == that.value && Objects.equals(bonusType, that.bonusType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusType, value);
    }

    @Override
    public String toString() {
        return "BonusIdentifier{" +
                "className='" + bonusType + '\'' +
                ", value=" + value +
                '}';
    }
}
