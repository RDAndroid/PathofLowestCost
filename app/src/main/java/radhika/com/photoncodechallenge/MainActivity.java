package radhika.com.photoncodechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import radhika.com.photoncodechallenge.utils.PathResult;
import radhika.com.photoncodechallenge.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String expectedContents = getValidString("\t",Utils.EXAMPLE_1);
        ((EditText) findViewById(R.id.etGrid)).setText(expectedContents);

        Button btSubmit = (Button) findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String grString = ((EditText) findViewById(R.id.etGrid)).getText().toString();
                int[][] gridContent = Utils.strintToArray(grString);
                if (validArray(gridContent)) {
                    loadResult(grString);
                } else {
                    Toast.makeText(MainActivity.this, "Ivalid items", Toast.LENGTH_SHORT).show();
                    ((TextView) findViewById(R.id.tvCost)).setText("Invalid matrix");
                    ((TextView) findViewById(R.id.tvResult)). setVisibility(View.GONE);
                    ((TextView) findViewById(R.id.tvPath)).setVisibility(View.GONE);
                }
            }
        });

    }
    private boolean validArray(int[][] elements) {
        if (elements.length < 1 || elements.length > 10 || elements[0].length < 1 || elements[0].length > 100 ) {
            return false;
        } else {
            return true;
        }
    }
    private void loadResult(String contents) {
        PathResult pathResult=Utils.calculateLowestCostPath(contents);
        if(pathResult!=null)
        {
            if(pathResult.getValidPath())
            ((TextView) findViewById(R.id.tvCost)).setText("YES");
            else
                ((TextView) findViewById(R.id.tvCost)).setText("NO");
            ((TextView) findViewById(R.id.tvResult)).setText(String.valueOf(pathResult.getLowestCost()));
            ((TextView) findViewById(R.id.tvPath)).setText(String.valueOf(pathResult.getLowestCostPath()));

        }else {
            Toast.makeText(MainActivity.this, "Ivalid items,Recheck inputs", Toast.LENGTH_SHORT).show();

        }

    }
    public String getValidString(String validator, int[][] values) {
        StringBuilder builder = new StringBuilder();

        for(int row = 0; row < values.length; ++row) {
            for(int column = 0; column < values[row].length; ++column) {
                builder.append(values[row][column]);
                if(column < values[row].length - 1) {
                    builder.append(validator);
                }
            }

            if(row < values.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
