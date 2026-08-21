package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class di3 extends hz1 {
    public final transient gz1 Y;
    public final transient Object[] Z;
    public final transient int y0;

    public di3(gz1 gz1Var, Object[] objArr, int i) {
        super(0);
        this.Y = gz1Var;
        this.Z = objArr;
        this.y0 = i;
    }

    @Override // defpackage.bz1
    public final int a(Object[] objArr) {
        return i().a(objArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.Y.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.hz1
    public final ez1 l() {
        return new ci3(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final hm4 iterator() {
        return i().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.y0;
    }
}
