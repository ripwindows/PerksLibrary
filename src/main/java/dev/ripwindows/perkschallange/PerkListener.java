package dev.ripwindows.perkschallange;

import dev.ripwindows.perkschallange.perkable.ClickablePerk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author <a href="https://github.com/ripwindows">ripwindows</a>
 */
public class PerkListener implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        ItemStack item = event.getItem();

        if (item == null)
            return;

        Player player = event.getPlayer();
        ClickablePerk clickablePerk = getPerk(item);

        if (clickablePerk == null)
            return;

        clickablePerk.apply(player);
        player.getInventory().removeItem(clickablePerk.item());

    }

    public ClickablePerk getPerk(ItemStack itemStack) {
        for (ClickablePerk perk : PerkManager.getInstance().getClickablePerks()) {
            if (perk.item().getType() == itemStack.getType() &&
                    perk.item().getItemMeta().equals(itemStack.getItemMeta()))
                return perk;
        }
        return null;
    }
}
