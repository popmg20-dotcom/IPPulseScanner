package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m25 extends pe5 {
    public final k25 Z;
    public final de5 y0;
    public static final String[] z0 = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] A0 = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    public static final String[] B0 = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] C0 = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    public static final String[] D0 = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] E0 = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] F0 = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] G0 = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] H0 = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public static final String[] I0 = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    public static final String[] J0 = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    public m25(ff5 ff5Var) {
        super(ff5Var);
        this.y0 = new de5(((k85) this.f).B0);
        x15 x15Var = ((k85) this.f).A;
        this.Z = new k25(this, ((k85) this.f).b);
    }

    public static final void E1(ContentValues contentValues, Object obj) {
        tj4.f("value");
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
            return;
        }
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            xe.k("Invalid value type");
        }
    }

    public static final String y1(List list) {
        return list.isEmpty() ? "" : ha0.o(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    public final t95 A1(String str) {
        tj4.i(str);
        V0();
        W0();
        return t95.c(100, r1("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    public final w25 B1(String str, w75 w75Var, String str2) {
        w25 w25VarT1 = t1("events", str, w75Var.q());
        if (w25VarT1 != null) {
            long j = w25VarT1.e + 1;
            long j2 = w25VarT1.d + 1;
            return new w25(w25VarT1.a, w25VarT1.b, w25VarT1.c + 1, j2, j, w25VarT1.f, w25VarT1.g, w25VarT1.h, w25VarT1.i, w25VarT1.j, w25VarT1.k);
        }
        k85 k85Var = (k85) this.f;
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.C0.c("Event aggregate wasn't created during raw event logging. appId, event", t65.Z0(str), k85Var.A0.a(str2));
        return new w25(str, w75Var.q(), 1L, 1L, 1L, w75Var.s(), 0L, null, null, null, null);
    }

    public final boolean C1() {
        return ((k85) this.f).b.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7 A[Catch: all -> 0x0079, SQLiteException -> 0x007b, TryCatch #5 {all -> 0x0079, blocks: (B:15:0x0065, B:18:0x006d, B:19:0x0071, B:45:0x00cf, B:47:0x00f7, B:48:0x0109, B:49:0x010d, B:50:0x011d, B:52:0x0123, B:53:0x0133, B:56:0x0146, B:68:0x016d, B:71:0x0175, B:77:0x0194, B:61:0x015c, B:75:0x0186, B:76:0x018f, B:98:0x0220, B:40:0x00bf, B:43:0x00c7), top: B:118:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109 A[Catch: all -> 0x0079, SQLiteException -> 0x007b, TRY_LEAVE, TryCatch #5 {all -> 0x0079, blocks: (B:15:0x0065, B:18:0x006d, B:19:0x0071, B:45:0x00cf, B:47:0x00f7, B:48:0x0109, B:49:0x010d, B:50:0x011d, B:52:0x0123, B:53:0x0133, B:56:0x0146, B:68:0x016d, B:71:0x0175, B:77:0x0194, B:61:0x015c, B:75:0x0186, B:76:0x018f, B:98:0x0220, B:40:0x00bf, B:43:0x00c7), top: B:118:0x0025 }] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D1(String str, long j, long j2, sb1 sb1Var) throws Throwable {
        ?? r9;
        ?? r4;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseK1;
        ?? IsEmpty;
        String[] strArr;
        String str2;
        String string;
        ?? r42;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String str3;
        v75 v75Var;
        long j3;
        String string2;
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        Cursor cursorQuery = null;
        cursorQuery = null;
        ?? r7 = 0;
        try {
            try {
                sQLiteDatabaseK1 = K1();
                IsEmpty = TextUtils.isEmpty(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e) {
            e = e;
            r9 = str;
        }
        try {
            if (IsEmpty != 0) {
                String[] strArr5 = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                str2 = j2 != -1 ? "rowid <= ? and " : "";
                StringBuilder sb = new StringBuilder(str2.length() + 148);
                sb.append("select app_id, metadata_fingerprint from raw_events where ");
                sb.append(str2);
                sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                cursorRawQuery = sQLiteDatabaseK1.rawQuery(sb.toString(), strArr5);
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    string2 = str;
                }
                if (cursorRawQuery.moveToFirst()) {
                    string2 = cursorRawQuery.getString(0);
                    try {
                        string = cursorRawQuery.getString(1);
                        cursorRawQuery.close();
                        r42 = string2;
                        cursorRawQuery = sQLiteDatabaseK1.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{r42, string}, null, null, "rowid", "2");
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursorQuery = cursorRawQuery;
                        r4 = string2;
                    }
                    if (cursorRawQuery.moveToFirst()) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.b(t65.Z0(r42), "Raw event metadata record is missing. appId");
                    } else {
                        try {
                            n85 n85Var = (n85) ((l85) z65.I1(n85.S(), cursorRawQuery.getBlob(0))).e();
                            if (cursorRawQuery.moveToNext()) {
                                t65 t65Var2 = k85Var.Y;
                                k85.h(t65Var2);
                                t65Var2.C0.b(t65.Z0(r42), "Get multiple raw event metadata records, expected one. appId");
                            }
                            cursorRawQuery.close();
                            sb1Var.f = n85Var;
                            if (k85Var.A.f1(null, r55.l1)) {
                                long jG1 = G1("select (rowid - 1) as max_rowid from raw_events where app_id = ? and metadata_fingerprint != ? order by rowid limit 1;", new String[]{r42, string}, -1L);
                                if (j2 != -1) {
                                    j3 = j2;
                                } else if (jG1 != -1) {
                                    j3 = -1;
                                } else {
                                    strArr2 = new String[]{r42, string};
                                    strArr4 = strArr2;
                                    str3 = "app_id = ? and metadata_fingerprint = ?";
                                }
                                if (j3 != -1 && jG1 != -1) {
                                    jG1 = Math.min(j3, jG1);
                                } else if (j3 != -1) {
                                    jG1 = j3;
                                }
                                strArr3 = new String[]{r42, string, String.valueOf(jG1)};
                                strArr4 = strArr3;
                                str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                            } else if (j2 != -1) {
                                strArr3 = new String[]{r42, string, String.valueOf(j2)};
                                strArr4 = strArr3;
                                str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                            } else {
                                strArr2 = new String[]{r42, string};
                                strArr4 = strArr2;
                                str3 = "app_id = ? and metadata_fingerprint = ?";
                            }
                            cursorQuery = sQLiteDatabaseK1.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str3, strArr4, null, null, "rowid", null);
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    do {
                                        long j4 = cursorQuery.getLong(0);
                                        try {
                                            v75Var = (v75) z65.I1(w75.x(), cursorQuery.getBlob(3));
                                            String string3 = cursorQuery.getString(1);
                                            v75Var.c();
                                            ((w75) v75Var.f).D(string3);
                                            long j5 = cursorQuery.getLong(2);
                                            v75Var.c();
                                            ((w75) v75Var.f).E(j5);
                                        } catch (IOException e4) {
                                            t65 t65Var3 = k85Var.Y;
                                            k85.h(t65Var3);
                                            t65Var3.z0.c("Data loss. Failed to merge raw event. appId", t65.Z0(r42), e4);
                                        }
                                        if (!sb1Var.d(j4, (w75) v75Var.e())) {
                                            break;
                                        }
                                    } while (cursorQuery.moveToNext());
                                } else {
                                    t65 t65Var4 = k85Var.Y;
                                    k85.h(t65Var4);
                                    t65Var4.C0.b(t65.Z0(r42), "Raw event data disappeared while in transaction. appId");
                                }
                            } catch (SQLiteException e5) {
                                e = e5;
                                r4 = r42;
                                t65 t65Var5 = k85Var.Y;
                                k85.h(t65Var5);
                                t65Var5.z0.c("Data loss. Error selecting raw event. appId", t65.Z0(r4), e);
                            }
                            cursorRawQuery = cursorQuery;
                        } catch (IOException e6) {
                            t65 t65Var6 = k85Var.Y;
                            k85.h(t65Var6);
                            t65Var6.z0.c("Data loss. Failed to merge raw event metadata. appId", t65.Z0(r42), e6);
                        }
                    }
                }
                cursorQuery = cursorRawQuery;
                r4 = string2;
                t65 t65Var52 = k85Var.Y;
                k85.h(t65Var52);
                t65Var52.z0.c("Data loss. Error selecting raw event. appId", t65.Z0(r4), e);
                cursorRawQuery = cursorQuery;
            } else {
                try {
                    if (j2 != -1) {
                        String str4 = str;
                        strArr = new String[]{str4, String.valueOf(j2)};
                        IsEmpty = str4;
                    } else {
                        String str5 = str;
                        strArr = new String[]{str5};
                        IsEmpty = str5;
                    }
                    str2 = j2 != -1 ? " and rowid <= ?" : "";
                    StringBuilder sb2 = new StringBuilder(str2.length() + 84);
                    sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb2.append(str2);
                    sb2.append(" order by rowid limit 1;");
                    cursorRawQuery = sQLiteDatabaseK1.rawQuery(sb2.toString(), strArr);
                } catch (SQLiteException e7) {
                    e = e7;
                    r9 = IsEmpty;
                }
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        r42 = IsEmpty;
                        cursorRawQuery = sQLiteDatabaseK1.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{r42, string}, null, null, "rowid", "2");
                        if (cursorRawQuery.moveToFirst()) {
                        }
                    }
                } catch (SQLiteException e8) {
                    e = e8;
                    cursorQuery = cursorRawQuery;
                    r9 = IsEmpty;
                    r4 = r9;
                }
                t65 t65Var522 = k85Var.Y;
                k85.h(t65Var522);
                t65Var522.z0.c("Data loss. Error selecting raw event. appId", t65.Z0(r4), e);
                cursorRawQuery = cursorQuery;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            r7 = " order by rowid limit 1;";
            if (r7 != 0) {
                r7.close();
            }
            throw th;
        }
    }

    public final long F1(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = K1().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long G1(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = K1().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void H1() {
        W0();
        K1().beginTransaction();
    }

    public final void I1() {
        W0();
        K1().setTransactionSuccessful();
    }

    public final void J1() {
        W0();
        K1().endTransaction();
    }

    public final SQLiteDatabase K1() {
        V0();
        try {
            return this.Z.getWritableDatabase();
        } catch (SQLiteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.b(e, "Error opening database");
            throw e;
        }
    }

    public final void L1(String str) {
        w25 w25VarT1;
        v1("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = K1().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (w25VarT1 = t1("events", str, string)) != null) {
                            u1("events_snapshot", w25VarT1);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.c("Error creating snapshot. appId", t65.Z0(str), e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M1(String str) throws Throwable {
        boolean z;
        w25 w25VarT1;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        w25 w25VarT12 = t1("events", str, "_f");
        w25 w25VarT13 = t1("events", str, "_v");
        v1("events", str);
        Cursor cursorQuery = null;
        boolean z2 = false;
        try {
            cursorQuery = K1().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            e = e;
            z = false;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (!cursorQuery.moveToFirst()) {
            cursorQuery.close();
            if (w25VarT12 != null) {
                u1("events", w25VarT12);
            } else if (w25VarT13 != null) {
                u1("events", w25VarT13);
            }
            v1("events_snapshot", str);
        }
        boolean z3 = false;
        z = false;
        do {
            try {
                String string = cursorQuery.getString(0);
                if (cursorQuery.getLong(1) >= 1) {
                    if ("_f".equals(string)) {
                        z3 = true;
                    } else if ("_v".equals(string)) {
                        z = true;
                    }
                }
                if (string != null && (w25VarT1 = t1("events_snapshot", str, string)) != null) {
                    u1("events", w25VarT1);
                }
            } catch (SQLiteException e2) {
                e = e2;
                z2 = z3;
                try {
                    t65 t65Var = ((k85) this.f).Y;
                    k85.h(t65Var);
                    t65Var.z0.c("Error querying snapshot. appId", t65.Z0(str), e);
                    z3 = z2;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (z2 && w25VarT12 != null) {
                        u1("events", w25VarT12);
                    } else if (!z && w25VarT13 != null) {
                        u1("events", w25VarT13);
                    }
                    v1("events_snapshot", str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = z3;
                if (cursorQuery != null) {
                }
                if (z2) {
                    if (!z) {
                        u1("events", w25VarT13);
                    }
                }
                v1("events_snapshot", str);
                throw th;
            }
        } while (cursorQuery.moveToNext());
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (z3 || w25VarT12 == null) {
            if (!z && w25VarT13 != null) {
            }
        }
        v1("events_snapshot", str);
    }

    public final void N1(String str, String str2) {
        tj4.f(str);
        tj4.f(str2);
        V0();
        W0();
        try {
            K1().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            k85 k85Var = (k85) this.f;
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.d("Error deleting user property. appId", t65.Z0(str), k85Var.A0.c(str2), e);
        }
    }

    public final boolean O1(mf5 mf5Var) {
        k85 k85Var = (k85) this.f;
        String str = mf5Var.b;
        V0();
        W0();
        String str2 = mf5Var.a;
        String str3 = mf5Var.c;
        if (P1(str2, str3) == null) {
            if (qf5.V1(str3)) {
                if (F1("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str2}) >= Math.max(Math.min(k85Var.A.d1(str2, r55.W), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str3)) {
                long jF1 = F1("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str2, str});
                x15 x15Var = k85Var.A;
                if (jF1 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str2);
        contentValues.put("origin", str);
        contentValues.put("name", str3);
        contentValues.put("set_timestamp", Long.valueOf(mf5Var.d));
        E1(contentValues, mf5Var.e);
        try {
            if (K1().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(t65.Z0(str2), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.c("Error storing user property. appId", t65.Z0(str2), e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final mf5 P1(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        tj4.f(str2);
        V0();
        W0();
        Cursor cursor = null;
        try {
            cursorQuery = K1().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            } catch (SQLiteException e) {
                e = e;
                str3 = str;
                str4 = str2;
            }
        } catch (SQLiteException e2) {
            str3 = str;
            str4 = str2;
            sQLiteException = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
        }
        if (cursorQuery.moveToFirst()) {
            long j = cursorQuery.getLong(0);
            Object objI1 = i1(cursorQuery, 1);
            if (objI1 != null) {
                str3 = str;
                str4 = str2;
                try {
                    mf5 mf5Var = new mf5(str3, cursorQuery.getString(2), str4, j, objI1);
                    if (cursorQuery.moveToNext()) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.b(t65.Z0(str3), "Got multiple records for user property, expected one. appId");
                    }
                    cursorQuery.close();
                    return mf5Var;
                } catch (SQLiteException e3) {
                    e = e3;
                }
            }
            sQLiteException = e;
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.d("Error querying user property. appId", t65.Z0(str3), k85Var.A0.c(str4), sQLiteException);
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    public final List Q1(String str) {
        String str2;
        SQLiteException sQLiteException;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        V0();
        W0();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                x15 x15Var = k85Var.A;
                cursorQuery = K1().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str3 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objI1 = i1(cursorQuery, 3);
                        if (objI1 == null) {
                            try {
                                t65 t65Var = k85Var.Y;
                                k85.h(t65Var);
                                t65Var.z0.b(t65.Z0(str), "Read invalid user property value, ignoring it. appId");
                                str2 = str;
                            } catch (SQLiteException e) {
                                sQLiteException = e;
                                str2 = str;
                                t65 t65Var2 = k85Var.Y;
                                k85.h(t65Var2);
                                t65Var2.z0.c("Error querying user properties. appId", t65.Z0(str2), sQLiteException);
                                arrayList = Collections.EMPTY_LIST;
                            }
                        } else {
                            str2 = str;
                            try {
                                arrayList.add(new mf5(str2, str3, string, j, objI1));
                            } catch (SQLiteException e2) {
                                e = e2;
                                sQLiteException = e;
                                t65 t65Var22 = k85Var.Y;
                                k85.h(t65Var22);
                                t65Var22.z0.c("Error querying user properties. appId", t65.Z0(str2), sQLiteException);
                                arrayList = Collections.EMPTY_LIST;
                            }
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        str = str2;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                str2 = str;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b0, code lost:
    
        defpackage.k85.h(r13);
        r13.z0.b(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List R1(String str, String str2, String str3) throws Throwable {
        Cursor cursor;
        String str4;
        Cursor cursorQuery;
        String str5;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        V0();
        W0();
        ?? arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList(3);
            String str6 = str;
            arrayList2.add(str6);
            StringBuilder sb = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                sb.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1);
                sb2.append(str3);
                sb2.append(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
                arrayList2.add(sb2.toString());
                sb.append(" and name glob ?");
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String string = sb.toString();
            x15 x15Var = k85Var.A;
            t65 t65Var = k85Var.Y;
            cursorQuery = K1().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, string, strArr, null, null, "rowid", "1001");
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        str4 = str2;
                        while (true) {
                            try {
                                if (arrayList.size() >= 1000) {
                                    break;
                                }
                                String string2 = cursorQuery.getString(0);
                                long j = cursorQuery.getLong(1);
                                Object objI1 = i1(cursorQuery, 2);
                                String string3 = cursorQuery.getString(3);
                                if (objI1 == null) {
                                    try {
                                        k85.h(t65Var);
                                        t65Var.z0.d("(2)Read invalid user property value, ignoring it", t65.Z0(str6), string3, str3);
                                        str5 = string3;
                                    } catch (SQLiteException e) {
                                        e = e;
                                        str5 = string3;
                                        cursor = cursorQuery;
                                        str4 = str5;
                                        try {
                                            t65 t65Var2 = k85Var.Y;
                                            k85.h(t65Var2);
                                            t65Var2.z0.d("(2)Error querying user properties", t65.Z0(str), str4, e);
                                            arrayList = Collections.EMPTY_LIST;
                                            cursorQuery = cursor;
                                        } catch (Throwable th) {
                                            th = th;
                                            if (cursor != null) {
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    str5 = string3;
                                    try {
                                        arrayList.add(new mf5(str, str5, string2, j, objI1));
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursor = cursorQuery;
                                        str4 = str5;
                                        t65 t65Var22 = k85Var.Y;
                                        k85.h(t65Var22);
                                        t65Var22.z0.d("(2)Error querying user properties", t65.Z0(str), str4, e);
                                        arrayList = Collections.EMPTY_LIST;
                                        cursorQuery = cursor;
                                    }
                                }
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                str6 = str;
                                str4 = str5;
                            } catch (SQLiteException e3) {
                                e = e3;
                                cursor = cursorQuery;
                                t65 t65Var222 = k85Var.Y;
                                k85.h(t65Var222);
                                t65Var222.z0.d("(2)Error querying user properties", t65.Z0(str), str4, e);
                                arrayList = Collections.EMPTY_LIST;
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                }
                                return arrayList;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                str4 = str2;
            }
        } catch (SQLiteException e5) {
            e = e5;
            str4 = str2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    public final boolean S1(q15 q15Var) {
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        String str = q15Var.b;
        tj4.i(str);
        if (P1(str, q15Var.z.f) == null) {
            long jF1 = F1("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            x15 x15Var = k85Var.A;
            if (jF1 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", q15Var.f);
        contentValues.put("name", q15Var.z.f);
        Object objA = q15Var.z.a();
        tj4.i(objA);
        E1(contentValues, objA);
        contentValues.put("active", Boolean.valueOf(q15Var.X));
        contentValues.put("trigger_event_name", q15Var.Y);
        contentValues.put("trigger_timeout", Long.valueOf(q15Var.y0));
        z25 z25Var = q15Var.Z;
        qf5 qf5Var = k85Var.z0;
        t65 t65Var = k85Var.Y;
        k85.f(qf5Var);
        contentValues.put("timed_out_event", qf5.B1(z25Var));
        contentValues.put("creation_timestamp", Long.valueOf(q15Var.A));
        k85.f(qf5Var);
        contentValues.put("triggered_event", qf5.B1(q15Var.z0));
        contentValues.put("triggered_timestamp", Long.valueOf(q15Var.z.z));
        contentValues.put("time_to_live", Long.valueOf(q15Var.A0));
        contentValues.put("expired_event", qf5.B1(q15Var.B0));
        try {
            if (K1().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            k85.h(t65Var);
            t65Var.z0.b(t65.Z0(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e) {
            k85.h(t65Var);
            t65Var.z0.c("Error storing conditional user property", t65.Z0(str), e);
            return true;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00f0: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:241), block:B:29:0x00f0 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final q15 T1(String str, String str2) throws Throwable {
        String str3;
        Cursor cursorQuery;
        Cursor cursor;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        tj4.f(str2);
        V0();
        W0();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = K1().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    str3 = str2;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            str3 = str2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (!cursorQuery.moveToFirst()) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        String string = cursorQuery.getString(0);
        if (string == null) {
            string = "";
        }
        String str4 = string;
        Object objI1 = i1(cursorQuery, 1);
        boolean z = cursorQuery.getInt(2) != 0;
        String string2 = cursorQuery.getString(3);
        long j = cursorQuery.getLong(4);
        z65 z65Var = this.X.Z;
        ff5.R(z65Var);
        byte[] blob = cursorQuery.getBlob(5);
        Parcelable.Creator<z25> creator = z25.CREATOR;
        z25 z25Var = (z25) z65Var.A1(blob, creator);
        long j2 = cursorQuery.getLong(6);
        ff5.R(z65Var);
        z25 z25Var2 = (z25) z65Var.A1(cursorQuery.getBlob(7), creator);
        long j3 = cursorQuery.getLong(8);
        long j4 = cursorQuery.getLong(9);
        ff5.R(z65Var);
        str3 = str2;
        try {
            q15 q15Var = new q15(str, str4, new kf5(j3, objI1, str3, str4), j2, z, string2, z25Var, j, z25Var2, j4, (z25) z65Var.A1(cursorQuery.getBlob(10), creator));
            if (cursorQuery.moveToNext()) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.z0.c("Got multiple records for conditional property, expected one", t65.Z0(str), k85Var.A0.c(str3));
            }
            cursorQuery.close();
            return q15Var;
        } catch (SQLiteException e3) {
            e = e3;
        }
        t65 t65Var2 = k85Var.Y;
        k85.h(t65Var2);
        t65Var2.z0.d("Error querying conditional property", t65.Z0(str), k85Var.A0.c(str3), e);
        if (cursorQuery != null) {
        }
        return null;
    }

    public final void U1(String str, String str2) {
        tj4.f(str);
        tj4.f(str2);
        V0();
        W0();
        try {
            K1().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            k85 k85Var = (k85) this.f;
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.d("Error deleting conditional property", t65.Z0(str), k85Var.A0.c(str2), e);
        }
    }

    public final List V1(String str, String str2, String str3) {
        tj4.f(str);
        V0();
        W0();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD));
            sb.append(" and name glob ?");
        }
        return W1(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0054, code lost:
    
        r0 = r1.Y;
        defpackage.k85.h(r0);
        r0.z0.b(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List W1(String str, String[] strArr) {
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                x15 x15Var = k85Var.A;
                cursorQuery = K1().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        if (arrayList.size() >= 1000) {
                            break;
                        }
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        String string3 = cursorQuery.getString(2);
                        Object objI1 = i1(cursorQuery, 3);
                        boolean z = cursorQuery.getInt(4) != 0;
                        String string4 = cursorQuery.getString(5);
                        long j = cursorQuery.getLong(6);
                        z65 z65Var = this.X.Z;
                        ff5.R(z65Var);
                        byte[] blob = cursorQuery.getBlob(7);
                        Parcelable.Creator<z25> creator = z25.CREATOR;
                        z25 z25Var = (z25) z65Var.A1(blob, creator);
                        long j2 = cursorQuery.getLong(8);
                        ff5.R(z65Var);
                        z25 z25Var2 = (z25) z65Var.A1(cursorQuery.getBlob(9), creator);
                        long j3 = cursorQuery.getLong(10);
                        long j4 = cursorQuery.getLong(11);
                        ff5.R(z65Var);
                        arrayList.add(new q15(string, string2, new kf5(j3, objI1, string3, string2), j2, z, string4, z25Var, j, z25Var2, j4, (z25) z65Var.A1(cursorQuery.getBlob(12), creator)));
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    }
                }
            } catch (SQLiteException e) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.z0.b(e, "Error querying conditional user property value");
                arrayList = Collections.EMPTY_LIST;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x03ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b75 X1(String str) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        String string;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        V0();
        W0();
        Cursor cursor = null;
        try {
            cursorQuery = K1().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        ff5 ff5Var = this.X;
                        b75 b75Var = new b75(ff5Var.C0, str);
                        k85 k85Var2 = b75Var.a;
                        t95 t95VarA = ff5Var.a(str);
                        r95 r95Var = r95.ANALYTICS_STORAGE;
                        if (t95VarA.i(r95Var)) {
                            b75Var.F(cursorQuery.getString(0));
                        }
                        boolean z = true;
                        b75Var.H(cursorQuery.getString(1));
                        if (ff5Var.a(str).i(r95.AD_STORAGE)) {
                            b75Var.I(cursorQuery.getString(2));
                        }
                        b75Var.e(cursorQuery.getLong(3));
                        b75Var.L(cursorQuery.getLong(4));
                        b75Var.M(cursorQuery.getLong(5));
                        b75Var.O(cursorQuery.getString(6));
                        b75Var.R(cursorQuery.getString(7));
                        b75Var.S(cursorQuery.getLong(8));
                        b75Var.a(cursorQuery.getLong(9));
                        b75Var.d(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                        b75Var.i(cursorQuery.getLong(11));
                        b75Var.j(cursorQuery.getLong(12));
                        b75Var.k(cursorQuery.getLong(13));
                        b75Var.l(cursorQuery.getLong(14));
                        b75Var.f(cursorQuery.getLong(15));
                        b75Var.g(cursorQuery.getLong(16));
                        b75Var.Q(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                        b75Var.K(cursorQuery.getString(18));
                        b75Var.n(cursorQuery.getLong(19));
                        b75Var.m(cursorQuery.getLong(20));
                        b75Var.v(cursorQuery.getString(21));
                        boolean z2 = cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0;
                        f85 f85Var = k85Var2.Z;
                        k85.h(f85Var);
                        f85Var.V0();
                        b75Var.Q |= b75Var.p != z2;
                        b75Var.p = z2;
                        b75Var.c(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                        if (!cursorQuery.isNull(26)) {
                            b75Var.x(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                        }
                        if (ff5Var.a(str).i(r95Var)) {
                            String string2 = cursorQuery.getString(28);
                            f85 f85Var2 = k85Var2.Z;
                            k85.h(f85Var2);
                            f85Var2.V0();
                            b75Var.Q |= !Objects.equals(b75Var.t, string2);
                            b75Var.t = string2;
                        }
                        boolean z3 = (cursorQuery.isNull(29) || cursorQuery.getInt(29) == 0) ? false : true;
                        f85 f85Var3 = k85Var2.Z;
                        k85.h(f85Var3);
                        f85Var3.V0();
                        b75Var.Q |= b75Var.u != z3;
                        b75Var.u = z3;
                        b75Var.r(cursorQuery.getLong(39));
                        String string3 = cursorQuery.getString(36);
                        f85 f85Var4 = k85Var2.Z;
                        k85.h(f85Var4);
                        f85Var4.V0();
                        b75Var.Q |= b75Var.C != string3;
                        b75Var.C = string3;
                        b75Var.z(cursorQuery.getLong(30));
                        b75Var.A(cursorQuery.getLong(31));
                        mg5.a();
                        if (k85Var.A.f1(str, r55.Q0)) {
                            int i = cursorQuery.getInt(32);
                            f85 f85Var5 = k85Var2.Z;
                            k85.h(f85Var5);
                            f85Var5.V0();
                            b75Var.Q |= b75Var.x != i;
                            b75Var.x = i;
                            b75Var.B(cursorQuery.getLong(35));
                        }
                        boolean z4 = (cursorQuery.isNull(33) || cursorQuery.getInt(33) == 0) ? false : true;
                        f85 f85Var6 = k85Var2.Z;
                        k85.h(f85Var6);
                        f85Var6.V0();
                        b75Var.Q |= b75Var.y != z4;
                        b75Var.y = z4;
                        if (cursorQuery.isNull(34)) {
                            boolValueOf = null;
                        } else {
                            boolValueOf = Boolean.valueOf(cursorQuery.getInt(34) != 0);
                        }
                        f85 f85Var7 = k85Var2.Z;
                        k85.h(f85Var7);
                        f85Var7.V0();
                        b75Var.Q |= !Objects.equals(b75Var.q, boolValueOf);
                        b75Var.q = boolValueOf;
                        b75Var.p(cursorQuery.getInt(37));
                        b75Var.q(cursorQuery.getInt(38));
                        if (cursorQuery.isNull(40)) {
                            string = "";
                        } else {
                            string = cursorQuery.getString(40);
                            tj4.i(string);
                        }
                        f85 f85Var8 = k85Var2.Z;
                        k85.h(f85Var8);
                        f85Var8.V0();
                        b75Var.Q |= b75Var.G != string;
                        b75Var.G = string;
                        if (!cursorQuery.isNull(41)) {
                            Long lValueOf = Long.valueOf(cursorQuery.getLong(41));
                            f85 f85Var9 = k85Var2.Z;
                            k85.h(f85Var9);
                            f85Var9.V0();
                            b75Var.Q |= !Objects.equals(b75Var.z, lValueOf);
                            b75Var.z = lValueOf;
                        }
                        if (!cursorQuery.isNull(42)) {
                            Long lValueOf2 = Long.valueOf(cursorQuery.getLong(42));
                            f85 f85Var10 = k85Var2.Z;
                            k85.h(f85Var10);
                            f85Var10.V0();
                            b75Var.Q |= !Objects.equals(b75Var.A, lValueOf2);
                            b75Var.A = lValueOf2;
                        }
                        byte[] blob = cursorQuery.getBlob(43);
                        f85 f85Var11 = k85Var2.Z;
                        k85.h(f85Var11);
                        f85Var11.V0();
                        b75Var.Q |= b75Var.H != blob;
                        b75Var.H = blob;
                        if (!cursorQuery.isNull(44)) {
                            int i2 = cursorQuery.getInt(44);
                            f85 f85Var12 = k85Var2.Z;
                            k85.h(f85Var12);
                            f85Var12.V0();
                            boolean z5 = b75Var.Q;
                            if (b75Var.I == i2) {
                                z = false;
                            }
                            b75Var.Q = z | z5;
                            b75Var.I = i2;
                        }
                        f85 f85Var13 = k85Var2.Z;
                        k85.h(f85Var13);
                        f85Var13.V0();
                        b75Var.Q = false;
                        if (cursorQuery.moveToNext()) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.z0.b(t65.Z0(str), "Got multiple records for app, expected one. appId");
                        }
                        cursorQuery.close();
                        return b75Var;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.c("Error querying app. appId", t65.Z0(str), e);
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final void Y1(b75 b75Var, boolean z) {
        k85 k85Var = (k85) this.f;
        k85 k85Var2 = b75Var.a;
        V0();
        W0();
        String strD = b75Var.D();
        tj4.i(strD);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strD);
        r95 r95Var = r95.ANALYTICS_STORAGE;
        ff5 ff5Var = this.X;
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (ff5Var.a(strD).i(r95Var)) {
            contentValues.put("app_instance_id", b75Var.E());
        }
        contentValues.put("gmp_app_id", b75Var.G());
        if (ff5Var.a(strD).i(r95.AD_STORAGE)) {
            f85 f85Var = k85Var2.Z;
            k85.h(f85Var);
            f85Var.V0();
            contentValues.put("resettable_device_id_hash", b75Var.e);
        }
        f85 f85Var2 = k85Var2.Z;
        k85.h(f85Var2);
        f85Var2.V0();
        contentValues.put("last_bundle_index", Long.valueOf(b75Var.g));
        f85 f85Var3 = k85Var2.Z;
        k85.h(f85Var3);
        f85Var3.V0();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b75Var.h));
        f85 f85Var4 = k85Var2.Z;
        k85.h(f85Var4);
        f85Var4.V0();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b75Var.i));
        contentValues.put("app_version", b75Var.N());
        f85 f85Var5 = k85Var2.Z;
        k85.h(f85Var5);
        f85Var5.V0();
        contentValues.put("app_store", b75Var.l);
        f85 f85Var6 = k85Var2.Z;
        k85.h(f85Var6);
        f85Var6.V0();
        contentValues.put("gmp_version", Long.valueOf(b75Var.m));
        f85 f85Var7 = k85Var2.Z;
        k85.h(f85Var7);
        f85Var7.V0();
        contentValues.put("dev_cert_hash", Long.valueOf(b75Var.n));
        f85 f85Var8 = k85Var2.Z;
        k85.h(f85Var8);
        f85Var8.V0();
        contentValues.put("measurement_enabled", Boolean.valueOf(b75Var.o));
        f85 f85Var9 = k85Var2.Z;
        f85 f85Var10 = k85Var2.Z;
        k85.h(f85Var9);
        f85Var9.V0();
        contentValues.put("day", Long.valueOf(b75Var.J));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_public_events_count", Long.valueOf(b75Var.K));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_events_count", Long.valueOf(b75Var.L));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_conversions_count", Long.valueOf(b75Var.M));
        f85 f85Var11 = k85Var2.Z;
        k85.h(f85Var11);
        f85Var11.V0();
        contentValues.put("config_fetched_time", Long.valueOf(b75Var.R));
        f85 f85Var12 = k85Var2.Z;
        k85.h(f85Var12);
        f85Var12.V0();
        contentValues.put("failed_config_fetch_time", Long.valueOf(b75Var.S));
        contentValues.put("app_version_int", Long.valueOf(b75Var.P()));
        contentValues.put("firebase_instance_id", b75Var.J());
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_error_events_count", Long.valueOf(b75Var.N));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_realtime_events_count", Long.valueOf(b75Var.O));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("health_monitor_sample", b75Var.P);
        contentValues.put("android_id", (Long) 0L);
        f85 f85Var13 = k85Var2.Z;
        k85.h(f85Var13);
        f85Var13.V0();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(b75Var.p));
        contentValues.put("dynamite_version", Long.valueOf(b75Var.b()));
        if (ff5Var.a(strD).i(r95Var)) {
            f85 f85Var14 = k85Var2.Z;
            k85.h(f85Var14);
            f85Var14.V0();
            contentValues.put("session_stitching_token", b75Var.t);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(b75Var.y()));
        f85 f85Var15 = k85Var2.Z;
        k85.h(f85Var15);
        f85Var15.V0();
        contentValues.put("target_os_version", Long.valueOf(b75Var.v));
        f85 f85Var16 = k85Var2.Z;
        k85.h(f85Var16);
        f85Var16.V0();
        contentValues.put("session_stitching_token_hash", Long.valueOf(b75Var.w));
        mg5.a();
        x15 x15Var = k85Var.A;
        t65 t65Var = k85Var.Y;
        if (x15Var.f1(strD, r55.Q0)) {
            f85 f85Var17 = k85Var2.Z;
            k85.h(f85Var17);
            f85Var17.V0();
            contentValues.put("ad_services_version", Integer.valueOf(b75Var.x));
            f85 f85Var18 = k85Var2.Z;
            k85.h(f85Var18);
            f85Var18.V0();
            contentValues.put("attribution_eligibility_status", Long.valueOf(b75Var.B));
        }
        f85 f85Var19 = k85Var2.Z;
        k85.h(f85Var19);
        f85Var19.V0();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(b75Var.y));
        contentValues.put("npa_metadata_value", b75Var.w());
        f85 f85Var20 = k85Var2.Z;
        k85.h(f85Var20);
        f85Var20.V0();
        contentValues.put("bundle_delivery_index", Long.valueOf(b75Var.F));
        contentValues.put("sgtm_preview_key", b75Var.C());
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("dma_consent_state", Integer.valueOf(b75Var.D));
        k85.h(f85Var10);
        f85Var10.V0();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(b75Var.E));
        contentValues.put("serialized_npa_metadata", b75Var.s());
        contentValues.put("client_upload_eligibility", Integer.valueOf(b75Var.t()));
        f85 f85Var21 = k85Var2.Z;
        k85.h(f85Var21);
        f85Var21.V0();
        ArrayList arrayList = b75Var.s;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                k85.h(t65Var);
                t65Var.C0.b(strD, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        if (k85Var.A.f1(null, r55.L0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        f85 f85Var22 = k85Var2.Z;
        k85.h(f85Var22);
        f85Var22.V0();
        contentValues.put("unmatched_pfo", b75Var.z);
        f85 f85Var23 = k85Var2.Z;
        k85.h(f85Var23);
        f85Var23.V0();
        contentValues.put("unmatched_uwa", b75Var.A);
        f85 f85Var24 = k85Var2.Z;
        k85.h(f85Var24);
        f85Var24.V0();
        contentValues.put("ad_campaign_info", b75Var.H);
        try {
            SQLiteDatabase sQLiteDatabaseK1 = K1();
            if (sQLiteDatabaseK1.update("apps", contentValues, "app_id = ?", new String[]{strD}) == 0 && sQLiteDatabaseK1.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                k85.h(t65Var);
                t65Var.z0.b(t65.Z0(strD), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e) {
            k85.h(t65Var);
            t65Var.z0.c("Error storing app. appId", t65.Z0(strD), e);
        }
    }

    public final long Z0(String str, j85 j85Var, String str2, Map map, qb5 qb5Var, Long l) {
        int iDelete;
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        tj4.i(j85Var);
        tj4.f(str);
        V0();
        W0();
        if (C1()) {
            ff5 ff5Var = this.X;
            long jA = ff5Var.z0.z0.a();
            wl3 wl3Var = k85Var.B0;
            t65 t65Var = k85Var.Y;
            wl3Var.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) r55.N.a(null)).longValue()) {
                ff5Var.z0.z0.b(jElapsedRealtime);
                V0();
                W0();
                if (C1() && (iDelete = K1().delete("upload_queue", x1(), new String[0])) > 0) {
                    k85.h(t65Var);
                    t65Var.H0.b(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                tj4.f(str);
                V0();
                W0();
                try {
                    int iD1 = k85Var.A.d1(str, r55.A);
                    if (iD1 > 0) {
                        K1().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iD1)});
                    }
                } catch (SQLiteException e) {
                    k85.h(t65Var);
                    t65Var.z0.c("Error deleting over the limit queued batches. appId", t65.Z0(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrA = j85Var.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrA);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append((CharSequence) "\r\n");
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(qb5Var.b));
        wl3 wl3Var2 = k85Var.B0;
        t65 t65Var2 = k85Var.Y;
        wl3Var2.getClass();
        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long jInsert = K1().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            k85.h(t65Var2);
            t65Var2.z0.b(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e2) {
            k85.h(t65Var2);
            t65Var2.z0.c("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1L;
        }
    }

    public final g25 Z1(long j, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        return a2(j, str, 1L, false, false, z, false, z2, z3, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public final List a1(String str, le5 le5Var, int i) {
        ?? arrayList;
        tj4.f(str);
        V0();
        W0();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseK1 = K1();
                String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"};
                String strY1 = y1(le5Var.b);
                String strX1 = x1();
                StringBuilder sb = new StringBuilder(strY1.length() + 17 + strX1.length());
                sb.append("app_id=?");
                sb.append(strY1);
                sb.append(" AND NOT ");
                sb.append(strX1);
                cursorQuery = sQLiteDatabaseK1.query("upload_queue", strArr, sb.toString(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
                arrayList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    if5 if5VarW1 = w1(str, cursorQuery.getLong(0), cursorQuery.getBlob(2), cursorQuery.getString(3), cursorQuery.getString(4), cursorQuery.getInt(5), cursorQuery.getInt(6), cursorQuery.getLong(7), cursorQuery.getLong(8), cursorQuery.getLong(9));
                    if (if5VarW1 != null) {
                        arrayList.add(if5VarW1);
                    }
                }
            } catch (SQLiteException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.c("Error to querying MeasurementBatch from upload_queue. appId", str, e);
                arrayList = Collections.EMPTY_LIST;
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public final g25 a2(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        V0();
        W0();
        String[] strArr = {str};
        g25 g25Var = new g25();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseK1 = K1();
                cursorQuery = sQLiteDatabaseK1.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j) {
                        g25Var.b = cursorQuery.getLong(1);
                        g25Var.a = cursorQuery.getLong(2);
                        g25Var.c = cursorQuery.getLong(3);
                        g25Var.d = cursorQuery.getLong(4);
                        g25Var.e = cursorQuery.getLong(5);
                        g25Var.f = cursorQuery.getLong(6);
                        g25Var.g = cursorQuery.getLong(7);
                    }
                    if (z) {
                        g25Var.b += j2;
                    }
                    if (z2) {
                        g25Var.a += j2;
                    }
                    if (z3) {
                        g25Var.c += j2;
                    }
                    if (z4) {
                        g25Var.d += j2;
                    }
                    if (z5) {
                        g25Var.e += j2;
                    }
                    if (z6) {
                        g25Var.f += j2;
                    }
                    if (z7) {
                        g25Var.g += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(g25Var.a));
                    contentValues.put("daily_events_count", Long.valueOf(g25Var.b));
                    contentValues.put("daily_conversions_count", Long.valueOf(g25Var.c));
                    contentValues.put("daily_error_events_count", Long.valueOf(g25Var.d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(g25Var.e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(g25Var.f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(g25Var.g));
                    sQLiteDatabaseK1.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.C0.b(t65.Z0(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.c("Error updating daily counts. appId", t65.Z0(str), e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return g25Var;
        } finally {
        }
    }

    public final boolean b1(String str) {
        qb5[] qb5VarArr = {qb5.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(qb5VarArr[0].b));
        String strY1 = y1(arrayList);
        String strX1 = x1();
        StringBuilder sb = new StringBuilder(strY1.length() + 61 + strX1.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strY1);
        sb.append(" AND NOT ");
        sb.append(strX1);
        return F1(sb.toString(), new String[]{str}) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final n02 b2(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        V0();
        W0();
        ?? r2 = 0;
        try {
            try {
                cursorQuery = K1().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        byte[] blob = cursorQuery.getBlob(0);
                        String string = cursorQuery.getString(1);
                        String string2 = cursorQuery.getString(2);
                        if (cursorQuery.moveToNext()) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.z0.b(t65.Z0(str), "Got multiple records for app config, expected one. appId");
                        }
                        if (blob != null) {
                            n02 n02Var = new n02(28, blob, string, string2);
                            cursorQuery.close();
                            return n02Var;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.c("Error querying remote config. appId", t65.Z0(str), e);
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = this;
                if (r2 != 0) {
                    throw th;
                }
                r2.close();
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r2 != 0) {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final void c1(Long l) {
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        try {
            if (K1().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.a("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(e, "Failed to delete a MeasurementBatch in a upload_queue table");
            throw e;
        }
    }

    public final void c2(n85 n85Var, boolean z) {
        V0();
        W0();
        tj4.f(n85Var.n());
        if (!n85Var.Z1()) {
            st4.g();
            return;
        }
        f1();
        k85 k85Var = (k85) this.f;
        wl3 wl3Var = k85Var.B0;
        t65 t65Var = k85Var.Y;
        wl3Var.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jA2 = n85Var.a2();
        q55 q55Var = r55.S;
        if (jA2 < jCurrentTimeMillis - ((Long) q55Var.a(null)).longValue() || n85Var.a2() > ((Long) q55Var.a(null)).longValue() + jCurrentTimeMillis) {
            k85.h(t65Var);
            t65Var.C0.d("Storing bundle outside of the max uploading time span. appId, now, timestamp", t65.Z0(n85Var.n()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(n85Var.a2()));
        }
        byte[] bArrA = n85Var.a();
        try {
            z65 z65Var = this.X.Z;
            ff5.R(z65Var);
            byte[] bArrH1 = z65Var.H1(bArrA);
            k85.h(t65Var);
            t65Var.H0.b(Integer.valueOf(bArrH1.length), "Saving bundle, size");
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", n85Var.n());
            contentValues.put("bundle_end_timestamp", Long.valueOf(n85Var.a2()));
            contentValues.put("data", bArrH1);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (n85Var.n0()) {
                contentValues.put("retry_count", Integer.valueOf(n85Var.o0()));
            }
            try {
                if (K1().insert("queue", null, contentValues) == -1) {
                    k85.h(t65Var);
                    t65Var.z0.b(t65.Z0(n85Var.n()), "Failed to insert bundle (got -1). appId");
                }
            } catch (SQLiteException e) {
                k85.h(t65Var);
                t65Var.z0.c("Error storing bundle. appId", t65.Z0(n85Var.n()), e);
            }
        } catch (IOException e2) {
            k85.h(t65Var);
            t65Var.z0.c("Data loss. Failed to serialize bundle. appId", t65.Z0(n85Var.n()), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String d1() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseK1 = K1();
        ?? r1 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseK1.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    t65 t65Var = ((k85) this.f).Y;
                    k85.h(t65Var);
                    t65Var.z0.b(e, "Database error getting next bundle app id");
                }
            } catch (Throwable th) {
                th = th;
                r1 = sQLiteDatabaseK1;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return null;
    }

    public final void e1(long j) {
        V0();
        W0();
        try {
            if (K1().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.b(e, "Failed to delete a bundle in a queue table");
            throw e;
        }
    }

    public final void f1() {
        V0();
        W0();
        if (C1()) {
            ff5 ff5Var = this.X;
            long jA = ff5Var.z0.y0.a();
            k85 k85Var = (k85) this.f;
            k85Var.B0.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) r55.N.a(null)).longValue()) {
                ff5Var.z0.y0.b(jElapsedRealtime);
                V0();
                W0();
                if (C1()) {
                    SQLiteDatabase sQLiteDatabaseK1 = K1();
                    k85Var.B0.getClass();
                    int iDelete = sQLiteDatabaseK1.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) r55.S.a(null)).longValue())});
                    if (iDelete > 0) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.H0.b(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    public final void g1(ArrayList arrayList) {
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        tj4.i(arrayList);
        if (arrayList.size() == 0) {
            xe.k("Given Integer is zero");
            return;
        }
        if (C1()) {
            String strJoin = TextUtils.join(",", arrayList);
            String strZ = fw.z(new StringBuilder(String.valueOf(strJoin).length() + 2), "(", strJoin, ")");
            if (F1(fw.z(new StringBuilder(strZ.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", strZ, " AND retry_count =  2147483647 LIMIT 1"), null) > 0) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseK1 = K1();
                StringBuilder sb = new StringBuilder(strZ.length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(strZ);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseK1.execSQL(sb.toString());
            } catch (SQLiteException e) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.b(e, "Error incrementing retry count. error");
            }
        }
    }

    public final void h1(Long l) {
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        if (C1()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (F1(sb.toString(), null) > 0) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseK1 = K1();
                k85Var.B0.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseK1.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.b(e, "Error incrementing retry count. error");
            }
        }
    }

    public final Object i1(Cursor cursor, int i) {
        k85 k85Var = (k85) this.f;
        int type = cursor.getType(i);
        if (type == 0) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
            return null;
        }
        t65 t65Var3 = k85Var.Y;
        k85.h(t65Var3);
        t65Var3.z0.a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: all -> 0x006d, SQLiteException -> 0x00a4, TryCatch #0 {SQLiteException -> 0x00a4, blocks: (B:15:0x0072, B:17:0x0093, B:20:0x00a6), top: B:30:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6 A[Catch: all -> 0x006d, SQLiteException -> 0x00a4, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a4, blocks: (B:15:0x0072, B:17:0x0093, B:20:0x00a6), top: B:30:0x0072 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long j1(String str) {
        long j;
        long jG1;
        ContentValues contentValues;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        tj4.f("first_open_count");
        V0();
        W0();
        SQLiteDatabase sQLiteDatabaseK1 = K1();
        sQLiteDatabaseK1.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select first_open_count from app2 where app_id=?");
                j = -1;
                jG1 = G1(sb.toString(), new String[]{str}, -1L);
            } catch (SQLiteException e) {
                e = e;
            }
            if (jG1 == -1) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", (Integer) 0);
                contentValues2.put("previous_install_count", (Integer) 0);
                if (sQLiteDatabaseK1.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.z0.c("Failed to insert column (got -1). appId", t65.Z0(str), "first_open_count");
                } else {
                    jG1 = 0;
                    try {
                        contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", Long.valueOf(1 + jG1));
                        if (sQLiteDatabaseK1.update("app2", contentValues, "app_id = ?", new String[]{str}) != 0) {
                            t65 t65Var2 = k85Var.Y;
                            k85.h(t65Var2);
                            t65Var2.z0.c("Failed to update column (got 0). appId", t65.Z0(str), "first_open_count");
                        } else {
                            sQLiteDatabaseK1.setTransactionSuccessful();
                            j = jG1;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        j2 = jG1;
                        t65 t65Var3 = k85Var.Y;
                        k85.h(t65Var3);
                        t65Var3.z0.d("Error inserting column. appId", t65.Z0(str), "first_open_count", e);
                        j = j2;
                    }
                }
                t65 t65Var32 = k85Var.Y;
                k85.h(t65Var32);
                t65Var32.z0.d("Error inserting column. appId", t65.Z0(str), "first_open_count", e);
                j = j2;
            } else {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Long.valueOf(1 + jG1));
                if (sQLiteDatabaseK1.update("app2", contentValues, "app_id = ?", new String[]{str}) != 0) {
                }
            }
            return j;
        } finally {
            sQLiteDatabaseK1.endTransaction();
        }
    }

    public final boolean k1(String str, String str2) {
        return F1("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final long l1(String str) {
        tj4.f(str);
        return G1("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final void m1(String str, Long l, long j, w75 w75Var) {
        V0();
        W0();
        tj4.i(w75Var);
        tj4.f(str);
        k85 k85Var = (k85) this.f;
        byte[] bArrA = w75Var.a();
        t65 t65Var = k85Var.Y;
        t65 t65Var2 = k85Var.Y;
        k85.h(t65Var);
        t65Var.H0.c("Saving complex main event, appId, data size", k85Var.A0.a(str), Integer.valueOf(bArrA.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrA);
        try {
            if (K1().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                k85.h(t65Var2);
                t65Var2.z0.b(t65.Z0(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e) {
            k85.h(t65Var2);
            t65Var2.z0.c("Error storing complex main event. appId", t65.Z0(str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n1(String str, Long l, String str2, Bundle bundle) {
        Bundle bundle2;
        t65 t65Var;
        n85 n85Var;
        Cursor cursorQuery;
        m25 m25Var = this;
        String str3 = str;
        k85 k85Var = (k85) m25Var.f;
        tj4.i(bundle);
        m25Var.V0();
        m25Var.W0();
        fv0 fv0Var = l != null ? new fv0(m25Var, str3, l.longValue()) : new fv0(m25Var, str3);
        List<h25> listX = fv0Var.x();
        while (!listX.isEmpty()) {
            for (h25 h25Var : listX) {
                if (!TextUtils.isEmpty(str2)) {
                    Cursor cursor = null;
                    n85 n85Var2 = null;
                    Cursor cursor2 = null;
                    try {
                        try {
                            cursorQuery = m25Var.K1().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, Long.toString(h25Var.b)}, null, null, "rowid", "2");
                            try {
                                try {
                                } catch (SQLiteException e) {
                                    e = e;
                                    n85Var = null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursorQuery;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        n85Var = null;
                    }
                    if (cursorQuery.moveToFirst()) {
                        try {
                            n85Var = (n85) ((l85) z65.I1(n85.S(), cursorQuery.getBlob(0))).e();
                            try {
                                if (cursorQuery.moveToNext()) {
                                    t65 t65Var2 = k85Var.Y;
                                    k85.h(t65Var2);
                                    t65Var2.C0.b(t65.Z0(str3), "Get multiple raw event metadata records, expected one. appId");
                                }
                                cursorQuery.close();
                                cursorQuery.close();
                            } catch (SQLiteException e3) {
                                e = e3;
                                cursor = cursorQuery;
                                t65 t65Var3 = k85Var.Y;
                                k85.h(t65Var3);
                                t65Var3.z0.c("Data loss. Error selecting raw event. appId", t65.Z0(str3), e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                            n85Var2 = n85Var;
                        } catch (IOException e4) {
                            t65 t65Var4 = k85Var.Y;
                            k85.h(t65Var4);
                            t65Var4.z0.c("Data loss. Failed to merge raw event metadata. appId", t65.Z0(str3), e4);
                            cursorQuery.close();
                        }
                        if (n85Var2 == null) {
                            Iterator it = n85Var2.S1().iterator();
                            while (it.hasNext()) {
                                if (((a95) it.next()).p().equals(str2)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        t65 t65Var5 = k85Var.Y;
                        k85.h(t65Var5);
                        t65Var5.z0.b(t65.Z0(str3), "Raw event metadata record is missing. appId");
                    }
                    cursorQuery.close();
                    if (n85Var2 == null) {
                    }
                }
                z65 z65Var = m25Var.X.Z;
                ff5.R(z65Var);
                w75 w75Var = h25Var.d;
                Bundle bundle3 = new Bundle();
                for (b85 b85Var : w75Var.n()) {
                    if (b85Var.v()) {
                        bundle3.putDouble(b85Var.o(), b85Var.w());
                    } else if (b85Var.t()) {
                        bundle3.putFloat(b85Var.o(), b85Var.u());
                    } else if (b85Var.r()) {
                        bundle3.putLong(b85Var.o(), b85Var.s());
                    } else if (b85Var.p()) {
                        bundle3.putString(b85Var.o(), b85Var.q());
                    } else if (b85Var.x().isEmpty()) {
                        t65 t65Var6 = ((k85) z65Var.f).Y;
                        k85.h(t65Var6);
                        t65Var6.z0.b(b85Var, "Unexpected parameter type for parameter");
                    } else {
                        bundle3.putParcelableArray(b85Var.o(), z65.K1((mc5) b85Var.x()));
                    }
                }
                String string = bundle3.getString("_o");
                bundle3.remove("_o");
                String strQ = w75Var.q();
                if (string == null) {
                    string = "";
                }
                qf5 qf5Var = k85Var.z0;
                t65 t65Var7 = k85Var.Y;
                k85.f(qf5Var);
                if (strQ.equals("_cmp")) {
                    bundle2 = new Bundle(bundle);
                    for (String str4 : bundle.keySet()) {
                        w75 w75Var2 = w75Var;
                        if (str4.startsWith("gad_")) {
                            bundle2.remove(str4);
                        }
                        w75Var = w75Var2;
                    }
                } else {
                    bundle2 = bundle;
                }
                w75 w75Var3 = w75Var;
                qf5Var.g1(bundle3, bundle2);
                v25 v25Var = new v25((k85) m25Var.f, string, str3, w75Var3.q(), w75Var3.s(), w75Var3.u(), bundle3);
                long j = h25Var.a;
                long j2 = h25Var.b;
                boolean z = h25Var.c;
                m25Var.V0();
                m25Var.W0();
                String str5 = v25Var.a;
                tj4.f(str5);
                ff5.R(z65Var);
                byte[] bArrA = z65Var.x1(v25Var).a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str5);
                contentValues.put("name", v25Var.b);
                contentValues.put("timestamp", Long.valueOf(v25Var.d));
                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                contentValues.put("data", bArrA);
                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                try {
                    long jUpdate = K1().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                    if (jUpdate != 1) {
                        k85.h(t65Var7);
                        t65Var = t65Var7;
                        try {
                            t65Var.z0.c("Failed to update raw event. appId, updatedRows", t65.Z0(str5), Long.valueOf(jUpdate));
                        } catch (SQLiteException e5) {
                            e = e5;
                            k85.h(t65Var);
                            t65Var.z0.c("Error updating raw event. appId", t65.Z0(str5), e);
                        }
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    t65Var = t65Var7;
                }
                m25Var = this;
                str3 = str;
            }
            listX = fv0Var.x();
            m25Var = this;
            str3 = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v0, types: [k70, m25, pe5] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final t95 o1(String str) {
        Throwable th;
        SQLiteException e;
        k85 k85Var = (k85) this.f;
        tj4.i(str);
        V0();
        W0();
        ?? r2 = 0;
        t95VarC = null;
        t95VarC = null;
        t95 t95VarC = null;
        try {
            try {
                this = K1().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str});
                try {
                    if (this.moveToFirst()) {
                        t95VarC = t95.c(this.getInt(1), this.getString(0));
                    } else {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.H0.a("No data found");
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.b(e, "Error querying database.");
                    if (this != 0) {
                    }
                    if (t95VarC != null) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = this;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            this = 0;
        } catch (Throwable th3) {
            th = th3;
            if (r2 != 0) {
            }
            throw th;
        }
        this.close();
        return t95VarC != null ? t95.c : t95VarC;
    }

    public final void p1(String str, ee5 ee5Var) {
        V0();
        W0();
        tj4.f(str);
        k85 k85Var = (k85) this.f;
        wl3 wl3Var = k85Var.B0;
        t65 t65Var = k85Var.Y;
        wl3Var.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        q55 q55Var = r55.w0;
        long jLongValue = jCurrentTimeMillis - ((Long) q55Var.a(null)).longValue();
        long j = ee5Var.f;
        if (j < jLongValue || j > ((Long) q55Var.a(null)).longValue() + jCurrentTimeMillis) {
            k85.h(t65Var);
            t65Var.C0.d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", t65.Z0(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
        }
        k85.h(t65Var);
        t65Var.H0.a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", ee5Var.b);
        contentValues.put("source", Integer.valueOf(ee5Var.z));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (K1().insert("trigger_uris", null, contentValues) == -1) {
                k85.h(t65Var);
                t65Var.z0.b(t65.Z0(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e) {
            k85.h(t65Var);
            t65Var.z0.c("Error storing trigger URI. appId", t65.Z0(str), e);
        }
    }

    public final void q1(String str, t95 t95Var) {
        tj4.i(str);
        tj4.i(t95Var);
        V0();
        W0();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", t95Var.g());
        contentValues.put("consent_source", Integer.valueOf(t95Var.b));
        s1(contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String r1(String str, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = K1().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return "";
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.c("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th;
    }

    public final void s1(ContentValues contentValues) {
        k85 k85Var = (k85) this.f;
        try {
            SQLiteDatabase sQLiteDatabaseK1 = K1();
            if (contentValues.getAsString("app_id") == null) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.B0.b(t65.Z0("app_id"), "Value of the primary key is not set.");
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (sQLiteDatabaseK1.update("consent_settings", contentValues, r5.toString(), new String[]{r4}) == 0 && sQLiteDatabaseK1.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                t65Var2.z0.c("Failed to insert/update table (got -1). key", t65.Z0("consent_settings"), t65.Z0("app_id"));
            }
        } catch (SQLiteException e) {
            t65 t65Var3 = k85Var.Y;
            k85.h(t65Var3);
            t65Var3.z0.d("Error storing into table. key", t65.Z0("consent_settings"), t65.Z0("app_id"), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final w25 t1(String str, String str2, String str3) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        k85 k85Var = (k85) this.f;
        tj4.f(str2);
        tj4.f(str3);
        V0();
        W0();
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count"));
        ?? r3 = 0;
        try {
            try {
                cursorQuery = K1().query(str, (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        long j = cursorQuery.getLong(0);
                        long j2 = cursorQuery.getLong(1);
                        long j3 = cursorQuery.getLong(2);
                        long j4 = 0;
                        long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                        Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                        Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                        Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                        if (cursorQuery.isNull(7)) {
                            boolValueOf = null;
                        } else {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        }
                        if (!cursorQuery.isNull(8)) {
                            j4 = cursorQuery.getLong(8);
                        }
                        w25 w25Var = new w25(str2, str3, j, j2, j4, j3, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursorQuery.moveToNext()) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.z0.b(t65.Z0(str2), "Got multiple records for event aggregates, expected one. appId");
                        }
                        cursorQuery.close();
                        return w25Var;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.d("Error querying events. appId", t65.Z0(str2), k85Var.A0.a(str3), e);
                }
            } catch (Throwable th) {
                th = th;
                r3 = arrayList;
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r3 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final void u1(String str, w25 w25Var) {
        k85 k85Var = (k85) this.f;
        tj4.i(w25Var);
        V0();
        W0();
        ContentValues contentValues = new ContentValues();
        String str2 = w25Var.a;
        contentValues.put("app_id", str2);
        contentValues.put("name", w25Var.b);
        contentValues.put("lifetime_count", Long.valueOf(w25Var.c));
        contentValues.put("current_bundle_count", Long.valueOf(w25Var.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(w25Var.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(w25Var.g));
        contentValues.put("last_bundled_day", w25Var.h);
        contentValues.put("last_sampled_complex_event_id", w25Var.i);
        contentValues.put("last_sampling_rate", w25Var.j);
        contentValues.put("current_session_count", Long.valueOf(w25Var.e));
        Boolean bool = w25Var.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (K1().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.z0.b(t65.Z0(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.c("Error storing event aggregates. appId", t65.Z0(str2), e);
        }
    }

    public final void v1(String str, String str2) {
        tj4.f(str2);
        V0();
        W0();
        try {
            K1().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.c("Error deleting snapshot. appId", t65.Z0(str2), e);
        }
    }

    public final if5 w1(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        qb5 qb5Var;
        k85 k85Var = (k85) this.f;
        if (TextUtils.isEmpty(str2)) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.G0.a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            g85 g85Var = (g85) z65.I1(j85.u(), bArr);
            qb5[] qb5VarArrValues = qb5.values();
            int length = qb5VarArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    qb5Var = qb5.UNKNOWN;
                    break;
                }
                qb5Var = qb5VarArrValues[i3];
                if (qb5Var.b == i) {
                    break;
                }
                i3++;
            }
            if (qb5Var != qb5.GOOGLE_SIGNAL && qb5Var != qb5.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = DesugarCollections.unmodifiableList(((j85) g85Var.f).n()).iterator();
                while (it.hasNext()) {
                    l85 l85Var = (l85) ((n85) it.next()).g();
                    l85Var.c();
                    ((n85) l85Var.f).R0(i2);
                    arrayList.add((n85) l85Var.e());
                }
                g85Var.c();
                ((j85) g85Var.f).z();
                g85Var.c();
                ((j85) g85Var.f).y(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length2 = strArrSplit.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        break;
                    }
                    String str4 = strArrSplit[i4];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b(str4, "Invalid upload header: ");
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i4++;
                }
            }
            return new if5(j, (j85) g85Var.e(), str2, map, qb5Var, j2, j3, j4, i2);
        } catch (IOException e) {
            t65 t65Var3 = k85Var.Y;
            k85.h(t65Var3);
            t65Var3.z0.c("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    public final String x1() {
        ((k85) this.f).B0.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Long l = (Long) r55.T.a(null);
        l.getClass();
        String str = "(upload_type = 1 AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + l + ")";
        String strC = dw2.C(fw.C("(upload_type != 1 AND ABS(creation_timestamp - ", ") > ", jCurrentTimeMillis), ")", ((Long) r55.S.a(null)).longValue());
        StringBuilder sb = new StringBuilder(str.length() + 5 + strC.length() + 1);
        ha0.v(sb, "(", str, " OR ", strC);
        sb.append(")");
        return sb.toString();
    }

    public final void z1(String str, t95 t95Var) {
        tj4.i(str);
        V0();
        W0();
        q1(str, o1(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", t95Var.g());
        s1(contentValues);
    }

    @Override // defpackage.pe5
    public final void Y0() {
    }
}
