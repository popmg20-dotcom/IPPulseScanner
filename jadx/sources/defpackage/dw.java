package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ew f;
    public final /* synthetic */ vv z;

    public /* synthetic */ dw(ew ewVar, vv vvVar, int i) {
        this.b = i;
        this.f = ewVar;
        this.z = vvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = 4;
        vv vvVar = this.z;
        ew ewVar = this.f;
        switch (i) {
            case 0:
                ewVar.b = true;
                w9 w9Var = new w9("Camera2CameraControl was updated with new options.");
                vv vvVar2 = (vv) ewVar.g;
                if (vvVar2 != null) {
                    vvVar2.d(w9Var);
                    ewVar.g = null;
                }
                ewVar.g = vvVar;
                if (ewVar.a) {
                    nw nwVar = (nw) ewVar.c;
                    vv vvVar3 = new vv();
                    vvVar3.c = new wj3();
                    yv yvVar = new yv(vvVar3);
                    vvVar3.b = yvVar;
                    vvVar3.a = fw.class;
                    try {
                        nwVar.f.execute(new s7(i2, nwVar, vvVar3));
                        vvVar3.a = "updateSessionConfigAsync";
                    } catch (Exception e) {
                        yvVar.b(e);
                    }
                    n12.K(yvVar).a(new d4(2, ewVar), (at3) ewVar.d);
                    ewVar.b = false;
                }
                break;
            default:
                ewVar.b = true;
                w9 w9Var2 = new w9("Camera2CameraControl was updated with new options.");
                vv vvVar4 = (vv) ewVar.g;
                if (vvVar4 != null) {
                    vvVar4.d(w9Var2);
                    ewVar.g = null;
                }
                ewVar.g = vvVar;
                if (ewVar.a) {
                    nw nwVar2 = (nw) ewVar.c;
                    vv vvVar5 = new vv();
                    vvVar5.c = new wj3();
                    yv yvVar2 = new yv(vvVar5);
                    vvVar5.b = yvVar2;
                    vvVar5.a = fw.class;
                    try {
                        nwVar2.f.execute(new s7(i2, nwVar2, vvVar5));
                        vvVar5.a = "updateSessionConfigAsync";
                    } catch (Exception e2) {
                        yvVar2.b(e2);
                    }
                    n12.K(yvVar2).a(new d4(2, ewVar), (at3) ewVar.d);
                    ewVar.b = false;
                }
                break;
        }
    }
}
