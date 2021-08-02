package io.github.farlandercraft.veryconcideas.items.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterial;

public class Axe extends AxeItem {
    public Axe(ToolMaterial material) {
        super(material, 1, -3.0f, new Item.Settings().group(ItemGroup.TOOLS));
    }
}