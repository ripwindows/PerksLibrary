package dev.ripwindows.perkschallange;


import dev.ripwindows.perkschallange.perkable.ClickablePerk;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;

/**
 * The type Perk manager.
 */
public final class PerkManager {
    private @Getter
    @Nullable Plugin plugin;
    private HashMap<String, Perk> perks;
    private HashMap<String, ClickablePerk> clickablePerks;
    private @Getter static PerkManager instance;

    /**
     * Instantiates a new Perk manager.
     *
     * @param plugin the plugin
     */
    public PerkManager(@NotNull Plugin plugin) {
        instance = this;
        this.plugin = plugin;
        clickablePerks = new HashMap<>();
        perks = new HashMap<>();
        plugin.getServer().getPluginManager().registerEvents(new PerkListener(), plugin);
    }

    /**
     * Sets new perk.
     *
     * @param perk the perk
     */
    public void setupNewPerk(Perk perk) {
        if (!perks.containsKey(perk.name()))
            perks.put(perk.name(), perk);
    }


    /**
     * Sets new perk.
     *
     * @param clickablePerk the clickable perk
     */
    public void setupNewPerk(ClickablePerk clickablePerk) {
        if (!clickablePerks.containsKey(clickablePerk.name()))
            clickablePerks.put(clickablePerk.name(), clickablePerk);
    }

    /**
     * Gets perk.
     *
     * @param name the name
     * @return the perk
     */
    public Perk getPerk(String name) {
        return perks.get(name);
    }

    /**
     * Gets clickable perk.
     *
     * @param name the name
     * @return the clickable perk
     */
    public ClickablePerk getClickablePerk(String name) {
        return clickablePerks.get(name);
    }
    public Collection<ClickablePerk> getClickablePerks() {
        return clickablePerks.values();
    }
}


