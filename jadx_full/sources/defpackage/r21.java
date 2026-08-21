package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.util.Pair;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.EmbeddingRule;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.reflection.Predicate2;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r21 {
    public static final String e = dh3.a(r21.class).c();
    public static final String f = "ae-gen:";
    public final s23 a;
    public final o21 b;
    public final p21 c = new p21(this);
    public final q21 d = new q21(this);

    static {
        new Binder();
    }

    public r21(s23 s23Var) {
        this.a = s23Var;
        this.b = new o21(this, s23Var);
    }

    public static n04 e(SplitAttributes splitAttributes) {
        m04 m04VarH;
        k04 k04Var;
        m04 m04Var = m04.c;
        t21 t21Var = u21.a;
        v21 v21Var = v21.b;
        w21 w21Var = new w21(t21Var, v21Var, v21Var, v21Var);
        SplitAttributes.SplitType.RatioSplitType splitType = splitAttributes.getSplitType();
        splitType.getClass();
        if (splitType instanceof SplitAttributes.SplitType.HingeSplitType) {
            m04VarH = m04.e;
        } else if (splitType instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            m04VarH = m04.c;
        } else {
            if (!(splitType instanceof SplitAttributes.SplitType.RatioSplitType)) {
                vp1.h(splitType, "Unknown split type: ");
                return null;
            }
            m04VarH = xb5.H(splitType.getRatio());
        }
        m04VarH.getClass();
        int layoutDirection = splitAttributes.getLayoutDirection();
        if (layoutDirection == 0) {
            k04Var = k04.d;
        } else if (layoutDirection == 1) {
            k04Var = k04.e;
        } else if (layoutDirection == 3) {
            k04Var = k04.c;
        } else if (layoutDirection == 4) {
            k04Var = k04.f;
        } else {
            if (layoutDirection != 5) {
                xe.k(dw2.A(layoutDirection, "Unknown layout direction: "));
                return null;
            }
            k04Var = k04.g;
        }
        int iA = y91.a();
        if (5 <= iA && iA < 7) {
            AnimationBackground animationBackground = splitAttributes.getAnimationBackground();
            animationBackground.getClass();
            w21Var = new w21(m(animationBackground), v21Var, v21Var, v21Var);
        }
        if (y91.a() >= 7) {
            AnimationBackground animationBackground2 = splitAttributes.getAnimationParams().getAnimationBackground();
            animationBackground2.getClass();
            w21Var = new w21(m(animationBackground2), n(splitAttributes.getAnimationParams().getOpenAnimationResId()), n(splitAttributes.getAnimationParams().getCloseAnimationResId()), n(splitAttributes.getAnimationParams().getChangeAnimationResId()));
        }
        return new n04(m04VarH, k04Var, w21Var, y91.a() >= 6 ? o(splitAttributes.getDividerAttributes()) : kw0.c);
    }

    public static int h(u04 u04Var) {
        if (u04Var == u04.d) {
            return 0;
        }
        if (u04Var == u04.e) {
            return 1;
        }
        if (u04Var == u04.f) {
            return 2;
        }
        vp1.h(u04Var, "Unknown finish behavior:");
        return 0;
    }

    public static SplitAttributes i(n04 n04Var) {
        int i;
        w21 w21Var = n04Var.c;
        if (y91.a() < 2) {
            xe.k("Failed requirement.");
            return null;
        }
        SplitAttributes.Builder splitType = new SplitAttributes.Builder().setSplitType(l(n04Var.a));
        k04 k04Var = n04Var.b;
        if (n12.c(k04Var, k04.c)) {
            i = 3;
        } else if (n12.c(k04Var, k04.d)) {
            i = 0;
        } else if (n12.c(k04Var, k04.e)) {
            i = 1;
        } else if (n12.c(k04Var, k04.f)) {
            i = 4;
        } else {
            if (!n12.c(k04Var, k04.g)) {
                st4.p("Unsupported layoutDirection:", n04Var, ".layoutDirection");
                return null;
            }
            i = 5;
        }
        SplitAttributes.Builder layoutDirection = splitType.setLayoutDirection(i);
        layoutDirection.getClass();
        if (y91.a() >= 5) {
            layoutDirection.setWindowAttributes(s());
        }
        int iA = y91.a();
        if (5 <= iA && iA < 7) {
            layoutDirection.setAnimationBackground(p(w21Var.a));
        }
        if (y91.a() >= 7) {
            AnimationParams animationParamsBuild = new AnimationParams.Builder().setAnimationBackground(p(w21Var.a)).setOpenAnimationResId(q(w21Var.b)).setCloseAnimationResId(q(w21Var.c)).setChangeAnimationResId(q(w21Var.d)).build();
            animationParamsBuild.getClass();
            layoutDirection.setAnimationParams(animationParamsBuild);
        }
        if (y91.a() >= 6) {
            layoutDirection.setDividerAttributes(r(n04Var.d));
        }
        SplitAttributes splitAttributesBuild = layoutDirection.build();
        splitAttributesBuild.getClass();
        return splitAttributesBuild;
    }

    public static SplitAttributes.SplitType l(m04 m04Var) {
        if (y91.a() < 2) {
            xe.k("Failed requirement.");
            return null;
        }
        if (n12.c(m04Var, m04.e)) {
            return new SplitAttributes.SplitType.HingeSplitType(l(m04.d));
        }
        if (n12.c(m04Var, m04.c)) {
            return new SplitAttributes.SplitType.ExpandContainersSplitType();
        }
        float f2 = m04Var.b;
        double d = f2;
        if (d > 0.0d && d < 1.0d) {
            return new SplitAttributes.SplitType.RatioSplitType(f2);
        }
        StringBuilder sb = new StringBuilder("Unsupported SplitType: ");
        sb.append(m04Var);
        float f3 = m04Var.b;
        sb.append(" with value: ");
        sb.append(f3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static u21 m(AnimationBackground animationBackground) {
        int iA = y91.a();
        if (iA >= 5) {
            return animationBackground instanceof AnimationBackground.ColorBackground ? new s21(((AnimationBackground.ColorBackground) animationBackground).getColor()) : u21.a;
        }
        vp1.n(fw.s(5, iA, "This API requires extension version ", ", but the device is on "));
        return null;
    }

    public static v21 n(int i) {
        int iA = y91.a();
        if (iA >= 7) {
            return i == 0 ? v21.c : v21.b;
        }
        vp1.n(fw.s(7, iA, "This API requires extension version ", ", but the device is on "));
        return null;
    }

    public static kw0 o(DividerAttributes dividerAttributes) {
        int iA = y91.a();
        if (iA < 6) {
            vp1.n(fw.s(6, iA, "This API requires extension version ", ", but the device is on "));
            return null;
        }
        if (dividerAttributes == null) {
            return kw0.c;
        }
        int dividerType = dividerAttributes.getDividerType();
        if (dividerType == 1) {
            int widthDp = dividerAttributes.getWidthDp();
            if (widthDp != -1 && widthDp < 0) {
                e04.f(dw2.A(widthDp, "widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: "));
                return null;
            }
            int dividerColor = dividerAttributes.getDividerColor();
            if ((dividerColor >>> 24) == 255) {
                return new jw0(widthDp, dividerColor);
            }
            st4.o(Integer.toHexString(dividerColor), "Divider color must be opaque. Got: ");
            return null;
        }
        if (dividerType == 2) {
            int widthDp2 = dividerAttributes.getWidthDp();
            if (widthDp2 != -1 && widthDp2 < 0) {
                e04.f(dw2.A(widthDp2, "widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: "));
                return null;
            }
            int dividerColor2 = dividerAttributes.getDividerColor();
            if ((dividerColor2 >>> 24) == 255) {
                return new iw0(widthDp2, dividerColor2, (dividerAttributes.getPrimaryMinRatio() == -1.0f && dividerAttributes.getPrimaryMaxRatio() == -1.0f) ? hw0.a : new gw0(dividerAttributes.getPrimaryMinRatio(), dividerAttributes.getPrimaryMaxRatio()), y91.a() >= 7 && dividerAttributes.isDraggingToFullscreenAllowed());
            }
            st4.o(Integer.toHexString(dividerColor2), "Divider color must be opaque. Got: ");
            return null;
        }
        a1.n(e, "Unknown divider type " + dividerAttributes + ".dividerType, default to fixed divider type");
        int widthDp3 = dividerAttributes.getWidthDp();
        if (widthDp3 != -1 && widthDp3 < 0) {
            e04.f(dw2.A(widthDp3, "widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: "));
            return null;
        }
        int dividerColor3 = dividerAttributes.getDividerColor();
        if ((dividerColor3 >>> 24) == 255) {
            return new jw0(widthDp3, dividerColor3);
        }
        st4.o(Integer.toHexString(dividerColor3), "Divider color must be opaque. Got: ");
        return null;
    }

    public static AnimationBackground p(u21 u21Var) {
        int iA = y91.a();
        if (iA < 5) {
            vp1.n(fw.s(5, iA, "This API requires extension version ", ", but the device is on "));
            return null;
        }
        if (u21Var instanceof s21) {
            AnimationBackground animationBackgroundCreateColorBackground = AnimationBackground.createColorBackground(((s21) u21Var).b);
            animationBackgroundCreateColorBackground.getClass();
            return animationBackgroundCreateColorBackground;
        }
        AnimationBackground animationBackground = AnimationBackground.ANIMATION_BACKGROUND_DEFAULT;
        animationBackground.getClass();
        return animationBackground;
    }

    public static int q(v21 v21Var) {
        int iA = y91.a();
        if (iA >= 7) {
            return v21Var.equals(v21.c) ? 0 : -1;
        }
        vp1.n(fw.s(7, iA, "This API requires extension version ", ", but the device is on "));
        return 0;
    }

    public static DividerAttributes r(kw0 kw0Var) {
        int i;
        kw0Var.getClass();
        int i2 = kw0Var.a;
        int iA = y91.a();
        if (iA < 6) {
            vp1.n(fw.s(6, iA, "This API requires extension version ", ", but the device is on "));
            return null;
        }
        if (kw0Var == kw0.c) {
            return null;
        }
        if (kw0Var instanceof jw0) {
            i = 1;
        } else {
            if (!(kw0Var instanceof iw0)) {
                vp1.h(kw0Var, "Unknown divider attributes ");
                return null;
            }
            i = 2;
        }
        DividerAttributes.Builder widthDp = new DividerAttributes.Builder(i).setDividerColor(kw0Var.b).setWidthDp(i2);
        widthDp.getClass();
        if (kw0Var instanceof iw0) {
            iw0 iw0Var = (iw0) kw0Var;
            hw0 hw0Var = iw0Var.d;
            if (hw0Var instanceof gw0) {
                gw0 gw0Var = (gw0) hw0Var;
                widthDp.setPrimaryMinRatio(gw0Var.b).setPrimaryMaxRatio(gw0Var.c);
            }
            if (y91.a() >= 7) {
                widthDp.setDraggingToFullscreenAllowed(iw0Var.e);
            }
        }
        if (y91.a() == 7 && i2 == 0) {
            widthDp.setWidthDp(1);
        }
        return widthDp.build();
    }

    public static WindowAttributes s() {
        int iA = y91.a();
        if (iA >= 5) {
            return new WindowAttributes(2);
        }
        vp1.n(fw.s(5, iA, "This API requires extension version ", ", but the device is on "));
        return null;
    }

    public final p04 a(SplitInfo splitInfo) {
        int iA = y91.a();
        if (iA == 1) {
            this.b.getClass();
            return o21.f(splitInfo);
        }
        if (iA == 2) {
            return this.c.a(splitInfo);
        }
        if (3 <= iA && iA < 5) {
            return this.d.a(splitInfo);
        }
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        primaryActivityStack.getClass();
        a5 a5VarD = d(primaryActivityStack);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        secondaryActivityStack.getClass();
        a5 a5VarD2 = d(secondaryActivityStack);
        SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        splitAttributes.getClass();
        n04 n04VarE = e(splitAttributes);
        SplitInfo.Token splitInfoToken = splitInfo.getSplitInfoToken();
        splitInfoToken.getClass();
        return new p04(a5VarD, a5VarD2, n04VarE, null, splitInfoToken);
    }

    public final ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(f70.Q(10, list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((SplitInfo) it.next()));
        }
        return arrayList;
    }

    public final Set c(Context context, Set set) {
        Class<?> clsLoadClass;
        SplitPairRule splitPairRuleG;
        try {
            clsLoadClass = this.a.a.loadClass("java.util.function.Predicate");
            clsLoadClass.getClass();
        } catch (ClassNotFoundException unused) {
            clsLoadClass = null;
        }
        if (clsLoadClass == null) {
            return k41.b;
        }
        ArrayList arrayList = new ArrayList(f70.Q(10, set));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            d31 d31Var = (d31) it.next();
            if (d31Var instanceof s04) {
                splitPairRuleG = j(context, (s04) d31Var, clsLoadClass);
            } else if (d31Var instanceof t04) {
                splitPairRuleG = k(context, (t04) d31Var, clsLoadClass);
            } else {
                if (!(d31Var instanceof z4)) {
                    xe.k("Unsupported rule type");
                    return null;
                }
                splitPairRuleG = g((z4) d31Var, clsLoadClass);
            }
            arrayList.add((EmbeddingRule) splitPairRuleG);
        }
        return d70.C0(arrayList);
    }

    public final a5 d(ActivityStack activityStack) {
        activityStack.getClass();
        int iA = y91.a();
        if (1 <= iA && iA < 5) {
            this.b.getClass();
            return o21.e(activityStack);
        }
        List activities = activityStack.getActivities();
        activities.getClass();
        return new a5(activities, activityStack.isEmpty(), activityStack.getActivityStackToken());
    }

    public final void f(List list) {
        ArrayList arrayList = new ArrayList(f70.Q(10, list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(d((ActivityStack) it.next()));
        }
    }

    public final ActivityRule g(final z4 z4Var, Class cls) {
        if (y91.a() < 2) {
            return this.b.d(z4Var, cls);
        }
        final int i = 0;
        final int i2 = 1;
        ActivityRule.Builder shouldAlwaysExpand = new ActivityRule.Builder(new Predicate2() { // from class: k21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i3 = i;
                z4 z4Var2 = z4Var;
                switch (i3) {
                    case 0:
                        Activity activity = (Activity) obj;
                        activity.getClass();
                        Set set = z4Var2.b;
                        if (!set.isEmpty()) {
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                if (((g4) it.next()).a(activity)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        Intent intent = (Intent) obj;
                        intent.getClass();
                        Set set2 = z4Var2.b;
                        if (!set2.isEmpty()) {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((g4) it2.next()).b(intent)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        }, new Predicate2() { // from class: k21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i3 = i2;
                z4 z4Var2 = z4Var;
                switch (i3) {
                    case 0:
                        Activity activity = (Activity) obj;
                        activity.getClass();
                        Set set = z4Var2.b;
                        if (!set.isEmpty()) {
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                if (((g4) it.next()).a(activity)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        Intent intent = (Intent) obj;
                        intent.getClass();
                        Set set2 = z4Var2.b;
                        if (!set2.isEmpty()) {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((g4) it2.next()).b(intent)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        }).setShouldAlwaysExpand(z4Var.c);
        shouldAlwaysExpand.getClass();
        String strA = z4Var.a();
        if (strA == null) {
            strA = uf2.r(z4Var);
        }
        shouldAlwaysExpand.setTag(strA);
        ActivityRule activityRuleBuild = shouldAlwaysExpand.build();
        activityRuleBuild.getClass();
        return activityRuleBuild;
    }

    public final SplitPairRule j(Context context, final s04 s04Var, Class cls) {
        if (y91.a() < 2) {
            return this.b.h(context, s04Var, cls);
        }
        final int i = 0;
        Predicate2 predicate2 = new Predicate2() { // from class: j21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i2 = i;
                s04 s04Var2 = s04Var;
                Pair pair = (Pair) obj;
                switch (i2) {
                    case 0:
                        pair.getClass();
                        Set<r04> set = s04Var2.j;
                        if (!set.isEmpty()) {
                            for (r04 r04Var : set) {
                                Object obj2 = pair.first;
                                obj2.getClass();
                                Object obj3 = pair.second;
                                obj3.getClass();
                                if (r04Var.b((Activity) obj2, (Activity) obj3)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        pair.getClass();
                        Set<r04> set2 = s04Var2.j;
                        if (!set2.isEmpty()) {
                            for (r04 r04Var2 : set2) {
                                Object obj4 = pair.first;
                                obj4.getClass();
                                Object obj5 = pair.second;
                                obj5.getClass();
                                if (r04Var2.a((Activity) obj4, (Intent) obj5)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        };
        final int i2 = 1;
        Predicate2 predicate22 = new Predicate2() { // from class: j21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i22 = i2;
                s04 s04Var2 = s04Var;
                Pair pair = (Pair) obj;
                switch (i22) {
                    case 0:
                        pair.getClass();
                        Set<r04> set = s04Var2.j;
                        if (!set.isEmpty()) {
                            for (r04 r04Var : set) {
                                Object obj2 = pair.first;
                                obj2.getClass();
                                Object obj3 = pair.second;
                                obj3.getClass();
                                if (r04Var.b((Activity) obj2, (Activity) obj3)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        pair.getClass();
                        Set<r04> set2 = s04Var2.j;
                        if (!set2.isEmpty()) {
                            for (r04 r04Var2 : set2) {
                                Object obj4 = pair.first;
                                obj4.getClass();
                                Object obj5 = pair.second;
                                obj5.getClass();
                                if (r04Var2.a((Activity) obj4, (Intent) obj5)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        };
        i21 i21Var = new i21(s04Var, context, 1);
        String strA = s04Var.a();
        SplitPairRule.Builder shouldClearTop = new SplitPairRule.Builder(predicate2, predicate22, i21Var).setDefaultSplitAttributes(i(s04Var.g)).setFinishPrimaryWithSecondary(h(s04Var.k)).setFinishSecondaryWithPrimary(h(s04Var.l)).setShouldClearTop(s04Var.m);
        shouldClearTop.getClass();
        if (strA == null) {
            strA = uf2.r(s04Var);
        }
        shouldClearTop.setTag(strA);
        SplitPairRule splitPairRuleBuild = shouldClearTop.build();
        splitPairRuleBuild.getClass();
        return splitPairRuleBuild;
    }

    public final SplitPlaceholderRule k(Context context, final t04 t04Var, Class cls) {
        if (y91.a() < 2) {
            return this.b.i(context, t04Var, cls);
        }
        final int i = 0;
        Predicate2 predicate2 = new Predicate2() { // from class: h21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i2 = i;
                t04 t04Var2 = t04Var;
                switch (i2) {
                    case 0:
                        Activity activity = (Activity) obj;
                        activity.getClass();
                        Set set = t04Var2.j;
                        if (!set.isEmpty()) {
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                if (((g4) it.next()).a(activity)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        Intent intent = (Intent) obj;
                        intent.getClass();
                        Set set2 = t04Var2.j;
                        if (!set2.isEmpty()) {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((g4) it2.next()).b(intent)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        };
        final int i2 = 1;
        Predicate2 predicate22 = new Predicate2() { // from class: h21
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                int i22 = i2;
                t04 t04Var2 = t04Var;
                switch (i22) {
                    case 0:
                        Activity activity = (Activity) obj;
                        activity.getClass();
                        Set set = t04Var2.j;
                        if (!set.isEmpty()) {
                            Iterator it = set.iterator();
                            while (it.hasNext()) {
                                if (((g4) it.next()).a(activity)) {
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        Intent intent = (Intent) obj;
                        intent.getClass();
                        Set set2 = t04Var2.j;
                        if (!set2.isEmpty()) {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((g4) it2.next()).b(intent)) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        };
        i21 i21Var = new i21(t04Var, context, 0);
        String strA = t04Var.a();
        SplitPlaceholderRule.Builder finishPrimaryWithPlaceholder = new SplitPlaceholderRule.Builder(t04Var.k, predicate2, predicate22, i21Var).setSticky(t04Var.l).setDefaultSplitAttributes(i(t04Var.g)).setFinishPrimaryWithPlaceholder(h(t04Var.m));
        finishPrimaryWithPlaceholder.getClass();
        if (strA == null) {
            strA = uf2.r(t04Var);
        }
        finishPrimaryWithPlaceholder.setTag(strA);
        SplitPlaceholderRule splitPlaceholderRuleBuild = finishPrimaryWithPlaceholder.build();
        splitPlaceholderRuleBuild.getClass();
        return splitPlaceholderRuleBuild;
    }
}
