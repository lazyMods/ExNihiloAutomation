package net.marcosantos.exnihiloauto.world.level.block;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CompressedBlock extends Block {

	public enum Tier {
		COMPRESSED(9, "Compressed", null),
		HIGHLY_COMPRESSED(81, "Highly Compressed", COMPRESSED),
		ATOMIC_COMPRESSION(729, "Atomic Compressed", HIGHLY_COMPRESSED);

		public final int amt;
		public final String name;
		public @Nullable final Tier below;

		Tier(int amt, String name, @Nullable Tier below) {
			this.amt = amt;
			this.name = name;
			this.below = below;
		}
	}

	public final Tier tier;

	public CompressedBlock(Properties props, Tier tier, ResourceKey<Block> id) {
		super(props.requiresCorrectToolForDrops().setId(id));
		this.tier = tier;
	}

	public static class Cobble extends CompressedBlock {
		public Cobble(Tier tier, ResourceKey<Block> id) {
			super(Properties.ofFullCopy(Blocks.COBBLESTONE), tier, id);
		}

		@Override
		@ParametersAreNonnullByDefault
		public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
			var to_display = String.format("Contains %s of %s", tier.amt, Component.translatable("compressed.cobblestone").getString());
			tooltipComponents.add(Component.literal(to_display));
			super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		}
	}

	public static class Dust extends CompressedBlock {
		public Dust(Tier tier, ResourceKey<Block> id) {
			super(Properties.ofFullCopy(Blocks.SAND).sound(SoundType.WOOL).strength(.7f), tier, id);
		}

		@Override
		@ParametersAreNonnullByDefault
		public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
			var to_display = String.format("Contains %s of %s", tier.amt, Component.translatable("compressed.dust").getString());
			tooltipComponents.add(Component.literal(to_display));
			super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		}
	}

	public static class Gravel extends CompressedBlock {
		public Gravel(Tier tier, ResourceKey<Block> id) {
			super(Properties.ofFullCopy(Blocks.GRAVEL), tier, id);
		}

		@Override
		@ParametersAreNonnullByDefault
		public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
			var to_display = String.format("Contains %s of %s", tier.amt, Component.translatable("compressed.gravel").getString());
			tooltipComponents.add(Component.literal(to_display));
			super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		}
	}

	public static class Sand extends CompressedBlock {
		public Sand(Tier tier, ResourceKey<Block> id) {
			super(Properties.ofFullCopy(Blocks.SAND), tier, id);
		}

		@Override
		@ParametersAreNonnullByDefault
		public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
			var to_display = String.format("Contains %s of %s", tier.amt, Component.translatable("compressed.sand").getString());
			tooltipComponents.add(Component.literal(to_display));
			super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		}
	}
}
