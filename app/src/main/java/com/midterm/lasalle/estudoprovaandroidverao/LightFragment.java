package com.midterm.lasalle.estudoprovaandroidverao;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LightFragment extends Fragment implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor sensorLuz;
    private TextView textViewLuz;

    public LightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_light, container, false);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        textViewLuz = rootView.findViewById(R.id.textViewLuz);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        sensorManager.registerListener(this,sensorLuz,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float luz = sensorEvent.values[0];

          textViewLuz.setText(Float.toString(luz));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
