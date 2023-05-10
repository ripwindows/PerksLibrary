package dev.ripwindows.perkschallange;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

/**
 * The interface Perk.
 *
 * @author <a href="https://github.com/ripwindows">ripwindows</a>
 */
public interface Perk {

    /**
     * Returns the name of the perk as a string.
     *
     * @return the name of the perk.
     */
    @NotNull String name();

    /**
     * Returns a Predicate that determines whether the given player
     * meets the requirements for the perk.
     *
     * @return a Predicate that tests whether the player meets the requirements.
     */
    Predicate<Player> requirements();

    /**
     * Executes the actions associated with the perk for the given player.
     *
     * @param player the player on which to execute the perk.
     */
    void execute(@NotNull Player player);

    /**
     * Applies the perk to the given player, if they meet the requirements.
     *
     * @param player the player to apply the perk to.
     */
    default void apply(@NotNull Player player) {
        if (requirements().test(player)) {
            execute(player);
        }
    }
}
