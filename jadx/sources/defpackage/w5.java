package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w5 implements n83 {
    public final /* synthetic */ int a;
    public static final w5 b = new w5(0);
    public static final w5 c = new w5(1);
    public static final w5 d = new w5(2);
    public static final w5 e = new w5(3);
    public static final w5 f = new w5(4);
    public static final w5 g = new w5(5);
    public static final w5 h = new w5(6);
    public static final w5 i = new w5(7);
    public static final w5 j = new w5(8);
    public static final w5 k = new w5(9);
    public static final w5 l = new w5(10);
    public static final w5 m = new w5(11);
    public static final w5 n = new w5(12);
    public static final w5 o = new w5(13);
    public static final w5 p = new w5(14);
    public static final w5 q = new w5(15);
    public static final w5 r = new w5(16);
    public static final w5 s = new w5(17);
    public static final w5 t = new w5(18);
    public static final w5 u = new w5(19);
    public static final w5 v = new w5(20);
    public static final w5 w = new w5(21);
    public static final w5 x = new w5(22);
    public static final w5 y = new w5(23);
    public static final w5 z = new w5(24);
    public static final w5 A = new w5(25);
    public static final w5 B = new w5(26);

    public /* synthetic */ w5(int i2) {
        this.a = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0143 A[PHI: r3
      0x0143: PHI (r3v19 k83) = (r3v13 k83), (r3v14 k83), (r3v15 k83), (r3v16 k83), (r3v17 k83) binds: [B:72:0x0141, B:75:0x014b, B:78:0x0154, B:81:0x015d, B:84:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.n83
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.l83 a(org.xmlpull.v1.XmlPullParser r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w5.a(org.xmlpull.v1.XmlPullParser):l83");
    }

    @Override // defpackage.n83
    public final k83 getName() {
        switch (this.a) {
            case 0:
                return x5.b;
            case 1:
                return b6.b;
            case 2:
                return d6.b;
            case 3:
                return fv.b;
            case 4:
                return gv.b;
            case 5:
                return hv.b;
            case 6:
                return mv.b;
            case 7:
                return bg0.b;
            case 8:
                return jg0.b;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return kg0.f;
            case 10:
                return tv0.b;
            case 11:
                return ro1.b;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return so1.b;
            case 13:
                return to1.b;
            case 14:
                return uo1.b;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return wo1.b;
            case 16:
                return dj2.b;
            case 17:
                return hj2.b;
            case 18:
                return lc3.b;
            case 19:
                return mc3.b;
            case 20:
                return ek3.b;
            case 21:
                return cq3.b;
            case 22:
                return m64.c;
            case 23:
                return n64.d;
            case 24:
                return m64.e;
            case 25:
                return m64.g;
            default:
                return h84.b;
        }
    }
}
