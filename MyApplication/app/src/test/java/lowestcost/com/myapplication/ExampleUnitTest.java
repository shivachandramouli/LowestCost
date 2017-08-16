package lowestcost.com.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void transform_isCorrect() throws Exception {

        int inputData[][]= { {3, 4, 1},
                             {6, 1, 8},
                             {5, 9, 3},
                            };
        int outputData[][] = { {3,6,5},
                {4,1,9},
                {1,8,3}

        };

        int transformedMatrix[][] = transformMatrix(inputData);

        assertEquals(outputData, transformedMatrix);
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
}