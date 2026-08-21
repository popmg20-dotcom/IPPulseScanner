package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.g41;
import defpackage.k41;
import defpackage.n12;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MetadataBackup {
    private final List<HostEntry> hosts;
    private final Set<String> pinnedProfiles;
    private final List<ProxyGroupSelectionEntry> proxyGroupSelections;
    private final String selectedProfile;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MetadataBackup(String str, Set set, List list, List list2, int i, al0 al0Var) {
        str = (i & 1) != 0 ? null : str;
        set = (i & 2) != 0 ? k41.b : set;
        int i2 = i & 4;
        g41 g41Var = g41.b;
        this(str, set, i2 != 0 ? g41Var : list, (i & 8) != 0 ? g41Var : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataBackup copy$default(MetadataBackup metadataBackup, String str, Set set, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadataBackup.selectedProfile;
        }
        if ((i & 2) != 0) {
            set = metadataBackup.pinnedProfiles;
        }
        if ((i & 4) != 0) {
            list = metadataBackup.proxyGroupSelections;
        }
        if ((i & 8) != 0) {
            list2 = metadataBackup.hosts;
        }
        return metadataBackup.copy(str, set, list, list2);
    }

    public final String component1() {
        return this.selectedProfile;
    }

    public final Set<String> component2() {
        return this.pinnedProfiles;
    }

    public final List<ProxyGroupSelectionEntry> component3() {
        return this.proxyGroupSelections;
    }

    public final List<HostEntry> component4() {
        return this.hosts;
    }

    public final MetadataBackup copy(String str, Set<String> set, List<ProxyGroupSelectionEntry> list, List<HostEntry> list2) {
        set.getClass();
        list.getClass();
        list2.getClass();
        return new MetadataBackup(str, set, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBackup)) {
            return false;
        }
        MetadataBackup metadataBackup = (MetadataBackup) obj;
        return n12.c(this.selectedProfile, metadataBackup.selectedProfile) && n12.c(this.pinnedProfiles, metadataBackup.pinnedProfiles) && n12.c(this.proxyGroupSelections, metadataBackup.proxyGroupSelections) && n12.c(this.hosts, metadataBackup.hosts);
    }

    public final List<HostEntry> getHosts() {
        return this.hosts;
    }

    public final Set<String> getPinnedProfiles() {
        return this.pinnedProfiles;
    }

    public final List<ProxyGroupSelectionEntry> getProxyGroupSelections() {
        return this.proxyGroupSelections;
    }

    public final String getSelectedProfile() {
        return this.selectedProfile;
    }

    public int hashCode() {
        String str = this.selectedProfile;
        return this.hosts.hashCode() + ((this.proxyGroupSelections.hashCode() + ((this.pinnedProfiles.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "MetadataBackup(selectedProfile=" + this.selectedProfile + ", pinnedProfiles=" + this.pinnedProfiles + ", proxyGroupSelections=" + this.proxyGroupSelections + ", hosts=" + this.hosts + ")";
    }

    public MetadataBackup(String str, Set<String> set, List<ProxyGroupSelectionEntry> list, List<HostEntry> list2) {
        set.getClass();
        list.getClass();
        list2.getClass();
        this.selectedProfile = str;
        this.pinnedProfiles = set;
        this.proxyGroupSelections = list;
        this.hosts = list2;
    }

    public MetadataBackup() {
        this(null, null, null, null, 15, null);
    }
}
