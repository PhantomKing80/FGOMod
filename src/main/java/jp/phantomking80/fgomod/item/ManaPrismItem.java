package jp.phantomking80.fgomod.item;

import net.minecraft.item.Item;

/**
 * ManaPrismの設定
 */
public class ManaPrismItem extends Item {

  /**
   * コンストラクタ
   */
  public ManaPrismItem() {
    // アイテムグループを設定
    super(new Item.Properties().group(ModItemGroup.FGO_GROUP));
    // 登録名を設定
    this.setRegistryName("mana_prism");
  }

}
