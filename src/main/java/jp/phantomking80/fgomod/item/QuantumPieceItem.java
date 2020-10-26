package jp.phantomking80.fgomod.item;

import java.util.List;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

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

  /**
   * 固有情報の設定
   */
  @Override
  public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
      ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);

    // Ctrl押下判定 : func_231172_r_()
    // Shift押下判定 : func_231173_s_()
    // Alt押下判定 : func_231174_t_()

    if (Screen.func_231173_s_()) {
      // Shift押下時
      // \u00A7e : 黄色
      tooltip.add(new StringTextComponent("\u00A7e いわゆるQPとかいうやつ"));
    } else {
      // デフォルト表示
      tooltip.add(new StringTextComponent(" Shiftでコメント表示"));
    }
  }
}
