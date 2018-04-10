package hr.ferit.ivana.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VolumeActivity extends AppCompatActivity {

    @BindView(R.id.spVolumeFrom) Spinner spVolumeFrom;
    @BindView(R.id.spVolumeTo) Spinner spVolumeTo;
    @BindView(R.id.etVolume) EditText etVolume;
    @BindView(R.id.bConvertVolume) Button bConvertVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bConvertVolume)
    public void convertVolume(){
        double result = 0;
        double volume;
        if (etVolume.getText().toString().matches("")){
            volume = 0;
        }
        else {
            volume = Float.valueOf(etVolume.getText().toString());
        }
        String volumeFrom = spVolumeFrom.getSelectedItem().toString();
        String volumeTo = spVolumeTo.getSelectedItem().toString();
        int volumeToPosition = spVolumeTo.getSelectedItemPosition();

        //ml to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 0) {
            switch (volumeToPosition) {
                case 0:
                    result = volume;
                    break;
                case 1:
                    result = volume * 0.01;
                    break;
                case 2:
                    result = volume * 0.001;
                    break;
                case 3:
                    result = volume * 0.202884136;
                    break;
                case 4:
                    result = volume * 0.0676280454;
                    break;
                case 5:
                    result = volume * 0.00422675284 ;
                    break;
            }
        }

        //dl to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 1) {
            switch (volumeToPosition) {
                case 0:
                    result = volume * 10;
                    break;
                case 1:
                    result = volume;
                    break;
                case 2:
                    result = volume * 0.1;
                    break;
                case 3:
                    result = volume * 20.2884136;
                    break;
                case 4:
                    result = volume * 6.76280454;
                    break;
                case 5:
                    result = volume * 0.422675284;
                    break;
            }
        }

        //l to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 2) {
            switch (volumeToPosition) {
                case 0:
                    result = volume * 1000;
                    break;
                case 1:
                    result = volume * 10;
                    break;
                case 2:
                    result = volume;
                    break;
                case 3:
                    result = volume * 202.884136;
                    break;
                case 4:
                    result = volume * 67.6280454;
                    break;
                case 5:
                    result = volume * 4.22675284;
                    break;
            }
        }

        //teas to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 3) {
            switch (volumeToPosition) {
                case 0:
                    result = volume * 4.92892159;
                    break;
                case 1:
                    result = volume * 0.0492892159;
                    break;
                case 2:
                    result = volume * 0.00492892159 ;
                    break;
                case 3:
                    result = volume;
                    break;
                case 4:
                    result = volume * 0.333333333;
                    break;
                case 5:
                    result = volume * 0.0208333333;
                    break;
            }
        }

        //tabs to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 4) {
            switch (volumeToPosition) {
                case 0:
                    result = volume * 14.7867648;
                    break;
                case 1:
                    result = volume * 0.147867648;
                    break;
                case 2:
                    result = volume * 0.0147867648  ;
                    break;
                case 3:
                    result = volume * 3;
                    break;
                case 4:
                    result = volume;
                    break;
                case 5:
                    result = volume * 0.0625;
                    break;
            }
        }

        //cups to ml, dl, l, teas, tabs, cups

        if (spVolumeFrom.getSelectedItemPosition() == 5) {
            switch (volumeToPosition) {
                case 0:
                    result = volume * 236.588237;
                    break;
                case 1:
                    result = volume * 2.36588237;
                    break;
                case 2:
                    result = volume * 0.236588237;
                    break;
                case 3:
                    result = volume * 48;
                    break;
                case 4:
                    result = volume * 16;
                    break;
                case 5:
                    result = volume;
                    break;
            }
        }

        showResult(result, volumeFrom, volumeTo, volume);
    }

    private void showResult(double result, String volumeFrom, String volumeTo, double volume) {
        Intent showingResult = new Intent (this, ResultsActivity.class);
        showingResult.putExtra(ResultsActivity.KEY_RESULT, result);
        showingResult.putExtra(ResultsActivity.KEY_FROM_UNIT, volumeFrom);
        showingResult.putExtra(ResultsActivity.KEY_TO_UNIT, volumeTo);
        showingResult.putExtra(ResultsActivity.KEY_FROM_VALUE, volume);
        startActivity(showingResult);
    }
}
