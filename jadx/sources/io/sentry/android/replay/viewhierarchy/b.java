package io.sentry.android.replay.viewhierarchy;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.TextUnit;
import defpackage.am1;
import defpackage.d70;
import defpackage.ek0;
import defpackage.m0;
import defpackage.n12;
import defpackage.p44;
import defpackage.z82;
import io.sentry.ILogger;
import io.sentry.android.replay.x;
import io.sentry.p5;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final z82 a = ek0.v(a.f);
    public static boolean b;
    public static WeakReference c;

    public static h a(LayoutNode layoutNode, h hVar, boolean z, m0 m0Var, ILogger iLogger) {
        TextLayoutInput layoutInput;
        TextStyle style;
        TextLayoutInput layoutInput2;
        TextStyle style2;
        AccessibilityAction accessibilityAction;
        am1 am1Var;
        if (!layoutNode.isPlaced() || !layoutNode.isAttached()) {
            return null;
        }
        if (z) {
            c = new WeakReference(LayoutCoordinatesKt.findRootCoordinates(layoutNode.getCoordinates()));
        }
        LayoutCoordinates coordinates = layoutNode.getCoordinates();
        WeakReference weakReference = c;
        Rect rectA = io.sentry.android.replay.util.h.a(coordinates, weakReference != null ? (LayoutCoordinates) weakReference.get() : null);
        try {
            SemanticsConfiguration semanticsConfigurationD = d(layoutNode);
            boolean z2 = !c.c(layoutNode) && (semanticsConfigurationD == null || !semanticsConfigurationD.contains(SemanticsProperties.INSTANCE.getInvisibleToUser())) && rectA.getBottom() - rectA.getTop() > 0.0f && rectA.getRight() - rectA.getLeft() > 0.0f;
            boolean z3 = (semanticsConfigurationD != null && semanticsConfigurationD.contains(SemanticsActions.INSTANCE.getSetText())) || (semanticsConfigurationD != null && semanticsConfigurationD.contains(SemanticsProperties.INSTANCE.getEditableText()));
            if ((semanticsConfigurationD != null && semanticsConfigurationD.contains(SemanticsProperties.INSTANCE.getText())) || z3) {
                boolean z4 = z2 && e(semanticsConfigurationD, false, m0Var);
                ArrayList arrayList = new ArrayList();
                if (semanticsConfigurationD != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfigurationD, SemanticsActions.INSTANCE.getGetTextLayoutResult())) != null && (am1Var = (am1) accessibilityAction.getAction()) != null) {
                }
                TextLayoutResult textLayoutResult = (TextLayoutResult) d70.e0(arrayList);
                Color colorC = (textLayoutResult == null || (layoutInput2 = textLayoutResult.getLayoutInput()) == null || (style2 = layoutInput2.getStyle()) == null) ? null : Color.box-impl(style2.getColor-0d7_KjU());
                if (colorC != null && colorC.unbox-impl() == 16) {
                    colorC = io.sentry.android.replay.util.h.c(layoutNode);
                }
                TextUnit textUnit = (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null || (style = layoutInput.getStyle()) == null) ? null : TextUnit.box-impl(style.getFontSize-XSAIIZE());
                io.sentry.android.replay.util.b bVar = (textLayoutResult == null || z3 || (textUnit != null ? TextUnit.equals-impl0(textUnit.unbox-impl(), TextUnit.Companion.getUnspecified-XSAIIZE()) : false)) ? null : new io.sentry.android.replay.util.b(textLayoutResult);
                Integer numValueOf = colorC != null ? Integer.valueOf(ColorKt.toArgb-8_81llA(colorC.unbox-impl()) | (-16777216)) : null;
                rectA.getLeft();
                rectA.getTop();
                return new g(bVar, numValueOf, 0, 0, layoutNode.getWidth(), layoutNode.getHeight(), hVar.c, hVar, z4, z2, io.sentry.android.replay.util.h.d(rectA));
            }
            Painter painterB = io.sentry.android.replay.util.h.b(layoutNode);
            if (painterB == null) {
                if (z2 && e(semanticsConfigurationD, false, m0Var)) {
                    z = true;
                }
                rectA.getLeft();
                rectA.getTop();
                return new d(layoutNode.getWidth(), layoutNode.getHeight(), hVar.c, hVar, z, z2, io.sentry.android.replay.util.h.d(rectA));
            }
            boolean z5 = z2 && e(semanticsConfigurationD, true, m0Var);
            rectA.getLeft();
            rectA.getTop();
            int width = layoutNode.getWidth();
            int height = layoutNode.getHeight();
            float f = hVar.c;
            if (z5) {
                String name = painterB.getClass().getName();
                if (!p44.o0(name, "Vector", false) && !p44.o0(name, "Color", false) && !p44.o0(name, "Brush", false)) {
                    z = true;
                }
            }
            return new e(width, height, f, hVar, z, z2, io.sentry.android.replay.util.h.d(rectA));
        } catch (Throwable th) {
            if (!b) {
                b = true;
                iLogger.b(p5.ERROR, th, "Error retrieving semantics information from Compose tree. Most likely you're using\nan unsupported version of androidx.compose.ui:ui. The supported\nversion range is 1.5.0 - 1.10.2.\nIf you're using a newer version, please open a github issue with the version\nyou're using, so we can add support for it.", new Object[0]);
            }
            if ("true".equalsIgnoreCase(System.getProperty("io.sentry.replay.compose.fail-fast"))) {
                throw th;
            }
            rectA.getLeft();
            rectA.getTop();
            return new d(layoutNode.getWidth(), layoutNode.getHeight(), hVar.c, hVar, true, !c.c(layoutNode) && rectA.getBottom() - rectA.getTop() > 0.0f && rectA.getRight() - rectA.getLeft() > 0.0f, io.sentry.android.replay.util.h.d(rectA));
        }
    }

    public static boolean b(View view, h hVar, m0 m0Var, ILogger iLogger) {
        m0Var.getClass();
        iLogger.getClass();
        p44.o0(view.getClass().getName(), "AndroidComposeView", false);
        return false;
    }

    public static String c(boolean z, SemanticsConfiguration semanticsConfiguration) {
        return z ? "android.widget.ImageView" : semanticsConfiguration != null ? (semanticsConfiguration.contains(SemanticsProperties.INSTANCE.getText()) || semanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText()) || semanticsConfiguration.contains(SemanticsProperties.INSTANCE.getEditableText())) ? "android.widget.TextView" : "android.view.View" : "android.view.View";
    }

    public static final SemanticsConfiguration d(LayoutNode layoutNode) {
        layoutNode.getClass();
        try {
            return layoutNode.getSemanticsConfiguration();
        } catch (Throwable th) {
            z82 z82Var = a;
            if (((Method) z82Var.getValue()) == null) {
                throw th;
            }
            Method method = (Method) z82Var.getValue();
            method.getClass();
            return (SemanticsConfiguration) method.invoke(layoutNode, null);
        }
    }

    public static boolean e(SemanticsConfiguration semanticsConfiguration, boolean z, m0 m0Var) {
        String str = semanticsConfiguration != null ? (String) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, x.a) : null;
        if (n12.c(str, "unmask")) {
            m0Var.y();
            return false;
        }
        if (n12.c(str, "mask")) {
            m0Var.y();
            return true;
        }
        String strC = c(z, semanticsConfiguration);
        if (((CopyOnWriteArraySet) m0Var.b).contains(strC)) {
            return false;
        }
        return ((CopyOnWriteArraySet) m0Var.a).contains(strC);
    }

    public static void f(LayoutNode layoutNode, h hVar, boolean z, m0 m0Var, ILogger iLogger) throws IllegalAccessException, InvocationTargetException {
        List listA = c.a(layoutNode);
        if (listA.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(listA.size());
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = (LayoutNode) listA.get(i);
            h hVarA = a(layoutNode2, hVar, z, m0Var, iLogger);
            if (hVarA != null) {
                arrayList.add(hVarA);
                f(layoutNode2, hVarA, false, m0Var, iLogger);
            }
        }
        hVar.g = arrayList;
    }
}
