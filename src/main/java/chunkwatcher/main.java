package chunkwatcher;

import chunkwatcher.commands.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.ParametersAreNonnullByDefault;

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
        org.bukkit.command.Command command = new org.bukkit.command.Command(name) {
            @Override
            @ParametersAreNonnullByDefault
            public boolean execute(org.bukkit.command.CommandSender sender, String commandLabel, String[] args) {
                return executor.onCommand(sender, this, commandLabel, args);
            }
        };

        command.setDescription(description);
        command.setUsage(usage);
        command.setPermission("chunkwatcher." + name);

        try {
            getServer().getCommandMap().register("chunkwatcher", command);
            getLogger().info("Registered command: " + name);
        } catch (Exception e) {
            getLogger().warning("Could not register command " + name + ": " + e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveConfig();
        getLogger().info("Turned off command");
    }
}
