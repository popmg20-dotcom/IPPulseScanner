package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.getsurfboard.R;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class wp4 {
    public static WeakHashMap a = null;
    public static Field b = null;
    public static boolean c = false;
    public static final int[] d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final hp4 e = new hp4();
    public static final jp4 f = new jp4();

    public static cr4 a(View view) {
        WeakHashMap weakHashMap = a;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            a = weakHashMap;
        }
        cr4 cr4Var = (cr4) weakHashMap.get(view);
        if (cr4Var != null) {
            return cr4Var;
        }
        cr4 cr4Var2 = new cr4(view);
        a.put(view, cr4Var2);
        return cr4Var2;
    }

    public static void b(View view, bv4 bv4Var) {
        WindowInsets windowInsetsF = bv4Var.f();
        if (windowInsetsF != null) {
            WindowInsets windowInsetsA = Build.VERSION.SDK_INT >= 30 ? sp4.a(view, windowInsetsF) : kp4.a(view, windowInsetsF);
            if (windowInsetsA.equals(windowInsetsF)) {
                return;
            }
            bv4.g(windowInsetsA, view);
        }
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = vp4.d;
        vp4 vp4Var = (vp4) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (vp4Var == null) {
            vp4Var = new vp4();
            vp4Var.a = null;
            vp4Var.b = null;
            vp4Var.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, vp4Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = vp4Var.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = vp4.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (vp4Var.a == null) {
                            vp4Var.a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = vp4.d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                vp4Var.a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    vp4Var.a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View viewA = vp4Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                SparseArray sparseArray = vp4Var.b;
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    vp4Var.b = sparseArray;
                }
                sparseArray.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = vp4.d;
        vp4 vp4Var = (vp4) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (vp4Var == null) {
            vp4Var = new vp4();
            vp4Var.a = null;
            vp4Var.b = null;
            vp4Var.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, vp4Var);
        }
        WeakReference weakReference2 = vp4Var.c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        vp4Var.c = new WeakReference(keyEvent);
        SparseArray sparseArray = vp4Var.b;
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            vp4Var.b = sparseArray;
        }
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        throw qe4.r(arrayList, size);
    }

    public static View.AccessibilityDelegate e(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return rp4.a(view);
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence f(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = qp4.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList g(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] h(fb fbVar) {
        return Build.VERSION.SDK_INT >= 31 ? tp4.a(fbVar) : (String[]) fbVar.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void i(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = f(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    accessibilityEventObtain.getText().add(f(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e2) {
                        a1.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(f(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static td0 j(View view, td0 td0Var) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + td0Var + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return tp4.b(view, td0Var);
        }
        hv2 hv2Var = (hv2) view.getTag(R.id.tag_on_receive_content_listener);
        iv2 iv2Var = e;
        if (hv2Var == null) {
            if (view instanceof iv2) {
                iv2Var = (iv2) view;
            }
            return iv2Var.a(td0Var);
        }
        td0 td0VarD = hv2Var.d(view, td0Var);
        if (td0VarD == null) {
            return null;
        }
        if (view instanceof iv2) {
            iv2Var = (iv2) view;
        }
        return iv2Var.a(td0VarD);
    }

    public static void k(View view, int i) {
        ArrayList arrayListG = g(view);
        for (int i2 = 0; i2 < arrayListG.size(); i2++) {
            if (((i2) arrayListG.get(i2)).a() == i) {
                arrayListG.remove(i2);
                return;
            }
        }
    }

    public static void l(View view, i2 i2Var, String str, z2 z2Var) {
        i2 i2Var2 = new i2(null, i2Var.b, str, z2Var, i2Var.c);
        View.AccessibilityDelegate accessibilityDelegateE = e(view);
        h2 h2Var = accessibilityDelegateE == null ? null : accessibilityDelegateE instanceof g2 ? ((g2) accessibilityDelegateE).a : new h2(accessibilityDelegateE);
        if (h2Var == null) {
            h2Var = new h2();
        }
        n(view, h2Var);
        k(view, i2Var2.a());
        g(view).add(i2Var2);
        i(view, 0);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            rp4.b(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void n(View view, h2 h2Var) {
        if (h2Var == null && (e(view) instanceof g2)) {
            h2Var = new h2();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(h2Var == null ? null : h2Var.b);
    }

    public static void o(View view, CharSequence charSequence) {
        new ip4(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        jp4 jp4Var = f;
        if (charSequence == null) {
            jp4Var.b.remove(view);
            view.removeOnAttachStateChangeListener(jp4Var);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(jp4Var);
        } else {
            jp4Var.b.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(jp4Var);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(jp4Var);
            }
        }
    }

    public static void p(ga4 ga4Var, oj1 oj1Var) {
        if (Build.VERSION.SDK_INT >= 24) {
            op4.a(ga4Var, (PointerIcon) oj1Var.f);
        }
    }
}
