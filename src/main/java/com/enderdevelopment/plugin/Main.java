package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SpawnPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpawnPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location spawnLocation = getServer().getWorlds().get(0).getSpawnLocation();
                player.teleport(spawnLocation);
                player.sendMessage(Component.text("You have been teleported to spawn!").color(NamedTextColor.GREEN));
                return true;
            } else {
                sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
                return false;
            }
        }
        return false;
    }
}