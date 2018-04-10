package hr.ferit.ivana.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DistanceActivity extends AppCompatActivity {
    @BindView(R.id.spDistanceFrom) Spinner spDistanceFrom;
    @BindView(R.id.spDistanceTo) Spinner spDistanceTo;
    @BindView(R.id.etDistance) EditText etDistance;
    @BindView(R.id.bConvertDistance) Button bConvertDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        ButterKnife.bind(this);
        }



    @OnClick(R.id.bConvertDistance)
    public void convertDistance(){
        double result = 0;
        double distance;
        if (etDistance.getText().toString().matches("")){
            distance = 0;
        }
        else {
            distance = Float.valueOf(etDistance.getText().toString());
        }
        String distanceFrom = spDistanceFrom.getSelectedItem().toString();
        String distanceTo = spDistanceTo.getSelectedItem().toString();
        int distanceToPosition = spDistanceTo.getSelectedItemPosition();

        //mm to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 0) {
            switch (distanceToPosition) {
                case 0:
                    result = distance;
                    break;
                case 1:
                    result = distance * 0.01;
                    break;
                case 2:
                    result = distance * 0.00001;
                    break;
                case 3:
                    result = distance * 0.393700787;
                    break;
                case 4:
                    result = distance * 0.032808399;
                    break;
                case 5:
                    result = distance * 0.000006213711922;
                    break;
            }
        }

        //m to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 1){
            switch (distanceToPosition) {
                case 0:
                    result = distance * 100;
                    break;
                case 1:
                    result = distance;
                    break;
                case 2:
                    result = distance * 0.001;
                    break;
                case 3:
                    result = distance * 39.3700787;
                    break;
                case 4:
                    result = distance * 3.2808399;
                    break;
                case 5:
                    result = distance * 0.0006213711922;
                    break;
            }
        }

        //km to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 2){
            switch (distanceToPosition) {
                case 0:
                    result = distance * 1000000;
                    break;
                case 1:
                    result = distance * 1000;
                    break;
                case 2:
                    result = distance;
                    break;
                case 3:
                    result = distance * 39370.0787;
                    break;
                case 4:
                    result = distance * 3280.8399;
                    break;
                case 5:
                    result = distance * 0.6213711922;
                    break;
            }
        }

        //inch to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 3){
            switch (distanceToPosition) {
                case 0:
                    result = distance * 24.4;
                    break;
                case 1:
                    result = distance * 0.0254;
                    break;
                case 2:
                    result = distance * 0.0000254;
                    break;
                case 3:
                    result = distance;
                    break;
                case 4:
                    result = distance * 0.0833333333;
                    break;
                case 5:
                    result = distance * 0.0000157828;
                    break;
            }
        }

        //feet to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 4){
            switch (distanceToPosition) {
                case 0:
                    result = distance * 304.8;
                    break;
                case 1:
                    result = distance * 0.3048;
                    break;
                case 2:
                    result = distance * 0.0003048;
                    break;
                case 3:
                    result = distance * 12;
                    break;
                case 4:
                    result = distance;
                    break;
                case 5:
                    result = distance * 0.000189393939;
                    break;
            }
        }

        //mile to mm,m,km,inch,feet,mile

        if (spDistanceFrom.getSelectedItemPosition() == 5){
            switch (distanceToPosition) {
                case 0:
                    result = distance * 1609344;
                    break;
                case 1:
                    result = distance * 1609.344;
                    break;
                case 2:
                    result = distance * 1.609344;
                    break;
                case 3:
                    result = distance * 63360;
                    break;
                case 4:
                    result = distance * 5280;
                    break;
                case 5:
                    result = distance;
                    break;
            }
        }

        showResult(result, distanceFrom, distanceTo, distance);

    }

    private void showResult(double result, String distanceFrom, String distanceTo, double distance) {
        Intent showingResult = new Intent (this, ResultsActivity.class);
        showingResult.putExtra(ResultsActivity.KEY_RESULT, result);
        showingResult.putExtra(ResultsActivity.KEY_FROM_UNIT, distanceFrom);
        showingResult.putExtra(ResultsActivity.KEY_TO_UNIT, distanceTo);
        showingResult.putExtra(ResultsActivity.KEY_FROM_VALUE, distance);
        startActivity(showingResult);
    }

}
