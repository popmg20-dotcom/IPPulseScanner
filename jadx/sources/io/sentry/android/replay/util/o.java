package io.sentry.android.replay.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import defpackage.e03;
import defpackage.m0;
import io.sentry.ILogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static final e03 a(View view) {
        if (!view.isAttachedToWindow()) {
            return new e03(Boolean.FALSE, null);
        }
        if (view.getWindowVisibility() != 0) {
            return new e03(Boolean.FALSE, null);
        }
        Object parent = view;
        while (parent instanceof View) {
            float transitionAlpha = Build.VERSION.SDK_INT >= 29 ? ((View) parent).getTransitionAlpha() : 1.0f;
            View view2 = (View) parent;
            if (view2.getAlpha() <= 0.0f || transitionAlpha <= 0.0f || view2.getVisibility() != 0) {
                return new e03(Boolean.FALSE, null);
            }
            parent = view2.getParent();
        }
        Rect rect = new Rect();
        return new e03(Boolean.valueOf(view.getGlobalVisibleRect(rect, new Point())), rect);
    }

    public static final void b(View view, io.sentry.android.replay.viewhierarchy.h hVar, m0 m0Var, ILogger iLogger, List list) {
        m0Var.getClass();
        iLogger.getClass();
        if ((view instanceof ViewGroup) && !io.sentry.android.replay.viewhierarchy.b.b(view, hVar, m0Var, iLogger)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    viewGroup.indexOfChild(childAt);
                    io.sentry.android.replay.viewhierarchy.h hVarE = io.sentry.config.a.e(childAt, hVar, m0Var);
                    arrayList.add(hVarE);
                    if (list != null && (hVarE instanceof io.sentry.android.replay.viewhierarchy.f) && hVarE.e) {
                        list.add(hVarE);
                    }
                    b(childAt, hVarE, m0Var, iLogger, list);
                }
            }
            hVar.g = arrayList;
        }
    }
}
