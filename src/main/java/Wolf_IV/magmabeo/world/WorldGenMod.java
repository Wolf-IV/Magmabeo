package Wolf_IV.magmabeo.world;

import java.util.Random;

import Wolf_IV.magmabeo.magmabeo;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenMod implements IWorldGenerator{//first

@Override
public void generate(Random rand	, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
		IChunkProvider chunkProvider) {//2

	switch(world.provider.dimensionId) {
	case -1:
		GenerateNether(world, chunkX *16 ,chunkZ *16, rand);
		break;
	case 0:
		GenerateOverWorld(world, chunkX *16 ,chunkZ *16, rand);
		break;
	case 1:
		GenerateEnd(world, chunkX *16 ,chunkZ *16, rand);
		break;
	
	}






}//2

public static void addOre(Block block, Block blockSpawn, Random rand, World world, int posX, int posZ, int minY, int maxY, int minV, int maxV, int spawnChance) {
int i;
	for(i=0;i<spawnChance; i++) {
		int chunkSize= 16;
		int X= posX + rand.nextInt(chunkSize);
		int Y= rand.nextInt(maxY-minY)+minY;//limite de generation par rapport a la couche (min-max)
		int Z= posZ + rand.nextInt(chunkSize);
		
		new WorldGenMinable(block, maxV, blockSpawn).generate(world, rand, X, Y, Z);
	
	}//for
	
	
}//3

private void GenerateEnd(World world, int par1, int par2, Random rand) {

	
}//End

private void GenerateOverWorld(World world, int par1, int par2, Random rand) {

	
}//OverWorld

private void GenerateNether(World world, int par1, int par2, Random rand) {
	addOre(magmabeo.Beo_Ore, Blocks.netherrack, rand, world, par1, par2, 0, 120, 1, 2, 1);
	addOre(magmabeo.Titan_Ore, Blocks.netherrack, rand, world, par1, par2, 0, 120, 1, 2, 1);
	addOre(magmabeo.Ardium_Ore, Blocks.netherrack, rand, world, par1, par2, 10, 130, 3, 11, 4);
	
	
}//nether

}//first
