package Wolf_IV.magmabeo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCakeMaker extends Block{

	protected BlockCakeMaker(Material material) {
		super(material);
	    this.setStepSound(this.soundTypeMetal);
	    this.setLightOpacity(16);
	}
	 @Override
		public boolean isOpaqueCube() {
		return false;
		}

}
