package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox check1, check2, check3, check4, check5;
    Button btnReset, btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);

        btnReset = findViewById(R.id.btnReset);
        btnSave = findViewById(R.id.btnSAve);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer Anil = new StringBuffer();
                Anil.append(" Select value :");


                if (check1.isChecked()) {
                    Anil.append("\n" + check1.getText().toString());

                }

                if (check2.isChecked()) {
                    Anil.append("\n" + check2.getText().toString());

                }
                if (check3.isChecked()) {
                    Anil.append("\n" + check3.getText().toString());

                }
                if (check4.isChecked()) {
                    Anil.append("\n" + check4.getText().toString());

                }
                if (check5.isChecked()) {
                    Anil.append("\n" + check5.getText().toString());

                }
                if (!check1.isChecked() && !check2.isChecked() && !check3.isChecked() && !check4.isChecked() && !check5.isChecked()) {
                    Anil.append("\nNone");

                    ToastClass.toastClass(MainActivity.this, Anil.toString());
                }


            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check1.isChecked()) {
                    check1.setChecked(false);


                    if (check2.isChecked()) {
                        check2.setChecked(false);

                        if (check3.isChecked()) {
                            check3.setChecked(false);


                            if (check4.isChecked()) {
                                check4.setChecked(false);

                                if (check5.isChecked()) {
                                    check5.setChecked(false);

                                }


                            }

                        }

                    }


                }
            }
        });


        /*check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    ToastClass.toastClass(MainActivity.this, "Show Name");

                } else {
                    ToastClass.toastClass(MainActivity.this, "Show clear Name");
                }

            }
        });*/


    }

    public void onCheckBoxCliked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.check1:
                if (checked) {
                    Log.d("check1", "Checked");
                } else {
                    Log.d("check1", "Unchecked");
                    break;
                }
                switch (view.getId()) {
                    case R.id.check2:
                        if (checked) {
                            Log.d("check2", "Checked");
                        } else {
                            Log.d("check2", "Unchecked");
                            break;
                        }
                        switch (view.getId()) {
                            case R.id.check3:
                                if (checked) {
                                    Log.d("check3", "Checked");
                                } else {
                                    Log.d("check3", "Unchecked");
                                    break;
                                }
                                switch (view.getId()) {
                                    case R.id.check4:
                                        if (checked) {
                                            Log.d("check4", "Checked");
                                        } else {
                                            Log.d("check4", "Unchecked");
                                            break;
                                        }

                                        switch (view.getId()) {
                                            case R.id.check5:
                                                if (checked) {
                                                    Log.d("check5", "Checked");
                                                } else {
                                                    Log.d("check5", "Unchecked");
                                                    break;


                                                }

                                        }


                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + view.getId());
                                }
                        }

                }
        }
    }
}