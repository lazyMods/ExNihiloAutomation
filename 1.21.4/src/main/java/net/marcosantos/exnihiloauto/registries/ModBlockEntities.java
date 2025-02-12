package net.marcosantos.exnihiloauto.registries;

import net.marcosantos.exnihiloauto.ExNihiloAuto;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoHammerBlockEntity;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoSieveBlockEntity;
import net.marcosantos.exnihiloauto.world.level.block.entity.AutoSilkerBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ExNihiloAuto.MODID);

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AutoSieveBlockEntity>> AUTO_SIEVE =
			BLOCK_ENTITIES.register(
					"auto_sieve",
					() -> new BlockEntityType<>(AutoSieveBlockEntity::new, ModBlocks.AUTO_SIEVE.get()));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AutoHammerBlockEntity>> AUTO_HAMMER =
			BLOCK_ENTITIES.register(
					"auto_hammer",
					() -> new BlockEntityType<>(AutoHammerBlockEntity::new, ModBlocks.AUTO_HAMMER.get()));

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AutoSilkerBlockEntity>> AUTO_SILKER =
			BLOCK_ENTITIES.register(
					"auto_silker",
					() -> new BlockEntityType<>(AutoSilkerBlockEntity::new, ModBlocks.AUTO_SILKER.get()));

	public static void init(IEventBus modEventBus) {
		BLOCK_ENTITIES.register(modEventBus);
	}
}
