package com.example.carpc.widgets.dashboardScreen.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.carpc.R;
import com.example.carpc.utils.DataParser;

public class TripManagerWidget extends Fragment {
    //LAST CHARGE
    public TextView passedDistanceTextView, rangeDistanceTextView, ampereHourTextView;
    //CURRENT TRIP
    public TextView passedDistanceCurTripTextView,
            usedEnergyCurTripTextView, averageConsumptionCurTripTextView;
    //ODOMETER
    public TextView totalTripTextView, totalEnergyTextView;
    int totalTripToSet = 0;
    DataParser parser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.trip_manager_widget, null);
        passedDistanceTextView = v.findViewById(R.id.passed_last_charge_text_view);
        rangeDistanceTextView = v.findViewById(R.id.range_last_charge_text_view);
        ampereHourTextView = v.findViewById(R.id.ampere_hour_text_view);

        passedDistanceCurTripTextView = v.findViewById(R.id.passed_current_trip_text_view);
        usedEnergyCurTripTextView = v.findViewById(R.id.current_trip_used_energy_text_view);
        averageConsumptionCurTripTextView = v.findViewById(R.id.current_trip_average_consumption_text_view);

        totalTripTextView = v.findViewById(R.id.value_total_trip);
        totalEnergyTextView = v.findViewById(R.id.value_total_energy);
        parser = DataParser.getInstance();
        setRetainInstance(true);
        return v;
    }

    public void updateWidgetUI(final Double lastChargePassedDistance, final Double range, final Double totalDistance) {
        System.out.println("Battery manager Widget");
        passedDistanceTextView.post(new Runnable() {
            @Override
            public void run() {
                passedDistanceTextView.setText(String.valueOf(lastChargePassedDistance));
            }
        });
        rangeDistanceTextView.post(new Runnable() {
            @Override
            public void run() {
                rangeDistanceTextView.setText(String.valueOf(range));
            }
        });
        totalTripTextView.post(new Runnable() {
            @Override
            public void run() {
                totalTripTextView.setText(String.valueOf(totalDistance));
            }
        });
    }
}