package hr.ferit.ivana.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultsActivity extends AppCompatActivity {

    public static final String KEY_RESULT = "result";
    public static final String KEY_FROM_UNIT = "from_unit";
    public static final String KEY_TO_UNIT = "to_unit";
    public static final String KEY_FROM_VALUE = "from_value";

    @BindView(R.id.fromValue) TextView fromValue;
    @BindView(R.id.toValue) TextView toValue;
    @BindView(R.id.fromUnit) TextView fromUnit;
    @BindView(R.id.toUnit) TextView toUnit;
    @BindView(R.id.bConvertAgain) Button bConvertAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ButterKnife.bind(this);

        Intent startingIntent = getIntent();
        handleStartingIntent(startingIntent);
    }

    @OnClick(R.id.bConvertAgain)
    public void convertAgain(){
        Intent openMainActivity = new Intent(this, MainActivity.class);
        startActivity(openMainActivity);
    }

    private void handleStartingIntent(Intent startingIntent) {
        if (startingIntent != null);{
            if (startingIntent.hasExtra(KEY_RESULT)){
                String result = String.valueOf(startingIntent.getDoubleExtra(KEY_RESULT, 1));
                toValue.setText(result);
            }
            if (startingIntent.hasExtra(KEY_FROM_UNIT)){
                fromUnit.setText(startingIntent.getStringExtra(KEY_FROM_UNIT));
            }
            if (startingIntent.hasExtra(KEY_TO_UNIT)){
                toUnit.setText(startingIntent.getStringExtra(KEY_TO_UNIT));
            }
            if (startingIntent.hasExtra(KEY_FROM_VALUE)){
                String value = String.valueOf(startingIntent.getDoubleExtra(KEY_FROM_VALUE, 1));
                fromValue.setText(value);
            }
        }
    }

}
