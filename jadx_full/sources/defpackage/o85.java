package defpackage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o85 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ tg5 f;
    public final /* synthetic */ i95 z;

    public /* synthetic */ o85(i95 i95Var, tg5 tg5Var, int i) {
        this.b = i;
        this.f = tg5Var;
        this.z = i95Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        tg5 tg5Var = this.f;
        i95 i95Var = this.z;
        switch (i) {
            case 0:
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                ff5Var.W(tg5Var);
                break;
            case 1:
                ff5 ff5Var2 = i95Var.c;
                ff5Var2.x();
                if (ff5Var2.P0 != null) {
                    ArrayList arrayList = new ArrayList();
                    ff5Var2.Q0 = arrayList;
                    arrayList.addAll(ff5Var2.P0);
                }
                m25 m25Var = ff5Var2.z;
                ff5.R(m25Var);
                k85 k85Var = (k85) m25Var.f;
                String str = tg5Var.b;
                tj4.i(str);
                tj4.f(str);
                m25Var.V0();
                m25Var.W0();
                try {
                    SQLiteDatabase sQLiteDatabaseK1 = m25Var.K1();
                    String[] strArr = {str};
                    int iDelete = sQLiteDatabaseK1.delete("apps", "app_id=?", strArr) + sQLiteDatabaseK1.delete("events", "app_id=?", strArr) + sQLiteDatabaseK1.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseK1.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseK1.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseK1.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseK1.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseK1.delete("queue", "app_id=?", strArr) + sQLiteDatabaseK1.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseK1.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseK1.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseK1.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseK1.delete("upload_queue", "app_id=?", strArr);
                    if (k85Var.A.f1(null, r55.i1)) {
                        iDelete += sQLiteDatabaseK1.delete("no_data_mode_events", "app_id=?", strArr);
                    }
                    if (iDelete > 0) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.H0.c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
                    }
                } catch (SQLiteException e) {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.c("Error resetting analytics data. appId, error", t65.Z0(str), e);
                }
                if (tg5Var.y0) {
                    ff5Var2.W(tg5Var);
                }
                break;
            default:
                ff5 ff5Var3 = i95Var.c;
                ff5Var3.x();
                ff5Var3.l0(tg5Var);
                break;
        }
    }
}
