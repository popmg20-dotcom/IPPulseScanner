package defpackage;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r81 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ long f;

    public /* synthetic */ r81(long j, int i) {
        this.b = i;
        this.f = j;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        Integer numValueOf;
        Boolean boolValueOf;
        switch (this.b) {
            case 0:
                long j = this.f;
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                Object value = entry.getValue();
                value.getClass();
                lz1 lz1Var = (lz1) value;
                return Boolean.valueOf((lz1Var.b == kz1.z || lz1Var.b == kz1.A) && j - lz1Var.e > 300000);
            case 1:
                ((rn2) obj).c(tr1.b, Long.valueOf(this.f));
                return null;
            default:
                long j2 = this.f;
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3 io3VarD0 = go3Var.D0("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
                try {
                    io3VarD0.j(1, j2);
                    int iP = p95.p(io3VarD0, "id");
                    int iP2 = p95.p(io3VarD0, "state");
                    int iP3 = p95.p(io3VarD0, "worker_class_name");
                    int iP4 = p95.p(io3VarD0, "input_merger_class_name");
                    int iP5 = p95.p(io3VarD0, "input");
                    int iP6 = p95.p(io3VarD0, "output");
                    int iP7 = p95.p(io3VarD0, "initial_delay");
                    int iP8 = p95.p(io3VarD0, "interval_duration");
                    int iP9 = p95.p(io3VarD0, "flex_duration");
                    int iP10 = p95.p(io3VarD0, "run_attempt_count");
                    int iP11 = p95.p(io3VarD0, "backoff_policy");
                    int iP12 = p95.p(io3VarD0, "backoff_delay_duration");
                    int iP13 = p95.p(io3VarD0, "last_enqueue_time");
                    int iP14 = p95.p(io3VarD0, "minimum_retention_duration");
                    int iP15 = p95.p(io3VarD0, "schedule_requested_at");
                    int iP16 = p95.p(io3VarD0, "run_in_foreground");
                    int iP17 = p95.p(io3VarD0, "out_of_quota_policy");
                    int iP18 = p95.p(io3VarD0, "period_count");
                    int iP19 = p95.p(io3VarD0, "generation");
                    int iP20 = p95.p(io3VarD0, "next_schedule_time_override");
                    int iP21 = p95.p(io3VarD0, "next_schedule_time_override_generation");
                    int iP22 = p95.p(io3VarD0, "stop_reason");
                    int iP23 = p95.p(io3VarD0, "trace_tag");
                    int iP24 = p95.p(io3VarD0, "backoff_on_system_interruptions");
                    int iP25 = p95.p(io3VarD0, "required_network_type");
                    int iP26 = p95.p(io3VarD0, "required_network_request");
                    int iP27 = p95.p(io3VarD0, "requires_charging");
                    int iP28 = p95.p(io3VarD0, "requires_device_idle");
                    int iP29 = p95.p(io3VarD0, "requires_battery_not_low");
                    int iP30 = p95.p(io3VarD0, "requires_storage_not_low");
                    int iP31 = p95.p(io3VarD0, "trigger_content_update_delay");
                    int iP32 = p95.p(io3VarD0, "trigger_max_content_delay");
                    int iP33 = p95.p(io3VarD0, "content_uri_triggers");
                    ArrayList arrayList = new ArrayList();
                    while (io3VarD0.C0()) {
                        String strE0 = io3VarD0.e0(iP);
                        int i = iP14;
                        ArrayList arrayList2 = arrayList;
                        ww4 ww4VarD = uf2.D((int) io3VarD0.getLong(iP2));
                        String strE02 = io3VarD0.e0(iP3);
                        String strE03 = io3VarD0.e0(iP4);
                        byte[] blob = io3VarD0.getBlob(iP5);
                        di0 di0Var = di0.b;
                        di0 di0VarI = ek0.i(blob);
                        di0 di0VarI2 = ek0.i(io3VarD0.getBlob(iP6));
                        long j3 = io3VarD0.getLong(iP7);
                        long j4 = io3VarD0.getLong(iP8);
                        long j5 = io3VarD0.getLong(iP9);
                        int i2 = (int) io3VarD0.getLong(iP10);
                        int i3 = iP;
                        int i4 = iP2;
                        ei eiVarA = uf2.A((int) io3VarD0.getLong(iP11));
                        long j6 = io3VarD0.getLong(iP12);
                        long j7 = io3VarD0.getLong(iP13);
                        long j8 = io3VarD0.getLong(i);
                        int i5 = iP15;
                        long j9 = io3VarD0.getLong(i5);
                        int i6 = iP13;
                        int i7 = iP16;
                        boolean z = ((int) io3VarD0.getLong(i7)) != 0;
                        int i8 = iP17;
                        ww2 ww2VarC = uf2.C((int) io3VarD0.getLong(i8));
                        iP17 = i8;
                        int i9 = iP18;
                        int i10 = (int) io3VarD0.getLong(i9);
                        iP18 = i9;
                        int i11 = iP19;
                        int i12 = (int) io3VarD0.getLong(i11);
                        int i13 = iP20;
                        long j10 = io3VarD0.getLong(i13);
                        int i14 = iP21;
                        int i15 = (int) io3VarD0.getLong(i14);
                        iP21 = i14;
                        int i16 = iP22;
                        int i17 = (int) io3VarD0.getLong(i16);
                        int i18 = iP23;
                        String strE04 = io3VarD0.isNull(i18) ? null : io3VarD0.e0(i18);
                        int i19 = iP24;
                        if (io3VarD0.isNull(i19)) {
                            iP23 = i18;
                            iP22 = i16;
                            numValueOf = null;
                        } else {
                            iP23 = i18;
                            iP22 = i16;
                            numValueOf = Integer.valueOf((int) io3VarD0.getLong(i19));
                        }
                        if (numValueOf != null) {
                            boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        } else {
                            boolValueOf = null;
                        }
                        int i20 = iP25;
                        pr2 pr2VarB = uf2.B((int) io3VarD0.getLong(i20));
                        int i21 = iP26;
                        hr2 hr2VarR = uf2.R(io3VarD0.getBlob(i21));
                        int i22 = iP27;
                        boolean z2 = ((int) io3VarD0.getLong(i22)) != 0;
                        int i23 = iP28;
                        boolean z3 = ((int) io3VarD0.getLong(i23)) != 0;
                        int i24 = iP29;
                        boolean z4 = ((int) io3VarD0.getLong(i24)) != 0;
                        iP29 = i24;
                        int i25 = iP30;
                        int i26 = iP31;
                        int i27 = iP32;
                        iP31 = i26;
                        int i28 = iP33;
                        iP33 = i28;
                        iP32 = i27;
                        arrayList2.add(new gx4(strE0, ww4VarD, strE02, strE03, di0VarI, di0VarI2, j3, j4, j5, new mc0(hr2VarR, pr2VarB, z2, z3, z4, ((int) io3VarD0.getLong(i25)) != 0, io3VarD0.getLong(i26), io3VarD0.getLong(i27), uf2.e(io3VarD0.getBlob(i28))), i2, eiVarA, j6, j7, j8, j9, z, ww2VarC, i10, i12, j10, i15, i17, strE04, boolValueOf));
                        iP30 = i25;
                        iP = i3;
                        iP13 = i6;
                        iP15 = i5;
                        arrayList = arrayList2;
                        iP16 = i7;
                        iP19 = i11;
                        iP20 = i13;
                        iP24 = i19;
                        iP25 = i20;
                        iP26 = i21;
                        iP27 = i22;
                        iP2 = i4;
                        iP28 = i23;
                        iP14 = i;
                        break;
                    }
                    ArrayList arrayList3 = arrayList;
                    io3VarD0.close();
                    return arrayList3;
                } catch (Throwable th) {
                    io3VarD0.close();
                    throw th;
                }
        }
    }
}
