import com.sourceforge.snap7.moka7.S7;
import si.trina.moka7.live.PLC;

import java.util.Timer;

public class S7Connection {
    public static void main(String[] args) throws Exception {
        System.out.println("test");

        //PLC plc1 = new PLC("test plc", "192.168.0.107", new byte[1], new byte[1],
        //2000, 2000, new double[]{0.0, 0.1});
        PLC plc1 = new PLC("plc22", "192.168.0.107", 8, 2,
                2000, 5000, new double[]{0.0, 0.1}, 0, 2, S7.S7AreaDB, S7.S7AreaDB);

        PLCListenerImplementation plcListenerImplementation = new PLCListenerImplementation();

        plc1.listeners.add(plcListenerImplementation);


        new Thread(plc1).start();


//        plc1.liveBitEnabled = true;
//        plc1.liveBitAddress = 0;
//        plc1.liveBitPosition = 0;
//        plc1.liveBitPCDuration = 250;
//        plc1.liveBitPLCDuration = 500;


        while (true) {
            plc1.putBool(false, 0, 2, true);
            try {

                boolean g = plc1.getBool(true, 0, 0);
                boolean j = plc1.getBool(true, 0, 7);
                int gf = plc1.getInt(true, 2);
                int fg = plc1.getDInt(true, 4);
//                String hjs = Integer.toString(fg, 2);
//                System.out.println(hjs);
//                int bits = Integer.parseInt(hjs, 2);
//                float value = Float.intBitsToFloat(bits);
//                System.out.println(value + " -> " + hjs);
                float hj = IEEEConvert.IntConvertIEEE(fg);
                System.out.println("test " + g + " " + j + " " + gf + "   dint  " + fg + "  " + hj);
                Thread.sleep(2000);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        Gabr dG = new KlopG(new Klop());
//
//        dG.read();

    }


}

class IEEEConvert {


    public static float IntConvertIEEE(int value) {
        String valueString = Integer.toString(value, 2);
        int bits = Integer.parseInt(valueString, 2);
        float convertValueIEEE = Float.intBitsToFloat(bits);
        return convertValueIEEE;
    }
}

//interface Gabr {
//    void read();
//}
//
//class Klop implements Gabr {
//    public void read() {
//        System.out.println("Klop read");
//    }
//}
//
//abstract class GrabDekorator implements Gabr {
//    Gabr gabr;
//
//    public GrabDekorator(Gabr gabr) {
//        this.gabr = gabr;
//    }
//
//    public abstract void read();
//}
//
//class KlopG extends GrabDekorator {
//
//
//    public KlopG(Gabr gabr) {
//        super(gabr);
//    }
//
//    @Override
//    public void read() {
//        System.out.println("KlopG read" + "  ");
//        gabr.read();
//    }
//}
