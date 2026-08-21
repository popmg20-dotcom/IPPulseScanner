package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.h41;
import defpackage.n12;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsBackup {
    private final Map<String, SettingValue> entries;

    public /* synthetic */ SettingsBackup(Map map, int i, al0 al0Var) {
        this((i & 1) != 0 ? h41.b : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsBackup copy$default(SettingsBackup settingsBackup, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = settingsBackup.entries;
        }
        return settingsBackup.copy(map);
    }

    public final Map<String, SettingValue> component1() {
        return this.entries;
    }

    public final SettingsBackup copy(Map<String, SettingValue> map) {
        map.getClass();
        return new SettingsBackup(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SettingsBackup) && n12.c(this.entries, ((SettingsBackup) obj).entries);
    }

    public final Map<String, SettingValue> getEntries() {
        return this.entries;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "SettingsBackup(entries=" + this.entries + ")";
    }

    public SettingsBackup(Map<String, SettingValue> map) {
        map.getClass();
        this.entries = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SettingsBackup() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
