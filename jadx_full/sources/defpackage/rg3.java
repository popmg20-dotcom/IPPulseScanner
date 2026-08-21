package defpackage;

import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rg3 {
    public static final List t = Collections.EMPTY_LIST;
    public final View a;
    public WeakReference b;
    public int j;
    public RecyclerView r;
    public rf3 s;
    public int c = -1;
    public int d = -1;
    public long e = -1;
    public int f = -1;
    public int g = -1;
    public rg3 h = null;
    public rg3 i = null;
    public ArrayList k = null;
    public List l = null;
    public int m = 0;
    public ig3 n = null;
    public boolean o = false;
    public int p = 0;
    public int q = -1;

    public rg3(View view) {
        if (view != null) {
            this.a = view;
        } else {
            xe.k("itemView may not be null");
            throw null;
        }
    }

    public final void a(int i) {
        this.j = i | this.j;
    }

    public final int b() {
        RecyclerView recyclerView = this.r;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.L(this);
    }

    public final int c() {
        RecyclerView recyclerView;
        rf3 adapter;
        int iL;
        if (this.s == null || (recyclerView = this.r) == null || (adapter = recyclerView.getAdapter()) == null || (iL = this.r.L(this)) == -1 || this.s != adapter) {
            return -1;
        }
        return iL;
    }

    public final int d() {
        int i = this.g;
        return i == -1 ? this.c : i;
    }

    public final List e() {
        ArrayList arrayList;
        return ((this.j & 1024) != 0 || (arrayList = this.k) == null || arrayList.size() == 0) ? t : this.l;
    }

    public final boolean f() {
        View view = this.a;
        return (view.getParent() == null || view.getParent() == this.r) ? false : true;
    }

    public final boolean g() {
        return (this.j & 1) != 0;
    }

    public final boolean h() {
        return (this.j & 4) != 0;
    }

    public final boolean i() {
        if ((this.j & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = wp4.a;
        return !this.a.hasTransientState();
    }

    public final boolean j() {
        return (this.j & 8) != 0;
    }

    public final boolean k() {
        return this.n != null;
    }

    public final boolean l() {
        return (this.j & 256) != 0;
    }

    public final boolean m() {
        return (this.j & 2) != 0;
    }

    public final void n(int i, boolean z) {
        if (this.d == -1) {
            this.d = this.c;
        }
        int i2 = this.g;
        if (i2 == -1) {
            i2 = this.c;
            this.g = i2;
        }
        if (z) {
            this.g = i2 + i;
        }
        this.c += i;
        View view = this.a;
        if (view.getLayoutParams() != null) {
            ((bg3) view.getLayoutParams()).c = true;
        }
    }

    public final void o() {
        if (RecyclerView.T1 && l()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.j = 0;
        this.c = -1;
        this.d = -1;
        this.e = -1L;
        this.g = -1;
        this.m = 0;
        this.h = null;
        this.i = null;
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.j &= -1025;
        this.p = 0;
        this.q = -1;
        RecyclerView.l(this);
    }

    public final void p(boolean z) {
        int i = this.m;
        int i2 = z ? i - 1 : i + 1;
        this.m = i2;
        if (i2 < 0) {
            this.m = 0;
            if (RecyclerView.T1) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            a1.d("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && i2 == 1) {
            this.j |= 16;
        } else if (z && i2 == 0) {
            this.j &= -17;
        }
        if (RecyclerView.U1) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
        }
    }

    public final boolean q() {
        return (this.j & 128) != 0;
    }

    public final boolean r() {
        return (this.j & 32) != 0;
    }

    public final String toString() {
        StringBuilder sbQ = ha0.q(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
        sbQ.append(Integer.toHexString(hashCode()));
        sbQ.append(" position=");
        sbQ.append(this.c);
        sbQ.append(" id=");
        sbQ.append(this.e);
        sbQ.append(", oldPos=");
        sbQ.append(this.d);
        sbQ.append(", pLpos:");
        sbQ.append(this.g);
        StringBuilder sb = new StringBuilder(sbQ.toString());
        if (k()) {
            sb.append(" scrap ");
            sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
        }
        if (h()) {
            sb.append(" invalid");
        }
        if (!g()) {
            sb.append(" unbound");
        }
        if ((this.j & 2) != 0) {
            sb.append(" update");
        }
        if (j()) {
            sb.append(" removed");
        }
        if (q()) {
            sb.append(" ignored");
        }
        if (l()) {
            sb.append(" tmpDetached");
        }
        if (!i()) {
            sb.append(" not recyclable(" + this.m + ")");
        }
        if ((this.j & 512) != 0 || h()) {
            sb.append(" undefined adapter position");
        }
        if (this.a.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }
}
