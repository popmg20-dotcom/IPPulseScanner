package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fi1 {
    public static final if2 a = new if2(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final xw3 d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new es1(1));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new xw3(0);
    }

    public static String a(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((ai1) list.get(i2)).g);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static ei1 b(String str, Context context, List list, int i) {
        int i2;
        Typeface typefaceM;
        if2 if2Var = a;
        Trace.beginSection(vo.O("getFontSync"));
        try {
            Typeface typeface = (Typeface) if2Var.h(str);
            if (typeface != null) {
                return new ei1(typeface);
            }
            t6 t6VarA = zh1.a(context, list);
            List list2 = (List) t6VarA.z;
            int i3 = t6VarA.f;
            if (i3 != 0) {
                i2 = i3 != 1 ? -3 : -2;
            } else {
                ki1[] ki1VarArr = (ki1[]) list2.get(0);
                if (ki1VarArr == null || ki1VarArr.length == 0) {
                    i2 = 1;
                } else {
                    int length = ki1VarArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            i2 = 0;
                            break;
                        }
                        int i5 = ki1VarArr[i4].f;
                        if (i5 == 0) {
                            i4++;
                        } else if (i5 >= 0) {
                            i2 = i5;
                        }
                    }
                }
            }
            if (i2 != 0) {
                return new ei1(i2);
            }
            if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                ki1[] ki1VarArr2 = (ki1[]) list2.get(0);
                uf2 uf2Var = dk4.a;
                Trace.beginSection(vo.O("TypefaceCompat.createFromFontInfo"));
                typefaceM = dk4.a.m(context, ki1VarArr2, i);
                Trace.endSection();
            } else {
                uf2 uf2Var2 = dk4.a;
                Trace.beginSection(vo.O("TypefaceCompat.createFromFontInfoWithFallback"));
                typefaceM = dk4.a.n(context, list2, i);
                Trace.endSection();
            }
            if (typefaceM == null) {
                return new ei1(-3);
            }
            if2Var.l(str, typefaceM);
            return new ei1(typefaceM);
        } catch (PackageManager.NameNotFoundException unused) {
            return new ei1(-1);
        } catch (Throwable th) {
            throw th;
        } finally {
            Trace.endSection();
        }
    }
}
