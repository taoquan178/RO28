package entity.exercise3;

public class CPU {
    private Float price;

    private Processor processor;

    private Ram ram;

    public CPU() {
    }

    public CPU(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public class Processor{
        private Float coreAmount;
        private String menufacturer;

        public Processor() {
        }

        public Processor(Float coreAmount, String menufacturer) {
            this.coreAmount = coreAmount;
            this.menufacturer = menufacturer;
        }

        public Float getCoreAmount() {
            return coreAmount;
        }

        public void setCoreAmount(Float coreAmount) {
            this.coreAmount = coreAmount;
        }

        public String getMenufacturer() {
            return menufacturer;
        }

        public void setMenufacturer(String menufacturer) {
            this.menufacturer = menufacturer;
        }

        public Float getCache(){
            return 4.3f;
        }
    }

    public class Ram{
        private String memory;
        private String menufacturer;

        public Ram() {
        }

        public Ram(String memory, String menufacturer) {
            this.memory = memory;
            this.menufacturer = menufacturer;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        public String getMenufacturer() {
            return menufacturer;
        }

        public void setMenufacturer(String menufacturer) {
            this.menufacturer = menufacturer;
        }

        public Float getClockSpeed(){
            return 5.5f;
        }
    }



    @Override
    public String toString() {
        return "CPU{" +
                "price=" + price +
                ", processor=" + processor +
                ", ram=" + ram +
                '}';
    }
}
