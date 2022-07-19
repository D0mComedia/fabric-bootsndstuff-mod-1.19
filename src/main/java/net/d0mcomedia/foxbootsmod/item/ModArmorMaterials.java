package net.d0mcomedia.foxbootsmod.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial
{
    FOXFUR("foxfur", 6, new int[]{2, 5, 6, 2}, 17,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(ModItems.FOX_FUR)),
    HONEY("honey", 4, new int[]{1, 4, 5, 1}, 0,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> Ingredient.ofItems(Items.HONEY_BLOCK));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}

//  HONEY BOOTS CONCEPT DATA
//
// private void updateSlidingVelocity(Entity entity) {
//        Vec3d vec3d = entity.getVelocity();
//        if (vec3d.y < -0.13) {
//            double d = -0.05 / vec3d.y;
//            entity.setVelocity(new Vec3d(vec3d.x * d, -0.05, vec3d.z * d));
//        } else {
//            entity.setVelocity(new Vec3d(vec3d.x, -0.05, vec3d.z));
//        }
//        entity.onLanding();
//    }
//
//            if (world.random.nextInt(5) == 0) {
//                entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0f, 1.0f);
//            }
//            }
//        }
//    }
//
//    public static void addRegularParticles(Entity entity) {
//        HoneyBlock.addParticles(entity, 5);
//    }
//
//    public static void addRichParticles(Entity entity) {
//        HoneyBlock.addParticles(entity, 10);
//    }
//
//    private static void addParticles(Entity entity, int count) {
//        if (!entity.world.isClient) {
//            return;
//        }
//
//
//
// HONEY(name:"honey", durabilityMultiplier:6, new int[]{1, 5, 6, 2}, enchantabilty:17,
//        SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, toughness:0.0f, knockbackResistance:0.0f, () -> Ingredient.ofItems(Items.HONEY_BLOCK))

