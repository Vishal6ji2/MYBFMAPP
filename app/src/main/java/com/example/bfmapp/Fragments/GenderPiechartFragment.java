package com.example.bfmapp.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.bfmapp.R;

import java.util.ArrayList;

public class GenderPiechartFragment extends Fragment {

    AnyChartView anyChartView;

    String [] genders = {"Male","Female"};
    double[] genpercent = {90.0,10.0};

    public GenderPiechartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gender_piechart, container, false);

        anyChartView = view.findViewById(R.id.genderfrag_chart);

        setupPieChart();

        return view;
    }

    private void setupPieChart() {

        ArrayList<DataEntry> dataEntries = new ArrayList<>();
        Pie pie = AnyChart.pie();

        for (int i=0; i<genders.length;i++){

            dataEntries.add(new ValueDataEntry(genders[i],genpercent[i]));
        }

        pie.data(dataEntries);

        anyChartView.setChart(pie);
    }

}
