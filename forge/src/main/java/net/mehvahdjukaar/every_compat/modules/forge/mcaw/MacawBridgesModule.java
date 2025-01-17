package net.mehvahdjukaar.every_compat.modules.forge.mcaw;

import com.mcwbridges.kikoz.MacawsBridges;
import com.mcwbridges.kikoz.init.BlockInit;
import com.mcwbridges.kikoz.objects.Iron_Stair;
import com.mcwbridges.kikoz.objects.Log_Bridge;
import com.mcwbridges.kikoz.objects.Rail_Bridge;
import com.mcwbridges.kikoz.objects.Support_Pillar;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class MacawBridgesModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> bridgePiers;
    public final SimpleEntrySet<WoodType, Block> bridgeMiddles;
    public final SimpleEntrySet<WoodType, Block> ropeBridges;
    public final SimpleEntrySet<WoodType, Block> railBridges;
    public final SimpleEntrySet<WoodType, Block> bridgeStairs;
    public final SimpleEntrySet<WoodType, Block> ropeStairs;

    public MacawBridgesModule(String modId) {
        super(modId, "mcb");

        bridgePiers = SimpleEntrySet.builder(WoodType.class, "bridge_pier",
                        BlockInit.OAK_BRIDGE_PIER, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Support_Pillar(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("wooden_piers"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .defaultRecipe()
                .build();

        this.addEntry(bridgePiers);

        ropeBridges = SimpleEntrySet.builder(WoodType.class, "bridge", "rope",
                        BlockInit.ROPE_OAK_BRIDGE, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Log_Bridge(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("rope_bridges"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .setRenderType(() -> RenderType::cutout)
                .defaultRecipe()
                .build();

        this.addEntry(ropeBridges);

        bridgeMiddles = SimpleEntrySet.builder(WoodType.class, "log_bridge_middle",
                        BlockInit.OAK_LOG_BRIDGE_MIDDLE, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Log_Bridge(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("log_bridges"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .setRenderType(() -> RenderType::cutout)
                .defaultRecipe()
                .build();

        this.addEntry(bridgeMiddles);


        railBridges = SimpleEntrySet.builder(WoodType.class, "rail_bridge",
                        BlockInit.OAK_RAIL_BRIDGE, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Rail_Bridge(Utils.copyPropertySafe(w.planks).noOcclusion()))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("rail_bridges"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .setRenderType(() -> RenderType::cutout)
                .defaultRecipe()
                .build();

        this.addEntry(railBridges);


        bridgeStairs = SimpleEntrySet.builder(WoodType.class, "log_bridge_stair",
                        BlockInit.OAK_LOG_BRIDGE_STAIR, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Iron_Stair(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("log_stairs"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .setRenderType(() -> RenderType::cutout)
                .defaultRecipe()
                .build();

        this.addEntry(bridgeStairs);

        ropeStairs = SimpleEntrySet.builder(WoodType.class, "rope_bridge_stair",
                        BlockInit.OAK_ROPE_BRIDGE_STAIR, () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new Iron_Stair(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registry.BLOCK_REGISTRY)
                .addTag(modRes("rope_stairs"), Registry.BLOCK_REGISTRY)
                .setTab(() -> MacawsBridges.BridgesItemGroup)
                .setRenderType(() -> RenderType::cutout)
                .defaultRecipe()
                .build();

        this.addEntry(ropeStairs);


    }


}
