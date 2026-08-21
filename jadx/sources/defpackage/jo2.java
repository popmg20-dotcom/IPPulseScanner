package defpackage;

import j$.util.Collection;
import j$.util.function.Predicate$CC;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jo2 implements ko2 {
    public final boolean a(Object obj, ArrayList arrayList) {
        final List list = (List) obj;
        if (list.size() < arrayList.size()) {
            return false;
        }
        final int[] iArr = {0};
        return Collection.EL.stream(arrayList).allMatch(new Predicate(this) { // from class: io2
            public /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate$CC.$default$and(this, predicate);
            }

            public /* synthetic */ Predicate negate() {
                return Predicate$CC.$default$negate(this);
            }

            public /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate$CC.$default$or(this, predicate);
            }

            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                int length;
                String str = (String) obj2;
                int[] iArr2 = iArr;
                int i = iArr2[0];
                while (true) {
                    List list2 = list;
                    if (i >= list2.size()) {
                        return false;
                    }
                    String str2 = (String) list2.get(i);
                    if (str2 != null && (str2.equals(str) || (str2.length() > (length = str.length()) && str2.substring(0, length).equals(str) && str2.charAt(length) == '.'))) {
                        break;
                    }
                    i++;
                }
                iArr2[0] = iArr2[0] + 1;
                return true;
            }
        });
    }
}
