package com.getsurfboard.backup.model;

import defpackage.dw2;
import defpackage.fw;
import defpackage.n12;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyGroupSelectionEntry {
    private final String groupName;
    private final String profileName;
    private final String selection;

    public ProxyGroupSelectionEntry(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.profileName = str;
        this.groupName = str2;
        this.selection = str3;
    }

    public static /* synthetic */ ProxyGroupSelectionEntry copy$default(ProxyGroupSelectionEntry proxyGroupSelectionEntry, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proxyGroupSelectionEntry.profileName;
        }
        if ((i & 2) != 0) {
            str2 = proxyGroupSelectionEntry.groupName;
        }
        if ((i & 4) != 0) {
            str3 = proxyGroupSelectionEntry.selection;
        }
        return proxyGroupSelectionEntry.copy(str, str2, str3);
    }

    public final String component1() {
        return this.profileName;
    }

    public final String component2() {
        return this.groupName;
    }

    public final String component3() {
        return this.selection;
    }

    public final ProxyGroupSelectionEntry copy(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        return new ProxyGroupSelectionEntry(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProxyGroupSelectionEntry)) {
            return false;
        }
        ProxyGroupSelectionEntry proxyGroupSelectionEntry = (ProxyGroupSelectionEntry) obj;
        return n12.c(this.profileName, proxyGroupSelectionEntry.profileName) && n12.c(this.groupName, proxyGroupSelectionEntry.groupName) && n12.c(this.selection, proxyGroupSelectionEntry.selection);
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public final String getSelection() {
        return this.selection;
    }

    public int hashCode() {
        return this.selection.hashCode() + dw2.w(this.profileName.hashCode() * 31, 31, this.groupName);
    }

    public String toString() {
        String str = this.profileName;
        String str2 = this.groupName;
        return fw.y(fw.E("ProxyGroupSelectionEntry(profileName=", str, ", groupName=", str2, ", selection="), this.selection, ")");
    }
}
