package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ns1 extends xb5 {
    public final /* synthetic */ int B0;

    public /* synthetic */ ns1(int i) {
        this.B0 = i;
    }

    @Override // defpackage.xb5
    public final void b(io3 io3Var, Object obj) {
        int i;
        int i2 = 1;
        switch (this.B0) {
            case 0:
                io3Var.getClass();
                ((ls1) obj).getClass();
                io3Var.j(1, r8.b);
                break;
            default:
                gx4 gx4Var = (gx4) obj;
                io3Var.getClass();
                gx4Var.getClass();
                String str = gx4Var.a;
                io3Var.K(1, str);
                io3Var.j(2, uf2.Q(gx4Var.b));
                io3Var.K(3, gx4Var.c);
                io3Var.K(4, gx4Var.d);
                di0 di0Var = di0.b;
                io3Var.k(5, ek0.F(gx4Var.e));
                io3Var.k(6, ek0.F(gx4Var.f));
                io3Var.j(7, gx4Var.g);
                io3Var.j(8, gx4Var.h);
                io3Var.j(9, gx4Var.i);
                io3Var.j(10, gx4Var.k);
                ei eiVar = gx4Var.l;
                eiVar.getClass();
                int iOrdinal = eiVar.ordinal();
                if (iOrdinal == 0) {
                    i = 0;
                } else if (iOrdinal != 1) {
                    g.d();
                } else {
                    i = 1;
                }
                io3Var.j(11, i);
                io3Var.j(12, gx4Var.m);
                io3Var.j(13, gx4Var.n);
                io3Var.j(14, gx4Var.o);
                io3Var.j(15, gx4Var.p);
                io3Var.j(16, gx4Var.q ? 1L : 0L);
                ww2 ww2Var = gx4Var.r;
                ww2Var.getClass();
                int iOrdinal2 = ww2Var.ordinal();
                if (iOrdinal2 == 0) {
                    i2 = 0;
                } else if (iOrdinal2 != 1) {
                    g.d();
                }
                io3Var.j(17, i2);
                io3Var.j(18, gx4Var.s);
                io3Var.j(19, gx4Var.t);
                io3Var.j(20, gx4Var.u);
                io3Var.j(21, gx4Var.v);
                io3Var.j(22, gx4Var.w);
                String str2 = gx4Var.x;
                if (str2 == null) {
                    io3Var.l(23);
                } else {
                    io3Var.K(23, str2);
                }
                Boolean bool = gx4Var.y;
                if ((bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null) == null) {
                    io3Var.l(24);
                } else {
                    io3Var.j(24, r0.intValue());
                }
                mc0 mc0Var = gx4Var.j;
                io3Var.j(25, uf2.H(mc0Var.a));
                io3Var.k(26, uf2.q(mc0Var.b));
                io3Var.j(27, mc0Var.c ? 1L : 0L);
                io3Var.j(28, mc0Var.d ? 1L : 0L);
                io3Var.j(29, mc0Var.e ? 1L : 0L);
                io3Var.j(30, mc0Var.f ? 1L : 0L);
                io3Var.j(31, mc0Var.g);
                io3Var.j(32, mc0Var.h);
                io3Var.k(33, uf2.M(mc0Var.i));
                io3Var.K(34, str);
                break;
        }
    }

    @Override // defpackage.xb5
    public final String e() {
        switch (this.B0) {
            case 0:
                return "DELETE FROM `hosts` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`backoff_on_system_interruptions` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }
    }
}
