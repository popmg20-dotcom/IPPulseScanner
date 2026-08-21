package defpackage;

import android.appwidget.AppWidgetManager;
import android.os.Build;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rh0 extends v74 implements Function2 {
    public final /* synthetic */ AppWidgetManager X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rh0(AppWidgetManager appWidgetManager, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = appWidgetManager;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((rh0) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new rh0(this.X, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        AppWidgetManager appWidgetManager;
        n12.S(obj);
        return Boolean.valueOf(Build.VERSION.SDK_INT < 26 || (appWidgetManager = this.X) == null || !appWidgetManager.isRequestPinAppWidgetSupported());
    }
}
