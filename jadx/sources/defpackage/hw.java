package defpackage;

import android.os.Process;
import io.sentry.android.core.internal.util.d;
import io.sentry.android.ndk.SentryNdk;
import io.sentry.ndk.NativeScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hw implements Runnable {
    public final /* synthetic */ int b;

    public /* synthetic */ hw(int i) {
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
            case 1:
                break;
            case 2:
                HashMap map = dg4.m;
                HashMap map2 = dg4.k;
                HashMap map3 = dg4.l;
                HashMap map4 = dg4.j;
                long j = dg4.b;
                long j2 = dg4.f;
                long j3 = j - dg4.d;
                long j4 = j2 - dg4.h;
                long j5 = dg4.c;
                long j6 = dg4.g;
                eg4 eg4Var = new eg4(j, j2, j3, j4, j5, j6, j5 - dg4.e, j6 - dg4.i);
                dg4.d = j;
                dg4.h = j2;
                dg4.e = j5;
                dg4.i = j6;
                on2 on2Var = dg4.p;
                if (!n12.c(on2Var.d(), eg4Var)) {
                    on2Var.i(eg4Var);
                }
                ArrayList arrayList = new ArrayList();
                Set<Integer> setKeySet = map4.keySet();
                setKeySet.getClass();
                for (Integer num : setKeySet) {
                    Object obj = map4.get(num);
                    if (obj == null) {
                        obj = 0L;
                    }
                    long jLongValue = ((Number) obj).longValue();
                    Object obj2 = map3.get(num);
                    if (obj2 == null) {
                        obj2 = 0L;
                    }
                    long jLongValue2 = ((Number) obj2).longValue();
                    Object obj3 = map2.get(num);
                    if (obj3 == null) {
                        obj3 = 0L;
                    }
                    long jLongValue3 = ((Number) obj3).longValue();
                    Object obj4 = map.get(num);
                    if (obj4 == null) {
                        obj4 = 0L;
                    }
                    long jLongValue4 = ((Number) obj4).longValue();
                    num.getClass();
                    arrayList.add(new pd(num.intValue(), jLongValue, jLongValue2, jLongValue - jLongValue3, jLongValue2 - jLongValue4));
                    map2.put(num, Long.valueOf(jLongValue));
                    map.put(num, Long.valueOf(jLongValue2));
                }
                Set<Integer> setKeySet2 = map3.keySet();
                setKeySet2.getClass();
                for (Integer num2 : setKeySet2) {
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            int i = ((pd) it.next()).a;
                            if (num2 != null && i == num2.intValue()) {
                            }
                            break;
                        }
                    }
                    Object obj5 = map4.get(num2);
                    if (obj5 == null) {
                        obj5 = 0L;
                    }
                    long jLongValue5 = ((Number) obj5).longValue();
                    Object obj6 = map3.get(num2);
                    if (obj6 == null) {
                        obj6 = 0L;
                    }
                    long jLongValue6 = ((Number) obj6).longValue();
                    Object obj7 = map2.get(num2);
                    if (obj7 == null) {
                        obj7 = 0L;
                    }
                    long jLongValue7 = ((Number) obj7).longValue();
                    Object obj8 = map.get(num2);
                    if (obj8 == null) {
                        obj8 = 0L;
                    }
                    long jLongValue8 = ((Number) obj8).longValue();
                    num2.getClass();
                    arrayList.add(new pd(num2.intValue(), jLongValue5, jLongValue6, jLongValue5 - jLongValue7, jLongValue6 - jLongValue8));
                    map.put(num2, Long.valueOf(jLongValue6));
                }
                dg4.q.i(arrayList);
                break;
            case 3:
                d.b = Process.myTid();
                break;
            case 4:
                NativeScope.nativeClearAttachments();
                break;
            default:
                SentryNdk.lambda$static$0();
                break;
        }
    }

    private final void a() {
    }

    private final void b() {
    }
}
