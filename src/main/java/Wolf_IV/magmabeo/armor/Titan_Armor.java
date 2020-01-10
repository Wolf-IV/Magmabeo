package Wolf_IV.magmabeo.armor;


import java.awt.Event;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.mojang.authlib.GameProfile;
import Wolf_IV.magmabeo.writing.Write;
import Wolf_IV.magmabeo.writing.Read;
import Wolf_IV.magmabeo.magmabeo;
import Wolf_IV.magmabeo.proxy.ClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHealthBoost;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class Titan_Armor extends ItemArmor{
	boolean pasup= true;//A sup
	boolean armorInstant= false;
	int time=0;
	int timeIn=0;
	String powerS="0";
	int power=0;
	boolean keyFirst=false;
	boolean launchEffect;
	int launchEffectNmb;
	int supEffectNmb;
	int supEffectIntit=5;
	boolean pantsWeared;
	boolean bootsWeared;
	boolean helmWeared;
	

	public Titan_Armor(ArmorMaterial armor, int render, int type) {
		super(armor, render, type);
		}
	//texture
	@Override public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
	
		if(this.armorType==2) {
			return "magmabeo:textures/models/armor/Titan2.png";
		}
		return "magmabeo:textures/models/armor/Titan.png";}
	//texture
	
	//effect
	
	@SubscribeEvent
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack ) {
		//ItemTooltipEvent event= new ItemTooltipEvent(stack, player, null, armorInstant);
	
		
	
		 
		/**
		 * PANTALON
		 */
		/*if (player.getCurrentArmor(1)!=null) {//effet du pantalon
				ItemStack pants =player.getCurrentArmor(1);
			if (pants.getItem() == magmabeo.Titan_Leggings) {
				pantsWeared=true;
				}else {pantsWeared=false;}
		 }else {pantsWeared=false;}*/
		 
		
		 
		 /**
		  * CASQUE
		  */
		 if (player.getCurrentArmor(3)!=null) {//effet du casque
			ItemStack helm =player.getCurrentArmor(3);
		if (helm.getItem() == magmabeo.Titan_Helmet) {
			player.addPotionEffect(new	PotionEffect(Potion.digSpeed.getId(), 100, 0, true));
			//helmWeared=true;
			}else {/*helmWeared=false;*/}
		}else {/*helmWeared=false;*/}
		
		
		
		
		/**
		 * BOOTS
		 */
		if (player.getCurrentArmor(0)!=null) {//effet des boot
			ItemStack boot= player.getCurrentArmor(0);
		if (boot.getItem() == magmabeo.Titan_Boots) {
			player.addPotionEffect(new	PotionEffect(Potion.jump.getId(), 100, 0, true));
			//bootsWeared=true;
			}else {/*bootsWeared=false;*/}
		}else {/*bootsWeared=false;*/}
		
		
		
		
		
		
		/**
		 * A SUPRIMER
		 */
		
		if(Keyboard.isKeyDown(Keyboard.KEY_P) && pasup==true) {//crée un dossier pour faciliter le dev a sup
			pasup=false;//sasure de pas sapmer la commande fait crash
			try {//write power
				Write.write(player.getUniqueID(), power);
			} catch (IOException e) {
					e.printStackTrace();
			}
		
		}//a sup
		
		if(world.isRemote==false) {
		//time increases
		time++;
		timeIn++;
		if(timeIn==248) {//tout les changement 
			timeIn=0;
		float timeGive=(float) time;
		int percent=(int)Math.floor(timeGive/24800*100);
		System.out.println(percent+"%");}
		//time increases
		}
		moreHealth(magmabeo.Titan_Helmet, magmabeo.Titan_Chestplate, magmabeo.Titan_Leggings, magmabeo.Titan_Boots, 1, world, player, stack);
	
			//power change and save
		//tous les 20,3333333min verifié 10% chaque 124 seconde
		if(world.isRemote==false && time==24800) {
			time=0;//time reset
			try {//read power
				powerS=Read.read(player.getUniqueID());
				power=Integer.parseInt(powerS);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//up 5+5+5+5 en 4 fois
			power=power+5;
			
			try {//write power
				Write.write(player.getUniqueID(), power);
			} catch (IOException e) {
					e.printStackTrace();
			}
			
			
		}//power save
			
	
			if(world.isRemote==false) {
			
		/**
		 * ULTY
		 */
		if(player.getCurrentEquippedItem()!=null && player.getCurrentArmor(3)!=null && player.getCurrentArmor(2)!=null && player.getCurrentArmor(1)!=null && player.getCurrentArmor(0)!=null) {
			
			ItemStack item= player.getCurrentEquippedItem();
			ItemStack helm =player.getCurrentArmor(3);
			ItemStack chest= player.getCurrentArmor(2);
			ItemStack pants= player.getCurrentArmor(1);
			ItemStack boot= player.getCurrentArmor(0);
			if(item.getItem()==magmabeo.Titan_Hammer && helm.getItem()==magmabeo.Titan_Helmet && chest.getItem()==magmabeo.Titan_Chestplate && pants.getItem()==magmabeo.Titan_Leggings && boot.getItem()==magmabeo.Titan_Boots) {
				
				int maxFuse=160;
				int minFuse=40;
				int rslt=100;
				
				 double x=  Math.round(player.posX);
					double y=  Math.round(player.posY);
					double z=  Math.round(player.posZ);
					
				magmabeo key = new magmabeo(); 
				Explosion explosion= new Explosion(world, player, x, y, z, 1);
				EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (x), (y), (z), player);
				
				//keyfirst sert a actionner la bombe juste quand la touche est laché alors il lit le power est siil est superieur a 30 il actionne la bombe et reduit le power de 30 puis save
				if(key.Ulty==false ) {
				if(keyFirst==true) {
					keyFirst=false; rslt=100;
					 try {//read
							powerS=Read.read(player.getUniqueID());
							power=Integer.parseInt(powerS);
						} catch (IOException e) {
							e.printStackTrace();
						}//read
					if(power>=30) {
					 
				entitytntprimed.fuse = rslt ;
	            world.spawnEntityInWorld(entitytntprimed);
	            //change
	            power=power-30;
	            //change
	           /*write*/ try {//write power
					Write.write(player.getUniqueID(), power);
				} catch (IOException e) {
						e.printStackTrace();
				}//write
					
					
					}
				}
				//this.worldObj.createExplosion(entitytntprimed, x, y, z, 4.0F, true);
				}else{keyFirst=true;}
				
				
			
			}
		}
		/**
		 * FIN ULTY
		 */
			}
		
		
		
		
		
		
	}/**/
	 
	

	
	//efect/ulty
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
		 */
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}//end more health
	
		
	
	 
	

}//class
