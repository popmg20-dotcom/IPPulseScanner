package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cf4 {
    public final int a;
    public final String b;
    public final List c;
    public final List d;

    public cf4(int i, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        this.a = i;
        this.b = str;
        this.c = DesugarCollections.unmodifiableList(arrayList);
        DesugarCollections.unmodifiableList(arrayList2);
        DesugarCollections.unmodifiableList(arrayList3);
        this.d = DesugarCollections.unmodifiableList(arrayList4);
        DesugarCollections.unmodifiableList(arrayList5);
    }
}
