package Wolf_IV.magmabeo.armor;

import Wolf_IV.magmabeo.magmabeo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Abeo_Armor extends ItemArmor{
	boolean armorInstant= false;
	int timeHold=0;
	boolean keyFirst=false;
	boolean launchEffect;
	int launchEffectNmb;
	int supEffectNmb;
	int supEffectIntit=5;
	boolean pantsWeared;
	boolean bootsWeared;
	boolean helmWeared;
	public Abeo_Armor(ArmorMaterial armor, int render, int type) {
		super(armor, render, type);
		}
	//texture
	@Override public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
	
		if(this.armorType==2) {
			return "magmabeo:textures/models/armor/Abeo2.png";
		}
		return "magmabeo:textures/models/armor/Abeo.png";}
	//texture


	@SubscribeEvent
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack ) {
		moreHealth(magmabeo.Abeo_Helmet, magmabeo.Abeo_Chestplate, magmabeo.Abeo_Leggings, magmabeo.Abeo_Boots, 4, world, player, stack);
	
		/**
		  * CASQUE
		  */
		 if (player.getCurrentArmor(3)!=null) {//effet du casque
			ItemStack helm =player.getCurrentArmor(3);
		if (helm.getItem() == magmabeo.Abeo_Helmet) {
			player.addPotionEffect(new	PotionEffect(Potion.digSpeed.getId(), 100, 0, true));
			//helmWeared=true;
			
		
		}}

			/**
			 * BOOTS
			 */
			if (player.getCurrentArmor(0)!=null) {//effet des boot
				ItemStack boot= player.getCurrentArmor(0);
			if (boot.getItem() == magmabeo.Abeo_Boots) {
				player.addPotionEffect(new	PotionEffect(Potion.jump.getId(), 100, 0, true));
				//bootsWeared=true;
				}}
			/**
			 * PANTALON
			 */
			if (player.getCurrentArmor(1)!=null) {//effet du pantalon
					ItemStack pants =player.getCurrentArmor(1);
				if (pants.getItem() == magmabeo.Abeo_Leggings) {
					player.addPotionEffect(new	PotionEffect(Potion.moveSpeed.getId(), 100, 0, true));
					}}
			/**
			 * CHESTPLATE
			 */
			if (player.getCurrentArmor(2)!=null) {//effet du chest
					ItemStack chest =player.getCurrentArmor(2);
				if (chest.getItem() == magmabeo.Abeo_Leggings) {
					player.addPotionEffect(new	PotionEffect(Potion.resistance.getId(), 100, 0, true));
					}}
	
	
	
	
	}





	
	
	/**
	 * BOOST DE VIE
	 */
	public void moreHealth(Item helm, Item chest, Item pants, Item boots, int niv, World world, EntityPlayer player, ItemStack stack) {
		
		
		if (player.getCurrentArmor(1)!=null) {
			ItemStack pantsNow =player.getCurrentArmor(1);
		if (pantsNow.getItem() == pants) {
		
			pantsWeared=true;
			}else {pantsWeared=false;}
	 }else {pantsWeared=false;}
	
	
		if (player.getCurrentArmor(3)!=null) {
			ItemStack helmNow =player.getCurrentArmor(3);
		if (helmNow.getItem() == helm) {
			helmWeared=true;
			
			}else {helmWeared=false;}
	 }else {helmWeared=false;}
		
		
		if (player.getCurrentArmor(0)!=null) {
			ItemStack bootsNow =player.getCurrentArmor(0);
		if (bootsNow.getItem() == boots) {
			bootsWeared=true;
			
			}else {bootsWeared=false;}
	 }else {bootsWeared=false;}
	
		
		
		if (player.getCurrentArmor(2)!=null) {
			ItemStack chestNow =player.getCurrentArmor(2);
		if (chestNow.getItem() == chest && pantsWeared==true && bootsWeared==true && helmWeared==true) {
			if ( armorInstant==true) {
				launchEffectNmb=40;//met l'effet 40 fois (2s)
				launchEffect=true;}
			if (launchEffect=true && launchEffectNmb>0 ) {
				launchEffectNmb--;
				player.addPotionEffect(new	PotionEffect(Potion.field_76434_w.getId(), 9999999, niv, true));//health boost
			}
			
			 armorInstant=false;
			}/**/else {
				
				if(armorInstant==false) {
					supEffectNmb=supEffectIntit;//enleve l'effect quand plus porter
				}
				if(supEffectNmb>0 ) {
					supEffectNmb--;
					player.addPotionEffect(new	PotionEffect(Potion.field_76434_w.getId(), 1, niv+1, true));//ENLEVE
				}
				armorInstant=true;
				}/**/
		}else {
			
		
		if(armorInstant==false) {
			supEffectNmb=supEffectIntit;//enleve l'effect quand plus porter
		}
		if(supEffectNmb>0) {
			supEffectNmb--;
			player.addPotionEffect(new	PotionEffect(Potion.field_76434_w.getId(), 1, niv+1, true));//ENLEVE
		}
		
		armorInstant=true;
		}
		/**
		 * FIN BOOST DE VIE
		 */}

}//fin
