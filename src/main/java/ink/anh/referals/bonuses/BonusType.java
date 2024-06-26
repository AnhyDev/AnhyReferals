package ink.anh.referals.bonuses;

public enum BonusType {
    POINTS_BONUS,
    ITEM_BONUS,
    COMMAND_BONUS,
    CURRENCY_BONUS,
    EVENT_BONUS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
