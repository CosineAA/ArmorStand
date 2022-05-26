package com.cosine.armorstand;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command3 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        ItemStack item = new ItemStack(player.getInventory().getItemInMainHand());

        Location location = player.getLocation();

        ArmorStand armorstand;
        if (!Value.ride.isEmpty()) {
            armorstand = Value.ride.get(player);
        } else {
            armorstand = location.getWorld().spawn(location, ArmorStand.class);
        }

        armorstand.getEquipment().setItemInOffHand(item);
        armorstand.setGravity(false);
        armorstand.setVisible(false);
        Value.ride.put(player, armorstand);
        return false;
    }
}
