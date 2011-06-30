package uk.ac.cam.jas250.networkutilities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class AddressCalculatorActivity extends Activity implements OnClickListener{
	
	//UI Elements
	private Button btn_Back;
	private Button btn_Update;
	private RadioGroup rdgrp_NetworkClass;
	private EditText[] txt_ip;
	private Spinner spnr_SubnetMask;
	private TextView lbl_AddressRange;
	private TextView lbl_SubnetID;
	
	//Fields
	private String networkClass;
	private String ipAddress;
	private String subnetMask;
	
	//Subnets
	String[] subnets = new String[] {"255.255.255.0","255.255.255.128","255.255.255.192","255.255.255.224","255.255.255.240","255.255.255.248","255.255.255.252"};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addresscalculator);
		
		//Link Buttons
		btn_Back = (Button)findViewById(R.id.btn_Back);
		btn_Back.setOnClickListener(this);
		btn_Update = (Button)findViewById(R.id.btn_Update);
		btn_Update.setOnClickListener(this);
		
		//Link Fields
		rdgrp_NetworkClass = (RadioGroup)findViewById(R.id.rbgroup_NetworkClass);
		EditText txt_ip1 = (EditText)findViewById(R.id.txt_IpAdd1);
		EditText txt_ip2 = (EditText)findViewById(R.id.txt_IpAdd2);
		EditText txt_ip3 = (EditText)findViewById(R.id.txt_IpAdd3);
		EditText txt_ip4 = (EditText)findViewById(R.id.txt_IpAdd4);
		txt_ip = new EditText[4];
		txt_ip[0] = txt_ip1;
		txt_ip[1] = txt_ip2;
		txt_ip[2] = txt_ip3;
		txt_ip[3] = txt_ip4;
		spnr_SubnetMask = (Spinner)findViewById(R.id.spnr_SubnetMask);
		lbl_AddressRange = (TextView)findViewById(R.id.lbl_AddressRange);
		lbl_SubnetID = (TextView)findViewById(R.id.lbl_SubnetID);
		
		//Setup the spinner
		ArrayAdapter<String>subnetArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,subnets);
		subnetArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnr_SubnetMask.setAdapter(subnetArrayAdapter);
		
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
		//Get the ip address
		for(int i=0;i<4;i++){
			ipAddress+=(txt_ip[i].getText().toString());
		}
		
		//Get the network class selected
		int checkedRb = rdgrp_NetworkClass.getCheckedRadioButtonId();
		if(checkedRb == R.id.rb_A)
			networkClass = "A";
		else if(checkedRb == R.id.rb_B)
			networkClass = "B";
		else if(checkedRb == R.id.rb_C)
			networkClass = "C";
		
		//Get the subnet selected
		int pos = spnr_SubnetMask.getSelectedItemPosition();
		subnetMask = subnets[pos];
		
	}

}
