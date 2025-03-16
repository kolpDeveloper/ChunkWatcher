# Plugin for chunck managment (Chunk Watcher)

### Idea: "Chunks Keeper" 
### Description: The plugin helps players and server administrators manage chunks — track activity, protect territories and receive notifications about actions in certain areas. This is useful for survival, building, or preventing griefing.


## Key features & Tracking activity in a chunk:
### Players can "tag" a chunk with the /chunkwatch command to receive notifications about actions in it (breaking blocks, placing, entering of other players).

## Notifications come in the chat: "Player Steve broke a stone in your chunk (x:16, z:16)".

## Chunk protection:
### The option to "lock" a chunk so that only the owner can break or place blocks (similar to a light protection without plugins like WorldGuard).

### Configurable chunk limit per player (e.g. 5).
## Chunk info:
### The /chunkinfo command shows:
### Chunk coordinates.
### Owner (if any).
### The number of blocks broken/placed in the last 24 hours.

## Commands:
### /chunkwatch — marks the current chunk for tracking.
### /chunklock — locks the chunk from being changed by other players.
### /chunkinfo — shows information about the current chunk.
### /chunkrelease — removes tracking or locking. I am writing on the paper core, help to configure the file to work with it
### /nearby — shows what kind of living entities are nearby
### /world — displays information about the worlds
