/*
 * @Description: 0810
 * @Author: Yixin Li
 * @Date: 2022-06-16 11:30:08
 * @LastEditors: Yixin Li
 * @LastEditTime: 2022-06-20 10:18:19
 */
import java.util.*;

public class MapParallelArray {
    public static void main(String[] args) {

        String[] FIRE_STATIONS = {"ALPHA", "BETA", "THETA", "CENTER", "RAILWAY", "HARBOR", "SUBURB"};
        int[] PERSONNEL = {2, 13, 23, 44, 23, 11, 43};
        Collection  FIRE_DUTY = new ArrayList<>();
        String STATION_ON_DUTY = "", UNDERSTAFFED = "", INPUT_DEVICE = "";
        int MIN = PERSONNEL[0];
        Scanner sc = new Scanner(System.in);
        
        calculate(PERSONNEL, FIRE_STATIONS);

        for(int I = 0; I < FIRE_STATIONS.length; I++){
            FIRE_DUTY.add(FIRE_STATIONS[I]);
        }
        
        Iterator it = FIRE_DUTY.iterator();

        for(int M = 0; M < FIRE_STATIONS.length; M++){
            if(MIN >= PERSONNEL[M]){
                MIN = PERSONNEL[M];
                UNDERSTAFFED = FIRE_STATIONS[M];
            }
        }

        int I = 0;
        while(I <= 52){
            INPUT_DEVICE = sc.nextLine();
            if(INPUT_DEVICE.compareTo("true") == 0){
                if(it.hasNext()){
                    STATION_ON_DUTY = (String) it.next();
                    if(STATION_ON_DUTY.compareTo(UNDERSTAFFED) == 0){
                        System.out.print("This station is understaffed. ");
                    }
                    System.out.println(STATION_ON_DUTY);
                }
                else{
                    it = FIRE_DUTY.iterator();
                    STATION_ON_DUTY = (String) it.next();
                    if(STATION_ON_DUTY.compareTo(UNDERSTAFFED) == 0){
                        System.out.print("This station is understaffed. ");
                    }
                    System.out.println(STATION_ON_DUTY);
                }
            }
            else if(INPUT_DEVICE.compareTo("false") == 0){
                I = 53;
                System.out.println("Emergency stop of procedure");
            }
            I = I + 1;
        }
    }

    public static void calculate(int[] args, String[] argss){
        int[] INFO = {-1, -1, -1, -1, -1, -1};
        for(int M = 0; M < 6; M++){
            if(args[M] < 25){
                INFO[M] = 25 - args[M];
            }
            else{
                INFO[M] = 0;
            }
            if(INFO[M] > 0){
                System.out.println("---------------------------");
                System.out.println(argss[M] + " lacks " + INFO[M] + " firefighters ");
            }
        }
    }
}
