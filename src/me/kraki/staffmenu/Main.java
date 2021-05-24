package me.kraki.staffmenu;

import me.kraki.staffmenu.commands.PlayerCrash;
import me.kraki.staffmenu.commands.SM;
import me.kraki.staffmenu.commands.SayAll;
import me.kraki.staffmenu.listeners.ClickEve;
import me.kraki.staffmenu.listeners.GUI;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "StaffMenu Enabled!");

        //Events
        getServer().getPluginManager().registerEvents(new GUI(), this);
        getServer().getPluginManager().registerEvents(new ClickEve(), this);

        //Commands
        getCommand("crash").setExecutor(new PlayerCrash());
        getCommand("sm").setExecutor(new SM());
        getCommand("spamall").setExecutor(new SayAll());
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "StaffMenu Disabled!");
    }


}
