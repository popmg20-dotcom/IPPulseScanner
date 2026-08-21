package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sh2 extends z0 {
    public final /* synthetic */ int b;
    public final Object f;

    public /* synthetic */ sh2(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.g0
    public final int a() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                return ((uh2) obj).a.groupCount() + 1;
            default:
                return ((ArrayList) obj).size();
        }
    }

    @Override // defpackage.g0, java.util.Collection
    public /* bridge */ boolean contains(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                String strGroup = ((uh2) obj).a.group(i);
                return strGroup == null ? "" : strGroup;
            default:
                return ((ArrayList) obj).get((r1.size() - 1) - i);
        }
    }

    @Override // defpackage.z0, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // defpackage.z0, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }
}
