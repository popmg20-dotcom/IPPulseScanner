package defpackage;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.app.UiModeManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.hardware.camera2.CameraDevice;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.appbar.AppBarLayout;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class co4 {
    public static bo4 a = null;
    public static boolean b = false;
    public static final int[] c = new int[0];
    public static final Object[] d = new Object[0];
    public static final int[] e = {R.attr.theme, com.getsurfboard.R.attr.theme};
    public static final int[] f = {com.getsurfboard.R.attr.materialThemeOverlay};
    public static final int[] g = {R.attr.stateListAnimator};
    public static boolean h = true;
    public static Field i;
    public static boolean j;

    public static boolean E() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static final boolean H() {
        UiModeManager uiModeManager = (UiModeManager) ContextUtilsKt.getContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static final cf0 I(lf0 lf0Var, cf0 cf0Var) {
        cf0 cf0VarP = p(lf0Var.I(), cf0Var, true);
        gm0 gm0Var = qv0.a;
        return (cf0VarP == gm0Var || cf0VarP.Z(pr1.f) != null) ? cf0VarP : cf0VarP.X(gm0Var);
    }

    public static ev1 J(ev1 ev1Var) {
        ArrayList arrayList = ev1Var.f;
        int size = arrayList.size() - 1;
        if (!n12.c(arrayList.get(size), "")) {
            return ev1Var;
        }
        dv1 dv1VarG = ev1Var.g();
        ArrayList arrayList2 = dv1VarG.f;
        arrayList2.remove(size);
        if (arrayList2.isEmpty()) {
            arrayList2.add("");
        }
        return dv1VarG.a();
    }

    public static final Object K(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static void L(float[] fArr, float f2) {
        Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
        Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
    }

    public static void M(float[] fArr) {
        Matrix.translateM(fArr, 0, 0.0f, 0.5f, 0.0f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        Matrix.translateM(fArr, 0, -0.0f, -0.5f, 0.0f);
    }

    public static void N(int i2, byte[] bArr) {
        bArr[0] = (byte) i2;
        bArr[1] = (byte) (i2 >> 8);
        bArr[2] = (byte) (i2 >> 16);
        bArr[3] = (byte) (i2 >> 24);
        for (int i3 = 4; i3 <= 15; i3++) {
            bArr[i3] = 0;
        }
    }

    public static final CharSequence O() {
        ClipData.Item itemAt;
        try {
            Object systemService = ContextUtilsKt.getContext().getSystemService("clipboard");
            systemService.getClass();
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) {
                return null;
            }
            return itemAt.getText();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final void P(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void Q(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final Object R(Function2 function2) {
        Thread.interrupted();
        return ke0.z(c41.b, new gd(function2, null, 16));
    }

    public static void S(Runnable runnable) {
        if (E()) {
            runnable.run();
        } else {
            r25.j("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(runnable));
        }
    }

    public static int T(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i3 == 0) {
            i3 = i2 & DnsRecord.CLASS_ANY;
        }
        if (i4 == 8) {
            i4 = (i2 & 768) >>> 8;
        }
        int i8 = (i2 & 1024) != 0 ? 1 : 0;
        if (i5 == -1) {
            i5 = (i2 & 30720) >>> 11;
        }
        if (i6 == 0) {
            i6 = (16744448 & i2) >>> 15;
        }
        if (i7 == 0) {
            i7 = (i2 & (-16777216)) >>> 24;
        }
        return (i4 << 8) | i3 | (i8 << 10) | (i5 << 11) | (i6 << 15) | (i7 << 24);
    }

    public static void U(AppBarLayout appBarLayout, float f2) {
        int integer = appBarLayout.getResources().getInteger(com.getsurfboard.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, com.getsurfboard.R.attr.state_liftable, -com.getsurfboard.R.attr.state_lifted}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }

    public static final long Y(long j2, long j3, long j4, String str) {
        String property;
        int i2 = p94.a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lN0 = w44.n0(property);
        if (lN0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lN0.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int Z(int i2, int i3, String str) {
        return (int) Y(i2, 1L, (i3 & 8) != 0 ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : 2097150, str);
    }

    public static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return ek0.w("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return ek0.w("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        xe.k(dw2.A(i3, "negative size: "));
        return null;
    }

    public static final int b(int i2, int i3, int[] iArr) {
        iArr.getClass();
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static final int c(long[] jArr, int i2, long j2) {
        jArr.getClass();
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else {
                if (j3 <= j2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final bl4 c0(ge0 ge0Var, cf0 cf0Var, Object obj) {
        bl4 bl4Var = null;
        if ((ge0Var instanceof nf0) && cf0Var.Z(cl4.b) != null) {
            nf0 nf0VarC = (nf0) ge0Var;
            while (true) {
                if ((nf0VarC instanceof nv0) || (nf0VarC = nf0VarC.c()) == null) {
                    break;
                }
                if (nf0VarC instanceof bl4) {
                    bl4Var = (bl4) nf0VarC;
                    break;
                }
            }
            if (bl4Var != null) {
                bl4Var.p0(cf0Var, obj);
            }
        }
        return bl4Var;
    }

    public static final ge3 d(vx3 vx3Var) {
        vx3Var.getClass();
        return new ge3(vx3Var);
    }

    public static Context d0(Context context, AttributeSet attributeSet, int i2, int i3) {
        return e0(context, attributeSet, i2, i3, new int[0]);
    }

    public static Context e0(Context context, AttributeSet attributeSet, int i2, int i3, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f, i2, i3);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i4 = iArr2[0];
        boolean z = (context instanceof de0) && ((de0) context).a == i4;
        if (i4 == 0 || z) {
            return context;
        }
        de0 de0Var = new de0(context, i4);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i5 = 0; i5 < iArr.length; i5++) {
                iArr3[i5] = typedArrayObtainStyledAttributes2.getResourceId(i5, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr3[i6];
            if (i7 != 0) {
                de0Var.getTheme().applyStyle(i7, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, e);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            de0Var.getTheme().applyStyle(resourceId, true);
        }
        return de0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[Catch: SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:26:0x0044, B:28:0x0074, B:30:0x0082, B:32:0x008a, B:33:0x008d, B:34:0x00b6, B:38:0x00bc, B:40:0x00bf, B:42:0x00c7, B:43:0x00ce, B:44:0x00d1, B:46:0x00d7, B:49:0x00e6, B:50:0x00ea, B:27:0x006d), top: B:60:0x0044, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc A[Catch: SQLiteException -> 0x00b7, LOOP:1: B:38:0x00bc->B:43:0x00ce, LOOP_START, PHI: r1
      0x00bc: PHI (r1v5 int) = (r1v4 int), (r1v6 int) binds: [B:37:0x00ba, B:43:0x00ce] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:26:0x0044, B:28:0x0074, B:30:0x0082, B:32:0x008a, B:33:0x008d, B:34:0x00b6, B:38:0x00bc, B:40:0x00bf, B:42:0x00c7, B:43:0x00ce, B:44:0x00d1, B:46:0x00d7, B:49:0x00e6, B:50:0x00ea, B:27:0x006d), top: B:60:0x0044, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7 A[Catch: SQLiteException -> 0x00b7, TryCatch #1 {SQLiteException -> 0x00b7, blocks: (B:26:0x0044, B:28:0x0074, B:30:0x0082, B:32:0x008a, B:33:0x008d, B:34:0x00b6, B:38:0x00bc, B:40:0x00bf, B:42:0x00c7, B:43:0x00ce, B:44:0x00d1, B:46:0x00d7, B:49:0x00e6, B:50:0x00ea, B:27:0x006d), top: B:60:0x0044, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f0(t65 t65Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        Throwable th;
        Cursor cursorQuery;
        HashSet hashSet;
        Cursor cursorRawQuery;
        boolean zMoveToFirst;
        if (t65Var == null) {
            xe.k("Monitor must not be null");
            return;
        }
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase2 = sQLiteDatabase;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            sQLiteDatabase2 = sQLiteDatabase;
        }
        try {
            try {
                try {
                    cursorQuery = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                    try {
                        try {
                            zMoveToFirst = cursorQuery.moveToFirst();
                            cursorQuery.close();
                        } catch (SQLiteException e3) {
                            e = e3;
                            t65Var.C0.c("Error querying for table", str, e);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            throw th;
                        }
                        cursor.close();
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    cursorQuery = null;
                    t65Var.C0.c("Error querying for table", str, e);
                    if (cursorQuery != null) {
                    }
                    sQLiteDatabase2.execSQL(str2);
                    hashSet = new HashSet();
                    StringBuilder sb = new StringBuilder(str.length() + 22);
                    sb.append("SELECT * FROM ");
                    sb.append(str);
                    sb.append(" LIMIT 0");
                    cursorRawQuery = sQLiteDatabase2.rawQuery(sb.toString(), null);
                    Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                    cursorRawQuery.close();
                    while (i < r0) {
                    }
                    if (strArr != null) {
                    }
                    if (hashSet.isEmpty()) {
                    }
                }
                Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                cursorRawQuery.close();
                for (String str4 : str3.split(",")) {
                    if (!hashSet.remove(str4)) {
                        StringBuilder sb2 = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                        sb2.append("Table ");
                        sb2.append(str);
                        sb2.append(" is missing required column: ");
                        sb2.append(str4);
                        throw new SQLiteException(sb2.toString());
                    }
                }
                if (strArr != null) {
                    for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                        if (!hashSet.remove(strArr[i2])) {
                            sQLiteDatabase2.execSQL(strArr[i2 + 1]);
                        }
                    }
                }
                if (hashSet.isEmpty()) {
                    t65Var.C0.c("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                    return;
                }
                return;
            } catch (Throwable th4) {
                cursorRawQuery.close();
                throw th4;
            }
            hashSet = new HashSet();
            StringBuilder sb3 = new StringBuilder(str.length() + 22);
            sb3.append("SELECT * FROM ");
            sb3.append(str);
            sb3.append(" LIMIT 0");
            cursorRawQuery = sQLiteDatabase2.rawQuery(sb3.toString(), null);
        } catch (SQLiteException e5) {
            t65Var.z0.b(str, "Failed to verify columns on table that was just created");
            throw e5;
        }
        if (!zMoveToFirst) {
            sQLiteDatabase2.execSQL(str2);
        }
    }

    public static void g(int i2, int i3) {
        String strW;
        if (i2 < 0 || i2 >= i3) {
            if (i2 < 0) {
                strW = ek0.w("%s (%s) must not be negative", "index", Integer.valueOf(i2));
            } else {
                if (i3 < 0) {
                    xe.k(dw2.A(i3, "negative size: "));
                    return;
                }
                strW = ek0.w("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IndexOutOfBoundsException(strW);
        }
    }

    public static void g0(t65 t65Var, SQLiteDatabase sQLiteDatabase) {
        if (t65Var == null) {
            xe.k("Monitor must not be null");
            return;
        }
        q65 q65Var = t65Var.C0;
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            q65Var.a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            q65Var.a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            q65Var.a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        q65Var.a("Failed to turn on database write permission for owner");
    }

    public static void h() {
        r25.j("Not in application's main thread", E());
    }

    public static void i(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            s53.k(a(i2, i3, "index"));
        }
    }

    public static void j(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? a(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? a(i3, i4, "end index") : ek0.w("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static final boolean k(String str) {
        str.getClass();
        try {
            Object systemService = ContextUtilsKt.getContext().getSystemService("clipboard");
            systemService.getClass();
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("text", str));
            return true;
        } catch (SecurityException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static CameraDevice.StateCallback l(ArrayList arrayList) {
        return arrayList.isEmpty() ? new fz() : arrayList.size() == 1 ? (CameraDevice.StateCallback) arrayList.get(0) : new ez(arrayList);
    }

    public static boolean m(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = m(file2) && z;
        }
        return z;
    }

    public static byte[] n(byte[] bArr, char[] cArr, int i2, boolean z) throws qy4 {
        byte[] bArr2 = bArr;
        int i3 = fw.i(i2);
        int iJ = fw.j(i2);
        int i4 = i3 + iJ + 2;
        cArr.getClass();
        byte[] bArrK = yr2.k(cArr, z);
        int i5 = 0;
        qt qtVar = new qt((byte) 0, 11);
        qtVar.k(bArrK);
        int i6 = i4 == 0 ? qtVar.b : i4;
        int i7 = qtVar.b;
        int i8 = (i6 / i7) + (i6 % i7 > 0 ? 1 : 0);
        int i9 = i6 - ((i8 - 1) * i7);
        byte[] bArr3 = new byte[i8 * i7];
        int i10 = 0;
        int i11 = 1;
        while (i11 <= i8) {
            int i12 = qtVar.b;
            byte[] bArr4 = new byte[i12];
            byte[] bArrDoFinal = new byte[bArr2.length + 4];
            int i13 = i3;
            System.arraycopy(bArr2, i5, bArrDoFinal, i5, bArr2.length);
            int length = bArr2.length;
            bArrDoFinal[length] = (byte) (i11 / 16777216);
            bArrDoFinal[length + 1] = (byte) (i11 / 65536);
            bArrDoFinal[length + 2] = (byte) (i11 / 256);
            bArrDoFinal[length + 3] = (byte) i11;
            for (int i14 = 0; i14 < 1000; i14++) {
                if (((ByteArrayOutputStream) qtVar.d).size() > 0) {
                    qtVar.g(0);
                }
                bArrDoFinal = ((Mac) qtVar.c).doFinal(bArrDoFinal);
                for (int i15 = 0; i15 < i12; i15++) {
                    bArr4[i15] = (byte) (bArr4[i15] ^ bArrDoFinal[i15]);
                }
            }
            System.arraycopy(bArr4, 0, bArr3, i10, i12);
            i10 += i7;
            i11++;
            bArr2 = bArr;
            i5 = 0;
            i3 = i13;
        }
        int i16 = i3;
        int i17 = i5;
        if (i9 < i7) {
            byte[] bArr5 = new byte[i6];
            System.arraycopy(bArr3, i17, bArr5, i17, i6);
            bArr3 = bArr5;
        }
        if (bArr3.length == i4) {
            return bArr3;
        }
        Integer numValueOf = Integer.valueOf(i16);
        Integer numValueOf2 = Integer.valueOf(iJ);
        Object[] objArr = new Object[2];
        objArr[i17] = numValueOf;
        objArr[1] = numValueOf2;
        throw new qy4(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", objArr));
    }

    public static final void o(FileOutputStream fileOutputStream) {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("logcat -t 3000 *:V").getInputStream();
            try {
                inputStream.getClass();
                l72.h(inputStream, fileOutputStream);
                inputStream.close();
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            String message = e2.getMessage();
            if (message != null) {
                byte[] bytes = message.getBytes(y30.a);
                bytes.getClass();
                l72.h(new ByteArrayInputStream(bytes), fileOutputStream);
            }
        }
    }

    public static final cf0 p(cf0 cf0Var, cf0 cf0Var2, boolean z) {
        Boolean bool = Boolean.FALSE;
        int i2 = 3;
        boolean zBooleanValue = ((Boolean) cf0Var.c0(bool, new dt(i2))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) cf0Var2.c0(bool, new dt(i2))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return cf0Var.X(cf0Var2);
        }
        dt dtVar = new dt(4);
        c41 c41Var = c41.b;
        cf0 cf0Var3 = (cf0) cf0Var.c0(c41Var, dtVar);
        Object objC0 = cf0Var2;
        if (zBooleanValue2) {
            objC0 = cf0Var2.c0(c41Var, new dt(5));
        }
        return cf0Var3.X((cf0) objC0);
    }

    public static zq1 q(SSLSession sSLSession) throws IOException {
        Object objK;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            xe.q("cipherSuite == null");
            return null;
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") || cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            vp1.i("cipherSuite == ".concat(cipherSuite));
            return null;
        }
        w40 w40VarJ = w40.b.j(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            xe.q("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            vp1.i("tlsVersion == NONE");
            return null;
        }
        ne4.f.getClass();
        ne4 ne4VarB = c84.b(protocol);
        try {
            objK = jz4.k(sSLSession.getPeerCertificates());
        } catch (SSLPeerUnverifiedException unused) {
            objK = g41.b;
        }
        return new zq1(ne4VarB, w40VarJ, jz4.k(sSLSession.getLocalCertificates()), new fn(6, objK));
    }

    public static m r(int i2, byte[] bArr) throws qy4 {
        int i3 = fw.i(i2);
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        m mVar = new m();
        mVar.b = null;
        int i5 = i3 / 4;
        if ((i5 != 4 && i5 != 6 && i5 != 8) || i5 * 4 != i3) {
            st4.j("invalid key length (not 128/192/256)");
            return null;
        }
        mVar.a = i5 + 6;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5 + 7, 4);
        int i6 = 0;
        while (i4 < i3) {
            iArr[i6 >> 2][i6 & 3] = (bArr2[i4] & 255) | ((bArr2[i4 + 1] & 255) << 8) | ((bArr2[i4 + 2] & 255) << 16) | (bArr2[i4 + 3] << 24);
            i4 += 4;
            i6++;
        }
        int i7 = (mVar.a + 1) << 2;
        for (int i8 = i5; i8 < i7; i8++) {
            int i9 = i8 - 1;
            int iC = iArr[i9 >> 2][i9 & 3];
            int i10 = i8 % i5;
            if (i10 == 0) {
                iC = m.c(m.b(iC, 8)) ^ m.h[(i8 / i5) - 1];
            } else if (i5 > 6 && i10 == 4) {
                iC = m.c(iC);
            }
            int i11 = i8 - i5;
            iArr[i8 >> 2][i8 & 3] = iC ^ iArr[i11 >> 2][i11 & 3];
        }
        mVar.b = iArr;
        return mVar;
    }

    public static void u(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
    }

    public abstract int A();

    public float B(View view) {
        if (h) {
            try {
                return qr4.a(view);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
        return view.getAlpha();
    }

    public abstract float C(Object obj);

    public abstract boolean D(float f2);

    public abstract boolean F(View view);

    public abstract boolean G(float f2, float f3);

    public void V(View view, float f2) {
        if (h) {
            try {
                qr4.b(view, f2);
                return;
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
        view.setAlpha(f2);
    }

    public abstract void W(Object obj, float f2);

    public abstract boolean X(View view, float f2);

    public abstract void a0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2);

    public abstract void b0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3);

    public abstract int e(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float f(int i2);

    public abstract int s(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int t();

    public abstract int v();

    public abstract int w();

    public abstract int x();

    public abstract int y(View view);

    public abstract int z(CoordinatorLayout coordinatorLayout);
}
