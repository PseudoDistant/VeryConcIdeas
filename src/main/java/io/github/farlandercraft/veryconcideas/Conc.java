package io.github.farlandercraft.veryconcideas;

import io.github.farlandercraft.veryconcideas.Materials.*;
import io.github.farlandercraft.veryconcideas.blocks.BasicBlock;
import io.github.farlandercraft.veryconcideas.items.BasicItem;
import io.github.farlandercraft.veryconcideas.items.GlintItem;
import io.github.farlandercraft.veryconcideas.items.armor.Armor;
import io.github.farlandercraft.veryconcideas.items.tools.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class Conc implements ModInitializer {

	/**Items*/
	public static final Item Ruby = new BasicItem(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item NetherStarShard = new GlintItem(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item WitherCharm = new GlintItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(1));
	public static final Item EmeraldApple = new BasicItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(7).alwaysEdible().saturationModifier(7.5f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 9600, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 9600), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600), 1.0f).build()));
	public static final Item WitherApple = new GlintItem(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(20).alwaysEdible().saturationModifier(20.0f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 4800, 4), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 9600, 2), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 9600, 4), 1.0f).build()));

	/**Blocks*/
	public static final Block RubyBlock = new BasicBlock(Material.STONE, FabricToolTags.PICKAXES, 2, BlockSoundGroup.STONE, 6, 7.5f);
	public static final Block RubyOre = new BasicBlock(Material.STONE, FabricToolTags.PICKAXES, 2, BlockSoundGroup.STONE, 5, 6.0f);
	public static final Block RubyOreNether = new BasicBlock(Material.STONE, FabricToolTags.PICKAXES, 2, BlockSoundGroup.NETHER_ORE, 5, 6.0f);

	public static final ToolMaterial RubyTM = new RubyToolMat();
	public static final ToolMaterial ThiccDiamond = new ThiccDiamondToolMat();
	public static final ToolMaterial EmeraldTM = new EmeraldToolMat();
	public static final ArmorMaterial RubyAM = new RubyArmorMat();
	public static final ArmorMaterial EmeraldAM = new EmeraldArmorMat();

	public static final SwordItem RubySword = new Sword(RubyTM);
	public static final SwordItem ThiccDiamondSword = new SwordItem(ThiccDiamond, 3, -3.2F, new Item.Settings().group(ItemGroup.COMBAT));
	public static final SwordItem EmeraldSword = new Sword(EmeraldTM);

	/**Pickaxes*/
	public static final PickaxeItem RubyPickaxe = new Pickaxe(RubyTM);
	//public static final PickaxeItem ThiccDiamondPickaxe = new PickaxeItem(ThiccDiamond, 1, -3.4f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final PickaxeItem EmeraldPickaxe = new Pickaxe(EmeraldTM);

	/**Axes*/
	public static final AxeItem RubyAxe = new Axe(RubyTM);
	//public static final AxeItem ThiccDiamondAxe = new AxeItem(ThiccDiamond, 7, -3.6f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final AxeItem EmeraldAxe = new Axe(EmeraldTM);

	/**Shovels*/
	public static final ShovelItem RubyShovel = new Shovel(RubyTM);
	public static final ShovelItem ThiccDiamondShovel = new ShovelItem(ThiccDiamond, 0, 3.6f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final ShovelItem EmeraldShovel = new Shovel(EmeraldTM);

	/**Hoes*/
	public static final HoeItem RubyHoe = new Hoe(RubyTM);
	//public static final HoeItem ThiccDiamondHoe = new HoeItem(ThiccDiamond, 0, 2f, new Item.Settings().group(ItemGroup.TOOLS));
	public static final HoeItem EmeraldHoe = new Hoe(EmeraldTM);

	/**Features*/
	public static ConfiguredFeature<?, ?> OreRubyOverworld = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, RubyOre.getDefaultState(), 3)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(15)))).spreadHorizontally().repeat(4);
	public static ConfiguredFeature<?, ?> OreRubyNether = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, RubyOreNether.getDefaultState(), 3)).range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(15)))).spreadHorizontally().repeat(4);

	@Override
	public void onInitialize() {

		//Item Register
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby"), Ruby);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_apple"), EmeraldApple);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "wither_apple"), WitherApple);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "nether_star_shard"), NetherStarShard);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "wither_charm"), WitherCharm);

		//Block and Block Item Register
		Registry.register(Registry.BLOCK, new Identifier("veryconcideas", "ruby_block"), RubyBlock);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_block"), new BlockItem(RubyBlock, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("veryconcideas", "ruby_ore"), RubyOre);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_ore"), new BlockItem(RubyOre, new Item.Settings().group(ItemGroup.MISC)));
		Registry.register(Registry.BLOCK, new Identifier("veryconcideas", "ruby_ore_nether"), RubyOreNether);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_ore_nether"), new BlockItem(RubyOreNether, new Item.Settings().group(ItemGroup.MISC)));

		//Tool Register
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_sword"), RubySword);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_pickaxe"), RubyPickaxe);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_axe"), RubyAxe);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_shovel"), RubyShovel);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_hoe"), RubyHoe);

		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_sword"), EmeraldSword);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_pickaxe"), EmeraldPickaxe);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_axe"), EmeraldAxe);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_shovel"), EmeraldShovel);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_hoe"), EmeraldHoe);

		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "thicc_diamond_sword"), ThiccDiamondSword);
		//Registry.register(Registry.ITEM, new Identifier("veryconcideas", "thicc_diamond_pickaxe"), ThiccDiamondPickaxe);
		//Registry.register(Registry.ITEM, new Identifier("veryconcideas", "thicc_diamond_axe"), ThiccDiamondAxe);
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "thicc_diamond_shovel"), ThiccDiamondShovel);
		//Registry.register(Registry.ITEM, new Identifier("veryconcideas", "thicc_diamond_hoe"), ThiccDiamondHoe);

		//Armor Register
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_helmet"), new Armor(RubyAM, EquipmentSlot.HEAD));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_chestplate"), new Armor(RubyAM, EquipmentSlot.CHEST));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_leggings"), new Armor(RubyAM, EquipmentSlot.LEGS));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "ruby_boots"), new Armor(RubyAM, EquipmentSlot.FEET));

		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_helmet"), new Armor(EmeraldAM, EquipmentSlot.HEAD));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_chestplate"), new Armor(EmeraldAM, EquipmentSlot.CHEST));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_leggings"), new Armor(EmeraldAM, EquipmentSlot.LEGS));
		Registry.register(Registry.ITEM, new Identifier("veryconcideas", "emerald_boots"), new Armor(EmeraldAM, EquipmentSlot.FEET));

		//Feature Register
		RegistryKey<ConfiguredFeature<?, ?>> Ore_Ruby_Overworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("veryconcideas", "ore_ruby_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Ore_Ruby_Overworld.getValue(), OreRubyOverworld);
		BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.MESA).and(BiomeSelectors.categories(Biome.Category.OCEAN)), GenerationStep.Feature.UNDERGROUND_ORES, Ore_Ruby_Overworld);
		RegistryKey<ConfiguredFeature<?, ?>> Ore_Ruby_Nether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("veryconcideas", "ore_ruby_nether"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Ore_Ruby_Nether.getValue(), OreRubyNether);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),GenerationStep.Feature.UNDERGROUND_ORES, Ore_Ruby_Nether);
	}

}
