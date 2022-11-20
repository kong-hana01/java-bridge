package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int countOfMove, boolean isMove) {
        String message = "";
        String mark = " ";
        for (int i = 0; i < countOfMove; i++) {
            mark = " ";
            if (bridge.get(i) == "U") {
                mark = "O";
            }
            message += " " + mark + " |";
        }
        mark = " ";
        if (bridge.get(countOfMove) == "U" && isMove){
            mark = "O";
        }
        if (bridge.get(countOfMove) == "U" && !isMove) {
            mark = "X";
        }
        message += " " + mark + " ";
        System.out.println("[" + message + "]");

        message = "";
        for (int i = 0; i < countOfMove; i++) {
            mark = " ";
            if (bridge.get(i) == "D") {
                mark = "O";
            }
            message += " " + mark + " |";
        }
        mark = " ";
        if (bridge.get(countOfMove) == "D" && isMove){
            mark = "O";
        }
        if (bridge.get(countOfMove) == "D" && !isMove) {
            mark = "X";
        }
        message += " " + mark + " ";
        System.out.println("[" + message + "]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int countOfMove, boolean isSuccess, int countOfPlay) {
        System.out.println("최종 게임 결과");
        printMap(bridge, countOfMove, isSuccess);
        String successMessage = "성공";
        if (!isSuccess) {
            successMessage = "실패";
        }
        System.out.println("\n게임 성공 여부: " + successMessage);
        System.out.println("총 시도한 횟수: " + countOfPlay);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printInputMoveMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestartMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
