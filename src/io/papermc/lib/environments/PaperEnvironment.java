package io.papermc.lib.environments;

import io.papermc.lib.features.asyncteleport.AsyncTeleportPaper;

public class PaperEnvironment extends SpigotEnvironment {

    public PaperEnvironment() {
        super();
    }

    @Override
    public String getName() {
        return "Paper";
    }

    @Override
    public boolean isPaper() {
        return true;
    }

}
