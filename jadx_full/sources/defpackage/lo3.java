package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.core.util.function.Predicate;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.EmbeddedActivityWindowInfo;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitAttributesCalculatorParams;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.SplitRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import io.sentry.android.core.a1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lo3 {
    public final ClassLoader a;
    public final cp1 b;
    public final WindowExtensions c;
    public final s23 d;

    public lo3(ClassLoader classLoader, cp1 cp1Var, WindowExtensions windowExtensions) {
        this.a = classLoader;
        this.b = cp1Var;
        this.c = windowExtensions;
        this.d = new s23(classLoader);
    }

    public static final boolean A() throws NoSuchMethodException {
        Method method = SplitPlaceholderRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
        Class cls = Integer.TYPE;
        Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setLayoutDirection", cls);
        Method method3 = SplitPlaceholderRule.Builder.class.getMethod("setSticky", Boolean.TYPE);
        Method method4 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithSecondary", cls);
        return dw2.H(method) && method.getReturnType().equals(SplitPlaceholderRule.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(SplitPlaceholderRule.Builder.class) && dw2.H(method3) && method3.getReturnType().equals(SplitPlaceholderRule.Builder.class) && dw2.H(method4) && method4.getReturnType().equals(SplitPlaceholderRule.Builder.class);
    }

    public static final boolean B() throws NoSuchMethodException {
        Constructor declaredConstructor = SplitPlaceholderRule.Builder.class.getDeclaredConstructor(Intent.class, Predicate.class, Predicate.class, Predicate.class);
        Method method = SplitPlaceholderRule.Builder.class.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
        Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithPlaceholder", Integer.TYPE);
        Method method3 = SplitPlaceholderRule.Builder.class.getMethod("setTag", String.class);
        declaredConstructor.getClass();
        return Modifier.isPublic(declaredConstructor.getModifiers()) && dw2.H(method) && method.getReturnType().equals(SplitPlaceholderRule.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(SplitPlaceholderRule.Builder.class) && dw2.H(method3) && method3.getReturnType().equals(SplitPlaceholderRule.Builder.class);
    }

    public static final boolean C() throws NoSuchMethodException {
        Method method = SplitPlaceholderRule.class.getMethod("getPlaceholderIntent", null);
        Method method2 = SplitPlaceholderRule.class.getMethod("isSticky", null);
        Method method3 = SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithSecondary", null);
        if (!dw2.H(method) || !method.getReturnType().equals(Intent.class) || !dw2.H(method2)) {
            return false;
        }
        Class cls = Boolean.TYPE;
        if (!dw2.G(cls, method2, cls) || !dw2.H(method3)) {
            return false;
        }
        Class cls2 = Integer.TYPE;
        return dw2.G(cls2, method3, cls2);
    }

    public static final boolean D() throws NoSuchMethodException {
        Class cls = Float.TYPE;
        Constructor declaredConstructor = SplitAttributes.SplitType.RatioSplitType.class.getDeclaredConstructor(cls);
        Method method = SplitAttributes.SplitType.RatioSplitType.class.getMethod("getRatio", null);
        Method method2 = SplitAttributes.SplitType.RatioSplitType.class.getMethod("splitEqually", null);
        Constructor declaredConstructor2 = SplitAttributes.SplitType.HingeSplitType.class.getDeclaredConstructor(SplitAttributes.SplitType.class);
        Method method3 = SplitAttributes.SplitType.HingeSplitType.class.getMethod("getFallbackSplitType", null);
        Constructor declaredConstructor3 = SplitAttributes.SplitType.ExpandContainersSplitType.class.getDeclaredConstructor(null);
        declaredConstructor.getClass();
        if (Modifier.isPublic(declaredConstructor.getModifiers()) && dw2.H(method) && dw2.G(cls, method, cls)) {
            declaredConstructor2.getClass();
            if (Modifier.isPublic(declaredConstructor2.getModifiers()) && dw2.H(method2) && method2.getReturnType().equals(SplitAttributes.SplitType.RatioSplitType.class) && dw2.H(method3) && method3.getReturnType().equals(SplitAttributes.SplitType.class)) {
                declaredConstructor3.getClass();
                if (Modifier.isPublic(declaredConstructor3.getModifiers())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean E() throws NoSuchMethodException {
        Method method = WindowAttributes.class.getMethod("getDimAreaBehavior", null);
        Method method2 = SplitAttributes.class.getMethod("getWindowAttributes", null);
        Method method3 = SplitAttributes.Builder.class.getMethod("setWindowAttributes", WindowAttributes.class);
        if (dw2.H(method)) {
            Class cls = Integer.TYPE;
            if (dw2.G(cls, method, cls) && dw2.H(method2) && method2.getReturnType().equals(WindowAttributes.class) && dw2.H(method3) && method3.getReturnType().equals(SplitAttributes.Builder.class)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean F() throws NoSuchMethodException {
        Method method = SplitAttributes.class.getMethod("getAnimationParams", null);
        return dw2.H(method) && method.getReturnType().equals(AnimationParams.class);
    }

    public static final boolean G() throws NoSuchMethodException {
        Method method = SplitRule.class.getMethod("getDefaultSplitAttributes", null);
        return dw2.H(method) && method.getReturnType().equals(SplitAttributes.class);
    }

    public static final boolean H() throws NoSuchMethodException {
        Method method = SplitAttributes.class.getMethod("getDividerAttributes", null);
        return dw2.H(method) && method.getReturnType().equals(DividerAttributes.class);
    }

    public static final boolean I(lo3 lo3Var) throws NoSuchMethodException {
        Method method = lo3Var.b().getMethod("getEmbeddedActivityWindowInfo", Activity.class);
        return dw2.H(method) && method.getReturnType().equals(EmbeddedActivityWindowInfo.class);
    }

    public static final boolean J() throws NoSuchMethodException {
        Method method = SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithPlaceholder", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Integer.TYPE;
        return dw2.G(cls, method, cls);
    }

    public static final boolean K() throws NoSuchMethodException {
        Method method = SplitRule.class.getMethod("getLayoutDirection", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Integer.TYPE;
        return dw2.G(cls, method, cls);
    }

    public static final boolean L() throws NoSuchMethodException {
        Method method = SplitInfo.class.getMethod("getSplitAttributes", null);
        return dw2.H(method) && method.getReturnType().equals(SplitAttributes.class);
    }

    public static final boolean M() throws NoSuchMethodException {
        Method method = SplitInfo.class.getMethod("getSplitInfoToken", null);
        return dw2.H(method) && method.getReturnType().equals(SplitInfo.Token.class);
    }

    public static final boolean N() throws NoSuchMethodException {
        Method method = SplitRule.class.getMethod("getSplitRatio", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Float.TYPE;
        return dw2.G(cls, method, cls);
    }

    public static final boolean O() throws NoSuchMethodException {
        Method method = DividerAttributes.class.getMethod("isDraggingToFullscreenAllowed", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Boolean.TYPE;
        return dw2.G(cls, method, cls);
    }

    public static final boolean P(lo3 lo3Var) throws NoSuchMethodException, ClassNotFoundException {
        Method method = SplitPinRule.class.getMethod("isSticky", null);
        Class clsB = lo3Var.b();
        Class<?> cls = Integer.TYPE;
        Method method2 = clsB.getMethod("pinTopActivityStack", cls, SplitPinRule.class);
        Method method3 = lo3Var.b().getMethod("unpinTopActivityStack", cls);
        if (dw2.H(method)) {
            Class cls2 = Boolean.TYPE;
            if (dw2.G(cls2, method, cls2) && dw2.H(method2) && method2.getReturnType().equals(cls2) && dw2.H(method3)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean Q(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("registerActivityStackCallback", Executor.class, Consumer.class));
    }

    public static final boolean R() throws NoSuchMethodException {
        Method method = SplitAttributes.Builder.class.getMethod("setAnimationParams", AnimationParams.class);
        return dw2.H(method) && method.getReturnType().equals(SplitAttributes.Builder.class);
    }

    public static final boolean S() throws NoSuchMethodException {
        Method method = SplitAttributes.Builder.class.getMethod("setDividerAttributes", DividerAttributes.class);
        return dw2.H(method) && method.getReturnType().equals(SplitAttributes.Builder.class);
    }

    public static final boolean T() throws NoSuchMethodException {
        Method method = DividerAttributes.Builder.class.getMethod("setDraggingToFullscreenAllowed", Boolean.TYPE);
        return dw2.H(method) && method.getReturnType().equals(DividerAttributes.Builder.class);
    }

    public static final boolean U(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("setEmbeddedActivityWindowInfoCallback", Executor.class, Consumer.class));
    }

    public static final boolean V(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("setSplitInfoCallback", Consumer.class));
    }

    public static final boolean W(lo3 lo3Var) throws NoSuchMethodException {
        Method method = lo3Var.b().getMethod("setSplitAttributesCalculator", Function.class);
        Method method2 = lo3Var.b().getMethod("clearSplitAttributesCalculator", null);
        method.getClass();
        return Modifier.isPublic(method.getModifiers()) && dw2.H(method2);
    }

    public static final boolean X() throws NoSuchMethodException {
        Method method = SplitInfo.class.getMethod("getToken", null);
        return dw2.H(method) && method.getReturnType().equals(IBinder.class);
    }

    public static final boolean Y(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("unregisterActivityStackCallback", Consumer.class));
    }

    public static final boolean Z(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("updateSplitAttributes", IBinder.class, SplitAttributes.class));
    }

    public static final boolean a0(lo3 lo3Var) {
        return dw2.H(lo3Var.b().getMethod("updateSplitAttributes", SplitInfo.Token.class, SplitAttributes.class));
    }

    public static final boolean i() throws NoSuchMethodException {
        Method method = ActivityStack.class.getMethod("getActivityStackToken", null);
        return dw2.H(method) && method.getReturnType().equals(ActivityStack.Token.class);
    }

    public static final boolean j() throws NoSuchMethodException {
        Method method = ActivityRule.Builder.class.getMethod("setShouldAlwaysExpand", Boolean.TYPE);
        return dw2.H(method) && method.getReturnType().equals(ActivityRule.Builder.class);
    }

    public static final boolean k() throws NoSuchMethodException {
        Constructor declaredConstructor = ActivityRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class);
        Method method = ActivityRule.Builder.class.getMethod("setTag", String.class);
        declaredConstructor.getClass();
        return Modifier.isPublic(declaredConstructor.getModifiers()) && dw2.H(method) && method.getReturnType().equals(ActivityRule.Builder.class);
    }

    public static final boolean l() throws NoSuchMethodException {
        Method method = ActivityRule.class.getMethod("shouldAlwaysExpand", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Boolean.TYPE;
        return dw2.G(cls, method, cls);
    }

    public static final boolean m() throws NoSuchFieldException, NoSuchMethodException {
        Method method = ActivityStack.Token.class.getMethod("toBundle", null);
        Method method2 = ActivityStack.Token.class.getMethod("readFromBundle", Bundle.class);
        Method method3 = ActivityStack.Token.class.getMethod("createFromBinder", IBinder.class);
        Field declaredField = ActivityStack.Token.class.getDeclaredField("INVALID_ACTIVITY_STACK_TOKEN");
        if (dw2.H(method) && method.getReturnType().equals(Bundle.class) && dw2.H(method2) && method2.getReturnType().equals(ActivityStack.Token.class) && dw2.H(method3) && method3.getReturnType().equals(ActivityStack.Token.class)) {
            declaredField.getClass();
            if (Modifier.isPublic(declaredField.getModifiers())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean n() throws NoSuchFieldException, NoSuchMethodException {
        Class cls = Integer.TYPE;
        Method method = AnimationBackground.class.getMethod("createColorBackground", cls);
        Field declaredField = AnimationBackground.class.getDeclaredField("ANIMATION_BACKGROUND_DEFAULT");
        Method method2 = AnimationBackground.ColorBackground.class.getMethod("getColor", null);
        Method method3 = SplitAttributes.class.getMethod("getAnimationBackground", null);
        Method method4 = SplitAttributes.Builder.class.getMethod("setAnimationBackground", AnimationBackground.class);
        if (dw2.H(method) && method.getReturnType().equals(AnimationBackground.ColorBackground.class)) {
            declaredField.getClass();
            if (Modifier.isPublic(declaredField.getModifiers()) && dw2.H(method2) && dw2.G(cls, method2, cls) && dw2.H(method3) && method3.getReturnType().equals(AnimationBackground.class) && dw2.H(method4) && method4.getReturnType().equals(SplitAttributes.Builder.class)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean o() throws NoSuchMethodException {
        Method method = AnimationParams.Builder.class.getMethod("setAnimationBackground", AnimationBackground.class);
        Class cls = Integer.TYPE;
        Method method2 = AnimationParams.Builder.class.getMethod("setOpenAnimationResId", cls);
        Method method3 = AnimationParams.Builder.class.getMethod("setCloseAnimationResId", cls);
        Method method4 = AnimationParams.Builder.class.getMethod("setChangeAnimationResId", cls);
        return dw2.H(method) && method.getReturnType().equals(AnimationParams.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(AnimationParams.Builder.class) && dw2.H(method3) && method3.getReturnType().equals(AnimationParams.Builder.class) && dw2.H(method4) && method4.getReturnType().equals(AnimationParams.Builder.class);
    }

    public static final boolean p() throws NoSuchFieldException, NoSuchMethodException {
        Field declaredField = AnimationParams.class.getDeclaredField("DEFAULT_ANIMATION_RESOURCES_ID");
        Method method = AnimationParams.class.getMethod("getAnimationBackground", null);
        Method method2 = AnimationParams.class.getMethod("getOpenAnimationResId", null);
        Method method3 = AnimationParams.class.getMethod("getCloseAnimationResId", null);
        Method method4 = AnimationParams.class.getMethod("getChangeAnimationResId", null);
        declaredField.getClass();
        if (!Modifier.isPublic(declaredField.getModifiers()) || !dw2.H(method) || !method.getReturnType().equals(AnimationBackground.class) || !dw2.H(method2)) {
            return false;
        }
        Class cls = Integer.TYPE;
        return dw2.G(cls, method2, cls) && dw2.H(method3) && method3.getReturnType().equals(cls) && dw2.H(method4) && method4.getReturnType().equals(cls);
    }

    public static final boolean q() throws NoSuchMethodException {
        Class cls = Integer.TYPE;
        Constructor declaredConstructor = DividerAttributes.Builder.class.getDeclaredConstructor(cls);
        Constructor declaredConstructor2 = DividerAttributes.Builder.class.getDeclaredConstructor(DividerAttributes.class);
        Method method = DividerAttributes.Builder.class.getMethod("setWidthDp", cls);
        Class cls2 = Float.TYPE;
        Method method2 = DividerAttributes.Builder.class.getMethod("setPrimaryMinRatio", cls2);
        Method method3 = DividerAttributes.Builder.class.getMethod("setPrimaryMaxRatio", cls2);
        Method method4 = DividerAttributes.Builder.class.getMethod("setDividerColor", cls);
        declaredConstructor.getClass();
        if (Modifier.isPublic(declaredConstructor.getModifiers())) {
            declaredConstructor2.getClass();
            if (Modifier.isPublic(declaredConstructor2.getModifiers()) && dw2.H(method) && method.getReturnType().equals(DividerAttributes.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(DividerAttributes.Builder.class) && dw2.H(method3) && method3.getReturnType().equals(DividerAttributes.Builder.class) && dw2.H(method4) && method4.getReturnType().equals(DividerAttributes.Builder.class)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean r() throws NoSuchMethodException {
        Method method = DividerAttributes.class.getMethod("getDividerType", null);
        Method method2 = DividerAttributes.class.getMethod("getWidthDp", null);
        Method method3 = DividerAttributes.class.getMethod("getPrimaryMinRatio", null);
        Method method4 = DividerAttributes.class.getMethod("getPrimaryMaxRatio", null);
        Method method5 = DividerAttributes.class.getMethod("getDividerColor", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Integer.TYPE;
        if (!dw2.G(cls, method, cls) || !dw2.H(method2) || !method2.getReturnType().equals(cls) || !dw2.H(method3)) {
            return false;
        }
        Class cls2 = Float.TYPE;
        return dw2.G(cls2, method3, cls2) && dw2.H(method4) && method4.getReturnType().equals(cls2) && dw2.H(method5) && method5.getReturnType().equals(cls);
    }

    public static final boolean s() throws NoSuchMethodException {
        Method method = EmbeddedActivityWindowInfo.class.getMethod("getActivity", null);
        Method method2 = EmbeddedActivityWindowInfo.class.getMethod("isEmbedded", null);
        Method method3 = EmbeddedActivityWindowInfo.class.getMethod("getTaskBounds", null);
        Method method4 = EmbeddedActivityWindowInfo.class.getMethod("getActivityStackBounds", null);
        if (!dw2.H(method) || !method.getReturnType().equals(Activity.class) || !dw2.H(method2)) {
            return false;
        }
        Class cls = Boolean.TYPE;
        return dw2.G(cls, method2, cls) && dw2.H(method3) && method3.getReturnType().equals(Rect.class) && dw2.H(method4) && method4.getReturnType().equals(Rect.class);
    }

    public static final boolean t() throws NoSuchMethodException {
        Method method = SplitAttributesCalculatorParams.class.getMethod("getParentWindowMetrics", null);
        Method method2 = SplitAttributesCalculatorParams.class.getMethod("getParentConfiguration", null);
        Method method3 = SplitAttributesCalculatorParams.class.getMethod("getDefaultSplitAttributes", null);
        Method method4 = SplitAttributesCalculatorParams.class.getMethod("areDefaultConstraintsSatisfied", null);
        Method method5 = SplitAttributesCalculatorParams.class.getMethod("getParentWindowLayoutInfo", null);
        Method method6 = SplitAttributesCalculatorParams.class.getMethod("getSplitRuleTag", null);
        if (!dw2.H(method)) {
            return false;
        }
        if (!method.getReturnType().equals(ad0.c()) || !dw2.H(method2) || !method2.getReturnType().equals(Configuration.class) || !dw2.H(method3) || !method3.getReturnType().equals(SplitAttributes.class) || !dw2.H(method4)) {
            return false;
        }
        Class cls = Boolean.TYPE;
        return dw2.G(cls, method4, cls) && dw2.H(method5) && method5.getReturnType().equals(WindowLayoutInfo.class) && dw2.H(method6) && method6.getReturnType().equals(String.class);
    }

    public static final boolean u() throws NoSuchMethodException {
        Method method = SplitAttributes.class.getMethod("getLayoutDirection", null);
        Method method2 = SplitAttributes.class.getMethod("getSplitType", null);
        Method method3 = SplitAttributes.Builder.class.getMethod("setSplitType", SplitAttributes.SplitType.class);
        Class cls = Integer.TYPE;
        return dw2.H(method) && dw2.G(cls, method, cls) && dw2.H(method2) && method2.getReturnType().equals(SplitAttributes.SplitType.class) && dw2.H(method3) && dw2.H(SplitAttributes.Builder.class.getMethod("setLayoutDirection", cls));
    }

    public static final boolean v() throws NoSuchMethodException {
        Method method = SplitInfo.Token.class.getMethod("createFromBinder", IBinder.class);
        return dw2.H(method) && method.getReturnType().equals(SplitInfo.Token.class);
    }

    public static final boolean w() throws NoSuchMethodException {
        Method method = SplitInfo.class.getMethod("getPrimaryActivityStack", null);
        Method method2 = SplitInfo.class.getMethod("getSecondaryActivityStack", null);
        Method method3 = SplitInfo.class.getMethod("getSplitRatio", null);
        if (!dw2.H(method) || !method.getReturnType().equals(ActivityStack.class) || !dw2.H(method2) || !method2.getReturnType().equals(ActivityStack.class) || !dw2.H(method3)) {
            return false;
        }
        Class cls = Float.TYPE;
        return dw2.G(cls, method3, cls);
    }

    public static final boolean x() throws NoSuchMethodException {
        Method method = SplitPairRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
        Method method2 = SplitPairRule.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
        return dw2.H(method) && method.getReturnType().equals(SplitPairRule.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(SplitPairRule.Builder.class);
    }

    public static final boolean y() throws NoSuchMethodException {
        Constructor declaredConstructor = SplitPairRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class, Predicate.class);
        Method method = SplitPairRule.Builder.class.getMethod("setDefaultSplitAttributes", SplitAttributes.class);
        Method method2 = SplitPairRule.Builder.class.getMethod("setTag", String.class);
        declaredConstructor.getClass();
        return Modifier.isPublic(declaredConstructor.getModifiers()) && dw2.H(method) && method.getReturnType().equals(SplitPairRule.Builder.class) && dw2.H(method2) && method2.getReturnType().equals(SplitPairRule.Builder.class);
    }

    public static final boolean z() throws NoSuchMethodException {
        Method method = SplitPairRule.class.getMethod("getFinishPrimaryWithSecondary", null);
        Method method2 = SplitPairRule.class.getMethod("getFinishSecondaryWithPrimary", null);
        Method method3 = SplitPairRule.class.getMethod("shouldClearTop", null);
        if (!dw2.H(method)) {
            return false;
        }
        Class cls = Integer.TYPE;
        if (!dw2.G(cls, method, cls) || !dw2.H(method2) || !method2.getReturnType().equals(cls) || !dw2.H(method3)) {
            return false;
        }
        Class cls2 = Boolean.TYPE;
        return dw2.G(cls2, method3, cls2);
    }

    public final ActivityEmbeddingComponent a() {
        boolean zH = false;
        if (this.d.c() && r25.W("WindowExtensions#getActivityEmbeddingComponent is not valid", new ko3(this, 6))) {
            int iA = y91.a();
            if (iA == 1) {
                zH = c();
            } else if (iA == 2) {
                zH = d();
            } else if (3 <= iA && iA < 5) {
                zH = e();
            } else if (iA == 5) {
                zH = f();
            } else if (iA == 6) {
                zH = g();
            } else if (iA == 7) {
                zH = h();
            } else if (8 <= iA && iA <= Integer.MAX_VALUE) {
                zH = h();
            }
        }
        if (!zH) {
            return null;
        }
        try {
            return this.c.getActivityEmbeddingComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final Class b() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.a.loadClass("androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        clsLoadClass.getClass();
        return clsLoadClass;
    }

    public final boolean c() {
        boolean zN;
        boolean zK;
        boolean zL;
        boolean zJ;
        boolean zW;
        boolean z;
        boolean zX;
        boolean zC;
        boolean zA;
        if (!r25.W("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new ko3(this, 5)) || !r25.W("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new ko3(this, 3)) || !r25.W("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new ko3(this, 4))) {
            return false;
        }
        try {
            zN = N();
            if (!zN) {
                a1.d("ReflectionGuard", "SplitRule#getSplitRatio is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitRule#getSplitRatio is not valid"));
            zN = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitRule#getSplitRatio is not valid"));
            zN = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitRule#getSplitRatio is not valid"));
            zN = false;
        }
        if (!zN) {
            return false;
        }
        try {
            zK = K();
            if (!zK) {
                a1.d("ReflectionGuard", "SplitRule#getLayoutDirection is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitRule#getLayoutDirection is not valid"));
            zK = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitRule#getLayoutDirection is not valid"));
            zK = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitRule#getLayoutDirection is not valid"));
            zK = false;
        }
        if (!zK) {
            return false;
        }
        try {
            zL = l();
            if (!zL) {
                a1.d("ReflectionGuard", "Class ActivityRule is not valid");
            }
        } catch (ClassNotFoundException unused7) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class ActivityRule is not valid"));
            zL = false;
        } catch (NoSuchFieldException unused8) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class ActivityRule is not valid"));
            zL = false;
        } catch (NoSuchMethodException unused9) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class ActivityRule is not valid"));
            zL = false;
        }
        if (!zL) {
            return false;
        }
        try {
            zJ = j();
            if (!zJ) {
                a1.d("ReflectionGuard", "Class ActivityRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused10) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class ActivityRule.Builder is not valid"));
            zJ = false;
        } catch (NoSuchFieldException unused11) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class ActivityRule.Builder is not valid"));
            zJ = false;
        } catch (NoSuchMethodException unused12) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class ActivityRule.Builder is not valid"));
            zJ = false;
        }
        if (!zJ) {
            return false;
        }
        try {
            zW = w();
            if (!zW) {
                a1.d("ReflectionGuard", "Class SplitInfo is not valid");
            }
        } catch (ClassNotFoundException unused13) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitInfo is not valid"));
            zW = false;
        } catch (NoSuchFieldException unused14) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitInfo is not valid"));
            zW = false;
        } catch (NoSuchMethodException unused15) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitInfo is not valid"));
            zW = false;
        }
        if (!zW) {
            return false;
        }
        try {
            z = z();
            if (!z) {
                a1.d("ReflectionGuard", "Class SplitPairRule is not valid");
            }
        } catch (ClassNotFoundException unused16) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPairRule is not valid"));
            z = false;
        } catch (NoSuchFieldException unused17) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPairRule is not valid"));
            z = false;
        } catch (NoSuchMethodException unused18) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPairRule is not valid"));
            z = false;
        }
        if (!z) {
            return false;
        }
        try {
            zX = x();
            if (!zX) {
                a1.d("ReflectionGuard", "Class SplitPairRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused19) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPairRule.Builder is not valid"));
            zX = false;
        } catch (NoSuchFieldException unused20) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPairRule.Builder is not valid"));
            zX = false;
        } catch (NoSuchMethodException unused21) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPairRule.Builder is not valid"));
            zX = false;
        }
        if (!zX) {
            return false;
        }
        try {
            zC = C();
            if (!zC) {
                a1.d("ReflectionGuard", "Class SplitPlaceholderRule is not valid");
            }
        } catch (ClassNotFoundException unused22) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPlaceholderRule is not valid"));
            zC = false;
        } catch (NoSuchFieldException unused23) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPlaceholderRule is not valid"));
            zC = false;
        } catch (NoSuchMethodException unused24) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPlaceholderRule is not valid"));
            zC = false;
        }
        if (!zC) {
            return false;
        }
        try {
            zA = A();
            if (!zA) {
                a1.d("ReflectionGuard", "Class SplitPlaceholderRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused25) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zA = false;
        } catch (NoSuchFieldException unused26) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zA = false;
        } catch (NoSuchMethodException unused27) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zA = false;
        }
        return zA;
    }

    public final boolean d() {
        boolean zV;
        boolean zW;
        boolean zL;
        boolean zJ;
        boolean zG;
        boolean zK;
        boolean zU;
        boolean zT;
        boolean zD;
        boolean zY;
        boolean zB;
        if (!c()) {
            return false;
        }
        try {
            zV = V(this);
            if (!zV) {
                a1.d("ReflectionGuard", "ActivityEmbeddingComponent#setSplitInfoCallback is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("ActivityEmbeddingComponent#setSplitInfoCallback is not valid"));
            zV = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("ActivityEmbeddingComponent#setSplitInfoCallback is not valid"));
            zV = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("ActivityEmbeddingComponent#setSplitInfoCallback is not valid"));
            zV = false;
        }
        if (!zV || !r25.W("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new ko3(this, 1))) {
            return false;
        }
        try {
            zW = W(this);
            if (!zW) {
                a1.d("ReflectionGuard", "ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid"));
            zW = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid"));
            zW = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid"));
            zW = false;
        }
        if (!zW) {
            return false;
        }
        try {
            zL = L();
            if (!zL) {
                a1.d("ReflectionGuard", "SplitInfo#getSplitAttributes is not valid");
            }
        } catch (ClassNotFoundException unused7) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitInfo#getSplitAttributes is not valid"));
            zL = false;
        } catch (NoSuchFieldException unused8) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitInfo#getSplitAttributes is not valid"));
            zL = false;
        } catch (NoSuchMethodException unused9) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitInfo#getSplitAttributes is not valid"));
            zL = false;
        }
        if (!zL) {
            return false;
        }
        try {
            zJ = J();
            if (!zJ) {
                a1.d("ReflectionGuard", "SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid");
            }
        } catch (ClassNotFoundException unused10) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid"));
            zJ = false;
        } catch (NoSuchFieldException unused11) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid"));
            zJ = false;
        } catch (NoSuchMethodException unused12) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid"));
            zJ = false;
        }
        if (!zJ) {
            return false;
        }
        try {
            zG = G();
            if (!zG) {
                a1.d("ReflectionGuard", "SplitRule#getDefaultSplitAttributes is not valid");
            }
        } catch (ClassNotFoundException unused13) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitRule#getDefaultSplitAttributes is not valid"));
            zG = false;
        } catch (NoSuchFieldException unused14) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitRule#getDefaultSplitAttributes is not valid"));
            zG = false;
        } catch (NoSuchMethodException unused15) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitRule#getDefaultSplitAttributes is not valid"));
            zG = false;
        }
        if (!zG) {
            return false;
        }
        try {
            zK = k();
            if (!zK) {
                a1.d("ReflectionGuard", "Class ActivityRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused16) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class ActivityRule.Builder is not valid"));
            zK = false;
        } catch (NoSuchFieldException unused17) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class ActivityRule.Builder is not valid"));
            zK = false;
        } catch (NoSuchMethodException unused18) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class ActivityRule.Builder is not valid"));
            zK = false;
        }
        if (!zK || !r25.W("Class EmbeddingRule is not valid", new t4(20))) {
            return false;
        }
        try {
            zU = u();
            if (!zU) {
                a1.d("ReflectionGuard", "Class SplitAttributes is not valid");
            }
        } catch (ClassNotFoundException unused19) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitAttributes is not valid"));
            zU = false;
        } catch (NoSuchFieldException unused20) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitAttributes is not valid"));
            zU = false;
        } catch (NoSuchMethodException unused21) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitAttributes is not valid"));
            zU = false;
        }
        if (!zU) {
            return false;
        }
        try {
            zT = t();
            if (!zT) {
                a1.d("ReflectionGuard", "Class SplitAttributesCalculatorParams is not valid");
            }
        } catch (ClassNotFoundException unused22) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitAttributesCalculatorParams is not valid"));
            zT = false;
        } catch (NoSuchFieldException unused23) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitAttributesCalculatorParams is not valid"));
            zT = false;
        } catch (NoSuchMethodException unused24) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitAttributesCalculatorParams is not valid"));
            zT = false;
        }
        if (!zT) {
            return false;
        }
        try {
            zD = D();
            if (!zD) {
                a1.d("ReflectionGuard", "Class SplitAttributes.SplitType is not valid");
            }
        } catch (ClassNotFoundException unused25) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitAttributes.SplitType is not valid"));
            zD = false;
        } catch (NoSuchFieldException unused26) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitAttributes.SplitType is not valid"));
            zD = false;
        } catch (NoSuchMethodException unused27) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitAttributes.SplitType is not valid"));
            zD = false;
        }
        if (!zD) {
            return false;
        }
        try {
            zY = y();
            if (!zY) {
                a1.d("ReflectionGuard", "Class SplitPairRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused28) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPairRule.Builder is not valid"));
            zY = false;
        } catch (NoSuchFieldException unused29) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPairRule.Builder is not valid"));
            zY = false;
        } catch (NoSuchMethodException unused30) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPairRule.Builder is not valid"));
            zY = false;
        }
        if (!zY) {
            return false;
        }
        try {
            zB = B();
            if (!zB) {
                a1.d("ReflectionGuard", "Class SplitPlaceholderRule.Builder is not valid");
            }
        } catch (ClassNotFoundException unused31) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zB = false;
        } catch (NoSuchFieldException unused32) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zB = false;
        } catch (NoSuchMethodException unused33) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class SplitPlaceholderRule.Builder is not valid"));
            zB = false;
        }
        return zB;
    }

    public final boolean e() {
        boolean Z;
        boolean zX;
        if (!d() || !r25.W("#invalidateTopVisibleSplitAttributes is not valid", new ko3(this, 2))) {
            return false;
        }
        try {
            Z = Z(this);
            if (!Z) {
                a1.d("ReflectionGuard", "#updateSplitAttributes is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("#updateSplitAttributes is not valid"));
            Z = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("#updateSplitAttributes is not valid"));
            Z = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("#updateSplitAttributes is not valid"));
            Z = false;
        }
        if (!Z) {
            return false;
        }
        try {
            zX = X();
            if (!zX) {
                a1.d("ReflectionGuard", "SplitInfo#getToken is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitInfo#getToken is not valid"));
            zX = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitInfo#getToken is not valid"));
            zX = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitInfo#getToken is not valid"));
            zX = false;
        }
        return zX;
    }

    public final boolean f() {
        boolean zI;
        boolean zQ;
        boolean zY;
        boolean zP;
        boolean zA0;
        boolean zM;
        boolean zN;
        boolean zM2;
        boolean zE;
        boolean zV;
        if (!e()) {
            return false;
        }
        try {
            zI = i();
            if (!zI) {
                a1.d("ReflectionGuard", "ActivityStack#getActivityToken is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("ActivityStack#getActivityToken is not valid"));
            zI = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("ActivityStack#getActivityToken is not valid"));
            zI = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("ActivityStack#getActivityToken is not valid"));
            zI = false;
        }
        if (!zI) {
            return false;
        }
        try {
            zQ = Q(this);
            if (!zQ) {
                a1.d("ReflectionGuard", "registerActivityStackCallback is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("registerActivityStackCallback is not valid"));
            zQ = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("registerActivityStackCallback is not valid"));
            zQ = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("registerActivityStackCallback is not valid"));
            zQ = false;
        }
        if (!zQ) {
            return false;
        }
        try {
            zY = Y(this);
            if (!zY) {
                a1.d("ReflectionGuard", "unregisterActivityStackCallback is not valid");
            }
        } catch (ClassNotFoundException unused7) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("unregisterActivityStackCallback is not valid"));
            zY = false;
        } catch (NoSuchFieldException unused8) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("unregisterActivityStackCallback is not valid"));
            zY = false;
        } catch (NoSuchMethodException unused9) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("unregisterActivityStackCallback is not valid"));
            zY = false;
        }
        if (!zY) {
            return false;
        }
        try {
            zP = P(this);
            if (!zP) {
                a1.d("ReflectionGuard", "#pin(unPin)TopActivityStack is not valid");
            }
        } catch (ClassNotFoundException unused10) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("#pin(unPin)TopActivityStack is not valid"));
            zP = false;
        } catch (NoSuchFieldException unused11) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("#pin(unPin)TopActivityStack is not valid"));
            zP = false;
        } catch (NoSuchMethodException unused12) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("#pin(unPin)TopActivityStack is not valid"));
            zP = false;
        }
        if (!zP) {
            return false;
        }
        try {
            zA0 = a0(this);
            if (!zA0) {
                a1.d("ReflectionGuard", "updateSplitAttributes is not valid");
            }
        } catch (ClassNotFoundException unused13) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("updateSplitAttributes is not valid"));
            zA0 = false;
        } catch (NoSuchFieldException unused14) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("updateSplitAttributes is not valid"));
            zA0 = false;
        } catch (NoSuchMethodException unused15) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("updateSplitAttributes is not valid"));
            zA0 = false;
        }
        if (!zA0) {
            return false;
        }
        try {
            zM = M();
            if (!zM) {
                a1.d("ReflectionGuard", "SplitInfo#getSplitInfoToken is not valid");
            }
        } catch (ClassNotFoundException unused16) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitInfo#getSplitInfoToken is not valid"));
            zM = false;
        } catch (NoSuchFieldException unused17) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitInfo#getSplitInfoToken is not valid"));
            zM = false;
        } catch (NoSuchMethodException unused18) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitInfo#getSplitInfoToken is not valid"));
            zM = false;
        }
        if (!zM) {
            return false;
        }
        try {
            zN = n();
            if (!zN) {
                a1.d("ReflectionGuard", "Class AnimationBackground is not valid");
            }
        } catch (ClassNotFoundException unused19) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class AnimationBackground is not valid"));
            zN = false;
        } catch (NoSuchFieldException unused20) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class AnimationBackground is not valid"));
            zN = false;
        } catch (NoSuchMethodException unused21) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class AnimationBackground is not valid"));
            zN = false;
        }
        if (!zN) {
            return false;
        }
        try {
            zM2 = m();
            if (!zM2) {
                a1.d("ReflectionGuard", "Class ActivityStack.Token is not valid");
            }
        } catch (ClassNotFoundException unused22) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class ActivityStack.Token is not valid"));
            zM2 = false;
        } catch (NoSuchFieldException unused23) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class ActivityStack.Token is not valid"));
            zM2 = false;
        } catch (NoSuchMethodException unused24) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class ActivityStack.Token is not valid"));
            zM2 = false;
        }
        if (!zM2) {
            return false;
        }
        try {
            zE = E();
            if (!zE) {
                a1.d("ReflectionGuard", "Class WindowAttributes is not valid");
            }
        } catch (ClassNotFoundException unused25) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class WindowAttributes is not valid"));
            zE = false;
        } catch (NoSuchFieldException unused26) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class WindowAttributes is not valid"));
            zE = false;
        } catch (NoSuchMethodException unused27) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class WindowAttributes is not valid"));
            zE = false;
        }
        if (!zE) {
            return false;
        }
        try {
            zV = v();
            if (!zV) {
                a1.d("ReflectionGuard", "SplitInfo.Token is not valid");
            }
        } catch (ClassNotFoundException unused28) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitInfo.Token is not valid"));
            zV = false;
        } catch (NoSuchFieldException unused29) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitInfo.Token is not valid"));
            zV = false;
        } catch (NoSuchMethodException unused30) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitInfo.Token is not valid"));
            zV = false;
        }
        return zV;
    }

    public final boolean g() {
        boolean zI;
        boolean zU;
        boolean zH;
        boolean zS;
        boolean zS2;
        boolean zR;
        boolean zQ;
        int i = 0;
        if (!f()) {
            return false;
        }
        try {
            zI = I(this);
            if (!zI) {
                a1.d("ReflectionGuard", "ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid"));
            zI = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid"));
            zI = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid"));
            zI = false;
        }
        if (!zI) {
            return false;
        }
        try {
            zU = U(this);
            if (!zU) {
                a1.d("ReflectionGuard", "ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid"));
            zU = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid"));
            zU = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid"));
            zU = false;
        }
        if (!zU || !r25.W("ActivityEmbeddingComponent#clearEmbeddedActivityWindowInfoCallback is not valid", new ko3(this, i))) {
            return false;
        }
        try {
            zH = H();
            if (!zH) {
                a1.d("ReflectionGuard", "SplitAttributes#getDividerAttributes is not valid");
            }
        } catch (ClassNotFoundException unused7) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitAttributes#getDividerAttributes is not valid"));
            zH = false;
        } catch (NoSuchFieldException unused8) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitAttributes#getDividerAttributes is not valid"));
            zH = false;
        } catch (NoSuchMethodException unused9) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitAttributes#getDividerAttributes is not valid"));
            zH = false;
        }
        if (!zH) {
            return false;
        }
        try {
            zS = S();
            if (!zS) {
                a1.d("ReflectionGuard", "SplitAttributes#setDividerAttributes is not valid");
            }
        } catch (ClassNotFoundException unused10) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitAttributes#setDividerAttributes is not valid"));
            zS = false;
        } catch (NoSuchFieldException unused11) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitAttributes#setDividerAttributes is not valid"));
            zS = false;
        } catch (NoSuchMethodException unused12) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitAttributes#setDividerAttributes is not valid"));
            zS = false;
        }
        if (!zS) {
            return false;
        }
        try {
            zS2 = s();
            if (!zS2) {
                a1.d("ReflectionGuard", "Class EmbeddedActivityWindowInfo is not valid");
            }
        } catch (ClassNotFoundException unused13) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class EmbeddedActivityWindowInfo is not valid"));
            zS2 = false;
        } catch (NoSuchFieldException unused14) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class EmbeddedActivityWindowInfo is not valid"));
            zS2 = false;
        } catch (NoSuchMethodException unused15) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class EmbeddedActivityWindowInfo is not valid"));
            zS2 = false;
        }
        if (!zS2) {
            return false;
        }
        try {
            zR = r();
            if (!zR) {
                a1.d("ReflectionGuard", "Class DividerAttributes is not valid");
            }
        } catch (ClassNotFoundException unused16) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class DividerAttributes is not valid"));
            zR = false;
        } catch (NoSuchFieldException unused17) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class DividerAttributes is not valid"));
            zR = false;
        } catch (NoSuchMethodException unused18) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class DividerAttributes is not valid"));
            zR = false;
        }
        if (!zR) {
            return false;
        }
        try {
            zQ = q();
            if (!zQ) {
                a1.d("ReflectionGuard", "Class DividerAttributes.Builder is not valid");
            }
        } catch (ClassNotFoundException unused19) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class DividerAttributes.Builder is not valid"));
            zQ = false;
        } catch (NoSuchFieldException unused20) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class DividerAttributes.Builder is not valid"));
            zQ = false;
        } catch (NoSuchMethodException unused21) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class DividerAttributes.Builder is not valid"));
            zQ = false;
        }
        return zQ;
    }

    public final boolean h() {
        boolean zF;
        boolean zR;
        boolean zO;
        boolean zT;
        boolean zP;
        boolean zO2;
        if (!g()) {
            return false;
        }
        try {
            zF = F();
            if (!zF) {
                a1.d("ReflectionGuard", "SplitAttributes#getAnimationParams is not valid");
            }
        } catch (ClassNotFoundException unused) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitAttributes#getAnimationParams is not valid"));
            zF = false;
        } catch (NoSuchFieldException unused2) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitAttributes#getAnimationParams is not valid"));
            zF = false;
        } catch (NoSuchMethodException unused3) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitAttributes#getAnimationParams is not valid"));
            zF = false;
        }
        if (!zF) {
            return false;
        }
        try {
            zR = R();
            if (!zR) {
                a1.d("ReflectionGuard", "SplitAttributes#setAnimationParams is not valid");
            }
        } catch (ClassNotFoundException unused4) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("SplitAttributes#setAnimationParams is not valid"));
            zR = false;
        } catch (NoSuchFieldException unused5) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("SplitAttributes#setAnimationParams is not valid"));
            zR = false;
        } catch (NoSuchMethodException unused6) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("SplitAttributes#setAnimationParams is not valid"));
            zR = false;
        }
        if (!zR) {
            return false;
        }
        try {
            zO = O();
            if (!zO) {
                a1.d("ReflectionGuard", "DividerAttributes#isDraggingToFullscreenAllowed is not valid");
            }
        } catch (ClassNotFoundException unused7) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("DividerAttributes#isDraggingToFullscreenAllowed is not valid"));
            zO = false;
        } catch (NoSuchFieldException unused8) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("DividerAttributes#isDraggingToFullscreenAllowed is not valid"));
            zO = false;
        } catch (NoSuchMethodException unused9) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("DividerAttributes#isDraggingToFullscreenAllowed is not valid"));
            zO = false;
        }
        if (!zO) {
            return false;
        }
        try {
            zT = T();
            if (!zT) {
                a1.d("ReflectionGuard", "DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid");
            }
        } catch (ClassNotFoundException unused10) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid"));
            zT = false;
        } catch (NoSuchFieldException unused11) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid"));
            zT = false;
        } catch (NoSuchMethodException unused12) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid"));
            zT = false;
        }
        if (!zT) {
            return false;
        }
        try {
            zP = p();
            if (!zP) {
                a1.d("ReflectionGuard", "Class AnimationParams is not valid");
            }
        } catch (ClassNotFoundException unused13) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class AnimationParams is not valid"));
            zP = false;
        } catch (NoSuchFieldException unused14) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class AnimationParams is not valid"));
            zP = false;
        } catch (NoSuchMethodException unused15) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class AnimationParams is not valid"));
            zP = false;
        }
        if (!zP) {
            return false;
        }
        try {
            zO2 = o();
            if (!zO2) {
                a1.d("ReflectionGuard", "Class AnimationParams.Builder is not valid");
            }
        } catch (ClassNotFoundException unused16) {
            a1.d("ReflectionGuard", "ClassNotFound: ".concat("Class AnimationParams.Builder is not valid"));
            zO2 = false;
        } catch (NoSuchFieldException unused17) {
            a1.d("ReflectionGuard", "NoSuchField: ".concat("Class AnimationParams.Builder is not valid"));
            zO2 = false;
        } catch (NoSuchMethodException unused18) {
            a1.d("ReflectionGuard", "NoSuchMethod: ".concat("Class AnimationParams.Builder is not valid"));
            zO2 = false;
        }
        return zO2;
    }
}
