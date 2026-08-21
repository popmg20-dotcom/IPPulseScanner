package defpackage;

import com.getsurfboard.ui.SurfboardApp;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q74 implements am1 {
    public final /* synthetic */ int b;

    private final Object c(Object obj) throws Exception {
        int i;
        Integer numValueOf;
        go3 go3Var = (go3) obj;
        go3Var.getClass();
        io3 io3VarD0 = go3Var.D0("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        try {
            io3VarD0.j(1, 200L);
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
                int i2 = iP13;
                int i3 = iP14;
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
                int i4 = (int) io3VarD0.getLong(iP10);
                int i5 = iP;
                int i6 = iP2;
                ei eiVarA = uf2.A((int) io3VarD0.getLong(iP11));
                long j4 = io3VarD0.getLong(iP12);
                long j5 = io3VarD0.getLong(i2);
                long j6 = io3VarD0.getLong(i3);
                int i7 = iP15;
                long j7 = io3VarD0.getLong(i7);
                iP15 = i7;
                int i8 = iP16;
                int i9 = iP3;
                boolean z = ((int) io3VarD0.getLong(i8)) != 0;
                int i10 = iP17;
                int i11 = iP4;
                ww2 ww2VarC = uf2.C((int) io3VarD0.getLong(i10));
                int i12 = iP18;
                int i13 = (int) io3VarD0.getLong(i12);
                int i14 = iP19;
                int i15 = (int) io3VarD0.getLong(i14);
                int i16 = iP20;
                long j8 = io3VarD0.getLong(i16);
                int i17 = iP21;
                int i18 = (int) io3VarD0.getLong(i17);
                iP21 = i17;
                int i19 = iP22;
                int i20 = (int) io3VarD0.getLong(i19);
                int i21 = iP23;
                Boolean boolValueOf = null;
                String strE04 = io3VarD0.isNull(i21) ? null : io3VarD0.e0(i21);
                int i22 = iP24;
                if (io3VarD0.isNull(i22)) {
                    i = i21;
                    iP22 = i19;
                    numValueOf = null;
                } else {
                    i = i21;
                    iP22 = i19;
                    numValueOf = Integer.valueOf((int) io3VarD0.getLong(i22));
                }
                if (numValueOf != null) {
                    boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                }
                Boolean bool = boolValueOf;
                int i23 = iP25;
                pr2 pr2VarB = uf2.B((int) io3VarD0.getLong(i23));
                int i24 = iP26;
                hr2 hr2VarR = uf2.R(io3VarD0.getBlob(i24));
                int i25 = iP27;
                boolean z2 = ((int) io3VarD0.getLong(i25)) != 0;
                int i26 = iP28;
                boolean z3 = ((int) io3VarD0.getLong(i26)) != 0;
                int i27 = iP29;
                boolean z4 = ((int) io3VarD0.getLong(i27)) != 0;
                iP29 = i27;
                int i28 = iP30;
                int i29 = iP31;
                int i30 = iP32;
                iP31 = i29;
                int i31 = iP33;
                arrayList.add(new gx4(strE0, ww4VarD, strE02, strE03, di0VarI, di0VarI2, j, j2, j3, new mc0(hr2VarR, pr2VarB, z2, z3, z4, ((int) io3VarD0.getLong(i28)) != 0, io3VarD0.getLong(i29), io3VarD0.getLong(i30), uf2.e(io3VarD0.getBlob(i31))), i4, eiVarA, j4, j5, j6, j7, z, ww2VarC, i13, i15, j8, i18, i20, strE04, bool));
                iP28 = i26;
                iP4 = i11;
                iP17 = i10;
                iP18 = i12;
                iP19 = i14;
                iP20 = i16;
                iP23 = i;
                iP24 = i22;
                iP25 = i23;
                iP26 = i24;
                iP27 = i25;
                iP33 = i31;
                iP32 = i30;
                iP30 = i28;
                iP = i5;
                iP3 = i9;
                iP13 = i2;
                iP14 = i3;
                iP2 = i6;
                iP16 = i8;
            }
            io3VarD0.close();
            return arrayList;
        } catch (Throwable th) {
            io3VarD0.close();
            throw th;
        }
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        Integer numValueOf;
        Boolean boolValueOf;
        Integer numValueOf2;
        Boolean boolValueOf2;
        Integer numValueOf3;
        Boolean boolValueOf3;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        z = false;
        boolean z = false;
        switch (i) {
            case 0:
                int i2 = SurfboardApp.A;
                l72.U();
                return xl4Var;
            case 1:
                int i3 = SurfboardApp.A;
                ji0.S();
                return xl4Var;
            case 2:
                int i4 = SurfboardApp.A;
                xb5.I();
                return xl4Var;
            case 3:
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3 io3VarD0 = go3Var.D0("SELECT DISTINCT work_spec_id FROM SystemIdInfo");
                try {
                    ArrayList arrayList = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList;
                } finally {
                }
            case 4:
                yh3 yh3Var = (yh3) obj;
                String strH = yh3Var.H();
                long j = yh3Var.Y;
                yr2.g(16);
                String string = Long.toString(j, 16);
                string.getClass();
                return ha0.o(strH, " ", p44.D0(string, 16, '0'));
            case 5:
                ((Boolean) obj).booleanValue();
                return xl4Var;
            case 6:
                io3 io3Var = (io3) obj;
                io3Var.getClass();
                return Boolean.valueOf(io3Var.C0());
            case 7:
                io3 io3Var2 = (io3) obj;
                io3Var2.getClass();
                cu3 cu3Var = new cu3();
                while (io3Var2.C0()) {
                    cu3Var.add(Integer.valueOf((int) io3Var2.getLong(0)));
                }
                return yr2.b(cu3Var);
            case 8:
                nb0 nb0Var = (nb0) obj;
                nb0Var.getClass();
                return nb0Var.getClass().getSimpleName();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                go3 go3Var2 = (go3) obj;
                go3Var2.getClass();
                try {
                    go3Var2.D0("DELETE FROM WorkProgress").C0();
                    return xl4Var;
                } finally {
                }
            case 10:
                go3 go3Var3 = (go3) obj;
                go3Var3.getClass();
                io3 io3VarD02 = go3Var3.D0("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
                try {
                    int iP = p95.p(io3VarD02, "id");
                    int iP2 = p95.p(io3VarD02, "state");
                    int iP3 = p95.p(io3VarD02, "worker_class_name");
                    int iP4 = p95.p(io3VarD02, "input_merger_class_name");
                    int iP5 = p95.p(io3VarD02, "input");
                    int iP6 = p95.p(io3VarD02, "output");
                    int iP7 = p95.p(io3VarD02, "initial_delay");
                    int iP8 = p95.p(io3VarD02, "interval_duration");
                    int iP9 = p95.p(io3VarD02, "flex_duration");
                    int iP10 = p95.p(io3VarD02, "run_attempt_count");
                    int iP11 = p95.p(io3VarD02, "backoff_policy");
                    int iP12 = p95.p(io3VarD02, "backoff_delay_duration");
                    int iP13 = p95.p(io3VarD02, "last_enqueue_time");
                    int iP14 = p95.p(io3VarD02, "minimum_retention_duration");
                    int iP15 = p95.p(io3VarD02, "schedule_requested_at");
                    int iP16 = p95.p(io3VarD02, "run_in_foreground");
                    int iP17 = p95.p(io3VarD02, "out_of_quota_policy");
                    int iP18 = p95.p(io3VarD02, "period_count");
                    int iP19 = p95.p(io3VarD02, "generation");
                    int iP20 = p95.p(io3VarD02, "next_schedule_time_override");
                    int iP21 = p95.p(io3VarD02, "next_schedule_time_override_generation");
                    int iP22 = p95.p(io3VarD02, "stop_reason");
                    int iP23 = p95.p(io3VarD02, "trace_tag");
                    int iP24 = p95.p(io3VarD02, "backoff_on_system_interruptions");
                    int iP25 = p95.p(io3VarD02, "required_network_type");
                    int iP26 = p95.p(io3VarD02, "required_network_request");
                    int iP27 = p95.p(io3VarD02, "requires_charging");
                    int iP28 = p95.p(io3VarD02, "requires_device_idle");
                    int iP29 = p95.p(io3VarD02, "requires_battery_not_low");
                    int iP30 = p95.p(io3VarD02, "requires_storage_not_low");
                    int iP31 = p95.p(io3VarD02, "trigger_content_update_delay");
                    int iP32 = p95.p(io3VarD02, "trigger_max_content_delay");
                    int iP33 = p95.p(io3VarD02, "content_uri_triggers");
                    ArrayList arrayList2 = new ArrayList();
                    while (io3VarD02.C0()) {
                        String strE0 = io3VarD02.e0(iP);
                        int i5 = iP14;
                        int i6 = iP13;
                        ww4 ww4VarD = uf2.D((int) io3VarD02.getLong(iP2));
                        String strE02 = io3VarD02.e0(iP3);
                        String strE03 = io3VarD02.e0(iP4);
                        byte[] blob = io3VarD02.getBlob(iP5);
                        di0 di0Var = di0.b;
                        di0 di0VarI = ek0.i(blob);
                        di0 di0VarI2 = ek0.i(io3VarD02.getBlob(iP6));
                        long j2 = io3VarD02.getLong(iP7);
                        long j3 = io3VarD02.getLong(iP8);
                        long j4 = io3VarD02.getLong(iP9);
                        int i7 = (int) io3VarD02.getLong(iP10);
                        int i8 = iP4;
                        int i9 = iP3;
                        ei eiVarA = uf2.A((int) io3VarD02.getLong(iP11));
                        long j5 = io3VarD02.getLong(iP12);
                        long j6 = io3VarD02.getLong(i6);
                        long j7 = io3VarD02.getLong(i5);
                        int i10 = iP15;
                        long j8 = io3VarD02.getLong(i10);
                        iP15 = i10;
                        int i11 = iP16;
                        int i12 = iP2;
                        boolean z2 = ((int) io3VarD02.getLong(i11)) != 0;
                        int i13 = iP17;
                        int i14 = iP;
                        ww2 ww2VarC = uf2.C((int) io3VarD02.getLong(i13));
                        int i15 = iP18;
                        int i16 = (int) io3VarD02.getLong(i15);
                        int i17 = iP19;
                        int i18 = (int) io3VarD02.getLong(i17);
                        int i19 = iP20;
                        long j9 = io3VarD02.getLong(i19);
                        int i20 = iP21;
                        int i21 = (int) io3VarD02.getLong(i20);
                        iP21 = i20;
                        int i22 = iP22;
                        int i23 = (int) io3VarD02.getLong(i22);
                        int i24 = iP23;
                        String strE04 = io3VarD02.isNull(i24) ? null : io3VarD02.e0(i24);
                        int i25 = iP24;
                        if (io3VarD02.isNull(i25)) {
                            iP23 = i24;
                            iP22 = i22;
                            numValueOf = null;
                        } else {
                            iP23 = i24;
                            iP22 = i22;
                            numValueOf = Integer.valueOf((int) io3VarD02.getLong(i25));
                        }
                        if (numValueOf != null) {
                            boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        } else {
                            boolValueOf = null;
                        }
                        int i26 = iP25;
                        pr2 pr2VarB = uf2.B((int) io3VarD02.getLong(i26));
                        int i27 = iP26;
                        hr2 hr2VarR = uf2.R(io3VarD02.getBlob(i27));
                        int i28 = iP27;
                        boolean z3 = ((int) io3VarD02.getLong(i28)) != 0;
                        int i29 = iP28;
                        boolean z4 = ((int) io3VarD02.getLong(i29)) != 0;
                        int i30 = iP29;
                        boolean z5 = ((int) io3VarD02.getLong(i30)) != 0;
                        iP29 = i30;
                        int i31 = iP30;
                        int i32 = iP31;
                        int i33 = iP32;
                        iP31 = i32;
                        int i34 = iP33;
                        arrayList2.add(new gx4(strE0, ww4VarD, strE02, strE03, di0VarI, di0VarI2, j2, j3, j4, new mc0(hr2VarR, pr2VarB, z3, z4, z5, ((int) io3VarD02.getLong(i31)) != 0, io3VarD02.getLong(i32), io3VarD02.getLong(i33), uf2.e(io3VarD02.getBlob(i34))), i7, eiVarA, j5, j6, j7, j8, z2, ww2VarC, i16, i18, j9, i21, i23, strE04, boolValueOf));
                        iP28 = i29;
                        iP = i14;
                        iP17 = i13;
                        iP18 = i15;
                        iP19 = i17;
                        iP20 = i19;
                        iP24 = i25;
                        iP25 = i26;
                        iP26 = i27;
                        iP27 = i28;
                        iP33 = i34;
                        iP32 = i33;
                        iP30 = i31;
                        iP3 = i9;
                        iP13 = i6;
                        iP14 = i5;
                        iP4 = i8;
                        iP2 = i12;
                        iP16 = i11;
                        break;
                    }
                    return arrayList2;
                } finally {
                }
            case 11:
                go3 go3Var4 = (go3) obj;
                go3Var4.getClass();
                io3 io3VarD03 = go3Var4.D0("SELECT * FROM workspec WHERE state=1");
                try {
                    int iP34 = p95.p(io3VarD03, "id");
                    int iP35 = p95.p(io3VarD03, "state");
                    int iP36 = p95.p(io3VarD03, "worker_class_name");
                    int iP37 = p95.p(io3VarD03, "input_merger_class_name");
                    int iP38 = p95.p(io3VarD03, "input");
                    int iP39 = p95.p(io3VarD03, "output");
                    int iP40 = p95.p(io3VarD03, "initial_delay");
                    int iP41 = p95.p(io3VarD03, "interval_duration");
                    int iP42 = p95.p(io3VarD03, "flex_duration");
                    int iP43 = p95.p(io3VarD03, "run_attempt_count");
                    int iP44 = p95.p(io3VarD03, "backoff_policy");
                    int iP45 = p95.p(io3VarD03, "backoff_delay_duration");
                    int iP46 = p95.p(io3VarD03, "last_enqueue_time");
                    int iP47 = p95.p(io3VarD03, "minimum_retention_duration");
                    int iP48 = p95.p(io3VarD03, "schedule_requested_at");
                    int iP49 = p95.p(io3VarD03, "run_in_foreground");
                    int iP50 = p95.p(io3VarD03, "out_of_quota_policy");
                    int iP51 = p95.p(io3VarD03, "period_count");
                    int iP52 = p95.p(io3VarD03, "generation");
                    int iP53 = p95.p(io3VarD03, "next_schedule_time_override");
                    int iP54 = p95.p(io3VarD03, "next_schedule_time_override_generation");
                    int iP55 = p95.p(io3VarD03, "stop_reason");
                    int iP56 = p95.p(io3VarD03, "trace_tag");
                    int iP57 = p95.p(io3VarD03, "backoff_on_system_interruptions");
                    int iP58 = p95.p(io3VarD03, "required_network_type");
                    int iP59 = p95.p(io3VarD03, "required_network_request");
                    int iP60 = p95.p(io3VarD03, "requires_charging");
                    int iP61 = p95.p(io3VarD03, "requires_device_idle");
                    int iP62 = p95.p(io3VarD03, "requires_battery_not_low");
                    int iP63 = p95.p(io3VarD03, "requires_storage_not_low");
                    int iP64 = p95.p(io3VarD03, "trigger_content_update_delay");
                    int iP65 = p95.p(io3VarD03, "trigger_max_content_delay");
                    int iP66 = p95.p(io3VarD03, "content_uri_triggers");
                    ArrayList arrayList3 = new ArrayList();
                    while (io3VarD03.C0()) {
                        String strE05 = io3VarD03.e0(iP34);
                        int i35 = iP47;
                        int i36 = iP46;
                        ww4 ww4VarD2 = uf2.D((int) io3VarD03.getLong(iP35));
                        String strE06 = io3VarD03.e0(iP36);
                        String strE07 = io3VarD03.e0(iP37);
                        byte[] blob2 = io3VarD03.getBlob(iP38);
                        di0 di0Var2 = di0.b;
                        di0 di0VarI3 = ek0.i(blob2);
                        di0 di0VarI4 = ek0.i(io3VarD03.getBlob(iP39));
                        long j10 = io3VarD03.getLong(iP40);
                        long j11 = io3VarD03.getLong(iP41);
                        long j12 = io3VarD03.getLong(iP42);
                        int i37 = (int) io3VarD03.getLong(iP43);
                        int i38 = iP37;
                        int i39 = iP36;
                        ei eiVarA2 = uf2.A((int) io3VarD03.getLong(iP44));
                        long j13 = io3VarD03.getLong(iP45);
                        long j14 = io3VarD03.getLong(i36);
                        long j15 = io3VarD03.getLong(i35);
                        int i40 = iP48;
                        long j16 = io3VarD03.getLong(i40);
                        int i41 = iP35;
                        int i42 = iP49;
                        boolean z6 = ((int) io3VarD03.getLong(i42)) != 0;
                        int i43 = iP34;
                        int i44 = iP50;
                        ww2 ww2VarC2 = uf2.C((int) io3VarD03.getLong(i44));
                        iP50 = i44;
                        int i45 = iP51;
                        int i46 = (int) io3VarD03.getLong(i45);
                        iP51 = i45;
                        int i47 = iP52;
                        int i48 = (int) io3VarD03.getLong(i47);
                        int i49 = iP53;
                        long j17 = io3VarD03.getLong(i49);
                        int i50 = iP54;
                        int i51 = (int) io3VarD03.getLong(i50);
                        iP54 = i50;
                        int i52 = iP55;
                        int i53 = (int) io3VarD03.getLong(i52);
                        int i54 = iP56;
                        String strE08 = io3VarD03.isNull(i54) ? null : io3VarD03.e0(i54);
                        int i55 = iP57;
                        if (io3VarD03.isNull(i55)) {
                            iP56 = i54;
                            iP55 = i52;
                            numValueOf2 = null;
                        } else {
                            iP56 = i54;
                            iP55 = i52;
                            numValueOf2 = Integer.valueOf((int) io3VarD03.getLong(i55));
                        }
                        if (numValueOf2 != null) {
                            boolValueOf2 = Boolean.valueOf(numValueOf2.intValue() != 0);
                        } else {
                            boolValueOf2 = null;
                        }
                        int i56 = iP58;
                        pr2 pr2VarB2 = uf2.B((int) io3VarD03.getLong(i56));
                        int i57 = iP59;
                        hr2 hr2VarR2 = uf2.R(io3VarD03.getBlob(i57));
                        int i58 = iP60;
                        boolean z7 = ((int) io3VarD03.getLong(i58)) != 0;
                        int i59 = iP61;
                        boolean z8 = ((int) io3VarD03.getLong(i59)) != 0;
                        int i60 = iP62;
                        boolean z9 = ((int) io3VarD03.getLong(i60)) != 0;
                        iP62 = i60;
                        int i61 = iP63;
                        int i62 = iP64;
                        int i63 = iP65;
                        iP64 = i62;
                        int i64 = iP66;
                        arrayList3.add(new gx4(strE05, ww4VarD2, strE06, strE07, di0VarI3, di0VarI4, j10, j11, j12, new mc0(hr2VarR2, pr2VarB2, z7, z8, z9, ((int) io3VarD03.getLong(i61)) != 0, io3VarD03.getLong(i62), io3VarD03.getLong(i63), uf2.e(io3VarD03.getBlob(i64))), i37, eiVarA2, j13, j14, j15, j16, z6, ww2VarC2, i46, i48, j17, i51, i53, strE08, boolValueOf2));
                        iP34 = i43;
                        iP49 = i42;
                        iP52 = i47;
                        iP53 = i49;
                        iP57 = i55;
                        iP58 = i56;
                        iP59 = i57;
                        iP60 = i58;
                        iP61 = i59;
                        iP66 = i64;
                        iP65 = i63;
                        iP63 = i61;
                        iP47 = i35;
                        iP36 = i39;
                        iP37 = i38;
                        iP35 = i41;
                        iP48 = i40;
                        iP46 = i36;
                        break;
                    }
                    return arrayList3;
                } finally {
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                go3 go3Var5 = (go3) obj;
                go3Var5.getClass();
                io3 io3VarD04 = go3Var5.D0("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
                try {
                    io3VarD04.K(1, "UpdateProfileWorker");
                    ArrayList arrayList4 = new ArrayList();
                    while (io3VarD04.C0()) {
                        arrayList4.add(io3VarD04.e0(0));
                        break;
                    }
                    return arrayList4;
                } finally {
                }
            case 13:
                go3 go3Var6 = (go3) obj;
                go3Var6.getClass();
                io3 io3VarD05 = go3Var6.D0("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
                try {
                    int iP67 = p95.p(io3VarD05, "id");
                    int iP68 = p95.p(io3VarD05, "state");
                    int iP69 = p95.p(io3VarD05, "worker_class_name");
                    int iP70 = p95.p(io3VarD05, "input_merger_class_name");
                    int iP71 = p95.p(io3VarD05, "input");
                    int iP72 = p95.p(io3VarD05, "output");
                    int iP73 = p95.p(io3VarD05, "initial_delay");
                    int iP74 = p95.p(io3VarD05, "interval_duration");
                    int iP75 = p95.p(io3VarD05, "flex_duration");
                    int iP76 = p95.p(io3VarD05, "run_attempt_count");
                    int iP77 = p95.p(io3VarD05, "backoff_policy");
                    int iP78 = p95.p(io3VarD05, "backoff_delay_duration");
                    int iP79 = p95.p(io3VarD05, "last_enqueue_time");
                    int iP80 = p95.p(io3VarD05, "minimum_retention_duration");
                    int iP81 = p95.p(io3VarD05, "schedule_requested_at");
                    int iP82 = p95.p(io3VarD05, "run_in_foreground");
                    int iP83 = p95.p(io3VarD05, "out_of_quota_policy");
                    int iP84 = p95.p(io3VarD05, "period_count");
                    int iP85 = p95.p(io3VarD05, "generation");
                    int iP86 = p95.p(io3VarD05, "next_schedule_time_override");
                    int iP87 = p95.p(io3VarD05, "next_schedule_time_override_generation");
                    int iP88 = p95.p(io3VarD05, "stop_reason");
                    int iP89 = p95.p(io3VarD05, "trace_tag");
                    int iP90 = p95.p(io3VarD05, "backoff_on_system_interruptions");
                    int iP91 = p95.p(io3VarD05, "required_network_type");
                    int iP92 = p95.p(io3VarD05, "required_network_request");
                    int iP93 = p95.p(io3VarD05, "requires_charging");
                    int iP94 = p95.p(io3VarD05, "requires_device_idle");
                    int iP95 = p95.p(io3VarD05, "requires_battery_not_low");
                    int iP96 = p95.p(io3VarD05, "requires_storage_not_low");
                    int iP97 = p95.p(io3VarD05, "trigger_content_update_delay");
                    int iP98 = p95.p(io3VarD05, "trigger_max_content_delay");
                    int iP99 = p95.p(io3VarD05, "content_uri_triggers");
                    ArrayList arrayList5 = new ArrayList();
                    while (io3VarD05.C0()) {
                        String strE09 = io3VarD05.e0(iP67);
                        int i65 = iP80;
                        int i66 = iP79;
                        ww4 ww4VarD3 = uf2.D((int) io3VarD05.getLong(iP68));
                        String strE010 = io3VarD05.e0(iP69);
                        String strE011 = io3VarD05.e0(iP70);
                        byte[] blob3 = io3VarD05.getBlob(iP71);
                        di0 di0Var3 = di0.b;
                        di0 di0VarI5 = ek0.i(blob3);
                        di0 di0VarI6 = ek0.i(io3VarD05.getBlob(iP72));
                        long j18 = io3VarD05.getLong(iP73);
                        long j19 = io3VarD05.getLong(iP74);
                        long j20 = io3VarD05.getLong(iP75);
                        int i67 = (int) io3VarD05.getLong(iP76);
                        int i68 = iP70;
                        int i69 = iP69;
                        ei eiVarA3 = uf2.A((int) io3VarD05.getLong(iP77));
                        long j21 = io3VarD05.getLong(iP78);
                        long j22 = io3VarD05.getLong(i66);
                        long j23 = io3VarD05.getLong(i65);
                        int i70 = iP81;
                        long j24 = io3VarD05.getLong(i70);
                        int i71 = iP68;
                        int i72 = iP82;
                        boolean z10 = ((int) io3VarD05.getLong(i72)) != 0;
                        int i73 = iP67;
                        int i74 = iP83;
                        ww2 ww2VarC3 = uf2.C((int) io3VarD05.getLong(i74));
                        iP83 = i74;
                        int i75 = iP84;
                        int i76 = (int) io3VarD05.getLong(i75);
                        iP84 = i75;
                        int i77 = iP85;
                        int i78 = (int) io3VarD05.getLong(i77);
                        int i79 = iP86;
                        long j25 = io3VarD05.getLong(i79);
                        int i80 = iP87;
                        int i81 = (int) io3VarD05.getLong(i80);
                        iP87 = i80;
                        int i82 = iP88;
                        int i83 = (int) io3VarD05.getLong(i82);
                        int i84 = iP89;
                        String strE012 = io3VarD05.isNull(i84) ? null : io3VarD05.e0(i84);
                        int i85 = iP90;
                        if (io3VarD05.isNull(i85)) {
                            iP89 = i84;
                            iP88 = i82;
                            numValueOf3 = null;
                        } else {
                            iP89 = i84;
                            iP88 = i82;
                            numValueOf3 = Integer.valueOf((int) io3VarD05.getLong(i85));
                        }
                        if (numValueOf3 != null) {
                            boolValueOf3 = Boolean.valueOf(numValueOf3.intValue() != 0);
                        } else {
                            boolValueOf3 = null;
                        }
                        int i86 = iP91;
                        pr2 pr2VarB3 = uf2.B((int) io3VarD05.getLong(i86));
                        int i87 = iP92;
                        hr2 hr2VarR3 = uf2.R(io3VarD05.getBlob(i87));
                        int i88 = iP93;
                        boolean z11 = ((int) io3VarD05.getLong(i88)) != 0;
                        int i89 = iP94;
                        boolean z12 = ((int) io3VarD05.getLong(i89)) != 0;
                        int i90 = iP95;
                        boolean z13 = ((int) io3VarD05.getLong(i90)) != 0;
                        iP95 = i90;
                        int i91 = iP96;
                        int i92 = iP97;
                        int i93 = iP98;
                        iP97 = i92;
                        int i94 = iP99;
                        arrayList5.add(new gx4(strE09, ww4VarD3, strE010, strE011, di0VarI5, di0VarI6, j18, j19, j20, new mc0(hr2VarR3, pr2VarB3, z11, z12, z13, ((int) io3VarD05.getLong(i91)) != 0, io3VarD05.getLong(i92), io3VarD05.getLong(i93), uf2.e(io3VarD05.getBlob(i94))), i67, eiVarA3, j21, j22, j23, j24, z10, ww2VarC3, i76, i78, j25, i81, i83, strE012, boolValueOf3));
                        iP67 = i73;
                        iP82 = i72;
                        iP85 = i77;
                        iP86 = i79;
                        iP90 = i85;
                        iP91 = i86;
                        iP92 = i87;
                        iP93 = i88;
                        iP94 = i89;
                        iP99 = i94;
                        iP98 = i93;
                        iP96 = i91;
                        iP80 = i65;
                        iP69 = i69;
                        iP70 = i68;
                        iP68 = i71;
                        iP81 = i70;
                        iP79 = i66;
                        break;
                    }
                    return arrayList5;
                } finally {
                }
            case 14:
                go3 go3Var7 = (go3) obj;
                go3Var7.getClass();
                io3 io3VarD06 = go3Var7.D0("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
                try {
                    int i95 = io3VarD06.C0() ? (int) io3VarD06.getLong(0) : 0;
                    io3VarD06.close();
                    return Integer.valueOf(i95);
                } finally {
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                go3 go3Var8 = (go3) obj;
                go3Var8.getClass();
                io3 io3VarD07 = go3Var8.D0("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
                try {
                    if (io3VarD07.C0()) {
                        if (((int) io3VarD07.getLong(0)) != 0) {
                            z = true;
                        }
                    }
                    io3VarD07.close();
                    return Boolean.valueOf(z);
                } finally {
                }
            case 16:
                return c(obj);
            default:
                go3 go3Var9 = (go3) obj;
                go3Var9.getClass();
                io3 io3VarD08 = go3Var9.D0("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)");
                try {
                    io3VarD08.C0();
                    int iC = r25.C(go3Var9);
                    io3VarD08.close();
                    return Integer.valueOf(iC);
                } finally {
                }
        }
    }

    public /* synthetic */ q74(int i) {
        this.b = i;
    }
}
