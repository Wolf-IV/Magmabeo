package Wolf_IV.magmabeo.biomes;

import java.util.Random;

import Wolf_IV.magmabeo.structures.Crafting;
import Wolf_IV.magmabeo.structures.Magmas1;
import net.minecraft.world.World;


public class StructureGenMagma {
public static final String magmas1= "magmas1";
public static final String crafting= "crafting";
	public boolean generate(String string, World world, Random rand, int x, int y, int z) {
		switch(string)
		{
		case magmas1:
			Magmas1.init(world, x, y, z);
			break;
		case crafting:
			Crafting.init(world, x, y, z);
		}
		
		return true;
	}
	
}
