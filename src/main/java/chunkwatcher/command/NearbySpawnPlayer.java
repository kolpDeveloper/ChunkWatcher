package chunkwatcher.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NearbySpawnPlayer implements CommandExecutor {

    public static final double RADIUS = 100.0;


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] strings) {
        if(!(commandSender instanceof Player player)) {
            commandSender.sendMessage("This command can only be executed by a player");
            return true;
        }

        Location playerLocation = player.getLocation();
        player.sendMessage("Finding players within " + RADIUS + " blocks");

        boolean found = false;
        for(Player nbyPlayer : player.getWorld().getPlayers() ) {
            if(nbyPlayer.equals(playerLocation)) {
                player.sendMessage("Someone nearby: " + nbyPlayer.getName());
                Location pLocation = nbyPlayer.getLocation();
                player.sendMessage("Player location is: " + "X" + (int)pLocation.x() + "\nY" + (int)pLocation.y() + "\nZ" + (int)pLocation.z() );
                found = true;
            }
        }
        return found;
    }





    public void nearbySpawnPlayer() {}
}
