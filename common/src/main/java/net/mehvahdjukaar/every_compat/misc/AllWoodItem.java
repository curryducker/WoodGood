package net.mehvahdjukaar.every_compat.misc;


import net.mehvahdjukaar.moonlight.api.client.ICustomItemRendererProvider;
import net.mehvahdjukaar.moonlight.api.client.ItemStackRenderer;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class AllWoodItem extends Item implements ICustomItemRendererProvider {

    public AllWoodItem() {
        super(new Properties().tab(null));
    }

    @Override
    public Supplier<ItemStackRenderer> getRendererFactory() {
        return AllWoodItemRenderer::new;
    }
}
