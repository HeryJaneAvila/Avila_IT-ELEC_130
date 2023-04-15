package com.example.bottomnav.ui.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnav.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    IntentFilter intentFilter;
    int deviceHealth;
    String currentBatteryhealth="Battery Health ";
    int batteryLevel;
    TextView textView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = binding.textNotifications;
        final Button checkStatus = binding.buttonCheck;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        checkStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().registerReceiver(broadcastreceiver, intentFilter);

            }
        });
        return root;
    }
    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD) {

                textView.setText(currentBatteryhealth+" = Cold");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD){

                textView.setText(currentBatteryhealth+" = Dead");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD) {
                textView.setText(currentBatteryhealth+" = Good");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT) {

                textView.setText(currentBatteryhealth+" = OverHeat");
            }

            if (deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE);
            {

                textView.setText(currentBatteryhealth + " = Over voltage");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN){

                textView.setText(currentBatteryhealth+" = Unkown");
            }
            if (deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE) {

                textView.setText(currentBatteryhealth+" = Unspecified  Failure");
            }
        }
        };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}