package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.getsurfboard.ui.fragment.AddHostFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t5 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ t5(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i2) {
            case 0:
                ((AddHostFragment) obj2).o((u5) ((j51) ((i51) obj)).get(i));
                break;
            default:
                Context context = (Context) obj;
                try {
                    ((t01) ((iv1) obj2).X).i(i);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                    Toast.makeText(context, e.toString(), 0).show();
                }
                break;
        }
    }
}
