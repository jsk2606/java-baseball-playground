package study;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame_ver1 {

    final String BATTER = getBatter();

    public static void main(String[] args) {
        final String RE_TRY = "1";
        final String END_GAME = "2";

        BaseballGame_ver1 game = new BaseballGame_ver1();
        game.throwBall();

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        if(RE_TRY.equals(input)){
            game = new BaseballGame_ver1();
            game.throwBall();
        }
        if(END_GAME.equals(input)){
            //게임종료
        }else{
            System.out.println("that Not What I Want...");
        }
    }

    public void throwBall(){
        System.out.print("숫자를 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if(!this.inputValueVerification(input)){
            // 똑바로 입력하세요.
            this.throwBall();
        }
        if(BATTER.equals(input)){
            // 정답쓰
            return;
        }

        System.out.println(this.judgmentResult(input));
        this.throwBall();
    }

    public String judgmentResult(String input) {
        StringBuilder sb = new StringBuilder();
        int ball = 0;
        int strike = 0;
        for(int i=0; i<BATTER.length(); i++){
            if(BATTER.charAt(i) == input.charAt(i)){
                strike++;
            }else if(BATTER.indexOf(input.charAt(i)) != -1){
                ball++;
            }
        }

        if(ball > 0){
            sb.append(ball);
            sb.append("볼");
        }
        if(strike > 0){
            sb.append(strike);
            sb.append("스트라이크");
        }
        if(ball == 0 && strike == 0){
            sb.append("낫싱");
        }

        return sb.toString();
    }

    public String getBatter(){
        final int RESULT_MAXIMUM = 987;
        final int RESULT_MINIMUM = 12;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        int randomNumber = random.nextInt((RESULT_MAXIMUM - RESULT_MINIMUM) + 1) + RESULT_MINIMUM;
        if(randomNumber < 100){
            sb.append(0);
        }
        sb.append(randomNumber);
        if(isThreeDigitDuplication(sb.toString())){
            this.getBatter();
        }

        return sb.toString();
    }

    public boolean inputValueVerification(String successfulInput) {
        final int LIMITED_SIZE = 3;
        if(successfulInput == null){
            return false;
        }
        if(successfulInput.length() != LIMITED_SIZE){
            return false;
        }
        try {
            Integer.parseInt(successfulInput);
        }catch (NumberFormatException e){
            return false;
        }
        return !isThreeDigitDuplication(successfulInput);
    }

    public boolean isThreeDigitDuplication(String threeDigit){
        Set<Character> set = new HashSet<>();
        set.add(threeDigit.charAt(0));
        set.add(threeDigit.charAt(1));
        set.add(threeDigit.charAt(2));
        return set.size() != 3;
    }

}
