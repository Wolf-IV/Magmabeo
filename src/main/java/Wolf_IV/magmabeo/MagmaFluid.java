package Wolf_IV.magmabeo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class MagmaFluid extends BlockFluidClassic {


	    public MagmaFluid(Fluid fluid,Material material) {
	        super(fluid, material);
	        this.setLightLevel(18.0F);
	        
	   
	   
	    }

	    
	    
	  @Override
	public boolean isOpaqueCube() {
	return false;
	}
	  
}	
