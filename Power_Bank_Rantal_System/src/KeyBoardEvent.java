
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardEvent extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() < '0' || keyEvent.getKeyChar() > '9') {
            keyEvent.consume();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {

            System.out.println("1");
        }
    }
}
