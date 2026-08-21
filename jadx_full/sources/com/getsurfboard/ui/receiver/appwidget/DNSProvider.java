package com.getsurfboard.ui.receiver.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import com.getsurfboard.base.ContextUtilsKt;
import defpackage.ha0;
import defpackage.ji0;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DNSProvider extends AppWidgetProvider {
    public static final ComponentName a = new ComponentName(ContextUtilsKt.getContext(), (Class<?>) DNSProvider.class);

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        ha0.u("type", "dns", "widget_removed");
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        ha0.u("type", "dns", "widget_added");
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        ji0.S();
    }
}
