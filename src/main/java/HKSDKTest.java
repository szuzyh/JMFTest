/**
 * Created by Leo on 2016/12/3.
 */
public class HKSDKTest {
    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    public static void main(String args[]){
        boolean initSuc = hCNetSDK.NET_DVR_Init();
    }
}
