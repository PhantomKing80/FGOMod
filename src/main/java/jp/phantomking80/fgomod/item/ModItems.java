package jp.phantomking80.fgomod.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * アイテム全般の宣言・登録<br>
 * 宣言と登録を想定しているためEventBusSubscriberのアノテーションをつける
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

  /** QP */
  public static final Item QUANTUM_PIECE = new QuantumPieceItem();

  /** マナプリズム */
  public static final Item MANA_PRISM = new ManaPrismItem();

  /** レアプリズム */
  public static final Item RARE_PRISM = new RarePrismItem();

  /**
   * アイテムの登録
   *
   * @param itemRegistryEvent
   */
  @SubscribeEvent
  public static void registerItems(final RegistryEvent.Register<Item> itemRegistryEvent) {

    // 登録アイテムを「,」で羅列する
    itemRegistryEvent.getRegistry().registerAll(QUANTUM_PIECE, MANA_PRISM, RARE_PRISM);
  }
}
