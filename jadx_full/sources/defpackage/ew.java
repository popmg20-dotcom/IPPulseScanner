package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ew {
    public boolean a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public Object f;
    public Object g;

    public ew(nj0 nj0Var, h31 h31Var) {
        int i;
        za0 za0Var;
        ol3 ol3Var = nj0Var.g;
        e64 e64Var = nj0Var.c;
        String str = nj0Var.b;
        this.c = nj0Var;
        this.d = h31Var;
        Object obj = nj0Var.e;
        this.e = obj == null ? g41.b : obj;
        ho3 ho3Var = nj0Var.p;
        if (ho3Var != null) {
            if (str == null) {
                za0Var = new za0(new lb(this, ho3Var));
            } else {
                lb lbVar = new lb(this, ho3Var);
                int iOrdinal = ol3Var.ordinal();
                if (iOrdinal == 1) {
                    i = 1;
                } else {
                    if (iOrdinal != 2) {
                        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + ol3Var + '\'').toString());
                    }
                    i = 4;
                }
                int iOrdinal2 = ol3Var.ordinal();
                if (iOrdinal2 != 1 && iOrdinal2 != 2) {
                    throw new IllegalStateException(("Can't get max number of writers for journal mode '" + ol3Var + '\'').toString());
                }
                za0Var = new za0(lbVar, str, i);
            }
            this.f = za0Var;
        } else {
            if (e64Var == null) {
                xe.k("SQLiteManager was constructed with both null driver and open helper factory!");
                throw null;
            }
            Context context = nj0Var.a;
            context.getClass();
            this.f = new d64(new wn1(e64Var.b(new a40(context, str, new t6(this, h31Var.a), false, false))));
        }
        boolean z = ol3Var == ol3.f;
        f64 f64VarD = d();
        if (f64VarD != null) {
            f64VarD.setWriteAheadLoggingEnabled(z);
        }
    }

    public static void b(go3 go3Var) {
        io3 io3VarD0 = go3Var.D0("PRAGMA busy_timeout");
        try {
            io3VarD0.C0();
            long j = io3VarD0.getLong(0);
            vf2.e(io3VarD0, null);
            if (j < 3000) {
                ez4.t(go3Var, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                vf2.e(io3VarD0, th);
                throw th2;
            }
        }
    }

    public void a(qx qxVar) {
        synchronized (this.e) {
            qn2 qn2Var = ((qx) this.f).b;
            ia0 ia0Var = ia0.b;
            for (pg pgVar : qn2Var.t()) {
                qxVar.b.f(pgVar, ia0Var, qn2Var.u(pgVar));
            }
        }
    }

    public void c(go3 go3Var) throws Throwable {
        Object tk3Var;
        h31 h31Var = (h31) this.d;
        nj0 nj0Var = (nj0) this.c;
        ol3 ol3Var = nj0Var.g;
        ol3 ol3Var2 = ol3.f;
        if (ol3Var == ol3Var2) {
            ez4.t(go3Var, "PRAGMA journal_mode = WAL");
        } else {
            ez4.t(go3Var, "PRAGMA journal_mode = TRUNCATE");
        }
        if (nj0Var.g == ol3Var2) {
            ez4.t(go3Var, "PRAGMA synchronous = NORMAL");
        } else {
            ez4.t(go3Var, "PRAGMA synchronous = FULL");
        }
        b(go3Var);
        io3 io3VarD0 = go3Var.D0("PRAGMA user_version");
        try {
            io3VarD0.C0();
            int i = (int) io3VarD0.getLong(0);
            vf2.e(io3VarD0, null);
            int i2 = h31Var.a;
            int i3 = h31Var.a;
            if (i != i2) {
                ez4.t(go3Var, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    if (i == 0) {
                        e(go3Var);
                    } else {
                        f(go3Var, i, i3);
                    }
                    ez4.t(go3Var, "PRAGMA user_version = " + i3);
                    tk3Var = xl4.a;
                } catch (Throwable th) {
                    tk3Var = new tk3(th);
                }
                if (!(tk3Var instanceof tk3)) {
                    ez4.t(go3Var, "END TRANSACTION");
                }
                Throwable thA = uk3.a(tk3Var);
                if (thA != null) {
                    ez4.t(go3Var, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            g(go3Var);
        } finally {
        }
    }

    public f64 d() {
        va0 va0Var = (va0) this.f;
        d64 d64Var = va0Var instanceof d64 ? (d64) va0Var : null;
        if (d64Var != null) {
            return (f64) d64Var.b.f;
        }
        return null;
    }

    public void e(go3 go3Var) {
        h31 h31Var = (h31) this.d;
        go3Var.getClass();
        io3 io3VarD0 = go3Var.D0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (io3VarD0.C0()) {
                if (io3VarD0.getLong(0) == 0) {
                    z = true;
                }
            }
            vf2.e(io3VarD0, null);
            h31Var.a(go3Var);
            if (!z) {
                h6 h6VarV = h31Var.v(go3Var);
                if (!h6VarV.b) {
                    throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + h6VarV.c).toString());
                }
            }
            h(go3Var);
            h31Var.r(go3Var);
            Iterator it = ((List) this.e).iterator();
            while (it.hasNext()) {
                ((nl3) it.next()).getClass();
                if (go3Var instanceof c64) {
                    ((c64) go3Var).b.getClass();
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x00a1 A[EDGE_INSN: B:117:0x00a1->B:39:0x00a1 BREAK  A[LOOP:4: B:9:0x0028->B:121:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(go3 go3Var, int i, int i2) {
        Iterable iterable;
        e03 e03Var;
        boolean z;
        h31 h31Var = (h31) this.d;
        go3Var.getClass();
        nj0 nj0Var = (nj0) this.c;
        jf2 jf2Var = nj0Var.d;
        if (i == i2) {
            iterable = g41.b;
        } else {
            boolean z2 = i2 > i;
            ArrayList arrayList = new ArrayList();
            int i3 = i;
            do {
                if (z2) {
                    if (i3 >= i2) {
                        iterable = arrayList;
                        break;
                    }
                    LinkedHashMap linkedHashMap = jf2Var.a;
                    if (z2) {
                        TreeMap treeMap = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                        if (treeMap != null) {
                            e03Var = new e03(treeMap, treeMap.keySet());
                        }
                        if (e03Var != null) {
                        }
                    } else {
                        TreeMap treeMap2 = (TreeMap) linkedHashMap.get(Integer.valueOf(i3));
                        e03Var = treeMap2 == null ? null : new e03(treeMap2, treeMap2.descendingKeySet());
                        if (e03Var != null) {
                            break;
                        }
                        Map map = (Map) e03Var.b;
                        Iterator it = ((Iterable) e03Var.f).iterator();
                        while (it.hasNext()) {
                            int iIntValue = ((Number) it.next()).intValue();
                            if (!z2) {
                                if (i2 <= iIntValue && iIntValue < i3) {
                                    Object obj = map.get(Integer.valueOf(iIntValue));
                                    obj.getClass();
                                    arrayList.add(obj);
                                    z = true;
                                    i3 = iIntValue;
                                    break;
                                    break;
                                }
                            } else if (i3 + 1 <= iIntValue && iIntValue <= i2) {
                                Object obj2 = map.get(Integer.valueOf(iIntValue));
                                obj2.getClass();
                                arrayList.add(obj2);
                                z = true;
                                i3 = iIntValue;
                                break;
                            }
                        }
                        z = false;
                    }
                } else {
                    if (i3 <= i2) {
                        iterable = arrayList;
                        break;
                    }
                    LinkedHashMap linkedHashMap2 = jf2Var.a;
                    if (z2) {
                    }
                }
            } while (z);
            iterable = null;
        }
        if (iterable != null) {
            h31Var.u(go3Var);
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                ((fm2) it2.next()).b(go3Var);
            }
            h6 h6VarV = h31Var.v(go3Var);
            if (h6VarV.b) {
                h31Var.t(go3Var);
                h(go3Var);
                return;
            } else {
                throw new IllegalStateException(("Migration didn't properly handle: " + h6VarV.c).toString());
            }
        }
        if (ek0.t(nj0Var, i, i2)) {
            throw new IllegalStateException(("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
        }
        if (nj0Var.o) {
            io3 io3VarD0 = go3Var.D0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                ub2 ub2VarI = p95.i();
                while (io3VarD0.C0()) {
                    String strE0 = io3VarD0.e0(0);
                    if (!w44.j0(strE0, "sqlite_", false) && !strE0.equals("android_metadata")) {
                        ub2VarI.add(new e03(strE0, Boolean.valueOf(n12.c(io3VarD0.e0(1), "view"))));
                    }
                }
                ub2 ub2VarC = p95.c(ub2VarI);
                vf2.e(io3VarD0, null);
                ListIterator listIterator = ub2VarC.listIterator(0);
                while (true) {
                    sb2 sb2Var = (sb2) listIterator;
                    if (!sb2Var.hasNext()) {
                        break;
                    }
                    e03 e03Var2 = (e03) sb2Var.next();
                    String str = (String) e03Var2.b;
                    if (((Boolean) e03Var2.f).booleanValue()) {
                        ez4.t(go3Var, "DROP VIEW IF EXISTS " + str);
                    } else {
                        ez4.t(go3Var, "DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        } else {
            h31Var.c(go3Var);
        }
        Iterator it3 = ((List) this.e).iterator();
        while (it3.hasNext()) {
            ((nl3) it3.next()).getClass();
            if (go3Var instanceof c64) {
                ((c64) go3Var).b.getClass();
            }
        }
        h31Var.a(go3Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(go3 go3Var) throws Throwable {
        boolean z;
        Object tk3Var;
        h6 h6VarV;
        go3Var.getClass();
        h31 h31Var = (h31) this.d;
        io3 io3VarD0 = go3Var.D0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            if (io3VarD0.C0()) {
                z = io3VarD0.getLong(0) != 0;
            }
            vf2.e(io3VarD0, null);
            if (z) {
                io3VarD0 = go3Var.D0("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
                try {
                    String strE0 = io3VarD0.C0() ? io3VarD0.e0(0) : null;
                    vf2.e(io3VarD0, null);
                    if (!((String) h31Var.b).equals(strE0) && !((String) h31Var.c).equals(strE0)) {
                        throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + ((String) h31Var.b) + ", found: " + strE0).toString());
                    }
                } finally {
                }
            } else {
                ez4.t(go3Var, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    h6VarV = h31Var.v(go3Var);
                } catch (Throwable th) {
                    tk3Var = new tk3(th);
                }
                if (!h6VarV.b) {
                    throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + h6VarV.c).toString());
                }
                h31Var.t(go3Var);
                h(go3Var);
                tk3Var = xl4.a;
                if (!(tk3Var instanceof tk3)) {
                    ez4.t(go3Var, "END TRANSACTION");
                }
                Throwable thA = uk3.a(tk3Var);
                if (thA != null) {
                    ez4.t(go3Var, "ROLLBACK TRANSACTION");
                    throw thA;
                }
            }
            h31Var.s(go3Var);
            for (nl3 nl3Var : (List) this.e) {
                nl3Var.getClass();
                if (go3Var instanceof c64) {
                    nl3Var.a(((c64) go3Var).b);
                }
            }
            this.a = true;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public void h(go3 go3Var) {
        ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        ez4.t(go3Var, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + ((String) ((h31) this.d).b) + "')");
    }

    public ew(nj0 nj0Var, ji jiVar) {
        this.c = nj0Var;
        this.d = new kl3("", -1, "");
        List list = nj0Var.e;
        g41 g41Var = g41.b;
        this.e = list == null ? g41Var : list;
        d70.n0(list == null ? g41Var : list, new ll3(new f0(21, this)));
        Context context = nj0Var.a;
        Executor executor = nj0Var.h;
        Executor executor2 = nj0Var.i;
        context.getClass();
        executor.getClass();
        executor2.getClass();
        throw new ss2(0);
    }

    public ew(nw nwVar, at3 at3Var) {
        this.a = false;
        this.b = false;
        this.e = new Object();
        this.f = new qx(0);
        this.c = nwVar;
        this.d = at3Var;
    }
}
