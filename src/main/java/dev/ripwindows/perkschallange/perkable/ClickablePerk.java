package dev.ripwindows.perkschallange.perkable;

import dev.ripwindows.perkschallange.Perk;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * The interface Clickable perk.
 *
 * @author <a href="https://github.com/ripwindows">ripwindows</a>
 */
public interface ClickablePerk extends Perk {
    /**
     * Clickable Item.
     *
     * @return the item stack
     */
    @NotNull ItemStack item();

    /**
     * Gives Player Perk.
     *
     * @param player the player
     */
    default void give(Player player) {
        player.getInventory().addItem(item());
    }

}
