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

public class WeightActivity extends AppCompatActivity {

    @BindView(R.id.spWeightFrom) Spinner spWeightFrom;
    @BindView(R.id.spWeightTo) Spinner spWeightTo;
    @BindView(R.id.etWeight) EditText etWeight;
    @BindView(R.id.bConvertWeight) Button bConvertWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bConvertWeight)
    public void convertWeight(){
        double result = 0;
        double weight;
        if (etWeight.getText().toString().matches("")){
            weight = 0;
        }
        else {
            weight = Float.valueOf(etWeight.getText().toString());
        }
        String weightFrom = spWeightFrom.getSelectedItem().toString();
        String weightTo = spWeightTo.getSelectedItem().toString();
        int weightToPosition = spWeightTo.getSelectedItemPosition();

        //g to g, kg, ounce, pound

        if (spWeightFrom.getSelectedItemPosition() == 0) {
            switch (weightToPosition) {
                case 0:
                    result = weight;
                    break;
                case 1:
                    result = weight * 0.001;
                    break;
                case 2:
                    result = weight * 0.0352739619;
                    break;
                case 3:
                    result = weight * 0.00220462262;
                    break;
            }
        }

        //kg to g, kg, ounce, pound

        if (spWeightFrom.getSelectedItemPosition() == 1) {
            switch (weightToPosition) {
                case 0:
                    result = weight * 1000;
                    break;
                case 1:
                    result = weight;
                    break;
                case 2:
                    result = weight * 35.2739619;
                    break;
                case 3:
                    result = weight * 2.20462262;
                    break;
            }
        }

        //ounce to g, kg, ounce, pound

        if (spWeightFrom.getSelectedItemPosition() == 2) {
            switch (weightToPosition) {
                case 0:
                    result = weight * 28.3495231;
                    break;
                case 1:
                    result = weight * 0.0283495231;
                    break;
                case 2:
                    result = weight;
                    break;
                case 3:
                    result = weight * 0.0625;
                    break;
            }
        }

        //g to g, kg, ounce, pound

        if (spWeightFrom.getSelectedItemPosition() == 3) {
            switch (weightToPosition) {
                case 0:
                    result = weight * 453.59237;
                    break;
                case 1:
                    result = weight * 0.45359237;
                    break;
                case 2:
                    result = weight * 16;
                    break;
                case 3:
                    result = weight;
                    break;
            }
        }

        showResult(result, weightFrom, weightTo, weight);
    }

    private void showResult(double result, String weightFrom, String weightTo, double weight) {
        Intent showingResult = new Intent (this, ResultsActivity.class);
        showingResult.putExtra(ResultsActivity.KEY_RESULT, result);
        showingResult.putExtra(ResultsActivity.KEY_FROM_UNIT, weightFrom);
        showingResult.putExtra(ResultsActivity.KEY_TO_UNIT, weightTo);
        showingResult.putExtra(ResultsActivity.KEY_FROM_VALUE, weight);
        startActivity(showingResult);
    }
}
