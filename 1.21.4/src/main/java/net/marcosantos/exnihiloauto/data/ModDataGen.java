package net.marcosantos.exnihiloauto.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import novamachina.novacore.data.loot.LootProvider;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ModDataGen {

	public static class ModLootProvider extends LootProvider {
		protected ModLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
			super(output, List.of(new SubProviderEntry(ModBlockLootProvider::new, LootContextParamSets.BLOCK)), provider);
		}
	}

	@SubscribeEvent
	static void gatherData(GatherDataEvent.Client event) {
		var generator = event.getGenerator();
		var pack = generator.getPackOutput();

		event.addProvider(new ModLanguageProvider(pack));
		event.addProvider(new ModItemModelProvider(pack));

		var lookup = event.getLookupProvider();

		event.addProvider(new ModTags(pack, lookup));
		event.createProvider(ModRecipeProvider.Runner::new);
		event.addProvider(new ModLootProvider(pack, lookup));
	}
}
