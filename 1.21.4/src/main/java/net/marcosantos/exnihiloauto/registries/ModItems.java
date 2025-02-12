package net.marcosantos.exnihiloauto.registries;

import net.marcosantos.exnihiloauto.ExNihiloAuto;
import net.marcosantos.exnihiloauto.world.item.UpgradeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExNihiloAuto.MODID);

	public static final DeferredItem<BlockItem> AUTO_SIEVE = ITEMS.register("auto_sieve",
			() -> new BlockItem(ModBlocks.AUTO_SIEVE.get(), new Item.Properties().setId(modKey("auto_sieve"))));

	public static final DeferredItem<BlockItem> AUTO_HAMMER = ITEMS.register("auto_hammer",
			() -> new BlockItem(ModBlocks.AUTO_HAMMER.get(), new Item.Properties().setId(modKey("auto_hammer"))));

	public static final DeferredItem<BlockItem> AUTO_SILKER = ITEMS.register("auto_silker",
			() -> new BlockItem(ModBlocks.AUTO_SILKER.get(), new Item.Properties().setId(modKey("auto_silker"))));

	public static final DeferredItem<BlockItem> COMPRESSED_COBBLE = ITEMS.register("compressed_cobble", () -> new BlockItem(ModBlocks.COMPRESSED_COBBLE.get(), new Item.Properties().stacksTo(64).setId(modKey("compressed_cobble"))));
	public static final DeferredItem<BlockItem> HIGHLY_COMPRESSED_COBBLE = ITEMS.register("highly_compressed_cobble", () -> new BlockItem(ModBlocks.HIGHLY_COMPRESSED_COBBLE.get(), new Item.Properties().stacksTo(64).setId(modKey("highly_compressed_cobble"))));
	public static final DeferredItem<BlockItem> ATOMIC_COMPRESSED_COBBLE = ITEMS.register("atomic_compressed_cobble", () -> new BlockItem(ModBlocks.ATOMIC_COMPRESSED_COBBLE.get(), new Item.Properties().stacksTo(64).setId(modKey("atomic_compressed_cobble"))));

	public static final DeferredItem<BlockItem> COMPRESSED_DUST = ITEMS.register("compressed_dust", () -> new BlockItem(ModBlocks.COMPRESSED_DUST.get(), new Item.Properties().stacksTo(64).setId(modKey("compressed_dust"))));
	public static final DeferredItem<BlockItem> HIGHLY_COMPRESSED_DUST = ITEMS.register("highly_compressed_dust", () -> new BlockItem(ModBlocks.HIGHLY_COMPRESSED_DUST.get(), new Item.Properties().stacksTo(64).setId(modKey("highly_compressed_dust"))));
	public static final DeferredItem<BlockItem> ATOMIC_COMPRESSED_DUST = ITEMS.register("atomic_compressed_dust", () -> new BlockItem(ModBlocks.ATOMIC_COMPRESSED_DUST.get(), new Item.Properties().stacksTo(64).setId(modKey("atomic_compressed_dust"))));

	public static final DeferredItem<BlockItem> COMPRESSED_GRAVEL = ITEMS.register("compressed_gravel", () -> new BlockItem(ModBlocks.COMPRESSED_GRAVEL.get(), new Item.Properties().stacksTo(64).setId(modKey("compressed_gravel"))));
	public static final DeferredItem<BlockItem> HIGHLY_COMPRESSED_GRAVEL = ITEMS.register("highly_compressed_gravel", () -> new BlockItem(ModBlocks.HIGHLY_COMPRESSED_GRAVEL.get(), new Item.Properties().stacksTo(64).setId(modKey("highly_compressed_gravel"))));
	public static final DeferredItem<BlockItem> ATOMIC_COMPRESSED_GRAVEL = ITEMS.register("atomic_compressed_gravel", () -> new BlockItem(ModBlocks.ATOMIC_COMPRESSED_GRAVEL.get(), new Item.Properties().stacksTo(64).setId(modKey("atomic_compressed_gravel"))));

	public static final DeferredItem<BlockItem> COMPRESSED_SAND = ITEMS.register("compressed_sand", () -> new BlockItem(ModBlocks.COMPRESSED_SAND.get(), new Item.Properties().stacksTo(64).setId(modKey("compressed_sand"))));
	public static final DeferredItem<BlockItem> HIGHLY_COMPRESSED_SAND = ITEMS.register("highly_compressed_sand", () -> new BlockItem(ModBlocks.HIGHLY_COMPRESSED_SAND.get(), new Item.Properties().stacksTo(64).setId(modKey("highly_compressed_sand"))));
	public static final DeferredItem<BlockItem> ATOMIC_COMPRESSED_SAND = ITEMS.register("atomic_compressed_sand", () -> new BlockItem(ModBlocks.ATOMIC_COMPRESSED_SAND.get(), new Item.Properties().stacksTo(64).setId(modKey("atomic_compressed_sand"))));

	public static final DeferredItem<Item> REINFORCED_UPGRADE = ITEMS.register("reinforcement_upgrade", () -> new UpgradeItem.Reinforcement(modKey("reinforcement_upgrade")));
	public static final DeferredItem<Item> SPEED_UPGRADE = ITEMS.register("speed_upgrade", () -> new UpgradeItem.Speed(modKey("speed_upgrade")));
	public static final DeferredItem<Item> BONUS_UPGRADE = ITEMS.register("bonus_upgrade", () -> new UpgradeItem.BonusDrop(modKey("bonus_upgrade")));

	public static void init(IEventBus bus) {
		ITEMS.register(bus);
	}

	private static ResourceKey<Item> modKey(String name) {
		return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ExNihiloAuto.MODID, name));
	}
}
