package Wolf_IV.magmabeo.structures;

import java.util.Random;

import Wolf_IV.magmabeo.magmabeo;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Crafting {
	public static void init(World world, int x, int y, int z) {
		Random rand = new Random();
		if (world.getBlock(x, y, z)== Blocks.nether_brick && world.getBlock(x, y+1 ,z)== Blocks.air) {
			for(int ii=0;ii<3;ii++) {
			for(int i=0;i<3;i++) {
				
			world.setBlock(x+i, y-1, z+ii, Blocks.clay);
			world.setBlock(x+i, y, z+ii, Blocks.glass);
		}
		}
		
	
	
	}
}
}