package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.WeakHashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r02 {
    public static final r02[] e = new r02[8];
    public int a;
    public int b;
    public int c = 0;
    public Object d;

    public r02(p60 p60Var) {
        Charset charset = j12.a;
        this.d = p60Var;
        p60Var.b = this;
    }

    public void A() {
        synchronized (r02.class) {
            int i = 0;
            while (true) {
                try {
                    r02[] r02VarArr = e;
                    if (i >= 8) {
                        break;
                    }
                    if (r02VarArr[i] == null) {
                        r02VarArr[i] = this;
                        this.d = null;
                        this.a = 0;
                        this.c = 0;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void B(int i) throws t12 {
        if (((p60) this.d).b() != i) {
            throw t12.e();
        }
    }

    public void C(int i) throws r12 {
        if ((this.a & 7) != i) {
            throw t12.b();
        }
    }

    public boolean D() {
        int i;
        p60 p60Var = (p60) this.d;
        if (p60Var.c() || (i = this.a) == this.b) {
            return false;
        }
        return p60Var.x(i);
    }

    public void a(Object obj) {
        Object[] objArr = (Object[]) this.d;
        int i = this.b;
        objArr[i] = obj;
        int i2 = this.c & (i + 1);
        this.b = i2;
        int i3 = this.a;
        if (i2 == i3) {
            int length = objArr.length;
            int i4 = length - i3;
            int i5 = length << 1;
            if (i5 < 0) {
                zo2.w("Max array capacity exceeded");
                return;
            }
            Object[] objArr2 = new Object[i5];
            qe.c0(0, i3, length, objArr, objArr2);
            qe.c0(i4, 0, this.a, (Object[]) this.d, objArr2);
            this.d = objArr2;
            this.a = 0;
            this.b = length;
            this.c = i5 - 1;
        }
    }

    public void b(int i, int i2) {
        if (i < 0) {
            xe.k("Layout positions must be non-negative");
            return;
        }
        if (i2 < 0) {
            xe.k("Pixel distance must be non-negative");
            return;
        }
        int i3 = this.c;
        int i4 = i3 * 2;
        int[] iArr = (int[]) this.d;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.d;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.c++;
    }

    public void c() {
        View view = (View) this.d;
        int top = this.c - (view.getTop() - this.a);
        WeakHashMap weakHashMap = wp4.a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.b));
    }

    public void d(RecyclerView recyclerView, boolean z) {
        this.c = 0;
        int[] iArr = (int[]) this.d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        ag3 ag3Var = recyclerView.H0;
        if (recyclerView.G0 == null || ag3Var == null || !ag3Var.i) {
            return;
        }
        if (z) {
            if (!recyclerView.y0.k()) {
                ag3Var.i(recyclerView.G0.b(), this);
            }
        } else if (!recyclerView.R()) {
            ag3Var.h(this.a, this.b, recyclerView.y1, this);
        }
        int i = this.c;
        if (i > ag3Var.j) {
            ag3Var.j = i;
            ag3Var.k = z;
            recyclerView.z.n();
        }
    }

    public int e() {
        char cCharAt;
        int i = this.b;
        this.a = i;
        if (i == this.c) {
            return 2;
        }
        char cCharAt2 = ((CharSequence) this.d).charAt(i);
        if (cCharAt2 == '\n') {
            this.b = this.a + 1;
            return 1;
        }
        int i2 = this.a;
        if (cCharAt2 == '\r') {
            if (i2 + 1 >= this.c || ((CharSequence) this.d).charAt(i2 + 1) != '\n') {
                this.b = this.a + 1;
            } else {
                this.b = this.a + 2;
            }
            return 1;
        }
        this.b = i2 + 1;
        while (true) {
            int i3 = this.b;
            if (i3 >= this.c || (cCharAt = ((CharSequence) this.d).charAt(i3)) == '\n' || cCharAt == '\r') {
                return 0;
            }
            this.b++;
        }
    }

    public int f() {
        int iU = this.c;
        if (iU != 0) {
            this.a = iU;
            this.c = 0;
        } else {
            iU = ((p60) this.d).u();
            this.a = iU;
        }
        return (iU == 0 || iU == this.b) ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : iU >>> 3;
    }

    public void g(Object obj, gq3 gq3Var, p91 p91Var) {
        int i = this.b;
        this.b = ((this.a >>> 3) << 3) | 4;
        try {
            gq3Var.h(obj, this, p91Var);
            if (this.a == this.b) {
            } else {
                throw new t12("Failed to parse the message.");
            }
        } finally {
            this.b = i;
        }
    }

    public void h(Object obj, gq3 gq3Var, p91 p91Var) throws t12 {
        p60 p60Var = (p60) this.d;
        int iV = p60Var.v();
        if (p60Var.a >= 100) {
            throw new t12("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = p60Var.e(iV);
        p60Var.a++;
        gq3Var.h(obj, this, p91Var);
        p60Var.a(0);
        p60Var.a--;
        p60Var.d(iE);
    }

    public void i(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Boolean.valueOf(p60Var.f()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Boolean.valueOf(p60Var.f()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public au j() throws r12 {
        C(2);
        return ((p60) this.d).g();
    }

    public void k(h12 h12Var) throws r12 {
        int iU;
        p60 p60Var = (p60) this.d;
        if ((this.a & 7) != 2) {
            throw t12.b();
        }
        do {
            ((x93) h12Var).add(j());
            if (p60Var.c()) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == this.a);
        this.c = iU;
    }

    public void l(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 1) {
            do {
                ((x93) h12Var).add(Double.valueOf(p60Var.h()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iV = p60Var.v();
        if ((iV & 7) != 0) {
            throw new t12("Failed to parse the message.");
        }
        int iB = p60Var.b() + iV;
        do {
            ((x93) h12Var).add(Double.valueOf(p60Var.h()));
        } while (p60Var.b() < iB);
    }

    public void m(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.i()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.i()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public Object n(bw4 bw4Var, Class cls, p91 p91Var) throws t12 {
        p60 p60Var = (p60) this.d;
        switch (bw4Var.ordinal()) {
            case 0:
                C(1);
                return Double.valueOf(p60Var.h());
            case 1:
                C(5);
                return Float.valueOf(p60Var.l());
            case 2:
                C(0);
                return Long.valueOf(p60Var.n());
            case 3:
                C(0);
                return Long.valueOf(p60Var.w());
            case 4:
                C(0);
                return Integer.valueOf(p60Var.m());
            case 5:
                C(1);
                return Long.valueOf(p60Var.k());
            case 6:
                C(5);
                return Integer.valueOf(p60Var.j());
            case 7:
                C(0);
                return Boolean.valueOf(p60Var.f());
            case 8:
                C(2);
                return p60Var.t();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            default:
                xe.k("unsupported field type.");
                return null;
            case 10:
                C(2);
                gq3 gq3VarA = v93.c.a(cls);
                co1 co1VarI = gq3VarA.i();
                h(co1VarI, gq3VarA, p91Var);
                gq3VarA.b(co1VarI);
                return co1VarI;
            case 11:
                return j();
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                C(0);
                return Integer.valueOf(p60Var.v());
            case 13:
                C(0);
                return Integer.valueOf(p60Var.i());
            case 14:
                C(5);
                return Integer.valueOf(p60Var.o());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                C(1);
                return Long.valueOf(p60Var.p());
            case 16:
                C(0);
                return Integer.valueOf(p60Var.q());
            case 17:
                C(0);
                return Long.valueOf(p60Var.r());
        }
    }

    public void o(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 2) {
            int iV = p60Var.v();
            if ((iV & 3) != 0) {
                throw new t12("Failed to parse the message.");
            }
            int iB = p60Var.b() + iV;
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.j()));
            } while (p60Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw t12.b();
        }
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.j()));
            if (p60Var.c()) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == this.a);
        this.c = iU;
    }

    public void p(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 1) {
            do {
                ((x93) h12Var).add(Long.valueOf(p60Var.k()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iV = p60Var.v();
        if ((iV & 7) != 0) {
            throw new t12("Failed to parse the message.");
        }
        int iB = p60Var.b() + iV;
        do {
            ((x93) h12Var).add(Long.valueOf(p60Var.k()));
        } while (p60Var.b() < iB);
    }

    public void q(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 2) {
            int iV = p60Var.v();
            if ((iV & 3) != 0) {
                throw new t12("Failed to parse the message.");
            }
            int iB = p60Var.b() + iV;
            do {
                ((x93) h12Var).add(Float.valueOf(p60Var.l()));
            } while (p60Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw t12.b();
        }
        do {
            ((x93) h12Var).add(Float.valueOf(p60Var.l()));
            if (p60Var.c()) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == this.a);
        this.c = iU;
    }

    public void r(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.m()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.m()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public void s(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Long.valueOf(p60Var.n()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Long.valueOf(p60Var.n()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public void t(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 2) {
            int iV = p60Var.v();
            if ((iV & 3) != 0) {
                throw new t12("Failed to parse the message.");
            }
            int iB = p60Var.b() + iV;
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.o()));
            } while (p60Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw t12.b();
        }
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.o()));
            if (p60Var.c()) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == this.a);
        this.c = iU;
    }

    public void u(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 1) {
            do {
                ((x93) h12Var).add(Long.valueOf(p60Var.p()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iV = p60Var.v();
        if ((iV & 7) != 0) {
            throw new t12("Failed to parse the message.");
        }
        int iB = p60Var.b() + iV;
        do {
            ((x93) h12Var).add(Long.valueOf(p60Var.p()));
        } while (p60Var.b() < iB);
    }

    public void v(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.q()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.q()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public void w(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Long.valueOf(p60Var.r()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Long.valueOf(p60Var.r()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public void x(h12 h12Var, boolean z) throws r12 {
        String strS;
        int iU;
        p60 p60Var = (p60) this.d;
        if ((this.a & 7) != 2) {
            throw t12.b();
        }
        do {
            if (z) {
                C(2);
                strS = p60Var.t();
            } else {
                C(2);
                strS = p60Var.s();
            }
            ((x93) h12Var).add(strS);
            if (p60Var.c()) {
                return;
            } else {
                iU = p60Var.u();
            }
        } while (iU == this.a);
        this.c = iU;
    }

    public void y(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Integer.valueOf(p60Var.v()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Integer.valueOf(p60Var.v()));
        } while (p60Var.b() < iB);
        B(iB);
    }

    public void z(h12 h12Var) throws t12 {
        int iU;
        p60 p60Var = (p60) this.d;
        int i = this.a & 7;
        if (i == 0) {
            do {
                ((x93) h12Var).add(Long.valueOf(p60Var.w()));
                if (p60Var.c()) {
                    return;
                } else {
                    iU = p60Var.u();
                }
            } while (iU == this.a);
            this.c = iU;
            return;
        }
        if (i != 2) {
            throw t12.b();
        }
        int iB = p60Var.b() + p60Var.v();
        do {
            ((x93) h12Var).add(Long.valueOf(p60Var.w()));
        } while (p60Var.b() < iB);
        B(iB);
    }
}
