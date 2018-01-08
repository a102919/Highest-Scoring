package sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mapCount {
    private Integer[][] table= {
            {4,0,-2,-1,-2,0,-2,-1,-1,-1,-1,-2,-1,-1,-1,1,0,0,-3,-2},
            {0,9,-3,-4,-2,-3,-3,-1,-3,-1,-1,-3,-3,-3,-3,-1,-1,-1,-2,-2},
            {-2,-3,6,2,-3,-1,-1,-3,-1,-4,-3,1,-1,0,-2,0,-1,-3,-4,-3},
            {-1,-4,2,5,-3,-2,0,-3,1,-3,-2,0,-1,2,0,0,-1,-2,-3,-2},
            {-2,-2,-3,-3,6,-3,-1,0,-3,0,0,-3,-4,-3,-3,-2,-2,-1,1,3},
            {0,-3,-1,-2,-3,6,-2,-4,-2,-4,-3,0,-2,-2,-2,0,-2,-3,-2,-3},
            {-2,-3,-1,0,-1,-2,8,-3,-1,-3,-2,1,-2,0,0,-1,-2,-3,-2,2},
            {-1,-1,-3,-3,0,-4,-3,4,-3,2,1,-3,-3,-3,-3,-2,-1,3,-3,-1},
            {-1,-3,-1,1,-3,-2,-1,-3,5,-2,-1,0,-1,1,2,0,-1,-2,-3,-2},
            {-1,-1,-4,-3,0,-4,-3,2,-2,4,2,-3,-3,-2,-2,-2,-1,1,-2,-1},
            {-1,-1,-3,-2,0,-3,-2,1,-1,2,5,-2,-2,0,-1,-1,-1,1,-1,-1},
            {-2,-3,1,0,-3,0,1,-3,0,-3,-2,6,-2,0,0,1,0,-3,-4,-2},
            {-1,-3,-1,-1,-4,-2,-2,-3,-1,-3,-2,-2,7,-1,-2,-1,-1,-2,-4,-3},
            {-1,-3,0,2,-3,-2,0,-3,1,-2,0,0,-1,5,1,0,-1,-2,-2,-1},
            {-1,-3,-2,0,-3,-2,0,-3,2,-2,-1,0,-2,1,5,-1,-1,-3,-3,-2},
            {1,-1,0,0,-2,0,-1,-2,0,-2,-1,1,-1,0,-1,4,1,-2,-3,-2},
            {0,-1,-1,-1,-2,-2,-2,-1,-1,-1,-1,0,-1,-1,-1,1,5,0,-2,-2},
            {0,-1,-3,-2,-1,-3,-3,3,-2,1,1,-3,-2,-2,-3,-2,0,4,-3,-1},
            {-3,-2,-4,-3,1,-2,-2,-3,-3,-2,-1,-4,-4,-2,-3,-3,-2,-3,11,2},
            {-2,-2,-3,-2,3,-3,2,-1,-2,-1,-1,-2,-3,-1,-2,-2,-2,-1,2,7}
    };
    private Map<Character,Integer> gmMap = new HashMap();
    private List<String> data;
    private Datalink[][] mapNumber;

    private void MapInit() {
        gmMap.put('A', 0);
        gmMap.put('C', 1);
        gmMap.put('D', 2);
        gmMap.put('E', 3);
        gmMap.put('F', 4);
        gmMap.put('G', 5);
        gmMap.put('H', 6);
        gmMap.put('I', 7);
        gmMap.put('K', 8);
        gmMap.put('L', 9);
        gmMap.put('M', 10);
        gmMap.put('N', 11);
        gmMap.put('P', 12);
        gmMap.put('Q', 13);
        gmMap.put('R', 14);
        gmMap.put('S', 15);
        gmMap.put('T', 16);
        gmMap.put('V', 17);
        gmMap.put('W', 18);
        gmMap.put('Y', 19);
    }

    public mapCount(List<String> data) {
        this.data = data;
        MapInit();
        mapNumber = new Datalink[data.get(0).length()+1][data.get(1).length()+1];
        mapNumberInit();
    }
    private void mapNumberInit(){
        String line = "";
        for(int i=0;i<mapNumber.length;i++){
            if(i==0){
                mapNumber[i][0] = new Datalink(0);
            }else {
                String oneLine = mapNumber[i-1][0].getLineOne() + data.get(0).charAt(i-1);
                mapNumber[i][0] = new Datalink(mapNumber[i-1][0].getNumber()-5,oneLine,line);
            }
            line +="-";
        }
        line = "";
        for(int j=0;j<mapNumber[0].length;j++){
            if(j==0){
                mapNumber[0][j] = new Datalink(0);
            }else {
                String twoLine = mapNumber[0][j-1].getLinrTwo() + data.get(1).charAt(j-1);
                mapNumber[0][j] = new Datalink(mapNumber[0][j-1].getNumber()-5,line,twoLine);
            }
            line +="-";
        }
    }

    public void countData(){
        int xlength = mapNumber.length;
        int ylength = mapNumber[0].length;
        for(int i=0;i<xlength;i++){
            for (int j=0;j<ylength;j++){
                if(mapNumber[i][j]==null){
                    int one = mapNumber[i-1][j-1].getNumber()+getTnumber(i,j);
                    int two = mapNumber[i-1][j].getNumber()-5;
                    int three = mapNumber[i][j-1].getNumber()-5;
                    int mainnum = 0;
                    String oneLine = null;
                    String twoLine = null;
                    if(one>=two && one>=three){
                         oneLine = mapNumber[i-1][j-1].getLineOne()+data.get(0).charAt(i-1);
                         twoLine = mapNumber[i-1][j-1].getLinrTwo()+data.get(1).charAt(j-1);
                        mainnum = one;
                    }else if(two>=one && two>=three){
                        twoLine = mapNumber[i-1][j].getLinrTwo()+"-";
                        oneLine = mapNumber[i-1][j].getLineOne()+data.get(0).charAt(i-1);
                        mainnum = two;
                    }else if(three>=one && three>=two){
                         oneLine = mapNumber[i][j-1].getLineOne()+"-";
                         twoLine = mapNumber[i][j-1].getLinrTwo()+data.get(1).charAt(j-1);
                        mainnum = three;
                    }
//                    System.out.println(oneLine);
//                    System.out.println(twoLine);
//                    System.out.println(mainnum);
                    mapNumber[i][j] = new Datalink(mainnum,oneLine,twoLine);
                }
            }
            if(i>2)
            for (int j=0;j<ylength;j++){
                mapNumber[i-1][j] = null;
            }
        }
        System.out.println(mapNumber[mapNumber.length-1][mapNumber[0].length-1].getNumber());
        System.out.println(mapNumber[mapNumber.length-1][mapNumber[0].length-1].getLineOne());
        System.out.println(mapNumber[mapNumber.length-1][mapNumber[0].length-1].getLinrTwo());
    }

    private int getTnumber(int i,int j){
        char xc = data.get(0).charAt(i-1);
        char yc = data.get(1).charAt(j-1);
        int x = gmMap.get(xc);
        int y = gmMap.get(yc);
        int d = table[x][y];
        return d;
    }
}
