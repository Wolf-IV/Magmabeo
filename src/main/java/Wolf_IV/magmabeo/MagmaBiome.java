package Wolf_IV.magmabeo;

import Wolf_IV.magmabeo.biomes.BiomeGen;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class MagmaBiome {

	public static void init() {
		
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(new BiomeGen(236), 100));
		
	}
}
