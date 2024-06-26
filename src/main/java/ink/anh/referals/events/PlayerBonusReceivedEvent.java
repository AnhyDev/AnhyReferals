package ink.anh.referals.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import ink.anh.referals.bonuses.Bonus;

import java.util.UUID;

public class PlayerBonusReceivedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final UUID referrer;
    private final UUID referral;
    private final Bonus bonus;

    public PlayerBonusReceivedEvent(Player player, UUID referrer, UUID referral, Bonus bonus) {
        this.player = player;
        this.referrer = referrer;
        this.referral = referral;
        this.bonus = bonus;
    }

    public Player getPlayer() {
        return player;
    }

    public UUID getReferrer() {
        return referrer;
    }

    public UUID getReferral() {
        return referral;
    }

    public Bonus getBonus() {
        return bonus;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
