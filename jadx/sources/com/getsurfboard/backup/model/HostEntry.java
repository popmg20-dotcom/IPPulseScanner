package com.getsurfboard.backup.model;

import defpackage.fw;
import defpackage.n12;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class HostEntry {
    private final String key;
    private final String value;

    public HostEntry(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.key = str;
        this.value = str2;
    }

    public static /* synthetic */ HostEntry copy$default(HostEntry hostEntry, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hostEntry.key;
        }
        if ((i & 2) != 0) {
            str2 = hostEntry.value;
        }
        return hostEntry.copy(str, str2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final HostEntry copy(String str, String str2) {
        str.getClass();
        str2.getClass();
        return new HostEntry(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostEntry)) {
            return false;
        }
        HostEntry hostEntry = (HostEntry) obj;
        return n12.c(this.key, hostEntry.key) && n12.c(this.value, hostEntry.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.key.hashCode() * 31);
    }

    public String toString() {
        return fw.v("HostEntry(key=", this.key, ", value=", this.value, ")");
    }
}
