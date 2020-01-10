package Wolf_IV.magmabeo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Beo_Ore extends Block {

    public Beo_Ore(Material material) {
        super(material);

        this.setHarvestLevel("pickaxe", 4);
        this.setHardness(60.0F);
        this.setResistance(25.0F);
        this.setLightOpacity(16);

    }

    
    

@Override
public boolean isOpaqueCube() {
return false;
}

@Override
public Item getItemDropped(int metadata, Random rand, int fortune) {
	return magmabeo.Beo_Piece; 
}
@Override
public int quantityDropped(Random rand) {
	return rand.nextInt(1+1)+1;//1-2
}












}