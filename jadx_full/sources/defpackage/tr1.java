package defpackage;

import android.content.Context;
import android.os.Build;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tr1 {
    public static final u33 b = new u33("fire-global");
    public static final u33 c = new u33("fire-count");
    public static final u33 d = new u33("last-used-date");
    public final b32 a;

    public tr1(Context context, String str) {
        this.a = new b32(context, "FirebaseHeartBeat".concat(str));
    }

    public final synchronized long a(rn2 rn2Var) {
        long j;
        try {
            long jLongValue = ((Long) xb5.t(rn2Var, c, 0L)).longValue();
            String str = "";
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry entry : rn2Var.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str3 : set) {
                        if (str2 == null || str2.compareTo(str3) > 0) {
                            str = ((u33) entry.getKey()).a;
                            hashSet = set;
                            str2 = str3;
                        }
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            str.getClass();
            rn2Var.d(new u33(str), hashSet2);
            j = jLongValue - 1;
            rn2Var.c(c, Long.valueOf(j));
        } catch (Throwable th) {
            throw th;
        }
        return j;
    }

    public final synchronized void b() {
    }

    public final synchronized ArrayList c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String strD = d(System.currentTimeMillis());
            for (Map.Entry entry : ((Map) ke0.z(c41.b, new mt(this.a, null, 8))).entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(strD);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new ug(((u33) entry.getKey()).a, new ArrayList(hashSet)));
                    }
                }
            }
            h(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized u33 e(rn2 rn2Var, String str) {
        for (Map.Entry entry : rn2Var.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        String str2 = ((u33) entry.getKey()).a;
                        str2.getClass();
                        return new u33(str2);
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void f(rn2 rn2Var, String str) {
        u33 u33VarE = e(rn2Var, str);
        if (u33VarE == null) {
            return;
        }
        HashSet hashSet = new HashSet((Collection) xb5.t(rn2Var, u33VarE, new HashSet()));
        hashSet.remove(str);
        if (hashSet.isEmpty()) {
            rn2Var.b();
            rn2Var.a.remove(u33VarE);
        } else {
            rn2Var.d(u33VarE, hashSet);
        }
    }

    public final synchronized void g(long j, String str) {
        String strD = d(j);
        str.getClass();
        u33 u33Var = new u33(str);
    }

    public final synchronized void h(long j) {
    }
}
