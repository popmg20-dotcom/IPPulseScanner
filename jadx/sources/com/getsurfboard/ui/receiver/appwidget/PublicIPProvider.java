package com.getsurfboard.ui.receiver.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import com.getsurfboard.base.ContextUtilsKt;
import defpackage.ha0;
import defpackage.l72;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PublicIPProvider extends AppWidgetProvider {
    public static final ComponentName a = new ComponentName(ContextUtilsKt.getContext(), (Class<?>) PublicIPProvider.class);

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        ha0.u("type", "public_ip", "widget_removed");
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        ha0.u("type", "public_ip", "widget_added");
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) throws UnknownHostException {
        l72.U();
    }
}
