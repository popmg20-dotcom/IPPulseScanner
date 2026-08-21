package defpackage;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a54 {
    public lb a;
    public ArrayList b;
    public int c;
    public boolean d;

    public final void a() {
        if (this.b != null) {
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= this.b.size() - 1) {
                    break;
                }
                i2++;
                int i3 = ((j60) this.b.get(i2)).c;
                if (i > i3) {
                    Collections.sort(this.b, j60.f);
                    break;
                }
                i = i3;
            }
            Collections.sort(new ArrayList(this.b), j60.g);
        }
    }
}
