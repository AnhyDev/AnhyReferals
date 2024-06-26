package ink.anh.referals;

import org.bukkit.configuration.file.FileConfiguration;

public class FamilyConfig {

    
    private String marriedSymbol;
    
    private boolean nonBinary;
    

    private static FamilyConfig instance;

    private FamilyConfig(AnhyReferrals plugin) {
        loadConfig(plugin);
    }

    public static FamilyConfig getInstance(AnhyReferrals plugin) {
        if (instance == null) {
            instance = new FamilyConfig(plugin);
        }
        return instance;
    }

    public void reloadConfig(AnhyReferrals plugin) {
        loadConfig(plugin);
    }

    private void loadConfig(AnhyReferrals plugin) {
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
