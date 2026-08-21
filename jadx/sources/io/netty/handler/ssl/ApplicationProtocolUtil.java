package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    private ApplicationProtocolUtil() {
    }

    public static List<String> toList(int i, Iterable<String> iterable) {
        if (iterable == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(ObjectUtil.checkNonEmpty(it.next(), "p"));
        }
        return (List) ObjectUtil.checkNonEmpty(arrayList, "result");
    }

    public static List<String> toList(Iterable<String> iterable) {
        return toList(2, iterable);
    }

    public static List<String> toList(String... strArr) {
        return toList(2, strArr);
    }

    public static List<String> toList(int i, String... strArr) {
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        for (String str : strArr) {
            arrayList.add(ObjectUtil.checkNonEmpty(str, "p"));
        }
        return (List) ObjectUtil.checkNonEmpty(arrayList, "result");
    }
}
