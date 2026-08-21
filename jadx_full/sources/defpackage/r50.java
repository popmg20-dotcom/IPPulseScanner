package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r50 extends nl3 {
    @Override // defpackage.nl3
    public final void a(gl1 gl1Var) {
        gl1Var.getClass();
        gl1Var.g();
        try {
            gl1Var.C("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + (System.currentTimeMillis() - 86400000) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            gl1Var.M();
        } finally {
            gl1Var.x();
        }
    }
}
