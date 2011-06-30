package uk.ac.cam.jas250.networkutilities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddressCalculatorActivity extends Activity implements OnClickListener{
	
	private Button btn_Back;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addresscalculator);
		
		//Link Buttons
		btn_Back = (Button)findViewById(R.id.btn_Back);
		btn_Back.setOnClickListener(this);
	}

	public void onClick(View v) {
		if(v.getId() == R.id.btn_Back){
			finish();
		}
		else if(v.getId() == R.id.btn_Update){
			updateCalcs();
		}
	}
	
	private void updateCalcs(){
		
	}

}
