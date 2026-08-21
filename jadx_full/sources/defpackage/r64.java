package defpackage;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
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
    */
    public static Range d(Range range, int i, Range[] rangeArr) {
        Range range2 = ih.h;
        if (range2.equals(range) || rangeArr == null) {
            return range2;
        }
        Range range3 = new Range(Integer.valueOf(Math.min(((Integer) range.getLower()).intValue(), i)), Integer.valueOf(Math.min(((Integer) range.getUpper()).intValue(), i)));
        int i2 = 0;
        for (Range range4 : rangeArr) {
            Objects.requireNonNull(range4);
            if (i >= ((Integer) range4.getLower()).intValue()) {
                if (range2.equals(ih.h)) {
                    range2 = range4;
                }
                if (range4.equals(range3)) {
                    return range4;
                }
                try {
                    int i3 = i(range4.intersect(range3));
                    if (i2 == 0) {
                        i2 = i3;
                    } else {
                        if (i3 >= i2) {
                            double dI = i(range2.intersect(range3));
                            double dI2 = i(range4.intersect(range3));
                            double dI3 = dI2 / ((double) i(range4));
                            double dI4 = dI / ((double) i(range2));
                            if (dI2 > dI) {
                                if (dI3 >= 0.5d || dI3 >= dI4) {
                                    range2 = range4;
                                }
                                i2 = i(range3.intersect(range2));
                            } else if (dI2 == dI) {
                                if (dI3 > dI4 || (dI3 == dI4 && ((Integer) range4.getLower()).intValue() > ((Integer) range2.getLower()).intValue())) {
                                    range2 = range4;
                                }
                                i2 = i(range3.intersect(range2));
                            } else {
                                if (dI4 < 0.5d && dI3 > dI4) {
                                }
                                i2 = i(range3.intersect(range2));
                            }
                        }
                        range4 = range2;
                    }
                } catch (IllegalArgumentException unused) {
                    if (i2 != 0 || (h(range4, range3) >= h(range2, range3) && (h(range4, range3) != h(range2, range3) || (((Integer) range4.getLower()).intValue() <= ((Integer) range2.getUpper()).intValue() && i(range4) >= i(range2))))) {
                    }
                }
                range2 = range4;
            }
        }
        return range2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Size f(StreamConfigurationMap streamConfigurationMap, int i, boolean z, Rational rational) {
        Size[] outputSizes;
        Size[] highResolutionOutputSizes;
        try {
            outputSizes = i == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i);
        } catch (Throwable unused) {
            outputSizes = null;
        }
        if (outputSizes == null || outputSizes.length == 0) {
            outputSizes = null;
        } else if (rational != null) {
            ArrayList arrayList = new ArrayList();
            for (Size size : outputSizes) {
                if (af.a(rational, size)) {
                    arrayList.add(size);
                }
            }
            if (!arrayList.isEmpty()) {
                outputSizes = (Size[]) arrayList.toArray(new Size[0]);
            }
        }
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        l80 l80Var = new l80(false);
        Size size2 = (Size) Collections.max(Arrays.asList(outputSizes), l80Var);
        Size size3 = yx3.a;
        if (z && (highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i)) != null && highResolutionOutputSizes.length > 0) {
            size3 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), l80Var);
        }
        return (Size) Collections.max(Arrays.asList(size2, size3), l80Var);
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
    */
    public final void c() {
        Size[] outputSizes;
        Size size;
        Size size2;
        int i;
        bw bwVar;
        int[] iArr;
        int i2;
        Size sizeE = this.y.e();
        Size size3 = null;
        int i3 = 0;
        try {
            i = Integer.parseInt(this.k);
            bwVar = this.l;
            iArr = new int[]{1, 13, 10, 8, 12, 6, 5, 4};
            i2 = 0;
        } catch (NumberFormatException unused) {
        }
        while (true) {
            if (i2 >= 8) {
                size = null;
                break;
            }
            int i4 = iArr[i2];
            if (bwVar.q(i, i4) && (r8 = bwVar.d(i, i4)) != null) {
                break;
            } else {
                i2++;
            }
            try {
                outputSizes = ((StreamConfigurationMap) ((oj1) this.m.c().f).f).getOutputSizes(MediaRecorder.class);
            } catch (Throwable unused2) {
                outputSizes = null;
            }
            if (outputSizes != null) {
                Arrays.sort(outputSizes, new l80(true));
                int length = outputSizes.length;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    Size size4 = outputSizes[i3];
                    int width = size4.getWidth();
                    Size size5 = yx3.e;
                    if (width <= size5.getWidth() && size4.getHeight() <= size5.getHeight()) {
                        size3 = size4;
                        break;
                    }
                    i3++;
                }
            }
            if (size3 == null) {
                size2 = size3;
                this.w = new ph(yx3.b, new HashMap(), sizeE, new HashMap(), size2, new HashMap(), new HashMap(), new HashMap(), new HashMap());
            } else {
                size = yx3.c;
                size2 = size;
                this.w = new ph(yx3.b, new HashMap(), sizeE, new HashMap(), size2, new HashMap(), new HashMap(), new HashMap(), new HashMap());
            }
        }
        if (size != null) {
            size2 = size;
        } else {
            outputSizes = ((StreamConfigurationMap) ((oj1) this.m.c().f).f).getOutputSizes(MediaRecorder.class);
            if (outputSizes != null) {
            }
            if (size3 == null) {
            }
        }
        this.w = new ph(yx3.b, new HashMap(), sizeE, new HashMap(), size2, new HashMap(), new HashMap(), new HashMap(), new HashMap());
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
    */
    public final k74 j(int i, ArrayList arrayList, HashMap map, boolean z, boolean z2, boolean z3) {
        boolean z4;
        HashMap map2;
        boolean z5;
        int i2;
        int i3;
        ArrayList arrayList2;
        Set set;
        ?? r24;
        Object objI;
        ?? r2;
        oz0 oz0Var;
        ?? r242;
        ?? r243;
        oz0 oz0Var2;
        oz0 oz0Var3 = oz0.e;
        sv0 sv0Var = this.y;
        sv0Var.b = sv0Var.a();
        if (this.w == null) {
            c();
        } else {
            Size sizeE = this.y.e();
            ph phVar = this.w;
            this.w = new ph(phVar.a, phVar.b, sizeE, phVar.d, phVar.e, phVar.f, phVar.g, phVar.h, phVar.i);
        }
        Set setKeySet = map.keySet();
        Range range = hs1.e;
        setKeySet.getClass();
        ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(((jg) it.next()).g));
        }
        ArrayList arrayList4 = new ArrayList(f70.Q(10, setKeySet));
        Iterator it2 = setKeySet.iterator();
        while (it2.hasNext()) {
            arrayList4.add(Integer.valueOf(((mn4) it2.next()).b()));
        }
        ArrayList arrayListM0 = d70.m0(arrayList3, arrayList4);
        if (arrayListM0.isEmpty()) {
            z4 = false;
        } else {
            Iterator it3 = arrayListM0.iterator();
            while (it3.hasNext()) {
                if (((Number) it3.next()).intValue() == 1) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        k74 k74Var = null;
        if (z4 && !arrayListM0.isEmpty()) {
            Iterator it4 = arrayListM0.iterator();
            while (it4.hasNext()) {
                if (((Number) it4.next()).intValue() != 1) {
                    xe.k("All sessionTypes should be high-speed when any of them is high-speed");
                    return null;
                }
            }
        }
        if (z4) {
            hs1 hs1Var = this.C;
            hs1Var.getClass();
            List listA = hs1.a(d70.y0(map.values()));
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : listA) {
                if (((List) hs1Var.d.getValue()).contains((Size) obj)) {
                    arrayList5.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(fh2.U(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                List list = (List) entry.getValue();
                ArrayList arrayList6 = new ArrayList();
                for (Object obj2 : list) {
                    k74 k74Var2 = k74Var;
                    if (arrayList5.contains((Size) obj2)) {
                        arrayList6.add(obj2);
                    }
                    k74Var = k74Var2;
                }
                linkedHashMap.put(key, arrayList6);
            }
            map2 = linkedHashMap;
        } else {
            map2 = map;
        }
        k74 k74Var3 = k74Var;
        ArrayList<mn4> arrayList7 = new ArrayList(map2.keySet());
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        Iterator it5 = arrayList7.iterator();
        while (it5.hasNext()) {
            int iW = ((mn4) it5.next()).w();
            if (!arrayList9.contains(Integer.valueOf(iW))) {
                arrayList9.add(Integer.valueOf(iW));
            }
        }
        Collections.sort(arrayList9);
        Collections.reverse(arrayList9);
        Iterator it6 = arrayList9.iterator();
        while (it6.hasNext()) {
            int iIntValue = ((Integer) it6.next()).intValue();
            for (mn4 mn4Var : arrayList7) {
                if (iIntValue == mn4Var.w()) {
                    arrayList8.add(Integer.valueOf(arrayList7.indexOf(mn4Var)));
                }
            }
        }
        fa5 fa5Var = this.B;
        sz0 sz0Var = (sz0) fa5Var.z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it7 = arrayList.iterator();
        while (it7.hasNext()) {
            linkedHashSet.add(((jg) it7.next()).d);
        }
        Set setB = ((rz0) sz0Var.a).b();
        HashSet hashSet = new HashSet(setB);
        Iterator it8 = linkedHashSet.iterator();
        while (it8.hasNext()) {
            fa5.r(hashSet, (oz0) it8.next(), sz0Var);
        }
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        Iterator it9 = arrayList8.iterator();
        while (it9.hasNext()) {
            mn4 mn4Var2 = (mn4) arrayList7.get(((Integer) it9.next()).intValue());
            boolean z6 = z4;
            oz0 oz0VarE = mn4Var2.e();
            HashMap map3 = map2;
            if (oz0VarE.equals(oz0.c)) {
                arrayList12.add(mn4Var2);
            } else {
                int i4 = oz0VarE.a;
                int i5 = oz0VarE.b;
                if (i4 == 2 || ((i4 != 0 && i5 == 0) || (i4 == 0 && i5 != 0))) {
                    arrayList11.add(mn4Var2);
                } else {
                    arrayList10.add(mn4Var2);
                }
            }
            z4 = z6;
            map2 = map3;
        }
        boolean z7 = z4;
        HashMap map4 = map2;
        HashMap map5 = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList13 = new ArrayList();
        arrayList13.addAll(arrayList10);
        arrayList13.addAll(arrayList11);
        arrayList13.addAll(arrayList12);
        Iterator it10 = arrayList13.iterator();
        ?? r9 = linkedHashSet;
        while (it10.hasNext()) {
            mn4 mn4Var3 = (mn4) it10.next();
            oz0 oz0VarE2 = mn4Var3.e();
            String strQ = mn4Var3.Q();
            Iterator it11 = it10;
            oz0 oz0Var4 = oz0.d;
            if (oz0VarE2.b()) {
                if (hashSet.contains(oz0VarE2)) {
                    r242 = r9;
                    set = setB;
                    oz0Var2 = oz0VarE2;
                    arrayList2 = arrayList7;
                    r2 = oz0Var2;
                    r243 = r242;
                }
                r24 = r9;
                set = setB;
                arrayList2 = arrayList7;
                r2 = k74Var3;
                r243 = r24;
            } else {
                int i6 = oz0VarE2.a;
                int i7 = oz0VarE2.b;
                if (i6 != 1 || i7 != 0) {
                    oz0 oz0VarM = fa5.m(oz0VarE2, r9, hashSet);
                    arrayList2 = arrayList7;
                    set = setB;
                    r24 = r9;
                    if (oz0VarM != null) {
                        ez4.o("DynamicRangeResolver", "Resolved dynamic range for use case " + strQ + " from existing attached surface.\n" + oz0VarE2 + "\n->\n" + oz0VarM);
                        oz0Var = oz0VarM;
                    } else {
                        oz0 oz0VarM2 = fa5.m(oz0VarE2, linkedHashSet2, hashSet);
                        if (oz0VarM2 != null) {
                            ez4.o("DynamicRangeResolver", "Resolved dynamic range for use case " + strQ + " from concurrently bound use case.\n" + oz0VarE2 + "\n->\n" + oz0VarM2);
                            oz0Var = oz0VarM2;
                        } else if (fa5.h(oz0VarE2, oz0Var4, hashSet)) {
                            ez4.o("DynamicRangeResolver", "Resolved dynamic range for use case " + strQ + " to no compatible HDR dynamic ranges.\n" + oz0VarE2 + "\n->\n" + oz0Var4);
                            r2 = oz0Var4;
                            r243 = r24;
                        } else {
                            if (i6 == 2 && (i7 == 10 || i7 == 0)) {
                                LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                                if (Build.VERSION.SDK_INT >= 33) {
                                    objI = k2.i((sy) fa5Var.f);
                                    if (objI != null) {
                                        linkedHashSet3.add(objI);
                                    }
                                } else {
                                    objI = k74Var3;
                                }
                                linkedHashSet3.add(oz0Var3);
                                oz0 oz0VarM3 = fa5.m(oz0VarE2, linkedHashSet3, hashSet);
                                if (oz0VarM3 != null) {
                                    StringBuilder sbE = fw.E("Resolved dynamic range for use case ", strQ, " from ", oz0VarM3.equals(objI) ? "recommended" : "required", " 10-bit supported dynamic range.\n");
                                    sbE.append(oz0VarE2);
                                    sbE.append("\n->\n");
                                    sbE.append(oz0VarM3);
                                    ez4.o("DynamicRangeResolver", sbE.toString());
                                    r2 = oz0VarM3;
                                    r243 = r24;
                                }
                            }
                            Iterator it12 = hashSet.iterator();
                            while (it12.hasNext()) {
                                oz0 oz0Var5 = (oz0) it12.next();
                                Iterator it13 = it12;
                                r25.j("Candidate dynamic range must be fully specified.", oz0Var5.b());
                                if (!oz0Var5.equals(oz0Var4) && fa5.g(oz0VarE2, oz0Var5)) {
                                    ez4.o("DynamicRangeResolver", "Resolved dynamic range for use case " + strQ + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + oz0VarE2 + "\n->\n" + oz0Var5);
                                    oz0Var = oz0Var5;
                                } else {
                                    it12 = it13;
                                }
                            }
                            r2 = k74Var3;
                            r243 = r24;
                        }
                    }
                    r2 = oz0Var;
                    r243 = r24;
                    break;
                }
                if (hashSet.contains(oz0Var4)) {
                    r242 = r9;
                    set = setB;
                    oz0Var2 = oz0Var4;
                    arrayList2 = arrayList7;
                    r2 = oz0Var2;
                    r243 = r242;
                }
                r24 = r9;
                set = setB;
                arrayList2 = arrayList7;
                r2 = k74Var3;
                r243 = r24;
            }
            if (r2 == 0) {
                String strQ2 = mn4Var3.Q();
                String strJoin = TextUtils.join("\n  ", set);
                String strJoin2 = TextUtils.join("\n  ", hashSet);
                StringBuilder sb = new StringBuilder("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  ");
                sb.append(strQ2);
                sb.append("\nRequested dynamic range:\n  ");
                sb.append(oz0VarE2);
                sb.append("\nSupported dynamic ranges:\n  ");
                xe.k(fw.z(sb, strJoin, "\nConstrained set of concurrent dynamic ranges:\n  ", strJoin2));
                return k74Var3;
            }
            fa5.r(hashSet, r2, sz0Var);
            map5.put(mn4Var3, r2);
            ?? r1 = r243;
            if (!r1.contains(r2)) {
                linkedHashSet2.add(r2);
            }
            r9 = r1;
            it10 = it11;
            arrayList7 = arrayList2;
            setB = set;
        }
        ArrayList arrayList14 = arrayList7;
        ez4.o("SupportedSurfaceCombination", "resolvedDynamicRanges = " + map5);
        Iterator it14 = arrayList.iterator();
        while (true) {
            if (it14.hasNext()) {
                if (((jg) it14.next()).b == 4101) {
                    break;
                }
            } else {
                Iterator it15 = map4.keySet().iterator();
                while (it15.hasNext()) {
                    if (((mn4) it15.next()).n() == 4101) {
                    }
                }
                z5 = false;
            }
        }
        Iterator it16 = arrayList.iterator();
        ?? ValueOf = k74Var3;
        while (it16.hasNext()) {
            boolean z8 = ((jg) it16.next()).i;
            if (ValueOf != 0 && ValueOf.booleanValue() != z8) {
                xe.q("All isStrictFpsRequired should be the same");
                return k74Var3;
            }
            ValueOf = Boolean.valueOf(z8);
        }
        Iterator it17 = arrayList14.iterator();
        ?? ValueOf2 = ValueOf;
        while (it17.hasNext()) {
            boolean zX = ((mn4) it17.next()).X();
            if (ValueOf2 != 0 && ValueOf2.booleanValue() != zX) {
                xe.q("All isStrictFpsRequired should be the same");
                return k74Var3;
            }
            ValueOf2 = Boolean.valueOf(zX);
        }
        boolean zBooleanValue = ValueOf2 != 0 ? ValueOf2.booleanValue() : false;
        Range rangeM = ih.h;
        Iterator it18 = arrayList.iterator();
        while (it18.hasNext()) {
            rangeM = m(((jg) it18.next()).h, rangeM, zBooleanValue);
        }
        Iterator it19 = arrayList8.iterator();
        Range rangeM2 = rangeM;
        while (it19.hasNext()) {
            Range rangeO = ((mn4) arrayList14.get(((Integer) it19.next()).intValue())).O(ih.h);
            Objects.requireNonNull(rangeO);
            rangeM2 = m(rangeO, rangeM2, zBooleanValue);
        }
        ez4.o("SupportedSurfaceCombination", "getSuggestedStreamSpecifications: isPreviewStabilizationOn = " + z + ", mIsPreviewStabilizationSupported = " + this.v + ", isFeatureComboInvocation = " + z3);
        if (z && !this.v && z3) {
            xe.k("Preview stabilization is not supported by the camera.");
            return k74Var3;
        }
        kh khVarB = b(i, z2, map5, z, z5, z7, z3, false, rangeM2, zBooleanValue);
        Collection collectionValues = map5.values();
        if (z3) {
            ?? Contains = collectionValues.contains(oz0Var3);
            ?? r0 = Contains;
            if (rangeM2 != null) {
                r0 = Contains;
                if (((Integer) rangeM2.getUpper()).intValue() == 60) {
                    r0 = Contains + 1;
                }
            }
            if (z) {
                r0++;
            }
            if (z5) {
                r0++;
            }
            i2 = 1;
            i3 = r0 > 1 ? 2 : r0 == 1 ? 3 : 1;
        } else {
            i3 = 1;
            i2 = 1;
        }
        ez4.o("SupportedSurfaceCombination", "resolveSpecsByCheckingMethod: checkingMethod = ".concat(i3 != i2 ? i3 != 2 ? i3 != 3 ? "null" : "WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT" : "WITH_FEATURE_COMBO" : "WITHOUT_FEATURE_COMBO"));
        int iG = fw.G(i3);
        if (iG == 1) {
            return n(b(khVarB.a, khVarB.b, map5, khVarB.d, khVarB.e, khVarB.f, khVarB.g, true, khVarB.i, khVarB.j), arrayList, map4, arrayList14, arrayList8, map5);
        }
        if (iG != 2) {
            return n(khVarB, arrayList, map4, arrayList14, arrayList8, map5);
        }
        try {
            return n(khVarB, arrayList, map4, arrayList14, arrayList8, map5);
        } catch (IllegalArgumentException e) {
            ez4.p("SupportedSurfaceCombination", "Failed to find a supported combination without feature combo, trying again with feature combo", e);
            return n(b(khVarB.a, khVarB.b, map5, khVarB.d, khVarB.e, khVarB.f, khVarB.g, true, khVarB.i, khVarB.j), arrayList, map4, arrayList14, arrayList8, map5);
        }
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
    */
    public final k74 n(kh khVar, ArrayList arrayList, Map map, ArrayList arrayList2, ArrayList arrayList3, HashMap map2) {
        String str;
        String str2;
        ?? arrayList4;
        boolean z;
        HashMap map3;
        HashMap map4;
        ?? r15;
        ArrayList arrayList5;
        HashMap map5;
        HashMap map6;
        String str3;
        HashMap map7;
        ?? r23;
        ArrayList arrayList6;
        Range range;
        int i;
        ?? r31;
        ?? r32;
        r64 r64Var;
        HashMap map8;
        HashMap map9;
        int i2;
        List list;
        HashMap map10;
        List list2;
        r64 r64Var2;
        HashMap map11;
        oz0 oz0Var;
        Size sizeB;
        u64 u64Var;
        int iE;
        r64 r64Var3 = this;
        kh khVar2 = khVar;
        Map map12 = map;
        HashMap map13 = map2;
        u64 u64Var2 = u64.f;
        ez4.o("SupportedSurfaceCombination", "resolveSpecsBySettings: featureSettings = " + khVar2);
        boolean z2 = false;
        if (khVar2.h) {
            str = "SupportedSurfaceCombination";
            str2 = "No supported surface combination is found for camera device - Id : ";
        } else {
            ArrayList arrayList7 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList7.add(((jg) it.next()).a);
            }
            l80 l80Var = new l80(false);
            for (mn4 mn4Var : map12.keySet()) {
                List list3 = (List) map12.get(mn4Var);
                r25.f((list3 == null || list3.isEmpty()) ? z2 : true, "No available output size is found for " + mn4Var + ".");
                Size size = (Size) Collections.min(list3, l80Var);
                l80 l80Var2 = l80Var;
                int iN = mn4Var.n();
                ph phVarL = r64Var3.l(iN);
                int i3 = khVar2.a;
                d44 d44VarJ = mn4Var.J();
                d44 d44Var = w64.e;
                arrayList7.add(tj4.j0(iN, size, phVarL, i3, u64Var2, d44VarJ));
                l80Var = l80Var2;
                z2 = false;
            }
            Map map14 = Collections.EMPTY_MAP;
            List list4 = Collections.EMPTY_LIST;
            str = "SupportedSurfaceCombination";
            str2 = "No supported surface combination is found for camera device - Id : ";
            if (!r64Var3.a(khVar2, arrayList7, map14, list4, list4)) {
                throw new IllegalArgumentException(str2 + r64Var3.k + ".  May be attempting to bind too many use cases. Existing surfaces: " + arrayList + ". New configs: " + arrayList2 + ". GroupableFeature settings: " + khVar2);
            }
        }
        HashMap map15 = new HashMap();
        Iterator it2 = map12.keySet().iterator();
        Map map16 = map12;
        while (it2.hasNext()) {
            mn4 mn4Var2 = (mn4) it2.next();
            ArrayList arrayList8 = new ArrayList();
            HashMap map17 = new HashMap();
            List<Size> list5 = (List) map16.get(mn4Var2);
            Objects.requireNonNull(list5);
            for (Size size2 : list5) {
                int iN2 = mn4Var2.n();
                d44 d44VarJ2 = mn4Var2.J();
                Range range2 = khVar2.i;
                ph phVarL2 = r64Var3.l(iN2);
                Iterator it3 = it2;
                int i4 = khVar2.a;
                u64 u64Var3 = khVar2.h ? u64.b : u64Var2;
                d44 d44Var2 = w64.e;
                t64 t64Var = tj4.j0(iN2, size2, phVarL2, i4, u64Var3, d44VarJ2).b;
                Range range3 = ih.h;
                if (range3.equals(range2)) {
                    u64Var = u64Var2;
                    iE = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                } else {
                    u64Var = u64Var2;
                    iE = r64Var3.e(iN2, size2, khVar2.f);
                }
                if (!khVar2.g || (t64Var != t64.NOT_SUPPORT && (range3.equals(range2) || iE >= ((Integer) range2.getUpper()).intValue()))) {
                    Set hashSet = (Set) map17.get(t64Var);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map17.put(t64Var, hashSet);
                    }
                    if (!hashSet.contains(Integer.valueOf(iE))) {
                        arrayList8.add(size2);
                        hashSet.add(Integer.valueOf(iE));
                    }
                }
                u64Var2 = u64Var;
                it2 = it3;
            }
            map15.put(mn4Var2, arrayList8);
            map16 = map;
        }
        ArrayList arrayList9 = new ArrayList();
        Iterator it4 = arrayList3.iterator();
        while (true) {
            Rational rational = null;
            if (!it4.hasNext()) {
                if (khVar2.f) {
                    r64Var3.C.getClass();
                    if (arrayList9.isEmpty()) {
                        arrayList4 = g41.b;
                    } else {
                        List<Size> listA = hs1.a(arrayList9);
                        ArrayList arrayList10 = new ArrayList(f70.Q(10, listA));
                        for (Size size3 : listA) {
                            int size4 = arrayList9.size();
                            ArrayList arrayList11 = new ArrayList(size4);
                            for (int i5 = 0; i5 < size4; i5++) {
                                arrayList11.add(size3);
                            }
                            arrayList10.add(arrayList11);
                        }
                        arrayList4 = arrayList10;
                    }
                } else {
                    Iterator it5 = arrayList9.iterator();
                    int size5 = 1;
                    while (it5.hasNext()) {
                        size5 *= ((List) it5.next()).size();
                    }
                    if (size5 == 0) {
                        xe.k("Failed to find supported resolutions.");
                        return null;
                    }
                    arrayList4 = new ArrayList();
                    for (int i6 = 0; i6 < size5; i6++) {
                        arrayList4.add(new ArrayList());
                    }
                    int i7 = size5;
                    int size6 = size5 / ((List) arrayList9.get(0)).size();
                    int i8 = 0;
                    while (i8 < arrayList9.size()) {
                        List list6 = (List) arrayList9.get(i8);
                        int i9 = 0;
                        while (i9 < size5) {
                            ((List) arrayList4.get(i9)).add((Size) list6.get((i9 % i7) / size6));
                            i9++;
                            rational = rational;
                        }
                        Rational rational2 = rational;
                        if (i8 < arrayList9.size() - 1) {
                            i7 = size6;
                            size6 /= ((List) arrayList9.get(i8 + 1)).size();
                        }
                        i8++;
                        rational = rational2;
                    }
                }
                ?? r40 = rational;
                ?? r10 = arrayList4;
                HashMap map18 = new HashMap();
                HashMap map19 = new HashMap();
                HashMap map20 = new HashMap();
                HashMap map21 = new HashMap();
                pg pgVar = e44.a;
                Iterator it6 = arrayList.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        jg jgVar = (jg) it6.next();
                        List list7 = jgVar.e;
                        list7.getClass();
                        on4 on4Var = (on4) list7.get(0);
                        ka0 ka0Var = jgVar.f;
                        ka0Var.getClass();
                        on4Var.getClass();
                        if (e44.e(ka0Var, on4Var)) {
                            break;
                        }
                    } else {
                        Iterator it7 = arrayList2.iterator();
                        while (it7.hasNext()) {
                            mn4 mn4Var3 = (mn4) it7.next();
                            on4 on4VarM = mn4Var3.M();
                            on4VarM.getClass();
                            if (e44.e(mn4Var3, on4VarM)) {
                            }
                        }
                        z = false;
                    }
                }
                z = true;
                boolean z3 = khVar2.f;
                Iterator it8 = arrayList.iterator();
                int iMin = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                while (it8.hasNext()) {
                    jg jgVar2 = (jg) it8.next();
                    iMin = Math.min(iMin, r64Var3.e(jgVar2.b, jgVar2.c, z3));
                }
                if (!r64Var3.s || z) {
                    map3 = map20;
                    map4 = map21;
                    r15 = r40;
                } else {
                    Iterator it9 = r10.iterator();
                    ?? G = r40;
                    while (true) {
                        if (!it9.hasNext()) {
                            map3 = map20;
                            map4 = map21;
                            break;
                        }
                        map3 = map20;
                        map4 = map21;
                        G = r64Var3.g(khVar2, (List) r64Var3.k(khVar2, arrayList, (List) it9.next(), arrayList2, arrayList3, iMin, map20, map21).first, map3, map4);
                        if (G != 0) {
                            break;
                        }
                        map3.clear();
                        map4.clear();
                        map20 = map3;
                        map21 = map4;
                        G = G;
                    }
                    ez4.o(str, "orderedSurfaceConfigListForStreamUseCase = " + G);
                    r15 = G;
                }
                Range range4 = khVar2.i;
                Iterator it10 = r10.iterator();
                ?? r20 = r40;
                ?? r21 = r20;
                int i10 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                int i11 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                boolean z4 = false;
                boolean z5 = false;
                r64 r64Var4 = r64Var3;
                ?? r152 = r15;
                ?? r202 = r20;
                while (true) {
                    if (!it10.hasNext()) {
                        arrayList5 = arrayList;
                        map5 = map3;
                        map6 = map4;
                        str3 = str2;
                        map7 = map18;
                        r23 = r152;
                        arrayList6 = arrayList2;
                        range = range4;
                        i = i11;
                        r31 = r202;
                        r32 = r21;
                        r64Var = r64Var4;
                        break;
                    }
                    List list8 = (List) it10.next();
                    int i12 = i11;
                    HashMap map22 = new HashMap();
                    int i13 = i10;
                    HashMap map23 = new HashMap();
                    str3 = str2;
                    map5 = map3;
                    map6 = map4;
                    Iterator it11 = it10;
                    map7 = map18;
                    ?? r232 = r152;
                    range = range4;
                    Pair pairK = r64Var4.k(khVar2, arrayList, list8, arrayList2, arrayList3, iMin, map22, map23);
                    int i14 = iMin;
                    arrayList5 = arrayList;
                    List list9 = (List) pairK.first;
                    int iIntValue = ((Integer) pairK.second).intValue();
                    boolean z6 = ih.h.equals(range) || iIntValue >= i14 || iIntValue >= ((Integer) range.getUpper()).intValue();
                    HashMap map24 = new HashMap();
                    int i15 = 0;
                    while (i15 < list9.size()) {
                        w64 w64Var = (w64) list9.get(i15);
                        oz0 oz0Var2 = oz0.c;
                        List list10 = list9;
                        if (map22.containsKey(Integer.valueOf(i15))) {
                            jg jgVar3 = (jg) map22.get(Integer.valueOf(i15));
                            Objects.requireNonNull(jgVar3);
                            oz0Var = jgVar3.d;
                        } else {
                            if (map23.containsKey(Integer.valueOf(i15))) {
                                mn4 mn4Var4 = (mn4) map23.get(Integer.valueOf(i15));
                                Objects.requireNonNull(mn4Var4);
                                oz0Var2 = (oz0) map13.get(mn4Var4);
                            }
                            oz0Var = oz0Var2;
                        }
                        map24.put(w64Var, oz0Var);
                        i15++;
                        list9 = list10;
                    }
                    List list11 = list9;
                    arrayList6 = arrayList2;
                    if (z4) {
                        i2 = i14;
                        list = list11;
                        map10 = map22;
                        list2 = list8;
                        r64Var2 = this;
                        map11 = map23;
                        khVar2 = khVar;
                    } else {
                        i2 = i14;
                        list = list11;
                        map10 = map22;
                        list2 = list8;
                        r64Var2 = this;
                        map11 = map23;
                        khVar2 = khVar;
                        boolean zA = r64Var2.a(khVar2, list, map24, arrayList6, arrayList3);
                        r64Var2 = r64Var2;
                        if (zA) {
                            if (i13 != Integer.MAX_VALUE && i13 >= iIntValue) {
                                i10 = i13;
                                r202 = r202;
                            } else {
                                i10 = iIntValue;
                                r202 = list2;
                            }
                            if (z6) {
                                if (z5) {
                                    i = i12;
                                    i10 = iIntValue;
                                    r32 = r21;
                                    r31 = list2;
                                    r64Var = r64Var2;
                                    r23 = r232;
                                    break;
                                }
                                i10 = iIntValue;
                                z4 = true;
                                r202 = list2;
                            }
                        }
                        if (r232 != 0 || z5 || r64Var2.g(khVar2, list, map10, map11) == null) {
                            i11 = i12;
                        } else {
                            if (i12 != Integer.MAX_VALUE && i12 >= iIntValue) {
                                i11 = i12;
                                r21 = r21;
                            } else {
                                i11 = iIntValue;
                                r21 = list2;
                            }
                            if (!z6) {
                                continue;
                            } else {
                                if (z4) {
                                    i = iIntValue;
                                    r31 = r202;
                                    r32 = list2;
                                    r64Var = r64Var2;
                                    r23 = r232;
                                    break;
                                }
                                i11 = iIntValue;
                                z5 = true;
                                r21 = list2;
                            }
                        }
                        range4 = range;
                        str2 = str3;
                        r152 = r232;
                        it10 = it11;
                        map18 = map7;
                        map3 = map5;
                        map4 = map6;
                        iMin = i2;
                        r64Var4 = r64Var2;
                        r202 = r202;
                        r21 = r21;
                    }
                    i10 = i13;
                    if (r232 != 0) {
                        i11 = i12;
                    }
                    range4 = range;
                    str2 = str3;
                    r152 = r232;
                    it10 = it11;
                    map18 = map7;
                    map3 = map5;
                    map4 = map6;
                    iMin = i2;
                    r64Var4 = r64Var2;
                    r202 = r202;
                    r21 = r21;
                }
                jh jhVar = (!khVar2.g || ih.h.equals(range) || (i10 != Integer.MAX_VALUE && i10 >= ((Integer) range.getUpper()).intValue())) ? new jh(r31, r32, i10, i, ChannelUtils.WRITE_STATUS_SNDBUF_FULL) : new jh(null, null, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
                ez4.o(str, "resolveSpecsBySettings: bestSizesAndFps = " + jhVar);
                List list12 = jhVar.a;
                int i16 = jhVar.c;
                List list13 = jhVar.b;
                int i17 = jhVar.d;
                int i18 = jhVar.e;
                if (list12 == null) {
                    throw new IllegalArgumentException(str3 + r64Var.k + " and Hardware level: " + r64Var.o + ". May be the specified resolution is too large and not supported. Existing surfaces: " + arrayList5 + " New configs: " + arrayList6);
                }
                Range rangeD = ih.h;
                boolean zEquals = rangeD.equals(khVar2.i);
                boolean z7 = khVar2.f;
                if (!zEquals) {
                    Range[] rangeArrB = z7 ? r64Var.C.b(list12) : (Range[]) r64Var.m.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                    Range rangeD2 = d(khVar2.i, i16, rangeArrB);
                    if (khVar2.g || khVar2.j) {
                        r25.f(rangeD2.equals(khVar2.i), "Target FPS range " + khVar2.i + " is not supported. Max FPS supported by the calculated best combination: " + i16 + ". Calculated best FPS range for device: " + rangeD2 + ". Device supported FPS ranges: " + Arrays.toString(rangeArrB));
                    }
                    rangeD = rangeD2;
                } else if (z7) {
                    rangeD = d(hs1.e, i16, r64Var.C.b(list12));
                }
                Iterator it12 = arrayList6.iterator();
                while (it12.hasNext()) {
                    mn4 mn4Var5 = (mn4) it12.next();
                    r90 r90VarA = ih.a((Size) list12.get(arrayList3.indexOf(Integer.valueOf(arrayList6.indexOf(mn4Var5)))));
                    Iterator it13 = it12;
                    r90VarA.d = Integer.valueOf(khVar2.f ? 1 : 0);
                    oz0 oz0Var3 = (oz0) map13.get(mn4Var5);
                    oz0Var3.getClass();
                    r90VarA.c = oz0Var3;
                    mn4Var5.getClass();
                    qn2 qn2VarC = qn2.c();
                    pg pgVar2 = rx.X;
                    if (mn4Var5.K(pgVar2)) {
                        qn2VarC.g(pgVar2, mn4Var5.u(pgVar2));
                    }
                    pg pgVar3 = mn4.i0;
                    if (mn4Var5.K(pgVar3)) {
                        qn2VarC.g(pgVar3, mn4Var5.u(pgVar3));
                    }
                    pg pgVar4 = yx1.f;
                    if (mn4Var5.K(pgVar4)) {
                        qn2VarC.g(pgVar4, mn4Var5.u(pgVar4));
                    }
                    pg pgVar5 = dy1.s;
                    if (mn4Var5.K(pgVar5)) {
                        qn2VarC.g(pgVar5, mn4Var5.u(pgVar5));
                    }
                    r90VarA.f = new rx(14, qn2VarC);
                    r90VarA.g = Boolean.valueOf(khVar2.b);
                    if (!ih.h.equals(rangeD)) {
                        r90VarA.e = rangeD;
                    }
                    map19.put(mn4Var5, r90VarA.e());
                    map13 = map2;
                    it12 = it13;
                }
                if (r23 == 0 || i16 != i17 || list12.size() != list13.size()) {
                    map8 = map7;
                    break;
                }
                for (int i19 = 0; i19 < list12.size(); i19++) {
                    if (!((Size) list12.get(i19)).equals(list13.get(i19))) {
                        map8 = map7;
                        break;
                    }
                }
                map8 = map7;
                if (!e44.f(r64Var.m, arrayList5, map19, map8)) {
                    int size7 = r23.size();
                    int i20 = 0;
                    ?? r233 = r23;
                    while (i20 < size7) {
                        ?? r2 = r233;
                        long j = ((w64) r2.get(i20)).c.b;
                        HashMap map25 = map5;
                        if (map25.containsKey(Integer.valueOf(i20))) {
                            jg jgVar4 = (jg) map25.get(Integer.valueOf(i20));
                            jgVar4.getClass();
                            ka0 ka0Var2 = jgVar4.f;
                            ka0Var2.getClass();
                            rx rxVarB = e44.b(ka0Var2, Long.valueOf(j));
                            if (rxVarB != null) {
                                r90 r90VarA2 = ih.a(jgVar4.c);
                                r90VarA2.d = Integer.valueOf(jgVar4.g);
                                Range range5 = jgVar4.h;
                                if (range5 == null) {
                                    zo2.n("Null expectedFrameRateRange");
                                    return r40;
                                }
                                r90VarA2.e = range5;
                                oz0 oz0Var4 = jgVar4.d;
                                if (oz0Var4 == null) {
                                    zo2.n("Null dynamicRange");
                                    return r40;
                                }
                                r90VarA2.c = oz0Var4;
                                r90VarA2.f = rxVarB;
                                map8.put(jgVar4, r90VarA2.e());
                            }
                            map9 = map6;
                        } else {
                            map9 = map6;
                            if (!map9.containsKey(Integer.valueOf(i20))) {
                                xe.i("SurfaceConfig does not map to any use case");
                                return r40;
                            }
                            Object obj = map9.get(Integer.valueOf(i20));
                            obj.getClass();
                            mn4 mn4Var6 = (mn4) obj;
                            ih ihVar = (ih) map19.get(mn4Var6);
                            ihVar.getClass();
                            ka0 ka0Var3 = ihVar.f;
                            ka0Var3.getClass();
                            rx rxVarB2 = e44.b(ka0Var3, Long.valueOf(j));
                            if (rxVarB2 != null) {
                                r90 r90VarB = ihVar.b();
                                r90VarB.f = rxVarB2;
                                map19.put(mn4Var6, r90VarB.e());
                            }
                        }
                        i20++;
                        r233 = r2;
                        map5 = map25;
                        map6 = map9;
                    }
                }
                return new k74(map19, map8, i18);
            }
            mn4 mn4Var7 = (mn4) arrayList2.get(((Integer) it4.next()).intValue());
            List<Size> list14 = (List) map15.get(mn4Var7);
            if (list14 == null) {
                list14 = Collections.EMPTY_LIST;
            }
            int iN3 = mn4Var7.n();
            q84 q84Var = r64Var3.z;
            sy syVar = r64Var3.m;
            q84Var.getClass();
            int i21 = (((Nexus4AndroidLTargetAspectRatioQuirk) xt0.a.z(Nexus4AndroidLTargetAspectRatioQuirk.class)) == null && ((AspectRatioLegacyApi21Quirk) p95.m(syVar).z(AspectRatioLegacyApi21Quirk.class)) == null) ? 3 : 2;
            if (i21 == 2) {
                Size size8 = (Size) r64Var3.l(256).f.get(256);
                if (size8 != null) {
                    rational = new Rational(size8.getWidth(), size8.getHeight());
                }
            } else if (i21 != 3) {
                xe.i(dw2.A(i21, "Undefined targetAspectRatio: "));
                return null;
            }
            if (rational != null) {
                ArrayList arrayList12 = new ArrayList();
                ArrayList arrayList13 = new ArrayList();
                for (Size size9 : list14) {
                    if (af.a(rational, size9)) {
                        arrayList12.add(size9);
                    } else {
                        arrayList13.add(size9);
                    }
                }
                arrayList13.addAll(0, arrayList12);
                list14 = arrayList13;
            }
            oj1 oj1Var = r64Var3.A;
            v64 v64Var = (v64) w64.h.get(Integer.valueOf(iN3));
            if (v64Var == null) {
                v64Var = v64.b;
            }
            if (((ExtraCroppingQuirk) oj1Var.f) != null && (sizeB = ExtraCroppingQuirk.b(v64Var)) != null) {
                ArrayList arrayList14 = new ArrayList();
                arrayList14.add(sizeB);
                for (Size size10 : list14) {
                    if (!size10.equals(sizeB)) {
                        arrayList14.add(size10);
                    }
                }
                list14 = arrayList14;
            }
            arrayList9.add(list14);
        }
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
