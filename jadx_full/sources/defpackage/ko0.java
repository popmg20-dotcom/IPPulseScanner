package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ko0 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;

    public /* synthetic */ ko0(String str, int i) {
        this.b = i;
        this.f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x064b  */
    @Override // defpackage.am1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Object obj) throws Exception {
        io3 io3VarD0;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Long lValueOf;
        gx4 gx4Var;
        Boolean boolValueOf;
        ww4 ww4VarD;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        String str = this.f;
        switch (i) {
            case 0:
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3VarD0 = go3Var.D0("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?");
                try {
                    io3VarD0.K(1, str);
                    if (io3VarD0.C0()) {
                        z = false;
                        if (((int) io3VarD0.getLong(0)) != 0) {
                            z2 = true;
                        }
                        io3VarD0.close();
                        return Boolean.valueOf(z2);
                    }
                    z = false;
                    z2 = z;
                    io3VarD0.close();
                    return Boolean.valueOf(z2);
                } finally {
                }
            case 1:
                go3 go3Var2 = (go3) obj;
                go3Var2.getClass();
                io3VarD0 = go3Var2.D0("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList;
                } finally {
                }
            case 2:
                go3 go3Var3 = (go3) obj;
                go3Var3.getClass();
                io3VarD0 = go3Var3.D0("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                try {
                    io3VarD0.K(1, str);
                    if (io3VarD0.C0()) {
                        z3 = ((int) io3VarD0.getLong(0)) != 0;
                    }
                    io3VarD0.close();
                    return Boolean.valueOf(z3);
                } finally {
                }
            case 3:
                List list = (List) obj;
                if (list == null || !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (n12.c(((zk) it.next()).getName(), str)) {
                            z4 = true;
                        }
                    }
                    z4 = false;
                } else {
                    z4 = false;
                }
                return Boolean.valueOf(z4);
            case 4:
                List list2 = (List) obj;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (n12.c(((zk) it2.next()).getName(), str)) {
                            z5 = true;
                        }
                    }
                    z5 = false;
                } else {
                    z5 = false;
                }
                return Boolean.valueOf(z5);
            case 5:
                List list3 = (List) obj;
                if (list3 == null || !list3.isEmpty()) {
                    Iterator it3 = list3.iterator();
                    while (it3.hasNext()) {
                        if (n12.c(((zk) it3.next()).getName(), str)) {
                            z6 = false;
                        }
                    }
                    z6 = true;
                } else {
                    z6 = true;
                }
                return Boolean.valueOf(z6);
            case 6:
                go3 go3Var4 = (go3) obj;
                go3Var4.getClass();
                io3VarD0 = go3Var4.D0("SELECT long_value FROM Preference where `key`=?");
                try {
                    io3VarD0.K(1, str);
                    if (io3VarD0.C0() && !io3VarD0.isNull(0)) {
                        lValueOf = Long.valueOf(io3VarD0.getLong(0));
                        break;
                    } else {
                        lValueOf = null;
                    }
                    return lValueOf;
                } finally {
                }
            case 7:
                go3 go3Var5 = (go3) obj;
                go3Var5.getClass();
                io3VarD0 = go3Var5.D0("SELECT * FROM proxy_group_selection WHERE profileName = ?");
                try {
                    io3VarD0.K(1, str);
                    int iP = p95.p(io3VarD0, "profileName");
                    int iP2 = p95.p(io3VarD0, "groupName");
                    int iP3 = p95.p(io3VarD0, "selection");
                    ArrayList arrayList2 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList2.add(new sa3(io3VarD0.e0(iP), io3VarD0.e0(iP2), io3VarD0.e0(iP3)));
                        break;
                    }
                    return arrayList2;
                } finally {
                }
            case 8:
                go3 go3Var6 = (go3) obj;
                go3Var6.getClass();
                io3VarD0 = go3Var6.D0("DELETE FROM proxy_group_selection WHERE profileName = ?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                go3 go3Var7 = (go3) obj;
                go3Var7.getClass();
                io3VarD0 = go3Var7.D0("SELECT * FROM proxy_group_selection WHERE profileName = ?");
                try {
                    io3VarD0.K(1, str);
                    int iP4 = p95.p(io3VarD0, "profileName");
                    int iP5 = p95.p(io3VarD0, "groupName");
                    int iP6 = p95.p(io3VarD0, "selection");
                    ArrayList arrayList3 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList3.add(new sa3(io3VarD0.e0(iP4), io3VarD0.e0(iP5), io3VarD0.e0(iP6)));
                        break;
                    }
                    return arrayList3;
                } finally {
                }
            case 10:
                String str2 = (String) obj;
                str2.getClass();
                return p44.x0(str2) ? str2.length() < str.length() ? str : str2 : str.concat(str2);
            case 11:
                go3 go3Var8 = (go3) obj;
                go3Var8.getClass();
                io3VarD0 = go3Var8.D0("DELETE FROM SystemIdInfo where work_spec_id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                go3 go3Var9 = (go3) obj;
                go3Var9.getClass();
                io3VarD0 = go3Var9.D0("SELECT name FROM workname WHERE work_spec_id=?");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList4 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList4.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList4;
                } finally {
                }
            case 13:
                go3 go3Var10 = (go3) obj;
                go3Var10.getClass();
                io3VarD0 = go3Var10.D0("DELETE from WorkProgress where work_spec_id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            case 14:
                go3 go3Var11 = (go3) obj;
                go3Var11.getClass();
                io3VarD0 = go3Var11.D0("SELECT * FROM workspec WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    int iP7 = p95.p(io3VarD0, "id");
                    int iP8 = p95.p(io3VarD0, "state");
                    int iP9 = p95.p(io3VarD0, "worker_class_name");
                    int iP10 = p95.p(io3VarD0, "input_merger_class_name");
                    int iP11 = p95.p(io3VarD0, "input");
                    int iP12 = p95.p(io3VarD0, "output");
                    int iP13 = p95.p(io3VarD0, "initial_delay");
                    int iP14 = p95.p(io3VarD0, "interval_duration");
                    int iP15 = p95.p(io3VarD0, "flex_duration");
                    int iP16 = p95.p(io3VarD0, "run_attempt_count");
                    int iP17 = p95.p(io3VarD0, "backoff_policy");
                    int iP18 = p95.p(io3VarD0, "backoff_delay_duration");
                    int iP19 = p95.p(io3VarD0, "last_enqueue_time");
                    int iP20 = p95.p(io3VarD0, "minimum_retention_duration");
                    int iP21 = p95.p(io3VarD0, "schedule_requested_at");
                    int iP22 = p95.p(io3VarD0, "run_in_foreground");
                    int iP23 = p95.p(io3VarD0, "out_of_quota_policy");
                    int iP24 = p95.p(io3VarD0, "period_count");
                    int iP25 = p95.p(io3VarD0, "generation");
                    int iP26 = p95.p(io3VarD0, "next_schedule_time_override");
                    int iP27 = p95.p(io3VarD0, "next_schedule_time_override_generation");
                    int iP28 = p95.p(io3VarD0, "stop_reason");
                    int iP29 = p95.p(io3VarD0, "trace_tag");
                    int iP30 = p95.p(io3VarD0, "backoff_on_system_interruptions");
                    int iP31 = p95.p(io3VarD0, "required_network_type");
                    int iP32 = p95.p(io3VarD0, "required_network_request");
                    int iP33 = p95.p(io3VarD0, "requires_charging");
                    int iP34 = p95.p(io3VarD0, "requires_device_idle");
                    int iP35 = p95.p(io3VarD0, "requires_battery_not_low");
                    int iP36 = p95.p(io3VarD0, "requires_storage_not_low");
                    int iP37 = p95.p(io3VarD0, "trigger_content_update_delay");
                    int iP38 = p95.p(io3VarD0, "trigger_max_content_delay");
                    int iP39 = p95.p(io3VarD0, "content_uri_triggers");
                    if (io3VarD0.C0()) {
                        String strE0 = io3VarD0.e0(iP7);
                        ww4 ww4VarD2 = uf2.D((int) io3VarD0.getLong(iP8));
                        String strE02 = io3VarD0.e0(iP9);
                        String strE03 = io3VarD0.e0(iP10);
                        byte[] blob = io3VarD0.getBlob(iP11);
                        di0 di0Var = di0.b;
                        di0 di0VarI = ek0.i(blob);
                        di0 di0VarI2 = ek0.i(io3VarD0.getBlob(iP12));
                        long j = io3VarD0.getLong(iP13);
                        long j2 = io3VarD0.getLong(iP14);
                        long j3 = io3VarD0.getLong(iP15);
                        int i2 = (int) io3VarD0.getLong(iP16);
                        ei eiVarA = uf2.A((int) io3VarD0.getLong(iP17));
                        long j4 = io3VarD0.getLong(iP18);
                        long j5 = io3VarD0.getLong(iP19);
                        long j6 = io3VarD0.getLong(iP20);
                        long j7 = io3VarD0.getLong(iP21);
                        boolean z7 = ((int) io3VarD0.getLong(iP22)) != 0;
                        ww2 ww2VarC = uf2.C((int) io3VarD0.getLong(iP23));
                        int i3 = (int) io3VarD0.getLong(iP24);
                        int i4 = (int) io3VarD0.getLong(iP25);
                        long j8 = io3VarD0.getLong(iP26);
                        int i5 = (int) io3VarD0.getLong(iP27);
                        int i6 = (int) io3VarD0.getLong(iP28);
                        String strE04 = io3VarD0.isNull(iP29) ? null : io3VarD0.e0(iP29);
                        Integer numValueOf = io3VarD0.isNull(iP30) ? null : Integer.valueOf((int) io3VarD0.getLong(iP30));
                        if (numValueOf != null) {
                            boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        } else {
                            boolValueOf = null;
                        }
                        gx4Var = new gx4(strE0, ww4VarD2, strE02, strE03, di0VarI, di0VarI2, j, j2, j3, new mc0(uf2.R(io3VarD0.getBlob(iP32)), uf2.B((int) io3VarD0.getLong(iP31)), ((int) io3VarD0.getLong(iP33)) != 0, ((int) io3VarD0.getLong(iP34)) != 0, ((int) io3VarD0.getLong(iP35)) != 0, ((int) io3VarD0.getLong(iP36)) != 0, io3VarD0.getLong(iP37), io3VarD0.getLong(iP38), uf2.e(io3VarD0.getBlob(iP39))), i2, eiVarA, j4, j5, j6, j7, z7, ww2VarC, i3, i4, j8, i5, i6, strE04, boolValueOf);
                    } else {
                        gx4Var = null;
                    }
                    return gx4Var;
                } finally {
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                go3 go3Var12 = (go3) obj;
                go3Var12.getClass();
                io3VarD0 = go3Var12.D0("SELECT state FROM workspec WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    if (io3VarD0.C0()) {
                        Integer numValueOf2 = io3VarD0.isNull(0) ? null : Integer.valueOf((int) io3VarD0.getLong(0));
                        if (numValueOf2 != null) {
                            ww4VarD = uf2.D(numValueOf2.intValue());
                            break;
                        }
                    } else {
                        ww4VarD = null;
                    }
                    return ww4VarD;
                } finally {
                }
            case 16:
                go3 go3Var13 = (go3) obj;
                go3Var13.getClass();
                io3VarD0 = go3Var13.D0("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList5 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList5.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList5;
                } finally {
                }
            case 17:
                go3 go3Var14 = (go3) obj;
                go3Var14.getClass();
                io3VarD0 = go3Var14.D0("UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    int iC = r25.C(go3Var14);
                    io3VarD0.close();
                    return Integer.valueOf(iC);
                } finally {
                }
            case 18:
                go3 go3Var15 = (go3) obj;
                go3Var15.getClass();
                io3VarD0 = go3Var15.D0("UPDATE workspec SET run_attempt_count=0 WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    int iC2 = r25.C(go3Var15);
                    io3VarD0.close();
                    return Integer.valueOf(iC2);
                } finally {
                }
            case 19:
                go3 go3Var16 = (go3) obj;
                go3Var16.getClass();
                io3VarD0 = go3Var16.D0("UPDATE workspec SET period_count=period_count+1 WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            case 20:
                go3 go3Var17 = (go3) obj;
                go3Var17.getClass();
                io3VarD0 = go3Var17.D0("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList6 = new ArrayList();
                    while (io3VarD0.C0()) {
                        byte[] blob2 = io3VarD0.getBlob(0);
                        di0 di0Var2 = di0.b;
                        arrayList6.add(ek0.i(blob2));
                        break;
                    }
                    return arrayList6;
                } finally {
                }
            case 21:
                go3 go3Var18 = (go3) obj;
                go3Var18.getClass();
                io3VarD0 = go3Var18.D0("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    int iC3 = r25.C(go3Var18);
                    io3VarD0.close();
                    return Integer.valueOf(iC3);
                } finally {
                }
            case 22:
                go3 go3Var19 = (go3) obj;
                go3Var19.getClass();
                io3VarD0 = go3Var19.D0("DELETE FROM workspec WHERE id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            case 23:
                go3 go3Var20 = (go3) obj;
                go3Var20.getClass();
                io3VarD0 = go3Var20.D0("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList7 = new ArrayList();
                    while (io3VarD0.C0()) {
                        String strE05 = io3VarD0.e0(0);
                        ww4 ww4VarD3 = uf2.D((int) io3VarD0.getLong(1));
                        strE05.getClass();
                        fx4 fx4Var = new fx4();
                        fx4Var.a = strE05;
                        fx4Var.b = ww4VarD3;
                        arrayList7.add(fx4Var);
                        break;
                    }
                    return arrayList7;
                } finally {
                }
            case 24:
                go3 go3Var21 = (go3) obj;
                go3Var21.getClass();
                io3VarD0 = go3Var21.D0("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
                try {
                    io3VarD0.K(1, str);
                    ArrayList arrayList8 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList8.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList8;
                } finally {
                }
            default:
                go3 go3Var22 = (go3) obj;
                go3Var22.getClass();
                io3VarD0 = go3Var22.D0("DELETE FROM worktag WHERE work_spec_id=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
        }
    }
}
