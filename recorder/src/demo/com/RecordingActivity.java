package demo.com;

import java.io.File;
import java.io.IOException;

import demo.com.RecordButton.OnFinishedRecordListener;
import demo.com.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
//no
public class RecordingActivity extends Activity {

    private RecordButton mRecordButton = null;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        mRecordButton = (RecordButton) findViewById(R.id.record_button);

        String path = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/com.dci.android.ssp";

        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
        path += "/mmmm.amr";
        mRecordButton.setSavePath(path);
        mRecordButton
                .setOnFinishedRecordListener(new OnFinishedRecordListener() {

                    @Override
                    public void onFinishedRecord(String audioPath) {
                        Log.i("RECORD!!!", "finished!!!!!!!!!! save to "
                                + audioPath);

                    }
                });

    }
}
