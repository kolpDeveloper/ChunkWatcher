package chunkwatcher;

import chunkwatcher.command.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin  {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("TEST ");

        getCommand("chunk").setExecutor(new ChunkInfo(this));
        getLogger().warning("Chunk Watcher is enabled");

        try {

    getCommand("nearby").setExecutor(new NearbyEntities(this));
            getLogger().warning("NearbyInfo is enabled");

    getCommand("world").setExecutor(new WorldInfo(this));
            getLogger().warning("WorldInfo is enabled");

    getCommand("chunkr").setExecutor(new ChunkRelease(this));
            getLogger().warning("Chunk Release is enabled");

    getCommand("chunkl").setExecutor(new LockChunk(this));
            getLogger().warning("Chunk locker is enabled");

} catch (Exception e) {
            getLogger().warning("Chunk Watcher could not be enabled");
}
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();
    }
}
