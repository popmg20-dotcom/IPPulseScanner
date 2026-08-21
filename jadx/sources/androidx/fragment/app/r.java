package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.fk1;
import defpackage.ha0;
import defpackage.lk1;
import defpackage.mk1;
import defpackage.pj1;
import defpackage.tj1;
import defpackage.xe;
import defpackage.zc3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r implements LayoutInflater.Factory2 {
    public final u b;

    public r(u uVar) {
        this.b = uVar;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        x xVarG;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        u uVar = this.b;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, uVar);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zc3.a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = o.class.isAssignableFrom(tj1.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    o oVarC = resourceId != -1 ? uVar.C(resourceId) : null;
                    if (oVarC == null && string != null) {
                        oVarC = uVar.D(string);
                    }
                    if (oVarC == null && id != -1) {
                        oVarC = uVar.C(id);
                    }
                    if (oVarC == null) {
                        tj1 tj1VarJ = uVar.J();
                        context.getClassLoader();
                        oVarC = tj1VarJ.a(attributeValue);
                        oVarC.mFromLayout = true;
                        oVarC.mFragmentId = resourceId != 0 ? resourceId : id;
                        oVarC.mContainerId = id;
                        oVarC.mTag = string;
                        oVarC.mInLayout = true;
                        oVarC.mFragmentManager = uVar;
                        pj1 pj1Var = uVar.x;
                        oVarC.mHost = pj1Var;
                        oVarC.onInflate((Context) pj1Var.f, attributeSet, oVarC.mSavedFragmentState);
                        xVarG = uVar.a(oVarC);
                        if (u.M(2)) {
                            Log.v("FragmentManager", "Fragment " + oVarC + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (oVarC.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        oVarC.mInLayout = true;
                        oVarC.mFragmentManager = uVar;
                        pj1 pj1Var2 = uVar.x;
                        oVarC.mHost = pj1Var2;
                        oVarC.onInflate((Context) pj1Var2.f, attributeSet, oVarC.mSavedFragmentState);
                        xVarG = uVar.g(oVarC);
                        if (u.M(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + oVarC + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    lk1 lk1Var = mk1.a;
                    mk1.b(new fk1(oVarC, "Attempting to use <fragment> tag to add fragment " + oVarC + " to container " + viewGroup));
                    mk1.a(oVarC).getClass();
                    oVarC.mContainer = viewGroup;
                    xVarG.k();
                    xVarG.j();
                    View view2 = oVarC.mView;
                    if (view2 == null) {
                        xe.q(ha0.o("Fragment ", attributeValue, " did not create a view."));
                        return null;
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (oVarC.mView.getTag() == null) {
                        oVarC.mView.setTag(string);
                    }
                    oVarC.mView.addOnAttachStateChangeListener(new q(this, xVarG));
                    return oVarC.mView;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
