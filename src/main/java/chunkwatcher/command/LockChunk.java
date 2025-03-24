package chunkwatcher.command;

import chunkwatcher.main;
import chunkwatcher.manager.ChunkManager;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class LockChunk implements CommandExecutor {
    private final main plugin;

    public LockChunk(main plugin) {
        this.plugin = plugin;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {

        if(!(commandSender instanceof Player player)){
            return true;
        }


        Chunk chunk = player.getLocation().getChunk();
        ChunkManager chunkManager = new ChunkManager();


        player.sendMessage("Start processing.");
        if(!chunkManager.lockChunk(chunk,player)){
            player.sendMessage("Lock stopped.");
            return false;
        }
        return true;
    }
}
