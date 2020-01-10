package Wolf_IV.magmabeo;

import Wolf_IV.magmabeo.armor.Abeo_Armor;
import Wolf_IV.magmabeo.armor.Titan_Armor;
import Wolf_IV.magmabeo.creative.Bedrock_;
import Wolf_IV.magmabeo.proxy.ClientProxy;
import Wolf_IV.magmabeo.proxy.CommonProxy;
import Wolf_IV.magmabeo.tool.Beo_Pickaxe;
import Wolf_IV.magmabeo.tool.Key;
import Wolf_IV.magmabeo.tool.Titan_Hammer;
import Wolf_IV.magmabeo.world.WorldGenMod;
import Wolf_IV.magmabeo.world.WorldRegister;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = "magmabeo", name = "Magmabeo", version = "1.0.0")
public class magmabeo {
	// setup instance
	//public static ClientProxy NonStatic = null;
	@Instance("magmabeo")
	public static magmabeo instance;
	public static boolean Ulty;
	// setup instance

	// setup proxy
	@SidedProxy(clientSide = "Wolf_IV.magmabeo.proxy.ClientProxy", serverSide = "Wolf_IV.magmabeo.proxy.CommonProxy")
	public static CommonProxy proxy;
	// setup proxy
	//Creative
	public static Item Bedrock_;
	//Creative
	// Ores
	public static Block Beo_Ore;
	public static Block Ardium_Ore;
	public static Block Titan_Ore;
	// Ores
	// Item Ores
	public static Item Titan_Fragment;
	public static Item Beo_Piece;
	public static Item Ardium_Piece;
	// Item Ores
	// Tools
	public static final Item.ToolMaterial titanTools = EnumHelper.addToolMaterial("titanTools", 4, 640, 7.75F, 5.5F,
			10);
	public static Item Titan_Hammer;
	//Beo
	public static final Item.ToolMaterial beoTools = EnumHelper.addToolMaterial("beoTools", 5, 920, 8.0F, 4.5F, 10);
	public static Item Beo_Pickaxe;
	//Abeo
	public static final Item.ToolMaterial abeoTools = EnumHelper.addToolMaterial("beoTools", 5, 594, 9.75F, 4.5F, 10);
	public static Item Abeo_Sword;
	// Tools
	
	// Armor
	public static final ItemArmor.ArmorMaterial titanArmor = EnumHelper.addArmorMaterial("titanArmor", 45,
			new int[] { 3, 8, 6, 3 }, 10);
	//..
	public static final ItemArmor.ArmorMaterial abeoArmor = EnumHelper.addArmorMaterial("titanArmor", 50,
			new int[] { 3, 8, 6, 3 }, 10);
	// Titan
	public static Item Titan_Helmet;
	public static Item Titan_Chestplate;
	public static Item Titan_Leggings;
	public static Item Titan_Boots;
	// Armor
	public static Item Titan_Ingot;
	public static Block Titan_Block;
	public static Item Titan_Nugget;
	// Stuff
	
	//Beo
	public static Item Beo_Ingot;
	public static Block Beo_Block;
	public static Item Beo_Nugget;
	public static Item Beo_Dust;
	//Stuff
	//Ardium
	public static Item Ardium_Ingot;
	public static Block Ardium_Block;
	public static Item Ardium_Nugget;
	public static Item Ardium_Dust;
	//Stuff
	
	//Abeo
	public static Item Abeo_Helmet;
	public static Item Abeo_Chestplate;
	public static Item Abeo_Leggings;
	public static Item Abeo_Boots;
	//Armor
	public static Item Abeo_Ingot;
	public static Block Abeo_Block;
	public static Item Abeo_Nugget;
	public static Item Abeo_Dust;
	// Stuff

	// Magma
	public static Block MagmaFluid;
	public static Fluid Magma;
	public static Item Magma_Bucket;
	// Magma
	
	//Crafting Tools
	public static Item Hammer;
	public static Item Plate;
	public static Item Mortar;
	public static Item Key;
	//Crafting Tools
      
 
	@EventHandler

	public void PreInit(FMLPreInitializationEvent event)

