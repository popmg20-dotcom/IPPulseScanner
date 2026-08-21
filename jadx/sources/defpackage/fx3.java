package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.database.AppDatabase;
import com.getsurfboard.profile.SuffixTreeNative;
import com.getsurfboard.ui.activity.SettingsActivity;
import io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fx3 implements pw3 {
    public static boolean A = true;
    public static final Object[] b = new Object[0];
    public static final int[] f = {R.attr.colorPrimary};
    public static final int[] z = {R.attr.colorPrimaryVariant};

    public static List A() {
        InputStream inputStreamD = vd1.a().d("textmate/languages.json");
        if (inputStreamD == null) {
            return Collections.EMPTY_LIST;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamD));
        jq1 jq1Var = new jq1();
        jq1Var.b(GrammarDefinition.class, new t82(8));
        return ((u82) jq1Var.a().b(bufferedReader, new bk4(u82.class))).a;
    }

    public static final ny4 B(final he3 he3Var) throws IOException {
        int iF = he3Var.F();
        if (iF != 33639248) {
            throw new IOException("bad zip: expected " + n(33639248) + " but was " + n(iF));
        }
        he3Var.Z(4L);
        short sN = he3Var.N();
        int i = sN & 65535;
        if ((sN & 1) != 0) {
            vp1.i("unsupported zip: general purpose bit flag=".concat(n(i)));
            return null;
        }
        int iN = he3Var.N() & 65535;
        int iN2 = he3Var.N() & 65535;
        int iN3 = he3Var.N() & 65535;
        long jF = ((long) he3Var.F()) & 4294967295L;
        final ah3 ah3Var = new ah3();
        ah3Var.b = ((long) he3Var.F()) & 4294967295L;
        final ah3 ah3Var2 = new ah3();
        ah3Var2.b = ((long) he3Var.F()) & 4294967295L;
        int iN4 = he3Var.N() & 65535;
        int iN5 = he3Var.N() & 65535;
        int iN6 = he3Var.N() & 65535;
        he3Var.Z(8L);
        final ah3 ah3Var3 = new ah3();
        ah3Var3.b = ((long) he3Var.F()) & 4294967295L;
        String strQ = he3Var.Q(iN4);
        if (p44.p0(strQ, (char) 0)) {
            vp1.i("bad zip: filename contains 0x00");
            return null;
        }
        long j = ah3Var2.b == 4294967295L ? 8L : 0L;
        if (ah3Var.b == 4294967295L) {
            j += 8;
        }
        if (ah3Var3.b == 4294967295L) {
            j += 8;
        }
        final long j2 = j;
        final bh3 bh3Var = new bh3();
        final bh3 bh3Var2 = new bh3();
        final bh3 bh3Var3 = new bh3();
        final xg3 xg3Var = new xg3();
        C(he3Var, iN5, new Function2() { // from class: uy4
            @Override // kotlin.jvm.functions.Function2
            public final Object k(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Integer) obj).intValue();
                long jLongValue = ((Long) obj2).longValue();
                he3 he3Var2 = he3Var;
                if (iIntValue == 1) {
                    xg3 xg3Var2 = xg3Var;
                    if (xg3Var2.b) {
                        vp1.i("bad zip: zip64 extra repeated");
                        return null;
                    }
                    xg3Var2.b = true;
                    if (jLongValue < j2) {
                        vp1.i("bad zip: zip64 extra too short");
                        return null;
                    }
                    ah3 ah3Var4 = ah3Var2;
                    long jI = ah3Var4.b;
                    if (jI == 4294967295L) {
                        jI = he3Var2.I();
                    }
                    ah3Var4.b = jI;
                    ah3 ah3Var5 = ah3Var;
                    ah3Var5.b = ah3Var5.b == 4294967295L ? he3Var2.I() : 0L;
                    ah3 ah3Var6 = ah3Var3;
                    ah3Var6.b = ah3Var6.b == 4294967295L ? he3Var2.I() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        vp1.i("bad zip: NTFS extra too short");
                        return null;
                    }
                    he3Var2.Z(4L);
                    fx3.C(he3Var2, (int) (jLongValue - 4), new ty4(bh3Var, he3Var2, bh3Var2, bh3Var3));
                }
                return xl4.a;
            }
        });
        if (j2 > 0 && !xg3Var.b) {
            vp1.i("bad zip: zip64 extra required but absent");
            return null;
        }
        String strQ2 = he3Var.Q(iN6);
        String str = u03.f;
        return new ny4(pr1.q("/").d(strQ), w44.d0(strQ, "/", false), strQ2, jF, ah3Var.b, ah3Var2.b, iN, ah3Var3.b, iN3, iN2, (Long) bh3Var.b, (Long) bh3Var2.b, (Long) bh3Var3.b, 57344);
    }

    public static final void C(he3 he3Var, int i, Function2 function2) throws IOException {
        hp hpVar = he3Var.f;
        long j = i;
        while (j != 0) {
            if (j < 4) {
                vp1.i("bad zip: truncated header in extra field");
                return;
            }
            int iN = he3Var.N() & 65535;
            long jN = ((long) he3Var.N()) & 65535;
            long j2 = j - 4;
            if (j2 < jN) {
                vp1.i("bad zip: truncated value in extra field");
                return;
            }
            he3Var.X(jN);
            long j3 = hpVar.f;
            function2.k(Integer.valueOf(iN), Long.valueOf(jN));
            long j4 = (hpVar.f + jN) - j3;
            if (j4 < 0) {
                vp1.i(dw2.A(iN, "unsupported zip: too many bytes processed for "));
                return;
            } else {
                if (j4 > 0) {
                    hpVar.z0(j4);
                }
                j = j2 - jN;
            }
        }
    }

    public static final ny4 D(he3 he3Var, ny4 ny4Var) throws IOException {
        int iF = he3Var.F();
        if (iF != 67324752) {
            throw new IOException("bad zip: expected " + n(67324752) + " but was " + n(iF));
        }
        he3Var.Z(2L);
        short sN = he3Var.N();
        int i = sN & 65535;
        if ((sN & 1) != 0) {
            vp1.i("unsupported zip: general purpose bit flag=".concat(n(i)));
            return null;
        }
        he3Var.Z(18L);
        long jN = ((long) he3Var.N()) & 65535;
        int iN = he3Var.N() & 65535;
        he3Var.Z(jN);
        if (ny4Var == null) {
            he3Var.Z(iN);
            return null;
        }
        bh3 bh3Var = new bh3();
        bh3 bh3Var2 = new bh3();
        bh3 bh3Var3 = new bh3();
        C(he3Var, iN, new ty4(he3Var, bh3Var, bh3Var2, bh3Var3));
        return new ny4(ny4Var.a, ny4Var.b, ny4Var.c, ny4Var.d, ny4Var.e, ny4Var.f, ny4Var.g, ny4Var.h, ny4Var.i, ny4Var.j, ny4Var.k, ny4Var.l, ny4Var.m, (Integer) bh3Var.b, (Integer) bh3Var2.b, (Integer) bh3Var3.b);
    }

    public static final long E(String str, byte[] bArr) throws IOException {
        str.getClass();
        File file = new File(new File(ContextUtilsKt.getContext().getFilesDir(), "policy_path"), ha0.x(r25.K(str), ".conf"));
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return file.lastModified();
        } finally {
        }
    }

    public static void F(TextView textView, int i) {
        if (i < 0) {
            s53.d();
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            u9.C(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void G(TextView textView, int i) {
        if (i < 0) {
            s53.d();
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void H(TextView textView, int i) {
        if (i < 0) {
            s53.d();
            return;
        }
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static final void I(Context context, String str, boolean z2) {
        Intent intentPutExtra = new Intent(context, (Class<?>) SettingsActivity.class).putExtra("open_vpn_settings", z2);
        intentPutExtra.getClass();
        if (str != null) {
            intentPutExtra.putExtra("highlight_key", str);
        }
        context.startActivity(intentPutExtra);
    }

    public static final Object J(iq3 iq3Var, boolean z2, iq3 iq3Var2, Function2 function2) throws Throwable {
        Object r80Var;
        Object objT;
        try {
            tj4.c(2, function2);
            r80Var = function2.k(iq3Var2, iq3Var);
        } catch (kv0 e) {
            Throwable th = e.b;
            iq3Var.S(new r80(th, false));
            throw th;
        } catch (Throwable th2) {
            r80Var = new r80(th2, false);
        }
        mf0 mf0Var = mf0.b;
        if (r80Var == mf0Var || (objT = iq3Var.T(r80Var)) == f42.b) {
            return mf0Var;
        }
        iq3Var.m0();
        if (!(objT instanceof r80)) {
            return f42.a(objT);
        }
        if (!z2) {
            Throwable th3 = ((r80) objT).a;
            if ((th3 instanceof ee4) && ((ee4) th3).b == iq3Var) {
                if (r80Var instanceof r80) {
                    throw ((r80) r80Var).a;
                }
                return r80Var;
            }
        }
        throw ((r80) objT).a;
    }

    public static mj K() {
        Context context = ContextUtilsKt.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.getClass();
        sv3 sv3Var = new sv3(sharedPreferences);
        AppDatabase appDatabase = oj0.a;
        ua3 ua3VarT = appDatabase.t();
        os1 os1VarS = appDatabase.s();
        Context context2 = ContextUtilsKt.getContext();
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences(context2.getPackageName() + "_preferences", 0);
        sharedPreferences2.getClass();
        ji jiVar = new ji(0);
        new t4(3);
        int i = 1;
        ji jiVar2 = new ji(i);
        ua3VarT.getClass();
        os1VarS.getClass();
        v92 v92Var = new v92();
        v92Var.b = ua3VarT;
        v92Var.f = os1VarS;
        v92Var.z = sharedPreferences2;
        v92Var.A = jiVar;
        v92Var.X = jiVar2;
        return new mj(sv3Var, v92Var, new ha1(i, d73.f()));
    }

    public static void L(ViewGroup viewGroup, boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            dq4.b(viewGroup, z2);
        } else if (A) {
            try {
                dq4.b(viewGroup, z2);
            } catch (NoSuchMethodError unused) {
                A = false;
            }
        }
    }

    public static yv M(List list, at3 at3Var, xq1 xq1Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(n12.K(((dn0) it.next()).c()));
        }
        return m(new m10(1, m(new sm1(new yb2(new ArrayList(arrayList), false, yu0.a()), xq1Var, 5000L)), at3Var, list));
    }

    public static final Object[] N(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i2);
                    }
                    i = i2;
                }
            }
        }
        return b;
    }

    public static final Object[] O(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    objNewInstance.getClass();
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf != objArr) {
                            return Arrays.copyOf(objArrCopyOf, i2);
                        }
                        objArr[i2] = null;
                        return objArr;
                    }
                    i = i2;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static ActionMode.Callback P(ActionMode.Callback callback) {
        return (!(callback instanceof xc4) || Build.VERSION.SDK_INT < 26) ? callback : ((xc4) callback).a;
    }

    public static ActionMode.Callback Q(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof xc4) || callback == null) ? callback : new xc4(callback, textView);
    }

    public static int R(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i2 = 0; i2 < 6; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    public static void a(List list, File file) {
        k();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String[] strArr = (String[]) list.toArray(new String[0]);
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        if (SuffixTreeNative.nativeBuild(strArr, absolutePath)) {
            t(file);
        } else {
            e04.f(ha0.n("Failed to build suffix tree to ", file.getAbsolutePath()));
        }
    }

    public static final LinkedHashMap b(ArrayList arrayList) {
        String str = u03.f;
        u03 u03VarQ = pr1.q("/");
        e03[] e03VarArr = {new e03(u03VarQ, new ny4(u03VarQ, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(fh2.U(1));
        e03 e03Var = e03VarArr[0];
        linkedHashMap.put(e03Var.b, e03Var.f);
        for (ny4 ny4Var : d70.u0(arrayList, new e1(27))) {
            if (((ny4) linkedHashMap.put(ny4Var.a, ny4Var)) == null) {
                while (true) {
                    u03 u03Var = ny4Var.a;
                    u03 u03VarB = u03Var.b();
                    if (u03VarB != null) {
                        ny4 ny4Var2 = (ny4) linkedHashMap.get(u03VarB);
                        if (ny4Var2 != null) {
                            ny4Var2.q.add(u03Var);
                            break;
                        }
                        ny4 ny4Var3 = new ny4(u03VarB, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                        linkedHashMap.put(u03VarB, ny4Var3);
                        ny4Var3.q.add(u03Var);
                        ny4Var = ny4Var3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static void c(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.R, i, i2);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                f(context, z, "Theme.MaterialComponents");
            }
        }
        f(context, f, "Theme.AppCompat");
    }

    public static void d(String str) {
        if (str.length() <= 10000) {
            return;
        }
        st4.k("Number string too large: ", str.substring(0, 30), "...");
    }

    public static void e(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.R, i, i2);
        boolean z2 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
            for (int i3 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i3, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z2 = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z2 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            return;
        }
        xe.k("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    public static void f(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i)) {
                typedArrayObtainStyledAttributes.recycle();
                xe.k(ha0.o("The style on this component requires your app theme to be ", str, " (or a descendant)."));
                return;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void g(tn3 tn3Var) {
        tn3Var.getClass();
        if (tn3Var instanceof om3) {
            om3 om3Var = (om3) tn3Var;
            SuffixTreeNative suffixTreeNative = om3Var.z0;
            if (suffixTreeNative != null) {
                suffixTreeNative.close();
            }
            om3Var.z0 = null;
            return;
        }
        if (tn3Var instanceof jn3) {
            Iterator it = ((jn3) tn3Var).z.iterator();
            while (it.hasNext()) {
                g((tn3) it.next());
            }
        } else if (tn3Var instanceof bn3) {
            Iterator it2 = ((bn3) tn3Var).getRules().iterator();
            while (it2.hasNext()) {
                g((tn3) it2.next());
            }
        }
    }

    public static final List h(tn3 tn3Var) {
        tn3Var.getClass();
        if (tn3Var instanceof om3) {
            String str = ((om3) tn3Var).Z;
            if (str.length() > 0) {
                return p95.x(str);
            }
        } else if (tn3Var instanceof jn3) {
            List list = ((jn3) tn3Var).z;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d70.U(h((tn3) it.next()), arrayList);
            }
            return arrayList;
        }
        return g41.b;
    }

    public static int i(int i, int i2) {
        int i3 = i - i2;
        if (i3 <= i2) {
            i3 = i2;
            i2 = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (i > i3) {
            i4 *= i;
            if (i5 <= i2) {
                i4 /= i5;
                i5++;
            }
            i--;
        }
        while (i5 <= i2) {
            i4 /= i5;
            i5++;
        }
        return i4;
    }

    public static ArrayList j(t64 t64Var, t64 t64Var2) {
        ArrayList arrayList = new ArrayList();
        d44 d44Var = w64.e;
        t64Var.getClass();
        d44 d44Var2 = w64.e;
        v64 v64Var = v64.b;
        w64 w64VarR = tj4.r(v64Var, t64Var, d44Var2);
        t64Var2.getClass();
        arrayList.add(new s64(w64VarR, tj4.r(v64.z, t64Var2, d44Var2)));
        arrayList.add(new s64(tj4.r(v64Var, t64Var, d44Var2), tj4.r(v64.A, t64Var2, d44Var2)));
        return arrayList;
    }

    public static void k() {
        String lowerCase;
        String str;
        if (SuffixTreeNative.X) {
            return;
        }
        String property = System.getProperty("suffixtree.library.path");
        if (property != null) {
            System.load(property);
        } else {
            try {
                System.loadLibrary("suffixtree");
            } catch (UnsatisfiedLinkError e) {
                String property2 = System.getProperty("os.name");
                if (property2 != null) {
                    lowerCase = property2.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = "";
                }
                if (p44.o0(lowerCase, "mac", false)) {
                    str = "libsuffixtree_test.dylib";
                } else {
                    if (!p44.o0(lowerCase, "linux", false)) {
                        throw e;
                    }
                    str = "libsuffixtree_test.so";
                }
                File file = new File("src/test/resources", str);
                if (!file.exists()) {
                    throw e;
                }
                System.load(file.getAbsolutePath());
            }
        }
        SuffixTreeNative.X = true;
    }

    public static yv m(wv wvVar) {
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = wvVar.getClass();
        try {
            Object objN = wvVar.n(vvVar);
            if (objN == null) {
                return yvVar;
            }
            vvVar.a = objN;
            return yvVar;
        } catch (Exception e) {
            yvVar.b(e);
            return yvVar;
        }
    }

    public static final String n(int i) {
        yr2.g(16);
        String string = Integer.toString(i, 16);
        string.getClass();
        return "0x".concat(string);
    }

    public static final n13 o(String str) {
        str.getClass();
        File file = new File(new File(ContextUtilsKt.getContext().getFilesDir(), "policy_path"), ha0.x(r25.K(str), ".conf"));
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArrS = l72.S(fileInputStream);
            Uri uriFromFile = Uri.fromFile(file);
            uriFromFile.getClass();
            n13 n13Var = new n13(str, bArrS, uriFromFile, file.lastModified());
            fileInputStream.close();
            return n13Var;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ez4.l(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static int p(int[] iArr, int i, boolean z2) {
        boolean z3;
        int[] iArr2 = iArr;
        int i2 = 0;
        for (int i3 : iArr2) {
            i2 += i3;
        }
        int length = iArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = length - 1;
            if (i4 >= i7) {
                return i5;
            }
            int i8 = 1 << i4;
            i6 |= i8;
            int i9 = 1;
            while (i9 < iArr2[i4]) {
                int i10 = i2 - i9;
                int i11 = length - i4;
                int i12 = i11 - 2;
                int i13 = i(i10 - 1, i12);
                if (z2 && i6 == 0) {
                    int i14 = i11 - 1;
                    if (i10 - i14 >= i14) {
                        i13 -= i(i10 - i11, i12);
                    }
                }
                boolean z4 = true;
                if (i11 - 1 > 1) {
                    int i15 = i10 - i12;
                    int i16 = 0;
                    while (i15 > i) {
                        i16 += i((i10 - i15) - 1, i11 - 3);
                        i15--;
                        z4 = z4;
                    }
                    z3 = z4;
                    i13 -= (i7 - i4) * i16;
                } else {
                    z3 = true;
                    if (i10 > i) {
                        i13--;
                    }
                }
                i5 += i13;
                i9++;
                i6 &= ~i8;
                iArr2 = iArr;
            }
            i2 -= i9;
            i4++;
            iArr2 = iArr;
        }
    }

    public static n23 q(AppCompatTextView appCompatTextView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new n23(u9.s(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = appCompatTextView.getBreakStrategy();
        int hyphenationFrequency = appCompatTextView.getHyphenationFrequency();
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z2 = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z2) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(u9.f(ga5.j(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new n23(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static yv r(cf0 cf0Var, Function2 function2) {
        cf0Var.getClass();
        return m(new m10(5, cf0Var, of0.b, function2));
    }

    public static float s(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static SuffixTreeNative t(File file) {
        k();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        long jNativeLoad = SuffixTreeNative.nativeLoad(absolutePath);
        if (jNativeLoad != 0) {
            return new SuffixTreeNative(jNativeLoad);
        }
        e04.f(ha0.n("Failed to load suffix tree from ", file.getAbsolutePath()));
        return null;
    }

    public static final boolean u(tn3 tn3Var, String str, String str2, InetAddress inetAddress, String str3, String str4, List list, on3 on3Var, e03 e03Var, String str5, Integer num, Integer num2, Integer num3, String str6, int i) {
        tn3Var.getClass();
        if (i <= 16) {
            if (!(tn3Var instanceof in3)) {
                if (!(tn3Var instanceof tm3)) {
                    if (tn3Var instanceof rm3) {
                        if (str2 == null || !((rm3) tn3Var).b(str2)) {
                        }
                    } else if (tn3Var instanceof wm3) {
                        if (inetAddress == null || !((wm3) tn3Var).m(inetAddress)) {
                        }
                    } else {
                        if (tn3Var instanceof bn3) {
                            return ((bn3) tn3Var).H(str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i + 1);
                        }
                        if (tn3Var instanceof qn3) {
                            if (list != null && e03Var != null) {
                                return ((qn3) tn3Var).c(str3, str4, list, on3Var, e03Var);
                            }
                        } else if (tn3Var instanceof hn3) {
                            if (num2 != null && num3 != null) {
                                return ((hn3) tn3Var).B(str5, num, num2.intValue(), num3.intValue());
                            }
                        } else if (tn3Var instanceof rn3) {
                            if (str6 == null || !ji0.a0(((rn3) tn3Var).b, str6)) {
                            }
                        } else if (!(tn3Var instanceof jn3)) {
                            g.d();
                            return false;
                        }
                    }
                }
                return true;
            }
            if (str != null && ji0.a0(((in3) tn3Var).b, str)) {
                return true;
            }
        }
        return false;
    }

    public static TypedArray v(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        c(context, attributeSet, i, i2);
        e(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static n02 w(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        c(context, attributeSet, i, i2);
        e(context, attributeSet, iArr, i, i2, iArr2);
        return new n02(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static BigDecimal z(String str) {
        d(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(str));
    }

    public abstract void l(xu3 xu3Var, float f2, float f3);

    public abstract void x(Throwable th);

    public abstract void y(iv1 iv1Var);
}
