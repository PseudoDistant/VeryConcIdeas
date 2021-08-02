package io.github.farlandercraft.veryconcideas.items.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class Shovel extends ShovelItem {
    public Shovel(ToolMaterial material) {
        super(material, -4, -3.0f, new Settings().group(ItemGroup.TOOLS));
    }
}