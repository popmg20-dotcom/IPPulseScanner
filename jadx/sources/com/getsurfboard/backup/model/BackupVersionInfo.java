package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.fw;
import defpackage.n12;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BackupVersionInfo {
    private final String appVersion;
    private final int minAppVersionCode;

    public BackupVersionInfo(String str, int i) {
        str.getClass();
        this.appVersion = str;
        this.minAppVersionCode = i;
    }

    public static /* synthetic */ BackupVersionInfo copy$default(BackupVersionInfo backupVersionInfo, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = backupVersionInfo.appVersion;
        }
        if ((i2 & 2) != 0) {
            i = backupVersionInfo.minAppVersionCode;
        }
        return backupVersionInfo.copy(str, i);
    }

    public final String component1() {
        return this.appVersion;
    }

    public final int component2() {
        return this.minAppVersionCode;
    }

    public final BackupVersionInfo copy(String str, int i) {
        str.getClass();
        return new BackupVersionInfo(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupVersionInfo)) {
            return false;
        }
        BackupVersionInfo backupVersionInfo = (BackupVersionInfo) obj;
        return n12.c(this.appVersion, backupVersionInfo.appVersion) && this.minAppVersionCode == backupVersionInfo.minAppVersionCode;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final int getMinAppVersionCode() {
        return this.minAppVersionCode;
    }

    public int hashCode() {
        return (this.appVersion.hashCode() * 31) + this.minAppVersionCode;
    }

    public String toString() {
        return fw.t(this.minAppVersionCode, "BackupVersionInfo(appVersion=", this.appVersion, ", minAppVersionCode=", ")");
    }

    public /* synthetic */ BackupVersionInfo(String str, int i, int i2, al0 al0Var) {
        this(str, (i2 & 2) != 0 ? 284 : i);
    }
}
