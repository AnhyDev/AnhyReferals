package ink.anh.referals;

import org.bukkit.plugin.java.JavaPlugin;

public class AnhyReferrals extends JavaPlugin {
    
    private static AnhyReferrals instance;

    // Method called when the plugin is enabled.
    @Override
    public void onEnable() {
        // Assign the current instance to the static variable.
        instance = this;


    }

    public static AnhyReferrals getInstance() {
        return instance;
    }
}
