public class BuilderPattern {

    static class Computer {

        private String CPU;
        private int RAM;
        private int Storage;
        private String GraphicsCard;
        private boolean Bluetooth;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GraphicsCard = builder.GraphicsCard;
            this.Bluetooth = builder.Bluetooth;
        }

        public void display() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM + " GB");
            System.out.println("Storage: " + Storage + " GB");
            System.out.println("Graphics Card: " + GraphicsCard);
            System.out.println("Bluetooth: " + Bluetooth);
            System.out.println();
        }

        static class Builder {

            private String CPU;
            private int RAM;
            private int Storage;
            private String GraphicsCard;
            private boolean Bluetooth;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(int RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(int Storage) {
                this.Storage = Storage;
                return this;
            }

            public Builder setGraphicsCard(String GraphicsCard) {
                this.GraphicsCard = GraphicsCard;
                return this;
            }

            public Builder setBluetooth(boolean Bluetooth) {
                this.Bluetooth = Bluetooth;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setBluetooth(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(16)
                .setStorage(512)
                .setGraphicsCard("Integrated Graphics")
                .setBluetooth(false)
                .build();

        gamingPC.display();
        officePC.display();
    }
}
