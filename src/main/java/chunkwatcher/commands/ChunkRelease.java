package chunkwatcher.commands;

import chunkwatcher.main;
import chunkwatcher.managers.ChunkManager;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChunkRelease implements CommandExecutor {
private main plugin;

    public ChunkRelease(main plugin) {
        this.plugin = plugin;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {

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
