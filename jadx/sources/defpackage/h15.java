package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h15 implements Iterable, d25, v15 {
    public final TreeMap b;
    public final TreeMap f;

    public h15(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                o(i, (d25) list.get(i));
            }
        }
    }

    @Override // defpackage.v15
    public final d25 a(String str) {
        d25 d25Var;
        return "length".equals(str) ? new p15(Double.valueOf(l())) : (!c(str) || (d25Var = (d25) this.f.get(str)) == null) ? d25.q0 : d25Var;
    }

    @Override // defpackage.v15
    public final void b(String str, d25 d25Var) {
        TreeMap treeMap = this.f;
        if (d25Var == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, d25Var);
        }
    }

    @Override // defpackage.v15
    public final boolean c(String str) {
        return "length".equals(str) || this.f.containsKey(str);
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new c15(this, this.b.keySet().iterator(), this.f.keySet().iterator());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h15)) {
            return false;
        }
        h15 h15Var = (h15) obj;
        if (l() != h15Var.l()) {
            return false;
        }
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return h15Var.b.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!m(iIntValue).equals(h15Var.m(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02dc, code lost:
    
        if (defpackage.ez4.f0(r7, r2, (defpackage.b25) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).l() == r7.l()) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    @Override // defpackage.d25
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.d25 f(java.lang.String r37, defpackage.ih4 r38, java.util.ArrayList r39) {
        /*
            Method dump skipped, instruction units count: 2160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h15.f(java.lang.String, ih4, java.util.ArrayList):d25");
    }

    @Override // defpackage.d25
    public final Double g() {
        TreeMap treeMap = this.b;
        return treeMap.size() == 1 ? m(0).g() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // defpackage.d25
    public final String h() {
        return r(",");
    }

    public final int hashCode() {
        return this.b.hashCode() * 31;
    }

    @Override // defpackage.d25
    public final d25 i() {
        h15 h15Var = new h15();
        for (Map.Entry entry : this.b.entrySet()) {
            boolean z = entry.getValue() instanceof v15;
            TreeMap treeMap = h15Var.b;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (d25) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((d25) entry.getValue()).i());
            }
        }
        return h15Var;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new wd4(this);
    }

    public final List j() {
        ArrayList arrayList = new ArrayList(l());
        for (int i = 0; i < l(); i++) {
            arrayList.add(m(i));
        }
        return arrayList;
    }

    public final Iterator k() {
        return this.b.keySet().iterator();
    }

    public final int l() {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final d25 m(int i) {
        d25 d25Var;
        if (i < l()) {
            return (!p(i) || (d25Var = (d25) this.b.get(Integer.valueOf(i))) == null) ? d25.q0 : d25Var;
        }
        s53.k("Attempting to get element outside of current array");
        return null;
    }

    public final void o(int i, d25 d25Var) {
        if (i > 32468) {
            xe.q("Array too large");
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        TreeMap treeMap = this.b;
        if (d25Var == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), d25Var);
        }
    }

    public final boolean p(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.b;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void q(int i) {
        TreeMap treeMap = this.b;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf(i2);
            if (treeMap.containsKey(numValueOf) || i2 < 0) {
                return;
            }
            treeMap.put(numValueOf, d25.q0);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i);
            d25 d25Var = (d25) treeMap.get(numValueOf2);
            if (d25Var != null) {
                treeMap.put(Integer.valueOf(i - 1), d25Var);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final String r(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.b.isEmpty()) {
            int i = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i >= l()) {
                    break;
                }
                d25 d25VarM = m(i);
                sb.append(str2);
                if (!(d25VarM instanceof j25) && !(d25VarM instanceof a25)) {
                    sb.append(d25VarM.h());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return r(",");
    }

    public h15() {
        this.b = new TreeMap();
        this.f = new TreeMap();
    }
}
