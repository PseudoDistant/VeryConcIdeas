package io.github.farlandercraft.veryconcideas.items;

import io.github.farlandercraft.veryconcideas.Conc;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.explosion.Explosion;

public class GlintItem extends Item {



    public GlintItem(Settings item$Settings_1) { super(item$Settings_1); }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    @Override
    public Rarity getRarity(ItemStack stack) { return Rarity.EPIC; }
    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        DamageSource damageSource = DamageSource.ANVIL;
        if (entity.getStack().getItem() == Conc.WitherCharm && entity.wasOnFire) {
            CreeperEntity AwMan = new CreeperEntity(EntityType.CREEPER, entity.getEntityWorld());
            LightningEntity Boom = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getEntityWorld());
            LightningEntity Boom1 = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getEntityWorld());
            LightningEntity Boom2 = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getEntityWorld());
            LightningEntity Boom3 = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getEntityWorld());

            entity.setPos(entity.getPos().x, entity.getY(), entity.getZ());
            entity.getEntityWorld().spawnEntity(AwMan);
            entity.getEntityWorld().spawnEntity(Boom);
            entity.getEntityWorld().spawnEntity(Boom1);
            entity.getEntityWorld().spawnEntity(Boom2);
            entity.getEntityWorld().spawnEntity(Boom3);

            AwMan.setPos(entity.getX(), entity.getY(), entity.getZ());
            Boom.setPos(entity.getX() - 10, entity.getY(), entity.getZ());
            Boom1.setPos(entity.getX(), entity.getY(), entity.getZ() - 10);
            Boom2.setPos(entity.getX() + 10, entity.getY(), entity.getZ());
            Boom3.setPos(entity.getX(), entity.getY(), entity.getZ() + 10);

            System.out.println(entity.getPos());
            System.out.println("Test");
            //System.out.println(entity.);

        } else {
            System.out.println("hi");
        }
    }
}
