/*
이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

[제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
*/

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int startLeft = 0;
        int startRight = 0;
        int left = 10;
        int right = 12;
        
        for(int i=0; i<numbers.length; i++){
            
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer.append("L");
                left = numbers[i];
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer.append("R");
                right = numbers[i];
            }else{
                if(numbers[i]==0) numbers[i] = 11;
                
                /*공식 찾아서 풀었음 ㅠ..*/
                startLeft = (Math.abs(numbers[i] - left)/3) + (Math.abs(numbers[i] - left)%3);  
                startRight = (Math.abs(numbers[i] - right)/3) + (Math.abs(numbers[i] - right)%3); 
                
                if(startLeft > startRight){
                    answer.append("R");
                    right = numbers[i];
                }else if(startLeft < startRight){
                    answer.append("L");
                    left = numbers[i];
                }else if(startLeft == startRight){
                    if(hand.equals("right")){
                        answer.append("R");
                        right = numbers[i];
                    }else{
                        answer.append("L");
                        left = numbers[i];
                    }
                }
            }
        }     
        
        return answer.toString();
    }
}
