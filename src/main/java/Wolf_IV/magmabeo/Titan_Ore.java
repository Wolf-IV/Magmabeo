package Wolf_IV.magmabeo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Titan_Ore extends Block{

    public Titan_Ore(Material material) {
        super(material);
        this.setHarvestLevel("pickaxe", 6);
        this.setHardness(20.0F);
        this.setResistance(20.0F);
        this.setStepSound(this.soundTypeMetal);
        this.setLightOpacity(16);
        
        
    }


@Override
public boolean isOpaqueCube() {
return false;
}
@Override
public Item getItemDropped(int metadata, Random rand, int fortune) {
	return magmabeo.Titan_Fragment;
}
@Override
public int quantityDropped(Random rand) {
	return rand.nextInt(128+1);//0-128
}

}



