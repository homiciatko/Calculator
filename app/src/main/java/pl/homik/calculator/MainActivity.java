package pl.homik.calculator;

import android.graphics.Path;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.homik.calculator.operations.Operation;
import pl.homik.calculator.operations.OperationAdd;
import pl.homik.calculator.operations.OperationDivision;
import pl.homik.calculator.operations.OperationMultiplication;
import pl.homik.calculator.operations.OperationSubstraction;

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

    @BindView(R.id.progressBar)
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

      private class NewTask extends AsyncTask<Operation, Integer, Operation> {

        @Override
        protected Operation doInBackground(Operation... params) {
           // operation = params[0];
            for(int i = 0; i < 20; i++  ) {
                publishProgress(i);
                try {
                    Thread.sleep(params[0].stress()+100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return params[0];
        }

          // chce wyjatka dac do gory
        @Override
        public void onPostExecute(Operation args) throws IllegalArgumentException {
            Toast.makeText(MainActivity.this, new StringBuilder().append("Udało sie, skonczyłem ").append(args.getOperationName()).toString(), Toast.LENGTH_LONG).show();
            try {
                display.setText(String.valueOf(args.result()));
            } catch (IllegalArgumentException ex) {
                display.setText(R.string.worningMessage);
            }

        }
        @Override
        public void onProgressUpdate(Integer ... args) {
            progressBar.setProgress(args[0]);
            Toast.makeText(MainActivity.this, "INT " + args[0].toString(), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View arg) {
        try {
            a = Double.parseDouble(leftText.getText().toString());
            b = Double.parseDouble(rightText.getText().toString());
//            if (arg.getId() == R.id.additionButton)  // to jest test czy tak mogę się odwoływać do ID
//                display.setText(String.valueOf(Operations.addition(Double.parseDouble(leftText.getText().toString()), Double.parseDouble(rightText.getText().toString()))));
            if (arg.getId() == additionButton.getId()) {
                new NewTask().execute(new OperationAdd(a,b));
            }
            else if (arg.getId() == subtractionButton.getId())
                new NewTask().execute(new OperationSubstraction(a,b));
            else if (arg.getId() == multiplicationButton.getId())
                new NewTask().execute(new OperationMultiplication(a,b));
            else if (arg.getId() == divisionButton.getId())
                new NewTask().execute(new OperationDivision(a,b));
            else if (arg.getId() == resultButton.getId()) {
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
