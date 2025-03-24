package chunkwatcher.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChunkWatch implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {


        return false;
    }
}
