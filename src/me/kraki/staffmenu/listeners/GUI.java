package me.kraki.staffmenu.listeners;


import me.kraki.staffmenu.Main;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class GUI implements Listener {
    final private Plugin plugin = Main.getPlugin(Main.class);


    public Inventory StaffMenuMain(String[] args) {
        Inventory i = plugin.getServer().createInventory(null, 54, "§9§lStaff Menu");

        ItemStack PaperBan = new ItemStack(Material.PAPER, 1);
        ItemMeta BanMeta = PaperBan.getItemMeta();
        BanMeta.setDisplayName("§4§lBan");
        PaperBan.setItemMeta(BanMeta);
        //
        ItemStack PaperTimeBan = new ItemStack(Material.PAPER, 1);
        ItemMeta TimeBanMeta = PaperTimeBan.getItemMeta();
        TimeBanMeta.setDisplayName("§6§lTime §4§lBan");
        PaperTimeBan.setItemMeta(TimeBanMeta);
        //
        ItemStack PaperUnBan = new ItemStack(Material.PAPER, 1);
        ItemMeta UnBanMeta = PaperUnBan.getItemMeta();
        UnBanMeta.setDisplayName("§3§lUn§4§lBan");
        PaperUnBan.setItemMeta(UnBanMeta);
        //
        ItemStack PaperKick = new ItemStack(Material.PAPER, 1);
        ItemMeta KickMeta = PaperKick.getItemMeta();
        KickMeta.setDisplayName("§c§lKick");
        PaperKick.setItemMeta(KickMeta);
        //
        ItemStack PaperWhitelistAdd = new ItemStack(Material.PAPER, 1);
        ItemMeta WhitelistAddMeta = PaperWhitelistAdd.getItemMeta();
        WhitelistAddMeta.setDisplayName("§7§lWhitelist §2§lAdd");
        PaperWhitelistAdd.setItemMeta(WhitelistAddMeta);
        //
        ItemStack PaperWhitelistRemove = new ItemStack(Material.PAPER, 1);
        ItemMeta WhitelistRemoveMeta = PaperWhitelistRemove.getItemMeta();
        WhitelistRemoveMeta.setDisplayName("§7§lWhitelist §c§lRemove");
        PaperWhitelistRemove.setItemMeta(WhitelistRemoveMeta);
        //
        ItemStack BedrockBack = new ItemStack(Material.BEDROCK, 1);
        ItemMeta BedrockMeta = BedrockBack.getItemMeta();
        BedrockMeta.setDisplayName("§8§lExit");
        BedrockBack.setItemMeta(BedrockMeta);
        //
//        ItemStack PlayerStats = new ItemStack(Material.FEATHER, 1);
//        ItemMeta PlayerMeta = PlayerStats.getItemMeta();
//        PlayerMeta.setDisplayName("§2§lStats");
//        List<String> loresList = new ArrayList<>();
//
//        loresList.add("§5§lDeaths: §f§l" + Bukkit.getOfflinePlayer(args[0]).getPlayer().getStatistic(Statistic.DEATHS));
//        loresList.add("§5§lKills: §f§l" + Bukkit.getOfflinePlayer(args[0]).getPlayer().getStatistic(Statistic.PLAYER_KILLS));
//
//        PlayerMeta.setLore(loresList);
//        PlayerStats.setItemMeta(PlayerMeta);


        //===========================================
        ItemStack BorderOrange = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 1);
        ItemMeta BorderOrangeMeta = BorderOrange.getItemMeta();
        BorderOrangeMeta.setDisplayName("§8");
        BorderOrange.setItemMeta(BorderOrangeMeta);
        //
        ItemStack BorderBlack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 15);
        ItemMeta BorderBlackMeta = BorderBlack.getItemMeta();
        BorderBlackMeta.setDisplayName("§8");
        BorderBlack.setItemMeta(BorderBlackMeta);
        //
        ItemStack skull = new ItemStack(397, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(args[0]);
        skullMeta.setDisplayName("§b§l" + args[0]);
        List<String> loresList1 = new ArrayList<>();
        loresList1.add("§a§lTeleport to");
        skullMeta.setLore(loresList1);
        skull.setItemMeta(skullMeta);


        for (byte j = 0; j <= 53; j++) {
            if (j >= 1 && j <= 7 || j >= 46 && j <= 52 || j == 9 || j == 17 || j == 18 || j == 26 || j == 27 || j == 35 || j == 36 || j == 44) {
                i.setItem(j, BorderBlack);

            } else if (j == 20) {
                i.setItem(j, PaperBan);
            } else if (j == 29) {
                i.setItem(j, PaperTimeBan);
            } else if (j == 22) {
                i.setItem(j, PaperUnBan);
            } else if (j == 31) {
                i.setItem(j, PaperKick);
            } else if (j == 24) {
                i.setItem(j, PaperWhitelistAdd);
            } else if (j == 33) {
                i.setItem(j, PaperWhitelistRemove);
            } else if (j == 45) {
                i.setItem(j, skull);
            } else if (j == 53) {
                i.setItem(j, BedrockBack);
            } else {
                i.setItem(j, BorderOrange);
            }

        }


        return i;
    }

    public Inventory ReasonGUI() {
        Inventory i = plugin.getServer().createInventory(null, 54, "§9§lReasons");

        ItemStack BorderOrange = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 1);
        ItemMeta BorderOrangeMeta = BorderOrange.getItemMeta();
        BorderOrangeMeta.setDisplayName("§8");
        BorderOrange.setItemMeta(BorderOrangeMeta);
        //
        ItemStack BorderBlack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 15);
        ItemMeta BorderBlackMeta = BorderBlack.getItemMeta();
        BorderBlackMeta.setDisplayName("§8");
        BorderBlack.setItemMeta(BorderBlackMeta);

        //
        ItemStack TagLoveYou = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta LoveYouMeta = TagLoveYou.getItemMeta();
        LoveYouMeta.setDisplayName("§d§lLove§9§lYou");
        TagLoveYou.setItemMeta(LoveYouMeta);
        //
        ItemStack TagTesting = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta TestingMEta = TagTesting.getItemMeta();
        TestingMEta.setDisplayName("§7§lTest§6§ling");
        TagTesting.setItemMeta(TestingMEta);
        //
        ItemStack TagHack = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta HackMeta = TagHack.getItemMeta();
        HackMeta.setDisplayName("§4§lHacking");
        TagHack.setItemMeta(HackMeta);
        //
        ItemStack TagSS = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta SSMeta = TagSS.getItemMeta();
        SSMeta.setDisplayName("§c§lRefuse §8§lto §3§lSS");
        TagSS.setItemMeta(SSMeta);
        //
        ItemStack TagAdv = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta AdvMeta = TagAdv.getItemMeta();
        AdvMeta.setDisplayName("§6§lAdvertising");
        TagAdv.setItemMeta(AdvMeta);
        //
        ItemStack TagVpn = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta VpnMeta = TagVpn.getItemMeta();
        VpnMeta.setDisplayName("§c§lVPN§f/§d§lAlts");
        TagVpn.setItemMeta(VpnMeta);
        //
        ItemStack TagByPass = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta BypassMeta = TagByPass.getItemMeta();
        BypassMeta.setDisplayName("§3§lBypassing §c§lBan");
        TagByPass.setItemMeta(BypassMeta);
        //
        ItemStack TagSpam = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta SpamMeta = TagSpam.getItemMeta();
        SpamMeta.setDisplayName("§5§lSpamming");
        TagSpam.setItemMeta(SpamMeta);
        //
        ItemStack TagHate = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta HateMeta = TagHate.getItemMeta();
        HateMeta.setDisplayName("§c§lHate Speech");
        TagHate.setItemMeta(HateMeta);
        //
        ItemStack TagStaff = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta StaffMeta = TagStaff.getItemMeta();
        StaffMeta.setDisplayName("§6§lStaff §c§lDisrespect");
        TagStaff.setItemMeta(StaffMeta);


        for (byte j = 0; j <= 53; j++) {

            if (j == 0 || j == 8 || j == 45 || j >= 10 && j <= 16 || j == 19 || j == 25 || j == 28 || j == 34 || j >= 37 && j <= 43 || j == 53) {
                i.setItem(j, BorderOrange);
            } else if (j == 20) {
                i.setItem(j, TagHack);
            } else if (j == 21) {
                i.setItem(j, TagSS);
            } else if (j == 22) {
                i.setItem(j, TagAdv);
            } else if (j == 23) {
                i.setItem(j, TagVpn);
            } else if (j == 24) {
                i.setItem(j, TagByPass);
            } else if (j == 29) {
                i.setItem(j, TagSpam);
            } else if (j == 30) {
                i.setItem(j, TagHate);
            } else if (j == 31) {
                i.setItem(j, TagStaff);
            } else if (j == 32) {
                i.setItem(j, TagTesting);
            } else if (j == 33) {
                i.setItem(j, TagLoveYou);
            } else {
                i.setItem(j, BorderBlack);
            }
        }

        return i;
    }

    public Inventory SetTimeGUI() {
        Inventory i = plugin.getServer().createInventory(null, 54, "§9§lSelect Time");

        ItemStack BorderOrange = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 1);
        ItemMeta BorderOrangeMeta = BorderOrange.getItemMeta();
        BorderOrangeMeta.setDisplayName("§8");
        BorderOrange.setItemMeta(BorderOrangeMeta);
        //
        ItemStack BorderBlack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0, (byte) 15);
        ItemMeta BorderBlackMeta = BorderBlack.getItemMeta();
        BorderBlackMeta.setDisplayName("§8");
        BorderBlack.setItemMeta(BorderBlackMeta);
        //
        ItemStack OKButton = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemMeta OKMeta = OKButton.getItemMeta();
        OKMeta.setDisplayName("§a§lOK");
        OKButton.setItemMeta(OKMeta);
        //
        ItemStack DayPaper = new ItemStack(Material.PAPER, 1);
        ItemMeta DayMeta = DayPaper.getItemMeta();
        DayMeta.setDisplayName("§c§l0 Days");
        DayPaper.setItemMeta(DayMeta);
        //
        ItemStack HoursPaper = new ItemStack(Material.PAPER, 1);
        ItemMeta HoursMeta = HoursPaper.getItemMeta();
        HoursMeta.setDisplayName("§6§l0 Hours");
        HoursPaper.setItemMeta(HoursMeta);
        //
        ItemStack MinutesPaper = new ItemStack(Material.PAPER, 1);
        ItemMeta MinutesMeta = MinutesPaper.getItemMeta();
        MinutesMeta.setDisplayName("§2§l0 Minutes");
        MinutesPaper.setItemMeta(MinutesMeta);
        //
        ItemStack SecondsPaper = new ItemStack(Material.PAPER, 1);
        ItemMeta SecondsMeta = SecondsPaper.getItemMeta();
        SecondsMeta.setDisplayName("§3§l0 Seconds");
        SecondsPaper.setItemMeta(SecondsMeta);
        //


        for (byte j = 0; j <= 53; j++) {

            if (j == 0 || j == 8 || j == 45 || j >= 10 && j <= 16 || j == 19 || j == 25 || j >= 28 && j <= 34 || j >= 37 && j <= 42 || j == 53 || j == 22) {
                i.setItem(j, BorderOrange);
            } else if (j == 43) {
                i.setItem(j, OKButton);
            } else if (j == 20) {
                i.setItem(j, DayPaper);
            } else if (j == 21) {
                i.setItem(j, HoursPaper);
            } else if (j == 23) {
                i.setItem(j, MinutesPaper);
            } else if (j == 24) {
                i.setItem(j, SecondsPaper);
            } else {
                i.setItem(j, BorderBlack);
            }
        }


        return i;
    }

}
