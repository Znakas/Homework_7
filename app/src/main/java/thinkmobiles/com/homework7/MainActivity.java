package thinkmobiles.com.homework7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewitem_1;
    TextView textViewitem_2;
    TextView textViewitem_3;
    LinearLayout item1_llayout;
    LinearLayout item2_llayout;
    LinearLayout item3_llayout;
    TextView settings1;
    TextView settings2;
    TextView settings3;
    MenuItem action_item1;
    MenuItem action_item2;
    MenuItem action_item3;
    public int item_checked=1;
    final static public int ITEM1 = 1;
    final static public int ITEM2 = 2;
    final static public int ITEM3 = 3;
    final static public String SELECTED_ITEM = "Key for check";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewitem_1 = (TextView) findViewById(R.id.textViewitem_1);
        textViewitem_2 = (TextView) findViewById(R.id.textViewitem_2);
        textViewitem_3 = (TextView) findViewById(R.id.textViewitem_3);
        settings1 = (TextView) findViewById(R.id.settings1);
        settings2 = (TextView) findViewById(R.id.settings2);
        settings3 = (TextView) findViewById(R.id.settings3);
        item1_llayout = (LinearLayout) findViewById(R.id.item1_layout);
        item2_llayout = (LinearLayout) findViewById(R.id.item2_layout);
        item3_llayout = (LinearLayout) findViewById(R.id.item3_layout);
    }
    public void CheckItem(int item_checked){
        switch(item_checked){
            case ITEM1:
                item1_checked();
            break;
            case ITEM2:
                item2_checked();
            break;
            case ITEM3:
                item3_checked();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        action_item1 = menu.findItem(R.id.action_item1);
        action_item2 = menu.findItem(R.id.action_item2);
        action_item3 = menu.findItem(R.id.action_item3);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_item1:
                item_checked = ITEM1;
                action_item1.setIcon(R.drawable.ic_checked);
                action_item2.setIcon(R.drawable.ic_unchecked);
                action_item3.setIcon(R.drawable.ic_unchecked);
                item1_checked();
                break;
            case R.id.action_item2:
                item_checked = ITEM2;
                action_item1.setIcon(R.drawable.ic_unchecked);
                action_item2.setIcon(R.drawable.ic_checked);
                action_item3.setIcon(R.drawable.ic_unchecked);
                item2_checked();
                break;
            case R.id.action_item3:
                item_checked = ITEM3;
                action_item1.setIcon(R.drawable.ic_unchecked);
                action_item2.setIcon(R.drawable.ic_unchecked);
                action_item3.setIcon(R.drawable.ic_checked);
                item3_checked();
                break;
        }
        return true;
    }
    public void onClick1(View v) {
        final PopupMenu menu = new PopupMenu(this, v);
            menu.inflate(R.menu.menu_item);
            menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.open_window:
                            Intent intent = new Intent(MainActivity.this, ItemView_Activity.class);
                            intent.putExtra("item_title", getString(R.string.item_1));
                            intent.putExtra("item_text", getString(R.string.text_item1));
                            startActivity(intent);
                            break;
                        case R.id.show_toast:
                            Toast.makeText(MainActivity.this, getString(R.string.text_item1), Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.close:
                            finish();
                            break;
                    }
                    return false;
                }
            });
            menu.show();
    }
    public void onClick2(View v) {
        final PopupMenu menu = new PopupMenu(this, v);
        menu.inflate(R.menu.menu_item);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.open_window:
                        Intent intent = new Intent(MainActivity.this, ItemView_Activity.class);
                        intent.putExtra("item_title", getString(R.string.item_2));
                        intent.putExtra("item_text", getString(R.string.text_item2));
                        startActivity(intent);
                        break;
                    case R.id.show_toast:
                        Toast.makeText(MainActivity.this, getString(R.string.text_item2), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.close:
                        finish();
                        break;
                }
                return false;
            }
        });
        menu.show();
    }
    public void onClick3(View v) {
        final PopupMenu menu = new PopupMenu(this, v);
        menu.inflate(R.menu.menu_item);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.open_window:
                        Intent intent = new Intent(MainActivity.this, ItemView_Activity.class);
                        intent.putExtra("item_title", getString(R.string.item_3));
                        intent.putExtra("item_text", getString(R.string.text_item3));
                        startActivity(intent);
                        break;
                    case R.id.show_toast:
                        Toast.makeText(MainActivity.this, getString(R.string.text_item3), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.close:
                        finish();
                        break;
                }
                return false;
            }
        });
        menu.show();
    }
    private void item1_checked() {
        item1_llayout.setBackgroundResource(R.drawable.item_checked);
        item2_llayout.setBackgroundResource(R.drawable.item_unchecked);
        item3_llayout.setBackgroundResource(R.drawable.item_unchecked);
        textViewitem_1.setTextColor(getResources().getColor(R.color.contentDisableColor));
        textViewitem_2.setTextColor(getResources().getColor(R.color.textDisableColor));
        textViewitem_3.setTextColor(getResources().getColor(R.color.textDisableColor));
        settings1.setEnabled(true);
        settings2.setEnabled(false);
        settings3.setEnabled(false);
    }
    private void item2_checked() {
        item1_llayout.setBackgroundResource(R.drawable.item_unchecked);
        item2_llayout.setBackgroundResource(R.drawable.item_checked);
        item3_llayout.setBackgroundResource(R.drawable.item_unchecked);
        textViewitem_1.setTextColor(getResources().getColor(R.color.textDisableColor));
        textViewitem_2.setTextColor(getResources().getColor(R.color.contentDisableColor));
        textViewitem_3.setTextColor(getResources().getColor(R.color.textDisableColor));
        settings1.setEnabled(false);
        settings2.setEnabled(true);
        settings3.setEnabled(false);
    }
    private void item3_checked() {
        item1_llayout.setBackgroundResource(R.drawable.item_unchecked);
        item2_llayout.setBackgroundResource(R.drawable.item_unchecked);
        item3_llayout.setBackgroundResource(R.drawable.item_checked);
        textViewitem_1.setTextColor(getResources().getColor(R.color.textDisableColor));
        textViewitem_2.setTextColor(getResources().getColor(R.color.textDisableColor));
        textViewitem_3.setTextColor(getResources().getColor(R.color.contentDisableColor));
        settings1.setEnabled(false);
        settings2.setEnabled(false);
        settings3.setEnabled(true);
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM, item_checked);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        item_checked = savedInstanceState.getInt(SELECTED_ITEM);
        CheckItem(item_checked);
    }
}
