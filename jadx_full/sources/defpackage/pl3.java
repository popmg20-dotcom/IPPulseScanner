package defpackage;

import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pl3 {
    public ce0 a;
    public Executor b;
    public la c;
    public ew d;
    public y12 e;
    public boolean g;
    public final lb f = new lb(new ly2(0, this, pl3.class, "onClosed", "onClosed()V", 0, 3));
    public final ThreadLocal h = new ThreadLocal();
    public final LinkedHashMap i = new LinkedHashMap();
    public boolean j = true;

    public final void a() {
        if (this.g) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            xe.q("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        a();
        a();
        gl1 gl1VarT = h().T();
        if (!gl1VarT.I()) {
            co4.R(new w12(g(), null, 2));
        }
        if (gl1VarT.b.isWriteAheadLoggingEnabled()) {
            gl1VarT.n();
        } else {
            gl1VarT.g();
        }
    }

    public List c(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(fh2.U(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            j50 j50Var = (j50) entry.getKey();
            j50Var.getClass();
            Class clsA = j50Var.a();
            clsA.getClass();
            linkedHashMap2.put(clsA, entry.getValue());
        }
        return g41.b;
    }

    public abstract y12 d();

    public h31 e() {
        throw new ss2(0);
    }

    public final lf0 f() {
        ce0 ce0Var = this.a;
        if (ce0Var != null) {
            return ce0Var;
        }
        n12.T("coroutineScope");
        throw null;
    }

    public final y12 g() {
        y12 y12Var = this.e;
        if (y12Var != null) {
            return y12Var;
        }
        n12.T("internalTracker");
        throw null;
    }

    public final f64 h() {
        ew ewVar = this.d;
        if (ewVar == null) {
            n12.T("connectionManager");
            throw null;
        }
        f64 f64VarD = ewVar.d();
        if (f64VarD != null) {
            return f64VarD;
        }
        xe.q("Cannot return a SupportSQLiteOpenHelper since no SupportSQLiteOpenHelper.Factory was configured with Room.");
        return null;
    }

    public Set i() {
        return d70.C0(new ArrayList(f70.Q(10, k41.b)));
    }

    public LinkedHashMap j() {
        int iU = fh2.U(f70.Q(10, k41.b));
        if (iU < 16) {
            iU = 16;
        }
        return new LinkedHashMap(iU);
    }

    public final boolean k() {
        ew ewVar = this.d;
        if (ewVar != null) {
            return ewVar.d() != null;
        }
        n12.T("connectionManager");
        throw null;
    }

    public final boolean l() {
        return o() && h().T().I();
    }

    public final void m() {
        h().T().x();
        if (l()) {
            return;
        }
        y12 y12VarG = g();
        y12VarG.b.d(y12VarG.e, y12VarG.f);
    }

    public final void n(go3 go3Var) {
        go3Var.getClass();
        y12 y12VarG = g();
        vh4 vh4Var = y12VarG.b;
        vh4Var.getClass();
        io3 io3VarD0 = go3Var.D0("PRAGMA query_only");
        try {
            io3VarD0.C0();
            boolean zL = io3VarD0.L();
            vf2.e(io3VarD0, null);
            if (!zL) {
                ez4.t(go3Var, "PRAGMA temp_store = MEMORY");
                ez4.t(go3Var, "PRAGMA recursive_triggers = 1");
                ez4.t(go3Var, "DROP TABLE IF EXISTS room_table_modification_log");
                if (vh4Var.d) {
                    ez4.t(go3Var, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                } else {
                    ez4.t(go3Var, w44.i0("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
                }
                ue1 ue1Var = vh4Var.h;
                ReentrantLock reentrantLock = (ReentrantLock) ue1Var.b;
                reentrantLock.lock();
                try {
                    ue1Var.f = true;
                } finally {
                    reentrantLock.unlock();
                }
            }
            synchronized (y12VarG.h) {
            }
        } finally {
        }
    }

    public final boolean o() {
        ew ewVar = this.d;
        if (ewVar == null) {
            n12.T("connectionManager");
            throw null;
        }
        gl1 gl1Var = (gl1) ewVar.g;
        if (gl1Var != null) {
            return gl1Var.b.isOpen();
        }
        return false;
    }

    public final Object p(pl1 pl1Var) {
        if (!k()) {
            return ke0.r(this, false, true, new f0(22, pl1Var));
        }
        b();
        try {
            Object objA = pl1Var.a();
            q();
            return objA;
        } finally {
            m();
        }
    }

    public final void q() {
        h().T().M();
    }

    public final Object r(boolean z, Function2 function2, ie0 ie0Var) {
        ew ewVar = this.d;
        if (ewVar != null) {
            return ((va0) ewVar.f).m(z, function2, ie0Var);
        }
        n12.T("connectionManager");
        throw null;
    }
}
