package net.marcosantos.exnihiloauto.registries;

import net.marcosantos.exnihiloauto.ExNihiloAuto;
import net.marcosantos.exnihiloauto.world.level.block.AutoBlock;
import net.marcosantos.exnihiloauto.world.level.block.CompressedBlock;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoHammerBlockEntity;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoSieveBlockEntity;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoSilkerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExNihiloAuto.MODID);

	public static final DeferredBlock<Block> AUTO_SIEVE =
			BLOCKS.register("auto_sieve", () -> new AutoBlock(AutoSieveBlockEntity::new, modKey("auto_sieve")));
	public static final DeferredBlock<Block> AUTO_HAMMER =
			BLOCKS.register("auto_hammer", () -> new AutoBlock(AutoHammerBlockEntity::new, modKey("auto_hammer")));
	public static final DeferredBlock<Block> AUTO_SILKER =
			BLOCKS.register("auto_silker", () -> new AutoBlock(AutoSilkerBlockEntity::new, modKey("auto_silker")));

	public static final DeferredBlock<CompressedBlock> COMPRESSED_COBBLE =
			BLOCKS.register(
					"compressed_cobble", () -> new CompressedBlock.Cobble(CompressedBlock.Tier.COMPRESSED, modKey("compressed_cobble")));
	public static final DeferredBlock<CompressedBlock> HIGHLY_COMPRESSED_COBBLE =
			BLOCKS.register(
					"highly_compressed_cobble",
					() -> new CompressedBlock.Cobble(CompressedBlock.Tier.HIGHLY_COMPRESSED, modKey("highly_compressed_cobble")));
	public static final DeferredBlock<CompressedBlock> ATOMIC_COMPRESSED_COBBLE =
			BLOCKS.register(
					"atomic_compressed_cobble",
					() -> new CompressedBlock.Cobble(CompressedBlock.Tier.ATOMIC_COMPRESSION, modKey("atomic_compressed_cobble")));

	public static final DeferredBlock<CompressedBlock> COMPRESSED_DUST =
			BLOCKS.register(
					"compressed_dust", () -> new CompressedBlock.Dust(CompressedBlock.Tier.COMPRESSED, modKey("compressed_dust")));
	public static final DeferredBlock<CompressedBlock> HIGHLY_COMPRESSED_DUST =
			BLOCKS.register(
					"highly_compressed_dust",
					() -> new CompressedBlock.Dust(CompressedBlock.Tier.HIGHLY_COMPRESSED, modKey("highly_compressed_dust")));
	public static final DeferredBlock<CompressedBlock> ATOMIC_COMPRESSED_DUST =
			BLOCKS.register(
					"atomic_compressed_dust",
					() -> new CompressedBlock.Dust(CompressedBlock.Tier.ATOMIC_COMPRESSION, modKey("atomic_compressed_dust")));

	public static final DeferredBlock<CompressedBlock> COMPRESSED_GRAVEL =
			BLOCKS.register(
					"compressed_gravel", () -> new CompressedBlock.Gravel(CompressedBlock.Tier.COMPRESSED, modKey("compressed_gravel")));
	public static final DeferredBlock<CompressedBlock> HIGHLY_COMPRESSED_GRAVEL =
			BLOCKS.register(
					"highly_compressed_gravel",
					() -> new CompressedBlock.Gravel(CompressedBlock.Tier.HIGHLY_COMPRESSED, modKey("highly_compressed_gravel")));
	public static final DeferredBlock<CompressedBlock> ATOMIC_COMPRESSED_GRAVEL =
			BLOCKS.register(
					"atomic_compressed_gravel",
					() -> new CompressedBlock.Gravel(CompressedBlock.Tier.ATOMIC_COMPRESSION, modKey("atomic_compressed_gravel")));

	public static final DeferredBlock<CompressedBlock> COMPRESSED_SAND =
			BLOCKS.register(
					"compressed_sand", () -> new CompressedBlock.Sand(CompressedBlock.Tier.COMPRESSED, modKey("compressed_sand")));
	public static final DeferredBlock<CompressedBlock> HIGHLY_COMPRESSED_SAND =
			BLOCKS.register(
					"highly_compressed_sand",
					() -> new CompressedBlock.Sand(CompressedBlock.Tier.HIGHLY_COMPRESSED, modKey("highly_compressed_sand")));
	public static final DeferredBlock<CompressedBlock> ATOMIC_COMPRESSED_SAND =
			BLOCKS.register(
					"atomic_compressed_sand",
					() -> new CompressedBlock.Sand(CompressedBlock.Tier.ATOMIC_COMPRESSION, modKey("atomic_compressed_sand")));

	public static void init(IEventBus bus) {
		BLOCKS.register(bus);
	}

	private static ResourceKey<Block> modKey(String name) {
		return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ExNihiloAuto.MODID, name));
	}
}
