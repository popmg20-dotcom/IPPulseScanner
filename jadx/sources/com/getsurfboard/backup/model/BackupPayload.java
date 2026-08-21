package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.n12;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BackupPayload {
    private final BackupManifest manifest;
    private final MetadataBackup metadata;
    private final Map<String, byte[]> profiles;
    private final SettingsBackup settings;

    public /* synthetic */ BackupPayload(BackupManifest backupManifest, SettingsBackup settingsBackup, MetadataBackup metadataBackup, Map map, int i, al0 al0Var) {
        this(backupManifest, (i & 2) != 0 ? null : settingsBackup, (i & 4) != 0 ? null : metadataBackup, (i & 8) != 0 ? null : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupPayload copy$default(BackupPayload backupPayload, BackupManifest backupManifest, SettingsBackup settingsBackup, MetadataBackup metadataBackup, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            backupManifest = backupPayload.manifest;
        }
        if ((i & 2) != 0) {
            settingsBackup = backupPayload.settings;
        }
        if ((i & 4) != 0) {
            metadataBackup = backupPayload.metadata;
        }
        if ((i & 8) != 0) {
            map = backupPayload.profiles;
        }
        return backupPayload.copy(backupManifest, settingsBackup, metadataBackup, map);
    }

    public final BackupManifest component1() {
        return this.manifest;
    }

    public final SettingsBackup component2() {
        return this.settings;
    }

    public final MetadataBackup component3() {
        return this.metadata;
    }

    public final Map<String, byte[]> component4() {
        return this.profiles;
    }

    public final BackupPayload copy(BackupManifest backupManifest, SettingsBackup settingsBackup, MetadataBackup metadataBackup, Map<String, byte[]> map) {
        backupManifest.getClass();
        return new BackupPayload(backupManifest, settingsBackup, metadataBackup, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupPayload)) {
            return false;
        }
        BackupPayload backupPayload = (BackupPayload) obj;
        return n12.c(this.manifest, backupPayload.manifest) && n12.c(this.settings, backupPayload.settings) && n12.c(this.metadata, backupPayload.metadata) && n12.c(this.profiles, backupPayload.profiles);
    }

    public final BackupManifest getManifest() {
        return this.manifest;
    }

    public final MetadataBackup getMetadata() {
        return this.metadata;
    }

    public final Map<String, byte[]> getProfiles() {
        return this.profiles;
    }

    public final SettingsBackup getSettings() {
        return this.settings;
    }

    public int hashCode() {
        int iHashCode = this.manifest.hashCode() * 31;
        SettingsBackup settingsBackup = this.settings;
        int iHashCode2 = (iHashCode + (settingsBackup == null ? 0 : settingsBackup.hashCode())) * 31;
        MetadataBackup metadataBackup = this.metadata;
        int iHashCode3 = (iHashCode2 + (metadataBackup == null ? 0 : metadataBackup.hashCode())) * 31;
        Map<String, byte[]> map = this.profiles;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "BackupPayload(manifest=" + this.manifest + ", settings=" + this.settings + ", metadata=" + this.metadata + ", profiles=" + this.profiles + ")";
    }

    public BackupPayload(BackupManifest backupManifest, SettingsBackup settingsBackup, MetadataBackup metadataBackup, Map<String, byte[]> map) {
        backupManifest.getClass();
        this.manifest = backupManifest;
        this.settings = settingsBackup;
        this.metadata = metadataBackup;
        this.profiles = map;
    }
}
