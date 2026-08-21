package defpackage;

import androidx.work.impl.WorkDatabase_Impl;
import com.getsurfboard.database.AppDatabase_Impl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wc extends h31 {
    public final /* synthetic */ int d = 1;
    public final /* synthetic */ pl3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc(AppDatabase_Impl appDatabase_Impl) {
        super("1f8a852a0f592c0f772e07c85a3f0479", 9, "8b8f7c5b98645f33a32618a3785d4d5c");
        this.e = appDatabase_Impl;
    }

    @Override // defpackage.h31
    public final void a(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
        switch (i) {
            case 0:
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `proxy_group_selection` (`profileName` TEXT NOT NULL, `groupName` TEXT NOT NULL, `selection` TEXT NOT NULL, PRIMARY KEY(`profileName`, `groupName`))");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `requests` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `proxy` TEXT NOT NULL, `rule` TEXT NOT NULL, `server` TEXT NOT NULL)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `hosts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                ez4.t(go3Var, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1f8a852a0f592c0f772e07c85a3f0479')");
                break;
            default:
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `trace_tag` TEXT, `backoff_on_system_interruptions` INTEGER, `required_network_type` INTEGER NOT NULL, `required_network_request` BLOB NOT NULL DEFAULT x'', `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                ez4.t(go3Var, "CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                ez4.t(go3Var, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                ez4.t(go3Var, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '08b926448d86528e697981ddd30459f7')");
                break;
        }
    }

    @Override // defpackage.h31
    public final void c(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
        switch (i) {
            case 0:
                ez4.t(go3Var, "DROP TABLE IF EXISTS `proxy_group_selection`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `requests`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `hosts`");
                break;
            default:
                ez4.t(go3Var, "DROP TABLE IF EXISTS `Dependency`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `WorkSpec`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `WorkTag`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `SystemIdInfo`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `WorkName`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `WorkProgress`");
                ez4.t(go3Var, "DROP TABLE IF EXISTS `Preference`");
                break;
        }
    }

    @Override // defpackage.h31
    public final void r(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
    }

    @Override // defpackage.h31
    public final void s(go3 go3Var) {
        int i = this.d;
        pl3 pl3Var = this.e;
        go3Var.getClass();
        switch (i) {
            case 0:
                ((AppDatabase_Impl) pl3Var).n(go3Var);
                break;
            default:
                ez4.t(go3Var, "PRAGMA foreign_keys = ON");
                ((WorkDatabase_Impl) pl3Var).n(go3Var);
                break;
        }
    }

    @Override // defpackage.h31
    public final void t(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
    }

    @Override // defpackage.h31
    public final void u(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
        switch (i) {
            case 0:
                vo.m(go3Var);
                break;
            default:
                vo.m(go3Var);
                break;
        }
    }

    @Override // defpackage.h31
    public final h6 v(go3 go3Var) {
        int i = this.d;
        go3Var.getClass();
        switch (i) {
            case 0:
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("profileName", new ka4("profileName", "TEXT", true, 1, null, 1));
                linkedHashMap.put("groupName", new ka4("groupName", "TEXT", true, 2, null, 1));
                linkedHashMap.put("selection", new ka4("selection", "TEXT", true, 0, null, 1));
                na4 na4Var = new na4("proxy_group_selection", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
                na4 na4VarO = ez4.O(go3Var, "proxy_group_selection");
                if (na4Var.equals(na4VarO)) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("id", new ka4("id", "INTEGER", true, 1, null, 1));
                    linkedHashMap2.put(RtspHeaders.Values.TIME, new ka4(RtspHeaders.Values.TIME, "INTEGER", true, 0, null, 1));
                    linkedHashMap2.put("packageName", new ka4("packageName", "TEXT", true, 0, null, 1));
                    linkedHashMap2.put("proxy", new ka4("proxy", "TEXT", true, 0, null, 1));
                    linkedHashMap2.put("rule", new ka4("rule", "TEXT", true, 0, null, 1));
                    linkedHashMap2.put("server", new ka4("server", "TEXT", true, 0, null, 1));
                    na4 na4Var2 = new na4("requests", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
                    na4 na4VarO2 = ez4.O(go3Var, "requests");
                    if (na4Var2.equals(na4VarO2)) {
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.put("id", new ka4("id", "INTEGER", true, 1, null, 1));
                        linkedHashMap3.put("key", new ka4("key", "TEXT", true, 0, null, 1));
                        linkedHashMap3.put("value", new ka4("value", "TEXT", true, 0, null, 1));
                        na4 na4Var3 = new na4("hosts", linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
                        na4 na4VarO3 = ez4.O(go3Var, "hosts");
                        if (!na4Var3.equals(na4VarO3)) {
                        }
                    }
                }
                break;
            default:
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                linkedHashMap4.put("work_spec_id", new ka4("work_spec_id", "TEXT", true, 1, null, 1));
                linkedHashMap4.put("prerequisite_id", new ka4("prerequisite_id", "TEXT", true, 2, null, 1));
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                linkedHashSet.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("work_spec_id"), p95.x("id")));
                linkedHashSet.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("prerequisite_id"), p95.x("id")));
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                linkedHashSet2.add(new ma4("index_Dependency_work_spec_id", false, p95.x("work_spec_id"), p95.x("ASC")));
                linkedHashSet2.add(new ma4("index_Dependency_prerequisite_id", false, p95.x("prerequisite_id"), p95.x("ASC")));
                na4 na4Var4 = new na4("Dependency", linkedHashMap4, linkedHashSet, linkedHashSet2);
                na4 na4VarO4 = ez4.O(go3Var, "Dependency");
                if (na4Var4.equals(na4VarO4)) {
                    LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                    linkedHashMap5.put("id", new ka4("id", "TEXT", true, 1, null, 1));
                    linkedHashMap5.put("state", new ka4("state", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("worker_class_name", new ka4("worker_class_name", "TEXT", true, 0, null, 1));
                    linkedHashMap5.put("input_merger_class_name", new ka4("input_merger_class_name", "TEXT", true, 0, null, 1));
                    linkedHashMap5.put("input", new ka4("input", "BLOB", true, 0, null, 1));
                    linkedHashMap5.put("output", new ka4("output", "BLOB", true, 0, null, 1));
                    linkedHashMap5.put("initial_delay", new ka4("initial_delay", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("interval_duration", new ka4("interval_duration", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("flex_duration", new ka4("flex_duration", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("run_attempt_count", new ka4("run_attempt_count", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("backoff_policy", new ka4("backoff_policy", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("backoff_delay_duration", new ka4("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("last_enqueue_time", new ka4("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
                    linkedHashMap5.put("minimum_retention_duration", new ka4("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("schedule_requested_at", new ka4("schedule_requested_at", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("run_in_foreground", new ka4("run_in_foreground", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("out_of_quota_policy", new ka4("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("period_count", new ka4("period_count", "INTEGER", true, 0, "0", 1));
                    linkedHashMap5.put("generation", new ka4("generation", "INTEGER", true, 0, "0", 1));
                    linkedHashMap5.put("next_schedule_time_override", new ka4("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
                    linkedHashMap5.put("next_schedule_time_override_generation", new ka4("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
                    linkedHashMap5.put("stop_reason", new ka4("stop_reason", "INTEGER", true, 0, "-256", 1));
                    linkedHashMap5.put("trace_tag", new ka4("trace_tag", "TEXT", false, 0, null, 1));
                    linkedHashMap5.put("backoff_on_system_interruptions", new ka4("backoff_on_system_interruptions", "INTEGER", false, 0, null, 1));
                    linkedHashMap5.put("required_network_type", new ka4("required_network_type", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("required_network_request", new ka4("required_network_request", "BLOB", true, 0, "x''", 1));
                    linkedHashMap5.put("requires_charging", new ka4("requires_charging", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("requires_device_idle", new ka4("requires_device_idle", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("requires_battery_not_low", new ka4("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("requires_storage_not_low", new ka4("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("trigger_content_update_delay", new ka4("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("trigger_max_content_delay", new ka4("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                    linkedHashMap5.put("content_uri_triggers", new ka4("content_uri_triggers", "BLOB", true, 0, null, 1));
                    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                    LinkedHashSet linkedHashSet4 = new LinkedHashSet();
                    linkedHashSet4.add(new ma4("index_WorkSpec_schedule_requested_at", false, p95.x("schedule_requested_at"), p95.x("ASC")));
                    linkedHashSet4.add(new ma4("index_WorkSpec_last_enqueue_time", false, p95.x("last_enqueue_time"), p95.x("ASC")));
                    na4 na4Var5 = new na4("WorkSpec", linkedHashMap5, linkedHashSet3, linkedHashSet4);
                    na4 na4VarO5 = ez4.O(go3Var, "WorkSpec");
                    if (na4Var5.equals(na4VarO5)) {
                        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                        linkedHashMap6.put("tag", new ka4("tag", "TEXT", true, 1, null, 1));
                        linkedHashMap6.put("work_spec_id", new ka4("work_spec_id", "TEXT", true, 2, null, 1));
                        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
                        linkedHashSet5.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("work_spec_id"), p95.x("id")));
                        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                        linkedHashSet6.add(new ma4("index_WorkTag_work_spec_id", false, p95.x("work_spec_id"), p95.x("ASC")));
                        na4 na4Var6 = new na4("WorkTag", linkedHashMap6, linkedHashSet5, linkedHashSet6);
                        na4 na4VarO6 = ez4.O(go3Var, "WorkTag");
                        if (na4Var6.equals(na4VarO6)) {
                            LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                            linkedHashMap7.put("work_spec_id", new ka4("work_spec_id", "TEXT", true, 1, null, 1));
                            linkedHashMap7.put("generation", new ka4("generation", "INTEGER", true, 2, "0", 1));
                            linkedHashMap7.put("system_id", new ka4("system_id", "INTEGER", true, 0, null, 1));
                            LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                            linkedHashSet7.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("work_spec_id"), p95.x("id")));
                            na4 na4Var7 = new na4("SystemIdInfo", linkedHashMap7, linkedHashSet7, new LinkedHashSet());
                            na4 na4VarO7 = ez4.O(go3Var, "SystemIdInfo");
                            if (na4Var7.equals(na4VarO7)) {
                                LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                                linkedHashMap8.put("name", new ka4("name", "TEXT", true, 1, null, 1));
                                linkedHashMap8.put("work_spec_id", new ka4("work_spec_id", "TEXT", true, 2, null, 1));
                                LinkedHashSet linkedHashSet8 = new LinkedHashSet();
                                linkedHashSet8.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("work_spec_id"), p95.x("id")));
                                LinkedHashSet linkedHashSet9 = new LinkedHashSet();
                                linkedHashSet9.add(new ma4("index_WorkName_work_spec_id", false, p95.x("work_spec_id"), p95.x("ASC")));
                                na4 na4Var8 = new na4("WorkName", linkedHashMap8, linkedHashSet8, linkedHashSet9);
                                na4 na4VarO8 = ez4.O(go3Var, "WorkName");
                                if (na4Var8.equals(na4VarO8)) {
                                    LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                                    linkedHashMap9.put("work_spec_id", new ka4("work_spec_id", "TEXT", true, 1, null, 1));
                                    linkedHashMap9.put("progress", new ka4("progress", "BLOB", true, 0, null, 1));
                                    LinkedHashSet linkedHashSet10 = new LinkedHashSet();
                                    linkedHashSet10.add(new la4("WorkSpec", "CASCADE", "CASCADE", p95.x("work_spec_id"), p95.x("id")));
                                    na4 na4Var9 = new na4("WorkProgress", linkedHashMap9, linkedHashSet10, new LinkedHashSet());
                                    na4 na4VarO9 = ez4.O(go3Var, "WorkProgress");
                                    if (na4Var9.equals(na4VarO9)) {
                                        LinkedHashMap linkedHashMap10 = new LinkedHashMap();
                                        linkedHashMap10.put("key", new ka4("key", "TEXT", true, 1, null, 1));
                                        linkedHashMap10.put("long_value", new ka4("long_value", "INTEGER", false, 0, null, 1));
                                        na4 na4Var10 = new na4("Preference", linkedHashMap10, new LinkedHashSet(), new LinkedHashSet());
                                        na4 na4VarO10 = ez4.O(go3Var, "Preference");
                                        if (!na4Var10.equals(na4VarO10)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
        return new h6(true, (String) null, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc(WorkDatabase_Impl workDatabase_Impl) {
        super("08b926448d86528e697981ddd30459f7", 24, "149fd8ad55885d3fe3549a37a0163243");
        this.e = workDatabase_Impl;
    }
}
