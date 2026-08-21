package defpackage;

import android.os.Build;
import android.util.Log;
import android.view.View;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.Iterator;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tf implements ag1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ tf(int i, Object obj, Object obj2) {
        this.b = i;
        this.z = obj2;
        this.f = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0395, code lost:
    
        if (r13.g(r1) == r6) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02af, code lost:
    
        if (r13.g(r1) == r6) goto L154;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0327  */
    /* JADX WARN: Type inference failed for: r13v0, types: [tf] */
    /* JADX WARN: Type inference failed for: r13v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r13v14, types: [wn2] */
    /* JADX WARN: Type inference failed for: r13v2, types: [wn2] */
    /* JADX WARN: Type inference failed for: r13v3, types: [wn2] */
    /* JADX WARN: Type inference failed for: r13v38, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v39 */
    /* JADX WARN: Type inference failed for: r13v65, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v66 */
    /* JADX WARN: Type inference failed for: r13v89 */
    /* JADX WARN: Type inference failed for: r13v90 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(ge0 ge0Var) {
        yy2 yy2Var;
        bz2 bz2Var;
        wn2 wn2Var;
        az2 az2Var;
        gd2 gd2VarO;
        lf0 lf0Var;
        lf0 lf0Var2;
        hd2 hd2Var;
        lf0 lf0Var3;
        gd2 gd2Var;
        bz2 bz2Var2;
        az2 az2Var2;
        hd2 hd2Var2;
        wn2 wn2Var2;
        az2 az2Var3;
        hd2 hd2Var3;
        hd2 hd2Var4;
        hd2 hd2Var5;
        as4 as4Var;
        az2 az2Var4;
        az2 az2Var5;
        lf0 lf0Var4;
        bz2 bz2Var3;
        wn2 wn2Var3;
        gd2 gd2Var2;
        az2 az2Var6;
        hd2 hd2Var6;
        az2 az2Var7;
        bz2 bz2Var4;
        wn2 wn2Var4;
        dz2 dz2Var;
        hd2 hd2Var7;
        gd2 gd2Var3;
        lf0 lf0Var5;
        az2 az2Var8;
        wn2 wn2Var5;
        hd2 hd2Var8;
        az2 az2Var9;
        bz2 bz2Var5;
        az2 az2Var10;
        hd2 hd2Var9;
        as4 as4Var2;
        az2 az2Var11;
        lf0 lf0Var6;
        gd2 gd2Var4;
        bz2 bz2Var6;
        wn2 wn2Var6;
        bz2 bz2Var7;
        wn2 wn2Var7;
        hd2 hd2Var10;
        dz2 dz2Var2;
        lf0 lf0Var7;
        az2 az2Var12;
        hd2 hd2Var11;
        bz2 bz2Var8;
        wn2 wn2Var8;
        az2 az2Var13;
        az2 az2Var14;
        hd2 hd2Var12;
        hd2 hd2Var13;
        as4 as4Var3;
        az2 az2Var15;
        az2 az2Var16;
        lf0 lf0Var8;
        az2 az2Var17;
        lf0 lf0Var9;
        bz2 bz2Var9;
        wn2 wn2Var9;
        fd2 fd2VarK;
        az2 az2Var18 = (az2) this.f;
        if (ge0Var instanceof yy2) {
            yy2Var = (yy2) ge0Var;
            int i = yy2Var.E0;
            if ((i & Integer.MIN_VALUE) != 0) {
                yy2Var.E0 = i - Integer.MIN_VALUE;
            } else {
                yy2Var = new yy2(this, ge0Var);
            }
        }
        Object obj = yy2Var.C0;
        int i2 = yy2Var.E0;
        hd2 hd2Var14 = hd2.b;
        mf0 mf0Var = mf0.b;
        try {
            try {
                try {
                    switch (i2) {
                        case 0:
                            n12.S(obj);
                            bz2Var = az2Var18.h;
                            wn2Var = bz2Var.a;
                            yy2Var.A = bz2Var;
                            yy2Var.X = az2Var18;
                            yy2Var.Y = wn2Var;
                            yy2Var.E0 = 1;
                            if (wn2Var.g(yy2Var) != mf0Var) {
                                az2Var = az2Var18;
                                try {
                                    dz2 dz2Var3 = bz2Var.b;
                                    gd2VarO = dz2Var3.j.O();
                                    dz2Var3.a((yr4) ((iv1) az2Var.e.f).A);
                                    wn2Var.n(null);
                                    lf0 lf0Var10 = (lf0) this.z;
                                    if (gd2VarO.a instanceof cd2) {
                                        lf0Var = lf0Var10;
                                        gd2Var2 = gd2VarO;
                                        if (gd2Var2.b instanceof cd2) {
                                        }
                                    } else {
                                        lf0Var2 = lf0Var10;
                                        hd2Var = hd2Var14;
                                        gd2Var = gd2VarO;
                                        if (xy2.a[hd2Var.ordinal()] == 1) {
                                            hd2Var4 = hd2Var;
                                            hd2Var5 = hd2Var4;
                                            as4Var = null;
                                            az2Var4 = az2Var18;
                                            yy2Var.A = gd2Var;
                                            yy2Var.X = az2Var18;
                                            yy2Var.Y = lf0Var2;
                                            yy2Var.Z = hd2Var4;
                                            yy2Var.y0 = null;
                                            yy2Var.z0 = null;
                                            yy2Var.A0 = null;
                                            yy2Var.B0 = null;
                                            yy2Var.E0 = 5;
                                            if (az2Var4.h(hd2Var5, as4Var, yy2Var) != mf0Var) {
                                                az2Var5 = az2Var18;
                                                lf0Var4 = lf0Var2;
                                                gd2VarO = gd2Var;
                                                if (hd2Var4 == hd2Var14) {
                                                    bz2Var3 = az2Var5.h;
                                                    wn2Var3 = bz2Var3.a;
                                                    yy2Var.A = gd2VarO;
                                                    yy2Var.X = az2Var5;
                                                    yy2Var.Y = lf0Var4;
                                                    yy2Var.Z = bz2Var3;
                                                    yy2Var.y0 = wn2Var3;
                                                    yy2Var.E0 = 6;
                                                }
                                                az2Var18 = az2Var5;
                                                lf0Var = lf0Var4;
                                                gd2Var2 = gd2VarO;
                                                if (gd2Var2.b instanceof cd2) {
                                                    az2Var6 = az2Var18;
                                                    if (gd2Var2.c instanceof cd2) {
                                                    }
                                                    return xl4.a;
                                                }
                                                bz2 bz2Var10 = az2Var18.h;
                                                yn2 yn2Var = bz2Var10.a;
                                                yy2Var.A = gd2Var2;
                                                yy2Var.X = az2Var18;
                                                yy2Var.Y = lf0Var;
                                                hd2Var6 = hd2.f;
                                                yy2Var.Z = hd2Var6;
                                                yy2Var.y0 = bz2Var10;
                                                yy2Var.z0 = yn2Var;
                                                yy2Var.E0 = 7;
                                                if (yn2Var.g(yy2Var) != mf0Var) {
                                                    az2Var7 = az2Var18;
                                                    bz2Var4 = bz2Var10;
                                                    wn2Var4 = yn2Var;
                                                    dz2Var = bz2Var4.b;
                                                    yy2Var.A = gd2Var2;
                                                    yy2Var.X = az2Var7;
                                                    yy2Var.Y = lf0Var;
                                                    yy2Var.Z = hd2Var6;
                                                    yy2Var.y0 = wn2Var4;
                                                    yy2Var.z0 = null;
                                                    yy2Var.E0 = 8;
                                                    if (az2Var7.j(dz2Var, hd2Var6, yy2Var) != mf0Var) {
                                                        hd2Var7 = hd2Var6;
                                                        gd2Var3 = gd2Var2;
                                                        lf0Var5 = lf0Var;
                                                        az2Var8 = az2Var7;
                                                        wn2Var4.n(null);
                                                        this = xy2.a[hd2Var7.ordinal()];
                                                        if (this != 1) {
                                                            hd2Var9 = hd2Var7;
                                                            as4Var2 = null;
                                                            az2Var11 = az2Var8;
                                                            yy2Var.A = gd2Var3;
                                                            yy2Var.X = az2Var8;
                                                            yy2Var.Y = lf0Var5;
                                                            yy2Var.Z = hd2Var9;
                                                            yy2Var.y0 = null;
                                                            yy2Var.z0 = null;
                                                            yy2Var.A0 = null;
                                                            yy2Var.B0 = null;
                                                            yy2Var.E0 = 10;
                                                            if (az2Var11.h(hd2Var7, as4Var2, yy2Var) != mf0Var) {
                                                                lf0Var6 = lf0Var5;
                                                                gd2Var4 = gd2Var3;
                                                                if (hd2Var9 == hd2Var14) {
                                                                    bz2Var6 = az2Var8.h;
                                                                    wn2Var6 = bz2Var6.a;
                                                                    yy2Var.A = gd2Var4;
                                                                    yy2Var.X = az2Var8;
                                                                    yy2Var.Y = lf0Var6;
                                                                    yy2Var.Z = bz2Var6;
                                                                    yy2Var.y0 = wn2Var6;
                                                                    yy2Var.E0 = 11;
                                                                    break;
                                                                }
                                                                gd2Var2 = gd2Var4;
                                                                az2Var6 = az2Var8;
                                                                lf0Var = lf0Var6;
                                                                if (gd2Var2.c instanceof cd2) {
                                                                    bz2Var7 = az2Var6.h;
                                                                    wn2Var7 = bz2Var7.a;
                                                                    yy2Var.A = az2Var6;
                                                                    yy2Var.X = lf0Var;
                                                                    hd2Var10 = hd2.z;
                                                                    yy2Var.Y = hd2Var10;
                                                                    yy2Var.Z = bz2Var7;
                                                                    yy2Var.y0 = wn2Var7;
                                                                    yy2Var.E0 = 12;
                                                                    if (wn2Var7.g(yy2Var) != mf0Var) {
                                                                        dz2Var2 = bz2Var7.b;
                                                                        yy2Var.A = az2Var6;
                                                                        yy2Var.X = lf0Var;
                                                                        yy2Var.Y = hd2Var10;
                                                                        yy2Var.Z = wn2Var7;
                                                                        yy2Var.y0 = null;
                                                                        yy2Var.E0 = 13;
                                                                        if (az2Var6.j(dz2Var2, hd2Var10, yy2Var) != mf0Var) {
                                                                            az2 az2Var19 = az2Var6;
                                                                            lf0Var7 = lf0Var;
                                                                            az2Var12 = az2Var19;
                                                                            hd2Var11 = hd2Var10;
                                                                            wn2Var7.n(null);
                                                                            this = xy2.a[hd2Var11.ordinal()];
                                                                            if (this != 1) {
                                                                                hd2Var13 = hd2Var11;
                                                                                as4Var3 = null;
                                                                                az2Var15 = az2Var12;
                                                                                yy2Var.A = az2Var12;
                                                                                yy2Var.X = lf0Var7;
                                                                                yy2Var.Y = hd2Var13;
                                                                                yy2Var.Z = null;
                                                                                yy2Var.y0 = null;
                                                                                yy2Var.z0 = null;
                                                                                yy2Var.A0 = null;
                                                                                yy2Var.E0 = 15;
                                                                                if (az2Var15.h(hd2Var11, as4Var3, yy2Var) != mf0Var) {
                                                                                    az2Var16 = az2Var12;
                                                                                    lf0Var8 = lf0Var7;
                                                                                    if (hd2Var13 == hd2Var14) {
                                                                                        bz2 bz2Var11 = az2Var16.h;
                                                                                        yn2 yn2Var2 = bz2Var11.a;
                                                                                        yy2Var.A = az2Var16;
                                                                                        yy2Var.X = lf0Var8;
                                                                                        yy2Var.Y = bz2Var11;
                                                                                        yy2Var.Z = yn2Var2;
                                                                                        yy2Var.E0 = 16;
                                                                                        if (yn2Var2.g(yy2Var) != mf0Var) {
                                                                                            az2Var17 = az2Var16;
                                                                                            lf0Var9 = lf0Var8;
                                                                                            bz2Var9 = bz2Var11;
                                                                                            wn2Var9 = yn2Var2;
                                                                                            try {
                                                                                                fd2VarK = bz2Var9.b.j.k(hd2Var14);
                                                                                                wn2Var9.n(null);
                                                                                                if (!(fd2VarK instanceof cd2)) {
                                                                                                    az2Var17.k(lf0Var9);
                                                                                                }
                                                                                            } finally {
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                bz2Var8 = az2Var12.h;
                                                                                wn2Var8 = bz2Var8.a;
                                                                                yy2Var.A = az2Var12;
                                                                                yy2Var.X = lf0Var7;
                                                                                yy2Var.Y = hd2Var11;
                                                                                yy2Var.Z = bz2Var8;
                                                                                yy2Var.y0 = wn2Var8;
                                                                                yy2Var.z0 = hd2Var11;
                                                                                yy2Var.A0 = az2Var12;
                                                                                yy2Var.E0 = 14;
                                                                                if (wn2Var8.g(yy2Var) != mf0Var) {
                                                                                    az2Var13 = az2Var12;
                                                                                    az2Var14 = az2Var13;
                                                                                    hd2Var12 = hd2Var11;
                                                                                    try {
                                                                                        as4Var3 = (as4) bz2Var8.b.i.get(hd2Var12);
                                                                                        wn2Var8.n(null);
                                                                                        az2Var15 = az2Var13;
                                                                                        hd2Var13 = hd2Var12;
                                                                                        az2Var12 = az2Var14;
                                                                                        yy2Var.A = az2Var12;
                                                                                        yy2Var.X = lf0Var7;
                                                                                        yy2Var.Y = hd2Var13;
                                                                                        yy2Var.Z = null;
                                                                                        yy2Var.y0 = null;
                                                                                        yy2Var.z0 = null;
                                                                                        yy2Var.A0 = null;
                                                                                        yy2Var.E0 = 15;
                                                                                        if (az2Var15.h(hd2Var11, as4Var3, yy2Var) != mf0Var) {
                                                                                        }
                                                                                    } finally {
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                return xl4.a;
                                                            }
                                                        } else {
                                                            bz2 bz2Var12 = az2Var8.h;
                                                            wn2Var5 = bz2Var12.a;
                                                            yy2Var.A = gd2Var3;
                                                            yy2Var.X = az2Var8;
                                                            yy2Var.Y = lf0Var5;
                                                            yy2Var.Z = hd2Var7;
                                                            yy2Var.y0 = bz2Var12;
                                                            yy2Var.z0 = wn2Var5;
                                                            yy2Var.A0 = hd2Var7;
                                                            yy2Var.B0 = az2Var8;
                                                            yy2Var.E0 = 9;
                                                            if (wn2Var5.g(yy2Var) != mf0Var) {
                                                                hd2Var8 = hd2Var7;
                                                                az2Var9 = az2Var8;
                                                                bz2Var5 = bz2Var12;
                                                                az2Var10 = az2Var9;
                                                                try {
                                                                    as4Var2 = (as4) bz2Var5.b.i.get(hd2Var8);
                                                                    wn2Var5.n(null);
                                                                    az2Var11 = az2Var10;
                                                                    hd2Var9 = hd2Var8;
                                                                    az2Var8 = az2Var9;
                                                                    yy2Var.A = gd2Var3;
                                                                    yy2Var.X = az2Var8;
                                                                    yy2Var.Y = lf0Var5;
                                                                    yy2Var.Z = hd2Var9;
                                                                    yy2Var.y0 = null;
                                                                    yy2Var.z0 = null;
                                                                    yy2Var.A0 = null;
                                                                    yy2Var.B0 = null;
                                                                    yy2Var.E0 = 10;
                                                                    if (az2Var11.h(hd2Var7, as4Var2, yy2Var) != mf0Var) {
                                                                    }
                                                                } finally {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        } else {
                                            bz2Var2 = az2Var18.h;
                                            yn2 yn2Var3 = bz2Var2.a;
                                            yy2Var.A = gd2Var;
                                            yy2Var.X = az2Var18;
                                            yy2Var.Y = lf0Var2;
                                            yy2Var.Z = hd2Var;
                                            yy2Var.y0 = bz2Var2;
                                            yy2Var.z0 = yn2Var3;
                                            yy2Var.A0 = hd2Var;
                                            yy2Var.B0 = az2Var18;
                                            yy2Var.E0 = 4;
                                            if (yn2Var3.g(yy2Var) != mf0Var) {
                                                az2Var2 = az2Var18;
                                                hd2Var2 = hd2Var;
                                                wn2Var2 = yn2Var3;
                                                az2Var3 = az2Var2;
                                                hd2Var3 = hd2Var2;
                                                try {
                                                    as4Var = (as4) bz2Var2.b.i.get(hd2Var2);
                                                    wn2Var2.n(null);
                                                    az2Var4 = az2Var3;
                                                    hd2Var5 = hd2Var3;
                                                    hd2Var4 = hd2Var2;
                                                    az2Var18 = az2Var2;
                                                    yy2Var.A = gd2Var;
                                                    yy2Var.X = az2Var18;
                                                    yy2Var.Y = lf0Var2;
                                                    yy2Var.Z = hd2Var4;
                                                    yy2Var.y0 = null;
                                                    yy2Var.z0 = null;
                                                    yy2Var.A0 = null;
                                                    yy2Var.B0 = null;
                                                    yy2Var.E0 = 5;
                                                    if (az2Var4.h(hd2Var5, as4Var, yy2Var) != mf0Var) {
                                                    }
                                                } finally {
                                                }
                                            }
                                        }
                                    }
                                } finally {
                                }
                            }
                            return mf0Var;
                        case 1:
                            wn2Var = (wn2) yy2Var.Y;
                            az2Var = (az2) yy2Var.X;
                            bz2Var = (bz2) yy2Var.A;
                            n12.S(obj);
                            dz2 dz2Var32 = bz2Var.b;
                            gd2VarO = dz2Var32.j.O();
                            dz2Var32.a((yr4) ((iv1) az2Var.e.f).A);
                            wn2Var.n(null);
                            lf0 lf0Var102 = (lf0) this.z;
                            if (gd2VarO.a instanceof cd2) {
                            }
                            break;
                        case 2:
                            wn2 wn2Var10 = (wn2) yy2Var.z0;
                            bz2 bz2Var13 = (bz2) yy2Var.y0;
                            hd2Var = (hd2) yy2Var.Z;
                            lf0Var3 = (lf0) yy2Var.Y;
                            az2 az2Var20 = (az2) yy2Var.X;
                            gd2 gd2Var5 = (gd2) yy2Var.A;
                            n12.S(obj);
                            dz2 dz2Var4 = bz2Var13.b;
                            yy2Var.A = gd2Var5;
                            yy2Var.X = az2Var20;
                            yy2Var.Y = lf0Var3;
                            yy2Var.Z = hd2Var;
                            yy2Var.y0 = wn2Var10;
                            yy2Var.z0 = null;
                            yy2Var.E0 = 3;
                            if (az2Var20.j(dz2Var4, hd2Var, yy2Var) != mf0Var) {
                                az2Var18 = az2Var20;
                                gd2VarO = gd2Var5;
                                this = wn2Var10;
                                this.n(null);
                                lf0Var2 = lf0Var3;
                                gd2Var = gd2VarO;
                                if (xy2.a[hd2Var.ordinal()] == 1) {
                                }
                            }
                            return mf0Var;
                        case 3:
                            wn2 wn2Var11 = (wn2) yy2Var.y0;
                            hd2 hd2Var15 = (hd2) yy2Var.Z;
                            lf0 lf0Var11 = (lf0) yy2Var.Y;
                            az2 az2Var21 = (az2) yy2Var.X;
                            gd2VarO = (gd2) yy2Var.A;
                            n12.S(obj);
                            hd2Var = hd2Var15;
                            az2Var18 = az2Var21;
                            lf0Var3 = lf0Var11;
                            this = wn2Var11;
                            this.n(null);
                            lf0Var2 = lf0Var3;
                            gd2Var = gd2VarO;
                            if (xy2.a[hd2Var.ordinal()] == 1) {
                            }
                            break;
                        case 4:
                            az2Var3 = yy2Var.B0;
                            hd2Var3 = (hd2) yy2Var.A0;
                            wn2Var2 = (wn2) yy2Var.z0;
                            bz2Var2 = (bz2) yy2Var.y0;
                            hd2Var2 = (hd2) yy2Var.Z;
                            lf0Var2 = (lf0) yy2Var.Y;
                            az2Var2 = (az2) yy2Var.X;
                            gd2Var = (gd2) yy2Var.A;
                            n12.S(obj);
                            as4Var = (as4) bz2Var2.b.i.get(hd2Var2);
                            wn2Var2.n(null);
                            az2Var4 = az2Var3;
                            hd2Var5 = hd2Var3;
                            hd2Var4 = hd2Var2;
                            az2Var18 = az2Var2;
                            yy2Var.A = gd2Var;
                            yy2Var.X = az2Var18;
                            yy2Var.Y = lf0Var2;
                            yy2Var.Z = hd2Var4;
                            yy2Var.y0 = null;
                            yy2Var.z0 = null;
                            yy2Var.A0 = null;
                            yy2Var.B0 = null;
                            yy2Var.E0 = 5;
                            if (az2Var4.h(hd2Var5, as4Var, yy2Var) != mf0Var) {
                            }
                            return mf0Var;
                        case 5:
                            hd2Var4 = (hd2) yy2Var.Z;
                            lf0 lf0Var12 = (lf0) yy2Var.Y;
                            az2 az2Var22 = (az2) yy2Var.X;
                            gd2 gd2Var6 = (gd2) yy2Var.A;
                            n12.S(obj);
                            gd2VarO = gd2Var6;
                            az2Var5 = az2Var22;
                            lf0Var4 = lf0Var12;
                            if (hd2Var4 == hd2Var14) {
                            }
                            az2Var18 = az2Var5;
                            lf0Var = lf0Var4;
                            gd2Var2 = gd2VarO;
                            if (gd2Var2.b instanceof cd2) {
                            }
                            break;
                        case 6:
                            wn2Var3 = (wn2) yy2Var.y0;
                            bz2Var3 = (bz2) yy2Var.Z;
                            lf0Var4 = (lf0) yy2Var.Y;
                            az2Var5 = (az2) yy2Var.X;
                            gd2VarO = (gd2) yy2Var.A;
                            n12.S(obj);
                            try {
                                fd2 fd2VarK2 = bz2Var3.b.j.k(hd2Var14);
                                wn2Var3.n(null);
                                if (!(fd2VarK2 instanceof cd2)) {
                                    az2Var5.k(lf0Var4);
                                }
                                az2Var18 = az2Var5;
                                lf0Var = lf0Var4;
                                gd2Var2 = gd2VarO;
                                if (gd2Var2.b instanceof cd2) {
                                }
                            } finally {
                            }
                            break;
                        case 7:
                            wn2Var4 = (wn2) yy2Var.z0;
                            bz2Var4 = (bz2) yy2Var.y0;
                            hd2Var6 = (hd2) yy2Var.Z;
                            lf0Var = (lf0) yy2Var.Y;
                            az2Var7 = (az2) yy2Var.X;
                            gd2Var2 = (gd2) yy2Var.A;
                            n12.S(obj);
                            dz2Var = bz2Var4.b;
                            yy2Var.A = gd2Var2;
                            yy2Var.X = az2Var7;
                            yy2Var.Y = lf0Var;
                            yy2Var.Z = hd2Var6;
                            yy2Var.y0 = wn2Var4;
                            yy2Var.z0 = null;
                            yy2Var.E0 = 8;
                            if (az2Var7.j(dz2Var, hd2Var6, yy2Var) != mf0Var) {
                            }
                            return mf0Var;
                        case 8:
                            wn2Var4 = (wn2) yy2Var.y0;
                            hd2Var7 = (hd2) yy2Var.Z;
                            lf0 lf0Var13 = (lf0) yy2Var.Y;
                            az2Var8 = (az2) yy2Var.X;
                            gd2 gd2Var7 = (gd2) yy2Var.A;
                            n12.S(obj);
                            lf0Var5 = lf0Var13;
                            gd2Var3 = gd2Var7;
                            wn2Var4.n(null);
                            this = xy2.a[hd2Var7.ordinal()];
                            if (this != 1) {
                            }
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            az2Var10 = yy2Var.B0;
                            hd2Var7 = (hd2) yy2Var.A0;
                            wn2Var5 = (wn2) yy2Var.z0;
                            bz2Var5 = (bz2) yy2Var.y0;
                            hd2Var8 = (hd2) yy2Var.Z;
                            lf0Var5 = (lf0) yy2Var.Y;
                            az2Var9 = (az2) yy2Var.X;
                            gd2Var3 = (gd2) yy2Var.A;
                            n12.S(obj);
                            as4Var2 = (as4) bz2Var5.b.i.get(hd2Var8);
                            wn2Var5.n(null);
                            az2Var11 = az2Var10;
                            hd2Var9 = hd2Var8;
                            az2Var8 = az2Var9;
                            yy2Var.A = gd2Var3;
                            yy2Var.X = az2Var8;
                            yy2Var.Y = lf0Var5;
                            yy2Var.Z = hd2Var9;
                            yy2Var.y0 = null;
                            yy2Var.z0 = null;
                            yy2Var.A0 = null;
                            yy2Var.B0 = null;
                            yy2Var.E0 = 10;
                            if (az2Var11.h(hd2Var7, as4Var2, yy2Var) != mf0Var) {
                            }
                            return mf0Var;
                        case 10:
                            hd2Var9 = (hd2) yy2Var.Z;
                            lf0 lf0Var14 = (lf0) yy2Var.Y;
                            az2 az2Var23 = (az2) yy2Var.X;
                            gd2 gd2Var8 = (gd2) yy2Var.A;
                            n12.S(obj);
                            gd2Var4 = gd2Var8;
                            az2Var8 = az2Var23;
                            lf0Var6 = lf0Var14;
                            if (hd2Var9 == hd2Var14) {
                            }
                            gd2Var2 = gd2Var4;
                            az2Var6 = az2Var8;
                            lf0Var = lf0Var6;
                            if (gd2Var2.c instanceof cd2) {
                            }
                            return xl4.a;
                        case 11:
                            wn2Var6 = (wn2) yy2Var.y0;
                            bz2Var6 = (bz2) yy2Var.Z;
                            lf0Var6 = (lf0) yy2Var.Y;
                            az2Var8 = (az2) yy2Var.X;
                            gd2Var4 = (gd2) yy2Var.A;
                            n12.S(obj);
                            try {
                                fd2 fd2VarK3 = bz2Var6.b.j.k(hd2Var14);
                                wn2Var6.n(null);
                                if (!(fd2VarK3 instanceof cd2)) {
                                    az2Var8.k(lf0Var6);
                                }
                                gd2Var2 = gd2Var4;
                                az2Var6 = az2Var8;
                                lf0Var = lf0Var6;
                                if (gd2Var2.c instanceof cd2) {
                                }
                                return xl4.a;
                            } finally {
                            }
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            wn2Var7 = (wn2) yy2Var.y0;
                            bz2Var7 = (bz2) yy2Var.Z;
                            hd2Var10 = (hd2) yy2Var.Y;
                            lf0Var = (lf0) yy2Var.X;
                            az2Var6 = (az2) yy2Var.A;
                            n12.S(obj);
                            dz2Var2 = bz2Var7.b;
                            yy2Var.A = az2Var6;
                            yy2Var.X = lf0Var;
                            yy2Var.Y = hd2Var10;
                            yy2Var.Z = wn2Var7;
                            yy2Var.y0 = null;
                            yy2Var.E0 = 13;
                            if (az2Var6.j(dz2Var2, hd2Var10, yy2Var) != mf0Var) {
                            }
                            return mf0Var;
                        case 13:
                            wn2Var7 = (wn2) yy2Var.Z;
                            hd2Var11 = (hd2) yy2Var.Y;
                            lf0 lf0Var15 = (lf0) yy2Var.X;
                            az2Var12 = (az2) yy2Var.A;
                            n12.S(obj);
                            lf0Var7 = lf0Var15;
                            wn2Var7.n(null);
                            this = xy2.a[hd2Var11.ordinal()];
                            if (this != 1) {
                            }
                            break;
                        case 14:
                            az2Var13 = (az2) yy2Var.A0;
                            hd2Var11 = (hd2) yy2Var.z0;
                            wn2Var8 = (wn2) yy2Var.y0;
                            bz2Var8 = (bz2) yy2Var.Z;
                            hd2Var12 = (hd2) yy2Var.Y;
                            lf0Var7 = (lf0) yy2Var.X;
                            az2Var14 = (az2) yy2Var.A;
                            n12.S(obj);
                            as4Var3 = (as4) bz2Var8.b.i.get(hd2Var12);
                            wn2Var8.n(null);
                            az2Var15 = az2Var13;
                            hd2Var13 = hd2Var12;
                            az2Var12 = az2Var14;
                            yy2Var.A = az2Var12;
                            yy2Var.X = lf0Var7;
                            yy2Var.Y = hd2Var13;
                            yy2Var.Z = null;
                            yy2Var.y0 = null;
                            yy2Var.z0 = null;
                            yy2Var.A0 = null;
                            yy2Var.E0 = 15;
                            if (az2Var15.h(hd2Var11, as4Var3, yy2Var) != mf0Var) {
                            }
                            return mf0Var;
                        case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                            hd2Var13 = (hd2) yy2Var.Y;
                            lf0Var8 = (lf0) yy2Var.X;
                            az2Var16 = (az2) yy2Var.A;
                            n12.S(obj);
                            if (hd2Var13 == hd2Var14) {
                            }
                            return xl4.a;
                        case 16:
                            wn2Var9 = (wn2) yy2Var.Z;
                            bz2Var9 = (bz2) yy2Var.Y;
                            lf0Var9 = (lf0) yy2Var.X;
                            az2Var17 = (az2) yy2Var.A;
                            n12.S(obj);
                            fd2VarK = bz2Var9.b.j.k(hd2Var14);
                            wn2Var9.n(null);
                            if (!(fd2VarK instanceof cd2)) {
                            }
                            return xl4.a;
                        default:
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0183, code lost:
    
        if (defpackage.ye.r(r4, r12, r8) == r6) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0192, code lost:
    
        if (r9.h(r13, r8) != r6) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        sf sfVar;
        ag1 ag1Var;
        b80 b80Var;
        b80 b80Var2;
        ag1 ag1Var2;
        Map map;
        uh1 uh1Var;
        Object next;
        int i = this.b;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 0:
                m24 m24Var = ((vf) obj2).c;
                if (ge0Var instanceof sf) {
                    sfVar = (sf) ge0Var;
                    int i2 = sfVar.X;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        sfVar.X = i2 - Integer.MIN_VALUE;
                    } else {
                        sfVar = new sf(this, ge0Var);
                    }
                }
                Object obj4 = sfVar.A;
                int i3 = sfVar.X;
                if (i3 == 0) {
                    n12.S(obj4);
                    ag1Var = (ag1) obj3;
                    b80Var = (b80) obj;
                    if (!((Boolean) m24Var.i()).booleanValue()) {
                        sfVar.Z = null;
                        sfVar.y0 = null;
                        sfVar.X = 3;
                        break;
                    } else {
                        sfVar.Z = b80Var;
                        sfVar.y0 = ag1Var;
                        sfVar.X = 1;
                        if (vf2.E(sfVar) != mf0Var) {
                            b80Var2 = b80Var;
                            ag1Var2 = ag1Var;
                        }
                    }
                    return mf0Var;
                }
                if (i3 == 1) {
                    ag1Var2 = sfVar.y0;
                    b80Var2 = sfVar.Z;
                    n12.S(obj4);
                } else {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            n12.S(obj4);
                            return xl4Var;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ag1Var2 = sfVar.y0;
                    b80Var2 = sfVar.Z;
                    n12.S(obj4);
                    ag1Var = ag1Var2;
                    b80Var = b80Var2;
                    sfVar.Z = null;
                    sfVar.y0 = null;
                    sfVar.X = 3;
                }
                break;
                pf pfVar = new pf(2, null);
                sfVar.Z = b80Var2;
                sfVar.y0 = ag1Var2;
                sfVar.X = 2;
                break;
            case 1:
                e03 e03Var = (e03) obj;
                Object obj5 = e03Var.b;
                Object obj6 = e03Var.f;
                p10 p10Var = ((ek) obj3).b;
                if (obj5 == p10Var && (p10Var != p10.X || !((Boolean) obj6).booleanValue() || ((map = (Map) ws4.f.d()) != null && !map.isEmpty()))) {
                    Object parent = ((View) obj2).getParent();
                    parent.getClass();
                    ((View) parent).setVisibility(((Boolean) obj6).booleanValue() ? 0 : 8);
                }
                return xl4Var;
            case 2:
                if (ge0Var instanceof uh1) {
                    uh1Var = (uh1) ge0Var;
                    int i4 = uh1Var.X;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        uh1Var.X = i4 - Integer.MIN_VALUE;
                    } else {
                        uh1Var = new uh1(this, ge0Var);
                    }
                }
                Object obj7 = uh1Var.A;
                int i5 = uh1Var.X;
                if (i5 == 0) {
                    n12.S(obj7);
                    ag1 ag1Var3 = (ag1) obj3;
                    ((vh1) obj2).getClass();
                    Iterator it = ((iv4) obj).a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (((cr1) next) instanceof cr1) {
                            }
                        } else {
                            next = null;
                        }
                    }
                    cr1 cr1Var = next instanceof cr1 ? (cr1) next : null;
                    if (cr1Var != null) {
                        uh1Var.X = 1;
                        if (ag1Var3.h(cr1Var, uh1Var) == mf0Var) {
                            return mf0Var;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj7);
                }
                return xl4Var;
            case 3:
                Object objD = ((az2) obj3).d((hd2) obj2, (do1) obj, ge0Var);
                return objD == mf0Var ? objD : xl4Var;
            case 4:
                return a(ge0Var);
            case 5:
                jy2 jy2Var = (jy2) obj;
                ge0 ge0Var2 = null;
                if (Build.ID != null && Log.isLoggable("Paging", 2)) {
                    Log.v("Paging", "Collected " + jy2Var, null);
                }
                rf rfVar = (rf) obj3;
                Object objB0 = ji0.b0(rfVar.a, new uf(jy2Var, rfVar, (kz2) obj2, ge0Var2, 16), ge0Var);
                return objB0 == mf0Var ? objB0 : xl4Var;
            default:
                ((zu2) obj3).a((gx4) obj2, (qc0) obj);
                return xl4Var;
        }
    }
}
