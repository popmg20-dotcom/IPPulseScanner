package com.ippulse.scanner;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.*;
import android.view.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MainActivity extends android.app.Activity {
    EditText ipInput, packetInput, intervalInput, timeoutInput;
    Button startButton, stopButton;
    ProgressBar progress;
    TextView status, results;
    ExecutorService pool;
    volatile boolean stopped = false;
    Handler main = new Handler(Looper.getMainLooper());
    final List<Result> all = Collections.synchronizedList(new ArrayList<>());

    @Override public void onCreate(Bundle b) {
        super.onCreate(b); setContentView(R.layout.activity_main);
        ipInput=findViewById(R.id.ipInput); packetInput=findViewById(R.id.packetInput); intervalInput=findViewById(R.id.intervalInput); timeoutInput=findViewById(R.id.timeoutInput);
        startButton=findViewById(R.id.startButton); stopButton=findViewById(R.id.stopButton); progress=findViewById(R.id.progress); status=findViewById(R.id.status); results=findViewById(R.id.results);
        startButton.setOnClickListener(v -> start()); stopButton.setOnClickListener(v -> stop());
    }
    void start(){
        List<String> ips=new ArrayList<>(); for(String s:ipInput.getText().toString().split("\\s+|,")){s=s.trim(); if(!s.isEmpty() && validIp(s)) ips.add(s);} 
        if(ips.isEmpty()){Toast.makeText(this,"حداقل یک IP معتبر وارد کن",Toast.LENGTH_SHORT).show(); return;}
        int packets=parse(packetInput,300), interval=parse(intervalInput,200), timeout=parse(timeoutInput,1500);
        packets=Math.min(Math.max(packets,1),300); interval=Math.min(Math.max(interval,50),5000); timeout=Math.min(Math.max(timeout,250),10000);
        stopped=false; all.clear(); results.setText(""); progress.setMax(ips.size()); progress.setProgress(0);
        startButton.setEnabled(false); stopButton.setEnabled(true); status.setText("در حال تست "+ips.size()+" مقصد...");
        pool=Executors.newFixedThreadPool(Math.min(4,ips.size()));
        for(String ip:ips) pool.submit(() -> { if(!stopped){ Result r=ping(ip,packets,interval,timeout); all.add(r); render(ips.size()); }});
    }
    void stop(){stopped=true; if(pool!=null) pool.shutdownNow(); startButton.setEnabled(true); stopButton.setEnabled(false); status.setText("متوقف شد");}
    int parse(EditText e,int d){try{return Integer.parseInt(e.getText().toString().trim());}catch(Exception x){return d;}}
    boolean validIp(String s){try{String[] p=s.split("\\."); if(p.length!=4)return false; for(String q:p){int n=Integer.parseInt(q); if(n<0||n>255)return false;} return true;}catch(Exception e){return false;}}

    Result ping(String ip,int packets,int intervalMs,int timeoutMs){
        ArrayList<Double> rtts=new ArrayList<>();
        String cmdInterval=String.format(Locale.US,"%.3f",intervalMs/1000.0);
        try {
            Process p=new ProcessBuilder("/system/bin/ping","-c",String.valueOf(packets),"-i",cmdInterval,"-W",String.valueOf(Math.max(1,(timeoutMs+999)/1000)),ip).redirectErrorStream(true).start();
            BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream())); Pattern pat=Pattern.compile("time[=<]([0-9.]+)"); String line;
            while((line=br.readLine())!=null){ Matcher m=pat.matcher(line); if(m.find()) { try{rtts.add(Double.parseDouble(m.group(1)));}catch(Exception ignore){} } if(stopped){p.destroy(); break;} }
            p.waitFor(30,TimeUnit.MINUTES);
        }catch(Exception ignored){}
        int recv=rtts.size(); double loss=packets==0?100.0:(packets-recv)*100.0/packets; double min=recv==0?Double.NaN:Collections.min(rtts); double max=recv==0?Double.NaN:Collections.max(rtts); double sum=0; for(double x:rtts)sum+=x; double avg=recv==0?Double.NaN:sum/recv;
        double jitter=0; if(rtts.size()>1){double d=0;for(int i=1;i<rtts.size();i++)d+=Math.abs(rtts.get(i)-rtts.get(i-1));jitter=d/(rtts.size()-1);} return new Result(ip,min,avg,max,jitter,loss,packets,recv);
    }
    void render(int total){ main.post(() -> { progress.setProgress(Math.min(total, all.size())); List<Result> c=new ArrayList<>(all); c.sort(Comparator.comparingDouble(MainActivity::score)); StringBuilder sb=new StringBuilder(); int i=1; for(Result r:c){sb.append(String.format(Locale.US,"#%d  %-15s Avg %6.2f  Jit %5.2f  Loss %5.1f%%  Min %6.2f  Max %6.2f\\n",i++,r.ip,r.avg,r.jitter,r.loss,r.min,r.max));} results.setText(sb.toString()); status.setText(all.size()+" / "+total+" کامل شد"); if(all.size()>=total){startButton.setEnabled(true);stopButton.setEnabled(false);} }); }
    static double score(Result r){ if(Double.isNaN(r.avg))return 1e9; return r.loss*10000+r.jitter*10+r.avg; }
    static class Result{String ip;double min,avg,max,jitter,loss;int sent,recv;Result(String i,double a,double b,double c,double d,double e,int f,int g){ip=i;min=a;avg=b;max=c;jitter=d;loss=e;sent=f;recv=g;}}
}
