package jp.phantomking80.fgomod;

import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * FGO Mod
 */
// ここでの値は、META-INF/mods.tomlファイルのエントリと一致させる
@Mod(FgoMod.MOD_ID)
public class FgoMod {

  /** Mod Id */
  public static final String MOD_ID = "fgomod";

  /** log4jロガー */
  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * コンストラクタ
   */
  public FgoMod() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    // modloading用のenqueueIMCメソッドを登録します
    // Register the enqueueIMC method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
    // modloading用のprocessIMCメソッドを登録します
    // Register the processIMC method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    // 興味のあるサーバーやその他のゲームイベントに登録します
    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }

  /**
   * セットアップ
   *
   * @param event イベント
   */
  private void setup(final FMLCommonSetupEvent event) {
    LOGGER.info("PREINIT START");
    LOGGER.info("PREINIT END");
    LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
  }

  /**
   * クライアントでのみ実行する処理
   *
   * @param event イベント
   */
  private void doClientStuff(final FMLClientSetupEvent event) {
    LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
  }

  private void enqueueIMC(final InterModEnqueueEvent event) {
    // some example code to dispatch IMC to another mod
    InterModComms.sendTo("examplemod", "helloworld", () -> {
      LOGGER.info("Hello world from the MDK");
      return "Hello world";
    });
  }

  private void processIMC(final InterModProcessEvent event) {
    // some example code to receive and process InterModComms from other mods
    LOGGER.info("Got IMC {}",
        event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
  }

  /**
   * サーバーの起動時に行う処理
   *
   * @param event イベント
   */
  // SubscribeEventを使用して、EventBusに呼び出すメソッドを検出させることができます
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) {
    LOGGER.info("HELLO from server starting");
  }

  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this
  // is subscribing to the MOD
  // Event bus for receiving Registry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
      // register a new block here
      LOGGER.info("HELLO from Register Block");
    }
  }
}
