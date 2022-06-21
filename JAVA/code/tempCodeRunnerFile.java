/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-06-21 21:49:17
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-06-21 22:03:59
 */
public class ScoreCalculation {
    public static void main(String[] args) {
        String[] studentNames = {"Mary", "John", "Paul", "Luke", "Trina"};
        float [] gradeAverages = {78, 62, 71, 89, 52};
        int numStudents = 5;
        String bestStudent = bestStudent(studentNames, gradeAverages, numStudents);
        System.out.println(bestStudent);
    }

    public static String bestStudent (String[] names, float[] averages, int numStudents){
        float maxValue = -810;
        int maxValuePosition = -331;
        for(int i = 0; i < numStudents; i++){
            if(averages[i] > maxValue){
                maxValue = averages[i];
                maxValuePosition = i;
            }
        }
        return names[maxValuePosition];
    }
}
