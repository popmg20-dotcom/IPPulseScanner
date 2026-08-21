package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tc implements View.OnClickListener {
    public Context A;
    public final View b;
    public final String f;
    public Method z;

    public tc(View view, String str) {
        this.b = view;
        this.f = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        Method method2 = this.z;
        if (method2 == null) {
            View view2 = this.b;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder sbD = fw.D("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    sbD.append(view2.getClass());
                    sbD.append(str);
                    throw new IllegalStateException(sbD.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.z = method;
                        this.A = context;
                        method2 = method;
                        break;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            method2.invoke(this.A, view);
        } catch (IllegalAccessException e) {
            e04.l("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            e04.l("Could not execute method for android:onClick", e2);
        }
    }
}
