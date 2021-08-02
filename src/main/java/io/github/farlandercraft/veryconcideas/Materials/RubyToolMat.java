package io.github.farlandercraft.veryconcideas.Materials;

import io.github.farlandercraft.veryconcideas.Conc;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMat implements ToolMaterial {

    @Override
    public int getDurability() {
        return 1932;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0f;
    }

    @Override
    public float getAttackDamage() {
        return 8f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Conc.Ruby);
    }
}

