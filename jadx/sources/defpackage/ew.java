package defpackage;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(defpackage.go3 r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew.f(go3, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(defpackage.go3 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ew.g(go3):void");
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
