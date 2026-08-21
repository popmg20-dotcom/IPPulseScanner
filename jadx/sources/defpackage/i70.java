package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i70 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;

    public /* synthetic */ i70(int i, int i2) {
        this.b = i2;
        this.f = i;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i;
        Integer numValueOf;
        int i2 = this.b;
        int i3 = this.f;
        switch (i2) {
            case 0:
                ((Integer) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i3 + '.');
            default:
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3 io3VarD0 = go3Var.D0("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
                try {
                    io3VarD0.j(1, i3);
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
                        int i4 = iP13;
                        int i5 = iP14;
                        ww4 ww4VarD = uf2.D((int) io3VarD0.getLong(iP2));
                        String strE02 = io3VarD0.e0(iP3);
                        String strE03 = io3VarD0.e0(iP4);
                        byte[] blob = io3VarD0.getBlob(iP5);
                        di0 di0Var = di0.b;
                        di0 di0VarI = ek0.i(blob);
                        di0 di0VarI2 = ek0.i(io3VarD0.getBlob(iP6));
                        long j = io3VarD0.getLong(iP7);
                        long j2 = io3VarD0.getLong(iP8);
                        long j3 = io3VarD0.getLong(iP9);
                        int i6 = (int) io3VarD0.getLong(iP10);
                        int i7 = iP;
                        int i8 = iP2;
                        ei eiVarA = uf2.A((int) io3VarD0.getLong(iP11));
                        long j4 = io3VarD0.getLong(iP12);
                        long j5 = io3VarD0.getLong(i4);
                        long j6 = io3VarD0.getLong(i5);
                        int i9 = iP15;
                        long j7 = io3VarD0.getLong(i9);
                        iP15 = i9;
                        int i10 = iP16;
                        int i11 = iP3;
                        boolean z = ((int) io3VarD0.getLong(i10)) != 0;
                        int i12 = iP17;
                        int i13 = iP4;
                        ww2 ww2VarC = uf2.C((int) io3VarD0.getLong(i12));
                        int i14 = iP18;
                        int i15 = (int) io3VarD0.getLong(i14);
                        int i16 = iP19;
                        int i17 = (int) io3VarD0.getLong(i16);
                        int i18 = iP20;
                        long j8 = io3VarD0.getLong(i18);
                        int i19 = iP21;
                        int i20 = (int) io3VarD0.getLong(i19);
                        iP21 = i19;
                        int i21 = iP22;
                        int i22 = (int) io3VarD0.getLong(i21);
                        int i23 = iP23;
                        Boolean boolValueOf = null;
                        String strE04 = io3VarD0.isNull(i23) ? null : io3VarD0.e0(i23);
                        int i24 = iP24;
                        if (io3VarD0.isNull(i24)) {
                            i = i23;
                            iP22 = i21;
                            numValueOf = null;
                        } else {
                            i = i23;
                            iP22 = i21;
                            numValueOf = Integer.valueOf((int) io3VarD0.getLong(i24));
                        }
                        if (numValueOf != null) {
                            boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        }
                        Boolean bool = boolValueOf;
                        int i25 = iP25;
                        pr2 pr2VarB = uf2.B((int) io3VarD0.getLong(i25));
                        int i26 = iP26;
                        hr2 hr2VarR = uf2.R(io3VarD0.getBlob(i26));
                        int i27 = iP27;
                        boolean z2 = ((int) io3VarD0.getLong(i27)) != 0;
                        int i28 = iP28;
                        boolean z3 = ((int) io3VarD0.getLong(i28)) != 0;
                        int i29 = iP29;
                        boolean z4 = ((int) io3VarD0.getLong(i29)) != 0;
                        iP29 = i29;
                        int i30 = iP30;
                        int i31 = iP31;
                        int i32 = iP32;
                        iP31 = i31;
                        int i33 = iP33;
                        arrayList.add(new gx4(strE0, ww4VarD, strE02, strE03, di0VarI, di0VarI2, j, j2, j3, new mc0(hr2VarR, pr2VarB, z2, z3, z4, ((int) io3VarD0.getLong(i30)) != 0, io3VarD0.getLong(i31), io3VarD0.getLong(i32), uf2.e(io3VarD0.getBlob(i33))), i6, eiVarA, j4, j5, j6, j7, z, ww2VarC, i15, i17, j8, i20, i22, strE04, bool));
                        iP28 = i28;
                        iP4 = i13;
                        iP17 = i12;
                        iP18 = i14;
                        iP19 = i16;
                        iP20 = i18;
                        iP23 = i;
                        iP24 = i24;
                        iP25 = i25;
                        iP26 = i26;
                        iP27 = i27;
                        iP33 = i33;
                        iP32 = i32;
                        iP30 = i30;
                        iP = i7;
                        iP3 = i11;
                        iP13 = i4;
                        iP14 = i5;
                        iP2 = i8;
                        iP16 = i10;
                        break;
                    }
                    io3VarD0.close();
                    return arrayList;
                } catch (Throwable th) {
                    io3VarD0.close();
                    throw th;
                }
        }
    }
}
