package net.jquesada.loudernoteblocks.mixin;

import net.minecraft.block.NoteBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {

    @ModifyArg(
            method = "onSyncedBlockEvent",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/sound/SoundCategory;FFJ)V"
            ),
            index = 6
    )
    private float volumeAmplify(float vol) {
        return 5.0f;
    }
}
