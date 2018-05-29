package com.hammam.shell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;


public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btn;
    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        out = findViewById(R.id.out);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CommandResult result = Shell.SH.run(input.getText().toString());
                out.append("input\n" + input.getText().toString() + "\n" +
                        "Output\n" + result.toString() + "\n");
            }
        });

    }

}
