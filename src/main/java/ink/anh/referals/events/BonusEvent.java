package ink.anh.referals.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BonusEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player referrer;
    private final Player referral;
    private final int bonusId;

    public BonusEvent(Player referrer, Player referral, int bonusId) {
        this.referrer = referrer;
        this.referral = referral;
        this.bonusId = bonusId;
    }

    public Player getReferrer() {
        return referrer;
    }

    public Player getRreferral() {
        return referral;
    }

    public int getBonusId() {
        return bonusId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
