package lowestcost.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

import static android.R.attr.key;
import static android.R.attr.max;
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    LinkedHashMap<Integer, ArrayList<Integer>> linkedHashMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
    ArrayList<Integer> positionArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView output1 = (TextView)findViewById(R.id.Row1);
        TextView output2 = (TextView)findViewById(R.id.Row2);
        TextView output3 = (TextView)findViewById(R.id.Row3);

        int inputData[][]= { {3, 4, 1, 2, 8, 6},
                             {6, 1, 8, 2, 7, 4},
                             {5, 9, 3, 9, 9, 5},
                             {8, 4, 1, 3, 2, 6},
                             {3, 7, 2, 1, 2, 3}};


        int transposeMatrix[][] = transformMatrix(inputData);

        for(int i=0; i<transposeMatrix.length; i++) {

            ArrayList<Integer> columnData = new ArrayList<Integer>();
            for(int j=0; j<transposeMatrix[i].length; j++) {
                columnData.add(j,transposeMatrix[i][j]);
            }
            linkedHashMap.put(i, columnData);
        }

        output2.setText(String.valueOf(getTotalCost()));
        output3.setText((String.valueOf(positionArray)));

        if (getTotalCost() > 50 ) {
            output1.setText("NO");
        }
        else {
            output1.setText("YES");
        }
    }

    public int getMinValue(ArrayList array) {

        Object obj = Collections.min(array);
        return (int) obj;
    }

    public int getPosition(ArrayList array, int element) {

        for (int i = 0;i<array.size();i++)  {
            Object obj = array.get(i);

            if ((int) obj == element) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] transformMatrix(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] trasposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++)
        {
            for(int y = 0; y < m; y++)
            {
                trasposedMatrix[x][y] = matrix[y][x];
            }
        }
        return trasposedMatrix;
    }

    private int getTotalCost() {

        int totalValue = 0;
        int position = 0;
        for (int i = 0;i<linkedHashMap.size();i++) {

            ArrayList arrayList = linkedHashMap.get(i);
            int minimumValue = getMinValue(arrayList);
            position = getPosition(arrayList, minimumValue) + 1;
            positionArray.add(position);
            totalValue = totalValue + minimumValue;
        }

        return totalValue;
    }
}
