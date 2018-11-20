package leetcode;

import java.util.*;

public class TikTockHotUserTest {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String userCountString = scanner.nextLine();
        String relationString = scanner.nextLine();
        String relationShipString = scanner.nextLine();

        int userCount = Integer.valueOf(userCountString);

        String[] relationShipArray = relationShipString.split(" ");
        int[][] relationShip = new int[userCount][userCount];
        HashMap<Integer , Integer> userPosiMap = new HashMap<>(userCount);

        int posi = 0;
        for(int i = 0 ; i < relationShipArray.length ; i ++){
            int no = Integer.valueOf(relationShipArray[i]);

            if(!userPosiMap.containsKey(no)){
                userPosiMap.put(no , posi++);
            }

            if(i % 2 != 0){
                relationShip[userPosiMap.get(Integer.valueOf(relationShipArray[i-1]))][userPosiMap.get(no)] = 1;
            }
        }

        Set<Integer> allUserSet = userPosiMap.keySet();
        while(allUserSet.iterator().hasNext()){
            Set<Integer> alreadyAddSet = new HashSet<>(userCount);
        }

    }

    private void printlnArray(int[][] array){
        for(int i = 0 ; i < array[0].length ; i ++){
            for(int j = 0 ; j < array.length ; j ++){
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
