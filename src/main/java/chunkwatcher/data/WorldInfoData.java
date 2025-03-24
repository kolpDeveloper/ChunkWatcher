package chunkwatcher.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WorldInfoData {
    private int playerCount;
    private long fullTime;
    private String name;
    private long gameTime;
    private boolean pvpEnabled;

    @Override
    public String toString() {
        return String.format("World: %s, Players: %d, FullTime: %d, GameTime: %d, PVP: %b",
                name, playerCount, fullTime, gameTime, pvpEnabled);
    }
}
