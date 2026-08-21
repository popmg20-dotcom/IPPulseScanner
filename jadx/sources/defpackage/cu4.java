package defpackage;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cu4 extends WindowInsetsAnimation$Callback {
    public final k70 a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public cu4(k70 k70Var) {
        super(0);
        this.d = new HashMap();
        this.a = k70Var;
    }

    public final fu4 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.d;
        fu4 fu4Var = (fu4) map.get(windowInsetsAnimation);
        if (fu4Var != null) {
            return fu4Var;
        }
        fu4 fu4Var2 = new fu4(0, null, 0L);
        fu4Var2.a = new du4(windowInsetsAnimation);
        map.put(windowInsetsAnimation, fu4Var2);
        return fu4Var2;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.a.P0(a(windowInsetsAnimation));
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.a.Q0(a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = DesugarCollections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimation = (WindowInsetsAnimation) list.get(size);
            fu4 fu4VarA = a(windowInsetsAnimation);
            fu4VarA.a.e(windowInsetsAnimation.getFraction());
            this.c.add(fu4VarA);
        }
        return this.a.R0(bv4.g(windowInsets, null), this.b).f();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        e24 e24VarS0 = this.a.S0(a(windowInsetsAnimation), new e24(bounds));
        e24VarS0.getClass();
        i7.c();
        return i7.a(((t02) e24VarS0.f).e(), ((t02) e24VarS0.z).e());
    }
}
