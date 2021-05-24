package me.kraki.staffmenu.commands;

import me.kraki.staffmenu.listeners.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SM implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("martex.admin.menu")) {
                if (args.length == 0) {
                    sender.sendMessage("Player arg missing");
                } else if (args.length == 1) {

                    ((Player) sender).openInventory(new GUI().StaffMenuMain(args));
                } else {
                    sender.sendMessage("Den kserw ti na grapsw");
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
