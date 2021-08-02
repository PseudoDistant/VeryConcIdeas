package io.github.farlandercraft.veryconcideas.items.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class Hoe extends HoeItem {
    public Hoe(ToolMaterial material) {
        super(material, -7, 0.0f, new Settings().group(ItemGroup.TOOLS));
    }
}