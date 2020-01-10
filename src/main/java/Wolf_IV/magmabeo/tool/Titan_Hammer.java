package Wolf_IV.magmabeo.tool;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import Wolf_IV.magmabeo.magmabeo;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class Titan_Hammer extends ItemSword{

	public Titan_Hammer(ToolMaterial material) {
		super(material);
	//this.setMaxDamage(10);
	}
	
	@Override
	public Set<String> getToolClasses (ItemStack stack){
		return 	ImmutableSet.of("pickaxe");
	};
	private static Set<Block> effectiveAgainst = Sets.newHashSet(new Block[]
			{
					 magmabeo.Beo_Ore, magmabeo.Titan_Block
			});
	@Override
	public boolean canHarvestBlock(Block block,ItemStack stack)
	{
		return effectiveAgainst.contains(block) ? true : super.canHarvestBlock(block, stack);
	}
		@Override
		public float func_150893_a(ItemStack stack,Block block)
		{
			return effectiveAgainst.contains(block) ? 20.0F : super.func_150893_a(stack, block);
		}
	//truc qui marche pas
	/* public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	    {
	        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
	        return stack;
	    }*///truc qui marche pas
	//truc pour posé de la bedrock

}
