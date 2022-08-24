package net.mehvahdjukaar.every_compat.forge;

import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.EveryCompatClient;
import net.mehvahdjukaar.every_compat.modules.another_furniture.AnotherFurnitureModule;
import net.mehvahdjukaar.every_compat.modules.backpacked.BackpackedModule;
import net.mehvahdjukaar.every_compat.modules.camp_chair.CampChairModule;
import net.mehvahdjukaar.every_compat.modules.mcaw.*;
import net.mehvahdjukaar.every_compat.modules.missing_wilds.MissingWildModule;
import net.mehvahdjukaar.every_compat.modules.mrcrayfish_furniture.MrCrayfishFurnitureModule;
import net.mehvahdjukaar.every_compat.modules.quark.QuarkModule;
import net.mehvahdjukaar.moonlight.api.platform.PlatformHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;

/**
 * Author: MehVahdJukaar
 */
@Mod(EveryCompat.MOD_ID)
public class EveryCompatForge extends EveryCompat {
    public static final String MOD_ID = EveryCompat.MOD_ID;

    public EveryCompatForge() {
        this.commonInit();

        // MinecraftForge.EVENT_BUS.addListener(CustomRecipeLoader::onEarlyPackLoad);
        // MinecraftForge.EVENT_BUS.register(EntriesRemapper.class);
        CraftingHelper.register(new BlockTypeEnabledCondition.Serializer());


        addModule("mcwdoors", () -> MacawDoorsModule::new);
        addModule("mcwlights", () -> MacawLightsModule::new);
        addModule("mcwpaths", () -> MacawPathsModule::new);
        addModule("mcwtrpdoors", () -> MacawTrapdoorsModule::new);
        addModule("mcwwindows", () -> MacawWindowsModule::new);
        addModule("mcwfences", () -> MacawFencesModule::new);
        addModule("mcwbridges", () -> MacawBridgesModule::new);


        addModule("another_furniture", () -> AnotherFurnitureModule::new);
        addModule("missingwilds", () -> MissingWildModule::new);

        addModule("campchair", () -> CampChairModule::new);
        addModule("cfm", () -> MrCrayfishFurnitureModule::new);
        addModule("backpacked", () -> BackpackedModule::new);
        addModule("quark", () -> QuarkModule::new);


        if(PlatformHelper.getEnv().isClient()){
            EveryCompatClient.commonInit();
        }

        FMLJavaModLoadingContext.get().getModEventBus().register(this);

    }

    @SubscribeEvent
    public void onRegister(RegisterEvent event) {
        var key = event.getRegistryKey();
        if (key == Registry.ITEM_REGISTRY) {
            this.registerItems((ResourceLocation a, Item b) -> event.getForgeRegistry().register(a, b));
        } else if (key == Registry.BLOCK_ENTITY_TYPE_REGISTRY) {
            this.registerTiles((ResourceLocation a, BlockEntityType<?> b) -> event.getForgeRegistry().register(a, b));
        } else if (key == Registry.ENTITY_TYPE_REGISTRY) {
            this.registerEntities((ResourceLocation a, EntityType<?> b) -> event.getForgeRegistry().register(a, b));
        }
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event){
        this.commonSetup();
    }


}