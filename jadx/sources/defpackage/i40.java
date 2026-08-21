package defpackage;

import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i40 implements dv2 {
    public final /* synthetic */ int b;
    public long f;
    public Object z;

    public /* synthetic */ i40(l75 l75Var, long j) {
        this.b = 3;
        this.z = l75Var;
        tj4.f("health_monitor");
        tj4.d(j > 0);
        this.f = j;
    }

    public void a(int i) {
        if (i < 64) {
            this.f &= ~(1 << i);
            return;
        }
        i40 i40Var = (i40) this.z;
        if (i40Var != null) {
            i40Var.a(i - 64);
        }
    }

    public int b(int i) {
        i40 i40Var = (i40) this.z;
        if (i40Var == null) {
            long j = this.f;
            return i >= 64 ? Long.bitCount(j) : Long.bitCount(((1 << i) - 1) & j);
        }
        if (i < 64) {
            return Long.bitCount(((1 << i) - 1) & this.f);
        }
        return Long.bitCount(this.f) + i40Var.b(i - 64);
    }

    @Override // defpackage.dv2
    public /* synthetic */ void c() {
        n02 n02Var = (n02) this.z;
        ((AtomicLong) n02Var.A).set(this.f);
    }

    public void d() {
        if (((i40) this.z) == null) {
            this.z = new i40();
        }
    }

    public boolean e(int i) {
        if (i < 64) {
            return ((1 << i) & this.f) != 0;
        }
        d();
        return ((i40) this.z).e(i - 64);
    }

    public void f(int i, boolean z) {
        if (i >= 64) {
            d();
            ((i40) this.z).f(i - 64, z);
            return;
        }
        long j = this.f;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.f = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            j(i);
        } else {
            a(i);
        }
        if (z2 || ((i40) this.z) != null) {
            d();
            ((i40) this.z).f(0, z2);
        }
    }

    public lr1 g() {
        m20 m20Var = new m20(1);
        while (true) {
            String strU = ((he3) this.z).U(this.f);
            this.f -= (long) strU.length();
            if (strU.length() == 0) {
                return gb4.y(m20Var);
            }
            int iU0 = p44.u0(strU, ':', 1, 4);
            if (iU0 != -1) {
                gb4.x(m20Var, strU.substring(0, iU0), strU.substring(iU0 + 1));
            } else if (strU.charAt(0) == ':') {
                gb4.x(m20Var, "", strU.substring(1));
            } else {
                gb4.x(m20Var, "", strU);
            }
        }
    }

    public boolean h(int i) {
        if (i >= 64) {
            d();
            return ((i40) this.z).h(i - 64);
        }
        long j = 1 << i;
        long j2 = this.f;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.f = j3;
        long j4 = j - 1;
        this.f = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        i40 i40Var = (i40) this.z;
        if (i40Var != null) {
            if (i40Var.e(0)) {
                j(63);
            }
            ((i40) this.z).h(0);
        }
        return z;
    }

    public void i() {
        this.f = 0L;
        i40 i40Var = (i40) this.z;
        if (i40Var != null) {
            i40Var.i();
        }
    }

    public void j(int i) {
        if (i < 64) {
            this.f |= 1 << i;
        } else {
            d();
            ((i40) this.z).j(i - 64);
        }
    }

    public void k() {
        l75 l75Var = (l75) this.z;
        l75Var.V0();
        ((k85) l75Var.f).B0.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = l75Var.Z0().edit();
        editorEdit.remove("health_monitor:count");
        editorEdit.remove("health_monitor:value");
        editorEdit.putLong("health_monitor:start", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public String toString() {
        switch (this.b) {
            case 0:
                if (((i40) this.z) == null) {
                    return Long.toBinaryString(this.f);
                }
                return ((i40) this.z).toString() + "xx" + Long.toBinaryString(this.f);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ i40(n02 n02Var, long j) {
        this.b = 2;
        this.z = n02Var;
        this.f = j;
    }

    public i40(he3 he3Var) {
        this.b = 1;
        this.z = he3Var;
        this.f = 262144L;
    }

    public i40() {
        this.b = 0;
        this.f = 0L;
    }
}
