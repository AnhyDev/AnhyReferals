package ink.anh.referals.achievements;

public enum AchievementType {
    TIME_SPENT,
    VILLAGER_TRADE,
    RESOURCE_MINED,
    MOBS_KILLED,
    ITEMS_COLLECTED,
    FISHING,
    BIOMES_EXPLORED,
    POTIONS_USED,
    LEVEL_REACHED,
    PVP_KILLS,
    SURVIVAL_TIME,
    ITEMS_CRAFTED,
    HARVEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
