package bridge;

import bridge.bridgeMaker.BridgeMaker;
import bridge.bridgeMaker.BridgeNumberGenerator;
import bridge.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.input.InputView;

import java.util.List;

public class GameStart {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private int bridgeSize;
    private List<String> bridge;
    private int countOfPlay;

    public GameStart() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        countOfPlay = 0;
    }

    public void run() {
        createBridge();
        boolean isSuccess = play();
        outputView.printResult();
    }

    private void createBridge() {
        outputView.printInputSizeMessage();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private String move() {
        outputView.printInputMoveMessage();
        String moveBlock = inputView.readMoving();
        return moveBlock;
    }

    private boolean play() {
        boolean isSuccess = false;
        boolean isRestart = true;
        do {
            countOfPlay++;
            for (int i = 0; i < bridgeSize; i++) {
                String moveBlock = move();
                boolean isMove = bridgeGame.move(moveBlock);
                outputView.printMap(bridge, i, isMove);
                if (!isMove) {
                    isRestart = readRestart();
                    break;
                }
            }
            if (!isRestart) {
                isSuccess = true;
            }
        } while (!isSuccess && isRestart);
        return isSuccess;
    }

    private boolean readRestart() {
        String restart = inputView.readGameCommand();
        outputView.printRestartMessage();
        boolean isSuccess = bridgeGame.retry(restart);
        return isSuccess;
    }
}
