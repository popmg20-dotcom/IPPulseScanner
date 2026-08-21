package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import defpackage.ed4;
import defpackage.t80;
import defpackage.vo;
import io.sentry.android.core.performance.g;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        g.f(this);
        Context context = getContext();
        if (context == null) {
            t80 t80Var = new t80("Context cannot be null");
            g.g(this);
            throw t80Var;
        }
        if (context.getApplicationContext() != null) {
            ed4 ed4VarC = ed4.C(context);
            Class<?> cls = getClass();
            Context context2 = (Context) ed4VarC.A;
            try {
                try {
                    Trace.beginSection(vo.O("Startup"));
                    ed4VarC.v(context2.getPackageManager().getProviderInfo(new ComponentName(context2, cls), 128).metaData);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new t80(e);
                }
            } finally {
                Trace.endSection();
            }
        }
        g.g(this);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
