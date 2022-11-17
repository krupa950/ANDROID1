package com.example.assigment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import  org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result,solution;
    MaterialButton buttonC;
    MaterialButton  add,sub,multi,div,equal;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        solution=findViewById(R.id.solution);
        assignId(buttonC,R.id.button19);
        assignId(add,R.id.button11);
        assignId(sub,R.id.button12);
        assignId(multi,R.id.button14);
        assignId(div,R.id.button18);
        assignId(equal,R.id.button13);
        assignId(button0,R.id.button10);
        assignId(button1,R.id.button);
        assignId(button2,R.id.button2);
        assignId(button3,R.id.button3);
        assignId(button4,R.id.button4);
        assignId(button5,R.id.button5);
        assignId(button6,R.id.button6);
        assignId(button7,R.id.button7);
        assignId(button8,R.id.button8);
        assignId(button9,R.id.button9);






    }
    void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button=(MaterialButton) view;
        String buttontext=button.getText().toString();
        String Dataculci=solution.getText().toString();
        if(buttontext.equals("C")){
            solution.setText("");
            result.setText("0");
            return;
        }
        if(buttontext.equals("=")){
            solution.setText(result.getText());
            return;

        }
        else{
            Dataculci=Dataculci+buttontext;

        }


        solution.setText(Dataculci);
        String  Finalresult=getResult(Dataculci);
        if(!Finalresult.equals("err")){
            result.setText(Finalresult);
        }

    }
    String getResult(String data){
                        try{
                            Context context=Context.enter();
                            context.setOptimizationLevel(-1);
                            Scriptable scriptable= context.initStandardObjects();
                        String Finalresult=context.evaluateString(scriptable,data,"Javascript",1,null).toString();
                        if(Finalresult.endsWith(".0")){
                            Finalresult=Finalresult.replace(".0","");
                        }
                        return Finalresult;
                        }catch (Exception e){
                            return "err";
                        }
    }
}