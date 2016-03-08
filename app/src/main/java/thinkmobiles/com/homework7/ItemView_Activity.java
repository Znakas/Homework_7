package thinkmobiles.com.homework7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Andrii on 06.03.2016.
 */
public class ItemView_Activity extends AppCompatActivity {
    TextView income_title;
    TextView income_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);
        income_title = (TextView) findViewById(R.id.income_title);
        income_text = (TextView) findViewById(R.id.income_text);
        Intent intent = getIntent();
        String title = intent.getStringExtra("item_title");
        String text = intent.getStringExtra("item_text");
        income_title.setText(title);
        income_text.setText(text);
        setActionBar();
    }
    private void setActionBar() {
        final ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setTitle(R.string.item_screen);
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setDisplayShowHomeEnabled(true);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_settings);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}