package com.unam.moviles.generadordecurp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayAdapter dataMonths, dataDays, dataYears;
    Spinner sp_months, sp_days, sp_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_days = (Spinner)findViewById(R.id.spnDay);
        sp_months = (Spinner)findViewById(R.id.spnMonth);
        sp_year = (Spinner)findViewById(R.id.spnYear);

        settingSpinnerProp(dataMonths, generateMonths(), sp_months);
        settingSpinnerProp(dataYears, generateYears(), sp_year);
        int quantity = (sp_year.getCount() - 13) - 1;
        sp_year.setSelection(quantity);
    }

    private void settingSpinnerProp(ArrayAdapter adapter, List<String> list, Spinner spn)
    {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(this);
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
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1949; i < currentYear; i++)
        {
            array.add(String.valueOf(i + 1));
        }
        return array;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == sp_months.getId())
        {
            int month = (int)sp_months.getSelectedItemId();
            settingSpinnerProp(dataDays, generateDays(month), sp_days);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
