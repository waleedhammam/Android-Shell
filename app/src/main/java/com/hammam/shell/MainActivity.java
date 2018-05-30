package com.hammam.shell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;


public class MainActivity extends AppCompatActivity {

    Button execute, clear;
    EditText inputCommand;
    TextView outputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        execute = findViewById(R.id.execute_button);
        clear = findViewById(R.id.clear_button);

        inputCommand = findViewById(R.id.input_text);
        outputResult = findViewById(R.id.output_text);
        outputResult.setMovementMethod(new ScrollingMovementMethod());

        execute.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CommandResult result = Shell.SH.run(inputCommand.getText().toString());
                outputResult.append("$ " + inputCommand.getText().toString() + "\n" +
                        "> " + result.toString() + "\n");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outputResult.setText("");
            }
        });
    }

}
