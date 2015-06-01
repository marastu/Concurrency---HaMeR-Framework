package vandy.mooc;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

/**
 * An Activity that downloads an image, stores it in a local file on
 * the local device, and returns a Uri to the image file.
 */
public class DownloadImageActivity extends Activity {
    /**
     * Debugging tag used by the Android logger.
     */
	private int mDelay = 5000;
    private final String TAG = getClass().getSimpleName();
   

    /**
     * Hook method called when a new instance of Activity is created.
     * One time initialization code goes here, e.g., UI layout and
     * some class scope variable initialization.
     *
     * @param Bundle object that contains saved state information.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Always call super class for necessary
        // initialization/implementation.
        // @@ TODO -- you fill in here.
         super.onCreate(savedInstanceState);
         
      
        // Get the URL associated with the Intent data.
        // @@ TODO -- you fill in here.
         final Uri uri = this.getIntent().getData();
        
         
             
        // Download the image in the background, create an Intent that
        // contains the path to the image file, and set this as the
        // result of the Activity.
 
	         // @@ TODO -- you fill in here using the Android "HaMeR"
        // concurrency framework.  Note that the finish() method
        // should be called in the UI thread, whereas the other
        // methods should be called in the background thread.
             
       
         
    
   
         Runnable downloadImageRunnable = new Runnable() {
			@Override
			public void run() {
				DownloadUtils du= new DownloadUtils();
			 Uri data=du.downloadImage(getApplicationContext(), uri);
								 Intent returnIntent = new Intent();
								 returnIntent.setData(data);
				                 setResult(MainActivity.RESULT_OK,returnIntent);     
				               						
			
				           runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						finish();
					}
	            	 
	             });
				
			}
	
    };
	new Thread(downloadImageRunnable).start();	
	

			
	}
}
    
    

	

