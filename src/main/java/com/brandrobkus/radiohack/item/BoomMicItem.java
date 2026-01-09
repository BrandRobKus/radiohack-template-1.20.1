package com.brandrobkus.radiohack.item;

import com.brandrobkus.radiohack.RadioHack;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import java.util.List;

public class BoomMicItem extends SwordItem {

    public BoomMicItem(ToolMaterial material, Item.Settings settings) {
        super(material, settings.attributeModifiers(new AttributeModifiersComponent(
                List.of(
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.0f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND),
                        new AttributeModifiersComponent.Entry(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -2.9f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND)
                )
        , false)));

    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        if (!world.isClient) {
            world.playSound(null, target.getBlockPos(),
                    RadioHack.MICROPHONE_HIT, SoundCategory.PLAYERS, 0.8F, 1.0F);
        }
        return super.postHit(stack, target, attacker);
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }
}
