package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x65 implements Runnable {
    public final String A;
    public final Map X;
    public final Object Y;
    public final /* synthetic */ k70 Z;
    public final /* synthetic */ int b = 1;
    public final URL f;
    public final byte[] z;

    public x65(z65 z65Var, String str, URL url, byte[] bArr, Map map, v65 v65Var) {
        Objects.requireNonNull(z65Var);
        this.Z = z65Var;
        tj4.f(str);
        tj4.i(url);
        this.f = url;
        this.z = bArr;
        this.Y = v65Var;
        this.A = str;
        this.X = map;
    }

    public void a(int i, IOException iOException, byte[] bArr, Map map) {
        f85 f85Var = ((k85) ((mb5) this.Z).f).Z;
        k85.h(f85Var);
        f85Var.e1(new mf(this, i, iOException, bArr, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5 A[Catch: all -> 0x00f9, LOOP:0: B:40:0x00ef->B:42:0x00f5, LOOP_END, TryCatch #11 {all -> 0x00f9, blocks: (B:39:0x00ed, B:40:0x00ef, B:42:0x00f5, B:45:0x00fb), top: B:184:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0178  */
    /* JADX WARN: Type inference failed for: r24v0, types: [x65] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Map] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x65.run():void");
    }

    public x65(mb5 mb5Var, String str, URL url, byte[] bArr, HashMap map, lb5 lb5Var) {
        Objects.requireNonNull(mb5Var);
        this.Z = mb5Var;
        tj4.f(str);
        this.f = url;
        this.z = bArr;
        this.Y = lb5Var;
        this.A = str;
        this.X = map;
    }
}
