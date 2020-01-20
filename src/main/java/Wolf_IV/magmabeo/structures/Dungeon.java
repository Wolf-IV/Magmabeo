package Wolf_IV.magmabeo.structures;

import java.util.Random;

import Wolf_IV.magmabeo.magmabeo;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Dungeon {

	public static void init(World world, int x, int y, int z) {
int i;
		Random rand = new Random();
		if (world.getBlock(x, y, z)== Blocks.nether_brick && world.getBlock(x, y+1 ,z)== Blocks.air && Math.random()<0.25) {
			for(i=0;i<5;i++) {
			world.setBlock(x+2, y+i, z, Blocks.cobblestone_wall);
			world.setBlock(x-2, y+i, z, Blocks.cobblestone_wall);
			world.setBlock(x+i-2, y+5, z, Blocks.glowstone);
			world.setBlock(x+i-2, y+4, z+1, Blocks.cobblestone);
			}
			
			for(i=0;i<4;i++) {
				world.setBlock(x+2, y+i, z+1, Blocks.cobblestone);
				world.setBlock(x-2, y+i, z+1, Blocks.cobblestone);
				
			}
			
			for(i=0;i<3;i++) {
				world.setBlock(x+1, y+i+1, z+2, Blocks.cobblestone);
				world.setBlock(x-1, y+i+1, z+2, Blocks.cobblestone);
			}
			
			for(i=0;i<2;i++) {
				world.setBlock(x+2, y-1, z+i+1, Blocks.cobblestone);
				world.setBlock(x-2, y-1, z+i+1, Blocks.cobblestone);
				world.setBlock(x, y+i+1, z+3, Blocks.cobblestone);
			}
			//out 1
			world.setBlock(x+2, y, z+2, Blocks.cobblestone);
			world.setBlock(x-2, y, z+2, Blocks.cobblestone);
			world.setBlock(x, y+3, z+2, magmabeo.Titan_Ore);
			//out 1
			//down
			for(int ii=-1;ii<60;i++) {
				for(i=-1;i<2;i++) {
					world.setBlock(x+i, y-ii, z+ii+4, Blocks.cobblestone);
					world.setBlock(x+i, y-ii-1, z+ii+4, Blocks.air);//c-a-a-a-c le chemin
					world.setBlock(x+i, y-ii-2, z+ii+4, Blocks.air);
					world.setBlock(x+i, y-ii-3, z+ii+4, Blocks.air);
					world.setBlock(x+i, y-ii-4, z+ii+4, Blocks.cobblestone);
				}
			}
			
		
		
		}
		
	}

}
