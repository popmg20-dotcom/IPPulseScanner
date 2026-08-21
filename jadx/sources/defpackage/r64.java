package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r64 {
    public final fa5 B;
    public final hs1 C;
    public final mc1 D;
    public final String k;
    public final bw l;
    public final sy m;
    public final zf2 n;
    public final int o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public ph w;
    public final sv0 y;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final HashMap g = new HashMap();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();
    public final ArrayList x = new ArrayList();
    public final q84 z = new q84(1);
    public final oj1 A = new oj1((byte) 0, 24);

    public r64(Context context, String str, pz pzVar, bw bwVar, mc1 mc1Var) throws e00 {
        boolean z;
        List listSingletonList;
        int[] iArr;
        boolean z2;
        this.p = false;
        this.q = false;
        this.t = false;
        this.u = false;
        str.getClass();
        this.k = str;
        bwVar.getClass();
        this.l = bwVar;
        this.n = new zf2(24);
        this.y = sv0.b(context);
        try {
            sy syVarB = pzVar.b(str);
            this.m = syVarB;
            Integer num = (Integer) syVarB.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.o = num != null ? num.intValue() : 2;
            int[] iArr2 = (int[]) syVarB.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr2 != null) {
                for (int i : iArr2) {
                    if (i == 3) {
                        this.p = true;
                    } else if (i == 6) {
                        this.q = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i == 16) {
                        this.t = true;
                    } else if (i == 1) {
                        this.u = true;
                    }
                }
            }
            fa5 fa5Var = new fa5(this.m);
            this.B = fa5Var;
            this.C = new hs1(this.m);
            ArrayList arrayList = this.a;
            int i2 = this.o;
            boolean z3 = this.p;
            boolean z4 = this.q;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            s64 s64Var = new s64();
            t64 t64Var = t64.MAXIMUM;
            d44 d44Var = w64.e;
            t64Var.getClass();
            d44 d44Var2 = w64.e;
            v64 v64Var = v64.b;
            s64 s64VarX = dw2.x(s64Var, tj4.r(v64Var, t64Var, d44Var2), arrayList3, s64Var);
            v64 v64Var2 = v64.z;
            s64 s64VarX2 = dw2.x(s64VarX, tj4.r(v64Var2, t64Var, d44Var2), arrayList3, s64VarX);
            v64 v64Var3 = v64.f;
            s64 s64VarX3 = dw2.x(s64VarX2, tj4.r(v64Var3, t64Var, d44Var2), arrayList3, s64VarX2);
            t64 t64Var2 = t64.PREVIEW;
            t64Var2.getClass();
            s64VarX3.a(tj4.r(v64Var, t64Var2, d44Var2));
            s64 s64VarX4 = dw2.x(s64VarX3, tj4.r(v64Var2, t64Var, d44Var2), arrayList3, s64VarX3);
            dw2.E(s64VarX4, tj4.r(v64Var3, t64Var2, d44Var2), v64Var2, t64Var, d44Var2);
            s64 s64VarY = dw2.y(arrayList3, s64VarX4);
            dw2.E(s64VarY, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var2, d44Var2);
            s64 s64VarY2 = dw2.y(arrayList3, s64VarY);
            dw2.E(s64VarY2, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var2, d44Var2);
            s64 s64VarY3 = dw2.y(arrayList3, s64VarY2);
            dw2.E(s64VarY3, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var2, d44Var2);
            s64VarY3.a(tj4.r(v64Var2, t64Var, d44Var2));
            arrayList3.add(s64VarY3);
            arrayList2.addAll(arrayList3);
            if (i2 == 0 || i2 == 4 || i2 == 1 || i2 == 3) {
                ArrayList arrayList4 = new ArrayList();
                s64 s64Var2 = new s64();
                s64Var2.a(tj4.r(v64Var, t64Var2, d44Var2));
                t64 t64Var3 = t64.RECORD;
                t64Var3.getClass();
                z = z3;
                s64Var2.a(tj4.r(v64Var, t64Var3, d44Var2));
                s64 s64VarY4 = dw2.y(arrayList4, s64Var2);
                dw2.E(s64VarY4, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var3, d44Var2);
                s64 s64VarY5 = dw2.y(arrayList4, s64VarY4);
                dw2.E(s64VarY5, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var3, d44Var2);
                s64 s64VarY6 = dw2.y(arrayList4, s64VarY5);
                dw2.E(s64VarY6, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var3, d44Var2);
                s64 s64VarX5 = dw2.x(s64VarY6, tj4.r(v64Var2, t64Var3, d44Var2), arrayList4, s64VarY6);
                dw2.E(s64VarX5, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var3, d44Var2);
                s64 s64VarX6 = dw2.x(s64VarX5, tj4.r(v64Var2, t64Var3, d44Var2), arrayList4, s64VarX5);
                dw2.E(s64VarX6, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var2, d44Var2);
                s64VarX6.a(tj4.r(v64Var2, t64Var, d44Var2));
                arrayList4.add(s64VarX6);
                arrayList2.addAll(arrayList4);
            } else {
                z = z3;
            }
            if (i2 == 1 || i2 == 3) {
                ArrayList arrayList5 = new ArrayList();
                s64 s64Var3 = new s64();
                dw2.E(s64Var3, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var, d44Var2);
                s64 s64VarY7 = dw2.y(arrayList5, s64Var3);
                dw2.E(s64VarY7, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY8 = dw2.y(arrayList5, s64VarY7);
                dw2.E(s64VarY8, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY9 = dw2.y(arrayList5, s64VarY8);
                dw2.E(s64VarY9, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX7 = dw2.x(s64VarY9, tj4.r(v64Var2, t64Var, d44Var2), arrayList5, s64VarY9);
                t64 t64Var4 = t64.VGA;
                t64Var4.getClass();
                s64VarX7.a(tj4.r(v64Var3, t64Var4, d44Var2));
                dw2.E(s64VarX7, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY10 = dw2.y(arrayList5, s64VarX7);
                dw2.E(s64VarY10, tj4.r(v64Var3, t64Var4, d44Var2), v64Var3, t64Var2, d44Var2);
                s64VarY10.a(tj4.r(v64Var3, t64Var, d44Var2));
                arrayList5.add(s64VarY10);
                arrayList2.addAll(arrayList5);
            }
            v64 v64Var4 = v64.X;
            if (z) {
                ArrayList arrayList6 = new ArrayList();
                s64 s64Var4 = new s64();
                s64 s64VarX8 = dw2.x(s64Var4, tj4.r(v64Var4, t64Var, d44Var2), arrayList6, s64Var4);
                dw2.E(s64VarX8, tj4.r(v64Var, t64Var2, d44Var2), v64Var4, t64Var, d44Var2);
                s64 s64VarY11 = dw2.y(arrayList6, s64VarX8);
                dw2.E(s64VarY11, tj4.r(v64Var3, t64Var2, d44Var2), v64Var4, t64Var, d44Var2);
                s64 s64VarY12 = dw2.y(arrayList6, s64VarY11);
                dw2.E(s64VarY12, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX9 = dw2.x(s64VarY12, tj4.r(v64Var4, t64Var, d44Var2), arrayList6, s64VarY12);
                dw2.E(s64VarX9, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var2, d44Var2);
                s64 s64VarX10 = dw2.x(s64VarX9, tj4.r(v64Var4, t64Var, d44Var2), arrayList6, s64VarX9);
                dw2.E(s64VarX10, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var2, d44Var2);
                s64 s64VarX11 = dw2.x(s64VarX10, tj4.r(v64Var4, t64Var, d44Var2), arrayList6, s64VarX10);
                dw2.E(s64VarX11, tj4.r(v64Var, t64Var2, d44Var2), v64Var2, t64Var, d44Var2);
                s64 s64VarX12 = dw2.x(s64VarX11, tj4.r(v64Var4, t64Var, d44Var2), arrayList6, s64VarX11);
                dw2.E(s64VarX12, tj4.r(v64Var3, t64Var2, d44Var2), v64Var2, t64Var, d44Var2);
                s64VarX12.a(tj4.r(v64Var4, t64Var, d44Var2));
                arrayList6.add(s64VarX12);
                arrayList2.addAll(arrayList6);
            }
            if (z4 && i2 == 0) {
                ArrayList arrayList7 = new ArrayList();
                s64 s64Var5 = new s64();
                dw2.E(s64Var5, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var, d44Var2);
                s64 s64VarY13 = dw2.y(arrayList7, s64Var5);
                dw2.E(s64VarY13, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY14 = dw2.y(arrayList7, s64VarY13);
                dw2.E(s64VarY14, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                arrayList7.add(s64VarY14);
                arrayList2.addAll(arrayList7);
            }
            if (i2 == 3) {
                ArrayList arrayList8 = new ArrayList();
                s64 s64Var6 = new s64();
                s64Var6.a(tj4.r(v64Var, t64Var2, d44Var2));
                t64 t64Var5 = t64.VGA;
                t64Var5.getClass();
                s64Var6.a(tj4.r(v64Var, t64Var5, d44Var2));
                dw2.E(s64Var6, tj4.r(v64Var3, t64Var, d44Var2), v64Var4, t64Var, d44Var2);
                s64 s64VarY15 = dw2.y(arrayList8, s64Var6);
                dw2.E(s64VarY15, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var5, d44Var2);
                dw2.E(s64VarY15, tj4.r(v64Var2, t64Var, d44Var2), v64Var4, t64Var, d44Var2);
                arrayList8.add(s64VarY15);
                arrayList2.addAll(arrayList8);
            }
            arrayList.addAll(arrayList2);
            zf2 zf2Var = this.n;
            String str2 = this.k;
            if (((ExtraSupportedSurfaceCombinationsQuirk) zf2Var.f) == null) {
                listSingletonList = new ArrayList();
            } else {
                s64 s64Var7 = ExtraSupportedSurfaceCombinationsQuirk.a;
                String str3 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str3) || "heroqltetmo".equalsIgnoreCase(str3)) {
                    ArrayList arrayList9 = new ArrayList();
                    listSingletonList = arrayList9;
                    if (str2.equals("1")) {
                        arrayList9.add(ExtraSupportedSurfaceCombinationsQuirk.a);
                        listSingletonList = arrayList9;
                    }
                } else {
                    listSingletonList = ((!"google".equalsIgnoreCase(Build.BRAND) ? false : ExtraSupportedSurfaceCombinationsQuirk.c.contains(Build.MODEL.toUpperCase(Locale.US))) || ExtraSupportedSurfaceCombinationsQuirk.b()) ? Collections.singletonList(ExtraSupportedSurfaceCombinationsQuirk.b) : Collections.EMPTY_LIST;
                }
            }
            arrayList.addAll(listSingletonList);
            if (this.t) {
                ArrayList arrayList10 = this.b;
                ArrayList arrayList11 = new ArrayList();
                s64 s64Var8 = new s64();
                t64 t64Var6 = t64.ULTRA_MAXIMUM;
                t64Var6.getClass();
                s64Var8.a(tj4.r(v64Var3, t64Var6, d44Var2));
                s64Var8.a(tj4.r(v64Var, t64Var2, d44Var2));
                t64 t64Var7 = t64.RECORD;
                t64Var7.getClass();
                s64Var8.a(tj4.r(v64Var, t64Var7, d44Var2));
                s64 s64VarY16 = dw2.y(arrayList11, s64Var8);
                dw2.E(s64VarY16, tj4.r(v64Var2, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX13 = dw2.x(s64VarY16, tj4.r(v64Var, t64Var7, d44Var2), arrayList11, s64VarY16);
                dw2.E(s64VarX13, tj4.r(v64Var4, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX14 = dw2.x(s64VarX13, tj4.r(v64Var, t64Var7, d44Var2), arrayList11, s64VarX13);
                dw2.E(s64VarX14, tj4.r(v64Var3, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX15 = dw2.x(s64VarX14, tj4.r(v64Var2, t64Var, d44Var2), arrayList11, s64VarX14);
                dw2.E(s64VarX15, tj4.r(v64Var2, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX16 = dw2.x(s64VarX15, tj4.r(v64Var2, t64Var, d44Var2), arrayList11, s64VarX15);
                dw2.E(s64VarX16, tj4.r(v64Var4, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX17 = dw2.x(s64VarX16, tj4.r(v64Var2, t64Var, d44Var2), arrayList11, s64VarX16);
                dw2.E(s64VarX17, tj4.r(v64Var3, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX18 = dw2.x(s64VarX17, tj4.r(v64Var3, t64Var, d44Var2), arrayList11, s64VarX17);
                dw2.E(s64VarX18, tj4.r(v64Var2, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX19 = dw2.x(s64VarX18, tj4.r(v64Var3, t64Var, d44Var2), arrayList11, s64VarX18);
                dw2.E(s64VarX19, tj4.r(v64Var4, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX20 = dw2.x(s64VarX19, tj4.r(v64Var3, t64Var, d44Var2), arrayList11, s64VarX19);
                dw2.E(s64VarX20, tj4.r(v64Var3, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX21 = dw2.x(s64VarX20, tj4.r(v64Var4, t64Var, d44Var2), arrayList11, s64VarX20);
                dw2.E(s64VarX21, tj4.r(v64Var2, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64 s64VarX22 = dw2.x(s64VarX21, tj4.r(v64Var4, t64Var, d44Var2), arrayList11, s64VarX21);
                dw2.E(s64VarX22, tj4.r(v64Var4, t64Var6, d44Var2), v64Var, t64Var2, d44Var2);
                s64VarX22.a(tj4.r(v64Var4, t64Var, d44Var2));
                arrayList11.add(s64VarX22);
                arrayList10.addAll(arrayList11);
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.r = zHasSystemFeature;
            if (zHasSystemFeature) {
                ArrayList arrayList12 = this.c;
                ArrayList arrayList13 = new ArrayList();
                s64 s64Var9 = new s64();
                t64 t64Var8 = t64.S1440P_4_3;
                t64Var8.getClass();
                s64Var9.a(tj4.r(v64Var3, t64Var8, d44Var2));
                s64 s64VarY17 = dw2.y(arrayList13, s64Var9);
                s64 s64VarX23 = dw2.x(s64VarY17, tj4.r(v64Var, t64Var8, d44Var2), arrayList13, s64VarY17);
                s64 s64VarX24 = dw2.x(s64VarX23, tj4.r(v64Var2, t64Var8, d44Var2), arrayList13, s64VarX23);
                t64 t64Var9 = t64.S720P_16_9;
                t64Var9.getClass();
                s64VarX24.a(tj4.r(v64Var3, t64Var9, d44Var2));
                s64 s64VarX25 = dw2.x(s64VarX24, tj4.r(v64Var2, t64Var8, d44Var2), arrayList13, s64VarX24);
                dw2.E(s64VarX25, tj4.r(v64Var, t64Var9, d44Var2), v64Var2, t64Var8, d44Var2);
                s64 s64VarY18 = dw2.y(arrayList13, s64VarX25);
                dw2.E(s64VarY18, tj4.r(v64Var3, t64Var9, d44Var2), v64Var3, t64Var8, d44Var2);
                s64 s64VarY19 = dw2.y(arrayList13, s64VarY18);
                dw2.E(s64VarY19, tj4.r(v64Var3, t64Var9, d44Var2), v64Var, t64Var8, d44Var2);
                s64 s64VarY20 = dw2.y(arrayList13, s64VarY19);
                dw2.E(s64VarY20, tj4.r(v64Var, t64Var9, d44Var2), v64Var3, t64Var8, d44Var2);
                s64 s64VarY21 = dw2.y(arrayList13, s64VarY20);
                dw2.E(s64VarY21, tj4.r(v64Var, t64Var9, d44Var2), v64Var, t64Var8, d44Var2);
                arrayList13.add(s64VarY21);
                arrayList12.addAll(arrayList13);
            }
            if (fa5Var.b) {
                ArrayList arrayList14 = this.h;
                ArrayList arrayList15 = new ArrayList();
                s64 s64Var10 = new s64();
                s64 s64VarX26 = dw2.x(s64Var10, tj4.r(v64Var, t64Var, d44Var2), arrayList15, s64Var10);
                s64 s64VarX27 = dw2.x(s64VarX26, tj4.r(v64Var3, t64Var, d44Var2), arrayList15, s64VarX26);
                dw2.E(s64VarX27, tj4.r(v64Var, t64Var2, d44Var2), v64Var2, t64Var, d44Var2);
                s64 s64VarY22 = dw2.y(arrayList15, s64VarX27);
                dw2.E(s64VarY22, tj4.r(v64Var, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY23 = dw2.y(arrayList15, s64VarY22);
                dw2.E(s64VarY23, tj4.r(v64Var3, t64Var2, d44Var2), v64Var3, t64Var, d44Var2);
                s64 s64VarY24 = dw2.y(arrayList15, s64VarY23);
                s64VarY24.a(tj4.r(v64Var, t64Var2, d44Var2));
                t64 t64Var10 = t64.RECORD;
                t64Var10.getClass();
                s64VarY24.a(tj4.r(v64Var, t64Var10, d44Var2));
                s64 s64VarY25 = dw2.y(arrayList15, s64VarY24);
                dw2.E(s64VarY25, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var10, d44Var2);
                s64 s64VarX28 = dw2.x(s64VarY25, tj4.r(v64Var3, t64Var10, d44Var2), arrayList15, s64VarY25);
                dw2.E(s64VarX28, tj4.r(v64Var, t64Var2, d44Var2), v64Var, t64Var10, d44Var2);
                s64VarX28.a(tj4.r(v64Var2, t64Var10, d44Var2));
                arrayList15.add(s64VarX28);
                arrayList14.addAll(arrayList15);
            }
            boolean zD = e44.d(this.m);
            this.s = zD;
            if (zD && Build.VERSION.SDK_INT >= 33) {
                ArrayList arrayList16 = this.j;
                ArrayList arrayList17 = new ArrayList();
                s64 s64Var11 = new s64();
                t64 t64Var11 = t64.S1440P_4_3;
                d44 d44Var3 = d44.PREVIEW_VIDEO_STILL;
                s64 s64VarX29 = dw2.x(s64Var11, tj4.r(v64Var, t64Var11, d44Var3), arrayList17, s64Var11);
                s64 s64VarX30 = dw2.x(s64VarX29, tj4.r(v64Var3, t64Var11, d44Var3), arrayList17, s64VarX29);
                t64 t64Var12 = t64.RECORD;
                d44 d44Var4 = d44.VIDEO_RECORD;
                s64 s64VarX31 = dw2.x(s64VarX30, tj4.r(v64Var, t64Var12, d44Var4), arrayList17, s64VarX30);
                s64 s64VarX32 = dw2.x(s64VarX31, tj4.r(v64Var3, t64Var12, d44Var4), arrayList17, s64VarX31);
                d44 d44Var5 = d44.STILL_CAPTURE;
                s64 s64VarX33 = dw2.x(s64VarX32, tj4.r(v64Var2, t64Var, d44Var5), arrayList17, s64VarX32);
                s64 s64VarX34 = dw2.x(s64VarX33, tj4.r(v64Var3, t64Var, d44Var5), arrayList17, s64VarX33);
                d44 d44Var6 = d44.PREVIEW;
                dw2.E(s64VarX34, tj4.r(v64Var, t64Var2, d44Var6), v64Var2, t64Var, d44Var5);
                s64 s64VarY26 = dw2.y(arrayList17, s64VarX34);
                dw2.E(s64VarY26, tj4.r(v64Var, t64Var2, d44Var6), v64Var3, t64Var, d44Var5);
                s64 s64VarY27 = dw2.y(arrayList17, s64VarY26);
                dw2.E(s64VarY27, tj4.r(v64Var, t64Var2, d44Var6), v64Var, t64Var12, d44Var4);
                s64 s64VarY28 = dw2.y(arrayList17, s64VarY27);
                dw2.E(s64VarY28, tj4.r(v64Var, t64Var2, d44Var6), v64Var3, t64Var12, d44Var4);
                s64 s64VarY29 = dw2.y(arrayList17, s64VarY28);
                dw2.E(s64VarY29, tj4.r(v64Var, t64Var2, d44Var6), v64Var3, t64Var2, d44Var6);
                s64 s64VarY30 = dw2.y(arrayList17, s64VarY29);
                dw2.E(s64VarY30, tj4.r(v64Var, t64Var2, d44Var6), v64Var, t64Var12, d44Var4);
                s64 s64VarX35 = dw2.x(s64VarY30, tj4.r(v64Var2, t64Var12, d44Var5), arrayList17, s64VarY30);
                dw2.E(s64VarX35, tj4.r(v64Var, t64Var2, d44Var6), v64Var3, t64Var12, d44Var4);
                s64 s64VarX36 = dw2.x(s64VarX35, tj4.r(v64Var2, t64Var12, d44Var5), arrayList17, s64VarX35);
                dw2.E(s64VarX36, tj4.r(v64Var, t64Var2, d44Var6), v64Var3, t64Var2, d44Var6);
                s64VarX36.a(tj4.r(v64Var2, t64Var, d44Var5));
                arrayList17.add(s64VarX36);
                arrayList16.addAll(arrayList17);
            }
            sy syVar = this.m;
            if (Build.VERSION.SDK_INT < 33 || (iArr = (int[]) syVar.a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) == null || iArr.length == 0) {
                z2 = false;
            } else {
                for (int i3 : iArr) {
                    if (i3 == 2) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            this.v = z2;
            if (z2 && Build.VERSION.SDK_INT >= 33) {
                ArrayList arrayList18 = this.d;
                ArrayList arrayList19 = new ArrayList();
                s64 s64Var12 = new s64();
                t64 t64Var13 = t64.S1440P_4_3;
                t64Var13.getClass();
                d44 d44Var7 = w64.e;
                s64 s64VarX37 = dw2.x(s64Var12, tj4.r(v64Var, t64Var13, d44Var7), arrayList19, s64Var12);
                s64 s64VarX38 = dw2.x(s64VarX37, tj4.r(v64Var3, t64Var13, d44Var7), arrayList19, s64VarX37);
                s64VarX38.a(tj4.r(v64Var, t64Var13, d44Var7));
                t64 t64Var14 = t64.MAXIMUM;
                t64Var14.getClass();
                s64VarX38.a(tj4.r(v64Var2, t64Var14, d44Var7));
                s64 s64VarY31 = dw2.y(arrayList19, s64VarX38);
                dw2.E(s64VarY31, tj4.r(v64Var3, t64Var13, d44Var7), v64Var2, t64Var14, d44Var7);
                s64 s64VarY32 = dw2.y(arrayList19, s64VarY31);
                dw2.E(s64VarY32, tj4.r(v64Var, t64Var13, d44Var7), v64Var3, t64Var14, d44Var7);
                s64 s64VarY33 = dw2.y(arrayList19, s64VarY32);
                dw2.E(s64VarY33, tj4.r(v64Var3, t64Var13, d44Var7), v64Var3, t64Var14, d44Var7);
                s64 s64VarY34 = dw2.y(arrayList19, s64VarY33);
                t64 t64Var15 = t64.PREVIEW;
                t64Var15.getClass();
                s64VarY34.a(tj4.r(v64Var, t64Var15, d44Var7));
                s64 s64VarX39 = dw2.x(s64VarY34, tj4.r(v64Var, t64Var13, d44Var7), arrayList19, s64VarY34);
                dw2.E(s64VarX39, tj4.r(v64Var3, t64Var15, d44Var7), v64Var, t64Var13, d44Var7);
                s64 s64VarY35 = dw2.y(arrayList19, s64VarX39);
                dw2.E(s64VarY35, tj4.r(v64Var, t64Var15, d44Var7), v64Var3, t64Var13, d44Var7);
                s64 s64VarY36 = dw2.y(arrayList19, s64VarY35);
                dw2.E(s64VarY36, tj4.r(v64Var3, t64Var15, d44Var7), v64Var3, t64Var13, d44Var7);
                arrayList19.add(s64VarY36);
                arrayList18.addAll(arrayList19);
            }
            c();
            this.D = mc1Var;
        } catch (xx e) {
            throw new e00(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Range d(android.util.Range r13, int r14, android.util.Range[] r15) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r64.d(android.util.Range, int, android.util.Range[]):android.util.Range");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Size f(android.hardware.camera2.params.StreamConfigurationMap r8, int r9, boolean r10, android.util.Rational r11) {
        /*
            r0 = 34
            r1 = 0
            if (r9 != r0) goto Lc
            java.lang.Class<android.graphics.SurfaceTexture> r0 = android.graphics.SurfaceTexture.class
            android.util.Size[] r0 = r8.getOutputSizes(r0)     // Catch: java.lang.Throwable -> L11
            goto L12
        Lc:
            android.util.Size[] r0 = r8.getOutputSizes(r9)     // Catch: java.lang.Throwable -> L11
            goto L12
        L11:
            r0 = r1
        L12:
            r2 = 0
            if (r0 == 0) goto L38
            int r3 = r0.length
            if (r3 != 0) goto L19
            goto L38
        L19:
            if (r11 == 0) goto L43
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r0.length
            r5 = r2
        L22:
            if (r5 >= r4) goto L32
            r6 = r0[r5]
            boolean r7 = defpackage.af.a(r11, r6)
            if (r7 == 0) goto L2f
            r3.add(r6)
        L2f:
            int r5 = r5 + 1
            goto L22
        L32:
            boolean r11 = r3.isEmpty()
            if (r11 == 0) goto L3a
        L38:
            r0 = r1
            goto L43
        L3a:
            android.util.Size[] r11 = new android.util.Size[r2]
            java.lang.Object[] r11 = r3.toArray(r11)
            r0 = r11
            android.util.Size[] r0 = (android.util.Size[]) r0
        L43:
            if (r0 == 0) goto L83
            int r11 = r0.length
            if (r11 != 0) goto L49
            goto L83
        L49:
            l80 r11 = new l80
            r11.<init>(r2)
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.lang.Object r0 = java.util.Collections.max(r0, r11)
            android.util.Size r0 = (android.util.Size) r0
            android.util.Size r1 = defpackage.yx3.a
            if (r10 == 0) goto L70
            android.util.Size[] r8 = r8.getHighResolutionOutputSizes(r9)
            if (r8 == 0) goto L70
            int r9 = r8.length
            if (r9 <= 0) goto L70
            java.util.List r8 = java.util.Arrays.asList(r8)
            java.lang.Object r8 = java.util.Collections.max(r8, r11)
            r1 = r8
            android.util.Size r1 = (android.util.Size) r1
        L70:
            r8 = 2
            android.util.Size[] r8 = new android.util.Size[r8]
            r8[r2] = r0
            r9 = 1
            r8[r9] = r1
            java.util.List r8 = java.util.Arrays.asList(r8)
            java.lang.Object r8 = java.util.Collections.max(r8, r11)
            android.util.Size r8 = (android.util.Size) r8
            return r8
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r64.f(android.hardware.camera2.params.StreamConfigurationMap, int, boolean, android.util.Rational):android.util.Size");
    }

    public static int h(Range range, Range range2) {
        r25.j("Ranges must not intersect", (range.contains((Integer) range2.getUpper()) || range.contains((Integer) range2.getLower())) ? false : true);
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    public static int i(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    public static Range m(Range range, Range range2, boolean z) {
        Range range3 = ih.h;
        if (range3.equals(range2) && range3.equals(range)) {
            return range3;
        }
        if (range3.equals(range2)) {
            return range;
        }
        if (range3.equals(range)) {
            return range2;
        }
        if (z) {
            r25.j("All targetFrameRate should be the same if strict fps is required", range == range2);
            return range;
        }
        try {
            return range2.intersect(range);
        } catch (IllegalArgumentException unused) {
            return range2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r23v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r26v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final boolean a(kh khVar, List list, Map map, List list2, List list3) {
        boolean z;
        boolean z2;
        ArrayList arrayList;
        List list4;
        Size size;
        boolean z3 = khVar.d;
        boolean z4 = khVar.h;
        HashMap map2 = this.g;
        if (map2.containsKey(khVar)) {
            list4 = (List) map2.get(khVar);
            z2 = z3;
            z = false;
        } else {
            ArrayList arrayList2 = new ArrayList();
            int i = khVar.a;
            v64 v64Var = v64.b;
            if (z4) {
                ArrayList arrayList3 = this.f;
                if (arrayList3.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    t64 t64Var = t64.S1080P_16_9;
                    d44 d44Var = w64.e;
                    t64Var.getClass();
                    z = false;
                    d44 d44Var2 = w64.e;
                    arrayList4.add(new s64(tj4.r(v64Var, t64Var, d44Var2)));
                    t64 t64Var2 = t64.S720P_16_9;
                    t64Var2.getClass();
                    arrayList4.add(new s64(tj4.r(v64Var, t64Var2, d44Var2)));
                    t64 t64Var3 = t64.MAXIMUM_16_9;
                    arrayList4.addAll(fx3.j(t64Var, t64Var3));
                    t64 t64Var4 = t64.UHD;
                    arrayList4.addAll(fx3.j(t64Var, t64Var4));
                    arrayList4.addAll(fx3.j(t64Var, t64.S1440P_16_9));
                    arrayList4.addAll(fx3.j(t64Var, t64Var));
                    arrayList4.addAll(fx3.j(t64Var2, t64Var3));
                    arrayList4.addAll(fx3.j(t64Var2, t64Var4));
                    arrayList4.addAll(fx3.j(t64Var2, t64Var));
                    t64 t64Var5 = t64.X_VGA;
                    t64 t64Var6 = t64.MAXIMUM_4_3;
                    arrayList4.addAll(fx3.j(t64Var5, t64Var6));
                    arrayList4.addAll(fx3.j(t64.S1080P_4_3, t64Var6));
                    arrayList3.addAll(arrayList4);
                } else {
                    z = false;
                }
                arrayList2.addAll(arrayList3);
                z2 = z3;
            } else {
                z = false;
                if (khVar.e) {
                    ArrayList arrayList5 = this.i;
                    if (arrayList5.isEmpty()) {
                        ArrayList arrayList6 = new ArrayList();
                        s64 s64Var = new s64();
                        t64 t64Var7 = t64.MAXIMUM;
                        d44 d44Var3 = w64.e;
                        t64Var7.getClass();
                        d44 d44Var4 = w64.e;
                        v64 v64Var2 = v64.A;
                        z2 = z3;
                        s64 s64VarX = dw2.x(s64Var, tj4.r(v64Var2, t64Var7, d44Var4), arrayList6, s64Var);
                        t64 t64Var8 = t64.PREVIEW;
                        t64Var8.getClass();
                        s64VarX.a(tj4.r(v64Var, t64Var8, d44Var4));
                        s64VarX.a(tj4.r(v64Var2, t64Var7, d44Var4));
                        arrayList6.add(s64VarX);
                        arrayList5.addAll(arrayList6);
                    } else {
                        z2 = z3;
                    }
                    if (i == 0) {
                        arrayList2.addAll(arrayList5);
                    }
                } else {
                    z2 = z3;
                    if (khVar.f) {
                        ArrayList arrayList7 = this.e;
                        if (arrayList7.isEmpty()) {
                            hs1 hs1Var = this.C;
                            if (((Boolean) hs1Var.b.getValue()).booleanValue()) {
                                arrayList7.clear();
                                Size size2 = (Size) hs1Var.c.getValue();
                                if (size2 != null) {
                                    ph phVarL = l(34);
                                    ArrayList arrayList8 = new ArrayList();
                                    d44 d44Var5 = w64.e;
                                    phVarL.getClass();
                                    w64 w64VarJ0 = tj4.j0(34, size2, phVarL, 0, u64.f, w64.e);
                                    s64 s64Var2 = new s64();
                                    s64Var2.a(w64VarJ0);
                                    arrayList8.add(s64Var2);
                                    s64 s64Var3 = new s64();
                                    s64Var3.a(w64VarJ0);
                                    s64Var3.a(w64VarJ0);
                                    arrayList8.add(s64Var3);
                                    arrayList7.addAll(arrayList8);
                                }
                            }
                        }
                        arrayList2.addAll(arrayList7);
                    } else {
                        int i2 = khVar.c;
                        if (i2 == 8) {
                            if (i != 1) {
                                ArrayList arrayList9 = this.a;
                                if (i != 2) {
                                    if (z2) {
                                        arrayList9 = this.d;
                                    }
                                    arrayList2.addAll(arrayList9);
                                } else {
                                    arrayList2.addAll(this.b);
                                    arrayList2.addAll(arrayList9);
                                }
                            } else {
                                arrayList = this.c;
                                map2.put(khVar, arrayList);
                                list4 = arrayList;
                            }
                        } else if (i2 == 10 && i == 0) {
                            arrayList2.addAll(this.h);
                        }
                    }
                }
            }
            arrayList = arrayList2;
            map2.put(khVar, arrayList);
            list4 = arrayList;
        }
        Iterator it = list4.iterator();
        boolean z5 = z;
        while (it.hasNext()) {
            z5 = ((s64) it.next()).c(list) != null ? true : z;
            if (z5) {
                break;
            }
        }
        if (!z5 || !z4) {
            return z5;
        }
        Range range = khVar.i;
        st3 st3Var = new st3();
        ?? r6 = z;
        while (r6 < list.size()) {
            w64 w64Var = (w64) list.get(r6);
            ph phVarL2 = l(w64Var.d);
            int i3 = w64Var.d;
            phVarL2.getClass();
            HashMap map3 = phVarL2.f;
            t64 t64Var9 = w64Var.b;
            int iOrdinal = t64Var9.ordinal();
            if (iOrdinal != 3) {
                switch (iOrdinal) {
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        size = phVarL2.e;
                        break;
                    case 10:
                        size = (Size) map3.get(Integer.valueOf(i3));
                        break;
                    case 11:
                        size = (Size) map3.get(Integer.valueOf(i3));
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        size = (Size) map3.get(Integer.valueOf(i3));
                        break;
                    case 13:
                        size = (Size) phVarL2.i.get(Integer.valueOf(i3));
                        break;
                    case 14:
                        xe.q("Not supported config size");
                        return z;
                    default:
                        size = t64Var9.f;
                        break;
                }
            } else {
                size = phVarL2.c;
            }
            size.getClass();
            mn4 mn4Var = (mn4) list2.get(((Integer) list3.get(r6)).intValue());
            oz0 oz0Var = (oz0) map.get(w64Var);
            Objects.requireNonNull(oz0Var);
            int i4 = kc1.a;
            mn4Var.getClass();
            lc1 lc1Var = new lc1(size, mn4Var.n());
            qn4.f.getClass();
            int iOrdinal2 = mn4Var.M().ordinal();
            ?? r20 = r6;
            Class cls = (iOrdinal2 != 0 ? iOrdinal2 != 1 ? iOrdinal2 != 3 ? iOrdinal2 != 4 ? qn4.Z : qn4.Y : qn4.X : qn4.z : qn4.A).b;
            if (cls != null) {
                lc1Var.j = cls;
            }
            pt3 pt3VarD = pt3.d(mn4Var, size);
            e10 e10Var = pt3VarD.b;
            pt3VarD.b(lc1Var, oz0Var, -1);
            ((qn2) e10Var.A).g(f10.j, ih.h.equals(range) ? cj1.d : range);
            if (z2) {
                ((qn2) e10Var.A).g(mn4.l0, 2);
            }
            st3Var.a(pt3VarD.c());
            boolean zC = st3Var.c();
            StringBuilder sb = new StringBuilder("Cannot create a combined SessionConfig for feature combo after adding ");
            sb.append(mn4Var);
            sb.append(" with ");
            sb.append(w64Var);
            sb.append(" due to [");
            sb.append(!st3Var.m ? "Template is not set" : st3Var.l.toString());
            sb.append("]; surfaceConfigList = ");
            sb.append((Object) list);
            sb.append(", featureSettings = ");
            sb.append(khVar);
            sb.append(", newUseCaseConfigs = ");
            sb.append(list2);
            r25.j(sb.toString(), zC);
            r6 = (r20 == true ? 1 : 0) + 1;
        }
        tt3 tt3VarB = st3Var.b();
        boolean zB = this.D.b(tt3VarB);
        Iterator it2 = tt3VarB.b().iterator();
        while (it2.hasNext()) {
            ((dn0) it2.next()).a();
        }
        return zB;
    }

    public final kh b(int i, boolean z, HashMap map, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Range range, boolean z7) {
        int i2;
        Range range2;
        Range range3;
        Iterator it = map.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = 8;
                break;
            }
            if (((oz0) it.next()).b == 10) {
                i2 = 10;
                break;
            }
        }
        String str = this.k;
        if (i != 0 && z3) {
            throw new IllegalArgumentException(fw.v("Camera device id is ", str, ". Ultra HDR is not currently supported in ", i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA", " camera mode."));
        }
        if (i != 0 && i2 == 10) {
            throw new IllegalArgumentException(fw.v("Camera device id is ", str, ". 10 bit dynamic range is not currently supported in ", i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA", " camera mode."));
        }
        if (i != 0 && z5) {
            throw new IllegalArgumentException(fw.v("Camera device id is ", str, ". Feature combination query is not currently supported in ", i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA", " camera mode."));
        }
        if (z4 && z5) {
            xe.k("High-speed session is not supported with feature combination");
            return null;
        }
        if (z4 && !((Boolean) this.C.b.getValue()).booleanValue()) {
            xe.k("High-speed session is not supported on this device.");
            return null;
        }
        if (z5) {
            range2 = range;
            if (range2 == ih.h && z6) {
                range3 = cj1.d;
            }
            return new kh(i, z, i2, z2, z3, z4, z5, z6, range3, z7);
        }
        range2 = range;
        range3 = range2;
        return new kh(i, z, i2, z2, z3, z4, z5, z6, range3, z7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r2 = new android.util.Size(r8.videoFrameWidth, r8.videoFrameHeight);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r11 = this;
            sv0 r0 = r11.y
            android.util.Size r4 = r0.e()
            r0 = 0
            r1 = 0
            java.lang.String r2 = r11.k     // Catch: java.lang.NumberFormatException -> L3a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L3a
            bw r3 = r11.l     // Catch: java.lang.NumberFormatException -> L3a
            r5 = 8
            int[] r6 = new int[r5]     // Catch: java.lang.NumberFormatException -> L3a
            r6 = {x00ac: FILL_ARRAY_DATA , data: [1, 13, 10, 8, 12, 6, 5, 4} // fill-array     // Catch: java.lang.NumberFormatException -> L3a
            r7 = r1
        L18:
            if (r7 >= r5) goto L35
            r8 = r6[r7]     // Catch: java.lang.NumberFormatException -> L3a
            boolean r9 = r3.q(r2, r8)     // Catch: java.lang.NumberFormatException -> L3a
            if (r9 == 0) goto L32
            android.media.CamcorderProfile r8 = r3.d(r2, r8)     // Catch: java.lang.NumberFormatException -> L3a
            if (r8 == 0) goto L32
            android.util.Size r2 = new android.util.Size     // Catch: java.lang.NumberFormatException -> L3a
            int r3 = r8.videoFrameWidth     // Catch: java.lang.NumberFormatException -> L3a
            int r5 = r8.videoFrameHeight     // Catch: java.lang.NumberFormatException -> L3a
            r2.<init>(r3, r5)     // Catch: java.lang.NumberFormatException -> L3a
            goto L36
        L32:
            int r7 = r7 + 1
            goto L18
        L35:
            r2 = r0
        L36:
            if (r2 == 0) goto L3a
        L38:
            r6 = r2
            goto L83
        L3a:
            sy r2 = r11.m
            n02 r2 = r2.c()
            java.lang.Object r2 = r2.f     // Catch: java.lang.Throwable -> L4f
            oj1 r2 = (defpackage.oj1) r2     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r2 = r2.f     // Catch: java.lang.Throwable -> L4f
            android.hardware.camera2.params.StreamConfigurationMap r2 = (android.hardware.camera2.params.StreamConfigurationMap) r2     // Catch: java.lang.Throwable -> L4f
            java.lang.Class<android.media.MediaRecorder> r3 = android.media.MediaRecorder.class
            android.util.Size[] r2 = r2.getOutputSizes(r3)     // Catch: java.lang.Throwable -> L4f
            goto L50
        L4f:
            r2 = r0
        L50:
            if (r2 != 0) goto L53
            goto L7c
        L53:
            l80 r3 = new l80
            r5 = 1
            r3.<init>(r5)
            java.util.Arrays.sort(r2, r3)
            int r3 = r2.length
        L5d:
            if (r1 >= r3) goto L7c
            r5 = r2[r1]
            int r6 = r5.getWidth()
            android.util.Size r7 = defpackage.yx3.e
            int r8 = r7.getWidth()
            if (r6 > r8) goto L79
            int r6 = r5.getHeight()
            int r7 = r7.getHeight()
            if (r6 > r7) goto L79
            r0 = r5
            goto L7c
        L79:
            int r1 = r1 + 1
            goto L5d
        L7c:
            if (r0 == 0) goto L80
            r6 = r0
            goto L83
        L80:
            android.util.Size r2 = defpackage.yx3.c
            goto L38
        L83:
            android.util.Size r2 = defpackage.yx3.b
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            ph r1 = new ph
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.w = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r64.c():void");
    }

    public final int e(int i, Size size, boolean z) {
        long outputMinFrameDuration;
        r25.j(null, !z || i == 34);
        if (!z) {
            try {
                outputMinFrameDuration = ((StreamConfigurationMap) ((oj1) this.m.c().f).f).getOutputMinFrameDuration(i, size);
            } catch (RuntimeException e) {
                ez4.b0("StreamConfigurationMapCompat", "Failed to get min frame duration for format = " + i + " and size = " + size, e);
                outputMinFrameDuration = 0L;
            }
            if (outputMinFrameDuration > 0) {
                return (int) (1.0E9d / outputMinFrameDuration);
            }
            if (!this.u) {
                return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            }
            ez4.a0("SupportedSurfaceCombination", "minFrameDuration: " + outputMinFrameDuration + " is invalid for imageFormat = " + i + ", size = " + size);
            return 0;
        }
        hs1 hs1Var = this.C;
        hs1Var.getClass();
        size.getClass();
        List listC = hs1Var.c(size);
        List list = listC.isEmpty() ? null : listC;
        if (list == null) {
            ez4.a0("HighSpeedResolver", "No supported high speed  fps for " + size);
            return 0;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            vp1.g();
            return 0;
        }
        Integer num = (Integer) ((Range) it.next()).getUpper();
        while (it.hasNext()) {
            Integer num2 = (Integer) ((Range) it.next()).getUpper();
            if (num.compareTo(num2) < 0) {
                num = num2;
            }
        }
        num.getClass();
        return num.intValue();
    }

    public final List g(kh khVar, List list, HashMap map, HashMap map2) {
        List list2;
        pg pgVar = e44.a;
        if (khVar.a == 0 && khVar.c == 8 && !khVar.f) {
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                List listC = ((s64) it.next()).c(list);
                if (listC != null) {
                    pg pgVar2 = e44.a;
                    int size = listC.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            long j = ((w64) listC.get(i)).c.b;
                            boolean zContainsKey = map.containsKey(Integer.valueOf(i));
                            on4 on4Var = on4.X;
                            if (zContainsKey) {
                                jg jgVar = (jg) map.get(Integer.valueOf(i));
                                jgVar.getClass();
                                List list3 = jgVar.e;
                                if (list3.size() == 1) {
                                    on4Var = (on4) list3.get(0);
                                }
                                on4Var.getClass();
                                if (!e44.c(on4Var, j, list3)) {
                                    break;
                                }
                                i++;
                            } else {
                                if (!map2.containsKey(Integer.valueOf(i))) {
                                    xe.i("SurfaceConfig does not map to any use case");
                                    return null;
                                }
                                Object obj = map2.get(Integer.valueOf(i));
                                obj.getClass();
                                mn4 mn4Var = (mn4) obj;
                                on4 on4VarM = mn4Var.M();
                                on4VarM.getClass();
                                if (mn4Var.M() == on4Var) {
                                    list2 = (List) ((sw2) ((a44) mn4Var).m()).u(a44.f);
                                    list2.getClass();
                                } else {
                                    list2 = g41.b;
                                }
                                if (!e44.c(on4VarM, j, list2)) {
                                    break;
                                }
                                i++;
                            }
                        } else if (e44.a(this.m, listC)) {
                            return listC;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x0485, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v58, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v11 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [r64] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.lang.Object, oz0] */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.LinkedHashSet] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.k74 j(int r27, java.util.ArrayList r28, java.util.HashMap r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instruction units count: 1613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r64.j(int, java.util.ArrayList, java.util.HashMap, boolean, boolean, boolean):k74");
    }

    public final Pair k(kh khVar, ArrayList arrayList, List list, ArrayList arrayList2, ArrayList arrayList3, int i, HashMap map, HashMap map2) {
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jg jgVar = (jg) it.next();
            arrayList4.add(jgVar.a);
            map.put(Integer.valueOf(arrayList4.size() - 1), jgVar);
        }
        int iMin = i;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Size size = (Size) list.get(i2);
            mn4 mn4Var = (mn4) arrayList2.get(((Integer) arrayList3.get(i2)).intValue());
            int iN = mn4Var.n();
            d44 d44VarJ = mn4Var.J();
            u64 u64Var = khVar.h ? u64.b : u64.f;
            ph phVarL = l(iN);
            int i3 = khVar.a;
            d44 d44Var = w64.e;
            arrayList4.add(tj4.j0(iN, size, phVarL, i3, u64Var, d44VarJ));
            map2.put(Integer.valueOf(arrayList4.size() - 1), mn4Var);
            iMin = Math.min(iMin, e(mn4Var.n(), size, khVar.f));
        }
        return new Pair(arrayList4, Integer.valueOf(iMin));
    }

    public final ph l(int i) {
        StreamConfigurationMap streamConfigurationMap;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = this.x;
        if (!arrayList.contains(numValueOf)) {
            p(this.w.b, yx3.d, i);
            p(this.w.d, yx3.f, i);
            o(this.w.f, i, null);
            o(this.w.g, i, af.a);
            o(this.w.h, i, af.c);
            HashMap map = this.w.i;
            if (Build.VERSION.SDK_INT >= 31 && this.t && (streamConfigurationMap = (StreamConfigurationMap) this.m.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) != null) {
                map.put(Integer.valueOf(i), f(streamConfigurationMap, i, true, null));
            }
            arrayList.add(Integer.valueOf(i));
        }
        return this.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:217:0x05b4  */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v11 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v61, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67, types: [g41] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r31v3 */
    /* JADX WARN: Type inference failed for: r32v0 */
    /* JADX WARN: Type inference failed for: r32v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r32v2 */
    /* JADX WARN: Type inference failed for: r32v3 */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r40v4, types: [k74] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.k74 n(defpackage.kh r38, java.util.ArrayList r39, java.util.Map r40, java.util.ArrayList r41, java.util.ArrayList r42, java.util.HashMap r43) {
        /*
            Method dump skipped, instruction units count: 2175
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r64.n(kh, java.util.ArrayList, java.util.Map, java.util.ArrayList, java.util.ArrayList, java.util.HashMap):k74");
    }

    public final void o(HashMap map, int i, Rational rational) {
        Size sizeF = f((StreamConfigurationMap) ((oj1) this.m.c().f).f, i, true, rational);
        if (sizeF != null) {
            map.put(Integer.valueOf(i), sizeF);
        }
    }

    public final void p(HashMap map, Size size, int i) {
        if (this.r) {
            Size sizeF = f((StreamConfigurationMap) ((oj1) this.m.c().f).f, i, false, null);
            Integer numValueOf = Integer.valueOf(i);
            if (sizeF != null) {
                size = (Size) Collections.min(Arrays.asList(size, sizeF), new l80(false));
            }
            map.put(numValueOf, size);
        }
    }
}
