package chunkwatcher.command;

import chunkwatcher.manager.ChunkManager;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChunkRealese implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        ChunkManager chunkManager = new ChunkManager();

        if (!(commandSender instanceof Player player)) {
            return true;
        }

        Chunk chunk = player.getLocation().getChunk();

        player.sendMessage("Release chunk: ");
        chunkManager.releaseChunk(chunk,player);


        return true;
    }
}
