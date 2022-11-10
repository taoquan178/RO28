package entity.exercise3;

public class Car {
    private String name;
    private String type;
    public Car(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    public class Engine {
        private String engineType;
        public Engine(String engineType) {
            super();
            this.engineType = engineType;
        }
        @Override
        public String toString() {
            return "Engine [engineType=" + engineType + "]";
        }
        /**
         * @return engineType
         */
        public String getEngineType() {
            return engineType;
        }
        /**
         * @param engineType the engineType to set
         */
        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }
    }
    @Override
    public String toString() {
        return "Car [name=" + name + ", type=" + type + "]";
    }
}
