package chunkwatcher.data;


import lombok.EqualsAndHashCode;
import org.bukkit.Chunk;

import java.util.UUID;


@EqualsAndHashCode
public class ChunkCoordinate {

    Chunk chunk;
    private final int ChunkX;
    private final int ChunkZ;
    private final UUID worldUUID;

    public ChunkCoordinate(Chunk chunk) {
        this.ChunkX = chunk.getX();
        this.ChunkZ = chunk.getZ();
        this.worldUUID = chunk.getWorld().getUID();
    }
}
