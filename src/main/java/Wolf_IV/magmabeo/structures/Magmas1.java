package Wolf_IV.magmabeo.structures;

import java.util.Random;

import Wolf_IV.magmabeo.magmabeo;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Magmas1 {
	
	public static void init(World world, int x, int y, int z) {
		Random rand = new Random();
		if (world.getBlock(x, y-1, z)== Blocks.nether_brick && world.getBlock(x, y+2 ,z)== Blocks.air) {
		boolean r = rand.nextBoolean();
		if (r==true) {world.setBlock(x, y+1, z, magmabeo.MagmaFluid);}else{world.setBlock(x, y+1, z, Blocks.water);}
		}
	}
	
	
}
