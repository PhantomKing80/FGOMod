package jp.phantomking80.fgomod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * MOD用アイテムグループの設定
 *
 */
public class ModItemGroup extends ItemGroup {

  /** FGO Mod用アイテムグループ */
  public static final ItemGroup FGO_GROUP = new ModItemGroup();


  /**
   * グループ名を設定
   */
  public ModItemGroup() {
    super("fgomod");

  }

  /**
   * アイコンの設定
   */
  @Override
  public ItemStack createIcon() {
    return new ItemStack(ModItems.QUANTUM_PIECE);
  }

}
