package com.unam.moviles.generadordecurp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ArrayAdapter data_months, data_day, data_years;
    Spinner sp_months, sp_days, sp_year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_days = (Spinner)findViewById(R.id.spnDay);
        sp_months = (Spinner)findViewById(R.id.spnMonth);
        sp_year = (Spinner)findViewById(R.id.spnYear);

        //sp_days = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, generateDays());
        //sp_months = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, generateMonths());
        sp_year = (Spinner)findViewById(R.id.spnYear);
    }

    private List<String> generateMonths()
    {
        List<String> months = new ArrayList<>();
        months.add("Enero");
        months.add("Febrero");
        months.add("Marzo");
        months.add("Abril");
        months.add("Mayo");
        months.add("Junio");
        months.add("Julio");
        months.add("Agosto");
        months.add("Septiembre");
        months.add("Octubre");
        months.add("Noviembre");
        months.add("Diciembre");
        return months;
    }

    private List<String> generateDays(int month)
    {
        int top = 0;
        if(month == 0 || month == 2 || month == 4  || month == 6
                || month == 7  || month == 9  || month == 11 )
            top = 31;
        else if(month == 1)
            top = 28;
        else
            top = 30;

//        int[] array = null;
        List<String> array = new ArrayList<>();
        for (int i = 0; i < top; i++)
        {
            array.add(String.valueOf(i + 1));
        }
        return array;
    }

    private List<String> generateYears()
    {
        List<String> array = new ArrayList<>();
        for (int i = 1949; i < 2016; i++)
        {
            array.add(String.valueOf(i + 1));
        }
        return array;
    }
}
