package j$.time.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {
    public final e[] a;
    public final boolean b;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(List list, boolean z) {
        ArrayList arrayList = (ArrayList) list;
        this((e[]) arrayList.toArray(new e[arrayList.size()]), z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        return true;
     */
    @Override // j$.time.format.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(r rVar, StringBuilder sb) {
        int length = sb.length();
        boolean z = this.b;
        if (z) {
            rVar.c++;
        }
        try {
            for (e eVar : this.a) {
                if (!eVar.h(rVar, sb)) {
                    sb.setLength(length);
                }
            }
        } finally {
            if (z) {
                rVar.c--;
            }
        }
    }

    @Override // j$.time.format.e
    public final int i(p pVar, CharSequence charSequence, int i) {
        boolean z = this.b;
        e[] eVarArr = this.a;
        int i2 = 0;
        if (!z) {
            int length = eVarArr.length;
            while (i2 < length) {
                i = eVarArr[i2].i(pVar, charSequence, i);
                if (i < 0) {
                    return i;
                }
                i2++;
            }
            return i;
        }
        ArrayList arrayList = pVar.d;
        v vVarC = pVar.c();
        vVarC.getClass();
        v vVar = new v();
        ((HashMap) vVar.a).putAll(vVarC.a);
        vVar.b = vVarC.b;
        vVar.c = vVarC.c;
        vVar.d = vVarC.d;
        arrayList.add(vVar);
        int length2 = eVarArr.length;
        int i3 = i;
        while (i2 < length2) {
            i3 = eVarArr[i2].i(pVar, charSequence, i3);
            if (i3 < 0) {
                pVar.d.remove(r6.size() - 1);
                return i;
            }
            i2++;
        }
        pVar.d.remove(r6.size() - 2);
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        e[] eVarArr = this.a;
        if (eVarArr != null) {
            boolean z = this.b;
            sb.append(z ? "[" : "(");
            for (e eVar : eVarArr) {
                sb.append(eVar);
            }
            sb.append(z ? "]" : ")");
        }
        return sb.toString();
    }

    public d(e[] eVarArr, boolean z) {
        this.a = eVarArr;
        this.b = z;
    }
}
