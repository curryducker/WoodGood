package net.mehvahdjukaar.every_compat.modules.forge.lauchs;

import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.init.BlockInit;


public class LauchsShuttersModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> shutters;

    public LauchsShuttersModule(String modId) {
        super(modId, "ls");
        CreativeModeTab tab = ShutterMain.SHUTTER_TAB;

        shutters = SimpleEntrySet.builder(WoodType.class, "shutter",
                        BlockInit.OAK_SHUTTER, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Shutter(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTextureM(modRes("block/oak_shutter_lower"), EveryCompat.res("block/ls/oak_shutter_lower_m"))
                .addTextureM(modRes("block/oak_shutter_normal"), EveryCompat.res("block/ls/oak_shutter_normal_m"))
                .addTextureM(modRes("block/oak_shutter_upper"), EveryCompat.res("block/ls/oak_shutter_upper_m"))
                .addTexture(modRes("block/oak_shutter_middle"))
                .addTexture(modRes("item/oak_shutter"))
                .setRenderType(() -> RenderType::cutout)
                .setTab(() -> tab)
                .defaultRecipe()
                .build();

        this.addEntry(shutters);
    }
}
