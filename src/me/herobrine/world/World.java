package me.herobrine.world;

import java.util.ArrayList;
import java.util.List;

import me.herobrine.Herobrine;
import me.herobrine.data.EntityType;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;
import me.herobrine.world.entities.Entity;
import net.minecraft.src.EntityList;


public class World {

	public static List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		
		List<net.minecraft.src.Entity> mcEntities = Herobrine.mc.theWorld.getLoadedEntityList();
		for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			entities.add(Entity.getEntity(mcEntity));
		}
		
		return entities;
	}
	
	public static <T extends Entity> List<T> getEntities(Class<T> entityType) {
		List<T> entities = new ArrayList<T>();
		
		for(Entity entity : World.getEntities()) {
			if(entityType.isInstance(entity)) {
				entities.add((T) entity);
			}
		}
		
		
		/*for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			if(entityType.isAssignableFrom(EntityType.fromId(EntityList.getEntityID(mcEntity)).getEntityClass())) {
				Entity entity = Entity.getEntity(mcEntity);
				
				if(entityType.isInstance(entity)) {
					entities.add((T) entity);
				}
			}
		}*/
		
		return entities;
	}
	
	public static Entity getEntity(int id) {
		List<net.minecraft.src.Entity> mcEntities = Herobrine.mc.theWorld.getLoadedEntityList();
		for(net.minecraft.src.Entity mcEntity : mcEntities.toArray(new net.minecraft.src.Entity[0])) {
			if(mcEntity.entityId == id)
				return Entity.getEntity(mcEntity);
		}
		return null;
	}
	
	public static int getBlockType(int x, int y, int z) {
		return Herobrine.mc.theWorld.getBlockId(x, y, z);
	}
	
	public static int getBlockData(int x, int y, int z) {
		return Herobrine.mc.theWorld.getBlockMetadata(x, y, z);
	}

	public static MaterialData getBlockMaterialData(int x, int y, int z) {
		return Material.getMaterial(Herobrine.mc.theWorld.getBlockId(x, y, z)).getNewData((byte) Herobrine.mc.theWorld.getBlockMetadata(x, y, z));
	}
	
	public static boolean exists() {
		return Herobrine.mc.theWorld != null;
	}
	
}
