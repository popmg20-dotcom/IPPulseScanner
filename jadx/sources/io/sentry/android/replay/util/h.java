package io.sentry.android.replay.util;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import defpackage.p44;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final Rect a(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        layoutCoordinates.getClass();
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = layoutCoordinates2 == null ? LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates) : layoutCoordinates2;
        float f = (int) (layoutCoordinatesFindRootCoordinates.getSize-YbymL2g() >> 32);
        float f2 = (int) (layoutCoordinatesFindRootCoordinates.getSize-YbymL2g() & 4294967295L);
        Rect rectLocalBoundingBoxOf = layoutCoordinatesFindRootCoordinates.localBoundingBoxOf(layoutCoordinates, true);
        float left = rectLocalBoundingBoxOf.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > f) {
            left = f;
        }
        float top = rectLocalBoundingBoxOf.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > f2) {
            top = f2;
        }
        float right = rectLocalBoundingBoxOf.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= f) {
            f = right;
        }
        float bottom = rectLocalBoundingBoxOf.getBottom();
        if (bottom < 0.0f) {
            bottom = 0.0f;
        }
        if (bottom <= f2) {
            f2 = bottom;
        }
        if (left == f || top == f2) {
            return new Rect(0.0f, 0.0f, 0.0f, 0.0f);
        }
        long j = layoutCoordinatesFindRootCoordinates.localToWindow-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(left)) << 32) | (((long) Float.floatToRawIntBits(top)) & 4294967295L)));
        long j2 = layoutCoordinatesFindRootCoordinates.localToWindow-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(top)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32)));
        long j3 = layoutCoordinatesFindRootCoordinates.localToWindow-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)));
        long j4 = layoutCoordinatesFindRootCoordinates.localToWindow-MK-Hz9U(Offset.constructor-impl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(left)) << 32)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (j4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (4294967295L & j3));
        return new Rect(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final Painter b(LayoutNode layoutNode) {
        layoutNode.getClass();
        List modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        for (int i = 0; i < size; i++) {
            Modifier modifier = ((ModifierInfo) modifierInfo.get(i)).getModifier();
            if (p44.o0(modifier.getClass().getName(), "Painter", false)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("painter");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    if (obj instanceof Painter) {
                        return (Painter) obj;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static final Color c(LayoutNode layoutNode) {
        layoutNode.getClass();
        List modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            Modifier modifier = ((ModifierInfo) modifierInfo.get(i)).getModifier();
            if (p44.o0(modifier.getClass().getName(), "Text", false)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("color");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    ColorProducer colorProducer = obj instanceof ColorProducer ? (ColorProducer) obj : null;
                    if (colorProducer != null) {
                        return Color.box-impl(colorProducer.invoke-0d7_KjU());
                    }
                } catch (Throwable unused) {
                }
            } else {
                i++;
            }
        }
        return null;
    }

    public static final android.graphics.Rect d(Rect rect) {
        return new android.graphics.Rect((int) Math.floor(rect.getLeft()), (int) Math.floor(rect.getTop()), (int) Math.ceil(rect.getRight()), (int) Math.ceil(rect.getBottom()));
    }
}
