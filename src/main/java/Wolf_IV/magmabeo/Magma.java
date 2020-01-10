package Wolf_IV.magmabeo;

import net.minecraftforge.fluids.Fluid;

public class Magma extends Fluid {

	public Magma(String fluidName) {
		super(fluidName);
		
		this.setViscosity(1250);
		//inverse la direction du magma
		//this.setDensity(-1000);
		
	}

}
