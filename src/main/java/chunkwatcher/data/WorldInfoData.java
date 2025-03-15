package chunkwatcher.data;

public class WorldInfoData {
    private final int playerCount;
    private final long fullTime;
    private final String name;
    private final long gameTime;
    private final boolean pvpEnabled;

    public WorldInfoData(int playerCount, long fullTime, String name, long gameTime, boolean pvpEnabled, long time) {
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
