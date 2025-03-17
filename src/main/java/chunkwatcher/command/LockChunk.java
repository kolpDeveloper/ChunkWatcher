package chunkwatcher.command;

import chunkwatcher.manager.ChunkManager;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LockChunk implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player player)){
            return true;
        }


        Chunk chunk = player.getLocation().getChunk();
        ChunkManager chunkManager = new ChunkManager();


        player.sendMessage("Start processing.");
        if(chunkManager.lockChunk(chunk,player) == false){
            player.sendMessage("Lock stopped.");
            return false;
        }
        return true;
    }
}
