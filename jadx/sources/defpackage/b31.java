package defpackage;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.reflection.Consumer2;
import io.sentry.android.core.a1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b31 implements c31 {
    public final ActivityEmbeddingComponent a;
    public final r21 b;
    public final cp1 c;
    public final Context d;
    public final ue2 e = new ue2(9);

    public b31(ActivityEmbeddingComponent activityEmbeddingComponent, r21 r21Var, cp1 cp1Var, Context context) {
        this.a = activityEmbeddingComponent;
        this.b = r21Var;
        this.c = cp1Var;
        this.d = context;
    }

    public static final void d(g91 g91Var, b31 b31Var, List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof SplitInfo) {
                arrayList.add(obj);
            }
        }
        b31Var.b.b(arrayList);
        Iterator it = g91Var.a.c.iterator();
        it.getClass();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
    }

    public final boolean a(Activity activity) {
        return this.a.isActivityEmbedded(activity);
    }

    public final void b(final g91 g91Var) {
        this.a.setSplitInfoCallback(new Consumer2() { // from class: y21
            @Override // androidx.window.reflection.Consumer2
            public final void accept(Object obj) {
                g91 g91Var2 = g91Var;
                b31 b31Var = this;
                List list = (List) obj;
                list.getClass();
                b31Var.b.b(list);
                Iterator it = g91Var2.a.c.iterator();
                it.getClass();
                if (it.hasNext()) {
                    throw dw2.z(it);
                }
            }
        });
    }

    public final void c(g91 g91Var) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int i = this.e.b;
        int i2 = 2;
        if (i != 1) {
            if (2 <= i && i < 5) {
                b(g91Var);
                return;
            } else {
                if (5 > i || i > Integer.MAX_VALUE) {
                    return;
                }
                b(g91Var);
                this.a.registerActivityStackCallback(new qd(1), new b5(g91Var, this.b));
                return;
            }
        }
        ActivityEmbeddingComponent activityEmbeddingComponent = this.a;
        j50 j50VarA = dh3.a(List.class);
        gj gjVar = new gj(i2, g91Var, this);
        Class<?> cls = activityEmbeddingComponent.getClass();
        cp1 cp1Var = this.c;
        Method method = cls.getMethod("setSplitInfoCallback", cp1Var.j0());
        Object objNewProxyInstance = Proxy.newProxyInstance((ClassLoader) cp1Var.f, new Class[]{cp1Var.j0()}, new ed0(j50VarA, gjVar));
        objNewProxyInstance.getClass();
        method.invoke(activityEmbeddingComponent, objNewProxyInstance);
    }

    public final void e(Set set) {
        Context context;
        Iterator it = set.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            context = this.d;
            if (!zHasNext) {
                break;
            }
            if (((d31) it.next()) instanceof v04) {
                if (!n12.c((o04) je.F(context).a.e.getValue(), o04.b)) {
                    if (uf2.f == uo4.f) {
                        a1.n("EmbeddingCompat", "Cannot set SplitRule because ActivityEmbedding Split is not supported or PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED is not set.");
                        return;
                    }
                    return;
                }
            }
        }
        this.a.setEmbeddingRules(this.b.c(context, set));
    }
}
