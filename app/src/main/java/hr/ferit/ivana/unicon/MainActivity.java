package hr.ferit.ivana.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bWeight) Button bWeight;
    @BindView(R.id.bDistance) Button bDistance;
    @BindView(R.id.bSpeed) Button bSpeed;
    @BindView(R.id.bVolume) Button bVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bWeight)
    public void showWeightConverter(){
        
    }

    @OnClick(R.id.bVolume)
    public void showVolumeConverter(){

    }

    @OnClick(R.id.bSpeed)
    public void showSpeedConverter() {

    }

    @OnClick(R.id.bDistance)
    public void showDistanceConverter(){

    }
}
