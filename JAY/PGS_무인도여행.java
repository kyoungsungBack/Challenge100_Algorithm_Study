package JAY;

import java.util.*;

public class PGS_무인도여행 {
    public static boolean[][] visited;
    public static List<Integer> list = new ArrayList<>();
    public static char[][] map;
    public static int count=0;

    public int[] solution(String[] maps) {
        int[] answer ={-1};
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        //maps를 한 단어씩 잘라서 2차원배열에 복사
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                dfs(map,i, j);
                if(count>0) {
                    list.add(count);
                    count=0;
                }
            }
        }

        Collections.sort(list);

        if(list.size()!=0){
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    public static void dfs(char[][] map, int i ,int j){

        //i,j 값이 0보다 작거나 map배열의 길이보다 크거나 같을때 실행 X
        if(i<0 || j<0 || i>=map.length || j>=map[0].length) {
            return;
        }
        //map에 들어있는 값이 숫자가 아닌 'X'거나 visited 배열이 true(이미 방문)일때 실행 X
        if(map[i][j]=='X'||visited[i][j]){
            return;
        }
        else{
            visited[i][j]=true; //방문처리
            count+=Integer.parseInt(String.valueOf(map[i][j]));
        }

        //상하좌우 탐색
        dfs(map,i+1,j); //오른쪽
        dfs(map,i-1,j); //왼쪽
        dfs(map,i,j+1); //위
        dfs(map,i,j-1); //아래
    }
}