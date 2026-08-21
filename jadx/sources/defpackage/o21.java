package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o21 {
    public final s23 a;

    public o21(r21 r21Var, s23 s23Var) {
        this.a = s23Var;
    }

    public static n04 a(SplitInfo splitInfo) {
        splitInfo.getClass();
        m04 m04Var = m04.c;
        t21 t21Var = u21.a;
        v21 v21Var = v21.b;
        w21 w21Var = new w21(t21Var, v21Var, v21Var, v21Var);
        float splitRatio = splitInfo.getSplitRatio();
        m04 m04VarH = m04.c;
        if (splitRatio != m04VarH.b) {
            m04VarH = xb5.H(splitRatio);
        }
        return new n04(m04VarH, k04.c, w21Var, kw0.c);
    }

    public static void b(SplitPairRule.Builder builder, n04 n04Var) {
        e03 e03VarG = g(n04Var);
        float fFloatValue = ((Number) e03VarG.b).floatValue();
        int iIntValue = ((Number) e03VarG.f).intValue();
        builder.setSplitRatio(fFloatValue);
        builder.setLayoutDirection(iIntValue);
    }

    public static void c(SplitPlaceholderRule.Builder builder, n04 n04Var) {
        e03 e03VarG = g(n04Var);
        float fFloatValue = ((Number) e03VarG.b).floatValue();
        int iIntValue = ((Number) e03VarG.f).intValue();
        builder.setSplitRatio(fFloatValue);
        builder.setLayoutDirection(iIntValue);
    }

    public static a5 e(ActivityStack activityStack) {
        activityStack.getClass();
        List activities = activityStack.getActivities();
        activities.getClass();
        return new a5(activities, activityStack.isEmpty(), null);
    }

    public static p04 f(SplitInfo splitInfo) {
        splitInfo.getClass();
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        primaryActivityStack.getClass();
        a5 a5VarE = e(primaryActivityStack);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        secondaryActivityStack.getClass();
        return new p04(a5VarE, e(secondaryActivityStack), a(splitInfo), null, null);
    }

    public static e03 g(n04 n04Var) {
        m04 m04Var = n04Var.a;
        k04 k04Var = n04Var.b;
        float f = m04Var.b;
        double d = f;
        int i = 3;
        if (0.0d <= d && d <= 1.0d && f != 1.0f) {
            k04 k04Var2 = k04.d;
            k04 k04Var3 = k04.e;
            k04 k04Var4 = k04.c;
            if (qe.a0(k04Var, new k04[]{k04Var2, k04Var3, k04Var4})) {
                Float fValueOf = Float.valueOf(m04Var.b);
                if (!n12.c(k04Var, k04Var4)) {
                    if (n12.c(k04Var, k04Var2)) {
                        i = 0;
                    } else {
                        if (!n12.c(k04Var, k04Var3)) {
                            xe.q("Unsupported layout direction must be covered in @isSplitAttributesSupported!");
                            return null;
                        }
                        i = 1;
                    }
                }
                return new e03(fValueOf, Integer.valueOf(i));
            }
        }
        return new e03(Float.valueOf(0.0f), 3);
    }

    public final ActivityRule d(z4 z4Var, Class cls) throws NoSuchMethodException {
        Constructor constructor = ActivityRule.Builder.class.getConstructor(cls, cls);
        Set set = z4Var.b;
        j50 j50VarA = dh3.a(Activity.class);
        l21 l21Var = new l21(set, 1);
        s23 s23Var = this.a;
        ActivityRule activityRuleBuild = ((ActivityRule.Builder) constructor.newInstance(s23Var.b(j50VarA, l21Var), s23Var.b(dh3.a(Intent.class), new l21(set, 0)))).setShouldAlwaysExpand(z4Var.c).build();
        activityRuleBuild.getClass();
        return activityRuleBuild;
    }

    public final SplitPairRule h(Context context, s04 s04Var, Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        final int i = 0;
        final int i2 = 1;
        Constructor constructor = SplitPairRule.Builder.class.getConstructor(cls, cls, cls);
        final Set set = s04Var.j;
        j50 j50VarA = dh3.a(Activity.class);
        j50 j50VarA2 = dh3.a(Activity.class);
        Function2 function2 = new Function2() { // from class: n21
            @Override // kotlin.jvm.functions.Function2
            public final Object k(Object obj, Object obj2) {
                int i3 = i2;
                boolean z = true;
                Set set2 = set;
                Activity activity = (Activity) obj;
                switch (i3) {
                    case 0:
                        Intent intent = (Intent) obj2;
                        activity.getClass();
                        intent.getClass();
                        if (set2.isEmpty()) {
                            z = false;
                        } else {
                            Iterator it = set2.iterator();
                            while (it.hasNext()) {
                                if (((r04) it.next()).a(activity, intent)) {
                                }
                            }
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    default:
                        Activity activity2 = (Activity) obj2;
                        activity.getClass();
                        activity2.getClass();
                        if (set2.isEmpty()) {
                            z = false;
                        } else {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((r04) it2.next()).b(activity, activity2)) {
                                }
                            }
                            z = false;
                        }
                        return Boolean.valueOf(z);
                }
            }
        };
        s23 s23Var = this.a;
        Object objNewInstance = constructor.newInstance(s23Var.a(j50VarA, j50VarA2, function2), s23Var.a(dh3.a(Activity.class), dh3.a(Intent.class), new Function2() { // from class: n21
            @Override // kotlin.jvm.functions.Function2
            public final Object k(Object obj, Object obj2) {
                int i3 = i;
                boolean z = true;
                Set set2 = set;
                Activity activity = (Activity) obj;
                switch (i3) {
                    case 0:
                        Intent intent = (Intent) obj2;
                        activity.getClass();
                        intent.getClass();
                        if (set2.isEmpty()) {
                            z = false;
                        } else {
                            Iterator it = set2.iterator();
                            while (it.hasNext()) {
                                if (((r04) it.next()).a(activity, intent)) {
                                }
                            }
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    default:
                        Activity activity2 = (Activity) obj2;
                        activity.getClass();
                        activity2.getClass();
                        if (set2.isEmpty()) {
                            z = false;
                        } else {
                            Iterator it2 = set2.iterator();
                            while (it2.hasNext()) {
                                if (((r04) it2.next()).b(activity, activity2)) {
                                }
                            }
                            z = false;
                        }
                        return Boolean.valueOf(z);
                }
            }
        }), s23Var.b(dh3.a(ad0.c()), new m21(s04Var, context)));
        objNewInstance.getClass();
        SplitPairRule.Builder builder = (SplitPairRule.Builder) objNewInstance;
        b(builder, s04Var.g);
        SplitPairRule splitPairRuleBuild = builder.setShouldClearTop(s04Var.m).setFinishPrimaryWithSecondary(r21.h(s04Var.k)).setFinishSecondaryWithPrimary(r21.h(s04Var.l)).build();
        splitPairRuleBuild.getClass();
        return splitPairRuleBuild;
    }

    public final SplitPlaceholderRule i(Context context, t04 t04Var, Class cls) throws NoSuchMethodException {
        Constructor constructor = SplitPlaceholderRule.Builder.class.getConstructor(Intent.class, cls, cls, cls);
        Intent intent = t04Var.k;
        Set set = t04Var.j;
        j50 j50VarA = dh3.a(Activity.class);
        l21 l21Var = new l21(set, 1);
        s23 s23Var = this.a;
        SplitPlaceholderRule.Builder finishPrimaryWithSecondary = ((SplitPlaceholderRule.Builder) constructor.newInstance(intent, s23Var.b(j50VarA, l21Var), s23Var.b(dh3.a(Intent.class), new l21(set, 0)), s23Var.b(dh3.a(ad0.c()), new m21(t04Var, context)))).setSticky(t04Var.l).setFinishPrimaryWithSecondary(r21.h(t04Var.m));
        finishPrimaryWithSecondary.getClass();
        c(finishPrimaryWithSecondary, t04Var.g);
        SplitPlaceholderRule splitPlaceholderRuleBuild = finishPrimaryWithSecondary.build();
        splitPlaceholderRuleBuild.getClass();
        return splitPlaceholderRuleBuild;
    }
}
