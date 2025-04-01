package chunkwatcher.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import javax.annotation.ParametersAreNonnullByDefault;

public class ChunkWatch implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand( CommandSender commandSender, Command command,String s, String[] strings) {


        commandSender.sendMessage(Component.text("ChunkWatch")
                .color(TextColor.color(255, 10, 16))
                .decorate(TextDecoration.ITALIC, TextDecoration.UNDERLINED)
        );
        return true;
    }
}
