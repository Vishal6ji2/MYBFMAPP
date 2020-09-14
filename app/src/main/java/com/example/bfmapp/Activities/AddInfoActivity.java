package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


    String dob = "";

    Spinner spincategory;
    String selectcategory;

    RadioGroup radioGroup;
    RadioButton selectedgender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        initviews();

        spinneritems();



        spincategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spincategory.getItemAtPosition(position).toString().equals("Select Who you are")){
                    selectcategory = "";

                }else {
                    selectcategory = spincategory.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(AddInfoActivity.this, "Please Select your Category", Toast.LENGTH_SHORT).show();

            }
        });

        txtdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setDob();
            }
        });

        selectedgender = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtname.getText().toString().equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please enter your Name", Toast.LENGTH_SHORT).show();
                }else if (edtusername.getText().toString().equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please enter your Username", Toast.LENGTH_SHORT).show();
                }else if (dob.equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please Select your Date of birth", Toast.LENGTH_SHORT).show();
                }else if (selectedgender==null){
                    Toast.makeText(AddInfoActivity.this, "Please select your Gender", Toast.LENGTH_SHORT).show();
                    Log.d( "gender",  selectedgender.getText().toString());
                }else if (selectcategory.equals("")){
                    Toast.makeText(AddInfoActivity.this, "Please Select your Category", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddInfoActivity.this, "Your details saved successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddInfoActivity.this,SelectCategoryActivity.class));
                    finish();
                }
            }
        });
    }

    private void initviews() {

        spincategory = findViewById(R.id.info_spincategories);

        radioGroup = findViewById(R.id.info_radiogroup);

        edtname = findViewById(R.id.info_edtname);
        edtusername = findViewById(R.id.info_edtusername);

        txtdob = findViewById(R.id.info_txtdob);

        btnfinish = findViewById(R.id.info_btnfinish);

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

        ArrayList<String> categories = new ArrayList<>();
        categories.add(0,"Select Who you are");
        categories.add("Director");
        categories.add("FilmMaker");
        categories.add("Photography");
        categories.add("VFX");
        categories.add("Animation");
        categories.add("Video Editing");
        categories.add("Vlogging");
        categories.add("CGI");
        categories.add("Blogging");
        categories.add("Science Fiction");
        categories.add("Illustrator");
        categories.add("3D Animation");
        categories.add("Novels");
        categories.add("Writing");
        categories.add("Script Writing");
        categories.add("2D Animation");
        categories.add("Content Writing");
        categories.add("Fiction");
        categories.add("Photoshop");
        categories.add("Others");

        ArrayAdapter<String> categoryadapter = new ArrayAdapter<>(AddInfoActivity.this,android.R.layout.simple_list_item_1,categories);

        categoryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spincategory.setAdapter(categoryadapter);
    }
}
