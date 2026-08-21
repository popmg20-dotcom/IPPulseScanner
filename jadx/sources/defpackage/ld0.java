package defpackage;

import j$.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ld0 implements CharSequence {
    public int A;
    public lg0 A0;
    public int X;
    public final AtomicLong Y = new AtomicLong(1);
    public final su Z;
    public final ArrayList b;
    public final ArrayList f;
    public final md0 y0;
    public final ReentrantReadWriteLock z;
    public final jl4 z0;

    public ld0(CharSequence charSequence, boolean z) {
        charSequence = charSequence == null ? "" : charSequence;
        if (z) {
            this.z = new ReentrantReadWriteLock();
        } else {
            this.z = null;
        }
        this.A = 0;
        this.X = 0;
        ArrayList arrayList = new ArrayList(1000);
        this.b = arrayList;
        arrayList.add(new ud0((Object) null));
        this.f = new ArrayList();
        this.y0 = new md0(this);
        jl4 jl4Var = new jl4();
        this.z0 = jl4Var;
        jl4Var.z = 500;
        jl4Var.a0();
        this.Z = new su(this);
        if (charSequence.length() == 0) {
            A(true);
            return;
        }
        A(false);
        r(0, 0, charSequence);
        A(true);
    }

    public final void A(boolean z) {
        jl4 jl4Var = this.z0;
        jl4Var.f = z;
        if (z) {
            return;
        }
        jl4Var.a0();
    }

    public final ld0 B(int i, int i2, int i3, int i4) {
        ld0 ld0Var = new ld0(null, true);
        ld0Var.A(false);
        ArrayList arrayList = this.b;
        ArrayList arrayList2 = ld0Var.b;
        if (i == i3) {
            ud0 ud0Var = (ud0) arrayList.get(i);
            if (i4 != ud0Var.f + 1 || ud0Var.d() != pa2.CRLF) {
                ld0Var.r(0, 0, ud0Var.subSequence(i2, i4));
            } else if (i2 < i4) {
                ld0Var.r(0, 0, ud0Var.subSequence(i2, ud0Var.f));
                ((ud0) arrayList2.get(0)).A = pa2.CR;
                ld0Var.A++;
                arrayList2.add(new ud0((Object) null));
            }
        } else {
            if (i >= i3) {
                throw new StringIndexOutOfBoundsException("start > end");
            }
            ud0 ud0Var2 = (ud0) arrayList.get(i);
            pa2 pa2VarD = ud0Var2.d();
            pa2 pa2Var = pa2.CRLF;
            int i5 = ud0Var2.f;
            if (pa2VarD != pa2Var) {
                ld0Var.r(0, 0, ud0Var2.subSequence(i2, i5));
                ((ud0) arrayList2.get(0)).A = ud0Var2.d();
                ld0Var.A += ud0Var2.d().f;
            } else if (i2 <= i5) {
                ld0Var.r(0, 0, ud0Var2.subSequence(i2, i5));
                ((ud0) arrayList2.get(0)).A = ud0Var2.d();
                ld0Var.A += ud0Var2.d().f;
            } else {
                if (i2 != i5 + 1) {
                    throw new IndexOutOfBoundsException();
                }
                ud0 ud0Var3 = (ud0) arrayList2.get(0);
                pa2 pa2Var2 = pa2.LF;
                ud0Var3.A = pa2Var2;
                ld0Var.A += pa2Var2.f;
            }
            for (int i6 = i + 1; i6 < i3; i6++) {
                ud0 ud0Var4 = (ud0) arrayList.get(i6);
                arrayList2.add(new ud0(ud0Var4));
                ld0Var.A = ud0Var4.f + ud0Var4.d().f + ld0Var.A;
            }
            ud0 ud0Var5 = (ud0) arrayList.get(i3);
            if (i4 == ud0Var5.f + 1 && ud0Var5.d() == pa2.CRLF) {
                ud0 ud0Var6 = new ud0((Object) null);
                ud0Var6.e(0, 0, i4 - 1, ud0Var5);
                arrayList2.add(ud0Var6);
                ud0Var6.A = pa2.CR;
                ld0Var.A = i4 + 1 + ld0Var.A;
            } else {
                ud0 ud0Var7 = new ud0((Object) null);
                ud0Var7.e(0, 0, i4, ud0Var5);
                arrayList2.add(ud0Var7);
                ld0Var.A += i4;
            }
        }
        ld0Var.A(true);
        return ld0Var;
    }

    public final StringBuilder C(int i, int i2, int i3, int i4, int i5) {
        StringBuilder sb = new StringBuilder(i5);
        ArrayList arrayList = this.b;
        if (i == i3) {
            ud0 ud0Var = (ud0) arrayList.get(i);
            if (i4 != ud0Var.f + 1 || ud0Var.d() != pa2.CRLF) {
                sb.append((CharSequence) arrayList.get(i), i2, i4);
                return sb;
            }
            if (i2 < i4) {
                sb.append((CharSequence) arrayList.get(i), i2, ud0Var.f);
                sb.append(pa2.CR.b);
            }
            return sb;
        }
        if (i >= i3) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        ud0 ud0Var2 = (ud0) arrayList.get(i);
        pa2 pa2VarD = ud0Var2.d();
        pa2 pa2Var = pa2.CRLF;
        int i6 = ud0Var2.f;
        if (pa2VarD != pa2Var || i2 <= i6) {
            sb.append((CharSequence) ud0Var2, i2, i6);
            sb.append(ud0Var2.d().b);
        } else {
            if (i2 != i6 + 1) {
                throw new IndexOutOfBoundsException();
            }
            sb.append(pa2.LF.b);
        }
        while (true) {
            i++;
            if (i >= i3) {
                break;
            }
            ud0 ud0Var3 = (ud0) arrayList.get(i);
            sb.append((CharSequence) ud0Var3);
            sb.append(ud0Var3.d().b);
        }
        ud0 ud0Var4 = (ud0) arrayList.get(i3);
        if (i4 != ud0Var4.f + 1 || ud0Var4.d() != pa2.CRLF) {
            sb.append((CharSequence) ud0Var4, 0, i4);
            return sb;
        }
        sb.append((CharSequence) ud0Var4, 0, i4);
        sb.append(pa2.CR.b);
        return sb;
    }

    public final String D(int i, int i2) throws Throwable {
        ld0 ld0Var;
        q30 q30VarJ;
        q30 q30VarJ2;
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        u(false);
        try {
            q30VarJ = n().j(i);
            q30VarJ2 = n().j(i2);
            ld0Var = this;
        } catch (Throwable th) {
            th = th;
            ld0Var = this;
        }
        try {
            String string = ld0Var.C(q30VarJ.b, q30VarJ.c, q30VarJ2.b, q30VarJ2.c, (i2 - i) + 1).toString();
            ld0Var.F(false);
            return string;
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            ld0Var.F(false);
            throw th3;
        }
    }

    public final StringBuilder E() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.b;
        sb.ensureCapacity(sb.length() + this.A);
        u(false);
        try {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ud0 ud0Var = (ud0) arrayList.get(i);
                sb.append(ud0Var.b, 0, ud0Var.f);
                sb.append(ud0Var.d().b);
            }
            return sb;
        } finally {
            F(false);
        }
    }

    public final void F(boolean z) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.z;
        if (reentrantReadWriteLock == null) {
            return;
        }
        (z ? reentrantReadWriteLock.writeLock() : reentrantReadWriteLock.readLock()).unlock();
    }

    public final void a(vd0 vd0Var) {
        if (vd0Var instanceof su) {
            xe.k("Permission denied");
            return;
        }
        ArrayList arrayList = this.f;
        if (arrayList.contains(vd0Var)) {
            return;
        }
        arrayList.add(vd0Var);
    }

    public final boolean b() {
        int i = this.X + 1;
        this.X = i;
        return i > 0;
    }

    public final char c(int i, int i2) {
        u(false);
        try {
            f(i, i2, 0);
            return ((ud0) this.b.get(i)).charAt(i2);
        } finally {
            F(false);
        }
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        d(i, 0);
        u(false);
        try {
            q30 q30VarJ = n().j(i);
            return ((ud0) this.b.get(q30VarJ.b)).charAt(q30VarJ.c);
        } finally {
            F(false);
        }
    }

    public final void d(int i, int i2) {
        int i3 = this.A;
        if (i2 != 0 ? i <= i3 : i < i3) {
            if (i >= 0) {
                return;
            }
        }
        StringBuilder sbD = dw2.D("Index ", i, " out of bounds. length:");
        sbD.append(this.A);
        throw new StringIndexOutOfBoundsException(sbD.toString());
    }

    public final void e(int i) {
        ArrayList arrayList = this.b;
        if (i >= arrayList.size() || i < 0) {
            StringBuilder sbD = dw2.D("Line ", i, " out of bounds. line count:");
            sbD.append(arrayList.size());
            throw new StringIndexOutOfBoundsException(sbD.toString());
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ld0) {
            ld0 ld0Var = (ld0) obj;
            if (ld0Var.A == this.A) {
                int i = 0;
                loop0: while (true) {
                    ArrayList arrayList = this.b;
                    if (i >= arrayList.size()) {
                        return true;
                    }
                    ud0 ud0Var = (ud0) arrayList.get(i);
                    ud0 ud0Var2 = (ud0) ld0Var.b.get(i);
                    if (ud0Var.f != ud0Var2.f) {
                        break;
                    }
                    if (ud0Var != ud0Var2) {
                        for (int i2 = 0; i2 < ud0Var.f; i2++) {
                            if (ud0Var.charAt(i2) != ud0Var2.charAt(i2)) {
                                break loop0;
                            }
                        }
                    }
                    i++;
                }
            }
        }
        return false;
    }

    public final void f(int i, int i2, int i3) {
        e(i);
        ArrayList arrayList = this.b;
        ud0 ud0Var = (ud0) arrayList.get(i);
        if (i3 == 0) {
            int i4 = ud0Var.f + ud0Var.d().f;
            if (i2 >= i4 || i2 < 0) {
                throw new StringIndexOutOfBoundsException(fw.w(")", fw.A(i2, i, "Column ", " out of bounds for READ. line: ", ", valid range: [0, "), i4));
            }
            return;
        }
        if (i3 == 1) {
            int i5 = ud0Var.f;
            if (i2 > i5 || i2 < 0) {
                throw new StringIndexOutOfBoundsException(fw.w("]", fw.A(i2, i, "Column ", " out of bounds for CURSOR. line: ", ", valid range: [0, "), i5));
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        int i6 = ud0Var.f + ud0Var.d().f;
        if (i == arrayList.size() - 1) {
            if (i2 > i6 || i2 < 0) {
                throw new StringIndexOutOfBoundsException(fw.w("]", fw.A(i2, i, "Column ", " out of bounds for INDEX. line: ", ", valid range: [0, "), i6));
            }
        } else if (i2 >= i6 || i2 < 0) {
            throw new StringIndexOutOfBoundsException(fw.w(")", fw.A(i2, i, "Column ", " out of bounds for INDEX. line: ", ", valid range: [0, "), i6));
        }
    }

    public final void g(int i, int i2) {
        u(true);
        d(i, 1);
        d(i2, 1);
        this.Y.getAndIncrement();
        try {
            q30 q30VarJ = n().j(i);
            q30 q30VarJ2 = n().j(i2);
            if (i != i2) {
                i(q30VarJ.b, q30VarJ.c, q30VarJ2.b, q30VarJ2.c);
            }
        } finally {
            F(true);
        }
    }

    public final void h(int i, int i2, int i3, int i4) {
        u(true);
        this.Y.getAndIncrement();
        try {
            i(i, i2, i3, i4);
        } finally {
            F(true);
        }
    }

    public final int hashCode() {
        return Objects.hash(this.b, Integer.valueOf(this.A));
    }

    public final void i(int i, int i2, int i3, int i4) {
        int i5;
        f(i3, i4, 1);
        f(i, i2, 1);
        if (i == i3 && i2 == i4) {
            return;
        }
        ArrayList arrayList = this.b;
        if (i4 > ((ud0) arrayList.get(i3)).f && (i5 = i3 + 1) < arrayList.size()) {
            i(i, i2, i5, 0);
            return;
        }
        int i6 = ((ud0) arrayList.get(i)).f;
        if (i2 > i6) {
            i(i, i6, i3, i4);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (i == i3) {
            ud0 ud0VarV = v(i);
            int i7 = ud0VarV.f;
            if (i2 < 0 || i4 > i7 || i2 > i4) {
                throw new StringIndexOutOfBoundsException("invalid bounds");
            }
            lg0 lg0Var = this.A0;
            if (lg0Var != null) {
                su suVar = lg0Var.b;
                lg0Var.f = suVar.m(i, i2).a();
                lg0Var.g = suVar.m(i3, i4).a();
            }
            j();
            sb.append((CharSequence) ud0VarV, i2, i4);
            ud0VarV.b(i2, i4);
            this.A -= i4 - i2;
        } else {
            if (i >= i3) {
                xe.k("start line > end line");
                return;
            }
            lg0 lg0Var2 = this.A0;
            if (lg0Var2 != null) {
                su suVar2 = lg0Var2.b;
                lg0Var2.f = suVar2.m(i, i2).a();
                lg0Var2.g = suVar2.m(i3, i4).a();
            }
            j();
            int i8 = i + 1;
            for (int i9 = i8; i9 <= i3 - 1; i9++) {
                ud0 ud0Var = (ud0) arrayList.get(i9);
                pa2 pa2VarD = ((ud0) arrayList.get(i9)).d();
                int i10 = this.A;
                int i11 = ud0Var.f;
                this.A = i10 - (pa2VarD.f + i11);
                sb.append(ud0Var.b, 0, i11);
                sb.append(pa2VarD.b);
            }
            if (i3 > i8) {
                arrayList.subList(i8, i3).clear();
            }
            ud0 ud0VarV2 = v(i);
            ud0 ud0Var2 = (ud0) arrayList.get(i8);
            int i12 = this.A;
            int i13 = ud0VarV2.f;
            this.A = i12 - (i13 - i2);
            sb.insert(0, ud0VarV2, i2, i13).insert(ud0VarV2.f - i2, ud0VarV2.d().b);
            ud0VarV2.b(i2, ud0VarV2.f);
            this.A -= i4;
            sb.append((CharSequence) ud0Var2, 0, i4);
            this.A -= ud0VarV2.d().f;
            arrayList.remove(i8);
            jc4 jc4Var = new jc4(ud0Var2, i4, ud0Var2.f);
            ud0VarV2.e(ud0VarV2.f, 0, jc4Var.length(), jc4Var);
            ud0VarV2.A = ud0Var2.d();
        }
        this.z0.Q(this, i, i2, i3, i4, sb);
        lg0 lg0Var3 = this.A0;
        if (lg0Var3 != null) {
            su suVar3 = lg0Var3.b;
            suVar3.Q(lg0Var3.a, i, i2, i3, i4, sb);
            int i14 = lg0Var3.f.a;
            int i15 = lg0Var3.g.a;
            int i16 = lg0Var3.c.a;
            int i17 = lg0Var3.d.a;
            if (i14 <= i17) {
                int i18 = i15 - i14;
                int iMax = i16 - Math.max(0, Math.min(i16 - i14, i18));
                int iMax2 = i17 - Math.max(0, Math.min(i17 - i14, i18));
                lg0Var3.c = suVar3.j(iMax).a();
                lg0Var3.d = suVar3.j(iMax2).a();
            }
        }
        su suVar4 = this.Z;
        if (suVar4 != null) {
            suVar4.Q(this, i, i2, i3, i4, sb);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((vd0) it.next()).Q(this, i, i2, i3, i4, sb);
        }
    }

    public final void j() {
        this.z0.I(this);
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((vd0) it.next()).I(this);
        }
    }

    public final boolean k() {
        int i = this.X - 1;
        this.X = i;
        if (i == 0) {
            jl4 jl4Var = this.z0;
            jl4Var.y0 = true;
            ArrayList arrayList = jl4Var.b;
            if (!arrayList.isEmpty() && (fw.r(arrayList, 1) instanceof hl4)) {
                hl4 hl4Var = (hl4) fw.r(arrayList, 1);
                if (hl4Var.f.size() == 1) {
                    arrayList.set(arrayList.size() - 1, (dl4) hl4Var.f.get(0));
                }
            }
        }
        int i2 = this.X;
        if (i2 < 0) {
            this.X = 0;
            i2 = 0;
        }
        return i2 > 0;
    }

    public final int l(int i, int i2) {
        u(false);
        try {
            return n().m(i, i2).a;
        } finally {
            F(false);
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.A;
    }

    public final lg0 m() {
        lg0 lg0Var = this.A0;
        if (lg0Var != null) {
            return lg0Var;
        }
        lg0 lg0Var2 = new lg0(this);
        this.A0 = lg0Var2;
        return lg0Var2;
    }

    public final su n() {
        lg0 lg0Var = this.A0;
        return lg0Var != null ? lg0Var.b : this.Z;
    }

    public final ud0 o(int i) {
        u(false);
        try {
            return (ud0) this.b.get(i);
        } finally {
            F(false);
        }
    }

    public final bv0 p(int i) {
        u(false);
        try {
            return this.y0.b(i, (ud0) this.b.get(i));
        } finally {
            F(false);
        }
    }

    public final String q(int i) {
        u(false);
        try {
            e(i);
            return ((ud0) this.b.get(i)).toString();
        } finally {
            F(false);
        }
    }

    public final void r(int i, int i2, CharSequence charSequence) {
        u(true);
        this.Y.getAndIncrement();
        try {
            s(i, i2, charSequence);
        } finally {
            F(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(int r17, int r18, java.lang.CharSequence r19) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ld0.s(int, int, java.lang.CharSequence):void");
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        u(false);
        try {
            q30 q30VarJ = n().j(i);
            q30 q30VarJ2 = n().j(i2);
            return B(q30VarJ.b, q30VarJ.c, q30VarJ2.b, q30VarJ2.c);
        } finally {
            F(false);
        }
    }

    public final boolean t(int i, int i2) {
        bv0 bv0VarP = p(i);
        for (int i3 = 0; i3 < bv0VarP.b.length; i3++) {
            if (i2 >= bv0VarP.m(i3) && i2 < bv0VarP.r(i3)) {
                return bv0VarP.t(i3);
            }
        }
        return false;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return E().toString();
    }

    public final void u(boolean z) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.z;
        if (reentrantReadWriteLock == null) {
            return;
        }
        (z ? reentrantReadWriteLock.writeLock() : reentrantReadWriteLock.readLock()).lock();
    }

    public final ud0 v(int i) {
        ud0 ud0Var = (ud0) this.b.get(i);
        ud0Var.getClass();
        return ud0Var;
    }

    public final void w(int i, int i2, CharSequence charSequence) {
        q30 q30VarJ = n().j(i);
        q30 q30VarJ2 = n().j(i2);
        x(q30VarJ.b, q30VarJ.c, charSequence, q30VarJ2.b, q30VarJ2.c);
    }

    public final void x(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (charSequence == null) {
            xe.k("text can not be null");
            return;
        }
        u(true);
        this.Y.getAndIncrement();
        try {
            su suVar = this.Z;
            this.z0.a(this);
            if (suVar != null) {
                suVar.getClass();
            }
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((vd0) it.next()).a(this);
            }
            i(i, i2, i3, i4);
            s(i, i2, charSequence);
        } finally {
            F(true);
        }
    }

    public final void y(int i, int i2, jd0 jd0Var) {
        u(false);
        try {
            id0 id0Var = new id0();
            id0Var.b = false;
            while (i <= i2) {
                if (id0Var.b) {
                    break;
                }
                jd0Var.b(i, (ud0) this.b.get(i), id0Var);
                i++;
            }
        } finally {
            F(false);
        }
    }

    public final void z(int i, kd0 kd0Var) {
        u(false);
        for (int i2 = 0; i2 <= i; i2++) {
            try {
                ud0 ud0Var = (ud0) this.b.get(i2);
                kd0Var.c(i2, ud0Var, this.y0.b(i2, ud0Var));
            } finally {
                F(false);
            }
        }
    }
}
