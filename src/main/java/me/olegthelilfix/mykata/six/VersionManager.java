package me.olegthelilfix.mykata.six;

public class VersionManager {
    private int majorInitial = 0;
    private int major = 0;

    private int minorInitial = 0;
    private int minor = 0;

    private int patchInitial = 1;
    private int patch = 1;

    public VersionManager() {}

    public VersionManager(String version) {
        if (!version.isEmpty()) {
            String[] parts = version.split("\\.");
            try {
                major = majorInitial = Integer.parseInt(parts[0]);
                if (parts.length > 1) {
                    minor = minorInitial = Integer.parseInt(parts[1]);
                    if (parts.length > 2) {
                        patch = patchInitial = Integer.parseInt(parts[2]);
                    }
                    else {
                        patch = patchInitial = 0;
                    }
                }
                else {
                    minor = minorInitial = 0;
                    patch = patchInitial = 0;
                }
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException("Error occured while parsing version!");
            }
            if (major < 0 || minor < 0 || patch < 0) {
                throw new IllegalArgumentException("Error occured while parsing version!");
            }
        }
    }

    public VersionManager major() {
        save();

        major++;
        minor = patch = 0;
        return this;
    }
    public VersionManager minor() {
        save();

        minor++;
        patch = 0;
        return this;
    }
    public VersionManager patch() {
        save();

        patch++;
        return this;
    }
    public VersionManager rollback() {
        if (major == majorInitial && minor == minorInitial && patch == patchInitial) {
            throw new IllegalStateException("Cannot rollback!");
        }

        major = majorInitial;
        minor = minorInitial;
        patch = patchInitial;

        return this;
    }

    private void save() {
        majorInitial = major;
        minorInitial = minor;
        patchInitial = patch;
    }

    public String release() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

}
