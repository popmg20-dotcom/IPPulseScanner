package defpackage;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gc2 implements View.OnTouchListener {
    public final /* synthetic */ hc2 b;

    public gc2(hc2 hc2Var) {
        this.b = hc2Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        hc2 hc2Var = this.b;
        ec2 ec2Var = hc2Var.I0;
        Handler handler = hc2Var.M0;
        kb kbVar = hc2Var.Q0;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && kbVar != null && kbVar.isShowing() && x >= 0 && x < kbVar.getWidth() && y >= 0 && y < kbVar.getHeight()) {
            handler.postDelayed(ec2Var, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        handler.removeCallbacks(ec2Var);
        return false;
    }
}
