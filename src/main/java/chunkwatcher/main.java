package chunkwatcher;

import chunkwatcher.command.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    



    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("chunk").setExecutor(new ChunkInfo());
        getCommand("nearby").setExecutor(new NearbyEntities());
        getCommand("world").setExecutor(new WorldInfo());
        getCommand("chunkr").setExecutor(new ChunkRealese());
        getCommand("chunkl").setExecutor(new LockChunk());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();
    }
}
