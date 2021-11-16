package com.example.aworldbluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    Button TurnOn_btn,TurnOff_btn,Pair_btn,Discover_btn;
    TextView Anil,Kumar;
    ImageView imageView;
    BluetoothAdapter adapter;
    private Toast showToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        TurnOn_btn = findViewById ( R.id.TurnOn_btn );
        TurnOff_btn = findViewById ( R.id.TurnOff_btn );
        Pair_btn = findViewById ( R.id.Pair_btn );
        Anil = findViewById ( R.id.Anil );
        Kumar = findViewById ( R.id.Kumar );
        Discover_btn = findViewById ( R.id.Discover_btn );
        imageView = findViewById ( R.id.imageView );


        adapter = BluetoothAdapter.getDefaultAdapter ();

        if (adapter == null){
            Anil.setText ( "Bluetooth is not show" );


        }
        else {
            Anil.setText ( "Bluetooth device is available" );
        }



      if (adapter.isEnabled ()){

        imageView.setImageResource ( R.drawable.ic_paswan_on );



      }
      else {
          Anil.setText ( "Blue is show off device" );
          imageView.setImageResource ( R.drawable.ic_paswan_off );

      }



      TurnOn_btn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View view) {
              if (!adapter.isEnabled ()){
                  
                  showToast.makeText ( MainActivity.this, "Turn On Bluetooth", Toast.LENGTH_SHORT ).show ();
                  Intent i = new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE);

                  startActivityForResult ( i,REQUEST_ENABLE_BT );


              }
              else {
                  showToast("Bluetooth is Already On ");
              }



          }
      } );

      TurnOff_btn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View view) {
              if (adapter.isEnabled ()){
                  adapter.disable ();
                  showToast ( "Turning Bluetooth off" );
                  imageView.setImageResource ( R.drawable.ic_paswan_off );

              }
              else {
                 showToast ( "Bluetooth is already Turned off" );
              }

          }
      } );


      Discover_btn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View view) {
              if (!adapter.isDiscovering ()){
                  showToast ( "Making Your Device Discoverable" );
                  Intent intent= new Intent (BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                  startActivityForResult ( intent,REQUEST_DISCOVER_BT );
              }


          }
      } );
      Pair_btn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View view) {
              if (adapter.isEnabled ()){
                  Kumar.setText ( "Paired Devices" );
                  Set<BluetoothDevice> device = adapter.getBondedDevices ();
                  for (BluetoothDevice Manoj: device){
                      Kumar.append ( "\nDevice: " + Manoj.getName ()+ ","+ device);


                  }

              }
              else {
                  showToast ( "Turn on bluetooth to get paired devices" );


              }

          }
      } );






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        switch (requestCode){
            case REQUEST_ENABLE_BT:

                if (resultCode  == RESULT_OK){

                    imageView.setImageResource ( R.drawable.ic_paswan_on );
                    showToast ( "Bluetooth is on" );

                }
                else {
                    showToast ( "Not on Bluetooth" );
                }
                break;


        }
        super.onActivityResult ( requestCode, resultCode, data );
    }

    private  void showToast(String Mass){
        Toast.makeText ( this, "Mass", Toast.LENGTH_SHORT ).show ();

    }
}