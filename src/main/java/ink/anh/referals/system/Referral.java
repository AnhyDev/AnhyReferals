package ink.anh.referals.system;

import com.google.gson.*;
import ink.anh.referals.achievements.Achievement;
import ink.anh.referals.bonuses.Bonus;
import ink.anh.referals.events.PlayerBonusReceivedEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class Referral {

    private UUID playerId;
    private UUID referrerId;
    private Set<UUID> referrals;
    private List<Achievement> achievements;
    private Map<UUID, List<BonusIdentifier>> referralBonuses;

    // Конструктор для створення нового реферала без реферера
    public Referral(UUID playerId) {
        this.playerId = playerId;
        this.referrals = new HashSet<>();
        this.achievements = new ArrayList<>();
        this.referralBonuses = new HashMap<>();
    }

    public Referral(UUID playerId, UUID referrerId) {
        this.playerId = playerId;
        this.referrerId = referrerId;
        this.referrals = new HashSet<>();
        this.achievements = new ArrayList<>();
        this.referralBonuses = new HashMap<>();
    }

    // Геттер для playerId
    public UUID getPlayerId() {
        return playerId;
    }

    // Геттер для referrerId
    public UUID getReferrerId() {
        return referrerId;
    }

    // Геттер для набору рефералів
    public Set<UUID> getReferrals() {
        return referrals;
    }

    // Геттер для досягнень
    public List<Achievement> getAchievements() {
        return achievements;
    }

    // Метод для додавання нового реферала
    public void addReferral(UUID playerId) {
        referrals.add(playerId);
    }

    // Метод для встановлення реферера
    public void setReferrerId(UUID referrerId) {
        this.referrerId = referrerId;
    }

    // Метод для додавання досягнення
    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    // Метод для отримання мапи бонусів
    public Map<UUID, List<BonusIdentifier>> getReferralBonuses() {
        return referralBonuses;
    }

    // Метод для додавання бонусу від реферала
    public void addReferralBonus(UUID playerId, Bonus bonus) {
        List<BonusIdentifier> bonuses = referralBonuses.computeIfAbsent(playerId, k -> new ArrayList<>());
        bonuses.add(new BonusIdentifier(bonus.getType(), bonus.getValue()));

        // Трансляція події
        Player player = Bukkit.getPlayer(this.playerId);
        if (player != null) {
            PlayerBonusReceivedEvent event = new PlayerBonusReceivedEvent(player, this.referrerId, playerId, bonus);
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

    // Метод для серіалізації об'єкта в JSON
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    // Метод для десеріалізації JSON в об'єкт
    public static Referral fromJson(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Referral.class);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Referral other = (Referral) obj;
        return Objects.equals(playerId, other.playerId);
    }
}
