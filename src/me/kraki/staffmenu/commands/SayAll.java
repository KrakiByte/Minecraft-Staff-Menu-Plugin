package me.kraki.staffmenu.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SayAll implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("kraki.sayall")) {
                for(byte i = 1;i<=50;i++) {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {

                        player.sendMessage(ChatColor.AQUA + String.valueOf(i));
                    }
                }
            } else {
                sender.sendMessage("§4Permission Denied");
            }
        } else {
            sender.sendMessage("Player only command!");
        }
        return true;
    }
}
