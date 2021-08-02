package io.github.farlandercraft.veryconcideas.items.tools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Sword extends SwordItem {
    public Sword(ToolMaterial material) {
        super(material, -1, -2.4f, new Settings().group(ItemGroup.TOOLS));
    }
}
