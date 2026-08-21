package defpackage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t81 extends v74 implements Function2 {
    public final /* synthetic */ u81 A0;
    public final /* synthetic */ ChannelHandlerContext B0;
    public final /* synthetic */ ArrayList C0;
    public String X;
    public Serializable Y;
    public ArrayList Z;
    public int y0;
    public final /* synthetic */ HttpPostRequestDecoder z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t81(HttpPostRequestDecoder httpPostRequestDecoder, u81 u81Var, ChannelHandlerContext channelHandlerContext, ArrayList arrayList, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = httpPostRequestDecoder;
        this.A0 = u81Var;
        this.B0 = channelHandlerContext;
        this.C0 = arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((t81) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new t81(this.z0, this.A0, this.B0, this.C0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        r4 = r4.get();
        r4.getClass();
        r10 = io.netty.util.CharsetUtil.UTF_8;
        r10.getClass();
        r11 = new java.lang.String(r4, r10);
        r4 = defpackage.p44.S0(r8, ".conf");
        r8 = defpackage.d73.g(r4).exists();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
    
        r10 = r21.A0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
    
        if (r8 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
    
        r0 = r21.B0;
        r3 = io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
        r3.getClass();
        r10.s(r0, r3, "Profile name already exists");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        r8 = defpackage.u81.N(r4, r11);
        r10 = r21.C0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
    
        if ((r8 instanceof defpackage.tk3) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
    
        r12 = new defpackage.e03[]{(defpackage.e03) r8};
        r21.X = r4;
        r21.Y = r8;
        r21.Z = r10;
        r21.y0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c3, code lost:
    
        if (defpackage.d73.j(r12, r21) != r3) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
    
        r9 = r4;
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0105, code lost:
    
        if (defpackage.d73.a(r4, r21) == r3) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: all -> 0x0018, Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:6:0x0013, B:53:0x0108, B:15:0x002a, B:41:0x00c8, B:42:0x00cb, B:18:0x0032, B:20:0x003a, B:22:0x0048, B:24:0x0050, B:26:0x005e, B:29:0x0072, B:31:0x0078, B:34:0x0099, B:35:0x00a6, B:37:0x00b0, B:48:0x00e6, B:50:0x00ee, B:44:0x00d5, B:47:0x00e2), top: B:68:0x000d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00ae -> B:42:0x00cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c6 -> B:41:0x00c8). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t81.p(java.lang.Object):java.lang.Object");
    }
}
