package fr.forix.inventorygui;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin implements Listener {

    //Ce qui sera affiché dans les logs de la console quand le plugin est en train de se lancer.
    @Override
    public void onLoad() {
        System.out.println("[InventoryGUI] Chargement en cours...");
    }
    //Ce qui sera affiché quand le plugin est prêt à être utilisé.
    @Override
    public void onEnable() {
        System.out.println("[InventoryGUI] InventoryGUI est desormais fonctionnel");
        Bukkit.getPluginManager().registerEvents(this, this);
        //Cette partie va permettre de vérifier si le plugin pourra créer le fichier de config ou non
        String dossierlocal = new File("").getAbsolutePath();
        File f = new File(dossierlocal+"/plugins/InventoryGUI/config.yml");
        if (f.exists()){
            System.out.println("[InventoryGUI] le fichier de config existe déjà!");
        } else{
            System.out.println("[InventoryGUI] Creation du fichier de config");
            saveDefaultConfig();
        }
    }
    //Ce qui sera affiché quand le plugin est éteint (fermeture du serveur).
    @Override
    public void onDisable() {
        System.out.println("[InventoryGUI] A la prochaine fois !");
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("menu")) {
                if (args.length == 1) {
                    String argument = args[0];
                    if (argument.equals(getConfig().getString("Inventaire.commande"))) {
                            int ligne;
                            ligne = getConfig().getInt("Inventaire.lignes");
                            ligne = ligne * 9;
                            if (ligne < 63) {
                                String nom = getConfig().getString("Inventaire.nom").replaceAll("&", "§");
                                Inventory inv = Bukkit.createInventory(null, ligne, nom);
                                int block = 1;
                                /*Cette boucle permettra d'ajouter les items dans l'inventaire personnalisé selon
                                le nombres d'items à ajouter qui a été configuré dans le fichier de config.*/
                                for (int i = 1; i <= getConfig().getInt("Inventaire.nombreitem"); i++) {
                                    switch (block) {
                                        case 1:
                                            //Ce code va récupérer l'ID de l'item
                                            ItemStack block1 = new ItemStack(getConfig().getInt("Inventaire.block1.type"));
                                            //Ce code permettra de lui donner un surnom
                                            ItemMeta block1m = block1.getItemMeta();
                                            //Ce code permettra de récupérer le surnom qui se trouve dans le fichier de config
                                            block1m.setDisplayName(getConfig().getString("Inventaire.block1.surnom"));
                                            //Ce code permet d'appliquer le surnom
                                            block1.setItemMeta(block1m);
                                            //Ce code permet d'ajouter l'item à l'inventaire
                                            inv.setItem(getConfig().getInt("Inventaire.block1.case") - 1, block1);
                                            break;
                                        case 2:
                                            ItemStack block2 = new ItemStack(getConfig().getInt("Inventaire.block2.type"));
                                            ItemMeta block2m = block2.getItemMeta();
                                            block2m.setDisplayName(getConfig().getString("Inventaire.block2.surnom"));
                                            block2.setItemMeta(block2m);
                                            inv.setItem(getConfig().getInt("Inventaire.block2.case") - 1, block2);
                                            break;
                                        case 3:
                                            ItemStack block3 = new ItemStack(getConfig().getInt("Inventaire.block3.type"));
                                            ItemMeta block3m = block3.getItemMeta();
                                            block3m.setDisplayName(getConfig().getString("Inventaire.block3.surnom"));
                                            block3.setItemMeta(block3m);
                                            inv.setItem(getConfig().getInt("Inventaire.block3.case") - 1, block3);
                                            break;
                                        case 4:
                                            ItemStack block4 = new ItemStack(getConfig().getInt("Inventaire.block4.type"));
                                            ItemMeta block4m = block4.getItemMeta();
                                            block4m.setDisplayName(getConfig().getString("Inventaire.block4.surnom"));
                                            block4.setItemMeta(block4m);
                                            inv.setItem(getConfig().getInt("Inventaire.block4.case") - 1, block4);
                                            break;
                                        case 5:
                                            ItemStack block5 = new ItemStack(getConfig().getInt("Inventaire.block5.type"));
                                            ItemMeta block5m = block5.getItemMeta();
                                            block5m.setDisplayName(getConfig().getString("Inventaire.block5.surnom"));
                                            block5.setItemMeta(block5m);
                                            inv.setItem(getConfig().getInt("Inventaire.block5.case") - 1, block5);
                                            break;
                                        case 6:
                                            ItemStack block6 = new ItemStack(getConfig().getInt("Inventaire.block6.type"));
                                            ItemMeta block6m = block6.getItemMeta();
                                            block6m.setDisplayName(getConfig().getString("Inventaire.block6.surnom"));
                                            block6.setItemMeta(block6m);
                                            inv.setItem(getConfig().getInt("Inventaire.block6.case") - 1, block6);
                                            break;
                                        case 7:
                                            ItemStack block7 = new ItemStack(getConfig().getInt("Inventaire.block7.type"));
                                            ItemMeta block7m = block7.getItemMeta();
                                            block7m.setDisplayName(getConfig().getString("Inventaire.block7.surnom"));
                                            block7.setItemMeta(block7m);
                                            inv.setItem(getConfig().getInt("Inventaire.block7.case") - 1, block7);
                                            break;
                                        case 8:
                                            ItemStack block8 = new ItemStack(getConfig().getInt("Inventaire.block8.type"));
                                            ItemMeta block8m = block8.getItemMeta();
                                            block8m.setDisplayName(getConfig().getString("Inventaire.block8.surnom"));
                                            block8.setItemMeta(block8m);
                                            inv.setItem(getConfig().getInt("Inventaire.block8.case") - 1, block8);
                                            break;
                                        case 9:
                                            ItemStack block9 = new ItemStack(getConfig().getInt("Inventaire.block9.type"));
                                            ItemMeta block9m = block9.getItemMeta();
                                            block9m.setDisplayName(getConfig().getString("Inventaire.block9.surnom"));
                                            block9.setItemMeta(block9m);
                                            inv.setItem(getConfig().getInt("Inventaire.block9.case") - 1, block9);
                                            break;
                                        case 10:
                                            ItemStack block10 = new ItemStack(getConfig().getInt("Inventaire.block10.type"));
                                            ItemMeta block10m = block10.getItemMeta();
                                            block10m.setDisplayName(getConfig().getString("Inventaire.block10.surnom"));
                                            block10.setItemMeta(block10m);
                                            inv.setItem(getConfig().getInt("Inventaire.block10.case") - 1, block10);
                                            break;
                                        case 11:
                                            ItemStack block11 = new ItemStack(getConfig().getInt("Inventaire.block11.type"));
                                            ItemMeta block11m = block11.getItemMeta();
                                            block11m.setDisplayName(getConfig().getString("Inventaire.block11.surnom"));
                                            block11.setItemMeta(block11m);
                                            inv.setItem(getConfig().getInt("Inventaire.block11.case") - 1, block11);
                                            break;
                                        case 12:
                                            ItemStack block12 = new ItemStack(getConfig().getInt("Inventaire.block12.type"));
                                            ItemMeta block12m = block12.getItemMeta();
                                            block12m.setDisplayName(getConfig().getString("Inventaire.block12.surnom"));
                                            block12.setItemMeta(block12m);
                                            inv.setItem(getConfig().getInt("Inventaire.block12.case") - 1, block12);
                                            break;
                                        case 13:
                                            ItemStack block13 = new ItemStack(getConfig().getInt("Inventaire.block13.type"));
                                            ItemMeta block13m = block13.getItemMeta();
                                            block13m.setDisplayName(getConfig().getString("Inventaire.block13.surnom"));
                                            block13.setItemMeta(block13m);
                                            inv.setItem(getConfig().getInt("Inventaire.block13.case") - 1, block13);
                                            break;
                                        case 14:
                                            ItemStack block14 = new ItemStack(getConfig().getInt("Inventaire.block14.type"));
                                            ItemMeta block14m = block14.getItemMeta();
                                            block14m.setDisplayName(getConfig().getString("Inventaire.block14.surnom"));
                                            block14.setItemMeta(block14m);
                                            inv.setItem(getConfig().getInt("Inventaire.block14.case") - 1, block14);
                                            break;
                                        case 15:
                                            ItemStack block15 = new ItemStack(getConfig().getInt("Inventaire.block15.type"));
                                            ItemMeta block15m = block15.getItemMeta();
                                            block15m.setDisplayName(getConfig().getString("Inventaire.block15.surnom"));
                                            block15.setItemMeta(block15m);
                                            inv.setItem(getConfig().getInt("Inventaire.block15.case") - 1, block15);
                                            break;
                                        case 16:
                                            ItemStack block16 = new ItemStack(getConfig().getInt("Inventaire.block16.type"));
                                            ItemMeta block16m = block16.getItemMeta();
                                            block16m.setDisplayName(getConfig().getString("Inventaire.block16.surnom"));
                                            block16.setItemMeta(block16m);
                                            inv.setItem(getConfig().getInt("Inventaire.block16.case") - 1, block16);
                                            break;
                                        case 17:
                                            ItemStack block17 = new ItemStack(getConfig().getInt("Inventaire.block17.type"));
                                            ItemMeta block17m = block17.getItemMeta();
                                            block17m.setDisplayName(getConfig().getString("Inventaire.block17.surnom"));
                                            block17.setItemMeta(block17m);
                                            inv.setItem(getConfig().getInt("Inventaire.block17.case") - 1, block17);
                                            break;
                                        case 18:
                                            ItemStack block18 = new ItemStack(getConfig().getInt("Inventaire.block18.type"));
                                            ItemMeta block18m = block18.getItemMeta();
                                            block18m.setDisplayName(getConfig().getString("Inventaire.block18.surnom"));
                                            block18.setItemMeta(block18m);
                                            inv.setItem(getConfig().getInt("Inventaire.block18.case") - 1, block18);
                                            break;
                                        case 19:
                                            ItemStack block19 = new ItemStack(getConfig().getInt("Inventaire.block19.type"));
                                            ItemMeta block19m = block19.getItemMeta();
                                            block19m.setDisplayName(getConfig().getString("Inventaire.block19.surnom"));
                                            block19.setItemMeta(block19m);
                                            inv.setItem(getConfig().getInt("Inventaire.block19.case") - 1, block19);
                                            break;
                                        case 20:
                                            ItemStack block20 = new ItemStack(getConfig().getInt("Inventaire.block20.type"));
                                            ItemMeta block20m = block20.getItemMeta();
                                            block20m.setDisplayName(getConfig().getString("Inventaire.block20.surnom"));
                                            block20.setItemMeta(block20m);
                                            inv.setItem(getConfig().getInt("Inventaire.block20.case") - 1, block20);
                                            break;
                                        case 21:
                                            ItemStack block21 = new ItemStack(getConfig().getInt("Inventaire.block21.type"));
                                            ItemMeta block21m = block21.getItemMeta();
                                            block21m.setDisplayName(getConfig().getString("Inventaire.block21.surnom"));
                                            block21.setItemMeta(block21m);
                                            inv.setItem(getConfig().getInt("Inventaire.block21.case") - 1, block21);
                                            break;
                                        case 22:
                                            ItemStack block22 = new ItemStack(getConfig().getInt("Inventaire.block22.type"));
                                            ItemMeta block22m = block22.getItemMeta();
                                            block22m.setDisplayName(getConfig().getString("Inventaire.block22.surnom"));
                                            block22.setItemMeta(block22m);
                                            inv.setItem(getConfig().getInt("Inventaire.block22.case") - 1, block22);
                                            break;
                                        case 23:
                                            ItemStack block23 = new ItemStack(getConfig().getInt("Inventaire.block23.type"));
                                            ItemMeta block23m = block23.getItemMeta();
                                            block23m.setDisplayName(getConfig().getString("Inventaire.block23.surnom"));
                                            block23.setItemMeta(block23m);
                                            inv.setItem(getConfig().getInt("Inventaire.block23.case") - 1, block23);
                                            break;
                                        case 24:
                                            ItemStack block24 = new ItemStack(getConfig().getInt("Inventaire.block24.type"));
                                            ItemMeta block24m = block24.getItemMeta();
                                            block24m.setDisplayName(getConfig().getString("Inventaire.block24.surnom"));
                                            block24.setItemMeta(block24m);
                                            inv.setItem(getConfig().getInt("Inventaire.block24.case") - 1, block24);
                                            break;
                                        case 25:
                                            ItemStack block25 = new ItemStack(getConfig().getInt("Inventaire.block25.type"));
                                            ItemMeta block25m = block25.getItemMeta();
                                            block25m.setDisplayName(getConfig().getString("Inventaire.block25.surnom"));
                                            block25.setItemMeta(block25m);
                                            inv.setItem(getConfig().getInt("Inventaire.block25.case") - 1, block25);
                                            break;
                                        case 26:
                                            ItemStack block26 = new ItemStack(getConfig().getInt("Inventaire.block26.type"));
                                            ItemMeta block26m = block26.getItemMeta();
                                            block26m.setDisplayName(getConfig().getString("Inventaire.block26.surnom"));
                                            block26.setItemMeta(block26m);
                                            inv.setItem(getConfig().getInt("Inventaire.block26.case") - 1, block26);
                                            break;
                                        case 27:
                                            ItemStack block27 = new ItemStack(getConfig().getInt("Inventaire.block27.type"));
                                            ItemMeta block27m = block27.getItemMeta();
                                            block27m.setDisplayName(getConfig().getString("Inventaire.block27.surnom"));
                                            block27.setItemMeta(block27m);
                                            inv.setItem(getConfig().getInt("Inventaire.block27.case") - 1, block27);
                                            break;
                                        case 28:
                                            ItemStack block28 = new ItemStack(getConfig().getInt("Inventaire.block28.type"));
                                            ItemMeta block28m = block28.getItemMeta();
                                            block28m.setDisplayName(getConfig().getString("Inventaire.block28.surnom"));
                                            block28.setItemMeta(block28m);
                                            inv.setItem(getConfig().getInt("Inventaire.block28.case") - 1, block28);
                                            break;
                                        case 29:
                                            ItemStack block29 = new ItemStack(getConfig().getInt("Inventaire.block29.type"));
                                            ItemMeta block29m = block29.getItemMeta();
                                            block29m.setDisplayName(getConfig().getString("Inventaire.block29.surnom"));
                                            block29.setItemMeta(block29m);
                                            inv.setItem(getConfig().getInt("Inventaire.block29.case") - 1, block29);
                                            break;
                                        case 30:
                                            ItemStack block30 = new ItemStack(getConfig().getInt("Inventaire.block30.type"));
                                            ItemMeta block30m = block30.getItemMeta();
                                            block30m.setDisplayName(getConfig().getString("Inventaire.block30.surnom"));
                                            block30.setItemMeta(block30m);
                                            inv.setItem(getConfig().getInt("Inventaire.block30.case") - 1, block30);
                                            break;
                                        case 31:
                                            ItemStack block31 = new ItemStack(getConfig().getInt("Inventaire.block31.type"));
                                            ItemMeta block31m = block31.getItemMeta();
                                            block31m.setDisplayName(getConfig().getString("Inventaire.block31.surnom"));
                                            block31.setItemMeta(block31m);
                                            inv.setItem(getConfig().getInt("Inventaire.block31.case") - 1, block31);
                                            break;
                                        case 32:
                                            ItemStack block32 = new ItemStack(getConfig().getInt("Inventaire.block32.type"));
                                            ItemMeta block32m = block32.getItemMeta();
                                            block32m.setDisplayName(getConfig().getString("Inventaire.block32.surnom"));
                                            block32.setItemMeta(block32m);
                                            inv.setItem(getConfig().getInt("Inventaire.block32.case") - 1, block32);
                                            break;
                                        case 33:
                                            ItemStack block33 = new ItemStack(getConfig().getInt("Inventaire.block33.type"));
                                            ItemMeta block33m = block33.getItemMeta();
                                            block33m.setDisplayName(getConfig().getString("Inventaire.block33.surnom"));
                                            block33.setItemMeta(block33m);
                                            inv.setItem(getConfig().getInt("Inventaire.block33.case") - 1, block33);
                                            break;
                                        case 34:
                                            ItemStack block34 = new ItemStack(getConfig().getInt("Inventaire.block34.type"));
                                            ItemMeta block34m = block34.getItemMeta();
                                            block34m.setDisplayName(getConfig().getString("Inventaire.block34.surnom"));
                                            block34.setItemMeta(block34m);
                                            inv.setItem(getConfig().getInt("Inventaire.block34.case") - 1, block34);
                                            break;
                                        case 35:
                                            ItemStack block35 = new ItemStack(getConfig().getInt("Inventaire.block35.type"));
                                            ItemMeta block35m = block35.getItemMeta();
                                            block35m.setDisplayName(getConfig().getString("Inventaire.block35.surnom"));
                                            block35.setItemMeta(block35m);
                                            inv.setItem(getConfig().getInt("Inventaire.block35.case") - 1, block35);
                                            break;
                                        case 36:
                                            ItemStack block36 = new ItemStack(getConfig().getInt("Inventaire.block36.type"));
                                            ItemMeta block36m = block36.getItemMeta();
                                            block36m.setDisplayName(getConfig().getString("Inventaire.block36.surnom"));
                                            block36.setItemMeta(block36m);
                                            inv.setItem(getConfig().getInt("Inventaire.block36.case") - 1, block36);
                                            break;
                                        case 37:
                                            ItemStack block37 = new ItemStack(getConfig().getInt("Inventaire.block37.type"));
                                            ItemMeta block37m = block37.getItemMeta();
                                            block37m.setDisplayName(getConfig().getString("Inventaire.block37.surnom"));
                                            block37.setItemMeta(block37m);
                                            inv.setItem(getConfig().getInt("Inventaire.block37.case") - 1, block37);
                                            break;
                                        case 38:
                                            ItemStack block38 = new ItemStack(getConfig().getInt("Inventaire.block38.type"));
                                            ItemMeta block38m = block38.getItemMeta();
                                            block38m.setDisplayName(getConfig().getString("Inventaire.block38.surnom"));
                                            block38.setItemMeta(block38m);
                                            inv.setItem(getConfig().getInt("Inventaire.block38.case") - 1, block38);
                                            break;
                                        case 39:
                                            ItemStack block39 = new ItemStack(getConfig().getInt("Inventaire.block39.type"));
                                            ItemMeta block39m = block39.getItemMeta();
                                            block39m.setDisplayName(getConfig().getString("Inventaire.block39.surnom"));
                                            block39.setItemMeta(block39m);
                                            inv.setItem(getConfig().getInt("Inventaire.block39.case") - 1, block39);
                                            break;
                                        case 40:
                                            ItemStack block40 = new ItemStack(getConfig().getInt("Inventaire.block40.type"));
                                            ItemMeta block40m = block40.getItemMeta();
                                            block40m.setDisplayName(getConfig().getString("Inventaire.block40.surnom"));
                                            block40.setItemMeta(block40m);
                                            inv.setItem(getConfig().getInt("Inventaire.block40.case") - 1, block40);
                                            break;
                                        case 41:
                                            ItemStack block41 = new ItemStack(getConfig().getInt("Inventaire.block41.type"));
                                            ItemMeta block41m = block41.getItemMeta();
                                            block41m.setDisplayName(getConfig().getString("Inventaire.block41.surnom"));
                                            block41.setItemMeta(block41m);
                                            inv.setItem(getConfig().getInt("Inventaire.block41.case") - 1, block41);
                                            break;
                                        case 42:
                                            ItemStack block42 = new ItemStack(getConfig().getInt("Inventaire.block42.type"));
                                            ItemMeta block42m = block42.getItemMeta();
                                            block42m.setDisplayName(getConfig().getString("Inventaire.block42.surnom"));
                                            block42.setItemMeta(block42m);
                                            inv.setItem(getConfig().getInt("Inventaire.block42.case") - 1, block42);
                                            break;
                                        case 43:
                                            ItemStack block43 = new ItemStack(getConfig().getInt("Inventaire.block43.type"));
                                            ItemMeta block43m = block43.getItemMeta();
                                            block43m.setDisplayName(getConfig().getString("Inventaire.block43.surnom"));
                                            block43.setItemMeta(block43m);
                                            inv.setItem(getConfig().getInt("Inventaire.block43.case") - 1, block43);
                                            break;
                                        case 44:
                                            ItemStack block44 = new ItemStack(getConfig().getInt("Inventaire.block44.type"));
                                            ItemMeta block44m = block44.getItemMeta();
                                            block44m.setDisplayName(getConfig().getString("Inventaire.block44.surnom"));
                                            block44.setItemMeta(block44m);
                                            inv.setItem(getConfig().getInt("Inventaire.block44.case") - 1, block44);
                                            break;
                                        case 45:
                                            ItemStack block45 = new ItemStack(getConfig().getInt("Inventaire.block45.type"));
                                            ItemMeta block45m = block45.getItemMeta();
                                            block45m.setDisplayName(getConfig().getString("Inventaire.block45.surnom"));
                                            block45.setItemMeta(block45m);
                                            inv.setItem(getConfig().getInt("Inventaire.block45.case") - 1, block45);
                                            break;
                                        case 46:
                                            ItemStack block46 = new ItemStack(getConfig().getInt("Inventaire.block46.type"));
                                            ItemMeta block46m = block46.getItemMeta();
                                            block46m.setDisplayName(getConfig().getString("Inventaire.block46.surnom"));
                                            block46.setItemMeta(block46m);
                                            inv.setItem(getConfig().getInt("Inventaire.block46.case") - 1, block46);
                                            break;
                                        case 47:
                                            ItemStack block47 = new ItemStack(getConfig().getInt("Inventaire.block47.type"));
                                            ItemMeta block47m = block47.getItemMeta();
                                            block47m.setDisplayName(getConfig().getString("Inventaire.block47.surnom"));
                                            block47.setItemMeta(block47m);
                                            inv.setItem(getConfig().getInt("Inventaire.block47.case") - 1, block47);
                                            break;
                                        case 48:
                                            ItemStack block48 = new ItemStack(getConfig().getInt("Inventaire.block48.type"));
                                            ItemMeta block48m = block48.getItemMeta();
                                            block48m.setDisplayName(getConfig().getString("Inventaire.block48.surnom"));
                                            block48.setItemMeta(block48m);
                                            inv.setItem(getConfig().getInt("Inventaire.block48.case") - 1, block48);
                                            break;
                                        case 49:
                                            ItemStack block49 = new ItemStack(getConfig().getInt("Inventaire.block49.type"));
                                            ItemMeta block49m = block49.getItemMeta();
                                            block49m.setDisplayName(getConfig().getString("Inventaire.block49.surnom"));
                                            block49.setItemMeta(block49m);
                                            inv.setItem(getConfig().getInt("Inventaire.block49.case") - 1, block49);
                                            break;
                                        case 50:
                                            ItemStack block50 = new ItemStack(getConfig().getInt("Inventaire.block50.type"));
                                            ItemMeta block50m = block50.getItemMeta();
                                            block50m.setDisplayName(getConfig().getString("Inventaire.block50.surnom"));
                                            block50.setItemMeta(block50m);
                                            inv.setItem(getConfig().getInt("Inventaire.block50.case") - 1, block50);
                                            break;
                                        case 51:
                                            ItemStack block51 = new ItemStack(getConfig().getInt("Inventaire.block51.type"));
                                            ItemMeta block51m = block51.getItemMeta();
                                            block51m.setDisplayName(getConfig().getString("Inventaire.block51.surnom"));
                                            block51.setItemMeta(block51m);
                                            inv.setItem(getConfig().getInt("Inventaire.block51.case") - 1, block51);
                                            break;
                                        case 52:
                                            ItemStack block52 = new ItemStack(getConfig().getInt("Inventaire.block52.type"));
                                            ItemMeta block52m = block52.getItemMeta();
                                            block52m.setDisplayName(getConfig().getString("Inventaire.block52.surnom"));
                                            block52.setItemMeta(block52m);
                                            inv.setItem(getConfig().getInt("Inventaire.block52.case") - 1, block52);
                                            break;
                                        case 53:
                                            ItemStack block53 = new ItemStack(getConfig().getInt("Inventaire.block53.type"));
                                            ItemMeta block53m = block53.getItemMeta();
                                            block53m.setDisplayName(getConfig().getString("Inventaire.block53.surnom"));
                                            block53.setItemMeta(block53m);
                                            inv.setItem(getConfig().getInt("Inventaire.block53.case") - 1, block53);
                                            break;
                                        case 54:
                                            ItemStack block54 = new ItemStack(getConfig().getInt("Inventaire.block54.type"));
                                            ItemMeta block54m = block54.getItemMeta();
                                            block54m.setDisplayName(getConfig().getString("Inventaire.block54.surnom"));
                                            block54.setItemMeta(block54m);
                                            inv.setItem(getConfig().getInt("Inventaire.block54.case") - 1, block54);
                                            break;
                                        default:
                                            break;
                                    }
                                    block++;
                                }
                                block = 1;
                                p.openInventory(inv);
                            } else {
                                //Erreur si jamais le joueur a mis plus de 6 lignes (l'inventaire sera bugé)
                                p.sendMessage("§cErreur: Vous pouvez mettre pas plus de 6 lignes !");
                            }
                    } else {
                        //Erreur si jamais le joueur a saisis le mauvais nom d'inventaire selon la configuration.
                        p.sendMessage("§4Erreur: Vous avez saisis le mauvais nom d'inventaire. Voici la liste d'inventaire disponible:");
                        p.sendMessage("§3"+getConfig().getString("Inventaire.nom").replaceAll("§", "")+" §2Commande à faire: /menu "+getConfig().getString("Inventaire.commande"));
                    }
                } else {
                    //Si jamais le joueur a marqué seulement /menu
                    p.sendMessage("/menu " + getConfig().getString("Inventaire.commande"));
                }
            }
        } else{
            //Si la personne qui a executée la commande n'est pas un joueur (console) ce message sera envoyé.
            System.out.println("Vous devez être un joueur !");
        }
        return true;
    }

    @EventHandler
    //Méthode permettant de créer un événement lors du clic sur un item dans l'inventaire personnalisé
    public void onInventoryClick(InventoryClickEvent event) {
        //initialisation des prérequis nécessaires pour le fonctionnement des events
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        /*Permet de vérifier si le nom de l'inventaire que le joueur a ouvert est égal à celui qui est présent dans le fichier
        de config*/
        if (inventory.getName().equals(getConfig().getString("Inventaire.nom"))){
            //Si le joueur clic sur rien, cette méthode permettra d'éviter de créer une erreur.
            if (clicked.getType() == Material.AIR)
                return;

            //Les actions ci-dessous seront executées selon le bloc que le joueur a cliqué
                //Si le joueur clic sur un block qui est égal à l'id qui a été donné dans le fichier de config alors...
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block1.type")){
                //Cette partie permettra de transformer les placeholders
                String getcmd = getConfig().getString("Inventaire.block1.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                //La commande qui sera executée par la console
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                //Quand le joueur aura cliqué sur l'item, il va revenir à sa place.
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block2.type")){
                String getcmd = getConfig().getString("Inventaire.block2.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block3.type")){
                String getcmd = getConfig().getString("Inventaire.block3.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block4.type")){
                String getcmd = getConfig().getString("Inventaire.block4.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block5.type")){
                String getcmd = getConfig().getString("Inventaire.block5.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block6.type")){
                String getcmd = getConfig().getString("Inventaire.block6.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block7.type")){
                String getcmd = getConfig().getString("Inventaire.block7.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block8.type")){
                String getcmd = getConfig().getString("Inventaire.block8.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block9.type")){
                String getcmd = getConfig().getString("Inventaire.block9.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block10.type")){
                String getcmd = getConfig().getString("Inventaire.block10.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block11.type")){
                String getcmd = getConfig().getString("Inventaire.block11.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block12.type")){
                String getcmd = getConfig().getString("Inventaire.block12.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block13.type")){
                String getcmd = getConfig().getString("Inventaire.block13.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block14.type")){
                String getcmd = getConfig().getString("Inventaire.block14.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block15.type")){
                String getcmd = getConfig().getString("Inventaire.block15.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block16.type")){
                String getcmd = getConfig().getString("Inventaire.block16.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block17.type")){
                String getcmd = getConfig().getString("Inventaire.block17.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block18.type")){
                String getcmd = getConfig().getString("Inventaire.block18.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block19.type")){
                String getcmd = getConfig().getString("Inventaire.block19.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block20.type")){
                String getcmd = getConfig().getString("Inventaire.block20.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block21.type")){
                String getcmd = getConfig().getString("Inventaire.block21.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block22.type")){
                String getcmd = getConfig().getString("Inventaire.block22.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block23.type")){
                String getcmd = getConfig().getString("Inventaire.block23.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block24.type")){
                String getcmd = getConfig().getString("Inventaire.block24.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block25.type")){
                String getcmd = getConfig().getString("Inventaire.block25.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block26.type")){
                String getcmd = getConfig().getString("Inventaire.block26.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block27.type")){
                String getcmd = getConfig().getString("Inventaire.block27.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block28.type")){
                String getcmd = getConfig().getString("Inventaire.block28.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block29.type")){
                String getcmd = getConfig().getString("Inventaire.block29.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block30.type")){
                String getcmd = getConfig().getString("Inventaire.block30.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block31.type")){
                String getcmd = getConfig().getString("Inventaire.block31.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block32.type")){
                String getcmd = getConfig().getString("Inventaire.block32.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block33.type")){
                String getcmd = getConfig().getString("Inventaire.block33.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block34.type")){
                String getcmd = getConfig().getString("Inventaire.block34.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block35.type")){
                String getcmd = getConfig().getString("Inventaire.block35.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block36.type")){
                String getcmd = getConfig().getString("Inventaire.block36.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block37.type")){
                String getcmd = getConfig().getString("Inventaire.block37.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block38.type")){
                String getcmd = getConfig().getString("Inventaire.block38.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block39.type")){
                String getcmd = getConfig().getString("Inventaire.block39.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block40.type")){
                String getcmd = getConfig().getString("Inventaire.block40.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block41.type")){
                String getcmd = getConfig().getString("Inventaire.block41.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block42.type")){
                String getcmd = getConfig().getString("Inventaire.block42.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block43.type")){
                String getcmd = getConfig().getString("Inventaire.block43.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block44.type")){
                String getcmd = getConfig().getString("Inventaire.block44.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block45.type")){
                String getcmd = getConfig().getString("Inventaire.block45.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block46.type")){
                String getcmd = getConfig().getString("Inventaire.block46.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }if (clicked.getTypeId() == getConfig().getInt("Inventaire.block47.type")){
                String getcmd = getConfig().getString("Inventaire.block47.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block48.type")){
                String getcmd = getConfig().getString("Inventaire.block48.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block49.type")){
                String getcmd = getConfig().getString("Inventaire.block49.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block50.type")){
                String getcmd = getConfig().getString("Inventaire.block50.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block51.type")){
                String getcmd = getConfig().getString("Inventaire.block51.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block52.type")){
                String getcmd = getConfig().getString("Inventaire.block52.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block53.type")){
                String getcmd = getConfig().getString("Inventaire.block53.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }
            if (clicked.getTypeId() == getConfig().getInt("Inventaire.block54.type")){
                String getcmd = getConfig().getString("Inventaire.block54.cmd");
                String cmd = PlaceholderAPI.setPlaceholders(player.getPlayer(), getcmd);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                event.setCancelled(true);
            }

        }
    }
}
