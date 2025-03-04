import back.Allocator;
import front.GUI;
import front.GUIListener;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Allocator allocator = new Allocator();


        gui.setGUIListener(new GUIListener() {
            @Override
            public void onInputReceived(String input) {
                String returnVal = allocator.init(input);
                gui.getOutput(returnVal);
            }
        });
    }
}