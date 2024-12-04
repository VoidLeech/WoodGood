package net.mehvahdjukaar.every_compat.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.mehvahdjukaar.every_compat.EveryCompat;
import net.mehvahdjukaar.every_compat.EveryCompatClient;
import net.mehvahdjukaar.every_compat.api.CompatModule;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.mehvahdjukaar.every_compat.modules.fabric.beautify_decorate.BeautifyRefabricatedModule;
import net.mehvahdjukaar.every_compat.modules.fabric.bewitchment.BewitchmentModule;
import net.mehvahdjukaar.every_compat.modules.fabric.clutter.ClutterModule;
import net.mehvahdjukaar.every_compat.modules.fabric.exlines.AwningModule;
import net.mehvahdjukaar.every_compat.modules.fabric.lauchs.LauchsShuttersModule;
import net.mehvahdjukaar.every_compat.modules.fabric.lightmans_currency.LightmansCurrencyModule;
import net.mehvahdjukaar.every_compat.modules.fabric.missing_wilds.MissingWildModule;
import net.mehvahdjukaar.every_compat.modules.fabric.mrcrayfish.MightyMailModule;
import net.mehvahdjukaar.every_compat.modules.fabric.create.CreateModule;
import net.mehvahdjukaar.every_compat.modules.fabric.dramatic_doors.DramaticDoorsModule;
import net.mehvahdjukaar.every_compat.modules.fabric.farmersdelight.FarmersDelightModuleOld;
import net.mehvahdjukaar.every_compat.modules.fabric.infinitybuttons.InfinityButtonsModule;
import net.mehvahdjukaar.every_compat.modules.fabric.mcaw.*;
import net.mehvahdjukaar.every_compat.modules.fabric.lieonlion.MoreCraftingTablesModule;
import net.mehvahdjukaar.every_compat.modules.fabric.red_bits.RedBitsModule;
import net.mehvahdjukaar.every_compat.modules.fabric.regions_unexplored.RegionsUnexploredModule;
import net.mehvahdjukaar.every_compat.modules.fabric.variants.VariantVanillaBlocksModule;
import net.mehvahdjukaar.every_compat.modules.fabric.wilder_wild.WilderWildModule;
import net.mehvahdjukaar.every_compat.modules.fabric.wooden_hoppers.WoodenHoppersModule;
import net.mehvahdjukaar.moonlight.api.platform.PlatHelper;

public class EveryCompatFabric extends EveryCompat implements ModInitializer {

    @Override
    public void onInitialize() {
        this.commonInit();

        if (PlatHelper.getPhysicalSide().isClient())
            ItemTooltipCallback.EVENT.register(EveryCompatClient::onItemTooltip);

// ================================================= Macaw's ======================================================== \\
        addIfLoaded("mcwbridges", () -> MacawBridgesModule::new);
        addIfLoaded("mcwdoors", () -> MacawDoorsModule::new);
        addIfLoaded("mcwfences", () -> MacawFencesModule::new);
        addIfLoaded("mcwlights", () -> MacawLightsModule::new);
        addIfLoaded("mcwpaths", () -> MacawPathsModule::new);
        addIfLoaded("mcwroofs", () -> MacawRoofsModule::new);
        addIfLoaded("mcwtrpdoors", () -> MacawTrapdoorsModule::new);
        addIfLoaded("mcwwindows", () -> MacawWindowsModule::new);
        addIfLoaded("mcwfurnitures", () -> MacawFurnitureModule::new);
        addIfLoaded("mcwstairs", () -> MacawStairsModule::new);

// ================================================= Add Modules ==================================================== \\
        addIfLoaded("beautify", () -> BeautifyRefabricatedModule::new);
        addIfLoaded("bewitchment", () -> BewitchmentModule::new);
        addIfLoaded("clutter", () -> ClutterModule::new);
        addIfLoaded("create", () -> CreateModule::new);
        addIfLoaded("dramaticdoors", () -> DramaticDoorsModule::new);
        addIfLoaded("exlineawnings", () -> AwningModule::new);
        addIfLoaded("infinitybuttons", () -> InfinityButtonsModule::new);
        addIfLoaded("lightmanscurrency", () -> LightmansCurrencyModule::new);
        addIfLoaded("lolmct", () -> MoreCraftingTablesModule::new);
        addIfLoaded("mighty_mail", () -> MightyMailModule::new);
        addIfLoaded("missingwilds", () -> MissingWildModule::new);
        addIfLoaded("redbits", () -> RedBitsModule::new);
        addIfLoaded("regions_unexplored", () -> RegionsUnexploredModule::new);
        addIfLoaded("shutter", () -> LauchsShuttersModule::new);
        addIfLoaded("variantvanillablocks", () -> VariantVanillaBlocksModule::new);
        addIfLoaded("wilderwild", () -> WilderWildModule::new);
        addIfLoaded("woodenhoppers", () -> WoodenHoppersModule::new);

// ============================================== DISABLED FOR A REASON ============================================= \\
//        addModule("twilightforest", () -> TwilightForestModule::new); //!! NOT AVAILABLE
//        addModule("architects_palette", () -> ArchitectsPaletteModule::new); //!! NOT AVAILABLE

// ===================================================== OTHERS ===================================================== \\
        if (EveryCompat.OLD_FD) EveryCompatAPI.registerModule(new FarmersDelightModuleOld("farmersdelight"));

        forAllModules(CompatModule::onModInit);
        if (PlatHelper.getPhysicalSide().isClient()) {
            EveryCompatClient.init();
        }
    }
}
