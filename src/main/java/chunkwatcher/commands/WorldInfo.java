package chunkwatcher.commands;

import chunkwatcher.data.WorldInfoData;
import chunkwatcher.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class WorldInfo implements CommandExecutor {

    private  final main plugin;

    public WorldInfo(main plugin) {
        this.plugin = plugin;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {

         if(!(commandSender instanceof Player )) {
            commandSender.sendMessage("This command can only be executed by a player");
            return true;
        }

        Player player = (Player) commandSender;
        getFullInfo(player);

        return true;
    }


    void getFullInfo(Player player ) {

        List<WorldInfoData> worldInfoList = Bukkit.getWorlds()
                        .stream()
                .map(e ->
                     new WorldInfoData(

                            e.getPlayerCount(),
                            e.getFullTime(),
                            e.getName(),
                            e.getGameTime(),
                            e.getPVP()
                ))
                .toList();

        player.sendMessage("World Information:");
        for (Object info : worldInfoList) {
            player.sendMessage(info.toString());
        }

    }

}
