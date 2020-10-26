package jp.phantomking80.fgomod.item;

import net.minecraft.item.Item;

/**
 * RarePrismの設定
 */
public class RarePrismItem extends Item {

  /**
   * コンストラクタ
   */
  public RarePrismItem() {
    // アイテムグループを設定
    super(new Item.Properties().group(ModItemGroup.FGO_GROUP));
    // 登録名を設定
    this.setRegistryName("rare_prism");
  }

}
