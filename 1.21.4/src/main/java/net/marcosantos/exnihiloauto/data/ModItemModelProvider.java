package net.marcosantos.exnihiloauto.data;

import net.marcosantos.exnihiloauto.ExNihiloAuto;
import net.marcosantos.exnihiloauto.registries.ModBlocks;
import net.marcosantos.exnihiloauto.registries.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ModelProvider {

	public ModItemModelProvider(PackOutput output) {
		super(output, ExNihiloAuto.MODID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		createAutoBlock(blockModels, ModBlocks.AUTO_SIEVE);
		createAutoBlock(blockModels, ModBlocks.AUTO_SILKER);
		createAutoBlock(blockModels, ModBlocks.AUTO_HAMMER);
		itemModels.itemModelOutput.accept(ModItems.REINFORCED_UPGRADE.get(), ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.REINFORCED_UPGRADE.get(), ModelTemplates.FLAT_ITEM)));
		itemModels.itemModelOutput.accept(ModItems.SPEED_UPGRADE.get(), ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.SPEED_UPGRADE.get(), ModelTemplates.FLAT_ITEM)));
		itemModels.itemModelOutput.accept(ModItems.BONUS_UPGRADE.get(), ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.BONUS_UPGRADE.get(), ModelTemplates.FLAT_ITEM)));
		registerCompressedModels(blockModels);
	}

	private void createAutoBlock(BlockModelGenerators blockModels, DeferredBlock<Block> block) {
		TextureMapping mapping = new TextureMapping();
		mapping.put(TextureSlot.SIDE, modLocation("block/auto_side"));
		mapping.put(TextureSlot.TOP, modLocation("block/auto_top"));
		mapping.put(TextureSlot.UP, modLocation("block/auto_top"));
		mapping.put(TextureSlot.BOTTOM, modLocation("block/auto_bottom"));
		mapping.put(TextureSlot.DOWN, modLocation("block/auto_bottom"));
		mapping.put(TextureSlot.PARTICLE, mcLocation("block/stone"));
		blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block.get(), ModelTemplates.CUBE.create(block.get(), mapping, blockModels.modelOutput)));
	}

	private void registerCompressedModels(BlockModelGenerators blockModels) {
		blockModels.createTrivialCube(ModBlocks.COMPRESSED_COBBLE.get());
		blockModels.createTrivialCube(ModBlocks.HIGHLY_COMPRESSED_COBBLE.get());
		blockModels.createTrivialCube(ModBlocks.ATOMIC_COMPRESSED_COBBLE.get());
		blockModels.createTrivialCube(ModBlocks.COMPRESSED_GRAVEL.get());
		blockModels.createTrivialCube(ModBlocks.HIGHLY_COMPRESSED_GRAVEL.get());
		blockModels.createTrivialCube(ModBlocks.ATOMIC_COMPRESSED_GRAVEL.get());
		blockModels.createTrivialCube(ModBlocks.COMPRESSED_SAND.get());
		blockModels.createTrivialCube(ModBlocks.HIGHLY_COMPRESSED_SAND.get());
		blockModels.createTrivialCube(ModBlocks.ATOMIC_COMPRESSED_SAND.get());
		blockModels.createTrivialCube(ModBlocks.COMPRESSED_DUST.get());
		blockModels.createTrivialCube(ModBlocks.HIGHLY_COMPRESSED_DUST.get());
		blockModels.createTrivialCube(ModBlocks.ATOMIC_COMPRESSED_DUST.get());
	}
}
