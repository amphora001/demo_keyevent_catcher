package com.locationlabs.keyeventcatcher;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MyActivity extends Activity {

   private static StringBuilder buffer = new StringBuilder("This app shows keyCode being send to this Activity:\n");

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_my);
      showMessage(null, "onCreate");
   }

   private void showMessage(String msg, String log) {
      if (!TextUtils.isEmpty(msg)) {
         buffer.append(msg).append('\n');
         System.out.println(msg);
      }
      ((TextView) findViewById(R.id.txt_msg)).setText(buffer.toString());

      System.out.println(log);
   }

   @Override
   public boolean onKeyLongPress(int keyCode, KeyEvent event) {
      boolean result = super.onKeyLongPress(keyCode, event);
      showMessage("onKeyLongPress keyCode=" + keyCode, " event=" + event);
      return result;
   }

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
      boolean result = super.onKeyDown(keyCode, event);
      showMessage("onKeyDown keyCode=" + keyCode, " event=" + event);
      return result;
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.my, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();
      if (id == R.id.action_settings) {
         return true;
      }
      return super.onOptionsItemSelected(item);
   }
}
