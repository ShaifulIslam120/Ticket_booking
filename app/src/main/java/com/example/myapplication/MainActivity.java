package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo, spinnerAdult, spinnerChild, spinnerSeatClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize spinners
        spinnerFrom = findViewById(R.id.spinner_from);
        spinnerTo = findViewById(R.id.spinner_to);
        spinnerAdult = findViewById(R.id.spinnerAdult);
        spinnerChild = findViewById(R.id.spinnerChild);
        spinnerSeatClass = findViewById(R.id.spinnerSeatClass); // Added for seat class spinner

        // Adapter for Country list (From and To spinners)
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country_list, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for 'From' and 'To' spinners
        spinnerFrom.setAdapter(countryAdapter);
        spinnerTo.setAdapter(countryAdapter);

        // Adapter for Passenger count (Adult and Children spinners)
        ArrayAdapter<CharSequence> passengerAdapter = ArrayAdapter.createFromResource(this, R.array.passenger_count, android.R.layout.simple_spinner_item);
        passengerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter for adult and child passenger spinners
        spinnerAdult.setAdapter(passengerAdapter);
        spinnerChild.setAdapter(passengerAdapter);

        // Adapter for Seat Class (Economy, Business, First Class)
        ArrayAdapter<CharSequence> seatClassAdapter = ArrayAdapter.createFromResource(this, R.array.seat_classes, android.R.layout.simple_spinner_item);
        seatClassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSeatClass.setAdapter(seatClassAdapter);

        // Set up listeners for spinners
        setSpinnerListener(spinnerFrom, "From");
        setSpinnerListener(spinnerTo, "To");
        setSpinnerListener(spinnerAdult, "Adults");
        setSpinnerListener(spinnerChild, "Children");
        setSpinnerListener(spinnerSeatClass, "Seat Class"); // Added listener for Seat Class spinner
    }

    /**
     * Helper method to set item selected listeners for spinners.
     *
     * @param spinner       The spinner to which listener is to be set
     * @param label         Label to display in the Toast (From, To, Adults, Children, Seat Class)
     */
    private void setSpinnerListener(Spinner spinner, final String label) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();
                // Avoid showing Toast for the initial 'Select' option
                if (!selectedItem.equals("Select Country") && !selectedItem.equals("Select Passenger Count") && !selectedItem.equals("Select Seat Class")) {
                    Toast.makeText(MainActivity.this, label + ": " + selectedItem, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing when no selection is made
            }
        });
    }
}
