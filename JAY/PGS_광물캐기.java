package JAY;

import java.util.*;

class PGS_광물캐기 {
    int min = Integer.MAX_VALUE;
    int[][] tired = {{1,1,1},{5,1,1},{25,5,1}};
    public int solution(int[] picks, String[] minerals) {
       // int answer = 0;
        
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
      
        if (dia > 0)
            dfs(0, 0, 0, minerals, dia-1, iron, stone);
        if (iron > 0)
            dfs(0, 1, 0, minerals, dia, iron-1, stone);
        if (stone > 0)
            dfs(0, 2, 0, minerals, dia, iron, stone-1);
    
        
        return min;
    }
    
    public void dfs(int fatigue, int toolIdx, int index, String[] minerals, int dia, int iron, int stone){
        if ( index >= minerals.length ) {
            min = Math.min(min, fatigue);
            return;
        }
        
        if (minerals[index].equals("diamond")) {
            fatigue+=tired[toolIdx][0];
        } else if (minerals[index].equals("iron")) {
            fatigue+=tired[toolIdx][1];
        } else if (minerals[index].equals("stone")) {
            fatigue+=tired[toolIdx][2];
        }
        
        
        if ((index + 1) % 5 == 0) {
            if ((dia == 0 && iron == 0 && stone == 0) ) {
                min = Math.min(min, fatigue);
                return;
            }
            
            if (dia > 0) {
                dfs (fatigue, 0, index+1, minerals, dia-1, iron, stone);
            }
            
            if (iron > 0) {
                dfs(fatigue, 1, index+1, minerals, dia, iron-1, stone);
            }
            
            if (stone > 0) {
                dfs(fatigue, 2, index+1, minerals, dia, iron, stone-1);
            }
        } else {
            dfs(fatigue, toolIdx, index+1, minerals, dia, iron, stone);
        }
        
    }
}
