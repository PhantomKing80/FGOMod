package jp.phantomking80.fgomod.handler;

import jp.phantomking80.fgomod.FgoMod;
import jp.phantomking80.fgomod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FgoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LivingDropsEventHandler {

  @SubscribeEvent
  public static void entityDropsItemAdd(LivingDropsEvent event) {
    LivingEntity livingEntity = event.getEntityLiving();

    // 全EntityにQPドロップを追加 確定1個？
    livingEntity.entityDropItem(ModItems.QUANTUM_PIECE);
  }

}
