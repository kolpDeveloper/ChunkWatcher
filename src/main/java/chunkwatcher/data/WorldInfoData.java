package chunkwatcher.data;

import lombok.Data;

@Data
public class WorldInfoData {
    private final int playerCount;
    private final long fullTime;
    private final String name;
    private final long gameTime;
    private final boolean pvpEnabled;


    @Override
    public String toString() {
        return String.format("World: %s, Players: %d, FullTime: %d, GameTime: %d, PVP: %b",
                name, playerCount, fullTime, gameTime, pvpEnabled);
    }
}
