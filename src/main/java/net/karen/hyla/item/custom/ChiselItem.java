package net.karen.hyla.item.custom;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.karen.hyla.component.ModDataComponentTypes;
import net.karen.hyla.component.custom.Coordinates;
import net.karen.hyla.particle.ModParticles;
import net.karen.hyla.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.World;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(Blocks.STONE, Blocks.STONE_BRICKS, Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                   Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS, Blocks.NETHERRACK, Blocks.NETHER_BRICKS);

    public static int chiselLoreColor = ColorHelper.getArgb(241, 131, 8);
    public static int blueBedrockColor = ColorHelper.getArgb(33, 73, 123);
    public static int redBedrockColor = ColorHelper.getArgb(151, 22, 7);

    public ChiselItem(Settings settings) { super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos clickedPos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(clickedPos).getBlock();
        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!world.isClient() && world instanceof ServerWorld serverWorld) {
                PlayerEntity player = context.getPlayer();
                ItemStack itemHand = context.getStack();
                world.setBlockState(clickedPos, CHISEL_MAP.get(clickedBlock).getDefaultState());
                itemHand.damage(1, serverWorld, (ServerPlayerEntity) player, item -> {
                    if (player != null) { player.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND); }
                });
                world.playSound(null, clickedPos, ModSounds.CHISEL_USE, SoundCategory.BLOCKS);
                int x = clickedPos.getX();
                int y = clickedPos.getY();
                int z = clickedPos.getZ();
                serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK,
                                                                        clickedBlock.getDefaultState()),
                                           x + 0.5, y + 1.0, z + 0.5, 5,
                                           0, 0, 0, 1);
                serverWorld.spawnParticles(ParticleTypes.DOLPHIN,
                                           x + 0.5, y + 1.5, z + 0.5, 5,
                                           0, 0, 0, 3);
                serverWorld.spawnParticles(ModParticles.BISMUTH_PARTICLES,
                                           x + 0.5, y + 1.0, z + 0.5, 5,
                                           0, 0, 0, 3);
                itemHand.set(ModDataComponentTypes.COORDINATES, new Coordinates(clickedPos));
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(this.getTranslationKey()).withColor(chiselLoreColor);
    }

    // CUSTOM METHOD - CHISEL shift description
//    public String chiselShiftDescription() {
//        if (MinecraftClient.Input) { return "tooltip.item.hyla.chisel.shift"; }
//        else { return "tooltip.item.hyla.chisel"; }
//    }
}