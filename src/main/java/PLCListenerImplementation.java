import si.trina.moka7.live.PLCListener;

public class PLCListenerImplementation implements PLCListener {
    public void PLCBitChanged(int address, int pos, boolean val, String plcName) {
        switch (address) {
            case 0:
                switch (pos) {
                    case 1:
                        System.out.println("Bit at address 0.1 of PLC " + plcName + " changed to: " + val);
                }
        }
    }
}
