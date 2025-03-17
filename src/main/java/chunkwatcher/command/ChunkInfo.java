package chunkwatcher.command;

import chunkwatcher.main;
import chunkwatcher.manager.ChunkManager;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChunkInfo implements CommandExecutor {

    private final main plugin;

    public ChunkInfo(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        ChunkManager chunkManager = new ChunkManager();

        if(!(commandSender instanceof Player player)) {
            commandSender.sendMessage("You must be a player to use this command.");
            return true;
        }

        Chunk chunk = player.getLocation().getChunk();

        player.sendMessage("Chunk information:");
        player.sendMessage(chunk.getX() + " " + chunk.getZ());


        int worldX = player.getLocation().getBlockX();
        int worldY = player.getLocation().getBlockY();
        int worldZ = player.getLocation().getBlockZ();

        int chunkX = worldX % 16;
        int chunkZ = worldZ % 16;


        Material material = chunk.getBlock(chunkX,worldY,chunkZ).getType();
        player.sendMessage("Block type:");
        player.sendMessage(String.valueOf(material));


        player.sendMessage("Chunk owner is: ");
        chunkManager.getChunkOwner(chunk);

        return true;
    }
}
