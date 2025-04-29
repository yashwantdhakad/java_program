package example.corejava.designpatterns;

// Target interface
interface Charger {
    void charge();
}

// Adapter with a different interface
class MicroUSBCharger {
    void connectMicroUSB() {
        System.out.println("Charging using Micro-USB.");
    }
}

// Adapter to bridge the gap
class USBAdapter implements Charger {
    private MicroUSBCharger microUSBCharger;

    public USBAdapter(MicroUSBCharger microUSBCharger) {
        this.microUSBCharger = microUSBCharger;
    }

    @Override
    public void charge() {
        microUSBCharger.connectMicroUSB();
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        MicroUSBCharger microUSBCharger = new MicroUSBCharger();
        Charger charger = new USBAdapter(microUSBCharger);
        charger.charge();
    }
}

