package uk.ac.cam.jas250.networkutilities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NetworkUtilitiesActivity extends Activity implements OnClickListener{
	
	private Button btn_MyNetworks;
	private Button btn_AddressCalculator;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Link buttons
        btn_MyNetworks = (Button) findViewById(R.id.btn_MyNetworks);
        btn_AddressCalculator = (Button) findViewById(R.id.btn_AddressCalculator);
        btn_MyNetworks.setOnClickListener(this);
        btn_AddressCalculator.setOnClickListener(this);
    }

	public void onClick(View v) {
		if(R.id.btn_MyNetworks == v.getId()){
			Intent myNetworksI = new Intent(NetworkUtilitiesActivity.this, MyNetworksActivity.class);
			startActivity(myNetworksI);
		}
		else if(R.id.btn_AddressCalculator == v.getId()){
			Intent addressCalculatorI = new Intent(NetworkUtilitiesActivity.this, AddressCalculatorActivity.class);
			startActivity(addressCalculatorI);
		}
	}
    
}