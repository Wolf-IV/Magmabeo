package Wolf_IV.magmabeo;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class Yittrium extends BlockFalling{
public Yittrium() {
	super(Material.rock);
	this.setHarvestLevel("shovel", 3);    
    this.setHardness(30.0F);
    this.setResistance(26.0F);
    this.setLightOpacity(16);
	this.setStepSound(soundTypeGravel);
}
	
}
