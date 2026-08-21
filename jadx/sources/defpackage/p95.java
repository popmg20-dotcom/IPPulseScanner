package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.Toast;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.MainActivity;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.StringUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p95 {
    public static r90 a;
    public static final char[] b = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] c;
    public static final char[] d;
    public static final char[] e;
    public static final char[] f;
    public static final nm2 g;
    public static nm2 h;
    public static final Object i;
    public static boolean j;
    public static int k;
    public static Toast l;
    public static d84 m;

    static {
        char[] cArr = {'!', StringUtil.DOUBLE_QUOTE, '#', '$', '%', '&', '\'', '(', ')', '*', '+', StringUtil.COMMA, '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        c = cArr;
        d = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        e = cArr;
        f = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
        g = new nm2(null, null, null);
        i = new Object();
    }

    public static final void C(int i2, Object... objArr) {
        String string = ContextUtilsKt.getContext().getString(i2, Arrays.copyOf(objArr, objArr.length));
        string.getClass();
        D(string);
    }

    public static final void D(String str) {
        Toast toast = l;
        if (toast != null) {
            toast.cancel();
        }
        Context context = ContextUtilsKt.getContext();
        int i2 = oe4.b;
        Toast toastMakeText = Toast.makeText(context, str, 0);
        oe4.a(toastMakeText.getView(), new xo3(context));
        oe4 oe4Var = new oe4(context, toastMakeText);
        l = oe4Var.a;
        oe4Var.show();
    }

    public static int E(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % DnsRecord.CLASS_ANY) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }

    public static Class F(Class cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }

    public static final gx4 G(List list, gx4 gx4Var) {
        gx4 gx4VarB;
        list.getClass();
        boolean zA = gx4Var.e.a("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME");
        boolean zA2 = gx4Var.e.a("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME");
        boolean zA3 = gx4Var.e.a("androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME");
        if (!zA && zA2 && zA3) {
            String str = gx4Var.c;
            cp1 cp1Var = new cp1(19);
            di0 di0Var = gx4Var.e;
            di0Var.getClass();
            cp1Var.g0(di0Var.a);
            ((LinkedHashMap) cp1Var.f).put("androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME", str);
            gx4VarB = gx4.b(gx4Var, null, null, "androidx.work.multiprocess.RemoteListenableDelegatingWorker", cp1Var.f(), 0, 0L, 0, 0, 0L, 0, 33554411);
        } else {
            gx4VarB = gx4Var;
        }
        if (Build.VERSION.SDK_INT <= 25) {
            mc0 mc0Var = gx4VarB.j;
            String str2 = gx4VarB.c;
            if (!n12.c(str2, ConstraintTrackingWorker.class.getName()) && (mc0Var.e || mc0Var.f)) {
                cp1 cp1Var2 = new cp1(19);
                di0 di0Var2 = gx4VarB.e;
                di0Var2.getClass();
                cp1Var2.g0(di0Var2.a);
                ((LinkedHashMap) cp1Var2.f).put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str2);
                return gx4.b(gx4VarB, null, null, ConstraintTrackingWorker.class.getName(), cp1Var2.f(), 0, 0L, 0, 0, 0L, 0, 33554411);
            }
        }
        return gx4VarB;
    }

    public static synchronized void H(r90 r90Var) {
        if (a != null) {
            throw new IllegalStateException("init() already called");
        }
        a = r90Var;
    }

    public static final ce0 a(cf0 cf0Var) {
        if (cf0Var.Z(pr1.X) == null) {
            cf0Var = cf0Var.X(je.b());
        }
        return new ce0(cf0Var);
    }

    public static zf1 b(zf1 zf1Var, int i2) {
        jp jpVar;
        if (i2 < 0 && i2 != -2 && i2 != -1) {
            e04.f(dw2.A(i2, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was "));
            return null;
        }
        if (i2 == -1) {
            i2 = 0;
            jpVar = jp.f;
        } else {
            jpVar = jp.b;
        }
        int i3 = i2;
        jp jpVar2 = jpVar;
        return zf1Var instanceof nm1 ? n12.y((nm1) zf1Var, null, i3, jpVar2, 1) : new d30(zf1Var, null, i3, jpVar2, 2);
    }

    public static ub2 c(ub2 ub2Var) {
        ub2Var.f();
        ub2Var.z = true;
        return ub2Var.f > 0 ? ub2Var : ub2.A;
    }

    public static final int d(BitmapFactory.Options options, int i2, int i3) {
        Integer numValueOf = Integer.valueOf(options.outHeight);
        Integer numValueOf2 = Integer.valueOf(options.outWidth);
        int iIntValue = numValueOf.intValue();
        int iIntValue2 = numValueOf2.intValue();
        int i4 = 1;
        if (iIntValue <= i3 && iIntValue2 <= i2) {
            return 1;
        }
        int i5 = iIntValue / 2;
        int i6 = iIntValue2 / 2;
        while (i5 / i4 >= i3 && i6 / i4 >= i2) {
            i4 *= 2;
            if (i4 == 0) {
                return (int) Math.pow(2.0d, 30.0d);
            }
        }
        return i4;
    }

    public static void e(lf0 lf0Var) {
        v32 v32Var = (v32) lf0Var.I().Z(pr1.X);
        if (v32Var != null) {
            v32Var.g(null);
        } else {
            ad0.o(lf0Var, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final void f(WorkDatabase workDatabase, na0 na0Var, nw4 nw4Var) {
        int i2;
        workDatabase.getClass();
        na0Var.getClass();
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList arrayListL = e70.L(nw4Var);
        int i3 = 0;
        while (!arrayListL.isEmpty()) {
            List list = ((nw4) d70.p0(arrayListL)).d;
            list.getClass();
            if (list.isEmpty()) {
                i2 = 0;
            } else {
                Iterator it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (((ex4) it.next()).b.j.b() && (i2 = i2 + 1) < 0) {
                        e70.O();
                        throw null;
                    }
                }
            }
            i3 += i2;
        }
        if (i3 == 0) {
            return;
        }
        int iIntValue = ((Number) ke0.r(workDatabase.x().a, true, false, new q74(14))).intValue();
        if (iIntValue + i3 <= 8) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: 8;\nalready enqueued count: " + iIntValue + ";\ncurrent enqueue operation count: " + i3 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }

    public static final Object h(Function2 function2, ge0 ge0Var) {
        iq3 iq3Var = new iq3(ge0Var, ge0Var.j());
        return fx3.J(iq3Var, true, iq3Var, function2);
    }

    public static ub2 i() {
        return new ub2(10);
    }

    public static String j(byte[] bArr, boolean z, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z) {
            return new String(bArr, m12.a);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static final uh2 k(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new uh2(matcher, charSequence);
        }
        return null;
    }

    public static final zf1 l(zf1 zf1Var, tq1 tq1Var) {
        if (tq1Var.Z(pr1.X) == null) {
            return tq1Var.equals(c41.b) ? zf1Var : zf1Var instanceof nm1 ? n12.y((nm1) zf1Var, tq1Var, 0, null, 6) : new d30(zf1Var, tq1Var, 0, null, 12);
        }
        st4.o(tq1Var, "Flow context cannot contain job in it. Had ");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x051b A[PHI: r5
      0x051b: PHI (r5v28 java.lang.String) = 
      (r5v23 java.lang.String)
      (r5v23 java.lang.String)
      (r5v23 java.lang.String)
      (r5v23 java.lang.String)
      (r5v23 java.lang.String)
      (r5v24 java.lang.String)
      (r5v25 java.lang.String)
      (r5v26 java.lang.String)
      (r5v29 java.lang.String)
     binds: [B:306:0x0519, B:301:0x050a, B:303:0x0512, B:296:0x04f9, B:291:0x04ea, B:286:0x04db, B:281:0x04c8, B:276:0x04b5, B:271:0x04a1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.oj1 m(defpackage.sy r14) {
        /*
            Method dump skipped, instruction units count: 1496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p95.m(sy):oj1");
    }

    public static pj2 n(String str) {
        str.getClass();
        uh2 uh2VarB = pj2.e.b(str, 0);
        if (uh2VarB == null) {
            s53.g(str, 34, "No subtype found for: \"");
            return null;
        }
        String str2 = (String) ((sh2) uh2VarB.a()).get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        lowerCase.getClass();
        String lowerCase2 = ((String) ((sh2) uh2VarB.a()).get(2)).toLowerCase(locale);
        lowerCase2.getClass();
        ArrayList arrayList = new ArrayList();
        int i2 = uh2VarB.b().f;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= str.length()) {
                return new pj2(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            uh2 uh2VarB2 = pj2.f.b(str, i3);
            if (uh2VarB2 == null) {
                throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(i3) + "\" for: \"" + str + StringUtil.DOUBLE_QUOTE).toString());
            }
            th2 th2Var = uh2VarB2.c;
            kh2 kh2VarB = th2Var.b(1);
            String str3 = kh2VarB != null ? kh2VarB.a : null;
            if (str3 == null) {
                i2 = uh2VarB2.b().f;
            } else {
                kh2 kh2VarB2 = th2Var.b(2);
                String strSubstring = kh2VarB2 != null ? kh2VarB2.a : null;
                if (strSubstring == null) {
                    kh2 kh2VarB3 = th2Var.b(3);
                    kh2VarB3.getClass();
                    strSubstring = kh2VarB3.a;
                } else if (p44.M0(strSubstring, '\'') && p44.r0(strSubstring, '\'') && strSubstring.length() > 2) {
                    strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                }
                arrayList.add(str3);
                arrayList.add(strSubstring);
                i2 = uh2VarB2.b().f;
            }
        }
    }

    public static byte[] o(String str, Charset charset) {
        return charset == null ? str.getBytes(m12.b) : str.getBytes(charset);
    }

    public static final int p(io3 io3Var, String str) {
        io3Var.getClass();
        int iD = xb5.d(io3Var, str);
        if (iD >= 0) {
            return iD;
        }
        int columnCount = io3Var.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i2 = 0; i2 < columnCount; i2++) {
            arrayList.add(io3Var.getColumnName(i2));
        }
        xe.m("Column '", str, "' does not exist. Available columns: [", d70.j0(arrayList, null, null, null, null, 63), 93);
        return 0;
    }

    public static rd1 q(wy4 wy4Var, String str) throws qy4 {
        rd1 rd1VarR = r(wy4Var, str);
        if (rd1VarR != null) {
            return rd1VarR;
        }
        String strReplaceAll = str.replaceAll("\\\\", "/");
        rd1 rd1VarR2 = r(wy4Var, strReplaceAll);
        return rd1VarR2 == null ? r(wy4Var, strReplaceAll.replaceAll("/", "\\\\")) : rd1VarR2;
    }

    public static rd1 r(wy4 wy4Var, String str) throws qy4 {
        if (wy4Var == null) {
            st4.j(ha0.n("zip model is null, cannot determine file header with exact match for fileName: ", str));
            return null;
        }
        if (!yr2.N(str)) {
            st4.j(ha0.n("file name is null, cannot determine file header with exact match for fileName: ", str));
            return null;
        }
        if (wy4Var.f.a.size() != 0) {
            for (rd1 rd1Var : wy4Var.f.a) {
                String str2 = rd1Var.m;
                if (yr2.N(str2) && str.equals(str2)) {
                    return rd1Var;
                }
            }
        }
        return null;
    }

    public static final Intent s(Context context, boolean z) {
        context.getClass();
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        if (z) {
            intent.putExtra("grant_permission", true);
        }
        return intent;
    }

    public static final boolean t() {
        String strO;
        String strO2;
        String strO3 = t23.o("webdav_account", null);
        return (strO3 == null || strO3.length() == 0 || (strO = t23.o("webdav_password", null)) == null || strO.length() == 0 || (strO2 = t23.o("webdav_server", null)) == null || strO2.length() == 0) ? false : true;
    }

    public static ge0 u(ge0 ge0Var) {
        ge0Var.getClass();
        ie0 ie0Var = ge0Var instanceof ie0 ? (ie0) ge0Var : null;
        if (ie0Var == null || (ge0Var = ie0Var.z) != null) {
            return ge0Var;
        }
        ef0 ef0Var = (ef0) ie0Var.j().Z(pr1.f);
        ge0 lv0Var = ef0Var != null ? new lv0(ef0Var, ie0Var) : ie0Var;
        ie0Var.z = lv0Var;
        return lv0Var;
    }

    public static boolean v(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ga5.w(context);
        }
        return true;
    }

    public static final k01 w(t60 t60Var, String str, Executor executor, pl1 pl1Var) {
        xl4 xl4Var = xl4.a;
        t60Var.getClass();
        executor.getClass();
        on2 on2Var = new on2(k01.Z);
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            executor.execute(new iw2(t60Var, str, pl1Var, on2Var, vvVar, 0));
            vvVar.a = xl4Var;
        } catch (Exception e2) {
            yvVar.b(e2);
        }
        return new k01(6);
    }

    public static List x(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        listSingletonList.getClass();
        return listSingletonList;
    }

    public static void y(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    public static void z(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = (Animator) arrayList.get(i2);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public abstract p95 A(j50 j50Var, Object obj);

    public abstract p95 B(String str, am1 am1Var);

    public abstract Object g();
}
