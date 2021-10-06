package jayedwards.com.somesortofworkfordigital;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import jayedwards.com.somesortofworkfordigital.databinding.ActivityMain3Binding;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void onClick(View view) {
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
        toastMsg("Going to page 1");
        EditText num1TxtBox = findViewById(R.id.editTextNum1);
        TextView num2TxtBox = findViewById(R.id.editTextNum2);
        EditText operatorBox = findViewById(R.id.editTextOper);

        TextView answer = findViewById(R.id.textViewAnswer);

        String num1String = num1TxtBox.getText().toString();
        int IntNum1 = Integer.parseInt(num1String);

        String operator = operatorBox.getText().toString();

        String num2String = num2TxtBox.getText().toString();
        int intNum2 = Integer.parseInt(num2String);

        int answerNumber = 0;

        if (operator.equals("+") ||operator.equals("plus")){
            answerNumber = IntNum1 + intNum2;
        } else {
            if(operator.equals("*")||operator.equals("times")) {
                answerNumber = IntNum1 * intNum2;
            } else {
                if(operator.equals("-")||operator.equals("minus")){
                    answerNumber = IntNum1 - intNum2;
                }
            }
        }

        {
        answer.setText(Integer.toString(answerNumber));
            if (operator.equals("1")) {
                startActivity (new Intent(MainActivity2.this,MainActivity.class));
                toastMsg("2");
            } else {
                toastMsg("Wrong PW lad!!!!");
            }
        }
    }

}

