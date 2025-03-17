package chunkwatcher;

import chunkwatcher.command.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin  {

    @Override
    public void onEnable() {
        // Plugin startup logic


try {
    getCommand("chunk").setExecutor(new ChunkInfo(this));
    getLogger().info("Chunk Watcher is enabled");

    getCommand("nearby").setExecutor(new NearbyEntities(this));
    getLogger().info("NearbyInfo is enabled");

    getCommand("world").setExecutor(new WorldInfo(this));
    getLogger().info("WorldInfo is enabled");

    getCommand("chunkr").setExecutor(new ChunkRelease(this));
    getLogger().info("Chunk Release is enabled");

    getCommand("chunkl").setExecutor(new LockChunk(this));
    getLogger().info("Chunk locker is enabled");

} catch (Exception e) {
    getLogger().severe("Chunk Watcher could not be enabled");
}
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();
    }
}
