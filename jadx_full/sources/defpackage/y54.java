package defpackage;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y54 implements MenuItem.OnMenuItemClickListener {
    public static final Class[] A = {MenuItem.class};
    public final /* synthetic */ int b = 0;
    public Object f;
    public Object z;

    public y54(xk2 xk2Var, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.z = xk2Var;
        this.f = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.b) {
            case 0:
                Object obj = this.f;
                Method method = (Method) this.z;
                boolean zBooleanValue = false;
                try {
                    if (method.getReturnType() == Boolean.TYPE) {
                        zBooleanValue = ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                    } else {
                        method.invoke(obj, menuItem);
                        zBooleanValue = true;
                    }
                    break;
                } catch (Exception e) {
                    vp1.p(e);
                }
                return zBooleanValue;
            default:
                return ((MenuItem.OnMenuItemClickListener) this.f).onMenuItemClick(((xk2) this.z).l(menuItem));
        }
    }

    public /* synthetic */ y54() {
    }
}
