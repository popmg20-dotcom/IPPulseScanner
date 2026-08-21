package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class oo0 implements io0 {
    public final nt4 d;
    public int f;
    public int g;
    public nt4 a = null;
    public boolean b = false;
    public boolean c = false;
    public int e = 1;
    public int h = 1;
    public su0 i = null;
    public boolean j = false;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    public oo0(nt4 nt4Var) {
        this.d = nt4Var;
    }

    @Override // defpackage.io0
    public final void a(io0 io0Var) {
        ArrayList<oo0> arrayList = this.l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((oo0) it.next()).j) {
                return;
            }
        }
        this.c = true;
        nt4 nt4Var = this.a;
        if (nt4Var != null) {
            nt4Var.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        oo0 oo0Var = null;
        int i = 0;
        for (oo0 oo0Var2 : arrayList) {
            if (!(oo0Var2 instanceof su0)) {
                i++;
                oo0Var = oo0Var2;
            }
        }
        if (oo0Var != null && i == 1 && oo0Var.j) {
            su0 su0Var = this.i;
            if (su0Var != null) {
                if (!su0Var.j) {
                    return;
                } else {
                    this.f = this.h * su0Var.g;
                }
            }
            d(oo0Var.g + this.f);
        }
        nt4 nt4Var2 = this.a;
        if (nt4Var2 != null) {
            nt4Var2.a(this);
        }
    }

    public final void b(nt4 nt4Var) {
        this.k.add(nt4Var);
        if (this.j) {
            nt4Var.a(nt4Var);
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (io0 io0Var : this.k) {
            io0Var.a(io0Var);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.g0);
        sb.append(":");
        switch (this.e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
