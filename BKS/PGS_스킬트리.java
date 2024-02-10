package BKS;

import java.util.ArrayList;

public class PGS_스킬트리 {
    // 20240210 16:00 ~ 16:55
    public static void main(String[] args) {
        int answer = 0;
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        ArrayList<Character> skillList = new ArrayList<>();
        boolean isSkill = true;
        // 1. skill에 대해 하나씩 저장
        for (int i = 0 ; i < skill.length() ; i++) {
            skillList.add(skill.charAt(i));
        }

        // 2. 현재 skill_trees의 스킬순서를 확인하며 선행스킬 순서와 비교한다.
        //    스킬트리와 상관없는 것들만 찍었을 때도 answer++ 해야 한다.
        for (int i = 0 ; i < skill_trees.length ; i++) {
            int idx = 0; // 현재 배우고 있는 스킬의 순서
            isSkill = true;

            for (int j = 0 ; j < skill_trees[i].length() ; j++) {
                char curSkill = skill_trees[i].charAt(j);

                // 3.1. 선행 스킬을 안배웠으면 못배우는 스킬트리이므로 반복문 탈출한다.
                if (skillList.indexOf(curSkill) > idx) {
                    isSkill = false;
                    break;
                } // 3.2. 선행 스킬을 배웠으면 다음스킬로 idx 증가시킨다.
                else if (skillList.indexOf(curSkill) == idx) {
                    idx++;
                } // 3.3. 스킬순서와 상관없으면 배울 수 있다.
                else {
                    continue;
                }

            }

            if (isSkill) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
