package defpackage;

import android.net.Uri;
import io.sentry.android.core.a1;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oa5 {
    public static final Object g = new Object();
    public static volatile v95 h;
    public static final AtomicInteger i;
    public final sn a;
    public final String b;
    public final Object c;
    public volatile int d = -1;
    public volatile Object e;
    public final /* synthetic */ int f;

    static {
        new AtomicReference();
        i = new AtomicInteger();
    }

    public /* synthetic */ oa5(sn snVar, String str, Object obj, int i2) {
        this.f = i2;
        if (((Uri) snVar.f) == null) {
            xe.k("Must pass a valid SharedPreferences file name or ContentProvider URI");
            throw null;
        }
        this.a = snVar;
        this.b = str;
        this.c = obj;
    }

    public final Object a(Object obj) {
        int i2 = this.f;
        String str = this.b;
        switch (i2) {
            case 0:
                if (obj instanceof Long) {
                    return (Long) obj;
                }
                if (obj instanceof String) {
                    try {
                        return Long.valueOf(Long.parseLong((String) obj));
                    } catch (NumberFormatException unused) {
                    }
                }
                String string = obj.toString();
                StringBuilder sb = new StringBuilder(str.length() + 25 + string.length());
                sb.append("Invalid long value for ");
                sb.append(str);
                sb.append(": ");
                sb.append(string);
                a1.d("PhenotypeFlag", sb.toString());
                return null;
            case 1:
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (n95.b.matcher(str2).matches()) {
                        return Boolean.TRUE;
                    }
                    if (n95.c.matcher(str2).matches()) {
                        return Boolean.FALSE;
                    }
                }
                String string2 = obj.toString();
                StringBuilder sb2 = new StringBuilder(str.length() + 28 + string2.length());
                sb2.append("Invalid boolean value for ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(string2);
                a1.d("PhenotypeFlag", sb2.toString());
                return null;
            case 2:
                if (obj instanceof Double) {
                    return (Double) obj;
                }
                if (obj instanceof Float) {
                    return Double.valueOf(((Float) obj).doubleValue());
                }
                if (obj instanceof String) {
                    try {
                        return Double.valueOf(Double.parseDouble((String) obj));
                    } catch (NumberFormatException unused2) {
                    }
                }
                String string3 = obj.toString();
                StringBuilder sb3 = new StringBuilder(str.length() + 27 + string3.length());
                sb3.append("Invalid double value for ");
                sb3.append(str);
                sb3.append(": ");
                sb3.append(string3);
                a1.d("PhenotypeFlag", sb3.toString());
                return null;
            default:
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[PHI: r2
      0x0058: PHI (r2v1 mw2) = (r2v0 mw2), (r2v5 mw2), (r2v5 mw2) binds: [B:8:0x0014, B:10:0x0022, B:16:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062 A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x0024, B:13:0x0034, B:17:0x0048, B:26:0x0062, B:28:0x006a, B:30:0x0072, B:33:0x0082, B:35:0x0090, B:47:0x00b5, B:50:0x00bd, B:51:0x00c0, B:52:0x00c4, B:39:0x0099, B:41:0x009d, B:43:0x00ab, B:45:0x00b1, B:53:0x00c9, B:54:0x00cb, B:55:0x00cc, B:56:0x00d1, B:14:0x0041, B:57:0x00d2), top: B:63:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc A[Catch: all -> 0x0055, TryCatch #0 {all -> 0x0055, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0016, B:11:0x0024, B:13:0x0034, B:17:0x0048, B:26:0x0062, B:28:0x006a, B:30:0x0072, B:33:0x0082, B:35:0x0090, B:47:0x00b5, B:50:0x00bd, B:51:0x00c0, B:52:0x00c4, B:39:0x0099, B:41:0x009d, B:43:0x00ab, B:45:0x00b1, B:53:0x00c9, B:54:0x00cb, B:55:0x00cc, B:56:0x00d1, B:14:0x0041, B:57:0x00d2), top: B:63:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b() {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oa5.b():java.lang.Object");
    }
}
