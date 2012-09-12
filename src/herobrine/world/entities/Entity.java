package herobrine.world.entities;

import herobrine.data.Position;
import herobrine.data.Rotation;

public abstract class Entity {

	private net.minecraft.src.Entity entity;

	public Entity(net.minecraft.src.Entity entity) {
		this.entity = entity;
	}

	public static Entity getEntity(net.minecraft.src.Entity entity) {
		if (entity instanceof net.minecraft.src.EntityLiving) {
			// Player
			if (entity instanceof net.minecraft.src.EntityPlayer) {
				return new EntityPlayer((net.minecraft.src.EntityPlayer) entity);
			}
			
			// Slimes
			else if (entity instanceof net.minecraft.src.EntitySlime) {
				// Magma Cube
				if (entity instanceof net.minecraft.src.EntityMagmaCube) {
					return new EntityMagmaCube((net.minecraft.src.EntityMagmaCube) entity);
				}
				
				// Slime
				return new EntitySlime((net.minecraft.src.EntitySlime) entity);
			}
			
			// Flying
			else if (entity instanceof net.minecraft.src.EntityFlying) {
				// Ghast
				if (entity instanceof net.minecraft.src.EntityGhast) {
					return new EntityGhast((net.minecraft.src.EntityGhast) entity);
				}
			}
			
			// Dragon Base
			else if (entity instanceof net.minecraft.src.EntityDragonBase) {
				// Dragon
				if(entity instanceof net.minecraft.src.EntityDragon) {
					return new EntityDragon((net.minecraft.src.EntityDragon) entity);
				}
			}

			// Creatures
			else if (entity instanceof net.minecraft.src.EntityCreature) {
				// Villager
				if (entity instanceof net.minecraft.src.EntityVillager) {
					return new EntityVillager((net.minecraft.src.EntityVillager) entity);
				}
				
				// Animals
				else if (entity instanceof net.minecraft.src.EntityAnimal) {
					// Chicken
					if (entity instanceof net.minecraft.src.EntityChicken) {
						return new EntityChicken((net.minecraft.src.EntityChicken) entity);
					}

					// Pig
					else if (entity instanceof net.minecraft.src.EntityPig) {
						return new EntityPig((net.minecraft.src.EntityPig) entity);
					}
					
					// Sheep
					else if (entity instanceof net.minecraft.src.EntitySheep) {
						return new EntitySheep((net.minecraft.src.EntitySheep) entity);
					}

					// Cows
					else if (entity instanceof net.minecraft.src.EntityCow) {
						// Mushroom Cow
						if (entity instanceof net.minecraft.src.EntityMooshroom) {
							return new EntityMushroomCow((net.minecraft.src.EntityMooshroom) entity);
						}

						// Cow
						return new EntityCow((net.minecraft.src.EntityCow) entity);
					}

					// Tameables
					else if (entity instanceof net.minecraft.src.EntityTameable) {
						// Wolf
						if (entity instanceof net.minecraft.src.EntityWolf) {
							return new EntityWolf((net.minecraft.src.EntityWolf) entity);
						}
						
						// Ocelot
						else if (entity instanceof net.minecraft.src.EntityOcelot) {
							return new EntityOcelot((net.minecraft.src.EntityOcelot) entity);
						}
					}
				}
				
				// Monsters
				else if (entity instanceof net.minecraft.src.EntityMob) {
					// Creeper
					if(entity instanceof net.minecraft.src.EntityCreeper) {
						return new EntityCreeper((net.minecraft.src.EntityCreeper) entity);
					}
					
					// Enderman
					else if(entity instanceof net.minecraft.src.EntityEnderman) {
						return new EntityEnderman((net.minecraft.src.EntityEnderman) entity);
					}
					
					// Silverfish
					else if(entity instanceof net.minecraft.src.EntitySilverfish) {
						return new EntitySilverfish((net.minecraft.src.EntitySilverfish) entity);
					}
					
					// Giant Zombie
					else if(entity instanceof net.minecraft.src.EntityGiantZombie) {
						return new EntityGiantZombie((net.minecraft.src.EntityGiantZombie) entity);
					}
					
					// Skeleton
					else if(entity instanceof net.minecraft.src.EntitySkeleton) {
						return new EntitySkeleton((net.minecraft.src.EntitySkeleton) entity);
					}
					
					// Blaze
					else if(entity instanceof net.minecraft.src.EntitySilverfish) {
						return new EntityBlaze((net.minecraft.src.EntityBlaze) entity);
					}
					
					// Spiders
					else if(entity instanceof net.minecraft.src.EntitySpider) {
						if(entity instanceof net.minecraft.src.EntityCaveSpider) {
							return new EntityCaveSpider((net.minecraft.src.EntityCaveSpider) entity);
						}
						
						return new EntitySpider((net.minecraft.src.EntitySpider) entity);
					}
					
					// Zombies
					else if(entity instanceof net.minecraft.src.EntityZombie) {
						if(entity instanceof net.minecraft.src.EntityPigZombie) {
							return new EntityPigZombie((net.minecraft.src.EntityPigZombie) entity);
						}
						
						return new EntityZombie((net.minecraft.src.EntityZombie) entity);
					}
				}
				
				// Water Animals
				else if (entity instanceof net.minecraft.src.EntityWaterMob) {
					// Squid
					if (entity instanceof net.minecraft.src.EntitySquid) {
						return new EntitySquid((net.minecraft.src.EntitySquid) entity);
					}
				}
				
				// Golems
				else if (entity instanceof net.minecraft.src.EntityGolem) {
					// Snowman
					if (entity instanceof net.minecraft.src.EntitySnowman) {
						return new EntitySnowman((net.minecraft.src.EntitySnowman) entity);
					} 
					
					// Iron Golem
					else if (entity instanceof net.minecraft.src.EntityIronGolem) {
						return new EntityIronGolem((net.minecraft.src.EntityIronGolem) entity);
					}
				}
			}
		} 
		
		// Dragon Part
		else if (entity instanceof net.minecraft.src.EntityDragonPart) {
			return new EntityDragonPart((net.minecraft.src.EntityDragonPart) entity);
		}
		
		// Experience Orb
		else if (entity instanceof net.minecraft.src.EntityXPOrb) {
			return new EntityExperienceOrb((net.minecraft.src.EntityXPOrb) entity);
		}
		
		// Arrow
		else if (entity instanceof net.minecraft.src.EntityArrow) {
			return new EntityArrow((net.minecraft.src.EntityArrow) entity);
		}
		
		// Boat
		else if (entity instanceof net.minecraft.src.EntityBoat) {
			return new EntityBoat((net.minecraft.src.EntityBoat) entity);
		}
		
		// Falling Block
		else if (entity instanceof net.minecraft.src.EntityFallingSand) {
			return new EntityFallingBlock((net.minecraft.src.EntityFallingSand) entity);
		}
		
		// Ender Eye
		else if (entity instanceof net.minecraft.src.EntityEnderEye) {
			return new EntityEnderEye((net.minecraft.src.EntityEnderEye) entity);
		}
		
		// Ender Crystal
		else if (entity instanceof net.minecraft.src.EntityEnderCrystal) {
			return new EntityEnderCrystal((net.minecraft.src.EntityEnderCrystal) entity);
		}
		
		// Fishing Hook
		else if (entity instanceof net.minecraft.src.EntityFishHook) {
			return new EntityFishingHook((net.minecraft.src.EntityFishHook) entity);
		}
		
		// Item
		else if (entity instanceof net.minecraft.src.EntityItem) {
			return new EntityItem((net.minecraft.src.EntityItem) entity);
		}
		
		// Fire Balls
		else if (entity instanceof net.minecraft.src.EntityFireball) {
			// Small Fire Ball
			if (entity instanceof net.minecraft.src.EntitySmallFireball) {
				return new EntitySmallFireball((net.minecraft.src.EntitySmallFireball) entity);
			} 
			
			// Fire Ball
			return new EntityFireball((net.minecraft.src.EntityFireball) entity);
		}
		
		// Minecarts
		else if (entity instanceof net.minecraft.src.EntityMinecart) {
			net.minecraft.src.EntityMinecart entityMinecart = (net.minecraft.src.EntityMinecart) entity;

			// Storage Minecart
			if (entityMinecart.minecartType == EntityMinecart.Type.StorageMinecart.getId()) {
				return new EntityStorageMinecart((net.minecraft.src.EntityMinecart) entity);
			} 
			
			// Powered Minecart
			else if (entityMinecart.minecartType == EntityMinecart.Type.PoweredMinecart.getId()) {
				return new EntityPoweredMinecart((net.minecraft.src.EntityMinecart) entity);
			} 
			
			// Minecart
			return new EntityMinecart((net.minecraft.src.EntityMinecart) entity);
		}
		
		// Throwables
		else if (entity instanceof net.minecraft.src.EntityThrowable) {
			// Snowball
			if (entity instanceof net.minecraft.src.EntitySnowball) {
				return new EntitySnowball((net.minecraft.src.EntitySnowball) entity);
			} 
			
			// Potion
			else if (entity instanceof net.minecraft.src.EntityPotion) {
				return new EntityPotion((net.minecraft.src.EntityPotion) entity);
			} 
			
			// Ender Pearl
			else if (entity instanceof net.minecraft.src.EntityEnderPearl) {
				return new EntityEnderPearl((net.minecraft.src.EntityEnderPearl) entity);
			} 
			
			// Experience Bottle
			else if (entity instanceof net.minecraft.src.EntityExpBottle) {
				return new EntityExperienceBottle((net.minecraft.src.EntityExpBottle) entity);
			} 
		}
		
		// Weather
		else if (entity instanceof net.minecraft.src.EntityWeatherEffect) {
			// Lightning
			if(entity instanceof net.minecraft.src.EntityLightningBolt) {
				return new EntityLightning((net.minecraft.src.EntityLightningBolt) entity);
			}
		}
		
		// Painting
		else if (entity instanceof net.minecraft.src.EntityPainting) {
			return new EntityPainting((net.minecraft.src.EntityPainting) entity);
		}
		
		// TNTPrimed
		else if (entity instanceof net.minecraft.src.EntityPainting) {
			return new EntityPainting((net.minecraft.src.EntityPainting) entity);
		}
		
		return null;
	}

	public Position getPosition() {
		return new Position(entity.posX, entity.posY, entity.posZ);
	}

	public void getPosition(Position position) {
		position.x = entity.posX;
		position.y = entity.posY;
		position.z = entity.posZ;
	}

	public Rotation getRotation() {
		return new Rotation(entity.rotationPitch, entity.rotationYaw, 0);
	}

	public void getRotation(Rotation rotation) {
		rotation.pitch = entity.rotationPitch;
		rotation.yaw = entity.rotationYaw;
		rotation.roll = 0;
	}

	public float getPitch() {
		return entity.rotationPitch;
	}

	public float getYaw() {
		return entity.rotationYaw;
	}

	public int getID() {
		return entity.entityId;
	}
	
	public Entity[] getParts() {
		net.minecraft.src.Entity[] parts = entity.getParts();
		Entity[] ret = new Entity[parts.length];
		for(int i = 0; i < parts.length; i++) {
			ret[i] = Entity.getEntity(parts[i]);
		}
		return ret;
	}

}
