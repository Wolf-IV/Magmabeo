package Wolf_IV.magmabeo;

import Wolf_IV.magmabeo.magmabeo;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class CraftT extends Item{
public CraftT() {
this.setMaxStackSize(1);
	//real bucket //this.setContainerItem((new ItemBucket(Blocks.air)).setUnlocalizedName("bucket").setMaxStackSize(16).setTextureName("bucket_empty"));
	//this.setContainerItem(this.setDamage((new ItemStack(this)), duraLeft));

	


	this.setContainerItem(this);




}
}
