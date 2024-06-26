package ink.anh.referals;

import java.io.File;
import org.bukkit.plugin.Plugin;

import ink.anh.api.LibraryManager;
import ink.anh.api.database.DatabaseManager;
import ink.anh.api.database.MySQLConfig;
import ink.anh.api.database.MySQLDatabaseManager;
import ink.anh.api.database.SQLiteDatabaseManager;
import ink.anh.api.lingo.Translator;
import ink.anh.api.lingo.lang.LanguageManager;
import ink.anh.api.messages.Logger;
import ink.anh.api.utils.SyncExecutor;
import ink.anh.referals.db.TableRegistry;
import ink.anh.referals.lang.LangMessage;
import net.md_5.bungee.api.ChatColor;

public class GlobalManager extends LibraryManager {

    private static GlobalManager instance;
    
    private final AnhyReferrals familyPlugin;

    private MySQLConfig mySQLConfig;
    private FamilyConfig familyConfig;
    
    private DatabaseManager dbManager;
    private LanguageManager langManager;
	
    private String pluginName;
    private String defaultLang;
    private boolean debug;
	
    private GlobalManager(AnhyReferrals familyPlugin) {
        super(familyPlugin);
        this.familyPlugin = familyPlugin;
        this.saveDefaultConfig();
        this.loadFields(familyPlugin);
    }

    public static synchronized GlobalManager getInstance() {
        if (instance == null) {
            instance = new GlobalManager(AnhyReferrals.getInstance());
            instance.initializeDatabase();

        }
        return instance;
    }

	@Override
    public Plugin getPlugin() {
        return familyPlugin;
    }

    @Override
    public String getPluginName() {
        return pluginName;
    }

    @Override
    public LanguageManager getLanguageManager() {
        return this.langManager;
    }

    @Override
    public String getDefaultLang() {
        return defaultLang;
    }

    @Override
    public boolean isDebug() {
        return debug;
    }

    public MySQLConfig getMySQLConfig() {
        return mySQLConfig;
    }

    public FamilyConfig getFamilyConfig() {
        return familyConfig;
    }

    public boolean reload() {
        SyncExecutor.runAsync(() -> {
            try {
                saveDefaultConfig();
                familyPlugin.reloadConfig();
                loadFields(familyPlugin);
                LangMessage.reloadInstance(instance);

                // Перезавантаження бази даних
                initializeDatabase();

                
                Logger.info(familyPlugin, Translator.translateKyeWorld(instance, "family_configuration_reloaded", new String[]{defaultLang}));
            } catch (Exception e) {
                e.printStackTrace();
                Logger.error(familyPlugin, Translator.translateKyeWorld(instance, "family_err_reloading_configuration", new String[]{defaultLang}));
            }
        });
        return true;
    }

    private void loadFields(AnhyReferrals familyPlugin) {
        defaultLang = familyPlugin.getConfig().getString("language", "en");
        pluginName = ChatColor.translateAlternateColorCodes('&', familyPlugin.getConfig().getString("plugin_name", "AnhyReferrals"));
        debug = familyPlugin.getConfig().getBoolean("debug", false);

        setMySQLConfig();
        
        // Не змінювати на LangMessage.getInstance(instance) бо буде циклічна залежність!!!
    	this.langManager = LangMessage.getInstance(this);

        // Ініціалізуємо конфіг
        familyConfig = FamilyConfig.getInstance(familyPlugin);
        // Перезавантажуємо конфіг
        familyConfig.reloadConfig(familyPlugin);
    }

    private void setMySQLConfig() {
    	this.mySQLConfig = new MySQLConfig(
				familyPlugin.getConfig().getString("database.mysql.host"),
				familyPlugin.getConfig().getInt("database.mysql.port"),
				familyPlugin.getConfig().getString("database.mysql.database"),
				familyPlugin.getConfig().getString("database.mysql.username"),
				familyPlugin.getConfig().getString("database.mysql.password"),
				familyPlugin.getConfig().getString("database.mysql.prefix"),
				familyPlugin.getConfig().getBoolean("database.mysql.useSSL"),
				familyPlugin.getConfig().getBoolean("database.mysql.autoReconnect"),
				"MySQL".equalsIgnoreCase(familyPlugin.getConfig().getString("database.type"))
	        );
    }

    private void saveDefaultConfig() {
        File dataFolder = familyPlugin.getDataFolder();
        if (!dataFolder.exists()) {
            boolean created = dataFolder.mkdirs();
            if (!created) {
                Logger.error(familyPlugin, "Could not create plugin directory: " + dataFolder.getPath());
                return;
            }
        }
        
    	File configFile = new File(dataFolder, "config.yml");
        if (!configFile.exists()) {
        	familyPlugin.getConfig().options().copyDefaults(true);
        	familyPlugin.saveDefaultConfig();
        }
    }

	@Override
	public DatabaseManager getDatabaseManager() {
		return dbManager;
	}
	
    private void setDatabaseManager() {
        TableRegistry registry = new TableRegistry(familyPlugin);
        if (mySQLConfig.isUseMySQL()) {
            dbManager = new MySQLDatabaseManager(this, registry);
        } else {
            dbManager = new SQLiteDatabaseManager(this, registry);
        }
    }
	
    private void initializeDatabase() {
        setDatabaseManager();
        dbManager.initialize();
        dbManager.initializeTables();
    }
}
