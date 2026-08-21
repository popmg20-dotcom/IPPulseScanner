package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.work.impl.WorkDatabase;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import io.netty.handler.codec.dns.DnsRecord;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ye {
    public static final ge0[] a = new ge0[0];
    public static final zl b = new zl();
    public static final boolean[] c = new boolean[3];
    public static final String[] d = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};
    public static final String[] e = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_lair", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};
    public static Boolean f;

    public static final String A() {
        Context context = ContextUtilsKt.getContext();
        String property = System.getProperty("http.agent");
        if (property == null) {
            property = "";
        }
        PackageManager packageManager = context.getPackageManager();
        packageManager.getClass();
        String packageName = context.getPackageName();
        packageName.getClass();
        return fw.u("Surfboard Profile Fetcher/", k2.e(packageManager, packageName, 0).versionName, " ", property);
    }

    public static void B(int i, rb0 rb0Var, jc0 jc0Var, boolean z) {
        lb0 lb0Var;
        lb0 lb0Var2;
        boolean z2;
        lb0 lb0Var3;
        lb0 lb0Var4;
        if (jc0Var.m) {
            return;
        }
        if (!(jc0Var instanceof kc0) && jc0Var.x() && c(jc0Var)) {
            kc0.R(jc0Var, rb0Var, new zl());
        }
        lb0 lb0VarG = jc0Var.g(2);
        lb0 lb0VarG2 = jc0Var.g(4);
        int iC = lb0VarG.c();
        int iC2 = lb0VarG2.c();
        HashSet<lb0> hashSet = lb0VarG.a;
        if (hashSet != null && lb0VarG.c) {
            for (lb0 lb0Var5 : hashSet) {
                jc0 jc0Var2 = lb0Var5.d;
                int i2 = i + 1;
                boolean zC = c(jc0Var2);
                lb0 lb0Var6 = jc0Var2.H;
                lb0 lb0Var7 = jc0Var2.J;
                if (jc0Var2.x() && zC) {
                    z2 = true;
                    kc0.R(jc0Var2, rb0Var, new zl());
                } else {
                    z2 = true;
                }
                boolean z3 = ((lb0Var5 == lb0Var6 && (lb0Var4 = lb0Var7.f) != null && lb0Var4.c) || (lb0Var5 == lb0Var7 && (lb0Var3 = lb0Var6.f) != null && lb0Var3.c)) ? z2 : false;
                int i3 = jc0Var2.o0[0];
                if (i3 != 3 || zC) {
                    if (!jc0Var2.x()) {
                        if (lb0Var5 == lb0Var6 && lb0Var7.f == null) {
                            int iD = lb0Var6.d() + iC;
                            jc0Var2.F(iD, jc0Var2.o() + iD);
                            B(i2, rb0Var, jc0Var2, z);
                        } else if (lb0Var5 == lb0Var7 && lb0Var6.f == null) {
                            int iD2 = iC - lb0Var7.d();
                            jc0Var2.F(iD2 - jc0Var2.o(), iD2);
                            B(i2, rb0Var, jc0Var2, z);
                        } else if (z3 && !jc0Var2.v()) {
                            I(i2, rb0Var, jc0Var2, z);
                        }
                    }
                } else if (i3 == 3 && jc0Var2.v >= 0 && jc0Var2.u >= 0 && (jc0Var2.f0 == 8 || (jc0Var2.r == 0 && jc0Var2.V == 0.0f))) {
                    if (!jc0Var2.v() && z3 && !jc0Var2.v()) {
                        J(i2, jc0Var, rb0Var, jc0Var2, z);
                    }
                }
            }
        }
        if (jc0Var instanceof nq1) {
            return;
        }
        HashSet<lb0> hashSet2 = lb0VarG2.a;
        if (hashSet2 != null && lb0VarG2.c) {
            for (lb0 lb0Var8 : hashSet2) {
                jc0 jc0Var3 = lb0Var8.d;
                int i4 = i + 1;
                boolean zC2 = c(jc0Var3);
                lb0 lb0Var9 = jc0Var3.H;
                lb0 lb0Var10 = jc0Var3.J;
                if (jc0Var3.x() && zC2) {
                    kc0.R(jc0Var3, rb0Var, new zl());
                }
                boolean z4 = (lb0Var8 == lb0Var9 && (lb0Var2 = lb0Var10.f) != null && lb0Var2.c) || (lb0Var8 == lb0Var10 && (lb0Var = lb0Var9.f) != null && lb0Var.c);
                int i5 = jc0Var3.o0[0];
                if (i5 != 3 || zC2) {
                    if (!jc0Var3.x()) {
                        if (lb0Var8 == lb0Var9 && lb0Var10.f == null) {
                            int iD3 = lb0Var9.d() + iC2;
                            jc0Var3.F(iD3, jc0Var3.o() + iD3);
                            B(i4, rb0Var, jc0Var3, z);
                        } else if (lb0Var8 == lb0Var10 && lb0Var9.f == null) {
                            int iD4 = iC2 - lb0Var10.d();
                            jc0Var3.F(iD4 - jc0Var3.o(), iD4);
                            B(i4, rb0Var, jc0Var3, z);
                        } else if (z4 && !jc0Var3.v()) {
                            I(i4, rb0Var, jc0Var3, z);
                        }
                    }
                } else if (i5 == 3 && jc0Var3.v >= 0 && jc0Var3.u >= 0) {
                    if (jc0Var3.f0 == 8 || (jc0Var3.r == 0 && jc0Var3.V == 0.0f)) {
                        if (!jc0Var3.v() && z4 && !jc0Var3.v()) {
                            J(i4, jc0Var, rb0Var, jc0Var3, z);
                        }
                    }
                }
            }
        }
        jc0Var.m = true;
    }

    public static int C(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        xe.k(dw2.A(i, "type needs to be >= FIRST and <= LAST, type="));
        return 0;
    }

    public static final void D(Logger logger, ua4 ua4Var, za4 za4Var, String str) {
        logger.fine(za4Var.b + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + ua4Var.a);
    }

    public static final boolean E(tn3 tn3Var, String str, int i) {
        if (i > 16) {
            return false;
        }
        if (!(tn3Var instanceof jn3)) {
            return fx3.u(tn3Var, null, str, null, null, null, null, null, null, null, null, null, null, null, 0);
        }
        List list = ((jn3) tn3Var).z;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (E((tn3) it.next(), str, i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void F(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static void H(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            rf4.a(view, charSequence);
            return;
        }
        tf4 tf4Var = tf4.B0;
        if (tf4Var != null && tf4Var.b == view) {
            tf4.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new tf4(view, charSequence);
            return;
        }
        tf4 tf4Var2 = tf4.C0;
        if (tf4Var2 != null && tf4Var2.b == view) {
            tf4Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static void I(int i, rb0 rb0Var, jc0 jc0Var, boolean z) {
        float f2 = jc0Var.c0;
        lb0 lb0Var = jc0Var.H;
        int iC = lb0Var.f.c();
        lb0 lb0Var2 = jc0Var.J;
        int iC2 = lb0Var2.f.c();
        int iD = lb0Var.d() + iC;
        int iD2 = iC2 - lb0Var2.d();
        if (iC == iC2) {
            f2 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int iO = jc0Var.o();
        int i2 = (iC2 - iC) - iO;
        if (iC > iC2) {
            i2 = (iC - iC2) - iO;
        }
        int i3 = ((int) (i2 > 0 ? (f2 * i2) + 0.5f : f2 * i2)) + iC;
        int i4 = i3 + iO;
        if (iC > iC2) {
            i4 = i3 - iO;
        }
        jc0Var.F(i3, i4);
        B(i + 1, rb0Var, jc0Var, z);
    }

    public static void J(int i, jc0 jc0Var, rb0 rb0Var, jc0 jc0Var2, boolean z) {
        float f2 = jc0Var2.c0;
        lb0 lb0Var = jc0Var2.H;
        int iD = lb0Var.d() + lb0Var.f.c();
        lb0 lb0Var2 = jc0Var2.J;
        int iC = lb0Var2.f.c() - lb0Var2.d();
        if (iC >= iD) {
            int iO = jc0Var2.o();
            if (jc0Var2.f0 != 8) {
                int i2 = jc0Var2.r;
                if (i2 == 2) {
                    iO = (int) (jc0Var2.c0 * 0.5f * (jc0Var instanceof kc0 ? jc0Var.o() : jc0Var.S.o()));
                } else if (i2 == 0) {
                    iO = iC - iD;
                }
                iO = Math.max(jc0Var2.u, iO);
                int i3 = jc0Var2.v;
                if (i3 > 0) {
                    iO = Math.min(i3, iO);
                }
            }
            int i4 = iD + ((int) ((f2 * ((iC - iD) - iO)) + 0.5f));
            jc0Var2.F(i4, iO + i4);
            B(i + 1, rb0Var, jc0Var2, z);
        }
    }

    public static void K(int i, rb0 rb0Var, jc0 jc0Var) {
        float f2 = jc0Var.d0;
        lb0 lb0Var = jc0Var.I;
        int iC = lb0Var.f.c();
        lb0 lb0Var2 = jc0Var.K;
        int iC2 = lb0Var2.f.c();
        int iD = lb0Var.d() + iC;
        int iD2 = iC2 - lb0Var2.d();
        if (iC == iC2) {
            f2 = 0.5f;
        } else {
            iC = iD;
            iC2 = iD2;
        }
        int i2 = jc0Var.i();
        int i3 = (iC2 - iC) - i2;
        if (iC > iC2) {
            i3 = (iC - iC2) - i2;
        }
        int i4 = (int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3);
        int i5 = iC + i4;
        int i6 = i5 + i2;
        if (iC > iC2) {
            i5 = iC - i4;
            i6 = i5 - i2;
        }
        jc0Var.G(i5, i6);
        M(i + 1, rb0Var, jc0Var);
    }

    public static void L(int i, jc0 jc0Var, rb0 rb0Var, jc0 jc0Var2) {
        float f2 = jc0Var2.d0;
        lb0 lb0Var = jc0Var2.I;
        int iD = lb0Var.d() + lb0Var.f.c();
        lb0 lb0Var2 = jc0Var2.K;
        int iC = lb0Var2.f.c() - lb0Var2.d();
        if (iC >= iD) {
            int i2 = jc0Var2.i();
            if (jc0Var2.f0 != 8) {
                int i3 = jc0Var2.s;
                if (i3 == 2) {
                    i2 = (int) (f2 * 0.5f * (jc0Var instanceof kc0 ? jc0Var.i() : jc0Var.S.i()));
                } else if (i3 == 0) {
                    i2 = iC - iD;
                }
                i2 = Math.max(jc0Var2.x, i2);
                int i4 = jc0Var2.y;
                if (i4 > 0) {
                    i2 = Math.min(i4, i2);
                }
            }
            int i5 = iD + ((int) ((f2 * ((iC - iD) - i2)) + 0.5f));
            jc0Var2.G(i5, i2 + i5);
            M(i + 1, rb0Var, jc0Var2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M(int i, rb0 rb0Var, jc0 jc0Var) {
        lb0 lb0Var;
        lb0 lb0Var2;
        lb0 lb0Var3;
        lb0 lb0Var4;
        if (jc0Var.n) {
            return;
        }
        if (!(jc0Var instanceof kc0) && jc0Var.x() && c(jc0Var)) {
            kc0.R(jc0Var, rb0Var, new zl());
        }
        lb0 lb0VarG = jc0Var.g(3);
        lb0 lb0VarG2 = jc0Var.g(5);
        int iC = lb0VarG.c();
        int iC2 = lb0VarG2.c();
        HashSet<lb0> hashSet = lb0VarG.a;
        if (hashSet != null && lb0VarG.c) {
            for (lb0 lb0Var5 : hashSet) {
                jc0 jc0Var2 = lb0Var5.d;
                int i2 = i + 1;
                boolean zC = c(jc0Var2);
                lb0 lb0Var6 = jc0Var2.I;
                lb0 lb0Var7 = jc0Var2.K;
                if (jc0Var2.x() && zC) {
                    kc0.R(jc0Var2, rb0Var, new zl());
                }
                boolean z = (lb0Var5 == lb0Var6 && (lb0Var4 = lb0Var7.f) != null && lb0Var4.c) || (lb0Var5 == lb0Var7 && (lb0Var3 = lb0Var6.f) != null && lb0Var3.c);
                int i3 = jc0Var2.o0[1];
                if (i3 != 3 || zC) {
                    if (!jc0Var2.x()) {
                        if (lb0Var5 == lb0Var6 && lb0Var7.f == null) {
                            int iD = lb0Var6.d() + iC;
                            jc0Var2.G(iD, jc0Var2.i() + iD);
                            M(i2, rb0Var, jc0Var2);
                        } else if (lb0Var5 == lb0Var7 && lb0Var6.f == null) {
                            int iD2 = iC - lb0Var7.d();
                            jc0Var2.G(iD2 - jc0Var2.i(), iD2);
                            M(i2, rb0Var, jc0Var2);
                        } else if (z && !jc0Var2.w()) {
                            K(i2, rb0Var, jc0Var2);
                        }
                    }
                } else if (i3 == 3 && jc0Var2.y >= 0 && jc0Var2.x >= 0 && (jc0Var2.f0 == 8 || (jc0Var2.s == 0 && jc0Var2.V == 0.0f))) {
                    if (!jc0Var2.w() && z && !jc0Var2.w()) {
                        L(i2, jc0Var, rb0Var, jc0Var2);
                    }
                }
            }
        }
        char c2 = 1;
        if (jc0Var instanceof nq1) {
            return;
        }
        HashSet<lb0> hashSet2 = lb0VarG2.a;
        if (hashSet2 != null && lb0VarG2.c) {
            for (lb0 lb0Var8 : hashSet2) {
                jc0 jc0Var3 = lb0Var8.d;
                int i4 = i + 1;
                boolean zC2 = c(jc0Var3);
                lb0 lb0Var9 = jc0Var3.I;
                lb0 lb0Var10 = jc0Var3.K;
                if (jc0Var3.x() && zC2) {
                    kc0.R(jc0Var3, rb0Var, new zl());
                }
                boolean z2 = (lb0Var8 == lb0Var9 && (lb0Var2 = lb0Var10.f) != null && lb0Var2.c) || (lb0Var8 == lb0Var10 && (lb0Var = lb0Var9.f) != null && lb0Var.c);
                int i5 = jc0Var3.o0[1];
                if (i5 != 3 || zC2) {
                    if (!jc0Var3.x()) {
                        if (lb0Var8 == lb0Var9 && lb0Var10.f == null) {
                            int iD3 = lb0Var9.d() + iC2;
                            jc0Var3.G(iD3, jc0Var3.i() + iD3);
                            M(i4, rb0Var, jc0Var3);
                        } else if (lb0Var8 == lb0Var10 && lb0Var9.f == null) {
                            int iD4 = iC2 - lb0Var10.d();
                            jc0Var3.G(iD4 - jc0Var3.i(), iD4);
                            M(i4, rb0Var, jc0Var3);
                        } else if (z2 && !jc0Var3.w()) {
                            K(i4, rb0Var, jc0Var3);
                        }
                    }
                } else if (i5 == 3 && jc0Var3.y >= 0 && jc0Var3.x >= 0 && (jc0Var3.f0 == 8 || (jc0Var3.s == 0 && jc0Var3.V == 0.0f))) {
                    if (!jc0Var3.w() && z2 && !jc0Var3.w()) {
                        L(i4, jc0Var, rb0Var, jc0Var3);
                    }
                }
            }
        }
        lb0 lb0VarG3 = jc0Var.g(6);
        if (lb0VarG3.a != null && lb0VarG3.c) {
            int iC3 = lb0VarG3.c();
            for (lb0 lb0Var11 : lb0VarG3.a) {
                jc0 jc0Var4 = lb0Var11.d;
                int i6 = i + 1;
                boolean zC3 = c(jc0Var4);
                lb0 lb0Var12 = jc0Var4.L;
                if (jc0Var4.x() && zC3) {
                    kc0.R(jc0Var4, rb0Var, new zl());
                }
                if (jc0Var4.o0[c2] != 3 || zC3) {
                    if (jc0Var4.x()) {
                        continue;
                    } else if (lb0Var11 == lb0Var12) {
                        int iD5 = lb0Var11.d() + iC3;
                        if (jc0Var4.E) {
                            int i7 = iD5 - jc0Var4.Z;
                            int i8 = jc0Var4.U + i7;
                            jc0Var4.Y = i7;
                            jc0Var4.I.i(i7);
                            jc0Var4.K.i(i8);
                            lb0Var12.i(iD5);
                            jc0Var4.l = c2;
                        }
                        M(i6, rb0Var, jc0Var4);
                    }
                }
                c2 = 1;
            }
        }
        jc0Var.n = true;
    }

    public static void N(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iV = V(parcel, i);
        parcel.writeBundle(bundle);
        W(parcel, iV);
    }

    public static void O(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iV = V(parcel, i);
        parcel.writeStrongBinder(iBinder);
        W(parcel, iV);
    }

    public static void P(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int iV = V(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        W(parcel, iV);
    }

    public static void Q(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iV = V(parcel, i);
        parcel.writeString(str);
        W(parcel, iV);
    }

    public static void R(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iV = V(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i2);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        W(parcel, iV);
    }

    public static void S(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iV = V(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        W(parcel, iV);
    }

    public static String T(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static void U(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public static int V(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void W(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.ti1 a(java.lang.String r8, java.lang.Object[] r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L13
            int r1 = r9.length
            if (r1 != 0) goto L7
            goto L13
        L7:
            int r1 = r9.length
            int r1 = r1 + (-1)
            r1 = r9[r1]
            boolean r2 = r1 instanceof java.lang.Throwable
            if (r2 == 0) goto L13
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            goto L14
        L13:
            r1 = r0
        L14:
            r2 = 0
            if (r1 == 0) goto L2e
            if (r9 == 0) goto L28
            int r3 = r9.length
            if (r3 == 0) goto L28
            int r3 = r9.length
            int r3 = r3 + (-1)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            if (r3 <= 0) goto L26
            java.lang.System.arraycopy(r9, r2, r4, r2, r3)
        L26:
            r9 = r4
            goto L2e
        L28:
            java.lang.String r8 = "non-sensical empty or null argument array"
            defpackage.xe.q(r8)
            return r0
        L2e:
            if (r8 != 0) goto L36
            ti1 r8 = new ti1
            r8.<init>(r0, r9, r1)
            return r8
        L36:
            if (r9 != 0) goto L3e
            ti1 r9 = new ti1
            r9.<init>(r8, r0, r0)
            return r9
        L3e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r3 = r8.length()
            int r3 = r3 + 50
            r0.<init>(r3)
            r3 = r2
        L4a:
            int r4 = r9.length
            if (r2 >= r4) goto Lb6
            java.lang.String r4 = "{}"
            int r4 = r8.indexOf(r4, r3)
            r5 = -1
            if (r4 != r5) goto L6f
            if (r3 != 0) goto L5e
            ti1 r0 = new ti1
            r0.<init>(r8, r9, r1)
            return r0
        L5e:
            int r2 = r8.length()
            r0.append(r8, r3, r2)
            ti1 r8 = new ti1
            java.lang.String r0 = r0.toString()
            r8.<init>(r0, r9, r1)
            return r8
        L6f:
            if (r4 != 0) goto L72
            goto La5
        L72:
            int r5 = r4 + (-1)
            char r6 = r8.charAt(r5)
            r7 = 92
            if (r6 != r7) goto La5
            r6 = 2
            if (r4 < r6) goto L98
            int r6 = r4 + (-2)
            char r6 = r8.charAt(r6)
            if (r6 != r7) goto L98
            r0.append(r8, r3, r5)
            r3 = r9[r2]
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            i(r0, r3, r5)
        L94:
            int r4 = r4 + 2
        L96:
            r3 = r4
            goto Lb3
        L98:
            int r2 = r2 + (-1)
            r0.append(r8, r3, r5)
            r3 = 123(0x7b, float:1.72E-43)
            r0.append(r3)
            int r4 = r4 + 1
            goto L96
        La5:
            r0.append(r8, r3, r4)
            r3 = r9[r2]
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            i(r0, r3, r5)
            goto L94
        Lb3:
            int r2 = r2 + 1
            goto L4a
        Lb6:
            int r2 = r8.length()
            r0.append(r8, r3, r2)
            ti1 r8 = new ti1
            java.lang.String r0 = r0.toString()
            r8.<init>(r0, r9, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.a(java.lang.String, java.lang.Object[]):ti1");
    }

    public static void b(long j, hp hpVar, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        ArrayList arrayList3;
        long j2;
        int i6;
        int i7 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i2 >= i3) {
            xe.k("Failed requirement.");
            return;
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((bu) arrayList4.get(i8)).d() < i7) {
                xe.k("Failed requirement.");
                return;
            }
        }
        bu buVar = (bu) arrayList.get(i2);
        bu buVar2 = (bu) arrayList4.get(i3 - 1);
        if (i7 == buVar.d()) {
            int iIntValue = ((Number) arrayList5.get(i2)).intValue();
            int i9 = i2 + 1;
            bu buVar3 = (bu) arrayList4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            buVar = buVar3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (buVar.i(i7) == buVar2.i(i7)) {
            int iMin = Math.min(buVar.d(), buVar2.d());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && buVar.i(i11) == buVar2.i(i11); i11++) {
                i10++;
            }
            long j3 = (hpVar.f / 4) + j + 2 + ((long) i10) + 1;
            hpVar.M0(-i10);
            hpVar.M0(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                hpVar.M0(buVar.i(i7) & DnsRecord.CLASS_ANY);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 == ((bu) arrayList4.get(i4)).d()) {
                    hpVar.M0(((Number) arrayList5.get(i4)).intValue());
                    return;
                } else {
                    xe.q("Check failed.");
                    return;
                }
            }
            hp hpVar2 = new hp();
            hpVar.M0(((int) ((hpVar2.f / 4) + j3)) * (-1));
            b(j3, hpVar2, i12, arrayList4, i4, i3, arrayList5);
            hpVar.A(hpVar2);
            return;
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((bu) arrayList4.get(i14 - 1)).i(i7) != ((bu) arrayList4.get(i14)).i(i7)) {
                i13++;
            }
        }
        long j4 = (hpVar.f / 4) + j + 2 + ((long) (i13 * 2));
        hpVar.M0(i13);
        hpVar.M0(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int i16 = ((bu) arrayList4.get(i15)).i(i7);
            if (i15 == i4 || i16 != ((bu) arrayList4.get(i15 - 1)).i(i7)) {
                hpVar.M0(i16 & DnsRecord.CLASS_ANY);
            }
        }
        hp hpVar3 = new hp();
        int i17 = i4;
        while (i17 < i3) {
            byte bI = ((bu) arrayList4.get(i17)).i(i7);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i3) {
                    i19 = i3;
                    break;
                } else if (bI != ((bu) arrayList4.get(i19)).i(i7)) {
                    break;
                } else {
                    i19++;
                }
            }
            if (i18 == i19 && i7 + 1 == ((bu) arrayList4.get(i17)).d()) {
                hpVar.M0(((Number) arrayList5.get(i17)).intValue());
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i19;
            } else {
                hpVar.M0(((int) ((hpVar3.f / 4) + j4)) * (-1));
                arrayList3 = arrayList5;
                j2 = j4;
                i6 = i19;
                b(j2, hpVar3, i7 + 1, arrayList, i17, i6, arrayList3);
                arrayList4 = arrayList;
            }
            j4 = j2;
            i17 = i6;
            arrayList5 = arrayList3;
        }
        hpVar.A(hpVar3);
    }

    public static boolean c(jc0 jc0Var) {
        int[] iArr = jc0Var.o0;
        int i = iArr[0];
        int i2 = iArr[1];
        kc0 kc0Var = jc0Var.S;
        if (kc0Var == null) {
            kc0Var = null;
        }
        if (kc0Var != null) {
            int i3 = kc0Var.o0[0];
        }
        if (kc0Var != null) {
            int i4 = kc0Var.o0[1];
        }
        boolean z = i == 1 || jc0Var.y() || i == 2 || (i == 3 && jc0Var.r == 0 && jc0Var.V == 0.0f && jc0Var.r(0)) || (i == 3 && jc0Var.r == 1 && jc0Var.s(0, jc0Var.o()));
        boolean z2 = i2 == 1 || jc0Var.z() || i2 == 2 || (i2 == 3 && jc0Var.s == 0 && jc0Var.V == 0.0f && jc0Var.r(1)) || (i2 == 3 && jc0Var.s == 1 && jc0Var.s(1, jc0Var.i()));
        return (jc0Var.V > 0.0f && (z || z2)) || (z && z2);
    }

    public static final void d(xw4 xw4Var, String str) {
        yx4 yx4VarB;
        WorkDatabase workDatabase = xw4Var.c;
        workDatabase.getClass();
        jx4 jx4VarX = workDatabase.x();
        mo0 mo0VarS = workDatabase.s();
        ArrayList arrayListL = e70.L(str);
        while (!arrayListL.isEmpty()) {
            String str2 = (String) d70.p0(arrayListL);
            ww4 ww4VarB = jx4VarX.b(str2);
            if (ww4VarB != ww4.z && ww4VarB != ww4.A) {
                ((Number) ke0.r(jx4VarX.a, false, true, new ko0(str2, 17))).intValue();
            }
            arrayListL.addAll(mo0VarS.a(str2));
        }
        n53 n53Var = xw4Var.f;
        n53Var.getClass();
        synchronized (n53Var.k) {
            ue2.g().a(n53.l, "Processor cancelling " + str);
            n53Var.i.add(str);
            yx4VarB = n53Var.b(str);
        }
        n53.e(str, yx4VarB, 1);
        Iterator it = xw4Var.e.iterator();
        while (it.hasNext()) {
            ((dq3) it.next()).d(str);
        }
    }

    public static void e(kc0 kc0Var, gb2 gb2Var, jc0 jc0Var) {
        jc0Var.o = -1;
        lb0 lb0Var = jc0Var.L;
        int[] iArr = jc0Var.o0;
        lb0 lb0Var2 = jc0Var.K;
        lb0 lb0Var3 = jc0Var.I;
        lb0 lb0Var4 = jc0Var.J;
        lb0 lb0Var5 = jc0Var.H;
        jc0Var.p = -1;
        int[] iArr2 = kc0Var.o0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = lb0Var5.g;
            int iO = kc0Var.o() - lb0Var4.g;
            lb0Var5.i = gb2Var.k(lb0Var5);
            lb0Var4.i = gb2Var.k(lb0Var4);
            gb2Var.d(lb0Var5.i, i);
            gb2Var.d(lb0Var4.i, iO);
            jc0Var.o = 2;
            jc0Var.X = i;
            int i2 = iO - i;
            jc0Var.T = i2;
            int i3 = jc0Var.a0;
            if (i2 < i3) {
                jc0Var.T = i3;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i4 = lb0Var3.g;
        int i5 = kc0Var.i() - lb0Var2.g;
        lb0Var3.i = gb2Var.k(lb0Var3);
        lb0Var2.i = gb2Var.k(lb0Var2);
        gb2Var.d(lb0Var3.i, i4);
        gb2Var.d(lb0Var2.i, i5);
        if (jc0Var.Z > 0 || jc0Var.f0 == 8) {
            jz3 jz3VarK = gb2Var.k(lb0Var);
            lb0Var.i = jz3VarK;
            gb2Var.d(jz3VarK, jc0Var.Z + i4);
        }
        jc0Var.p = 2;
        jc0Var.Y = i4;
        int i6 = i5 - i4;
        jc0Var.U = i6;
        int i7 = jc0Var.b0;
        if (i6 < i7) {
            jc0Var.U = i7;
        }
    }

    public static int f(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
    
        return new defpackage.e03(r14, r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.e03 g(java.lang.String r11, java.lang.String[] r12, defpackage.ad1 r13, defpackage.ed1 r14, defpackage.pl1 r15) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.g(java.lang.String, java.lang.String[], ad1, ed1, pl1):e03");
    }

    public static void i(StringBuilder sb, Object obj, HashMap map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            try {
                sb.append(obj.toString());
                return;
            } catch (Throwable th) {
                co4.Q("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
                sb.append("[FAILED toString()]");
                return;
            }
        }
        int i = 0;
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            sb.append('[');
            int length = zArr.length;
            while (i < length) {
                sb.append(zArr[i]);
                if (i != length - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            sb.append('[');
            int length2 = bArr.length;
            while (i < length2) {
                sb.append((int) bArr[i]);
                if (i != length2 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            sb.append('[');
            int length3 = cArr.length;
            while (i < length3) {
                sb.append(cArr[i]);
                if (i != length3 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            sb.append('[');
            int length4 = sArr.length;
            while (i < length4) {
                sb.append((int) sArr[i]);
                if (i != length4 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            sb.append('[');
            int length5 = iArr.length;
            while (i < length5) {
                sb.append(iArr[i]);
                if (i != length5 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            sb.append('[');
            int length6 = jArr.length;
            while (i < length6) {
                sb.append(jArr[i]);
                if (i != length6 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            sb.append('[');
            int length7 = fArr.length;
            while (i < length7) {
                sb.append(fArr[i]);
                if (i != length7 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            sb.append('[');
            int length8 = dArr.length;
            while (i < length8) {
                sb.append(dArr[i]);
                if (i != length8 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            sb.append(']');
            return;
        }
        Object[] objArr = (Object[]) obj;
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length9 = objArr.length;
            while (i < length9) {
                i(sb, objArr[i], map);
                if (i != length9 - 1) {
                    sb.append(", ");
                }
                i++;
            }
            map.remove(objArr);
        }
        sb.append(']');
    }

    public static void j(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (yg0 yg0Var : (Set) it2.next()) {
                        for (ho0 ho0Var : yg0Var.a.c) {
                            if (ho0Var.c == 0) {
                                Set<yg0> set = (Set) map.get(new zg0(ho0Var.a, ho0Var.b == 2));
                                if (set != null) {
                                    for (yg0 yg0Var2 : set) {
                                        yg0Var.b.add(yg0Var2);
                                        yg0Var2.c.add(yg0Var);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet<yg0> hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                for (yg0 yg0Var3 : hashSet) {
                    if (yg0Var3.c.isEmpty()) {
                        hashSet2.add(yg0Var3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    yg0 yg0Var4 = (yg0) hashSet2.iterator().next();
                    hashSet2.remove(yg0Var4);
                    i++;
                    for (yg0 yg0Var5 : yg0Var4.b) {
                        yg0Var5.c.remove(yg0Var4);
                        if (yg0Var5.c.isEmpty()) {
                            hashSet2.add(yg0Var5);
                        }
                    }
                }
                if (i == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (yg0 yg0Var6 : hashSet) {
                    if (!yg0Var6.c.isEmpty() && !yg0Var6.b.isEmpty()) {
                        arrayList2.add(yg0Var6.a);
                    }
                }
                throw new jo0("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
            }
            x80 x80Var = (x80) it.next();
            yg0 yg0Var7 = new yg0(x80Var);
            for (fc3 fc3Var : x80Var.b) {
                boolean z = x80Var.e == 0;
                zg0 zg0Var = new zg0(fc3Var, !z);
                if (!map.containsKey(zg0Var)) {
                    map.put(zg0Var, new HashSet());
                }
                Set set2 = (Set) map.get(zg0Var);
                if (!set2.isEmpty() && z) {
                    st4.p("Multiple components provide ", fc3Var, ".");
                    return;
                }
                set2.add(yg0Var7);
            }
        }
    }

    public static final boolean k(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final j51 m(Enum[] enumArr) {
        enumArr.getClass();
        return new j51(enumArr);
    }

    public static final String n(ConcurrentHashMap concurrentHashMap, InetAddress inetAddress) {
        concurrentHashMap.getClass();
        synchronized (concurrentHashMap) {
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                Iterator it = ((Iterable) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (n12.c(((gx0) it.next()).c, inetAddress)) {
                        return (String) entry.getKey();
                    }
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o(defpackage.av r7, defpackage.ie0 r8) {
        /*
            boolean r0 = r8 instanceof defpackage.fh1
            if (r0 == 0) goto L13
            r0 = r8
            fh1 r0 = (defpackage.fh1) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            fh1 r0 = new fh1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.Y
            int r1 = r0.Z
            r2 = 0
            br1 r3 = defpackage.at2.a
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 != r4) goto L2e
            ch1 r7 = r0.X
            bh3 r1 = r0.A
            defpackage.n12.S(r8)     // Catch: defpackage.u -> L2c
            goto L63
        L2c:
            r8 = move-exception
            goto L57
        L2e:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r2
        L34:
            defpackage.n12.S(r8)
            bh3 r1 = new bh3
            r1.<init>()
            r1.b = r3
            ch1 r8 = new ch1
            r5 = 0
            r8.<init>(r1, r5)
            r0.A = r1     // Catch: defpackage.u -> L53
            r0.X = r8     // Catch: defpackage.u -> L53
            r0.Z = r4     // Catch: defpackage.u -> L53
            java.lang.Object r7 = r7.a(r8, r0)     // Catch: defpackage.u -> L53
            mf0 r8 = defpackage.mf0.b
            if (r7 != r8) goto L63
            return r8
        L53:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L57:
            java.lang.Object r4 = r8.b
            if (r4 != r7) goto L6e
            cf0 r7 = r0.f
            r7.getClass()
            defpackage.je.A(r7)
        L63:
            java.lang.Object r7 = r1.b
            if (r7 == r3) goto L68
            return r7
        L68:
            java.lang.String r7 = "Expected at least one element"
            defpackage.e04.h(r7)
            return r2
        L6e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.o(av, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(defpackage.zf1 r6, kotlin.jvm.functions.Function2 r7, defpackage.ie0 r8) {
        /*
            boolean r0 = r8 instanceof defpackage.gh1
            if (r0 == 0) goto L13
            r0 = r8
            gh1 r0 = (defpackage.gh1) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            gh1 r0 = new gh1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.Y
            int r1 = r0.Z
            r2 = 0
            br1 r3 = defpackage.at2.a
            r4 = 1
            if (r1 == 0) goto L34
            if (r1 != r4) goto L2e
            eh1 r6 = r0.X
            bh3 r7 = r0.A
            defpackage.n12.S(r8)     // Catch: defpackage.u -> L2c
            goto L65
        L2c:
            r8 = move-exception
            goto L59
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r2
        L34:
            defpackage.n12.S(r8)
            bh3 r8 = new bh3
            r8.<init>()
            r8.b = r3
            eh1 r1 = new eh1
            r5 = 0
            r1.<init>(r7, r8, r5)
            r0.A = r8     // Catch: defpackage.u -> L55
            r0.X = r1     // Catch: defpackage.u -> L55
            r0.Z = r4     // Catch: defpackage.u -> L55
            java.lang.Object r6 = r6.a(r1, r0)     // Catch: defpackage.u -> L55
            mf0 r7 = defpackage.mf0.b
            if (r6 != r7) goto L53
            return r7
        L53:
            r7 = r8
            goto L65
        L55:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r1
        L59:
            java.lang.Object r1 = r8.b
            if (r1 != r6) goto L70
            cf0 r6 = r0.f
            r6.getClass()
            defpackage.je.A(r6)
        L65:
            java.lang.Object r6 = r7.b
            if (r6 == r3) goto L6a
            return r6
        L6a:
            java.lang.String r6 = "Expected at least one element matching the predicate"
            defpackage.e04.h(r6)
            return r2
        L70:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.p(zf1, kotlin.jvm.functions.Function2, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(defpackage.zf1 r5, defpackage.ie0 r6) {
        /*
            boolean r0 = r6 instanceof defpackage.ih1
            if (r0 == 0) goto L13
            r0 = r6
            ih1 r0 = (defpackage.ih1) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            ih1 r0 = new ih1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.Y
            int r1 = r0.Z
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            ch1 r5 = r0.X
            bh3 r1 = r0.A
            defpackage.n12.S(r6)     // Catch: defpackage.u -> L29
            goto L5e
        L29:
            r6 = move-exception
            goto L52
        L2b:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            r5 = 0
            return r5
        L32:
            defpackage.n12.S(r6)
            bh3 r1 = new bh3
            r1.<init>()
            ch1 r6 = new ch1
            r6.<init>(r1, r2)
            r0.A = r1     // Catch: defpackage.u -> L4e
            r0.X = r6     // Catch: defpackage.u -> L4e
            r0.Z = r2     // Catch: defpackage.u -> L4e
            java.lang.Object r5 = r5.a(r6, r0)     // Catch: defpackage.u -> L4e
            mf0 r6 = defpackage.mf0.b
            if (r5 != r6) goto L5e
            return r6
        L4e:
            r5 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L52:
            java.lang.Object r2 = r6.b
            if (r2 != r5) goto L61
            cf0 r5 = r0.f
            r5.getClass()
            defpackage.je.A(r5)
        L5e:
            java.lang.Object r5 = r1.b
            return r5
        L61:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.q(zf1, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(defpackage.zf1 r4, kotlin.jvm.functions.Function2 r5, defpackage.ie0 r6) {
        /*
            boolean r0 = r6 instanceof defpackage.jh1
            if (r0 == 0) goto L13
            r0 = r6
            jh1 r0 = (defpackage.jh1) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            jh1 r0 = new jh1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.Y
            int r1 = r0.Z
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            eh1 r4 = r0.X
            bh3 r5 = r0.A
            defpackage.n12.S(r6)     // Catch: defpackage.u -> L29
            goto L60
        L29:
            r6 = move-exception
            goto L54
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L32:
            defpackage.n12.S(r6)
            bh3 r6 = new bh3
            r6.<init>()
            eh1 r1 = new eh1
            r1.<init>(r5, r6, r2)
            r0.A = r6     // Catch: defpackage.u -> L50
            r0.X = r1     // Catch: defpackage.u -> L50
            r0.Z = r2     // Catch: defpackage.u -> L50
            java.lang.Object r4 = r4.a(r1, r0)     // Catch: defpackage.u -> L50
            mf0 r5 = defpackage.mf0.b
            if (r4 != r5) goto L4e
            return r5
        L4e:
            r5 = r6
            goto L60
        L50:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r1
        L54:
            java.lang.Object r1 = r6.b
            if (r1 != r4) goto L63
            cf0 r4 = r0.f
            r4.getClass()
            defpackage.je.A(r4)
        L60:
            java.lang.Object r4 = r5.b
            return r4
        L63:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ye.r(zf1, kotlin.jvm.functions.Function2, ie0):java.lang.Object");
    }

    public static final String s(long j) {
        return String.format("%6s", Arrays.copyOf(new Object[]{j <= -999500000 ? dw2.C(new StringBuilder(), " s ", (j - 500000000) / 1000000000) : j <= -999500 ? dw2.C(new StringBuilder(), " ms", (j - 500000) / 1000000) : j <= 0 ? dw2.C(new StringBuilder(), " µs", (j - 500) / 1000) : j < 999500 ? dw2.C(new StringBuilder(), " µs", (j + 500) / 1000) : j < 999500000 ? dw2.C(new StringBuilder(), " ms", (j + 500000) / 1000000) : dw2.C(new StringBuilder(), " s ", (j + 500000000) / 1000000000)}, 1));
    }

    public static u04 t(int i) {
        if (i == 0) {
            return u04.d;
        }
        if (i == 1) {
            return u04.e;
        }
        if (i == 2) {
            return u04.f;
        }
        xe.k(dw2.A(i, "Unknown finish behavior:"));
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class u(j50 j50Var) {
        Class cls = j50Var.a;
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return cls;
    }

    public static final String w() {
        Configuration configuration = ContextUtilsKt.getContext().getResources().getConfiguration();
        Locale locale = (Build.VERSION.SDK_INT >= 24 ? new rd2(new ud2(ga5.k(configuration))) : rd2.a(configuration.locale)).a.get(0);
        if (locale == null) {
            return null;
        }
        if (n12.c(locale.getScript(), "Hans")) {
            return "zh_CN";
        }
        if (n12.c(locale.getScript(), "Hant")) {
            return "zh_HK";
        }
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static final int z(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                xe.k("Step is zero.");
                return 0;
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }

    public abstract int G(int i, int i2, byte[] bArr);

    public abstract String h(int i, int i2, byte[] bArr);

    public abstract int l(String str, byte[] bArr, int i, int i2);

    public abstract List v();

    public abstract ig2 x();

    public abstract List y();
}
