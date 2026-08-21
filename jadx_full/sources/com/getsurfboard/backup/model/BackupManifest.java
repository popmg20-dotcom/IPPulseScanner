package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.dw2;
import defpackage.g41;
import defpackage.n12;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BackupManifest {
    private final String appVersion;
    private final long createdAt;
    private final int minAppVersionCode;
    private final List<String> sections;

    public /* synthetic */ BackupManifest(int i, String str, long j, List list, int i2, al0 al0Var) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? g41.b : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackupManifest copy$default(BackupManifest backupManifest, int i, String str, long j, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = backupManifest.minAppVersionCode;
        }
        if ((i2 & 2) != 0) {
            str = backupManifest.appVersion;
        }
        if ((i2 & 4) != 0) {
            j = backupManifest.createdAt;
        }
        if ((i2 & 8) != 0) {
            list = backupManifest.sections;
        }
        List list2 = list;
        return backupManifest.copy(i, str, j, list2);
    }

    public final int component1() {
        return this.minAppVersionCode;
    }

    public final String component2() {
        return this.appVersion;
    }

    public final long component3() {
        return this.createdAt;
    }

    public final List<String> component4() {
        return this.sections;
    }

    public final BackupManifest copy(int i, String str, long j, List<String> list) {
        str.getClass();
        list.getClass();
        return new BackupManifest(i, str, j, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupManifest)) {
            return false;
        }
        BackupManifest backupManifest = (BackupManifest) obj;
        return this.minAppVersionCode == backupManifest.minAppVersionCode && n12.c(this.appVersion, backupManifest.appVersion) && this.createdAt == backupManifest.createdAt && n12.c(this.sections, backupManifest.sections);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getMinAppVersionCode() {
        return this.minAppVersionCode;
    }

    public final List<String> getSections() {
        return this.sections;
    }

    public int hashCode() {
        int iW = dw2.w(this.minAppVersionCode * 31, 31, this.appVersion);
        long j = this.createdAt;
        return this.sections.hashCode() + ((iW + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public String toString() {
        return "BackupManifest(minAppVersionCode=" + this.minAppVersionCode + ", appVersion=" + this.appVersion + ", createdAt=" + this.createdAt + ", sections=" + this.sections + ")";
    }

    public BackupManifest(int i, String str, long j, List<String> list) {
        str.getClass();
        list.getClass();
        this.minAppVersionCode = i;
        this.appVersion = str;
        this.createdAt = j;
        this.sections = list;
    }

    public BackupManifest() {
        this(0, null, 0L, null, 15, null);
    }
}
