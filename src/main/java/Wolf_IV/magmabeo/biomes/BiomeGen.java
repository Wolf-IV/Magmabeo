package Wolf_IV.magmabeo.biomes;

import java.util.Random;

import Wolf_IV.magmabeo.magmabeo;
import Wolf_IV.magmabeo.world.WorldGenMod;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.World;


public class BiomeGen extends BiomeGenBase{
	int i;



	public BiomeGen(int p_i1971_1_) {
		super(p_i1971_1_);
		this.topBlock = Blocks.nether_brick;
		this.setBiomeName("Magma");
		this.fillerBlock = Blocks.glowstone;
		 this.spawnableMonsterList.clear();
	        this.spawnableCreatureList.clear();
	        this.spawnableWaterCreatureList.clear();
	        this.spawnableCaveCreatureList.clear();
	        this.enableRain = false;
	        this.waterColorMultiplier= 15101991;
	        //this.BiomeDecorator.generateLakes = false;
	        
	      
	        
	}
	
	
	 public void addStructure(String string, Random rand, World world, int posX, int posZ, int minY, int maxY, int spawnChance) {
		 for(i=0; i< spawnChance; i++) {
			 int chunkSize =16;
			 int Xpos=posX+ rand.nextInt(chunkSize);
			 int Ypos=minY+ rand.nextInt(maxY - minY);
			 int Zpos=posZ+ rand.nextInt(chunkSize);
			 new StructureGenMagma().generate(string, world, rand, Xpos, Ypos, Zpos);
		 }
	  
	 }
	  public void decorate(World world, Random rand, int par1, int par2) {
		addStructure("magmas1", rand, world, par1, par2, 60, 90, 5);
		addStructure("crafting", rand, world, par1, par2, 60, 90, 5);
		addStructure("dungeon", rand, world, par1, par2, 60, 90, 1);
		WorldGenMod.addOre(Blocks.netherrack, Blocks.stone, rand, world, par1, par2, 15, 130, 16, 48, 5);
		WorldGenMod.addOre(magmabeo.Titan_Ore, Blocks.netherrack, rand, world, par1, par2, 10, 130, 3, 11, 8);
	  }
	 

}
