package ink.anh.referals.db;

import ink.anh.api.database.AbstractTableRegistrar;
import ink.anh.api.database.DatabaseManager;
import ink.anh.api.database.MySQLDatabaseManager;
import ink.anh.api.database.SQLiteDatabaseManager;
import ink.anh.referals.AnhyReferrals;

public class TableRegistry extends AbstractTableRegistrar {
    private AnhyReferrals familyPlugin;

	public TableRegistry(AnhyReferrals familyPlugin) {
		this.familyPlugin = familyPlugin;
	}

	@Override
    public void registerAllTables(DatabaseManager dbManager) {
        
        // Реєстрація таблиць для SQLite
        if (dbManager instanceof SQLiteDatabaseManager) {
            //dbManager.registerTable(PlayerFamily.class, new SQLiteFamilyTable(familyPlugin));
            //dbManager.registerTable(FamilyDetails.class, new SQLiteFamilyDetailsTable(familyPlugin));
        }
        
        // Реєстрація таблиць для MySQL
        if (dbManager instanceof MySQLDatabaseManager) {
            //dbManager.registerTable(PlayerFamily.class, new MySQLFamilyTable(familyPlugin));
            //dbManager.registerTable(FamilyDetails.class, new MySQLFamilyDetailsTable(familyPlugin));
        }
    }
}
