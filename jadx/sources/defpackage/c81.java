package defpackage;

import android.app.ApplicationExitInfo;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.google.android.material.textview.MaterialTextView;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c81 extends rb2 {
    public final y71 e;

    public c81(y71 y71Var) {
        super(b81.k);
        this.e = y71Var;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        e81 e81Var = (e81) rg3Var;
        Object objQ = q(i);
        objQ.getClass();
        ApplicationExitInfo applicationExitInfoA = a71.a(objQ);
        y71 y71Var = this.e;
        y71Var.getClass();
        v92 v92Var = e81Var.u;
        MaterialTextView materialTextView = (MaterialTextView) v92Var.A;
        MaterialTextView materialTextView2 = (MaterialTextView) v92Var.f;
        ConstraintLayout constraintLayout = (ConstraintLayout) v92Var.b;
        SimpleDateFormat simpleDateFormat = g81.a;
        materialTextView.setText(g81.e(applicationExitInfoA.getReason()));
        MaterialTextView materialTextView3 = (MaterialTextView) v92Var.X;
        long timestamp = applicationExitInfoA.getTimestamp();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - timestamp;
        materialTextView3.setText((0 > j || j >= 604800000) ? g81.b(timestamp) : DateUtils.getRelativeTimeSpanString(timestamp, jCurrentTimeMillis, 60000L).toString());
        int i2 = 0;
        ((MaterialTextView) v92Var.z).setText(constraintLayout.getContext().getString(R.string.exit_detail_process, applicationExitInfoA.getProcessName(), Integer.valueOf(applicationExitInfoA.getPid())));
        String description = applicationExitInfoA.getDescription();
        materialTextView2.setVisibility((description == null || description.length() == 0) ? 8 : 0);
        materialTextView2.setText(applicationExitInfoA.getDescription());
        constraintLayout.setOnClickListener(new d81(i2, y71Var, applicationExitInfoA, e81Var));
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exit_info, viewGroup, false);
        int i2 = R.id.description;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.description);
        if (materialTextView != null) {
            i2 = R.id.process_name;
            MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.process_name);
            if (materialTextView2 != null) {
                i2 = R.id.reason;
                MaterialTextView materialTextView3 = (MaterialTextView) vf2.l(viewInflate, R.id.reason);
                if (materialTextView3 != null) {
                    i2 = R.id.timestamp;
                    MaterialTextView materialTextView4 = (MaterialTextView) vf2.l(viewInflate, R.id.timestamp);
                    if (materialTextView4 != null) {
                        return new e81(new v92((ConstraintLayout) viewInflate, materialTextView, materialTextView2, materialTextView3, materialTextView4));
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
