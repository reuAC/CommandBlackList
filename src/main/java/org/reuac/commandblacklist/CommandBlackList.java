package org.reuac.commandblacklist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.stream.Collectors;

public final class CommandBlackList extends JavaPlugin {

    static CommandBlackList main;

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("commandblacklist").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new MainListener(),this);

        saveDefaultConfig();
        loadConfig();

        main = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadWorldCommandSettings() {
        FileConfiguration config = getConfig();

        // 遍历配置文件中的所有世界并缓存指令设置
        for (String worldName : config.getConfigurationSection("Worlds").getKeys(false)) {
            List<String> whitelist = config.getStringList("Worlds." + worldName + ".Command_BlackList");
            boolean enabledMessage = config.getBoolean("Worlds." + worldName + ".enabledMessage");
            List<String> notAllowTip = config.getStringList("Worlds." + worldName + ".CommandNotAllow_Tip").stream()
                    .map(message -> ChatColor.translateAlternateColorCodes('&', message))
                    .collect(Collectors.toList());

            // 将世界的指令白名单和提示信息缓存
            MainListener.worldCommandSettingsMap.put(worldName, new WorldCommandSettings(whitelist, enabledMessage, notAllowTip));
        }
    }

    public void loadConfig() {
        MainListener.DefaultConfig = getConfig().getString("Default.name");
        MainListener.DefaultEnable = getConfig().getBoolean("Default.enable");
        loadWorldCommandSettings();
    }
}
