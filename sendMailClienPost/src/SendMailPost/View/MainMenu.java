package SendMailPost.View;

import javax.swing.*;

public class MainMenu extends JMenuBar {
    private JMenu menu, newMenu;
    private JMenuItem itemMenu;
    public void createMenu(){
        menu = new JMenu("File");
        newMenu = new JMenu("New File");
        newMenu.add(new JMenuItem("add"));
        menu.add(newMenu);
        itemMenu = new JMenuItem("Close");
        menu.add(itemMenu);
        menu.add(new JMenuItem("Open"));
        menu.add(new JMenuItem("Close All"));
        add(menu);
    }

}
