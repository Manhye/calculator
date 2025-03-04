import front.GUI;
import front.GUIListener;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();

        gui.setGUIListener(new GUIListener() {
            @Override
            public void onInputReceived(String input) {
                String result = "hello";
                System.out.println(input);
                gui.getOutput(result);
            }
        });
    }
}