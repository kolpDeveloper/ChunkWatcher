package chunkwatcher.data;

import lombok.Data;


public class WorldInfoData {
    private int playerCount;
    private long fullTime;
    private String name;
    private long gameTime;
    private boolean pvpEnabled;

    public WorldInfoData(int playerCount, long fullTime, String name, long gameTime, boolean pvp) {
        this.playerCount = playerCount;
        this.fullTime = fullTime;
        this.name = name;
        this.gameTime = gameTime;
        this.pvpEnabled = pvpEnabled;
    }

    @Override
    public String toString() {
        return String.format("World: %s, Players: %d, FullTime: %d, GameTime: %d, PVP: %b",
                name, playerCount, fullTime, gameTime, pvpEnabled);
    }
}
