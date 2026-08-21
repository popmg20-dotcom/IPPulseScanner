package io.netty.resolver;

import j$.util.DesugarCollections;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class HostsFileEntries {
    static final HostsFileEntries EMPTY;
    private final Map<String, Inet4Address> inet4Entries;
    private final Map<String, Inet6Address> inet6Entries;

    static {
        Map map = Collections.EMPTY_MAP;
        EMPTY = new HostsFileEntries(map, map);
    }

    public HostsFileEntries(Map<String, Inet4Address> map, Map<String, Inet6Address> map2) {
        this.inet4Entries = DesugarCollections.unmodifiableMap(new HashMap(map));
        this.inet6Entries = DesugarCollections.unmodifiableMap(new HashMap(map2));
    }

    public Map<String, Inet4Address> inet4Entries() {
        return this.inet4Entries;
    }

    public Map<String, Inet6Address> inet6Entries() {
        return this.inet6Entries;
    }
}
