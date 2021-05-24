package me.kraki.staffmenu.listeners;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.bukkit.Bukkit.getServer;

public class ClickEve implements Listener {


    /**
     * Ban player map
     * Key: Player
     * Value: Target name
     */
    Map<Player, String> map1 = Maps.newHashMap();

    /**
     * Tempban player map
     * Key: Player
     * Value: Target name
     */
    Map<Player, String> map2 = Maps.newHashMap();
    /**
     * kick player map
     * Key: Player
     * Value: Target name
     */
    Map<Player, String> map3 = Maps.newHashMap();

    Table<Player, String, Integer> PlayerTime = HashBasedTable.create();

    Integer BanTime = null;

    String d = "Days";
    String h = "Hours";
    String m = "Minutes";
    String s = "Seconds";

    @SuppressWarnings("unused")
    @EventHandler
    public void inventClick(InventoryClickEvent e) {

        if (e.getInventory().getTitle().equals("§9§lStaff Menu")) {

            ItemStack itemStack = e.getCurrentItem();
            if (itemStack == null) {
                return;
            }
            if (!itemStack.hasItemMeta()) {
                return;
            }

            Player player = (Player) e.getWhoClicked();
            String targetName = ChatColor.stripColor(e.getInventory().getItem(45).getItemMeta().getDisplayName());


            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§lBan")) {
                if (map1.containsKey(player) || map1.containsValue(targetName)) {
                    map1.remove(player);
                    e.setCancelled(true);
                }

                map1.put(player, targetName);

                player.openInventory(new GUI().ReasonGUI());

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lTime §4§lBan")) {

                if (map2.containsKey(player) || map2.containsValue(targetName)) {
                    map2.remove(player);
                    e.setCancelled(true);
                }
                map2.put(player, targetName);

                player.openInventory(new GUI().SetTimeGUI());
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3§lUn§4§lBan")) {

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban " + targetName);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lKick")) {

                if (map3.containsKey(player) || map3.containsValue(targetName)) {
                    map3.remove(player);
                    e.setCancelled(true);
                }

                map3.put(player, targetName);

                player.openInventory(new GUI().ReasonGUI());

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWhitelist §2§lAdd")) {

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + targetName);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWhitelist §c§lRemove")) {

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist remove " + targetName);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§lExit")) {

                player.closeInventory();

            } else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals(targetName)) {

                Player p = getServer().getPlayer(targetName);

                if (p != null) {
                    player.teleport(Bukkit.getPlayer(targetName));
                } else {

                    player.sendMessage(ChatColor.RED + "Player is offline!");
                }

            }


            e.setCancelled(true);
        }
        if (e.getInventory().getTitle().equals("§9§lReasons")) {

            Player player = (Player) e.getWhoClicked();
            ItemStack itemStack = e.getCurrentItem();

            if (itemStack == null) {
                return;
            }
            if (!itemStack.hasItemMeta()) {
                return;
            }
            List<String> GetReason = new ArrayList<>();
            GetReason.add("§4§lHacking");
            GetReason.add("§c§lRefuse §8§lto §3§lSS");
            GetReason.add("§6§lAdvertising");
            GetReason.add("§c§lVPN§f/§d§lAlts");
            GetReason.add("§3§lBypassing §c§lBan");
            GetReason.add("§5§lSpamming");
            GetReason.add("§c§lHate Speech");
            GetReason.add("§6§lStaff §c§lDisrespect");
            GetReason.add("§7§lTesting");
            GetReason.add("§d§lI Love§9§lYou");

            if (GetReason.contains(e.getCurrentItem().getItemMeta().getDisplayName())) {
                if (map1.containsKey(player)) {


                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + map1.get(player) + " " + e.getCurrentItem().getItemMeta().getDisplayName());
                    map1.remove(player);
                    player.closeInventory();


                } else if (map2.containsKey(player)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + map2.get(player) + " " + BanTime + "s" + " " + e.getCurrentItem().getItemMeta().getDisplayName());
                    BanTime = null;
                    map2.remove(player);
                    player.closeInventory();
                } else if (map3.containsKey(player)) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + map3.get(player) + " " + e.getCurrentItem().getItemMeta().getDisplayName());
                    BanTime = null;
                    map3.remove(player);
                    player.closeInventory();
                }
            }
            e.setCancelled(true);
        }
        if (e.getInventory().getTitle().equals("§9§lSelect Time")) {

            Player player = (Player) e.getWhoClicked();
            ItemStack itemStack = e.getCurrentItem();

            if (itemStack == null) {
                return;
            }
            if (!itemStack.hasItemMeta()) {
                return;
            }
            ClickType cl = e.getClick();


            if (e.getSlot() == 20) {
                if (!PlayerTime.contains(player, d)) {
                    PlayerTime.put(player, d, 0);
                }
                if (cl.isLeftClick()) {
                    PlayerTime.put(player, d, PlayerTime.get(player, d) + 1);
                    ItemMeta iMeta = itemStack.getItemMeta();
                    iMeta.setDisplayName("§c§l" + PlayerTime.get(player, d) + " Days");
                    itemStack.setItemMeta(iMeta);


                    player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.D));

                    e.getInventory().setItem(20, itemStack);

                } else if (cl.isRightClick()) {
                    if (PlayerTime.get(player, d) != 0) {
                        PlayerTime.put(player, d, PlayerTime.get(player, d) - 1);
                        ItemMeta iMeta = itemStack.getItemMeta();
                        iMeta.setDisplayName("§c§l" + PlayerTime.get(player, d) + " Days");
                        itemStack.setItemMeta(iMeta);

                        e.getInventory().setItem(20, itemStack);

                    }
                    player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.B));

                }
            }
            if (e.getSlot() == 21) {
                if (!PlayerTime.contains(player, h)) {
                    PlayerTime.put(player, h, 0);
                }
                if (cl.isLeftClick()) {
                    PlayerTime.put(player, h, PlayerTime.get(player, h) + 1);
                    ItemMeta iMeta = itemStack.getItemMeta();
                    iMeta.setDisplayName("§6§l" + PlayerTime.get(player, h) + " Hours");
                    itemStack.setItemMeta(iMeta);
                    player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.D));
                    e.getInventory().setItem(21, itemStack);

                } else if (cl.isRightClick()) {
                    if (PlayerTime.get(player, h) != 0) {
                        PlayerTime.put(player, h, PlayerTime.get(player, h) - 1);
                        ItemMeta iMeta = itemStack.getItemMeta();
                        iMeta.setDisplayName("§6§l" + PlayerTime.get(player, h) + " Hours");
                        itemStack.setItemMeta(iMeta);
                        player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.B));
                        e.getInventory().setItem(21, itemStack);
                    }
                }
            }
            if (e.getSlot() == 23) {
                if (!PlayerTime.contains(player, m)) {
                    PlayerTime.put(player, m, 0);
                }
                if (cl.isLeftClick()) {
                    PlayerTime.put(player, m, PlayerTime.get(player, m) + 1);
                    ItemMeta iMeta = itemStack.getItemMeta();
                    iMeta.setDisplayName("§2§l" + PlayerTime.get(player, m) + " Minutes");
                    itemStack.setItemMeta(iMeta);
                    player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.D));
                    e.getInventory().setItem(23, itemStack);

                } else if (cl.isRightClick()) {
                    if (PlayerTime.get(player, m) != 0) {
                        PlayerTime.put(player, m, PlayerTime.get(player, m) - 1);
                        ItemMeta iMeta = itemStack.getItemMeta();
                        iMeta.setDisplayName("§2§l" + PlayerTime.get(player, m) + " Minutes");
                        itemStack.setItemMeta(iMeta);
                        player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.B));
                        e.getInventory().setItem(23, itemStack);
                    }
                }
            }
            if (e.getSlot() == 24) {
                if (!PlayerTime.contains(player, s)) {
                    PlayerTime.put(player, s, 0);
                }
                if (cl.isLeftClick()) {
                    PlayerTime.put(player, s, PlayerTime.get(player, s) + 1);
                    ItemMeta iMeta = itemStack.getItemMeta();
                    iMeta.setDisplayName("§3§l" + PlayerTime.get(player, s) + " Seconds");
                    itemStack.setItemMeta(iMeta);
                    player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.D));
                    e.getInventory().setItem(24, itemStack);

                } else if (cl.isRightClick()) {
                    if (PlayerTime.get(player, s) != 0) {
                        PlayerTime.put(player, s, PlayerTime.get(player, s) - 1);
                        ItemMeta iMeta = itemStack.getItemMeta();
                        iMeta.setDisplayName("§3§l" + PlayerTime.get(player, s) + " Seconds");
                        itemStack.setItemMeta(iMeta);
                        player.playNote(player.getLocation(), Instrument.STICKS, Note.sharp(1, Note.Tone.B));
                        e.getInventory().setItem(24, itemStack);
                    }
                }
            }

            if (e.getSlot() == 43) {
                if (!PlayerTime.contains(player, d)) {
                    PlayerTime.put(player, d, 0);
                }
                if (!PlayerTime.contains(player, h)) {
                    PlayerTime.put(player, h, 0);
                }
                if (!PlayerTime.contains(player, m)) {
                    PlayerTime.put(player, m, 0);
                }
                if (!PlayerTime.contains(player, s)) {
                    PlayerTime.put(player, s, 0);
                }
                BanTime = (PlayerTime.get(player, d) * 86400) + (PlayerTime.get(player, h) * 3600) + (PlayerTime.get(player, m) * 60) + PlayerTime.get(player, s);

                player.openInventory(new GUI().ReasonGUI());

            }
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {


        if (e.getInventory().getTitle().equals("§9§lSelect Time")) {
            Player player = (Player) e.getPlayer();
            if (PlayerTime.contains(player, d)) {
                PlayerTime.remove(player, d);
            }
            if (PlayerTime.contains(player, h)) {
                PlayerTime.remove(player, h);
            }
            if (PlayerTime.contains(player, m)) {
                PlayerTime.remove(player, m);
            }
            if (PlayerTime.contains(player, s)) {
                PlayerTime.remove(player, s);
            }

        }
    }
}

