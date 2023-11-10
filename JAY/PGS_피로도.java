package JAY;

public class PGS_피로도 {
    public int answer;
    public boolean[] visited; //방문 여부 확인 배열

    public int solution(int k, int[][] dungeons) {

        visited= new boolean[dungeons.length];

        dfs(0,k,dungeons);

        return answer;
    }

    public void dfs(int cnt, int k, int[][] dungeons){
        //cnt = 탐험한 던전 수
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]==false && k>=dungeons[i][0]){ //해당 던전을 방문한 적 없고, 던전의 최소 피로도가 k 이하일때
                visited[i]=true; //방문처리
                dfs(cnt+1,k-dungeons[i][1],dungeons); //k-dungeons[i][1] : 현재 잔여피로도
                visited[i]=false; //방문초기화
            }
        }

        answer = Math.max(answer, cnt);
    }
}
