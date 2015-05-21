package org.linaro.usb_speed_switch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.os.SystemProperties;


public class MainActivity extends Activity {
    String Tag="USB_SPEED_SWITCH";
    RadioButton HighSpeedButton;
    RadioButton FullSpeedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HighSpeedButton = (RadioButton)findViewById(R.id.HighSpeedButton);
        FullSpeedButton = (RadioButton)findViewById(R.id.FullSpeedButton);
        String state = SystemProperties.get("usb_speed.switch","full");
        Log.d(Tag,"Returned property" + state);
        if (state.equals("full")) {
            FullSpeedButton.setChecked(true);
        } else {
            HighSpeedButton.setChecked(true);
        }
        HighSpeedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(Tag,"Request for High Speed mode");
                    SystemProperties.set("usb_speed.switch","high");
                }
            }
        });
        FullSpeedButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.d(Tag,"Request for Full Speed mode");
                    SystemProperties.set("usb_speed.switch","full");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,"OnResume called");
        String state = SystemProperties.get("usb_speed.switch","full");
        if (state.equals("full")) {
            FullSpeedButton.setChecked(true);
        } else {
            HighSpeedButton.setChecked(true);
        }
    }
}
