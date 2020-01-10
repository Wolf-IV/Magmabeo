package Wolf_IV.magmabeo.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister {

	public static void registry(){
		registerGen(new WorldGenMod(), -1);
		registerGen(new WorldGenMod(), 0);
		registerGen(new WorldGenMod(), 1);
	}
	public static void registerGen(IWorldGenerator iGen, int chance) {
		GameRegistry.registerWorldGenerator(iGen, chance);
		
		
	}



}
