package chunkwatcher.command;

import chunkwatcher.data.WorldInfoData;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class WorldInfo implements CommandExecutor {



    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

         if(!(commandSender instanceof Player )) {
            commandSender.sendMessage("This command can only be executed by a player");
            return true;
        }

        Player player = (Player) commandSender;
         World world = player.getWorld();
         Block block = world.getBlockAt(player.getLocation());
        getFullInfo(world,player,block);

        return true;
    }


    void getFullInfo(World world, Player player, Block block) {

        List<WorldInfoData> worldInfoList = Bukkit.getWorlds()
                        .stream()
                .map(e ->
                     new WorldInfoData(

                            e.getPlayerCount(),
                            e.getFullTime(),
                            e.getName(),
                            e.getGameTime(),
                            e.getPVP(),
                            e.getGameTime()
                ))
                .collect(Collectors.toList());

        player.sendMessage("World Information:");
        for (WorldInfoData info : worldInfoList) {
            player.sendMessage(info.toString());
        }

    }
}
