package jp.phantomking80.fgomod.item;

import net.minecraft.item.Item;

/**
 * QuantumPieceの設定
 */
public class QuantumPieceItem extends Item {

  /**
   * コンストラクタ
   */
  public QuantumPieceItem() {
    // アイテムグループを設定
    super(new Item.Properties().group(ModItemGroup.FGO_GROUP));
    // 登録名を設定
    this.setRegistryName("quantum_piece");
  }

  // 説明を入れたいときに使う
  // Shiftを押したときのコメントとか
  // @Override
  // public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
  // ITooltipFlag flagIn) {
  // super.addInformation(stack, worldIn, tooltip, flagIn);
  // }
}
