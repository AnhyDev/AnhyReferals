package ink.anh.referals;

import org.bukkit.configuration.file.FileConfiguration;

public class FamilyConfig {

    
    private String marriedSymbol;
    
    private boolean nonBinary;
    

    private static FamilyConfig instance;

    private FamilyConfig(AnhyReferals plugin) {
        loadConfig(plugin);
    }

    public static FamilyConfig getInstance(AnhyReferals plugin) {
        if (instance == null) {
            instance = new FamilyConfig(plugin);
        }
        return instance;
    }

    public void reloadConfig(AnhyReferals plugin) {
        loadConfig(plugin);
    }

    private void loadConfig(AnhyReferals plugin) {
        FileConfiguration config = plugin.getConfig();

        
        this.marriedSymbol = config.getString("marriedSymbol", "⚭");
        
        this.nonBinary = config.getBoolean("non_binary", false);
    }


    public String getMarriedSymbol() {
        return marriedSymbol;
    }

    public boolean isNonBinary() {
        return nonBinary;
    }
}
