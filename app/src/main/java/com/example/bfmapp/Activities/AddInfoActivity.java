package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bfmapp.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddInfoActivity extends AppCompatActivity {

    TextInputEditText edtname,edtusername;

    TextView txtdob;

    Button btnfinish;

    Spinner spingender;

    String dob = "",selectedgender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        initviews();

        spinneritems();


        spingender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spingender.getItemAtPosition(position).toString().equals("Gender")){
                    selectedgender = "";

                }else {
                   selectedgender = spingender.getItemAtPosition(position).toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(AddInfoActivity.this, "Please Select your Gender", Toast.LENGTH_SHORT).show();

            }
        });


        txtdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDob();
            }
        });

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtname.getText().toString().equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                }else if (edtusername.getText().toString().equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please enter your Username", Toast.LENGTH_SHORT).show();
                }else if (dob.equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please Select your Date of birth", Toast.LENGTH_SHORT).show();
                }else if (selectedgender.equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please Select your Gender", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddInfoActivity.this, "Your details saved successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddInfoActivity.this,SelectCategoryActivity.class));
                    finish();
                }
            }
        });
    }

    private void initviews() {

        edtname = findViewById(R.id.info_edtname);
        edtusername = findViewById(R.id.info_edtusername);

        txtdob = findViewById(R.id.info_txtdob);

        btnfinish = findViewById(R.id.info_btnfinish);

        spingender = findViewById(R.id.info_spingender);
    }

    private void setDob(){
        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        final int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(AddInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month+1;
                dob = dayOfMonth+"/"+month+"/"+year;
                txtdob.setText(dob);
            }
        },year,month,day);

        datePickerDialog.show();
    }

    private void spinneritems(){

        ArrayList<String> genderslist = new ArrayList<>();
        genderslist.add(0,"Gender");
        genderslist.add("Male");
        genderslist.add("Female");
        genderslist.add("Other");

        ArrayAdapter<String > genderadapter = new ArrayAdapter<>(AddInfoActivity.this,android.R.layout.simple_list_item_1,genderslist);

        genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spingender.setAdapter(genderadapter);
    }
}
