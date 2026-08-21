package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k25 extends SQLiteOpenHelper {
    public final /* synthetic */ int b;
    public final /* synthetic */ k70 f;

    public k25(Context context, String str) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        int i = this.b;
        k70 k70Var = this.f;
        switch (i) {
            case 0:
                m25 m25Var = (m25) k70Var;
                k85 k85Var = (k85) m25Var.f;
                x15 x15Var = k85Var.A;
                de5 de5Var = m25Var.y0;
                if (de5Var.a != 0 && SystemClock.elapsedRealtime() - de5Var.a < 3600000) {
                    throw new SQLiteException("Database open failed");
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException unused) {
                    de5Var.getClass();
                    de5Var.a = SystemClock.elapsedRealtime();
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.z0.a("Opening the database failed, dropping and recreating it");
                    if (!k85Var.b.getDatabasePath("google_app_measurement.db").delete()) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b("google_app_measurement.db", "Failed to delete corrupted db file");
                    }
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        de5Var.a = 0L;
                        return writableDatabase;
                    } catch (SQLiteException e) {
                        t65 t65Var3 = k85Var.Y;
                        k85.h(t65Var3);
                        t65Var3.z0.b(e, "Failed to open freshly created database");
                        throw e;
                    }
                }
            default:
                k85 k85Var2 = (k85) ((i65) k70Var).f;
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e2) {
                    throw e2;
                } catch (SQLiteException unused2) {
                    t65 t65Var4 = k85Var2.Y;
                    k85.h(t65Var4);
                    t65Var4.z0.a("Opening the local database failed, dropping and recreating it");
                    if (!k85Var2.b.getDatabasePath("google_app_measurement_local.db").delete()) {
                        t65 t65Var5 = k85Var2.Y;
                        k85.h(t65Var5);
                        t65Var5.z0.b("google_app_measurement_local.db", "Failed to delete corrupted local db file");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e3) {
                        t65 t65Var6 = k85Var2.Y;
                        k85.h(t65Var6);
                        t65Var6.z0.b(e3, "Failed to open local database. Events will bypass local storage");
                        return null;
                    }
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.b;
        k70 k70Var = this.f;
        switch (i) {
            case 0:
                t65 t65Var = ((k85) ((m25) k70Var).f).Y;
                k85.h(t65Var);
                co4.g0(t65Var, sQLiteDatabase);
                break;
            default:
                t65 t65Var2 = ((k85) ((i65) k70Var).f).Y;
                k85.h(t65Var2);
                co4.g0(t65Var2, sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        int i = this.b;
        k70 k70Var = this.f;
        switch (i) {
            case 0:
                k85 k85Var = (k85) ((m25) k70Var).f;
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                co4.f0(t65Var, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", m25.z0);
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "events_snapshot", "CREATE TABLE IF NOT EXISTS events_snapshot ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, last_bundled_timestamp INTEGER, last_bundled_day INTEGER, last_sampled_complex_event_id INTEGER, last_sampling_rate INTEGER, last_exempt_from_sampling INTEGER, current_session_count INTEGER, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp,last_bundled_timestamp,last_bundled_day,last_sampled_complex_event_id,last_sampling_rate,last_exempt_from_sampling,current_session_count", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", m25.B0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", m25.C0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", m25.E0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", m25.D0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", m25.F0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", m25.G0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", m25.H0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", m25.I0);
                mg5.a();
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "trigger_uris", "CREATE TABLE IF NOT EXISTS trigger_uris ( app_id TEXT NOT NULL, trigger_uri TEXT NOT NULL, timestamp_millis INTEGER NOT NULL, source INTEGER NOT NULL);", "app_id,trigger_uri,source,timestamp_millis", m25.J0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "upload_queue", "CREATE TABLE IF NOT EXISTS upload_queue ( app_id TEXT NOT NULL, upload_uri TEXT NOT NULL, upload_headers TEXT NOT NULL, upload_type INTEGER NOT NULL, measurement_batch BLOB NOT NULL, retry_count INTEGER NOT NULL, creation_timestamp INTEGER NOT NULL );", "app_id,upload_uri,upload_headers,upload_type,measurement_batch,retry_count,creation_timestamp", m25.A0);
                k85.h(t65Var2);
                co4.f0(t65Var2, sQLiteDatabase, "no_data_mode_events", "CREATE TABLE IF NOT EXISTS no_data_mode_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, data BLOB NOT NULL, timestamp_millis INTEGER NOT NULL);", "app_id,name,data,timestamp_millis", null);
                break;
            default:
                t65 t65Var3 = ((k85) ((i65) k70Var).f).Y;
                k85.h(t65Var3);
                co4.f0(t65Var3, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", i65.y0);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = this.b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k25(i65 i65Var, Context context) {
        this(context, "google_app_measurement_local.db");
        this.b = 1;
        this.f = i65Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k25(m25 m25Var, Context context) {
        this(context, "google_app_measurement.db");
        this.b = 0;
        this.f = m25Var;
    }

    private final void g(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void n(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void s(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private final void x(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
