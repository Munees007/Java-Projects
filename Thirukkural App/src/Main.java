import UI.Thirukkural_App;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) throws  Exception {
        SwingUtilities.invokeLater(() -> {
            try {
                new Thirukkural_App();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
