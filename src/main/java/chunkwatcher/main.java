package chunkwatcher;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public final class main extends JavaPlugin {
    



    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        for (int i = 0; i < l.getLast(); i++) {

        }
    }
}
