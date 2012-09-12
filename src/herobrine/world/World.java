package herobrine.world;

import java.util.ArrayList;
import java.util.List;

import herobrine.Herobrine;
import herobrine.world.entities.Entity;
import herobrine.world.entities.EntityPlayer;

public class World {

	public static List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		
		List<net.minecraft.src.Entity> mcEntities = Herobrine.mc.theWorld.getLoadedEntityList();
		for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			entities.add(Entity.getEntity(mcEntity));
		}
		
		return entities;
	}
	
	public static List<EntityPlayer> getPlayers() {
		List<EntityPlayer> players = new ArrayList<EntityPlayer>();
		
		List<net.minecraft.src.Entity> mcEntities = Herobrine.mc.theWorld.getLoadedEntityList();
		for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			if(mcEntity instanceof net.minecraft.src.EntityPlayer) {
				players.add((EntityPlayer) Entity.getEntity(mcEntity));
			}
		}
		
		return players;
	}
	
	public static Entity getEntity(int id) {
		List<net.minecraft.src.Entity> mcEntities = Herobrine.mc.theWorld.getLoadedEntityList();
		for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			if(mcEntity.entityId == id)
				return Entity.getEntity(mcEntity);
		}
		return null;
	}

	public static boolean exists() {
		return Herobrine.mc.theWorld != null;
	}
	
}
