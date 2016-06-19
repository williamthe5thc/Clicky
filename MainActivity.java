package edu.byui.theawesomes.clicky;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int count;
    public static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore settings
        SharedPreferences settings = getSharedPreferences("MyPrefsFile", 0);
        count = settings.getInt("count",0);

        //set the text fields
        TextView advanceView = (TextView) findViewById(R.id.counter);
        String countS = Integer.toString(count);
        advanceView.setText(countS);
    }

    public void advanceButtonOnClick(View v) {
        count++;
        TextView advanceView = (TextView) findViewById(R.id.counter);
        String countS = Integer.toString(count);
        advanceView.setText(countS);
    }

    public void saveCountButtonOnClick(View v) {
        //save the stuff!
        SharedPreferences settings = getSharedPreferences("MyPrefsFile", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("count", count);

        //necessary to commit changes to save stuff
        editor.commit();
    }
}
