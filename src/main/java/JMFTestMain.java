import javax.media.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Leo on 2016/12/3.
 */
public class JMFTestMain extends JFrame {
    public static Player player=null;
    public CaptureDeviceInfo info=null;
    private MediaLocator mediaLocator=null;

    public JMFTestMain()  {
        init();
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        String str1 = "vfw:Logitech USB Video Camera:0";
        String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";
        info   =   CaptureDeviceManager.getDevice(str2);
        System.out.println(info);
        System.out.println(info.getName());
        mediaLocator=info.getLocator();
        try{
            player= Manager.createPlayer(mediaLocator);
            player.start();
            Component   comp;
            if   ((comp   =   player.getVisualComponent())   !=   null) {
                //如果摄像头视频组件不如空，加到窗体中
                this.getContentPane().add(comp, BorderLayout.NORTH);
            }
        } catch (NoPlayerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new JMFTestMain();
    }
}
