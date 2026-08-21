package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ok1 {
    public static final tk1 a = new tk1();
    public static final uk1 b;

    static {
        uk1 uk1Var = null;
        try {
            uk1Var = (uk1) zk1.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        b = uk1Var;
    }

    public static final void a(ArrayList arrayList, int i) {
        arrayList.getClass();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }
}
