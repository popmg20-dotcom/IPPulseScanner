package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class zk1 extends uk1 {
    @Override // defpackage.uk1
    public final void a(View view, Object obj) {
        ((vg4) obj).b(view);
    }

    @Override // defpackage.uk1
    public final void b(Object obj, ArrayList arrayList) {
        vg4 vg4Var = (vg4) obj;
        if (vg4Var == null) {
            return;
        }
        int i = 0;
        if (vg4Var instanceof ch4) {
            ch4 ch4Var = (ch4) vg4Var;
            int size = ch4Var.X0.size();
            while (i < size) {
                b(ch4Var.V(i), arrayList);
                i++;
            }
            return;
        }
        if (uk1.k(vg4Var.X) && uk1.k(vg4Var.Y)) {
            int size2 = arrayList.size();
            while (i < size2) {
                vg4Var.b((View) arrayList.get(i));
                i++;
            }
        }
    }

    @Override // defpackage.uk1
    public final void c(Object obj) {
        sg4 sg4Var = (sg4) obj;
        sg4Var.h();
        sg4Var.d.a(sg4Var.g.Q0 + 1);
    }

    @Override // defpackage.uk1
    public final void d(Object obj, s7 s7Var) {
        sg4 sg4Var = (sg4) obj;
        sg4Var.f = s7Var;
        sg4Var.h();
        sg4Var.d.a(0.0f);
    }

    @Override // defpackage.uk1
    public final void e(ViewGroup viewGroup, Object obj) {
        ah4.a(viewGroup, (vg4) obj);
    }

    @Override // defpackage.uk1
    public final boolean g(Object obj) {
        return obj instanceof vg4;
    }

    @Override // defpackage.uk1
    public final Object h(Object obj) {
        if (obj != null) {
            return ((vg4) obj).clone();
        }
        return null;
    }

    @Override // defpackage.uk1
    public final Object i(ViewGroup viewGroup, Object obj) {
        vg4 vg4Var = (vg4) obj;
        ArrayList arrayList = ah4.c;
        if (!arrayList.contains(viewGroup) && viewGroup.isLaidOut() && Build.VERSION.SDK_INT >= 34) {
            if (vg4Var.x()) {
                arrayList.add(viewGroup);
                vg4 vg4VarClone = vg4Var.clone();
                ch4 ch4Var = new ch4();
                ch4Var.U(vg4VarClone);
                ah4.c(viewGroup, ch4Var);
                viewGroup.setTag(R.id.transition_current_scene, null);
                zg4 zg4Var = new zg4();
                zg4Var.b = ch4Var;
                zg4Var.f = viewGroup;
                viewGroup.addOnAttachStateChangeListener(zg4Var);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(zg4Var);
                viewGroup.invalidate();
                sg4 sg4Var = new sg4(ch4Var);
                ch4Var.R0 = sg4Var;
                ch4Var.a(sg4Var);
                return ch4Var.R0;
            }
            xe.k("The Transition must support seeking.");
        }
        return null;
    }

    @Override // defpackage.uk1
    public final boolean l() {
        return true;
    }

    @Override // defpackage.uk1
    public final boolean m(Object obj) {
        boolean zX = ((vg4) obj).x();
        if (!zX) {
            Log.v("FragmentManager", "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return zX;
    }

    @Override // defpackage.uk1
    public final Object n(Object obj, Object obj2, Object obj3) {
        vg4 vg4Var = (vg4) obj;
        vg4 vg4Var2 = (vg4) obj2;
        vg4 vg4Var3 = (vg4) obj3;
        if (vg4Var != null && vg4Var2 != null) {
            ch4 ch4Var = new ch4();
            ch4Var.U(vg4Var);
            ch4Var.U(vg4Var2);
            ch4Var.Y(1);
            vg4Var = ch4Var;
        } else if (vg4Var == null) {
            vg4Var = vg4Var2 != null ? vg4Var2 : null;
        }
        if (vg4Var3 == null) {
            return vg4Var;
        }
        ch4 ch4Var2 = new ch4();
        if (vg4Var != null) {
            ch4Var2.U(vg4Var);
        }
        ch4Var2.U(vg4Var3);
        return ch4Var2;
    }

    @Override // defpackage.uk1
    public final Object o(Object obj, Object obj2) {
        ch4 ch4Var = new ch4();
        if (obj != null) {
            ch4Var.U((vg4) obj);
        }
        ch4Var.U((vg4) obj2);
        return ch4Var;
    }

    @Override // defpackage.uk1
    public final void p(Object obj, View view, ArrayList arrayList) {
        ((vg4) obj).a(new wk1(view, arrayList));
    }

    @Override // defpackage.uk1
    public final void q(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((vg4) obj).a(new xk1(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // defpackage.uk1
    public final void r(Object obj, float f) {
        sg4 sg4Var = (sg4) obj;
        boolean z = sg4Var.b;
        if (z) {
            ch4 ch4Var = sg4Var.g;
            long j = ch4Var.Q0;
            long j2 = (long) (f * j);
            if (j2 == 0) {
                j2 = 1;
            }
            if (j2 == j) {
                j2 = j - 1;
            }
            if (sg4Var.d != null) {
                xe.q("setCurrentPlayTimeMillis() called after animation has been started");
                return;
            }
            long j3 = sg4Var.a;
            if (j2 == j3 || !z) {
                return;
            }
            if (!sg4Var.c) {
                if (j2 == 0 && j3 > 0) {
                    j2 = -1;
                } else if (j2 == j && j3 < j) {
                    j2 = j + 1;
                }
                if (j2 != j3) {
                    ch4Var.K(j2, j3);
                    sg4Var.a = j2;
                }
            }
            qt qtVar = sg4Var.e;
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i = (qtVar.b + 1) % 20;
            qtVar.b = i;
            ((long[]) qtVar.c)[i] = jCurrentAnimationTimeMillis;
            ((float[]) qtVar.d)[i] = j2;
        }
    }

    @Override // defpackage.uk1
    public final void s(View view, Object obj) {
        if (view != null) {
            uk1.j(view, new Rect());
            ((vg4) obj).N(new vk1());
        }
    }

    @Override // defpackage.uk1
    public final void t(Object obj, Rect rect) {
        ((vg4) obj).N(new vk1());
    }

    @Override // defpackage.uk1
    public final void u(o oVar, Object obj, b10 b10Var, Runnable runnable) {
        v(obj, b10Var, null, runnable);
    }

    @Override // defpackage.uk1
    public final void v(Object obj, b10 b10Var, d4 d4Var, Runnable runnable) {
        vg4 vg4Var = (vg4) obj;
        m10 m10Var = new m10(3, d4Var, vg4Var, runnable);
        synchronized (b10Var) {
            while (b10Var.b) {
                try {
                    try {
                        b10Var.wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (((m10) b10Var.c) != m10Var) {
                b10Var.c = m10Var;
                if (b10Var.a) {
                    Runnable runnable2 = (Runnable) m10Var.f;
                    vg4 vg4Var2 = (vg4) m10Var.z;
                    Runnable runnable3 = (Runnable) m10Var.A;
                    if (runnable2 == null) {
                        vg4Var2.d();
                        runnable3.run();
                    } else {
                        runnable2.run();
                    }
                }
            }
        }
        vg4Var.a(new yk1(runnable));
    }

    @Override // defpackage.uk1
    public final void w(Object obj, View view, ArrayList arrayList) {
        ch4 ch4Var = (ch4) obj;
        ArrayList arrayList2 = ch4Var.Y;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            uk1.f(arrayList2, (View) arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(ch4Var, arrayList);
    }

    @Override // defpackage.uk1
    public final void x(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        ch4 ch4Var = (ch4) obj;
        if (ch4Var != null) {
            ArrayList arrayList3 = ch4Var.Y;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            z(ch4Var, arrayList, arrayList2);
        }
    }

    @Override // defpackage.uk1
    public final Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        ch4 ch4Var = new ch4();
        ch4Var.U((vg4) obj);
        return ch4Var;
    }

    public final void z(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        vg4 vg4Var = (vg4) obj;
        int i = 0;
        if (vg4Var instanceof ch4) {
            ch4 ch4Var = (ch4) vg4Var;
            int size = ch4Var.X0.size();
            while (i < size) {
                z(ch4Var.V(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (uk1.k(vg4Var.X)) {
            ArrayList arrayList3 = vg4Var.Y;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size2) {
                    vg4Var.b((View) arrayList2.get(i));
                    i++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    vg4Var.G((View) arrayList.get(size3));
                }
            }
        }
    }
}
