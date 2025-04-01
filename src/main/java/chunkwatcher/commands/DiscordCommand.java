package chunkwatcher.commands;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;



import static chunkwatcher.managers.DiscordCommandManager.colorize;

public class DiscordCommand implements CommandExecutor {




    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender)
            return true;




        Player player = (Player) commandSender;
        TextComponent component =  LegacyComponentSerializer.legacySection().deserialize(colorize("\n#7289DA&lDiscord: ")).hoverEvent(HoverEvent.showText(LegacyComponentSerializer.legacySection().deserialize(colorize("&aClick here"))));
        TextComponent link = LegacyComponentSerializer.legacySection().deserialize(colorize("&ehttps://google.com")).clickEvent(ClickEvent.openUrl("https://google.com"));
        player.sendMessage(component.append(link));
        return true;
    }
}
