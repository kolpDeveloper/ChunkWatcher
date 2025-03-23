package chunkwatcher;

import chunkwatcher.command.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class main extends JavaPlugin  {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("TEST ");



        try {

            registerCommand("chunkinfo", "Выводит информацию о чанке", "/chunk", new ChunkInfo(this));
            registerCommand("nearbyspawn", "Показывает живые сущности поблизости", "/nearby", new NearbyEntities(this));
            registerCommand("worldinfo", "Выводит информацию о мирах", "/world", new WorldInfo(this));
            registerCommand("chunkrelease", "Освобождает чанки", "/chunkr", new ChunkRelease(this));
            registerCommand("lockchunk", "Блокирует чанк", "/chunkl", new LockChunk(this));


} catch (Exception e) {
            getLogger().warning("Chunk Watcher could not be enabled");
}
    }


    private void registerCommand(String name, String description, String usage, CommandExecutor executor) {
        getServer().getCommandMap().register("chunkwatcher", new org.bukkit.command.Command(name) {
            {
                this.setDescription(description);
                this.setUsage(usage);
                this.setPermission("chunkwatcher." + name);
            }

            @Override
            public boolean execute(org.bukkit.command.CommandSender sender, String commandLabel, String[] args) {
                return executor.onCommand(sender, this, commandLabel, args);
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();
    }
}
