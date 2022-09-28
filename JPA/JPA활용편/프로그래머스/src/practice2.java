import com.sun.jdi.IntegerType;

import java.util.*;

public class practice2 {
    public static void main(String[] args) {
        System.out.println(solution(5,"123123","qweqweqwe"));

    }

    public static String[] solution(int n, String[] queries) {
        String[] answer = {};
        String ip = "192.168.0.";
        HashMap<String,Integer> ipLog = new HashMap<>();
        int[] ipStatus = new int[n];
        ipStatus[0] = 100;
        Boolean ipUseAbleStatus = true;

        for(int i = 1;i<=n;i++){
            ipStatus[i] = 0;
        }
        ArrayList<String> result = new ArrayList<>();

        for (String query : queries) {
            String[] arrQuery = query.split(" ");
            String desktop = arrQuery[0];
            String command = arrQuery[1];

            if(command.equals("request")){
                if(ipLog.get(desktop) == null){
                    if(!ipUseAbleStatus){
                        result.add(desktop + " " + "reject");
                    }
                    else if(ipUseAbleStatus) {
                        for(int i = 1 ; i<=n ; i++){
                            if(ipStatus[i] == 0){
                                result.add(desktop + " " + i);
                                ipLog.put(desktop,i);
                                if(i==n){
                                    ipUseAbleStatus = false;
                                }
                                break;
                            }
                        }
                    }
                }
                if(ipLog.get(desktop) != null){
                    int recentUseIp = ipLog.get(desktop);


                }
            }
            else if(command.equals("release")){

            }



        }
        return answer;
    }




}
