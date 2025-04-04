package chunkwatcher.commands;

import chunkwatcher.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;

public class NearbyEntities implements CommandExecutor {

    private final main plugin;

    public static final double RADIUS = 20.0;


    public NearbyEntities(main plugin) {
        this.plugin = plugin;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {

        if(!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be executed by a player");
            return true;
        }

        boolean found = false;

        ArrayList<Entity> entities = (ArrayList<Entity>)player.getNearbyEntities(RADIUS, RADIUS, RADIUS);
            if(entities.isEmpty()) {
                commandSender.sendMessage("No entities found");
            }
            else {
                player.sendMessage("Found " + entities.size() + " entities");
                for(Entity entity : entities)
                {
                    player.sendMessage(entity.getType().toString());
                    found = true;
                }
            }

        return found;
    }
}
