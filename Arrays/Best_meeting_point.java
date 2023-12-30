// time complexity. is O(n^2)
// question simply ask to find the minimum distance to travel by the people to meet
// where 1 is the people in the 2d arrayList 
// so we find the median point first and then we find the distance travlled by each people
// median will always give shortest path 
// to find median first we take xco-ordinate and yco-ordinate in shorted order
// to find xco-ordinate we traverse row wise and check for 1 and add row
// to find yco-ordinate we traverse column wise and check for 1 and add in column
// to find xmedian and ymedian we simply take the median index value of x and y and the array list
// distance formula will be= math.abs(xmedian-x1)+(xmedian-x2)+(ymedian-y1)+(ymedian-y2)
// return distance
// 
import java.util.ArrayList;

public class Solution {

	public static int findBestMeetingPoint(ArrayList<ArrayList<Integer>> mat) {

        int n = mat.size(), m = mat.get(0).size(); // column and row size

        // Storing x coordinates in the array 'xCoordinates'.
        ArrayList<Integer> xCoordinates = new ArrayList<Integer>();
        ArrayList<Integer> yCoordinates = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (mat.get(i).get(j) == 1)
                {
                    xCoordinates.add(i); // add x coordinate in ascending order by traversing rowwise
                }
            }
        }

        // Storing y coordinates in the array 'yCoordinates'.
        for (int j = 0; j < m; j++)
        {
            for (int i = 0; i < n; i++)
            {
                if (mat.get(i).get(j) == 1)
                {
                    yCoordinates.add(j); // adding y coordinate in ascending order by traversing column wise
                }
            }
        }

        int totalPoints = xCoordinates.size();

        // Taking the meeting point as the middle point.
        int middlePointX = xCoordinates.get(totalPoints / 2); // findind median
        int middlePointY = yCoordinates.get(totalPoints / 2);


        int minDistanceTravelled = 0;

        // for (int i = 0; i < n; i++)
        // {
        //     for (int j = 0; j < m; j++)
        //     {
        //         if (mat.get(i).get(j) == 1)
        //         {
        //             /*
        //                 If the there is a friend at point (i, j),add the 
        //                 distance of middle point to (i, j) to currentDistance.
        //             */
        //             minDistanceTravelled += Math.abs(i - middlePointX); 
        //             minDistanceTravelled += Math.abs(j - middlePointY);
        //         }
        //     }
        // }
		// above commented code too works but take bit more time than the below code
		for(int i=0;i<xCoordinates.size();i++){
			minDistanceTravelled+=Math.abs(middlePointX-xCoordinates.get(i));
		}
		for(int i=0;i<yCoordinates.size();i++){
			minDistanceTravelled+=Math.abs(middlePointY-yCoordinates.get(i));
		}

        // Return minDistanceTravelled as the final answer.
        return minDistanceTravelled;
	}

}