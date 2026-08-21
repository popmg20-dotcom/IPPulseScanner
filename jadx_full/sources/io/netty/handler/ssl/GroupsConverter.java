package io.netty.handler.ssl;

import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class GroupsConverter {
    private static final Map<String, String> mappings;

    static {
        HashMap map = new HashMap();
        map.put("secp224r1", "P-224");
        map.put("prime256v1", "P-256");
        map.put("secp256r1", "P-256");
        map.put("secp384r1", "P-384");
        map.put("secp521r1", "P-521");
        map.put("x25519", "X25519");
        mappings = DesugarCollections.unmodifiableMap(map);
    }

    private GroupsConverter() {
    }

    public static String toOpenSsl(String str) {
        String str2 = mappings.get(str);
        return str2 == null ? str : str2;
    }
}
