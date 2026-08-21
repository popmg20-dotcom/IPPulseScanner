package defpackage;

import android.content.ContentValues;
import android.net.Network;
import android.net.Uri;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y74 extends v74 implements Function2 {
    public LinearProgressIndicator A0;
    public InputStream B0;
    public Closeable C0;
    public OutputStream D0;
    public byte[] E0;
    public ah3 F0;
    public int G0;
    public int H0;
    public int I0;
    public final /* synthetic */ b84 J0;
    public final /* synthetic */ boolean K0;
    public final /* synthetic */ String L0;
    public final /* synthetic */ Network M0;
    public final /* synthetic */ LinearProgressIndicator N0;
    public ContentValues X;
    public Uri Y;
    public HttpURLConnection Z;
    public Long y0;
    public Closeable z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y74(b84 b84Var, boolean z, String str, Network network, LinearProgressIndicator linearProgressIndicator, ge0 ge0Var) {
        super(2, ge0Var);
        this.J0 = b84Var;
        this.K0 = z;
        this.L0 = str;
        this.M0 = network;
        this.N0 = linearProgressIndicator;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((y74) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new y74(this.J0, this.K0, this.L0, this.M0, this.N0, ge0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f7  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.String, java.lang.String[], java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01da -> B:96:0x01dd). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r31) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y74.p(java.lang.Object):java.lang.Object");
    }
}
