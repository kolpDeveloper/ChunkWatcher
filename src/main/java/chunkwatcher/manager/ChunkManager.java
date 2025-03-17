package chunkwatcher.manager;

import chunkwatcher.data.ChunkCoordinate;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChunkManager {

    private final Map<ChunkCoordinate, UUID> lockedChunks = new HashMap<>();

    public boolean lockChunk(Chunk chunk, Player player) {
        ChunkCoordinate coordinate = new ChunkCoordinate(chunk);


        if(lockedChunks.containsKey(coordinate)) {
            return false;
        }


        lockedChunks.put(coordinate, player.getUniqueId());
        return true;
    }


    public boolean releaseChunk(Chunk chunk, Player player) {
        ChunkCoordinate coordinate = new ChunkCoordinate(chunk);

        if(lockedChunks.containsKey(coordinate)) {
            lockedChunks.remove(coordinate);
        }
        return true;
    }

    public UUID getChunkOwner(Chunk chunk) {
        return lockedChunks.get(new ChunkCoordinate(chunk));
    }




}