	{

		// imports
		/* import:Ores */WorldRegister.registry();
		/* import:Ores */
		/* Biome_Magma */ MagmaBiome.init(); /* Biome_Magma */
		// imports
		//Creative
		Bedrock_ = new Bedrock_().setUnlocalizedName("Bedrock_").setTextureName("magmabeo:Bedrock_")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Bedrock_, Bedrock_.getUnlocalizedName().substring(5));
		//Creative
		// Beo_Ore
		Beo_Ore = new Beo_Ore(Material.rock).setBlockName("Beo_Ore").setBlockTextureName("magmabeo:BOre")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerBlock(Beo_Ore, Beo_Ore.getUnlocalizedName().substring(5));
		//..
		Beo_Piece = new ItemCakeMaker().setUnlocalizedName("Beo_Piece").setTextureName("magmabeo:BPie")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Beo_Piece, Beo_Piece.getUnlocalizedName().substring(5));
		// Beo_Ore

		// Ardium_Ore
		Ardium_Ore = new Ardium_Ore(Material.rock).setBlockName("Ardium_Ore").setBlockTextureName("magmabeo:AOre")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerBlock(Ardium_Ore, Ardium_Ore.getUnlocalizedName().substring(5));
		//..
		Ardium_Piece = new ItemCakeMaker().setUnlocalizedName("Ardium_Piece").setTextureName("magmabeo:APie")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Ardium_Piece, Ardium_Piece.getUnlocalizedName().substring(5));
		// Ardium_Ore

		// Titan_Ore
		Titan_Ore = new Titan_Ore(Material.rock).setBlockName("Titan_Ore").setBlockTextureName("magmabeo:TOre")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerBlock(Titan_Ore, Titan_Ore.getUnlocalizedName().substring(5));
		// ..
		Titan_Fragment = new ItemCakeMaker().setUnlocalizedName("Titan_Fragment").setTextureName("magmabeo:TFrag")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Fragment, Titan_Fragment.getUnlocalizedName().substring(5));
		// Titan_Ore
		//Beo Stuff
		Beo_Nugget = new ItemCakeMaker().setUnlocalizedName("Beo_Nugget")
				.setTextureName("magmabeo:BNug").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Beo_Nugget, Beo_Nugget.getUnlocalizedName().substring(5));
		//..
		Beo_Ingot = new ItemCakeMaker().setUnlocalizedName("Beo_Ingot")
				.setTextureName("magmabeo:BIngot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Beo_Ingot, Beo_Ingot.getUnlocalizedName().substring(5));
		//..
		Beo_Block = new BlockCakeMaker(Material.iron).setBlockName("Beo_Block")
				.setBlockTextureName("magmabeo:BBlock").setCreativeTab(magmabeoTab).setHardness(20.0F).setResistance(22.5F);
		GameRegistry.registerBlock(Beo_Block, Beo_Block.getUnlocalizedName().substring(5));
		//..
		Beo_Dust = new ItemCakeMaker().setUnlocalizedName("Beo_Dust").setTextureName("magmabeo:BDust")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Beo_Dust, Beo_Dust.getUnlocalizedName().substring(5));
		//Beo Stuff
		Beo_Pickaxe = new Beo_Pickaxe(beoTools).setUnlocalizedName("Beo_Pickaxe").setTextureName("magmabeo:BPick")
				.setFull3D().setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Beo_Pickaxe, Beo_Pickaxe.getUnlocalizedName().substring(5));
		//Beo Tool
		//Ardium Stuff
		Ardium_Nugget = new ItemCakeMaker().setUnlocalizedName("Ardium_Nugget")
				.setTextureName("magmabeo:ANug").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Ardium_Nugget, Ardium_Nugget.getUnlocalizedName().substring(5));
		//..
		Ardium_Ingot = new ItemCakeMaker().setUnlocalizedName("Ardium_Ingot")
				.setTextureName("magmabeo:AIngot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Ardium_Ingot, Ardium_Ingot.getUnlocalizedName().substring(5));
		//..
		Ardium_Block = new BlockCakeMaker(Material.iron).setBlockName("Ardium_Block")
				.setBlockTextureName("magmabeo:ABlock").setCreativeTab(magmabeoTab).setHardness(20.0F)
						.setResistance(22.5F).setLightLevel(10.0F);
		GameRegistry.registerBlock(Ardium_Block, Ardium_Block.getUnlocalizedName().substring(5));
		//..
		Ardium_Dust = new ItemCakeMaker().setUnlocalizedName("Ardium_Dust").setTextureName("magmabeo:ADust")
				.setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Ardium_Dust, Ardium_Dust.getUnlocalizedName().substring(5));
		//Ardium Stuff

		// Titan Hammer
		Titan_Hammer = new Titan_Hammer(titanTools).setUnlocalizedName("Titan_Hammer").setTextureName("magmabeo:THam")
				.setFull3D().setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Hammer, Titan_Hammer.getUnlocalizedName().substring(5));
		// Titan Hammer

		// Titan Armor
		Titan_Helmet = new Titan_Armor(titanArmor, 0, 0).setUnlocalizedName("Titan_Helmet")
				.setTextureName("magmabeo:THelm").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Helmet, Titan_Helmet.getUnlocalizedName().substring(5));
		// ..
		Titan_Chestplate = new Titan_Armor(titanArmor, 0, 1).setUnlocalizedName("Titan_Chestplate")
				.setTextureName("magmabeo:TChest").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Chestplate, Titan_Chestplate.getUnlocalizedName().substring(5));
		// ..
		Titan_Leggings = new Titan_Armor(titanArmor, 0, 2).setUnlocalizedName("Titan_Leggings")
				.setTextureName("magmabeo:TLeg").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Leggings, Titan_Leggings.getUnlocalizedName().substring(5));
		// ..
		Titan_Boots = new Titan_Armor(titanArmor, 0, 3).setUnlocalizedName("Titan_Boots")
				.setTextureName("magmabeo:TBoot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Boots, Titan_Boots.getUnlocalizedName().substring(5));
		// Titan Armor
		
		// Titan Stuff
		Titan_Nugget = new ItemCakeMaker().setUnlocalizedName("Titan_Nugget")
				.setTextureName("magmabeo:TNug").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Nugget, Titan_Nugget.getUnlocalizedName().substring(5));
		//..
		Titan_Ingot = new ItemCakeMaker().setUnlocalizedName("Titan_Ingot")
				.setTextureName("magmabeo:TIngot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Titan_Ingot, Titan_Ingot.getUnlocalizedName().substring(5));
		//..
		Titan_Block = new BlockCakeMaker(Material.iron).setBlockName("Titan_Block")
				.setBlockTextureName("magmabeo:TBlock").setCreativeTab(magmabeoTab).setHardness(15.0F).setResistance(25.0F);
		GameRegistry.registerBlock(Titan_Block, Titan_Block.getUnlocalizedName().substring(5));
		// Titan Stuff
		
		//Abeo Armor
		Abeo_Helmet = new Abeo_Armor(abeoArmor, 0, 0).setUnlocalizedName("Abeo_Helmet")
				.setTextureName("magmabeo:ABHelm").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Helmet, Abeo_Helmet.getUnlocalizedName().substring(5));
		// ..
		Abeo_Chestplate = new Abeo_Armor(abeoArmor, 0, 1).setUnlocalizedName("Abeo_Chestplate")
				.setTextureName("magmabeo:ABChest").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Chestplate, Abeo_Chestplate.getUnlocalizedName().substring(5));
		// ..
		Abeo_Leggings = new Abeo_Armor(abeoArmor, 0, 2).setUnlocalizedName("Abeo_Leggings")
				.setTextureName("magmabeo:ABLeg").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Leggings, Abeo_Leggings.getUnlocalizedName().substring(5));
		// ..
		Abeo_Boots = new Abeo_Armor(abeoArmor, 0, 3).setUnlocalizedName("Abeo_Boots")
				.setTextureName("magmabeo:ABBoot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Boots, Abeo_Boots.getUnlocalizedName().substring(5));
		//Abeo Armor
		
		//Abeo Stuff
		Abeo_Nugget = new ItemCakeMaker().setUnlocalizedName("Abeo_Nugget")
				.setTextureName("magmabeo:ABNug").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Nugget, Abeo_Nugget.getUnlocalizedName().substring(5));
		//..
		Abeo_Ingot = new ItemCakeMaker().setUnlocalizedName("Abeo_Ingot")
				.setTextureName("magmabeo:ABIngot").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Ingot, Abeo_Ingot.getUnlocalizedName().substring(5));
		//..
		Abeo_Block = new BlockCakeMaker(Material.iron).setBlockName("Abeo_Block")
				.setBlockTextureName("magmabeo:ABBlock").setCreativeTab(magmabeoTab).setHardness(15.0F).setResistance(25.0F);
		GameRegistry.registerBlock(Abeo_Block, Abeo_Block.getUnlocalizedName().substring(5));
		//..
		Abeo_Dust = new ItemCakeMaker().setUnlocalizedName("Abeo_Dust")
				.setTextureName("magmabeo:ABDust").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Abeo_Dust, Abeo_Dust.getUnlocalizedName().substring(5));
		//Abeo Stuff
		
		//Abeo Sword
		
		// Magma
		Magma = new Magma("Magma").setUnlocalizedName("Magma");
		FluidRegistry.registerFluid(Magma);
		// ..
		MagmaFluid = new MagmaFluid(magmabeo.Magma, Material.lava).setBlockName("MagmaFluid")
				.setBlockTextureName("magmabeo:Magma").setCreativeTab(magmabeoTab);
		GameRegistry.registerBlock(MagmaFluid, MagmaFluid.getUnlocalizedName().substring(5));
		// ..
		Magma_Bucket = new MagmaBucket(null);
		GameRegistry.registerItem(Magma_Bucket, Magma_Bucket.getUnlocalizedName().substring(5));
		// ..
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		// Magma
		//Crafting Tools
		Hammer = new CraftT().setUnlocalizedName("Hammer")
				.setTextureName("magmabeo:Hammer").setCreativeTab(magmabeoTab).setFull3D();
		GameRegistry.registerItem(Hammer, Hammer.getUnlocalizedName().substring(5));
		//..
		Plate = new CraftT().setUnlocalizedName("Plate")
				.setTextureName("magmabeo:Plate").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Plate, Plate.getUnlocalizedName().substring(5));
		//..
		Mortar = new CraftT().setUnlocalizedName("Mortar")
				.setTextureName("magmabeo:Mortar").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Mortar, Mortar.getUnlocalizedName().substring(5));
		//..
		Key = new Key().setUnlocalizedName("Key")
				.setTextureName("magmabeo:Key").setCreativeTab(magmabeoTab);
		GameRegistry.registerItem(Key, Key.getUnlocalizedName().substring(5));
		//Crafting Tools
		/**
		 * SMELTING
		 */
		//Titan
		GameRegistry.addSmelting(Titan_Fragment ,new ItemStack(Titan_Nugget), 10.0F);
		//Titan
		//Beo
		GameRegistry.addSmelting(Beo_Piece ,new ItemStack(Beo_Nugget, 4), 10.0F);
		GameRegistry.addSmelting(Beo_Dust ,new ItemStack(Beo_Ingot), 0.0F);
		//Beo
		//Ardium
		GameRegistry.addSmelting(Ardium_Piece ,new ItemStack(Ardium_Nugget, 4), 10.0F);
		GameRegistry.addSmelting(Ardium_Dust ,new ItemStack(Ardium_Ingot), 0.0F);
		//Ardium
		
	}

	@EventHandler

	public void Init(FMLInitializationEvent event)

	{
		
		//Crafting
		
		//Abeo
		GameRegistry.addShapelessRecipe(new ItemStack(Abeo_Dust), new Object[] {Beo_Dust,Ardium_Dust});
		//..
		GameRegistry.addRecipe(new ItemStack(Abeo_Block), new Object[] {"TTT","TTT","TTT",'T',Abeo_Ingot});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Abeo_Ingot, 9), new Object[] {"T",'T',Abeo_Block});
		//..
		GameRegistry.addRecipe(new ItemStack(Abeo_Ingot), new Object[] {"TTT","TTT","TTT",'T',Abeo_Nugget});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Abeo_Nugget, 9), new Object[] {"T",'T',Abeo_Ingot});
		//Stuff
		GameRegistry.addRecipe(new ItemStack(Abeo_Helmet), new Object[] {"TTT","T T",'T',Abeo_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Abeo_Chestplate), new Object[] {"T T","TTT","TTT",'T',Abeo_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Abeo_Leggings), new Object[] {"TTT","T T","T T",'T',Abeo_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Abeo_Boots), new Object[] {"T T","T T",'T',Abeo_Ingot});
		//Armur
		
		//Ardium
		GameRegistry.addRecipe(new ItemStack(Ardium_Block), new Object[] {"TTT","TTT","TTT",'T',Ardium_Ingot});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Ardium_Ingot, 9), new Object[] {"T",'T',Ardium_Block});
		//..
		GameRegistry.addRecipe(new ItemStack(Ardium_Ingot), new Object[] {"TTT","TTT","TTT",'T',Ardium_Nugget});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Ardium_Nugget, 9), new Object[] {"T",'T',Ardium_Ingot});
		//Stuff
		
		//Tool
		GameRegistry.addRecipe(new ItemStack(Titan_Hammer), new Object[] {"TTT","TTT"," S ",'T',Titan_Ingot,'S',Items.stick});
		//Titan
		GameRegistry.addRecipe(new ItemStack(Beo_Pickaxe), new Object[] {"TTT"," S "," S ",'T',Beo_Ingot,'S',Items.stick});
		//Beo
		
		//Beo
		GameRegistry.addRecipe(new ItemStack(Beo_Block), new Object[] {"TTT","TTT","TTT",'T',Beo_Ingot});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Beo_Ingot, 9), new Object[] {"T",'T',Beo_Block});
				//..
		GameRegistry.addRecipe(new ItemStack(Beo_Ingot), new Object[] {"TTT","TTT","TTT",'T',Beo_Nugget});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Beo_Nugget, 9), new Object[] {"T",'T',Beo_Ingot});
		//Stuff
				
		//Tool
		GameRegistry.addRecipe(new ItemStack(Titan_Hammer), new Object[] {"TTT","TTT"," S ",'T',Titan_Ingot,'S',Items.stick});
		//Titan
		GameRegistry.addRecipe(new ItemStack(Beo_Pickaxe), new Object[] {"TTT"," S "," S ",'T',Beo_Ingot,'S',Items.stick});
		//Beo
		
		//Titan
		GameRegistry.addRecipe(new ItemStack(Titan_Helmet), new Object[] {"TTT","T T",'T',Titan_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Titan_Chestplate), new Object[] {"T T","TTT","TTT",'T',Titan_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Titan_Leggings), new Object[] {"TTT","T T","T T",'T',Titan_Ingot});
		//..
		GameRegistry.addRecipe(new ItemStack(Titan_Boots), new Object[] {"T T","T T",'T',Titan_Ingot});
		//Armor
		GameRegistry.addRecipe(new ItemStack(Titan_Block), new Object[] {"TTT","TTT","TTT",'T',Titan_Ingot});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Titan_Ingot, 9), new Object[] {"T",'T',Titan_Block});
		//..
		GameRegistry.addRecipe(new ItemStack(Titan_Ingot), new Object[] {"TTT","TTT","TTT",'T',Titan_Nugget});
		/**--->*/GameRegistry.addRecipe(new ItemStack(Titan_Nugget, 9), new Object[] {"T",'T',Titan_Ingot});
		//Stuff
		//Crafting Tools
		GameRegistry.addRecipe(new ItemStack(Hammer), new Object[] {"III","III"," S ",'I',Items.iron_ingot,'S',Items.stick});
		GameRegistry.addRecipe(new ItemStack(Mortar), new Object[] {"I I","I I","III",'I',Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(Plate), new Object[] {"III",'I',Items.iron_ingot});
		//Crafting Tools
		
		//Craft of Crafting Tools
		GameRegistry.addRecipe(new ItemStack(Ardium_Dust), new Object[] {"H","A","M",'H',Hammer,'A',Ardium_Ingot,'M',Mortar});
		GameRegistry.addRecipe(new ItemStack(Beo_Dust), new Object[] {"H","B","M",'H',Hammer,'B',Beo_Ingot,'M',Mortar});
		//Craft of Crafting Tools
	
	}

	@EventHandler

	public void PostInit(FMLPostInitializationEvent event)

	{

	}

	public static CreativeTabs magmabeoTab=new CreativeTabs("magmabeoTab"){@Override public Item getTabIconItem(){return new ItemStack(magmabeo.Titan_Hammer).getItem();}};

	/*static boolean inputKeyResult;
	public static  void setUltimatePressed(boolean inputKey){
		if( inputKey==true) {
			inputKeyResult=true;
		
	}else {inputKeyResult=false;}
		
		}
	public static boolean ultimateIsPressed() {
		if( inputKeyResult==true) {
			return true;
		}
		return false;
	}*/
	
}


