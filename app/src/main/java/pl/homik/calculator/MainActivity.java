package pl.homik.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private double a = 5.0;
    private double b = 2.0;


    private TextView display;

    private EditText leftText;
    private EditText rightText;

    private Button additionButton;
    private Button subtractionButton;
    private Button multiplicationButton;
    private Button divisionButton;
    private Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        additionButton = (Button) findViewById(R.id.additionButton);
        subtractionButton = (Button) findViewById(R.id.subtractButton);
        multiplicationButton = (Button) findViewById(R.id.multiplicationButton);
        divisionButton = (Button) findViewById(R.id.divisionButton);
        resultButton = (Button) findViewById(R.id.resultButton);

        additionButton.setOnClickListener(this);
        subtractionButton.setOnClickListener(this);
        multiplicationButton.setOnClickListener(this);
        divisionButton.setOnClickListener(this);
        resultButton.setOnClickListener(this);

        display = (TextView) findViewById(R.id.display);

        leftText = (EditText) findViewById(R.id.leftText);
        rightText = (EditText) findViewById(R.id.rightText);
    }

    @Override
    public void onClick(View arg) {

        try {
            a = Double.parseDouble(leftText.getText().toString());
            b = Double.parseDouble(rightText.getText().toString());

            if (arg.getId() == R.id.additionButton)  // to jest test czy tak mogę się odwoływać do ID
                display.setText(String.valueOf(Operations.addition(Double.parseDouble(leftText.getText().toString()), Double.parseDouble(rightText.getText().toString()))));
//                display.setText();
            if (arg.getId() == subtractionButton.getId())
                display.setText(String.valueOf(Operations.subtraction(a, b)));
            if (arg.getId() == multiplicationButton.getId())
                display.setText(String.valueOf(Operations.multiplication(a, b)));
            if (arg.getId() == divisionButton.getId())
                display.setText(String.valueOf(Operations.division(a, b)));
            if (arg.getId() == resultButton.getId()) {
                display.setText(R.string.worningMessage);
                Toast.makeText(this, R.string.worningMessage, Toast.LENGTH_LONG).show();
         }
    } catch(NumberFormatException ex) {
            display.setText(R.string.worningMessage);
        } catch (IllegalArgumentException ex) {
            display.setText(R.string.worningMessage);
        }
    }
}
