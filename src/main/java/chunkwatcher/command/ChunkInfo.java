package chunkwatcher.command;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChunkInfo implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(!(commandSender instanceof Player player)) {
            commandSender.sendMessage("You must be a player to use this command.");
            return true;
        }

        Chunk chunk = player.getLocation().getChunk();

        player.sendMessage(ChatColor.RED + "Chunk information:");
        player.sendMessage(chunk.getX() + " " + chunk.getZ());


        int worldX = player.getLocation().getBlockX();
        int worldY = player.getLocation().getBlockY();
        int worldZ = player.getLocation().getBlockZ();

        int chunkX = worldX % 16;
        int chunkZ = worldZ % 16;


        Material material = chunk.getBlock(chunkX,worldY,chunkZ).getType();
        player.sendMessage(ChatColor.RED + "Block type:");
        player.sendMessage(String.valueOf(material));




        return true;
    }
}
