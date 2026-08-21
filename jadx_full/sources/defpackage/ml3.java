package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ml3 {
    public final j50 a;
    public final Context b;
    public final String c;
    public final ArrayList d;
    public final ArrayList e;
    public Executor f;
    public Executor g;
    public o73 h;
    public boolean i;
    public final jf2 j;
    public final LinkedHashSet k;
    public final LinkedHashSet l;
    public final ArrayList m;
    public boolean n;
    public boolean o;
    public boolean p;

    public ml3(Context context, Class cls, String str) {
        context.getClass();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.j = new jf2(2);
        this.k = new LinkedHashSet();
        this.l = new LinkedHashSet();
        this.m = new ArrayList();
        this.n = true;
        this.a = dh3.a(cls);
        this.b = context;
        this.c = str;
    }

    public final void a(fm2... fm2VarArr) {
        for (fm2 fm2Var : fm2VarArr) {
            Integer numValueOf = Integer.valueOf(fm2Var.a);
            LinkedHashSet linkedHashSet = this.l;
            linkedHashSet.add(numValueOf);
            linkedHashSet.add(Integer.valueOf(fm2Var.b));
        }
        for (fm2 fm2Var2 : (fm2[]) Arrays.copyOf(fm2VarArr, fm2VarArr.length)) {
            this.j.a(fm2Var2);
        }
    }

    public final pl3 b() {
        String name;
        h31 h31VarE;
        f64 f64VarG;
        f64 f64VarG2;
        boolean zContainsKey;
        Executor executor = this.f;
        if (executor == null && this.g == null) {
            qd qdVar = rd.B0;
            this.g = qdVar;
            this.f = qdVar;
        } else if (executor != null && this.g == null) {
            this.g = executor;
        } else if (executor == null) {
            this.f = this.g;
        }
        LinkedHashSet linkedHashSet = this.l;
        boolean zIsEmpty = linkedHashSet.isEmpty();
        LinkedHashSet linkedHashSet2 = this.k;
        if (!zIsEmpty) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (linkedHashSet2.contains(Integer.valueOf(iIntValue))) {
                    e04.f(dw2.A(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: "));
                    return null;
                }
            }
        }
        e64 pr1Var = this.h;
        if (pr1Var == null) {
            pr1Var = new pr1();
        }
        e64 e64Var = pr1Var;
        boolean z = this.i;
        Context context = this.b;
        context.getClass();
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        ol3 ol3Var = (activityManager == null || activityManager.isLowRamDevice()) ? ol3.b : ol3.f;
        Executor executor2 = this.f;
        if (executor2 == null) {
            xe.k("Required value was null.");
            return null;
        }
        Executor executor3 = this.g;
        if (executor3 == null) {
            xe.k("Required value was null.");
            return null;
        }
        nj0 nj0Var = new nj0(context, this.c, e64Var, this.j, this.d, z, ol3Var, executor2, executor3, null, this.n, this.o, linkedHashSet2, null, null, null, this.e, this.m, this.p, null, null);
        Class clsA = this.a.a();
        clsA.getClass();
        Package r0 = clsA.getPackage();
        if (r0 == null || (name = r0.getName()) == null) {
            name = "";
        }
        String canonicalName = clsA.getCanonicalName();
        canonicalName.getClass();
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String strReplace = canonicalName.replace('.', '_');
        strReplace.getClass();
        String strConcat = strReplace.concat("_Impl");
        try {
            Class<?> cls = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, clsA.getClassLoader());
            cls.getClass();
            pl3 pl3Var = (pl3) cls.getDeclaredConstructor(null).newInstance(null);
            pl3Var.getClass();
            pl3Var.j = true;
            try {
                h31VarE = pl3Var.e();
                h31VarE.getClass();
            } catch (ss2 unused) {
                h31VarE = null;
            }
            if (h31VarE == null) {
                new ew(nj0Var, new ji(28, pl3Var));
                throw null;
            }
            pl3Var.d = new ew(nj0Var, h31VarE);
            pl3Var.e = pl3Var.d();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set setI = pl3Var.i();
            List list = nj0Var.n;
            int size = list.size();
            boolean[] zArr = new boolean[size];
            Iterator it2 = setI.iterator();
            while (true) {
                int i = -1;
                if (!it2.hasNext()) {
                    int size2 = list.size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i2 = size2 - 1;
                            if (size2 >= size || !zArr[size2]) {
                                break;
                            }
                            if (i2 < 0) {
                                break;
                            }
                            size2 = i2;
                        }
                        xe.k("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                        return null;
                    }
                    for (fm2 fm2Var : pl3Var.c(linkedHashMap)) {
                        int i3 = fm2Var.a;
                        int i4 = fm2Var.b;
                        jf2 jf2Var = nj0Var.d;
                        LinkedHashMap linkedHashMap2 = jf2Var.a;
                        if (linkedHashMap2.containsKey(Integer.valueOf(i3))) {
                            Map map = (Map) linkedHashMap2.get(Integer.valueOf(i3));
                            if (map == null) {
                                map = h41.b;
                            }
                            zContainsKey = map.containsKey(Integer.valueOf(i4));
                        } else {
                            zContainsKey = false;
                        }
                        if (!zContainsKey) {
                            jf2Var.a(fm2Var);
                        }
                    }
                    LinkedHashMap linkedHashMapJ = pl3Var.j();
                    List list2 = nj0Var.m;
                    boolean[] zArr2 = new boolean[list2.size()];
                    for (Map.Entry entry : linkedHashMapJ.entrySet()) {
                        j50 j50Var = (j50) entry.getKey();
                        for (j50 j50Var2 : (List) entry.getValue()) {
                            int size3 = list2.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i5 = size3 - 1;
                                    if (j50Var2.d(list2.get(size3))) {
                                        zArr2[size3] = true;
                                        break;
                                    }
                                    if (i5 < 0) {
                                        break;
                                    }
                                    size3 = i5;
                                }
                                size3 = -1;
                            } else {
                                size3 = -1;
                            }
                            if (size3 < 0) {
                                throw new IllegalArgumentException(("A required type converter (" + j50Var2.b() + ") for " + j50Var.b() + " is missing in the database configuration.").toString());
                            }
                            Object obj = list2.get(size3);
                            j50Var2.getClass();
                            obj.getClass();
                            pl3Var.i.put(j50Var2, obj);
                        }
                    }
                    int size4 = list2.size() - 1;
                    if (size4 >= 0) {
                        while (true) {
                            int i6 = size4 - 1;
                            if (!zArr2[size4]) {
                                st4.p("Unexpected type converter ", list2.get(size4), ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                return null;
                            }
                            if (i6 < 0) {
                                break;
                            }
                            size4 = i6;
                        }
                    }
                    pl3Var.b = nj0Var.h;
                    pl3Var.c = new la(nj0Var.i);
                    Executor executor4 = pl3Var.b;
                    if (executor4 == null) {
                        n12.T("internalQueryExecutor");
                        throw null;
                    }
                    ce0 ce0VarA = p95.a(tj4.W(n12.x(executor4), gb4.d()));
                    pl3Var.a = ce0VarA;
                    cf0 cf0Var = ce0VarA.b;
                    la laVar = pl3Var.c;
                    if (laVar == null) {
                        n12.T("internalTransactionExecutor");
                        throw null;
                    }
                    cf0Var.X(n12.x(laVar));
                    pl3Var.g = nj0Var.f;
                    ew ewVar = pl3Var.d;
                    if (ewVar == null) {
                        n12.T("connectionManager");
                        throw null;
                    }
                    f64 f64VarD = ewVar.d();
                    if (f64VarD == null) {
                        f64VarG = null;
                        break;
                    }
                    f64VarG = f64VarD;
                    while (!(f64VarG instanceof l23)) {
                        if (!(f64VarG instanceof sn0)) {
                            f64VarG = null;
                            break;
                        }
                        f64VarG = ((sn0) f64VarG).g();
                    }
                    ew ewVar2 = pl3Var.d;
                    if (ewVar2 == null) {
                        n12.T("connectionManager");
                        throw null;
                    }
                    f64 f64VarD2 = ewVar2.d();
                    if (f64VarD2 == null) {
                        f64VarG2 = null;
                        break;
                    }
                    f64VarG2 = f64VarD2;
                    while (!(f64VarG2 instanceof eg)) {
                        if (!(f64VarG2 instanceof sn0)) {
                            f64VarG2 = null;
                            break;
                        }
                        f64VarG2 = ((sn0) f64VarG2).g();
                    }
                    return pl3Var;
                }
                j50 j50Var3 = (j50) it2.next();
                int size5 = list.size() - 1;
                if (size5 >= 0) {
                    while (true) {
                        int i7 = size5 - 1;
                        if (j50Var3.d(list.get(size5))) {
                            zArr[size5] = true;
                            i = size5;
                            break;
                        }
                        if (i7 < 0) {
                            break;
                        }
                        size5 = i7;
                    }
                }
                if (i < 0) {
                    s53.t("A required auto migration spec (", j50Var3.b(), ") is missing in the database configuration.");
                    return null;
                }
                linkedHashMap.put(j50Var3, list.get(i));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find implementation for " + clsA.getCanonicalName() + ". " + strConcat + " does not exist. Is Room annotation processor correctly configured?", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot access the constructor " + clsA.getCanonicalName(), e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Failed to create an instance of " + clsA.getCanonicalName(), e3);
        }
    }
}
