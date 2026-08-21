package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jw3 implements ot4 {
    public static volatile jw3 c;
    public static final ReentrantLock d = new ReentrantLock();
    public final i91 a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    public jw3(hw3 hw3Var) {
        this.a = hw3Var;
        if (hw3Var != null) {
            hw3Var.d(new wn1(18, this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.ot4
    public final void a(Context context, qd qdVar, e74 e74Var) {
        Object next;
        WindowManager.LayoutParams attributes;
        iBinder = null;
        IBinder iBinder = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        g41 g41Var = g41.b;
        if (activity == null) {
            e74Var.accept(new iv4(g41Var));
            return;
        }
        ReentrantLock reentrantLock = d;
        reentrantLock.lock();
        try {
            i91 i91Var = this.a;
            if (i91Var == null) {
                e74Var.accept(new iv4(g41Var));
                return;
            }
            boolean z = true;
            CopyOnWriteArrayList copyOnWriteArrayList = this.b;
            if ((copyOnWriteArrayList != null) == true && copyOnWriteArrayList.isEmpty()) {
                z = false;
            } else {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    if (((iw3) it.next()).a.equals(activity)) {
                        break;
                    }
                }
                z = false;
            }
            iw3 iw3Var = new iw3(activity, qdVar, e74Var);
            copyOnWriteArrayList.add(iw3Var);
            if (z) {
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it2.next();
                        if (activity.equals(((iw3) next).a)) {
                            break;
                        }
                    }
                }
                iw3 iw3Var2 = (iw3) next;
                iv4 iv4Var = iw3Var2 != null ? iw3Var2.c : null;
                if (iv4Var != null) {
                    iw3Var.c = iv4Var;
                    iw3Var.b.accept(iv4Var);
                }
            } else {
                hw3 hw3Var = (hw3) i91Var;
                Window window = activity.getWindow();
                if (window != null && (attributes = window.getAttributes()) != null) {
                    iBinder = attributes.token;
                }
                if (iBinder != null) {
                    hw3Var.c(iBinder, activity);
                } else {
                    activity.getWindow().getDecorView().addOnAttachStateChangeListener(new gw3(hw3Var, activity));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.ot4
    public final void b(e74 e74Var) {
        synchronized (d) {
            try {
                if (this.a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = this.b.iterator();
                it.getClass();
                while (it.hasNext()) {
                    iw3 iw3Var = (iw3) it.next();
                    if (iw3Var.b == e74Var) {
                        arrayList.add(iw3Var);
                    }
                }
                this.b.removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Activity activity = ((iw3) it2.next()).a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.b;
                    if (!(copyOnWriteArrayList != null) || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it3 = copyOnWriteArrayList.iterator();
                        while (it3.hasNext()) {
                            if (((iw3) it3.next()).a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    i91 i91Var = this.a;
                    if (i91Var != null) {
                        ((hw3) i91Var).b(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
