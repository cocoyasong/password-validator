package com.example.yasong.assign2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    TextView text;
    Button button;
    EditText field;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);
        field = (EditText) findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String psd = field.getText().toString();
                text.setText(password(psd));
            }
        });
    }

    public String password (String s){
        String ch=s.substring(0,1);
        // rule 3: must begin with upper case
        boolean beginUpper=!ch.equals(ch.toLowerCase());
        //rule 4:must have both upper case and lower case
        boolean hasUppercase = !s.equals(s.toLowerCase());
        boolean hasLowercase = !s.equals(s.toUpperCase());
        //rule 5:
        boolean checkDigit=s.matches(".*\\d.*");

        int num=0;
        String res="";

        if (!s.toLowerCase().equals("password")){
            num++;
            res+="rule one complete\n";
        }
        if (s.length()>8){
            num++;
            res+="rule two complete\n";
        }
        if (beginUpper){
            res+="rule three complete\n";
        }
        if (hasUppercase && hasLowercase) {
            res+="rule four complete\n";
        }
        if(checkDigit) {
            res+="rule five complete\n";
        }
        if (num==5){
            res="Successful!";
        }
        return res;
    }


}
