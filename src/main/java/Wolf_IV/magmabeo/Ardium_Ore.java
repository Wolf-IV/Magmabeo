package Wolf_IV.magmabeo;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Ardium_Ore extends Block{

    public Ardium_Ore(Material material) {
        super(material);
    this.setHarvestLevel("pickaxe", 5);    
    this.setHardness(80.0F);
    this.setResistance(26.0F);
    this.setLightLevel(10.0F);
    this.setLightOpacity(16);

    
    }

    
    
  @Override
public boolean isOpaqueCube() {
return false;
}
  
}
