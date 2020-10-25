package jp.phantomking80.fgomod.handler;

import jp.phantomking80.fgomod.FgoMod;
import jp.phantomking80.fgomod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * LivingDropsEvent用Handler
 */
@Mod.EventBusSubscriber(modid = FgoMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LivingDropsEventHandler {

  /**
   * Entityを倒したときのドロップアイテム追加
   *
   * @param event イベント
   */
  @SubscribeEvent
  public static void entityDropsItemAdd(LivingDropsEvent event) {
    LivingEntity livingEntity = event.getEntityLiving();

    // TODO ドロップ確率を今後修正
    // 全EntityにQPドロップを追加 確定1個？
    livingEntity.entityDropItem(ModItems.QUANTUM_PIECE);
  }

}
