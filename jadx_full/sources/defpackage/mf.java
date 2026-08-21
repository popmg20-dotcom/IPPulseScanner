package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mf implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    public /* synthetic */ mf(x65 x65Var, int i, Exception exc, byte[] bArr, Map map) {
        this.z = x65Var;
        this.f = i;
        this.A = exc;
        this.X = bArr;
        this.Y = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.X;
        Object obj2 = this.A;
        Object obj3 = this.z;
        Object obj4 = this.Y;
        switch (i) {
            case 0:
                ((of) obj4).c.execute(new tm1(3, this, je.n(new lf(this)), false));
                return;
            case 1:
                break;
            default:
                x65 x65Var = (x65) obj3;
                ((lb5) x65Var.Y).a(x65Var.A, this.f, (Exception) obj2, (byte[]) obj, (Map) obj4);
                return;
        }
        for (int i2 = 0; i2 < this.f; i2++) {
            View view = (View) ((ArrayList) obj3).get(i2);
            String str = (String) ((ArrayList) obj2).get(i2);
            WeakHashMap weakHashMap = wp4.a;
            view.setTransitionName(str);
            ((View) ((ArrayList) obj).get(i2)).setTransitionName((String) ((ArrayList) obj4).get(i2));
        }
    }

    public mf(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f = i;
        this.z = arrayList;
        this.A = arrayList2;
        this.X = arrayList3;
        this.Y = arrayList4;
    }

    public mf(of ofVar, List list, List list2, int i, Runnable runnable) {
        this.Y = ofVar;
        this.z = list;
        this.A = list2;
        this.f = i;
        this.X = runnable;
    }
}
