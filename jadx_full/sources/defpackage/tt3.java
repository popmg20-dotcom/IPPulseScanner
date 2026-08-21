package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.util.ArrayMap;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tt3 {
    public static final List j = Arrays.asList(1, 5, 3);
    public final ArrayList a;
    public final fh b;
    public final List c;
    public final List d;
    public final List e;
    public final rt3 f;
    public final f10 g;
    public final int h;
    public final InputConfiguration i;

    public tt3(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, f10 f10Var, rt3 rt3Var, InputConfiguration inputConfiguration, int i, fh fhVar) {
        this.a = arrayList;
        this.c = DesugarCollections.unmodifiableList(arrayList2);
        this.d = DesugarCollections.unmodifiableList(arrayList3);
        this.e = DesugarCollections.unmodifiableList(arrayList4);
        this.f = rt3Var;
        this.g = f10Var;
        this.i = inputConfiguration;
        this.h = i;
        this.b = fhVar;
    }

    public static tt3 a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = new ArrayList(0);
        ArrayList arrayList4 = new ArrayList(0);
        HashSet hashSet = new HashSet();
        qn2 qn2VarC = qn2.c();
        ArrayList arrayList5 = new ArrayList();
        vn2 vn2VarA = vn2.a();
        ArrayList arrayList6 = new ArrayList(hashSet);
        sw2 sw2VarA = sw2.a(qn2VarC);
        ArrayList arrayList7 = new ArrayList(arrayList5);
        pa4 pa4Var = pa4.b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = vn2VarA.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        return new tt3(arrayList, arrayList2, arrayList3, arrayList4, new f10(arrayList6, sw2VarA, -1, arrayList7, false, new pa4(arrayMap), null), null, null, 0, null);
    }

    public final List b() {
        ArrayList arrayList = new ArrayList();
        for (fh fhVar : this.a) {
            arrayList.add(fhVar.a);
            Iterator it = fhVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add((dn0) it.next());
            }
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }
}
