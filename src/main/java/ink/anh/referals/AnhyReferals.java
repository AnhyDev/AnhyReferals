package ink.anh.referals;

import org.bukkit.plugin.java.JavaPlugin;

public class AnhyReferals extends JavaPlugin {
    
    private static AnhyReferals instance;

    // Method called when the plugin is enabled.
    @Override
    public void onEnable() {
        // Assign the current instance to the static variable.
        instance = this;


    }

    public static AnhyReferals getInstance() {
        return instance;
    }
}
