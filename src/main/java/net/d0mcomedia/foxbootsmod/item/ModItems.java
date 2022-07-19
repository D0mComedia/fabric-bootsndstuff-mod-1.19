package net.d0mcomedia.foxbootsmod.item;

import net.d0mcomedia.foxbootsmod.foxbootsmod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModItems {

    public static final Item FOX_BOOTS = registerItem("fox_boots",
         new ArmorItem(ModArmorMaterials.FOXFUR, EquipmentSlot.FEET,
            new FabricItemSettings().group(ModItemGroup.FUR)));
    //item with the problem
    public static final Item HONEY_BOOTS = registerItem("honey_boots",
            new ArmorItem(ModArmorMaterials.HONEY, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.FUR)));
    public static final Item FOX_FUR = registerItem("fox_fur",
            new Item(new FabricItemSettings().group(ModItemGroup.FUR)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(foxbootsmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        foxbootsmod.LOGGER.info("Registering Mod Items for " + foxbootsmod.MOD_ID);
    }
    //problem in question
    public class honey_boots extends ArmorItem {

        public honey_boots(Settings settings) {
            super(
                    // armor material
                    ModArmorMaterials.HONEY,
                    // feet slot
                    EquipmentSlot.FEET,
                    settings
            );
        }

        @Override
        public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
            // if equipped on feet
            if (slot == EquipmentSlot.FEET.getEntitySlotId()) {

                // velocity updating on every tick

                Vec3d velocity = entity.getVelocity();

                //         immobility to jump like honey block
                entity.setVelocity(velocity.x, -0.3, velocity.z);

                //         increasing entity(player) velocity on tick
                //         be careful, big values cause infinite speed increasing
                entity.addVelocity(0.1 * velocity.x, 0, 0.1 * velocity.z);


                // ... only your creativity
            }
        }
    }
  }
