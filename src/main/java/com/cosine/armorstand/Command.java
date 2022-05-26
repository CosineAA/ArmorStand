package com.cosine.armorstand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Command implements CommandExecutor {

    BukkitTask loop = new BukkitRunnable() {

        @Override
        public void run() {
            for(Player player : Bukkit.getOnlinePlayers()) {
                if (Value.ride.containsKey(player)) {
                    ArmorStand armorStand = Value.ride.get(player);
                    player.setPassenger(armorStand);
                    armorStand.teleport(player);
                }
            }
        }
    }.runTaskTimerAsynchronously(com.cosine.armorstand.ArmorStand.getPlugin(com.cosine.armorstand.ArmorStand.class), 0, 0);

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack item = new ItemStack(player.getInventory().getItemInMainHand());

        Location location = player.getLocation();

        ArmorStand armorstand;
        if (!Value.ride.isEmpty()) {
            armorstand = Value.ride.get(player);
        } else {
            armorstand = location.getWorld().spawn(location, ArmorStand.class);
        }

        armorstand.setHelmet(item);
        armorstand.setGravity(false);
        armorstand.setVisible(false);
        Value.ride.put(player, armorstand);
        return false;
    }
}
