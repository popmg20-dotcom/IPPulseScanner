package defpackage;

import android.util.SparseArray;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jr2 {
    public final int a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    public jr2(byte[] bArr, Map map) {
        ?? arrayList;
        if (map == null) {
            arrayList = 0;
        } else if (map.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new ir1((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(200, bArr, map, arrayList, false);
    }

    public float a(char c, c03 c03Var) {
        int i;
        float[] fArr = (float[]) this.e;
        if (c == '\t') {
            c = ' ';
            i = this.a;
        } else {
            i = 1;
        }
        float fMeasureText = fArr[c];
        if (fMeasureText == 0.0f) {
            char[] cArr = (char[]) this.d;
            cArr[0] = c;
            fMeasureText = c03Var.measureText(cArr, 0, 1);
            fArr[c] = fMeasureText;
        }
        return fMeasureText * i;
    }

    public float b(CharSequence charSequence, int i, int i2, c03 c03Var) {
        char[] cArr;
        double dCeil;
        float[] fArr = (float[]) this.c;
        long jCeil = 0;
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == 55356 || cCharAt == 55357 || cCharAt == 55358) {
                int i3 = i + 4;
                if (i3 <= i2) {
                    c03Var.getTextWidths(charSequence, i, i3, fArr);
                    if (fArr[0] > 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[3] == 0.0f) {
                        i += 3;
                        dCeil = Math.ceil(r4 * 1000.0f);
                        jCeil += (long) dCeil;
                    }
                }
                int iMin = Math.min(i2, i + 2) - i;
                int i4 = 0;
                while (true) {
                    cArr = (char[]) this.d;
                    if (i4 >= iMin) {
                        break;
                    }
                    cArr[i4] = charSequence.charAt(i + i4);
                    i4++;
                }
                jCeil += (long) Math.ceil(c03Var.measureText(cArr, 0, iMin) * 1000.0f);
                i += iMin - 1;
            } else if (this.b && ek0.s(cCharAt)) {
                String strN = ek0.n(cCharAt);
                for (int i5 = 0; i5 < strN.length(); i5++) {
                    jCeil += (long) Math.ceil(a(strN.charAt(i5), c03Var) * 1000.0f);
                }
            } else {
                dCeil = Math.ceil(a(cCharAt, c03Var) * 1000.0f);
                jCeil += (long) dCeil;
            }
            i++;
        }
        return jCeil / 1000.0f;
    }

    public jr2(int i, byte[] bArr, Map map, List list, boolean z) {
        this.a = i;
        this.c = bArr;
        this.d = map;
        if (list == null) {
            this.e = null;
        } else {
            this.e = DesugarCollections.unmodifiableList(list);
        }
        this.b = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map] */
    public jr2(int i, byte[] bArr, boolean z, List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ir1 ir1Var = (ir1) it.next();
                treeMap.put(ir1Var.a, ir1Var.b);
            }
        }
        this(i, bArr, treeMap, list, z);
    }

    public jr2(int i) {
        this.e = new float[65536];
        this.d = new char[10];
        this.c = new float[10];
        new SparseArray();
        this.a = i;
    }
}
