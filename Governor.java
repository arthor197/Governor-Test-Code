package Governor.Governor; //Package directory

/*
* Basic importing
*/



import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/*
* Basic needed forge stuff
*/
@Mod(modid="Governor",name="Governor Mod",version="V1.0")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)



public class Governor {

/*
* ToolMaterial
*/
	static EnumToolMaterial EnumToolMaterialfire_gem= EnumHelper.addToolMaterial("LowPower", 2, 1800, 18.0F, 3, 15);	
//Telling forge that we are creating these


public static Item fire_gem;
//Tools
public static Item FireAxe;
public static Item FireShovel;
public static Item FireSword;
public static Item FirePickaxe;
public static Item FireHoe;
//Blocks
public static Block fireblock;
public static Block fireore;
@Init
public void load(FMLInitializationEvent event){
// define items/blocks
	fireblock= new FireBlock(3608, "fireblock").setUnlocalizedName("fireblock").setHardness(5.0F).setStepSound(Block.soundMetalFootstep).setResistance(10.0F);
	GameRegistry.registerBlock(fireblock, "fireblock");
	LanguageRegistry.addName(fireblock, "Fire Block");
	//Ore
	fireore= new FireOre(3609, "fireore").setUnlocalizedName("fireore").setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setResistance(5.0F);
	GameRegistry.registerBlock(fireore, "fireore");
	LanguageRegistry.addName(fireore, "Fire Ore");
	
//tools
FireAxe = new FireAxe(2503, EnumToolMaterialfire_gem).setUnlocalizedName("fireaxe");
FireShovel = new FireShovel(2504, EnumToolMaterialfire_gem).setUnlocalizedName("fireshovel");
FirePickaxe = new FirePickaxe(2505, EnumToolMaterialfire_gem).setUnlocalizedName("firepick");
FireHoe = new FireHoe(2506, EnumToolMaterialfire_gem).setUnlocalizedName("firehoe");
FireSword = new FireSword(2507, EnumToolMaterialfire_gem).setUnlocalizedName("firesword");

fire_gem = new GemItems(2013).setUnlocalizedName("fire_gem");


//adding names


LanguageRegistry.addName(fire_gem, "Fire Gem");
LanguageRegistry.addName(FireAxe, "Fire Axe");
LanguageRegistry.addName(FireShovel, "Fire Shovel");
LanguageRegistry.addName(FirePickaxe, "Fire Pickaxe");
LanguageRegistry.addName(FireHoe, "Fire Hoe");
LanguageRegistry.addName(FireSword, "Fire Sword");


//crafting
GameRegistry.addRecipe(new ItemStack(FireAxe,1), new Object[]{
"FF ","FS "," S ",'F',fire_gem,'S',Item.stick,
});
GameRegistry.addRecipe(new ItemStack(FireShovel,1), new Object[]{
" F "," S "," S ",'F',fire_gem,'S',Item.stick,
});
GameRegistry.addRecipe(new ItemStack(FirePickaxe,1), new Object[]{
"FFF"," S "," S ",'F',fire_gem,'S',Item.stick,
});
GameRegistry.addRecipe(new ItemStack(FireHoe,1), new Object[]{
"FF "," S "," S ",'F',fire_gem,'S',Item.stick,
});
GameRegistry.addRecipe(new ItemStack(FireSword,1), new Object[]{
" F "," F "," S ",'F',fire_gem,'S',Item.stick
});
GameRegistry.addRecipe(new ItemStack(fireblock,1), new Object[]{
"FFF","FFF","FFF",'F',fire_gem,
});
//World Gen
GameRegistry.registerWorldGenerator(new WorldGeneratorFireOre());
}
}