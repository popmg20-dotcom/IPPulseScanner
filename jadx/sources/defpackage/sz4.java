package defpackage;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sz4 implements rp1, sp1 {
    public final t9 d;
    public final x9 e;
    public final e24 f;
    public final int i;
    public final b05 j;
    public boolean k;
    public final /* synthetic */ tp1 n;
    public final LinkedList c = new LinkedList();
    public final HashSet g = new HashSet();
    public final HashMap h = new HashMap();
    public final ArrayList l = new ArrayList();
    public ab0 m = null;

    /* JADX WARN: Multi-variable type inference failed */
    public sz4(tp1 tp1Var, kp1 kp1Var) {
        this.n = tp1Var;
        Looper looper = tp1Var.m.getLooper();
        ed4 ed4VarA = kp1Var.a();
        uf4 uf4Var = new uf4((String) ed4VarA.z, (String) ed4VarA.A, (me) ed4VarA.f);
        t9 t9VarJ = ((kz4) kp1Var.c.f).j(kp1Var.a, looper, uf4Var, kp1Var.d, this, this);
        String str = kp1Var.b;
        if (str != null && (t9VarJ instanceof tk)) {
            ((tk) t9VarJ).J0 = str;
        }
        if (str != null && (t9VarJ instanceof ks2)) {
            dw2.I(t9VarJ);
            throw null;
        }
        this.d = t9VarJ;
        this.e = kp1Var.e;
        this.f = new e24(26);
        this.i = kp1Var.f;
        if (!t9VarJ.j()) {
            this.j = null;
            return;
        }
        Context context = tp1Var.e;
        s05 s05Var = tp1Var.m;
        ed4 ed4VarA2 = kp1Var.a();
        this.j = new b05(context, s05Var, new uf4((String) ed4VarA2.z, (String) ed4VarA2.A, (me) ed4VarA2.f));
    }

    @Override // defpackage.sp1
    public final void a(ab0 ab0Var) {
        o(ab0Var, null);
    }

    @Override // defpackage.rp1
    public final void b(int i) {
        Looper looperMyLooper = Looper.myLooper();
        s05 s05Var = this.n.m;
        if (looperMyLooper == s05Var.getLooper()) {
            i(i);
        } else {
            s05Var.post(new zv(i, 4, this));
        }
    }

    @Override // defpackage.rp1
    public final void c() {
        Looper looperMyLooper = Looper.myLooper();
        s05 s05Var = this.n.m;
        if (looperMyLooper == s05Var.getLooper()) {
            h();
        } else {
            s05Var.post(new f33(29, this));
        }
    }

    public final void d(ab0 ab0Var) {
        HashSet hashSet = this.g;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() != null) {
            st4.n();
        } else {
            if (gb4.I(ab0Var, ab0.X)) {
                this.d.d();
            }
            throw null;
        }
    }

    public final void e(Status status) {
        tj4.e(this.n.m);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z) {
        tj4.e(this.n.m);
        if ((status == null) == (exc == null)) {
            xe.k("Status XOR exception should be null");
            return;
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            yz4 yz4Var = (yz4) it.next();
            if (!z || yz4Var.a == 2) {
                if (status != null) {
                    yz4Var.c(status);
                } else {
                    yz4Var.d(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.c;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            yz4 yz4Var = (yz4) arrayList.get(i);
            if (!this.d.isConnected()) {
                return;
            }
            if (k(yz4Var)) {
                linkedList.remove(yz4Var);
            }
        }
    }

    public final void h() {
        tp1 tp1Var = this.n;
        tj4.e(tp1Var.m);
        this.m = null;
        d(ab0.X);
        s05 s05Var = tp1Var.m;
        if (this.k) {
            x9 x9Var = this.e;
            s05Var.removeMessages(11, x9Var);
            s05Var.removeMessages(9, x9Var);
            this.k = false;
        }
        Iterator it = this.h.values().iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        g();
        j();
    }

    public final void i(int i) {
        tp1 tp1Var = this.n;
        s05 s05Var = tp1Var.m;
        tj4.e(tp1Var.m);
        this.m = null;
        this.k = true;
        String strI = this.d.i();
        e24 e24Var = this.f;
        e24Var.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strI != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strI);
        }
        e24Var.I(true, new Status(20, sb.toString(), null, null));
        x9 x9Var = this.e;
        s05Var.sendMessageDelayed(Message.obtain(s05Var, 9, x9Var), 5000L);
        s05Var.sendMessageDelayed(Message.obtain(s05Var, 11, x9Var), 120000L);
        ((SparseIntArray) tp1Var.g.f).clear();
        Iterator it = this.h.values().iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
    }

    public final void j() {
        tp1 tp1Var = this.n;
        s05 s05Var = tp1Var.m;
        x9 x9Var = this.e;
        s05Var.removeMessages(12, x9Var);
        s05Var.sendMessageDelayed(s05Var.obtainMessage(12, x9Var), tp1Var.a);
    }

    public final boolean k(yz4 yz4Var) {
        ic1 ic1Var;
        if (yz4Var == null) {
            e24 e24Var = this.f;
            t9 t9Var = this.d;
            yz4Var.f(e24Var, t9Var.j());
            try {
                yz4Var.e(this);
                return true;
            } catch (DeadObjectException unused) {
                b(1);
                t9Var.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        ic1[] ic1VarArrB = yz4Var.b(this);
        if (ic1VarArrB == null || ic1VarArrB.length == 0) {
            ic1Var = null;
        } else {
            ic1[] ic1VarArrH = this.d.h();
            if (ic1VarArrH == null) {
                ic1VarArrH = new ic1[0];
            }
            ie ieVar = new ie(ic1VarArrH.length);
            for (ic1 ic1Var2 : ic1VarArrH) {
                ieVar.put(ic1Var2.b, Long.valueOf(ic1Var2.a()));
            }
            int length = ic1VarArrB.length;
            for (int i = 0; i < length; i++) {
                ic1Var = ic1VarArrB[i];
                Long l = (Long) ieVar.get(ic1Var.b);
                if (l == null || l.longValue() < ic1Var.a()) {
                    break;
                }
            }
            ic1Var = null;
        }
        if (ic1Var == null) {
            e24 e24Var2 = this.f;
            t9 t9Var2 = this.d;
            yz4Var.f(e24Var2, t9Var2.j());
            try {
                yz4Var.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                b(1);
                t9Var2.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        a1.n("GoogleApiManager", this.d.getClass().getName() + " could not execute call because it requires feature (" + ic1Var.b + ", " + ic1Var.a() + ").");
        if (!this.n.n || !yz4Var.a(this)) {
            yz4Var.d(new ym4(ic1Var));
            return true;
        }
        tz4 tz4Var = new tz4(this.e, ic1Var);
        int iIndexOf = this.l.indexOf(tz4Var);
        ArrayList arrayList = this.l;
        if (iIndexOf >= 0) {
            tz4 tz4Var2 = (tz4) arrayList.get(iIndexOf);
            this.n.m.removeMessages(15, tz4Var2);
            s05 s05Var = this.n.m;
            s05Var.sendMessageDelayed(Message.obtain(s05Var, 15, tz4Var2), 5000L);
            return false;
        }
        arrayList.add(tz4Var);
        s05 s05Var2 = this.n.m;
        s05Var2.sendMessageDelayed(Message.obtain(s05Var2, 15, tz4Var), 5000L);
        s05 s05Var3 = this.n.m;
        s05Var3.sendMessageDelayed(Message.obtain(s05Var3, 16, tz4Var), 120000L);
        ab0 ab0Var = new ab0(2, null);
        if (!l(ab0Var)) {
            this.n.a(ab0Var, this.i);
        }
        return false;
    }

    public final boolean l(ab0 ab0Var) {
        synchronized (tp1.q) {
        }
        return false;
    }

    public final void m() {
        tp1 tp1Var = this.n;
        tj4.e(tp1Var.m);
        t9 t9Var = this.d;
        if (t9Var.isConnected() || t9Var.c()) {
            return;
        }
        try {
            rz4 rz4Var = tp1Var.g;
            Context context = tp1Var.e;
            SparseIntArray sparseIntArray = (SparseIntArray) rz4Var.f;
            tj4.i(context);
            int iG = t9Var.g();
            int iB = ((SparseIntArray) rz4Var.f).get(iG, -1);
            if (iB == -1) {
                iB = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > iG && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iB == -1) {
                    iB = lp1.d.b(context, iG);
                }
                sparseIntArray.put(iG, iB);
            }
            if (iB != 0) {
                ab0 ab0Var = new ab0(iB, null);
                a1.n("GoogleApiManager", "The service for " + t9Var.getClass().getName() + " is not available: " + ab0Var.toString());
                o(ab0Var, null);
                return;
            }
            x8 x8Var = new x8(tp1Var, t9Var, this.e);
            if (t9Var.j()) {
                b05 b05Var = this.j;
                tj4.i(b05Var);
                Handler handler = b05Var.e;
                uf4 uf4Var = b05Var.h;
                kw3 kw3Var = b05Var.i;
                if (kw3Var != null) {
                    kw3Var.n();
                }
                uf4Var.g = Integer.valueOf(System.identityHashCode(b05Var));
                b05Var.i = (kw3) b05Var.f.j(b05Var.d, handler.getLooper(), uf4Var, (lw3) uf4Var.f, b05Var, b05Var);
                b05Var.j = x8Var;
                Set set = b05Var.g;
                if (set == null || set.isEmpty()) {
                    handler.post(new qz4(1, b05Var));
                } else {
                    kw3 kw3Var2 = b05Var.i;
                    kw3Var2.getClass();
                    kw3Var2.e(new cp1(kw3Var2));
                }
            }
            try {
                t9Var.e(x8Var);
            } catch (SecurityException e) {
                o(new ab0(10), e);
            }
        } catch (IllegalStateException e2) {
            o(new ab0(10), e2);
        }
    }

    public final void n(yz4 yz4Var) {
        tj4.e(this.n.m);
        boolean zIsConnected = this.d.isConnected();
        LinkedList linkedList = this.c;
        if (zIsConnected) {
            if (k(yz4Var)) {
                j();
                return;
            } else {
                linkedList.add(yz4Var);
                return;
            }
        }
        linkedList.add(yz4Var);
        ab0 ab0Var = this.m;
        if (ab0Var == null || ab0Var.f == 0 || ab0Var.z == null) {
            m();
        } else {
            o(ab0Var, null);
        }
    }

    public final void o(ab0 ab0Var, RuntimeException runtimeException) {
        kw3 kw3Var;
        tj4.e(this.n.m);
        b05 b05Var = this.j;
        if (b05Var != null && (kw3Var = b05Var.i) != null) {
            kw3Var.n();
        }
        tj4.e(this.n.m);
        this.m = null;
        ((SparseIntArray) this.n.g.f).clear();
        d(ab0Var);
        if ((this.d instanceof q05) && ab0Var.f != 24) {
            tp1 tp1Var = this.n;
            tp1Var.b = true;
            s05 s05Var = tp1Var.m;
            s05Var.sendMessageDelayed(s05Var.obtainMessage(19), 300000L);
        }
        if (ab0Var.f == 4) {
            e(tp1.p);
            return;
        }
        if (this.c.isEmpty()) {
            this.m = ab0Var;
            return;
        }
        tp1 tp1Var2 = this.n;
        if (runtimeException != null) {
            tj4.e(tp1Var2.m);
            f(null, runtimeException, false);
            return;
        }
        boolean z = tp1Var2.n;
        x9 x9Var = this.e;
        if (!z) {
            e(tp1.b(x9Var, ab0Var));
            return;
        }
        f(tp1.b(x9Var, ab0Var), null, true);
        if (this.c.isEmpty() || l(ab0Var) || this.n.a(ab0Var, this.i)) {
            return;
        }
        if (ab0Var.f == 18) {
            this.k = true;
        }
        if (!this.k) {
            e(tp1.b(this.e, ab0Var));
            return;
        }
        tp1 tp1Var3 = this.n;
        x9 x9Var2 = this.e;
        s05 s05Var2 = tp1Var3.m;
        s05Var2.sendMessageDelayed(Message.obtain(s05Var2, 9, x9Var2), 5000L);
    }

    public final void p(ab0 ab0Var) {
        tj4.e(this.n.m);
        t9 t9Var = this.d;
        t9Var.b("onSignInFailed for " + t9Var.getClass().getName() + " with " + String.valueOf(ab0Var));
        o(ab0Var, null);
    }

    public final void q() {
        tj4.e(this.n.m);
        Status status = tp1.o;
        e(status);
        int i = 0;
        this.f.I(false, status);
        for (uc2 uc2Var : (uc2[]) this.h.keySet().toArray(new uc2[0])) {
            n(new k05(new wa4()));
        }
        d(new ab0(4));
        t9 t9Var = this.d;
        if (t9Var.isConnected()) {
            t9Var.f(new rz4(i, this));
        }
    }
}
