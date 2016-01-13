package com.ruler.timepicker;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    ImageView ivArrow;
    private android.support.v7.app.ActionBar actionBar;
    LinearLayout llHideInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setPadding(0, 0, 0, 0);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        addCustomeActionBar();

        ivArrow = (ImageView) findViewById(R.id.ivArrow);
        llHideInformation = (LinearLayout) findViewById(R.id.llHideInformation);
        llHideInformation.setVisibility(View.GONE);

        TextView tvBasedOn = (TextView)findViewById(R.id.tvBasedOn);
        tvBasedOn.setText(Html.fromHtml(getString(R.string.based_on)));

        EditText etName = (EditText)findViewById(R.id.etName);
        etName.getBackground().setColorFilter(getResources().getColor(R.color.gray_light), PorterDuff.Mode.SRC_IN);


        ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(llHideInformation.getVisibility() == View.GONE){
                    llHideInformation.setVisibility(View.VISIBLE);
                    ivArrow.setImageResource(R.mipmap.ic_action_arrow_down);
                }else {
                    llHideInformation.setVisibility(View.GONE);
                    ivArrow.setImageResource(R.mipmap.ic_action_arrow_up);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
  * Display custome actionBar
  * */
    private void addCustomeActionBar() {
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_TITLE);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View action_bar_view = inflator.inflate(R.layout.mainactivity_actionbar, null);
        actionBar.setCustomView(action_bar_view);
    }
}
