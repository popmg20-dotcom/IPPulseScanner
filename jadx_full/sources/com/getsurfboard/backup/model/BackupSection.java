package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.i51;
import defpackage.n12;
import defpackage.ye;
import java.util.Iterator;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BackupSection {
    private static final /* synthetic */ i51 $ENTRIES;
    private static final /* synthetic */ BackupSection[] $VALUES;
    public static final Companion Companion;
    private final String manifestName;
    public static final BackupSection PROFILES = new BackupSection("PROFILES", 0, "profiles");
    public static final BackupSection SETTINGS = new BackupSection("SETTINGS", 1, "settings");
    public static final BackupSection METADATA = new BackupSection("METADATA", 2, "metadata");
    public static final BackupSection HOSTS = new BackupSection("HOSTS", 3, "hosts");

    private static final /* synthetic */ BackupSection[] $values() {
        return new BackupSection[]{PROFILES, SETTINGS, METADATA, HOSTS};
    }

    static {
        BackupSection[] backupSectionArr$values = $values();
        $VALUES = backupSectionArr$values;
        $ENTRIES = ye.m(backupSectionArr$values);
        Companion = new Companion(null);
    }

    private BackupSection(String str, int i, String str2) {
        this.manifestName = str2;
    }

    public static i51 getEntries() {
        return $ENTRIES;
    }

    public static BackupSection valueOf(String str) {
        return (BackupSection) Enum.valueOf(BackupSection.class, str);
    }

    public static BackupSection[] values() {
        return (BackupSection[]) $VALUES.clone();
    }

    public final String getManifestName() {
        return this.manifestName;
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Companion {
        public /* synthetic */ Companion(al0 al0Var) {
            this();
        }

        public final BackupSection fromManifestName(String str) {
            Object next;
            str.getClass();
            Iterator<E> it = BackupSection.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (n12.c(((BackupSection) next).getManifestName(), str)) {
                    break;
                }
            }
            return (BackupSection) next;
        }

        private Companion() {
        }
    }
}
