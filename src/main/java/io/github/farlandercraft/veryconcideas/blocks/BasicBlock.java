package io.github.farlandercraft.veryconcideas.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;

public class BasicBlock extends Block{
    public BasicBlock(Material material, Tag tag, int miningLevel, BlockSoundGroup sound, int hardness, float resistance) {
        super(FabricBlockSettings.of(material).breakByHand(false).breakByTool(tag, miningLevel).sounds(sound).strength(hardness, resistance));
    }
}
