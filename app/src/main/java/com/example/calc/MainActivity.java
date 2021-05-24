package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button clear, del, pow, div, malti, min, add, ans, equal, dot, n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private TextView result;
    private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        clear=findViewById(R.id.clear);
        del=findViewById(R.id.del);
        pow=findViewById(R.id.pow);
        div=findViewById(R.id.div);
        malti=findViewById(R.id.malti);
        min=findViewById(R.id.min);
        add=findViewById(R.id.add);
        ans=findViewById(R.id.ans);
        equal=findViewById(R.id.equal);
        dot=findViewById(R.id.dot);
        n0=findViewById(R.id.n0);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);
        n9=findViewById(R.id.n9);

    }

    public void numclick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = "0";
                break;
            case "ans":
                input="";
                input += answer;
                break;
            case "*":
                    input += "*";
                break;
            case "/":
                input += "/";
                break;
            case "-":
                input += "-";
                break;
            case "+":
                input += "+";
                break;
            case "^":
                input += "^";
                break;
            case "=":
                try {
                    Solve();
                    answer = input;
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }

                break;
            case "del":
                try {
                    String newtext;
                    newtext = input.substring(0, input.length() - 1);
                    input = newtext;
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                if (input == null) {
                    input = "0";
                }
                if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
                    try {
                        Solve();
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    }
                }
                if (input == "0")
                {
                    input="";
                }
                input += data;
        }
        result.setText(input);

    }

    private void Solve() {
        if (input.split("\\*").length == 2) {
            String[] number;
            number = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);

                input = mul+"";
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        } else if (input.split("/").length == 2) {
            String[] number;
            number = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        } else if (input.split("-").length ==2) {
            String[] number;
            number = input.split("-");
            if (number[0].equals("") && number.length ==2) {
                number[0] = 0 + "";
            }
            try {
                double min = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = min+"";
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        }
        else if (input.split("\\+").length == 2) {
            String[] number;
            number = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add+"";
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        }
        else if (input.split("\\^").length == 2) {
            String[] number;
            number = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input = pow + "";
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
        else if (input.split("\\.").length == 2) {
            String[] number;
            number = input.split("\\.");
            try {
                if(number.length > 1)
                {
                    if(number[1].equals("0"))
                    {
                        input = number[0];
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}