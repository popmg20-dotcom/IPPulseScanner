package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class nk2 implements Menu {
    public static final int[] z = {1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;
    public final boolean d;
    public lk2 e;
    public final ArrayList f;
    public final ArrayList g;
    public boolean h;
    public final ArrayList i;
    public final ArrayList j;
    public boolean k;
    public CharSequence m;
    public Drawable n;
    public View o;
    public sk2 w;
    public boolean y;
    public int l = 0;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public final ArrayList u = new ArrayList();
    public final CopyOnWriteArrayList v = new CopyOnWriteArrayList();
    public boolean x = false;

    public nk2(Context context) {
        boolean zF;
        boolean z2 = false;
        this.a = context;
        Resources resources = context.getResources();
        this.b = resources;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = xp4.a;
            if (Build.VERSION.SDK_INT >= 28) {
                zF = u9.F(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zF = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zF) {
                z2 = true;
            }
        }
        this.d = z2;
    }

    public sk2 a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 < 0 || i5 >= 6) {
            xe.k("order does not contain a valid category.");
            return null;
        }
        int i6 = (z[i5] << 16) | (65535 & i3);
        sk2 sk2Var = new sk2(this, i, i2, i3, i6, charSequence, this.l);
        ArrayList arrayList = this.f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i4 = 0;
                break;
            }
            if (((sk2) arrayList.get(size)).d <= i6) {
                i4 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i4, sk2Var);
        r(true);
        return sk2Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            sk2 sk2VarA = a(i, i2, i3, resolveInfo.loadLabel(packageManager));
            sk2VarA.setIcon(resolveInfo.loadIcon(packageManager));
            sk2VarA.g = intent2;
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = sk2VarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        sk2 sk2VarA = a(i, i2, i3, charSequence);
        b54 b54Var = new b54(this.a, this, sk2VarA);
        sk2VarA.o = b54Var;
        b54Var.setHeaderTitle(sk2VarA.e);
        return b54Var;
    }

    public final void b(gl2 gl2Var, Context context) {
        this.v.add(new WeakReference(gl2Var));
        gl2Var.l(context, this);
        this.k = true;
    }

    public final void c(boolean z2) {
        if (this.t) {
            return;
        }
        this.t = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            gl2 gl2Var = (gl2) weakReference.get();
            if (gl2Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                gl2Var.a(this, z2);
            }
        }
        this.t = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        sk2 sk2Var = this.w;
        if (sk2Var != null) {
            d(sk2Var);
        }
        this.f.clear();
        r(true);
    }

    public final void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        r(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(sk2 sk2Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        boolean zF = false;
        if (!copyOnWriteArrayList.isEmpty() && this.w == sk2Var) {
            y();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                gl2 gl2Var = (gl2) weakReference.get();
                if (gl2Var != null) {
                    zF = gl2Var.f(sk2Var);
                    if (zF) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            x();
            if (zF) {
                this.w = null;
            }
        }
        return zF;
    }

    public boolean e(nk2 nk2Var, sk2 sk2Var) {
        lk2 lk2Var = this.e;
        return lk2Var != null && lk2Var.V(nk2Var, sk2Var);
    }

    public final void f(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            for (WeakReference weakReference : copyOnWriteArrayList) {
                gl2 gl2Var = (gl2) weakReference.get();
                if (gl2Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = gl2Var.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        gl2Var.h(parcelable);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sk2 sk2Var = (sk2) arrayList.get(i2);
            if (sk2Var.a == i) {
                return sk2Var;
            }
            if (sk2Var.hasSubMenu() && (menuItemFindItem = sk2Var.o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final void g(Bundle bundle) {
        Parcelable parcelableM;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            gl2 gl2Var = (gl2) weakReference.get();
            if (gl2Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = gl2Var.getId();
                if (id > 0 && (parcelableM = gl2Var.m()) != null) {
                    sparseArray.put(id, parcelableM);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f.get(i);
    }

    public boolean h(sk2 sk2Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        boolean zJ = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        y();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            gl2 gl2Var = (gl2) weakReference.get();
            if (gl2Var != null) {
                zJ = gl2Var.j(sk2Var);
                if (zJ) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        x();
        if (zJ) {
            this.w = sk2Var;
        }
        return zJ;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((sk2) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final sk2 i(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.u;
        arrayList.clear();
        j(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (sk2) arrayList.get(0);
        }
        boolean zP = p();
        for (int i2 = 0; i2 < size; i2++) {
            sk2 sk2Var = (sk2) arrayList.get(i2);
            char c = zP ? sk2Var.j : sk2Var.h;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (zP && c == '\b' && i == 67))) {
                return sk2Var;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return i(i, keyEvent) != null;
    }

    public final void j(ArrayList arrayList, int i, KeyEvent keyEvent) {
        boolean zP = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList2 = this.f;
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                sk2 sk2Var = (sk2) arrayList2.get(i2);
                if (sk2Var.hasSubMenu()) {
                    sk2Var.o.j(arrayList, i, keyEvent);
                }
                char c = zP ? sk2Var.j : sk2Var.h;
                if ((modifiers & 69647) == ((zP ? sk2Var.k : sk2Var.i) & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (zP && c == '\b' && i == 67)) && sk2Var.isEnabled()) {
                        arrayList.add(sk2Var);
                    }
                }
            }
        }
    }

    public final void k() {
        ArrayList arrayListN = n();
        if (this.k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
            boolean zE = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                gl2 gl2Var = (gl2) weakReference.get();
                if (gl2Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zE |= gl2Var.e();
                }
            }
            ArrayList arrayList = this.i;
            ArrayList arrayList2 = this.j;
            if (zE) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListN.size();
                for (int i = 0; i < size; i++) {
                    sk2 sk2Var = (sk2) arrayListN.get(i);
                    if ((sk2Var.x & 32) == 32) {
                        arrayList.add(sk2Var);
                    } else {
                        arrayList2.add(sk2Var);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(n());
            }
            this.k = false;
        }
    }

    public String l() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList n() {
        boolean z2 = this.h;
        ArrayList arrayList = this.g;
        if (!z2) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            sk2 sk2Var = (sk2) arrayList2.get(i);
            if (sk2Var.isVisible()) {
                arrayList.add(sk2Var);
            }
        }
        this.h = false;
        this.k = true;
        return arrayList;
    }

    public boolean o() {
        return this.x;
    }

    public boolean p() {
        return this.c;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return s(findItem(i), null, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        sk2 sk2VarI = i(i, keyEvent);
        boolean zS = sk2VarI != null ? s(sk2VarI, null, i2) : false;
        if ((i2 & 2) != 0) {
            c(true);
        }
        return zS;
    }

    public boolean q() {
        return this.d;
    }

    public void r(boolean z2) {
        if (this.p) {
            this.q = true;
            if (z2) {
                this.r = true;
                return;
            }
            return;
        }
        if (z2) {
            this.h = true;
            this.k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        y();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            gl2 gl2Var = (gl2) weakReference.get();
            if (gl2Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                gl2Var.c(z2);
            }
        }
        x();
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((sk2) arrayList.get(i3)).b == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((sk2) arrayList.get(i3)).b != i) {
                    break;
                }
                if (i3 >= 0 && i3 < arrayList.size()) {
                    arrayList.remove(i3);
                }
                i2 = i4;
            }
            r(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((sk2) arrayList.get(i2)).a == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i2);
        r(true);
    }

    public final boolean s(MenuItem menuItem, gl2 gl2Var, int i) {
        sk2 sk2Var = (sk2) menuItem;
        if (sk2Var == null || !sk2Var.isEnabled()) {
            return false;
        }
        boolean zF = sk2Var.f();
        uk2 uk2Var = sk2Var.A;
        boolean z2 = uk2Var != null && uk2Var.b.hasSubMenu();
        if (sk2Var.e()) {
            boolean zExpandActionView = sk2Var.expandActionView() | zF;
            if (zExpandActionView) {
                c(true);
            }
            return zExpandActionView;
        }
        if (!sk2Var.hasSubMenu() && !z2) {
            if ((i & 1) == 0) {
                c(true);
            }
            return zF;
        }
        if ((i & 4) == 0) {
            c(false);
        }
        if (!sk2Var.hasSubMenu()) {
            b54 b54Var = new b54(this.a, this, sk2Var);
            sk2Var.o = b54Var;
            b54Var.setHeaderTitle(sk2Var.e);
        }
        b54 b54Var2 = sk2Var.o;
        if (z2) {
            uk2Var.b.onPrepareSubMenu(b54Var2);
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        if (!copyOnWriteArrayList.isEmpty()) {
            zD = gl2Var != null ? gl2Var.d(b54Var2) : false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                gl2 gl2Var2 = (gl2) weakReference.get();
                if (gl2Var2 == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else if (!zD) {
                    zD = gl2Var2.d(b54Var2);
                }
            }
        }
        boolean z3 = zF | zD;
        if (!z3) {
            c(true);
        }
        return z3;
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z2, boolean z3) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sk2 sk2Var = (sk2) arrayList.get(i2);
            if (sk2Var.b == i) {
                sk2Var.g(z3);
                sk2Var.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.x = z2;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z2) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sk2 sk2Var = (sk2) arrayList.get(i2);
            if (sk2Var.b == i) {
                sk2Var.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z2) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            sk2 sk2Var = (sk2) arrayList.get(i2);
            if (sk2Var.b == i) {
                int i3 = sk2Var.x;
                int i4 = (i3 & (-9)) | (z2 ? 0 : 8);
                sk2Var.x = i4;
                if (i3 != i4) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            r(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.c = z2;
        r(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f.size();
    }

    public final void t(gl2 gl2Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            gl2 gl2Var2 = (gl2) weakReference.get();
            if (gl2Var2 == null || gl2Var2 == gl2Var) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void u(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(l());
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((b54) item.getSubMenu()).u(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public final void v(Bundle bundle) {
        int size = this.f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((b54) item.getSubMenu()).v(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(l(), sparseArray);
        }
    }

    public final void w(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (i > 0) {
                this.m = this.b.getText(i);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i2 > 0) {
                this.n = this.a.getDrawable(i2);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        r(false);
    }

    public final void x() {
        this.p = false;
        if (this.q) {
            this.q = false;
            r(this.r);
        }
    }

    public final void y() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.q = false;
        this.r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.b.getString(i));
    }

    public nk2 m() {
        return this;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.b.getString(i4));
    }
}
