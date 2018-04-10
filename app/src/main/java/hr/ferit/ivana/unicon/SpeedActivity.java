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

public class SpeedActivity extends AppCompatActivity {

    @BindView(R.id.spSpeedFrom) Spinner spSpeedFrom;
    @BindView(R.id.spSpeedTo) Spinner spSpeedTo;
    @BindView(R.id.etSpeed) EditText etSpeed;
    @BindView(R.id.bConvertSpeed) Button bConvertSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bConvertSpeed)
    public void convertSpeed() {
        double result = 0;
        double speed;
        if (etSpeed.getText().toString().matches("")){
            speed = 0;
        }
        else {
            speed = Float.valueOf(etSpeed.getText().toString());
        }
        String speedFrom = spSpeedFrom.getSelectedItem().toString();
        String speedTo = spSpeedTo.getSelectedItem().toString();
        int speedToPosition = spSpeedTo.getSelectedItemPosition();

        //ms to ms, kmh, mh

        if (spSpeedFrom.getSelectedItemPosition() == 0) {
            switch (speedToPosition) {
                case 0:
                    result = speed;
                    break;
                case 1:
                    result = speed * 3.6;
                    break;
                case 2:
                    result = speed * 2.236936292;
                    break;
            }
        }

        //kh to ms, kmh, mh

        if (spSpeedFrom.getSelectedItemPosition() == 1) {
            switch (speedToPosition) {
                case 0:
                    result = speed * 0.27777777777778;
                    break;
                case 1:
                    result = speed;
                    break;
                case 2:
                    result = speed * 0.621371192;
                    break;
            }
        }

        //mh to ms, kmh, mh

        if (spSpeedFrom.getSelectedItemPosition() == 2) {
            switch (speedToPosition) {
                case 0:
                    result = speed * 0.44704;
                    break;
                case 1:
                    result = speed * 1.609344;
                    break;
                case 2:
                    result = speed;
                    break;
            }
        }

        showResult(result, speedFrom, speedTo, speed);
    }

    private void showResult(double result, String speedFrom, String speedTo, double speed) {
        Intent showingResult = new Intent (this, ResultsActivity.class);
        showingResult.putExtra(ResultsActivity.KEY_RESULT, result);
        showingResult.putExtra(ResultsActivity.KEY_FROM_UNIT, speedFrom);
        showingResult.putExtra(ResultsActivity.KEY_TO_UNIT, speedTo);
        showingResult.putExtra(ResultsActivity.KEY_FROM_VALUE, speed);
        startActivity(showingResult);
    }
}
