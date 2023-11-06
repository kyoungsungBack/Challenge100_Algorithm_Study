package JAY;

import java.util.*;

class PGS_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        ArrayList<String> list= new ArrayLisat<>();
        
        list.add(words[0]);
        int i;
        for(i=1;i<words.length;i++){
            char last=words[i-1].charAt(words[i-1].length()-1);
            char now=words[i].charAt(0);
            
            if(list.contains(words[i])||last!=now){
                 answer[0]=i%n+1;
                answer[1]=i/n+1;  
                break;
            }
              
            list.add(words[i]);
            
        }
        
        return answer;
    }
}
