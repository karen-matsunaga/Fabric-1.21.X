package net.karen.hyla.mixin;

import net.karen.hyla.component.ModDataComponentTypes;
import net.karen.hyla.component.custom.Coordinates;
import net.karen.hyla.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.ArrayList;
import java.util.List;
import static net.karen.hyla.item.custom.ChiselItem.*;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(method = "getTooltip", at = @At("RETURN"), cancellable = true)
    private void newTooltip(Item.TooltipContext context, PlayerEntity player,
                            TooltipType type, CallbackInfoReturnable<List<Text>> cir) {
        ItemStack stack = (ItemStack) (Object) this;
        List<Text> text = new ArrayList<>(cir.getReturnValue());
        if (stack.isOf(ModItems.CHISEL)) {
            Coordinates coordinates = stack.get(ModDataComponentTypes.COORDINATES);
            if (coordinates != null) {
                text.add(Text.translatable(coordinates.description()).withColor(chiselLoreColor));
            }
        }
        cir.setReturnValue(text);
    }
}