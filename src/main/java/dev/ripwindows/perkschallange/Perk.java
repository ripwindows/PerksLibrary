package dev.ripwindows.perkschallange;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * The interface Perk.
 *
 * @author <a href="https://github.com/ripwindows">ripwindows</a>
 */
public interface Perk {
    /**
     * Name string.
     *
     * @return the string
     */
    @NotNull String name();

    /**
     * Requirements boolean.
     *
     * @param player the player
     * @return the boolean
     */
    boolean requirements(@NotNull Player player);

    /**
     * Execute.
     *
     * @param player the player
     */
    void execute(@NotNull Player player);
    /**
     * Apply.
     *
     * @param player the player
     */
    default void apply(@NotNull Player player) {
        if (!requirements(player))
            execute(player);
    }

}
