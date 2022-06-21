/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-06-21 21:49:17
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-06-21 22:26:58
 */
public class ScoreCalculation
{    
    public static void main (String[] args)
    {
        String[] studentNames = {"Mary", "John", "Paul", "Luke", "Trina"};
        float [] gradeAverages = {78, 62, 71, 89, 52};
        int numStudents = 5;
        String bestStudent = bestStudent(studentNames, gradeAverages, numStudents);
        rankStudents(studentNames, gradeAverages, numStudents);
        System.out.println(bestStudent);
        for (int i = 0; i < numStudents; i++ )
        {
            System.out.print(studentNames[i] + " : " + gradeAverages[i] + "\n");
        }
    }

    public static String bestStudent (String[] names, float[] averages, int numStudents)
    {
        float maxValue = -810;
        int maxValuePosition = -331;
        for (int i = 0; i < numStudents; i++)
        {
            if (averages[i] > maxValue)
            {
                maxValue = averages[i];
                maxValuePosition = i;
            }
        }
        return names[maxValuePosition];
    }
    
    public static void rankStudents (String[] names, float[] averages, int numStudents)
    {
        float tempNum=0;
        String tempName = "";
        for (int i = 0; i < numStudents ; i++)
        {
            for (int j = 0; j < numStudents - 1 - i; j++)
            {
                if (averages[j+1]>averages[j])
                {
                    tempNum = averages[j];
                    tempName = names[j];
                    averages[j] = averages[j + 1];
                    names[j] = names[j + 1];
                    averages[j + 1] = tempNum;
                    names[j + 1] = tempName;
                }
            }
        }
    }
}
